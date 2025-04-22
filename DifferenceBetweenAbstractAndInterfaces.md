# Difference Between Interface and Abstract Class

Both interfaces and abstract classes are used for abstraction in object-oriented programming, but they have key differences:

## Abstract Class
1. **Definition**: A class declared with the `abstract` keyword that cannot be instantiated
2. **Methods**:
   - Can contain both abstract (no implementation) and concrete (with implementation) methods
   - Abstract methods must be declared with the `abstract` keyword
3. **Variables**:
   - Can have member variables (fields)
   - Variables can be of any visibility (public, private, protected)
4. **Constructors**: Can have constructors (but can't be instantiated directly)
5. **Inheritance**:
   - A class can extend only one abstract class (single inheritance)
   - Child class must implement all abstract methods or be declared abstract
6. **Use Case**: When you want to provide a common base class with some default implementation

## Interface
1. **Definition**: A completely abstract type that defines a contract
2. **Methods**:
   - All methods are abstract by default (no implementation)
   - In Java 8+, can have default and static methods with implementation
3. **Variables**:
   - Can only have public static final constants (implicitly)
   - No instance variables allowed
4. **Constructors**: Cannot have constructors
5. **Inheritance**:
   - A class can implement multiple interfaces (multiple inheritance)
   - An interface can extend multiple other interfaces
6. **Use Case**: When you want to define a contract that multiple unrelated classes can implement

## Key Differences Summary
| Feature            | Abstract Class               | Interface                    |
|--------------------|------------------------------|------------------------------|
| Instantiation      | Cannot be instantiated       | Cannot be instantiated       |
| Method types       | Abstract + concrete          | All abstract (pre-Java 8)    |
| Variables          | Can have instance variables  | Only constants               |
| Constructors       | Can have constructors        | No constructors              |
| Inheritance        | Single inheritance           | Multiple inheritance         |
| Default methods    | Since beginning              | Since Java 8                 |
| Access modifiers   | Any visibility               | Public (implicitly)          |

## When to Use Which
- Use an **abstract class** when you want to share code among closely related classes
- Use an **interface** when you want to define a contract for unrelated classes to implement
- Use an **interface** when you want to specify a behavior that classes can choose to implement

Modern Java (8+) has blurred some of these distinctions with default methods in interfaces, but the fundamental differences in purpose remain.













Great question! Understanding the difference between **interface** and **abstract class** is key to writing good object-oriented code. Here’s a clear breakdown of the differences:

---

### ✅ **1. Purpose**

| Concept         | Purpose                                                                 |
|----------------|-------------------------------------------------------------------------|
| **Interface**   | Defines a **contract** — what a class should do, not how.               |
| **Abstract Class** | Serves as a **base class** — can provide both definition and implementation. |

---

### ✅ **2. Methods**

| Concept         | Methods                                                                 |
|----------------|-------------------------------------------------------------------------|
| **Interface**   | Only contains **abstract methods** (until Java 8+ where default methods are allowed). |
| **Abstract Class** | Can have both **abstract** and **concrete** (implemented) methods.         |

---

### ✅ **3. Variables / Fields**

| Concept         | Variables/Fields                                                        |
|----------------|-------------------------------------------------------------------------|
| **Interface**   | Only **public static final** (constants).                              |
| **Abstract Class** | Can have instance variables of any type and access modifier.            |

---

### ✅ **4. Inheritance**

| Concept         | Inheritance                                                             |
|----------------|-------------------------------------------------------------------------|
| **Interface**   | A class can implement **multiple interfaces** (supports multiple inheritance). |
| **Abstract Class** | A class can **only extend one** abstract class (single inheritance).     |

---

### ✅ **5. Constructors**

| Concept         | Constructors                                                            |
|----------------|-------------------------------------------------------------------------|
| **Interface**   | ❌ Cannot have constructors.                                              |
| **Abstract Class** | ✅ Can have constructors to initialize state.                          |

---

### ✅ **6. When to Use**

- **Use an Interface** when:
  - You want to define a contract that multiple classes can implement in their own way.
  - You need multiple inheritance (since classes can implement many interfaces).

- **Use an Abstract Class** when:
  - You want to share code among several closely related classes.
  - You want to define some common behavior, but force subclasses to implement the rest.

---

### 🚀 Example in Java

```java
interface Animal {
    void makeSound(); // abstract by default
}

abstract class Bird {
    void fly() {
        System.out.println("Flying...");
    }
    abstract void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Bark!");
    }
}

class Parrot extends Bird {
    void makeSound() {
        System.out.println("Squawk!");
    }
}
```

---

Let me know if you want the same breakdown for a different language (like C#, Python, etc.) or want real-life analogies to better grasp it!
