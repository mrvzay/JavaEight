# **HashMap in Java**

A **HashMap** in Java is a part of the **Java Collections Framework** and implements the **Map interface**. It stores data in **key-value pairs** and allows fast retrieval, insertion, and deletion of elements based on keys.

## **Key Features of HashMap**
1. **Stores Key-Value Pairs**: Each element has a unique key and an associated value.
2. **No Duplicate Keys**: If a duplicate key is inserted, the old value is replaced.
3. **Allows One `null` Key & Multiple `null` Values**.
4. **Unordered Collection**: The order of elements is not guaranteed (unlike `LinkedHashMap`).
5. **Not Thread-Safe**: For thread-safe operations, use `ConcurrentHashMap` or `Collections.synchronizedMap()`.
6. **Initial Default Capacity**: **16** (can be customized).
7. **Load Factor**: **0.75** (when 75% full, it resizes to double its capacity).

---

## **Internal Working of HashMap**
### **1. Storage Structure**
- Internally, a **HashMap** uses an **array of `Node` objects** (buckets).
- Each `Node` contains:
  ```java
  class Node<K,V> {
      final int hash; // Hash of the key
      final K key;    // Key
      V value;        // Value
      Node<K,V> next; // Next node (for chaining)
  }
  ```

### **2. How `put()` Works**
1. **Calculate `hashCode()` of the key**.
2. **Compute bucket index**:
   ```java
   index = hash(key) & (n - 1)  // where n = array size
   ```
3. **Check the bucket**:
   - If **bucket is empty**, store the new `Node`.
   - If **bucket has existing nodes**:
     - If a node with the **same key** exists, **update its value**.
     - Else, traverse the linked list/tree and **add the new node** at the end.
4. **If the bucket exceeds a threshold (TREEIFY_THRESHOLD = 8)**, convert the linked list into a **Red-Black Tree** (for better performance).

### **3. How `get()` Works**
1. **Compute the hash of the key**.
2. **Find the bucket index**.
3. **Traverse the linked list/tree** in that bucket:
   - If the key matches, return the value.
   - Else, return `null`.

### **4. Handling Collisions**
- **Separate Chaining**: If two keys have the same hash, they are stored in the same bucket as a **linked list** (or **tree** in Java 8+).
- **Java 8+ Optimization**: If a bucket has **>8 nodes**, it converts the linked list into a **Red-Black Tree (O(log n) search)** instead of O(n).

### **5. Resizing (Rehashing)**
- When the number of elements exceeds `(Capacity × Load Factor)`, the HashMap **doubles its size** (e.g., from 16 to 32).
- All existing entries are **rehashed** and redistributed to new buckets.

---

## **Example of HashMap Usage**
```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding elements
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        // Accessing a value
        System.out.println(map.get("Banana")); // Output: 20

        // Updating a value
        map.put("Apple", 50);

        // Removing a key
        map.remove("Orange");

        // Iterating
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
```
**Output:**
```
20
Apple: 50
Banana: 20
```

---

## **When to Use HashMap?**
✔ **Fast Lookups**: O(1) average time complexity for `get()` and `put()`.  
✔ **No Order Requirement**: If insertion order doesn’t matter.  
✔ **Key-Value Storage**: When you need to associate keys with values.  

## **Alternatives**
- **`LinkedHashMap`**: Maintains insertion order.
- **`TreeMap`**: Sorts keys in natural order (or using a `Comparator`).
- **`ConcurrentHashMap`**: Thread-safe version for multi-threading.

---

### **Summary**
- **HashMap** is a **key-value** storage structure.
- Uses **hashing** for O(1) average-time operations.
- **Handles collisions** using **linked lists** (or **trees** in Java 8+).
- **Resizes dynamically** when it reaches the load factor.
- **Not synchronized** (use `ConcurrentHashMap` for thread safety).




# **Detailed Internal Working of HashMap in Java**

HashMap is one of the most important data structures in Java, optimized for fast key-value storage and retrieval. Let's dive deep into its internal mechanisms.

## **1. Core Data Structures**
A HashMap internally uses:
- **Array of `Node` objects (buckets)** → Acts as the primary storage
- **Linked Lists** → For collision handling (Java 7 and earlier)
- **Red-Black Trees** → For collision handling (Java 8+)

### **Node Class (Entry in Java 7)**
```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash; // Precomputed hash of the key
    final K key;    // Key (immutable)
    V value;        // Value (can change)
    Node<K,V> next; // Reference to next node (for chaining)
    
    // Constructor, getters, setters...
}
```

---

## **2. Key Operations Explained**

