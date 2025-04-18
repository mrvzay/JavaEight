# Java Keywords (Reserved Words)

Java has a set of reserved words that have special meaning in the language and cannot be used as identifiers (variable names, method names, class names, etc.). Here's the complete list of Java keywords:

## Access Modifiers
- `public` - accessible from anywhere
- `private` - accessible only within its own class
- `protected` - accessible within package and subclasses
- (default) - no keyword, accessible within package

## Class, Method, and Variable Modifiers
- `abstract` - cannot be instantiated, may contain abstract methods
- `class` - declares a class
- `extends` - indicates inheritance
- `final` - cannot be extended/overridden/changed
- `implements` - indicates interface implementation
- `interface` - declares an interface
- `native` - implemented in platform-dependent code
- `new` - creates new objects
- `static` - belongs to the class rather than instances
- `strictfp` - restricts floating-point calculations
- `synchronized` - controls thread access
- `transient` - not part of object's persistent state
- `volatile` - indicates variable may be changed by multiple threads

## Control Flow
- `break` - exits loop or switch
- `case` - a branch in switch statement
- `continue` - skips current loop iteration
- `default` - default branch in switch
- `do` - starts do-while loop
- `else` - alternative in if-else
- `for` - starts for loop
- `if` - starts conditional
- `instanceof` - tests object type
- `return` - exits method with optional value
- `switch` - multi-way branch
- `while` - starts while loop

## Exception Handling
- `assert` - tests boolean expression
- `catch` - handles exceptions
- `finally` - always executes after try-catch
- `throw` - throws an exception
- `throws` - declares exceptions a method might throw
- `try` - block of code to handle exceptions

## Package Control
- `import` - imports packages or classes
- `package` - declares package

## Primitives
- `boolean` - true/false value
- `byte` - 8-bit integer
- `char` - single Unicode character
- `double` - double-precision floating-point
- `float` - single-precision floating-point
- `int` - 32-bit integer
- `long` - 64-bit integer
- `short` - 16-bit integer

## Other
- `const` (reserved but not used)
- `enum` - declares enumerated type
- `goto` (reserved but not used)
- `super` - refers to superclass
- `this` - refers to current object
- `void` - indicates no return value

## Literals (not technically keywords but reserved)
- `true` - boolean literal
- `false` - boolean literal
- `null` - null reference

Note: As of Java 17, there are 50 reserved keywords and 3 reserved literals in the Java language. These words cannot be used as identifiers in your code.
