In Spring, **stereotype annotations** are specialized annotations that mark classes as Spring-managed components, enabling automatic detection and dependency injection. They are part of the **Spring Core** framework and are processed during **component scanning**.

---

## **1. Core Stereotype Annotations**
### **① `@Component`**  
- **Purpose:** Generic marker for any Spring-managed bean.  
- **Usage:** Classes that don't fit into `@Service`, `@Repository`, or `@Controller`.  
- **Example:**  
  ```java
  @Component
  public class UtilityService {
      // Business logic here
  }
  ```

### **② `@Service`**  
- **Purpose:** Identifies a **business service layer** class (logic, calculations, transactions).  
- **Semantic Meaning:** Indicates the class holds business logic.  
- **Example:**  
  ```java
  @Service
  public class PaymentService {
      public void processPayment() {
          // Payment processing logic
      }
  }
  ```

### **③ `@Repository`**  
- **Purpose:** Marks a **data access layer** class (DAO, database operations).  
- **Extra Benefit:** Automatically translates **JDBC/JPA exceptions** into Spring’s `DataAccessException`.  
- **Example:**  
  ```java
  @Repository
  public class UserRepository {
      public User findById(Long id) {
          // Database query
      }
  }
  ```

### **④ `@Controller`**  
- **Purpose:** Defines a **Spring MVC controller** (handles HTTP requests).  
- **Used with:** `@RequestMapping`, `@GetMapping`, etc.  
- **Example:**  
  ```java
  @Controller
  public class UserController {
      @GetMapping("/users")
      public String getUsers(Model model) {
          // Return a view
      }
  }
  ```

### **⑤ `@RestController`** (Specialized `@Controller`)  
- **Purpose:** Combines `@Controller` + `@ResponseBody` for **REST APIs**.  
- **Example:**  
  ```java
  @RestController
  public class ApiController {
      @GetMapping("/api/data")
      public ResponseEntity<Data> fetchData() {
          // Return JSON/XML
      }
  }
  ```

---

## **2. How Stereotypes Work?**
- **Component Scanning:**  
  Spring scans classes annotated with `@Component` (or its specializations) during startup and registers them as beans.  
  ```java
  @Configuration
  @ComponentScan("com.example.package") // Scans this package
  public class AppConfig {}
  ```
- **Bean Naming:**  
  By default, the bean name is the **class name in lowercase** (e.g., `UserService` → `userService`).  
  Override with `@Component("customName")`.

---

## **3. Key Differences Between Stereotypes**
| Annotation     | Layer          | Use Case                          | Special Behavior                     |
|---------------|---------------|----------------------------------|--------------------------------------|
| `@Component`  | Generic        | Utility classes, helpers         | Base for other stereotypes.          |
| `@Service`    | Business Logic | Payment, order processing        | No extra features (semantic only).   |
| `@Repository` | Data Access    | Database operations (JPA, JDBC)  | Exception translation.               |
| `@Controller` | Web Layer      | MVC controllers (server-side rendering) | Handles HTTP requests.              |
| `@RestController` | Web Layer  | REST APIs (JSON/XML)             | Auto-serializes responses.           |

---

## **4. Custom Stereotypes (Meta-Annotations)**
You can create **custom stereotypes** by combining existing ones:  
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component // Makes it detectable by Spring
public @interface CustomService {
    // Additional metadata
}
```
**Usage:**  
```java
@CustomService
public class MyCustomService { ... }
```

---

## **5. Common Mistakes**
1. **Using `@Component` instead of specialized annotations:**  
   - Prefer `@Service` for business logic, `@Repository` for DAOs.  
2. **Missing `@ComponentScan`:**  
   - Ensure Spring scans the package where your stereotypes are defined.  
3. **Overusing `@RestController` for non-API classes:**  
   - Use `@Controller` for server-side views (Thymeleaf, JSP).  

---

## **6. When to Use Which?**
- **`@Service`:** Business logic (e.g., `OrderService`, `PaymentService`).  
- **`@Repository`:** Database operations (e.g., `UserRepository`, `ProductDao`).  
- **`@Controller`/`@RestController`:** Web layer (MVC or REST APIs).  
- **`@Component`:** Generic utilities (e.g., `EmailValidator`, `DateUtils`).  

---

## **Summary**
- **Stereotype annotations** classify Spring beans by layer (`@Service`, `@Repository`, etc.).  
- **`@Component`** is the base; others provide **semantic meaning** and **extra features**.  
- **Component scanning** detects these annotations and registers beans automatically.  

---------------------------------------------------


In Spring, **stereotype annotations** are used to mark classes as **Spring-managed components**, helping the framework detect and register them automatically during **component scanning**.

---

## 📦 Common Spring Stereotype Annotations

| Annotation        | Purpose                                    | Typical Use Case                      |
| ----------------- | ------------------------------------------ | ------------------------------------- |
| `@Component`      | Generic Spring-managed component           | General-purpose bean                  |
| `@Service`        | Specialized version of `@Component`        | Business logic layer                  |
| `@Repository`     | Specialized version of `@Component`        | Data access layer (DAOs, Repos)       |
| `@Controller`     | Specialized version of `@Component`        | Web layer (Spring MVC controllers)    |
| `@RestController` | Combines `@Controller` and `@ResponseBody` | REST APIs (returns JSON/XML directly) |

---

## 📌 1. `@Component`

* Base annotation for all components.

```java
@Component
public class MyUtility {
    // utility code
}
```

---

## 📌 2. `@Service`

* Indicates a service component (business logic).

```java
@Service
public class OrderService {
    public void placeOrder() {
        // business logic
    }
}
```

---

## 📌 3. `@Repository`

* Indicates a data-access component.
* Adds exception translation (e.g., wraps SQL exceptions into Spring’s `DataAccessException`).

```java
@Repository
public class UserRepository {
    public User findUserById(int id) {
        // data access code
    }
}
```

---

## 📌 4. `@Controller`

* Marks a class as a Spring MVC web controller.

```java
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // returns view name
    }
}
```

---

## 📌 5. `@RestController`

* A shortcut for `@Controller + @ResponseBody`.
* Sends response body directly as JSON or XML.

```java
@RestController
public class ApiController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }
}
```

---

## 🧠 Behind the Scenes

All of these are actually **meta-annotated with `@Component`**, so Spring treats them as beans — but their **semantic meaning** helps organize your app and enable specific features (e.g., AOP, exception handling).

---

Would you like a quick diagram showing how these stereotypes fit into a layered Spring architecture?
