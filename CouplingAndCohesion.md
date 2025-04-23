# **Coupling and Cohesion in OOP**  

### **1. Cohesion (High Cohesion = Good)**  
**Definition:**  
Cohesion refers to how closely the responsibilities of a **single class/module** are related to each other.  

**Key Points:**  
- **High Cohesion** → A class performs **one well-defined task** (e.g., `UserService` only handles user-related logic).  
- **Low Cohesion** → A class does **unrelated tasks** (e.g., `UserService` also handles logging, email, and file operations).  

**Example:**  
✅ **High Cohesion (Good):**  
```java
class OrderProcessor {
    void validateOrder(Order order) { ... }
    void processPayment(Order order) { ... }
}
```
❌ **Low Cohesion (Bad):**  
```java
class OrderProcessor {
    void validateOrder(Order order) { ... }
    void sendEmail(User user) { ... }  // Unrelated to orders!
    void logError(String error) { ... } // Should be in Logger class
}
```
**Why High Cohesion?**  
✔ Easier to maintain  
✔ More reusable  
✔ Better readability  

---

### **2. Coupling (Low Coupling = Good)**  
**Definition:**  
Coupling refers to **how much one class depends on another**.  

**Key Points:**  
- **Low Coupling** → Classes interact **loosely** (e.g., via interfaces).  
- **High Coupling** → Classes are **tightly dependent** (changes in one break another).  

**Example:**  
✅ **Low Coupling (Good - Uses Interface):**  
```java
interface PaymentGateway {
    void processPayment(double amount);
}

class PayPal implements PaymentGateway { ... }
class Stripe implements PaymentGateway { ... }

class OrderService {
    private PaymentGateway gateway; // Depends on abstraction
    OrderService(PaymentGateway gateway) { this.gateway = gateway; }
}
```
❌ **High Coupling (Bad - Direct Dependency):**  
```java
class OrderService {
    private PayPal paypal; // Tightly coupled to PayPal
    OrderService() { this.paypal = new PayPal(); }
}
```
**Why Low Coupling?**  
✔ Easier to modify one class without breaking others  
✔ Better testability (mock dependencies)  
✔ More flexible (swap implementations easily)  

---

### **Summary Table**  
| Concept       | Goal          | Good Practice | Bad Practice |
|--------------|--------------|---------------|--------------|
| **Cohesion** | High (focused) | One class = one responsibility | A class does many unrelated things |
| **Coupling** | Low (independent) | Depend on abstractions (interfaces) | Direct dependency on concrete classes |

### **Best Practice:**  
➡ **High Cohesion + Low Coupling = Maintainable & Scalable Code**  
➡ Follow **SOLID principles** (Single Responsibility, Dependency Inversion) to achieve this.  

This balance makes OOP systems **modular, reusable, and easier to maintain**. 🚀


Why is it important to minimize coupling and maximize cohesion  in java ?

### **Why Minimize Coupling & Maximize Cohesion in Java?**  

Minimizing **coupling** (dependencies between classes) and maximizing **cohesion** (keeping classes focused) are crucial for writing **clean, maintainable, and scalable Java code**. Here’s why:  

---

### **1. Easier Maintenance**  
- **Low Coupling** → Changing one class **doesn’t break others**.  
- **High Cohesion** → Classes have **single responsibilities**, making them easier to modify.  

✅ **Example:**  
```java
// High Cohesion (UserService only handles user logic)
class UserService {  
    void registerUser(User user) { ... }  
    void deleteUser(User user) { ... }  
}  

// Low Coupling (uses Dependency Injection)
class AuthService {  
    private final UserService userService; // Depends on abstraction  
    AuthService(UserService userService) {  
        this.userService = userService;  
    }  
}  
```
➡ **Changes to `UserService` won’t force changes in `AuthService`.**  

---

