# Preventing Forgery Attacks in Java Serialization

Serialization forgery attacks occur when malicious actors craft fake serialized objects to compromise your system. Here's how these attacks work and how to prevent them:

## Common Serialization Forgery Attacks

### 1. Class Injection Attacks
- Attackers inject malicious class definitions into the object stream
- Bypasses standard constructor logic
- Example: Crafting a `HashMap` with pathological collision cases to cause DoS

### 2. Signature Bypass
- Forging serialized objects that appear to be legitimate
- Example: Creating fake authentication tokens or session objects

### 3. Reference Manipulation
- Exploiting object graph references to create inconsistent states
- Example: Circular references that cause infinite processing

## Prevention Techniques

### 1. Use Serialization Filters (JDK 9+)
```java
// Set global filter
ObjectInputFilter.Config.setSerialFilter(
    info -> info.depth() > 10 ? Status.REJECTED : 
           info.references() > 1000 ? Status.REJECTED :
           info.streamBytes() > 1_000_000 ? Status.REJECTED :
           Status.UNDECIDED
);

// Per-stream filter
ObjectInputStream ois = new ObjectInputStream(input);
ois.setObjectInputFilter(myFilter);
```

### 2. Implement readObject() Defensively
```java
private void readObject(ObjectInputStream in) 
    throws IOException, ClassNotFoundException {
    // First perform default deserialization
    in.defaultReadObject();
    
    // Then validate critical fields
    if (this.sensitiveField == null || this.sensitiveField.isEmpty()) {
        throw new InvalidObjectException("Invalid sensitive field");
    }
    
    // Verify invariants
    if (this.value < 0) {
        throw new InvalidObjectException("Negative value not allowed");
    }
}
```

### 3. Use Serial Proxy Pattern
```java
private static class SerializationProxy implements Serializable {
    private final String data;
    
    SerializationProxy(OriginalClass orig) {
        this.data = orig.getData();
    }
    
    private Object readResolve() {
        return new OriginalClass(data); // Uses safe constructor
    }
}

private Object writeReplace() {
    return new SerializationProxy(this);
}
```

### 4. Cryptographic Protection
```java
// Sign serialized data
public byte[] serializeWithSignature(MyObject obj, PrivateKey key) 
    throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
        oos.writeObject(obj);
    }
    
    Signature sig = Signature.getInstance("SHA256withRSA");
    sig.initSign(key);
    sig.update(baos.toByteArray());
    
    ByteArrayOutputStream signed = new ByteArrayOutputStream();
    signed.write(sig.sign());
    signed.write(baos.toByteArray());
    return signed.toByteArray();
}
```

### 5. Avoid Serialization Entirely (Best Option)
- Use JSON/XML with schema validation
- Implement proper database persistence
- Use Protocol Buffers or similar binary formats

## Additional Security Measures

1. **Class Whitelisting**:
   ```java
   // In your serialization filter
   if (!info.serialClass().getName().startsWith("com.yourpackage.")) {
       return Status.REJECTED;
   }
   ```

2. **Input Validation**:
   ```java
   public static MyObject deserialize(byte[] data) 
       throws IOException, ClassNotFoundException {
       try (ObjectInputStream ois = new SecureObjectInputStream(data)) {
           Object obj = ois.readObject();
           if (!(obj instanceof MyObject)) {
               throw new InvalidObjectException("Unexpected type");
           }
           return (MyObject) obj;
       }
   }
   ```

3. **SecureObjectInputStream** Implementation:
   ```java
   public class SecureObjectInputStream extends ObjectInputStream {
       public SecureObjectInputStream(byte[] data) throws IOException {
           super(new ByteArrayInputStream(data));
       }
       
       @Override
       protected Class<?> resolveClass(ObjectStreamClass desc)
           throws IOException, ClassNotFoundException {
           if (desc.getName().startsWith("java.") || 
               desc.getName().startsWith("javax.")) {
               throw new InvalidClassException("Unauthorized class", desc.getName());
           }
           return super.resolveClass(desc);
       }
   }
   ```

Remember: The most secure approach is to **avoid Java serialization completely** and use safer alternatives. If you must use serialization, implement multiple layers of defense including strict validation, cryptographic signatures, and runtime monitoring.


Great question — **forgery attacks** during serialization/deserialization are real and dangerous, especially in distributed systems or when handling **untrusted data**.