### **A. `put(K key, V value)` Operation**
1. **Compute the hash of the key**  
   - Uses `key.hashCode()` but applies an **additional hash function** to reduce collisions:
     ```java
     static final int hash(Object key) {
         int h;
         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     }
     ```
     - This **spreads higher bits** to reduce collisions.

2. **Calculate the bucket index**  
   - Uses **bitwise AND (`&`)** instead of modulo (`%`) for efficiency:
     ```java
     index = (n - 1) & hash  // n = current array size (always power of 2)
     ```

3. **Check the bucket at the computed index**
   - **If bucket is empty** → Insert new `Node`.
   - **If bucket has existing nodes**:
     - Traverse the linked list or tree.
     - If a node with the **same key** exists → **replace its value**.
     - Else → **append a new node** at the end.

4. **If the bucket exceeds `TREEIFY_THRESHOLD` (default=8)**  
   - Converts the linked list into a **Red-Black Tree** (if `MIN_TREEIFY_CAPACITY` ≥ 64).

5. **Resize if threshold is crossed**  
   - If `size > (capacity × load factor)` → **double the array size** and **rehash all entries**.

---

### **B. `get(Object key)` Operation**
1. **Compute the hash of the key** (same as `put`).
2. **Find the bucket index**:
   ```java
   index = (n - 1) & hash
   ```
3. **Traverse the bucket**:
   - If the bucket is a **linked list** → **O(n)** search.
   - If the bucket is a **tree** → **O(log n)** search.
   - If key matches → return value; else return `null`.

---

### **C. `remove(Object key)` Operation**
1. **Compute hash and bucket index** (same as `get`).
2. **Find the node** in the bucket.
3. **Remove the node** and adjust linked list/tree.

---

## **3. Handling Collisions**
### **A. Separate Chaining**
- If two keys **hash to the same bucket**, they are stored as a **linked list** (or **tree** in Java 8+).
- **Java 7**: Only linked lists (O(n) worst case).
- **Java 8+**: Converts to **Red-Black Tree** if bucket size > 8 (O(log n) worst case).

### **B. Why Red-Black Trees?**
- **Prevents DoS attacks** where attackers could force all keys into one bucket (making HashMap O(n)).
- **Improves worst-case performance** from O(n) to O(log n).

---

## **4. Resizing (Rehashing)**
### **When does resizing happen?**
- When `size > (capacity × load factor)` (default: 16 × 0.75 = 12).

### **How does resizing work?**
1. **New capacity = Old capacity × 2** (always powers of 2: 16 → 32 → 64...).
2. **Recompute hashes** for all keys:
   - Since `index = (n - 1) & hash`, doubling `n` changes the index distribution.
3. **Reassign entries** to new buckets.

### **Performance Impact**
- **Expensive operation** (O(n) time).
- **Can be optimized** by providing an **initial capacity** if size is known in advance:
  ```java
  HashMap<String, Integer> map = new HashMap<>(100); // Initial capacity 100
  ```

---

## **5. Java 8+ Optimizations**
| Feature | Java 7 | Java 8+ |
|---------|--------|---------|
| **Collision Handling** | Linked List (O(n)) | Tree (O(log n)) if bucket size > 8 |
| **Tree Conversion** | Not available | Converts to **Red-Black Tree** |
| **Hash Calculation** | Multiple steps | Optimized with `hash ^ (hash >>> 16)` |

---

## **6. Thread Safety & Alternatives**
- **HashMap is NOT thread-safe**:
  - Concurrent modifications can lead to **infinite loops** (in Java 7) or **data corruption**.
- **Thread-safe alternatives**:
  - `ConcurrentHashMap` (best for high concurrency).
  - `Collections.synchronizedMap(new HashMap<>())` (legacy approach).

---

## **7. Best Practices**
✔ **Override `hashCode()` and `equals()` correctly** for custom key objects.  
✔ **Set initial capacity** if size is known to avoid resizing overhead.  
✔ **Use immutable keys** (like `String`, `Integer`) to prevent hash changes.  
✔ **Prefer `ConcurrentHashMap`** in multi-threaded environments.  

---

## **Summary of HashMap Internals**
| Concept | Description |
|---------|-------------|
| **Storage** | Array of `Node` objects (buckets) |
| **Collision Handling** | Linked List → Red-Black Tree (Java 8+) |
| **Hash Calculation** | `(key.hashCode()) ^ (h >>> 16)` |
| **Index Calculation** | `(n - 1) & hash` |
| **Load Factor** | 0.75 (default) |
| **Resizing** | Doubles capacity when threshold is crossed |
| **Thread Safety** | Not thread-safe (use `ConcurrentHashMap`) |

Would you like a deep dive into **hash collision attacks** or **performance benchmarks**? 😊
