Garbage Collection (GC) in programming languages like Java and Python automatically reclaims memory occupied by objects that are no longer reachable. Here are different scenarios where objects become eligible for garbage collection:

### **1. Nullifying References**
   - When an object reference is explicitly set to `null`, the object it referred to becomes unreachable.
   ```java
   Object obj = new Object();  
   obj = null;  // Now the object is eligible for GC
   ```

### **2. Reassigning References**
   - If a reference variable is reassigned to a new object, the previous object (if unreferenced elsewhere) becomes eligible for GC.
   ```java
   Object obj1 = new Object();
   Object obj2 = new Object();
   obj1 = obj2;  // The first object is now eligible for GC
   ```

### **3. Objects Inside a Method**
   - Objects created within a method are eligible for GC once the method completes execution, provided no reference escapes.
   ```java
   void method() {
       Object obj = new Object();  // Eligible for GC after method ends
   }
   ```

### **4. Island of Isolation**
   - When two objects reference each other but are not reachable from any active thread or root reference, they become eligible for GC.
   ```java
   class Test {
       Test t;
   }
   
   Test obj1 = new Test();
   Test obj2 = new Test();
   obj1.t = obj2;
   obj2.t = obj1;

   obj1 = null;
   obj2 = null;  // Both objects are now eligible for GC (island of isolation)
   ```

### **5. Objects Inside Weak References**
   - Weak references (`WeakReference` in Java) allow objects to be garbage collected even if they are still referenced.
   ```java
   WeakReference<Object> weakRef = new WeakReference<>(new Object());
   System.gc();  // The object may be garbage collected
   ```

### **6. Unused Static References**
   - Static references prevent GC, but if a class is unloaded (e.g., in a web application when a class loader is removed), its static variables may be garbage collected.

### **7. Circular References in Non-GC Languages**
   - In languages without automatic garbage collection (like C++), circular references can cause memory leaks unless manually deallocated.