Let’s break it down step by step:

---

## 🎭 What is a Forgery Attack in Serialization?

A **forgery attack** happens when an attacker **manipulates or crafts serialized data** to:

- **Trick the system into deserializing fake objects**
- **Bypass security checks**
- **Inject malicious payloads**
- **Spoof identities or manipulate behavior**

### Example:
An attacker sends a serialized object that *pretends* to be an admin user:

```java
// Forged serialized byte stream of an AdminUser object with isAdmin = true
```

If your app trusts this stream and deserializes it blindly → 🧨 **security breach**.

---

## 🚨 Real Dangers of Forgery in Serialization

1. **Privilege Escalation** – pretend to be another user
2. **Arbitrary Code Execution** – via gadget chains
3. **Tampering with Object State** – set hidden/private fields
4. **Bypassing Business Logic** – by crafting objects in invalid states

---

## 🔐 How to Avoid Forgery Attacks

---

### ✅ 1. **NEVER trust serialized data from untrusted sources**

Treat any serialized input like user input: **validate, verify, sanitize**.

---

### ✅ 2. **Use Serialization Filters (Java 9+)**

Apply `ObjectInputFilter` to restrict what classes can be deserialized.

#### Example:
```java
ObjectInputStream ois = new ObjectInputStream(inputStream);
ois.setObjectInputFilter(info -> {
    if (info.serialClass().getName().startsWith("com.myapp.")) {
        return ObjectInputFilter.Status.ALLOWED;
    }
    return ObjectInputFilter.Status.REJECTED;
});
```

Or globally:

```bash
-Djdk.serialFilter=java.base/*;com.myapp.model.*;maxdepth=10;maxbytes=100000
```

---

### ✅ 3. **Use Digital Signatures for Serialized Data**

Before deserializing, verify the **integrity and authenticity** of the data.

#### Example Approach:
- Serialize object
- Sign the serialized bytes with a private key
- Send the data and signature
- Receiver verifies the signature before deserialization

---

### ✅ 4. **Use Safe Alternatives (Preferable)**

Replace Java serialization with:

| Safer Method        | Tool                   |
|---------------------|------------------------|
| JSON serialization  | Jackson, Gson          |
| Protocol Buffers    | Google Protobuf        |
| Object persistence  | JPA, Hibernate, JDBC   |
| Messaging           | Kafka, RabbitMQ        |

---

### ✅ 5. **Implement Whitelisting / Class Checks**

Manually check the deserialized class before using the object.

```java
if (!(obj instanceof MyExpectedType)) {
    throw new SecurityException("Unexpected object type");
}
```

---

### ✅ 6. **Avoid Deserializing Arbitrary Objects**

If possible, design your protocol or API to avoid needing general object deserialization. Stick to structured data formats (e.g. JSON, XML, Protobuf).

---

## 🔒 Final Tips

| Tip | Why |
|-----|-----|
| Avoid Java Serialization in APIs | Too easy to forge |
| Validate expected object types | Prevent spoofing |
| Sign serialized data | Detect tampering |
| Use JSON with schema validation | Safer and transparent |

---

## 💬 TL;DR

**Forgery attacks** in serialization happen when attackers send crafted object data to trick your app. You can avoid them by:

✅ Never trusting serialized data  
✅ Using filters and type validation  
✅ Signing data  
✅ Moving to JSON, Protobuf, or DB storage  

---

Want a code template to securely replace Java serialization with JSON + signature validation?

Forgery attacks in serialization exploit the process of deserializing data to inject or manipulate objects in a way that leads to unauthorized actions or information disclosure. These attacks often rely on crafting malicious serialized payloads. Here's a breakdown of common forgery attack scenarios in serialization and how to avoid them:

**Types of Forgery Attacks in Serialization:**

1.  **Object Substitution:** An attacker crafts a serialized stream containing an object of a different, potentially malicious class than what the application expects. During deserialization, the application unknowingly instantiates and operates on this forged object, leading to unexpected behavior or security breaches. For example, substituting a harmless user object with a malicious object that triggers code execution upon a specific method call.

2.  **Data Tampering:** An attacker intercepts and modifies a serialized stream in transit before it's deserialized. They might alter the state of objects within the stream to escalate privileges, change data values, or inject malicious data. For instance, changing the `isAdmin` flag of a user object from `false` to `true`.

