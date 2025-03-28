### **Java Collection Framework Hierarchy**
The **Java Collection Framework (JCF)** provides a unified architecture for storing and manipulating groups of objects. It includes **interfaces**, **classes**, and **algorithms** that allow developers to work with collections efficiently.

---

## **1. Collection Framework Hierarchy Diagram**
```
                 Iterable (interface)
                     |
              -----------------
              |               |
         Collection         Map (interface)
              |               |
   -----------------      -----------------
   |       |       |      |               |
 List     Set   Queue   HashMap      SortedMap
   |       |       |      |               |
ArrayList HashSet PriorityQueue TreeMap LinkedHashMap
LinkedList TreeSet Deque
Vector
Stack
```

---

## **2. Core Interfaces in Collection Framework**
### **(A) Iterable Interface**
- Root interface of the Collection Framework.
- Allows iteration using `for-each` loop.
- Implemented by `Collection`, `Queue`, `Set`, and `List`.

### **(B) Collection Interface**
- Extends `Iterable` and is the base for all data structures in JCF.
- Provides core methods: `add()`, `remove()`, `size()`, `clear()`, `contains()`, etc.

### **(C) List Interface**
- Ordered collection (maintains insertion order).
- Allows duplicate elements.
- Implementations:
  - **ArrayList**: Resizable array, fast random access, slow insertion/deletion.
  - **LinkedList**: Doubly linked list, fast insertion/deletion, slow random access.
  - **Vector**: Synchronized version of `ArrayList` (legacy).
  - **Stack**: LIFO (Last-In-First-Out) data structure.

### **(D) Set Interface**
- No duplicate elements allowed.
- Implementations:
  - **HashSet**: Uses a Hash Table (unordered, unique elements).
  - **LinkedHashSet**: HashSet + maintains insertion order.
  - **TreeSet**: Sorted set based on `Comparable` or `Comparator`.

### **(E) Queue Interface**
- FIFO (First-In-First-Out) structure.
- Implementations:
  - **PriorityQueue**: Orders elements based on priority.
  - **Deque (Double-Ended Queue)**: Supports insertion/removal from both ends.
  - **LinkedList**: Can be used as a Queue.

### **(F) Map Interface (Not a Subtype of Collection)**
- Key-Value pairs (unique keys, values can be duplicate).
- Implementations:
  - **HashMap**: Unordered key-value mapping, allows `null` keys.
  - **LinkedHashMap**: Maintains insertion order.
  - **TreeMap**: Sorted map (keys in ascending order).

---

## **3. Differences Between List, Set, and Map**
| Feature       | List       | Set        | Map          |
|--------------|-----------|-----------|-------------|
| Duplicates   | ✅ Allowed | ❌ Not Allowed | ❌ Not Allowed (Keys) |
| Ordered?     | ✅ Yes     | ❌ No (Except LinkedHashSet) | ✅ By keys (TreeMap) |
| Key-Value Pair | ❌ No     | ❌ No     | ✅ Yes |
| Performance  | Fast random access (ArrayList) | Fast lookup (HashSet) | Fast key lookup (HashMap) |

---

## **4. Example Usage of Different Collections**
### **Using `ArrayList`**
```java
import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

### **Using `HashSet`**
```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // Duplicate, will not be added

        System.out.println(numbers);
    }
}
```

### **Using `HashMap`**
```java
import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        students.put(1, "Alice");
        students.put(2, "Bob");

        System.out.println(students.get(1)); // Output: Alice
    }
}
```

---

### **5. Key Takeaways**
✅ Use `ArrayList` when you need fast random access.  
✅ Use `LinkedList` when frequent insertions/removals are required.  
✅ Use `HashSet` to store unique elements.  
✅ Use `HashMap` when key-value mappings are needed.  

Would you like a more detailed example of any specific collection? 🚀
