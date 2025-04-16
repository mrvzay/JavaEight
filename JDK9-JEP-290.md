# JDK 9 Serial Filter for Serialization Security

In JDK 9, Oracle introduced a serialization filtering mechanism to enhance the security of Java's serialization/deserialization process, which had been a source of many vulnerabilities.

## What is Serial Filtering?

Serial filtering provides a way to validate incoming serialized data streams before deserialization occurs. It helps prevent:

1. Deserialization of malicious objects
2. Resource exhaustion attacks (by limiting array sizes, graph depth, etc.)
3. Classes that might exploit known vulnerabilities

## Key Components

### 1. JVM-wide Filter

You can set a global filter using the `jdk.serialFilter` system property:

```bash
java -Djdk.serialFilter="maxdepth=10;maxarray=10000;!org.example.ExploitClass" MyApp
```

### 2. Programmatic Filter

You can set filters programmatically using `ObjectInputFilter`:

```java
ObjectInputFilter filter = ObjectInputFilter.Config.createFilter(
    "maxdepth=5;maxbytes=1000000;!org.example.*");
ObjectInputFilter.Config.setSerialFilter(filter);
```

## Filter Pattern Syntax

Filters use patterns with these elements:

- `maxdepth=<value>` - maximum graph depth
- `maxbytes=<value>` - maximum bytes in the stream
- `maxrefs=<value>` - maximum number of references
- `maxarray=<value>` - maximum array size allowed
- `!<pattern>` - reject classes matching pattern
- `<pattern>` - allow classes matching pattern

## Example Patterns

1. Basic security filter:
   ```
   maxdepth=10;maxarray=100000;maxbytes=500000;!org.example.*
   ```

2. Allow specific packages only:
   ```
   com.trusted.*;!*
   ```

3. Limit resource usage:
   ```
   maxdepth=20;maxrefs=1000;maxarray=50000
   ```

## Best Practices

1. Always use serial filters in security-sensitive applications
2. Start with restrictive filters and loosen as needed
3. Combine global filters with application-specific filters
4. Log filter rejections to monitor for attacks
5. Keep your filter patterns updated as new vulnerabilities are discovered

Serial filtering in JDK 9+ provides an important security layer against deserialization attacks that were common in earlier Java versions.

In **JDK 9**, a new feature was introduced to improve the **security of Java serialization**: **Serialization Filtering**.

### 🔐 What is Serialization Filtering?

Serialization filtering allows applications to **control what classes are allowed or disallowed** to be deserialized. This helps **prevent deserialization vulnerabilities**, which can lead to remote code execution or denial-of-service attacks.

---

### ✅ How It Works

Serialization filters check classes during **deserialization** to ensure they match defined criteria. If a class doesn't meet the filter's rules, the deserialization process throws an exception.

---

### 🧰 Types of Filters

- **Global Filter**: Set via system properties or `java.security` file.
- **Per-stream Filter**: Set on a specific `ObjectInputStream` using the `setObjectInputFilter` method.

---

### 📍 Global Filter Example

You can set a global serialization filter using a system property:

```bash
-Djdk.serialFilter=pattern
```

Or define it in the `java.security` file:

```properties
jdk.serialFilter=pattern
```

#### Example Pattern:

```properties
jdk.serialFilter=java.base/*;maxdepth=10;maxrefs=10000;maxbytes=500000
```

This pattern allows classes from the `java.base` module and sets limits on:
- `maxdepth` – object graph depth
- `maxrefs` – total object references
- `maxbytes` – stream size

---

### 🧪 Per-Stream Filter Example

You can set a filter for an individual stream:

```java
ObjectInputStream in = new ObjectInputStream(inputStream);
in.setObjectInputFilter(info -> {
    if (info.serialClass() != null && info.serialClass().getName().startsWith("com.myapp.")) {
        return ObjectInputFilter.Status.ALLOWED;
    }
    return ObjectInputFilter.Status.REJECTED;
});
```

