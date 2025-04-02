### **HashMap in Java**
A `HashMap` in Java is a part of the **Java Collections Framework** and is used to store key-value pairs. It is implemented using **hashing** and provides **constant-time performance (O(1))** for basic operations like `put()`, `get()`, and `remove()`, in the average case.

---
## **1. Characteristics of HashMap**
- Stores **key-value** pairs.
- **No duplicate keys** (each key must be unique).
- **Allows one `null` key** and multiple `null` values.
- **Not thread-safe** (Use `ConcurrentHashMap` for thread safety).
- **Does not maintain insertion order** (Use `LinkedHashMap` if needed).
- **Uses hashing** for fast retrieval.

---
## **2. How to Create a HashMap?**
```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Getting a value
        System.out.println(map.get(2)); // Output: Banana

        // Removing a key
        map.remove(3);

        // Checking if a key exists
        System.out.println(map.containsKey(1)); // Output: true

        // Iterating over HashMap
        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
```

---
## **3. Internal Working of HashMap**
### **a) Hashing Mechanism**
- Java uses the **hashCode()** of a key to determine where it should be stored in an array of **buckets**.
- The **index** is calculated as:
  ```java
  index = (hash & (n - 1))
  ```
- If multiple keys map to the same index (collision), Java stores them using a **linked list** (Java 7) or a **Red-Black Tree** (Java 8+).

### **b) Collision Handling**
- **Before Java 8:** Used a **Linked List**.
- **After Java 8:** Uses a **Red-Black Tree** if bucket size > 8 for better performance.

---
## **4. Important HashMap Methods**
| Method | Description |
|--------|------------|
| `put(K key, V value)` | Inserts a key-value pair. |
| `get(K key)` | Retrieves value for the key. |
| `remove(K key)` | Removes the key-value pair. |
| `containsKey(K key)` | Checks if a key exists. |
| `containsValue(V value)` | Checks if a value exists. |
| `size()` | Returns the number of key-value pairs. |
| `isEmpty()` | Checks if HashMap is empty. |
| `keySet()` | Returns a set of all keys. |
| `values()` | Returns a collection of all values. |
| `entrySet()` | Returns a set of all key-value pairs. |

---
## **5. Performance & Complexity**
| Operation | Average Case | Worst Case |
|-----------|-------------|------------|
| **Insert (`put`)** | O(1) | O(log n) (if collision tree is formed) |
| **Search (`get`)** | O(1) | O(log n) |
| **Delete (`remove`)** | O(1) | O(log n) |

---
## **6. HashMap vs Other Maps**
| Feature | `HashMap` | `LinkedHashMap` | `TreeMap` |
|---------|----------|---------------|----------|
| Order | Unordered | Insertion order | Sorted by keys |
| Speed | Fastest (O(1)) | Slightly slower | Slower (O(log n)) |
| Null Keys | Allowed | Allowed | Not allowed |
| Thread Safety | No | No | No |

---
## **7. When to Use HashMap?**
✅ When you need **fast lookups (O(1))**.  
✅ When you don't care about the order of elements.  
✅ When you need to store unique keys with corresponding values.  

---
### **Conclusion**
A `HashMap` is one of the most efficient ways to store key-value pairs in Java, offering quick retrieval and modification. However, it is **not synchronized**, so for multi-threading, you should use `ConcurrentHashMap`.

Would you like a deep dive into any specific part? 🚀



## **Internal Working of HashMap in Java (In-Depth)**
A `HashMap` in Java is implemented using **hashing** and follows a **bucket-based structure**. It provides **O(1) average time complexity** for basic operations like `put()`, `get()`, and `remove()`, but in the worst case, it can go up to **O(log n)**.

---

# **1. Data Structure Used in HashMap**
Internally, `HashMap` uses:
- **An array of `Node<K, V>` (buckets)**.
- Each bucket can store multiple key-value pairs using **Linked List (before Java 8)** or **Red-Black Tree (Java 8+).**

### **Node Structure**
Each entry in the `HashMap` is represented by a `Node<K, V>`:

```java
static class Node<K, V> {
    final int hash;  // Hash value of key
    final K key;     // Key
    V value;         // Value
    Node<K, V> next; // Pointer to next node (for collision handling)
}
```

---

