import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondMain {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //1. Find the average salary of the employee.
        double averageSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println(averageSalary);

        //2. Find the average salary of male and female employees.
        Map<String, Double> averageSalariesByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(averageSalariesByGender.get("Male"));
        System.out.println(averageSalariesByGender.get("Female"));

        //3. Find employees who joined the organization in a specific year.
        List<Employee> employeesInSpecificYear = employeeList.stream()
                .filter(e -> e.getYearOfJoining() == 2013)
                .toList();
        employeesInSpecificYear.forEach(e -> System.out.println(e.getName()));

        //4. Find the highest salary employee.
        Optional<Employee> highestSalaryEmployee = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        highestSalaryEmployee.ifPresent(employee -> {
            System.out.println("Employee with the highest salary: " + employee.getName() +
                    ", Salary: " + employee.getSalary());
        });

        //5. Find the second-highest salary employee.
        Optional<Employee> secondHighestSalaryEmployee = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1) // Skip the first highest salary
                .findFirst();

        secondHighestSalaryEmployee.ifPresent(employee -> {
            System.out.println("Second highest salary employee: " + employee.getName() +
                    ", Salary: " + employee.getSalary());
        });

        //6. How many employees are there in a department ?
        long count = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .count();
        System.out.println(count);

        //7. How many male and female employees are there ?
        // Solution 1:
        long maleCount = employeeList.stream()
                .filter(employee -> employee.getGender().equals("Male"))
                .count();
        System.out.println(maleCount);

        long female = employeeList.stream()
                .filter(employee -> employee.getGender().equals("Female"))
                .count();
        System.out.println(female);

        // Solution 2:
        Map<String, Long> genderCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        genderCount.entrySet().forEach(System.out::println);

        // Solution 3:
        Map<Boolean, Long> genderCounts = employeeList.stream()
                .collect(Collectors.partitioningBy(
                        employee -> employee.getGender().equals("Male"),
                        Collectors.counting()));
        System.out.println("Male : " + genderCounts.get(true));
        System.out.println("Female : " + genderCounts.get(false));

        //8. How many female are there in the sales department ?
        long femaleSalesCount = employeeList.stream()
                .filter(employee -> employee.getGender().equals("Female"))
                .filter(employee -> employee.getDepartment().startsWith("Sales"))
                .count();
        System.out.println(femaleSalesCount);

        //9. Increment the salary of employees in the HR department by 10 percent.
        // Solution 1:
        employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .forEach(employee -> employee.setSalary(employee.getSalary() * 1.10));
        employeeList.forEach(System.out::println);

        System.out.println("****");

        // Solution 2:
        List<Employee> hrEmployee = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .toList();

        hrEmployee.forEach(employee -> employee.setSalary(employee.getSalary() * 1.10));
        employeeList.forEach(System.out::println);

        // Solution 3:
        List<Employee> updatedEmployees = employeeList.stream()
                .map(employee -> {
                    if (employee.getDepartment().equals("HR")) {
                        employee.setSalary(employee.getSalary() * 1.10);
                    }
                    return employee;
                })
                .toList();

        updatedEmployees.forEach(System.out::println);

        //10. Find the nth highest salary employee.
        int n = 3; // Change this to find the nth highest salary
        Optional<Employee> nthHighestSalaryEmployee = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(n - 1)
                .findFirst();

        if (nthHighestSalaryEmployee.isPresent()) {
            System.out.println(n + "th highest salary employee: " + nthHighestSalaryEmployee.get());
        } else {
            System.out.println("There are fewer than " + n + " employees.");
        }

        //11. Find the oldest employee in the organization.
        Optional<Employee> oldestEmployee = employeeList.stream()
//                .max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
                .max(Comparator.comparingInt(Employee::getAge));

        System.out.println(oldestEmployee);

        //12. Find the youngest employee in the organization ?
        Optional<Employee> youngestEmployee = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getAge));
        System.out.println(youngestEmployee);

        //13. Compress a string using the Stream API.
        String input = "aaabbccccdeeeeffff";
//        String compressedString = compressOne(input);
        System.out.println("Compressed string one: " + compressOne(input));
        System.out.println("Compressed string two: " + compressTwo(input));
        System.out.println("Compressed string three: " + compressStreamGroupBy(input));

        //14. Find the minimum and maximum salary of the employee.
        var minSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .min();
        System.out.println(minSalary);

        var naxSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .max();
        System.out.println(naxSalary);

        var summary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println("Minimum Salary: " + summary.getMin());
        System.out.println("Maximum Salary: " + summary.getMax());

        //15. What is diamond problem in java ?

        /*
        The diamond problem arises in object-oriented programming, specifically in languages that support **multiple inheritance**.
        It occurs when a class inherits from two parent classes that share a common ancestor,
         and both parent classes define a method with the same signature (name and parameters).
          This creates ambiguity for the compiler when the inheriting class tries to call that method,
           as it's unclear which implementation should be used.

        Here's a breakdown of the diamond problem in Java:
        **Scenario:**
        1. Class `A` defines a method `sayHello()`.
        2. Class `B` inherits from `A`.
        3. Class `C` inherits from `A`.
        4. Class `D` inherits from both `B` and `C`.

        **Problem:**
        Both `B` and `C` might inherit the `sayHello()` method from `A`. When `D` tries to call `sayHello()`,
         the compiler doesn't know which implementation (from `B` or `C`) to use. This ambiguity leads to a compilation error.
        **Java and Multiple Inheritance:**
        Java **does not** support traditional multiple inheritance due to the diamond problem.
        It allows **single inheritance**, where a class can inherit from only one parent class.
        This avoids the ambiguity caused by the diamond problem.

         **Solutions in Java:**
        1. **Interfaces:** Java uses interfaces to achieve a similar effect to multiple inheritance.
        Interfaces define methods without implementation. Classes can implement multiple interfaces, inheriting the methods from each interface.
         This allows for code reuse and avoids the diamond problem.
        2. **Abstract Classes:** You can use abstract classes to define common functionality and force subclasses to implement specific methods.
         This provides some level of code reuse while maintaining clarity in the inheritance hierarchy.

        By avoiding multiple inheritance, Java prioritizes code clarity and avoids potential ambiguity for developers.

         */
        //16. Explain the concept of Optional and how to use it in java.
        //17. Give a brief explanation of lambda expression in java ?
        //18. What are predefined functional interfaces in java ?
    }

    public static String compressOne(String input) {
        return input.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> entry.getKey() + (entry.getValue() > 1 ? entry.getValue().toString() : ""))
                .collect(Collectors.joining());
    }

    public static String compressTwo(String string) {
        StringBuilder result = new StringBuilder();
        char currChar = string.charAt(0);
        int currCount = 1;
        for (int i = 1; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == currChar) {
                currCount++;
            } else {
                result.append(currCount).append(currChar);
                currChar = c;
                currCount = 1;
            }
        }
        result.append(currCount).append(currChar);
        return result.toString();
    }

    public static String compressStreamGroupBy(String input) {
        return new StringBuilder(input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .toString()
                .replaceAll("\\((.*?)\\)", "$1"))
                .toString();
    }

}