### **2. Better Reusability**  
- **Low Coupling** → Classes can be **reused independently**.  
- **High Cohesion** → Classes are **focused**, making them reusable in different contexts.  

✅ **Example:**  
```java
// Reusable Logger (High Cohesion)
class Logger {  
    void log(String message) { ... }  
}  

// Used in multiple classes (Low Coupling)
class OrderService {  
    private final Logger logger;  
    OrderService(Logger logger) { this.logger = logger; }  
}  

class PaymentService {  
    private final Logger logger;  
    PaymentService(Logger logger) { this.logger = logger; }  
}  
```
➡ **Same `Logger` works in `OrderService` and `PaymentService` without modifications.**  

---

### **3. Improved Testability**  
- **Low Coupling** → Easier to **mock dependencies** in unit tests.  
- **High Cohesion** → Tests are **focused** on one behavior.  

✅ **Example:**  
```java
// Testable PaymentProcessor (Low Coupling)
class PaymentProcessor {  
    private final PaymentGateway gateway;  
    PaymentProcessor(PaymentGateway gateway) {  
        this.gateway = gateway;  
    }  
    boolean process(double amount) {  
        return gateway.charge(amount);  
    }  
}  

// Mock PaymentGateway in tests  
@Test  
void testPaymentProcessor() {  
    PaymentGateway mockGateway = mock(PaymentGateway.class);  
    PaymentProcessor processor = new PaymentProcessor(mockGateway);  
    assertTrue(processor.process(100.0));  
}  
```
➡ **No need to test `PaymentGateway`—just mock it!**  

---

### **4. Scalability & Flexibility**  
- **Low Coupling** → New features can be added **without rewriting existing code**.  
- **High Cohesion** → Classes are **modular**, making them easier to extend.  

✅ **Example:**  
```java
// Extensible with new PaymentGateways (Low Coupling)
interface PaymentGateway {  
    boolean charge(double amount);  
}  

class PayPal implements PaymentGateway { ... }  
class Stripe implements PaymentGateway { ... }  

// PaymentProcessor works with ANY PaymentGateway  
PaymentProcessor paypalProcessor = new PaymentProcessor(new PayPal());  
PaymentProcessor stripeProcessor = new PaymentProcessor(new Stripe());  
```
➡ **Add `CryptoGateway` later without modifying `PaymentProcessor`.**  

---

### **5. Reduced Bug Risks**  
- **Low Coupling** → Fewer **side effects** when modifying code.  
- **High Cohesion** → Clearer logic, reducing **unexpected behavior**.  

✅ **Example:**  
```java
// Bug-prone (High Coupling + Low Cohesion)
class OrderManager {  
    private Database db;  
    private EmailService email;  
    private Logger logger;  

    void placeOrder(Order order) {  
        db.save(order);  
        email.sendConfirmation(order.getUser());  
        logger.log("Order placed");  
    }  
}  
```
❌ **Changing `EmailService` could break `OrderManager`!**  

➡ **Solution:** Split into smaller, decoupled classes.  

---

### **Key Takeaways**  
| **Goal**          | **Benefit**                                  | **How?** |
|-------------------|---------------------------------------------|----------|
| **Minimize Coupling** | Fewer dependencies → More flexible code | Use **interfaces**, **Dependency Injection** |
| **Maximize Cohesion** | Clean, focused classes → Easier debugging | Follow **Single Responsibility Principle (SRP)** |

### **Best Practices**  
✔ **Use Dependency Injection** (Spring, Guice) to reduce coupling.  
✔ **Follow SOLID Principles** (especially **Single Responsibility & Dependency Inversion**).  
✔ **Avoid God Classes** (classes doing too much → low cohesion).  

By keeping **coupling low** and **cohesion high**, your Java code becomes:  
🚀 **Easier to maintain**  
🔄 **More reusable**  
🧪 **Simpler to test**  
📈 **More scalable**  

This is why these principles are **fundamental** in OOP and enterprise Java development!
