# Java Collections Framework Hierarchy

The Java Collections Framework is a unified architecture for representing and manipulating collections. Here's a comprehensive overview of its hierarchy:

## Core Hierarchy Structure

```
Iterable (interface)
  ↓
Collection (interface)
  ├── List (interface)
  │    ├── ArrayList (class)
  │    ├── LinkedList (class)
  │    ├── Vector (class) [legacy]
  │    │    └── Stack (class) [legacy]
  │    └── CopyOnWriteArrayList (class) [thread-safe]
  │
  ├── Set (interface)
  │    ├── HashSet (class)
  │    │    └── LinkedHashSet (class)
  │    ├── SortedSet (interface)
  │    │    └── TreeSet (class)
  │    ├── NavigableSet (interface)
  │    └── CopyOnWriteArraySet (class) [thread-safe]
  │
  └── Queue (interface)
       ├── Deque (interface)
       │    ├── ArrayDeque (class)
       │    └── LinkedList (class)
       ├── PriorityQueue (class)
       └── BlockingQueue (interface)
            ├── ArrayBlockingQueue (class)
            ├── LinkedBlockingQueue (class)
            └── PriorityBlockingQueue (class)

Map (interface) [Not part of Collection hierarchy]
  ├── HashMap (class)
  │    └── LinkedHashMap (class)
  ├── Hashtable (class) [legacy]
  ├── SortedMap (interface)
  │    └── TreeMap (class)
  ├── NavigableMap (interface)
  └── ConcurrentMap (interface)
       ├── ConcurrentHashMap (class)
       └── ConcurrentSkipListMap (class)
```

## Detailed Breakdown

### 1. Iterable Interface
- Root interface of the collection hierarchy
- Provides iterator() method to iterate over elements
- Implemented by all collection classes

### 2. Collection Interface
- Root interface of the collection hierarchy
- Basic operations: add(), remove(), contains(), size(), etc.
- Three main sub-interfaces: List, Set, and Queue

### 3. List Interface
- Ordered collection (sequence)
- Allows duplicates
- Index-based access
- Implementations:
  - **ArrayList**: Resizable array, fast random access
  - **LinkedList**: Doubly-linked list, fast insertions/deletions
  - **Vector**: Thread-safe but legacy (use ArrayList with synchronization)
  - **Stack**: LIFO structure (legacy, better alternatives exist)

### 4. Set Interface
- Unordered collection
- No duplicates
- Implementations:
  - **HashSet**: Hash table implementation, fastest
  - **LinkedHashSet**: Maintains insertion order
  - **TreeSet**: Red-Black tree implementation, sorted order
  - **SortedSet**: Interface for sorted sets
  - **NavigableSet**: Extends SortedSet with navigation methods

### 5. Queue Interface
- Designed for holding elements prior to processing
- FIFO (First-In-First-Out) by default
- Implementations:
  - **PriorityQueue**: Priority-based ordering
  - **Deque**: Double-ended queue (sub-interface)
    - **ArrayDeque**: Resizable array implementation
    - **LinkedList**: Also implements Deque
  - **BlockingQueue**: Thread-safe queues for concurrent programming

### 6. Map Interface
- Not part of the Collection interface hierarchy
- Stores key-value pairs
- Implementations:
  - **HashMap**: Hash table implementation
  - **LinkedHashMap**: Maintains insertion order
  - **TreeMap**: Red-Black tree implementation, sorted by keys
  - **Hashtable**: Legacy thread-safe implementation
  - **ConcurrentHashMap**: Thread-safe and scalable
  - **WeakHashMap**: Entries can be garbage-collected

## Utility Classes

1. **Collections**:
   - Static methods for collection operations (sort, search, synchronize, etc.)
   - Factory methods for immutable collections (Java 9+)

2. **Arrays**:
   - Utility methods for array manipulation
   - Bridge between arrays and collections

## Java Collections Framework Features

1. **Polymorphism**: Can treat different implementations uniformly
2. **Interoperability**: Easy conversion between collection types
3. **Algorithm Support**: Built-in sorting, searching, shuffling
4. **Extensibility**: Can create custom implementations
5. **Thread Safety**: Concurrent collections for multi-threaded environments

## When Java 8+ Enhancements

- Stream API for bulk operations
- Default methods in interfaces
- Factory methods for immutable collections (List.of(), Set.of(), etc.)
- Improved concurrent collections

The Collections Framework provides a well-designed, standardized architecture that promotes code reuse and interoperability while offering flexibility through multiple implementations for different needs.