---

### 🔒 Benefits

- Prevents deserialization of malicious or unexpected classes
- Fine-grained control over deserialization behavior
- Helps defend against common Java serialization attacks

---

If you want, I can help you write a secure serialization filter tailored to your application. Just let me know what kind of objects you're deserializing.

In JDK 9, the **Serial Filter** provides security to serialization by allowing you to **filter incoming streams of object-serialization data**. This mechanism helps to improve both the **security** and **robustness** of your Java applications by preventing the deserialization of potentially malicious or unexpected objects.

Here's a breakdown of how it provides security:

* **Class Filtering (Whitelist and Blacklist):** The core functionality of the serial filter is to control which classes are allowed or rejected during deserialization. You can configure filters based on:
    * **Whitelist:** Explicitly allow only a specific set of classes or packages to be deserialized. This is generally considered more secure as it blocks everything by default and only permits known safe classes.
    * **Blacklist:** Explicitly block a specific set of known problematic or vulnerable classes or packages from being deserialized. While easier to set up initially, it's less secure as new vulnerabilities might arise in unblocked classes.

* **Resource Control:** Beyond just class types, the serial filter can also enforce limits on the resource consumption during deserialization, such as:
    * **Maximum depth of the object graph:** Prevents deeply nested object structures that could lead to stack overflow errors or excessive processing.
    * **Maximum number of references:** Limits the number of distinct objects in the deserialized graph, preventing potential denial-of-service attacks.
    * **Maximum array size:** Restricts the size of arrays being deserialized, mitigating memory exhaustion risks.
    * **Maximum stream size:** Limits the total number of bytes that can be read from the input stream.

* **Defense against Deserialization Vulnerabilities:** By carefully configuring the serial filter, you can significantly reduce the attack surface of your application against various deserialization vulnerabilities. These vulnerabilities often exploit the ability to craft malicious serialized data that, upon deserialization, can lead to arbitrary code execution or other harmful actions.

**How to Configure the Serial Filter in JDK 9:**

You can configure the serial filter in several ways:

1.  **Using the `jdk.serialFilter` System Property:** This allows you to set a JVM-wide filter using a pattern-based syntax on the command line when starting your Java application. For example:
    ```
    java -Djdk.serialFilter="com.example.safe.*;java.util.*;!com.example.unsafe.*" MyApp
    ```
    This example allows classes in the `com.example.safe` and `java.util` packages but rejects any class in the `com.example.unsafe` package.

2.  **Using the `jdk.serialFilter` Security Property:** You can also define the filter in the `java.security` configuration file. This is similar to the system property but is configured within the JRE/JDK installation.

3.  **Programmatically using the `ObjectInputFilter` API:** JDK 9 introduced the `java.io.ObjectInputFilter` interface and related classes, allowing you to create and set filters on individual `ObjectInputStream` instances. This provides more fine-grained control over deserialization in specific parts of your application. You can create custom filters by implementing the `ObjectInputFilter` interface or by using the `ObjectInputFilter.Config.createFilter(String pattern)` method for pattern-based filters. You can then set the filter on an `ObjectInputStream` using the `setObjectInputFilter()` method.

**Example of programmatic filtering:**

```java
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;

public class DeserializationExample {
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new java.io.ByteArrayInputStream(data))) {
            ObjectInputFilter filter = ObjectInputFilter.Config.createFilter("com.example.safe.*;java.lang.*;!com.example.unsafe.*");
            ois.setObjectInputFilter(filter);
            return ois.readObject();
        }
    }

    public static void main(String[] args) {
        // ... your serialization and deserialization code ...
    }
}
```

**In summary, the JDK 9 Serial Filter is a crucial security feature that allows you to control the types of objects and the resources consumed during Java object deserialization. By implementing appropriate filters, you can significantly mitigate the risks associated with deserializing untrusted data and enhance the security and stability of your Java applications.**