# **2. Hashing Mechanism**
## **(a) How Does Hashing Work?**
When a key-value pair is inserted, Java:
1. Computes the **hash** of the key.
2. Determines the **bucket index** using:
   ```java
   index = (hash & (n - 1));  // Efficient modulus operation
   ```
   - `n` is the array size (power of 2).
   - `(n - 1)` ensures uniform distribution of keys.

### **(b) Hash Calculation**
Java computes the hash using:
```java
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```
- This **spreads out hash values** to minimize collisions.

---

# **3. Handling Collisions**
## **What if Two Keys Map to the Same Bucket?**
When multiple keys have the same index (hash collision), `HashMap` resolves collisions in two ways:

### **(a) Before Java 8 – Using Linked List**
- If two keys map to the same bucket, they are **stored in a linked list**.
- New elements are **added at the head of the list**.

### **(b) After Java 8 – Using Red-Black Tree**
- If a bucket contains **more than 8 entries**, Java **converts the linked list into a Red-Black Tree** for **O(log n)** performance.

#### **Red-Black Tree vs Linked List**
| Structure  | Search Time Complexity |
|------------|------------------------|
| Linked List | O(n) |
| Red-Black Tree | O(log n) |

---

# **4. Resizing & Rehashing**
## **(a) Load Factor**
- The **default initial capacity** is `16`.
- The **default load factor** is `0.75` (i.e., when 75% of the HashMap is filled, it resizes).

## **(b) When Does HashMap Resize?**
When the size exceeds `capacity * load factor`, the capacity **doubles** and all elements are **rehashed**.

## **(c) Why Power of 2 Capacity?**
- Ensures uniform distribution.
- **Efficient hashing using bitwise operations** instead of `%`.

---

# **5. Operations in HashMap**
## **(a) Insertion (`put(K key, V value)`)**
### **Steps:**
1. Compute **hash** of the key.
2. Determine **bucket index**.
3. If **bucket is empty**, store the key-value pair.
4. If **bucket has existing nodes**, check:
   - If **key already exists**, replace the value.
   - If **collision occurs**, insert into **Linked List (or Tree in Java 8+).**
5. If size > threshold (`capacity * load factor`), **resize and rehash**.

## **(b) Retrieval (`get(K key)`)**
### **Steps:**
1. Compute **hash** and find bucket index.
2. Traverse the **Linked List / Tree** in that bucket.
3. If key is found, return the value.
4. If key is not found, return `null`.

## **(c) Removal (`remove(K key)`)**
### **Steps:**
1. Compute **hash** and find bucket index.
2. Traverse the **Linked List / Tree**.
3. Remove the **matching node**.

---

# **6. Performance Analysis**
| Operation  | Best Case | Average Case | Worst Case (Before Java 8) | Worst Case (After Java 8) |
|------------|----------|--------------|--------------------------|--------------------------|
| **Put**    | O(1)     | O(1)         | O(n) (if all keys collide) | O(log n) (tree) |
| **Get**    | O(1)     | O(1)         | O(n) | O(log n) |
| **Remove** | O(1)     | O(1)         | O(n) | O(log n) |

---

# **7. HashMap vs Other Maps**
| Feature | `HashMap` | `LinkedHashMap` | `TreeMap` |
|---------|----------|---------------|----------|
| Order | No order | Maintains insertion order | Sorted by keys |
| Speed | O(1) (best case) | O(1) (best case) | O(log n) |
| Null Keys | Allowed | Allowed | Not allowed |
| Thread Safety | No | No | No |

---

# **8. Thread Safety of HashMap**
### **(a) Why is HashMap Not Thread-Safe?**
- `HashMap` is **not synchronized**.
- In multi-threaded environments, concurrent modifications can lead to **data corruption** (e.g., infinite loops).

### **(b) How to Make HashMap Thread-Safe?**
- Use **`Collections.synchronizedMap()`**:
  ```java
  Map<K, V> map = Collections.synchronizedMap(new HashMap<>());
  ```
- Use **`ConcurrentHashMap`** for better performance.

---

# **9. Summary**
✅ **Uses an array of `Node<K, V>[]`.**  
✅ **Determines bucket using `hash & (n - 1)`.**  
✅ **Handles collisions using Linked List (Java 7) or Red-Black Tree (Java 8+).**  
✅ **Resizes when `size > capacity * load factor`.**  
✅ **Provides O(1) performance in average case, O(log n) in worst case.**  
✅ **Not thread-safe; use `ConcurrentHashMap` for multi-threading.**  

---

## **Would you like a practical example or a deep dive into Red-Black Tree usage in HashMap?** 🚀