3.  **Replay Attacks:** An attacker captures a valid serialized stream and resends it later to perform an action again, potentially without proper authorization or in an unintended context. This is especially problematic if the action performed during deserialization has side effects or if the validity of the action should be time-sensitive.

4.  **Gadget Chain Exploits (Indirect Forgery):** While often categorized as deserialization vulnerabilities leading to remote code execution, they can also be seen as a form of forgery. Attackers forge a specific sequence of serialized objects (a "gadget chain") that, when deserialized, trigger a series of method calls leading to arbitrary code execution. The forged part is the carefully constructed chain that misuses existing application or library code.

**How to Avoid Forgery Attacks in Serialization:**

A multi-layered approach is necessary to effectively prevent forgery attacks:

1.  **Avoid Deserializing Untrusted Data:**
    * **The Golden Rule:** The most effective way to prevent serialization-related forgery is to **avoid deserializing data from untrusted or unauthenticated sources entirely.** If you don't deserialize external data, you eliminate the primary attack vector.
    * **Consider Alternatives:** For inter-service communication or data persistence, prefer safer alternatives like JSON, Protocol Buffers, or databases with proper access controls. These formats don't inherently carry the same arbitrary code execution risks as Java serialization.

2.  **Implement Strong Authentication and Integrity Checks:**
    * **Authenticate the Source:** Before deserializing any data, rigorously verify the identity of the sender. Use strong authentication mechanisms (e.g., mutual TLS, API keys with proper rotation).
    * **Ensure Data Integrity:** Implement mechanisms to ensure the integrity of the serialized data during transit. Use cryptographic techniques like:
        * **HMAC (Hash-based Message Authentication Code):** Generate a keyed hash of the serialized data before sending it. The receiver can then verify the integrity by recalculating the HMAC using the same key. Any tampering will result in a different HMAC.
        * **Digital Signatures:** Use digital signatures to verify both the authenticity and integrity of the serialized data.

3.  **Utilize the `jdk.serialFilter` (Java 9+):**
    * As discussed previously, configure the `jdk.serialFilter` to **whitelist only the classes you expect and trust** to be deserialized. This significantly reduces the attack surface by preventing the instantiation of unexpected or malicious classes.
    * Carefully define the filter rules based on your application's specific needs. Be as restrictive as possible.

4.  **Minimize the Use of Serialization:**
    * If possible, reduce the places in your application where Java serialization is used. Explore alternative data transfer and persistence mechanisms.

5.  **Secure Custom `readObject()` and `writeObject()` Methods:**
    * If your serializable classes implement custom `readObject()` or `writeObject()` methods, ensure they are carefully written and don't introduce vulnerabilities. Avoid performing any actions in these methods that could be exploited if the object's state is manipulated.
    * Be cautious about performing lookups, accessing external resources, or making state changes within these methods without proper validation.

6.  **Keep Dependencies Updated:**
    * Regularly update all your Java runtime environment and third-party libraries. Security vulnerabilities, including those related to deserialization gadgets, are often discovered and patched in these updates.

7.  **Implement Robust Input Validation (Even After Deserialization):**
    * Even if you've taken steps to secure the deserialization process, always validate the state of the deserialized objects before using them. Don't assume that the deserialized data is valid or hasn't been tampered with.

8.  **Consider Using Signed Serialization (Custom Implementation):**
    * For critical data, you could implement a custom serialization/deserialization mechanism that includes signing the serialized data with a private key. The receiver can then verify the signature using the corresponding public key to ensure the data hasn't been tampered with. This requires more effort but provides a strong guarantee of integrity and authenticity.

9.  **Monitor and Log Deserialization Activities:**
    * Implement logging to track deserialization attempts, especially those that are blocked by the `jdk.serialFilter` or fail integrity checks. This can help detect and respond to potential attacks.

**Important Considerations:**

* **Defense in Depth:** No single technique is foolproof. Implement a combination of these strategies to create a robust defense against forgery attacks.
* **Regular Security Audits:** Conduct regular security audits of your application, paying close attention to areas where serialization is used.
* **Educate Developers:** Ensure your development team understands the risks associated with Java serialization and the best practices for mitigating them.

By diligently implementing these preventative measures, you can significantly reduce the risk of successful forgery attacks targeting your Java applications through serialization. Remember that avoiding deserialization of untrusted data is the most fundamental and effective defense.
