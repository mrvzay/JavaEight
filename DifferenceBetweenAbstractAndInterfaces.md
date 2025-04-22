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
