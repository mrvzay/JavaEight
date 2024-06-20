package employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeMain {

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

        //1. Find out the count of male and female employees present in the organization?
        var femaleAndMaleCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Male : " + femaleAndMaleCount.getOrDefault("Male", 0L));
        System.out.println("Female : " + femaleAndMaleCount.getOrDefault("Female", 0L));

        //2. Write a program to print the names of all departments in the organization.
        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        //3. Find the average age of Male and Female Employees?
        var ageAverageGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(ageAverageGender);

        //4. Get the names of employees who joined after 2015.
        employeeList.stream()
                .filter(f -> f.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);

        //5. Count the number of employees in each department ?
        var countByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

//        Set<Map.Entry<String, Long>> entrySet = countByDept.entrySet();
//        for (Map.Entry<String, Long> entry : entrySet) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        countByDept.forEach((key, value) -> System.out.println(key + " : " + value));

        //6. Find out the average salary of each department ?
        var averageEachDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
//        for (Map.Entry<String, Double> entry : entrySet) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        averageEachDepartment.forEach((key, value) -> System.out.println(key + " : " + value));

        //7. Find out the oldest employee, his/her age and department?
        var oldest = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge));
//        Employee oldestEmployee = oldest.get();
//        System.out.println(oldestEmployee.getName());
//        System.out.println(oldestEmployee.getAge());
//        System.out.println(oldestEmployee.getSalary());
        System.out.println(oldest);

        //8. Find out the average and total salary of the organization ?
        var averageTotalSalary = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(averageTotalSalary.getAverage());
        System.out.println(averageTotalSalary.getSum());

        // Calculate the total salary
        double totalSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        // Calculate the average salary
        OptionalDouble averageSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average();

        System.out.println("Total : " + totalSalary);
        System.out.println("Average : " + averageSalary);

        //9.List down the employees of each department
        Map<String, List<Employee>> empList = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

//        Set<Map.Entry<String, List<Employee>>> entrySet = empList.entrySet();
//        for (Map.Entry<String, List<Employee>> entry : entrySet) {
//            System.out.println("------------------------");
//            System.out.println("Employees In " + entry.getKey() + " : ");
//            System.out.println("------------------------");
//            List<Employee> list = entry.getValue();
//            for (Employee e : list) {
//                System.out.println(e.getName());
//            }
//    }
        empList.forEach((key, value) -> {
            System.out.println("--------------------");
            System.out.println(key);
            System.out.println("--------------------");
            value.forEach(value1 -> System.out.println(value1.getName() + " "));
        });

        System.out.println("******************************");
        Map<String, List<String>> employeesByDept = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        employeesByDept.forEach((department, employeeNames) -> {
            System.out.println(department + " : " + employeeNames);
        });

        //10. Find out the highest experienced employees in the organization ?
        var seniorEmp = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                .findFirst();

        Employee seniorMostEmployee = seniorEmp.get();
        System.out.println("Senior most employee details : ");
        System.out.println("-------------------------------");
        System.out.println("ID : " + seniorMostEmployee.getId());
        System.out.println("Name : " + seniorMostEmployee.getName());
        System.out.println("Age : " + seniorMostEmployee.getAge());

        //1. Find the highest paid employee
        Optional<Employee> highestPaid = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaid.ifPresent(System.out::println);

        //2. Calculate the average salary by department
        var calculateEachDepartmentAvg = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        System.out.println(calculateEachDepartmentAvg);
        calculateEachDepartmentAvg.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });

        //3. List employees by department
        Map<String, List<Employee>> listDep = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        listDep.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("---------------");
            v.forEach(System.out::println);
            System.out.println();
        });

        //4. Find employees with salary above a threshold 70,000.
        var threshHoldSalary = employeeList.stream()
                .filter(df -> df.getSalary() > 70000)
                .collect(Collectors.toList());
        System.out.println(threshHoldSalary);

        //5. Get names of all employees in a single string
        var employeeNames = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(employeeNames);

        // names of the employee whose salary greater than 50000
        var namesAbove50k = employeeList.stream()
                .filter(df -> df.getSalary() > 50000)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(namesAbove50k);

        // grouping the employees by their department
        var groupingDepartments = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(groupingDepartments);
        groupingDepartments.forEach((k, v) -> {
            System.out.println("---------------");
            System.out.println(k);
            System.out.println("---------------");
            v.forEach(System.out::println);
        });

        System.out.println("**");
        // the highest salary of the employee name
        var highestSalaryEmp = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .get();
        System.out.println(highestSalaryEmp);

        /*
        // Find the employee with the highest salary
        Optional<Employee> highestSalaryEmployee = employees.stream()
                .reduce((emp1, emp2) -> emp1.getSalary() > emp2.getSalary() ? emp1 : emp2);

        // Print the name of the employee with the highest salary
        highestSalaryEmployee.ifPresent(emp -> System.out.println("Employee with highest salary: " + emp.getName()));

 // Find the employee with the highest salary
        Employee highestSalaryEmployee = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                        Optional::get
                ));

        // Print the name of the employee with the highest salary
        System.out.println("Employee with highest salary: " + highestSalaryEmployee.getName());

         // Find the employee with the highest salary
        Employee highestSalaryEmployee = employees.stream()
                .sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()))
                .findFirst()
                .orElse(null);

        // Print the name of the employee with the highest salary
        if (highestSalaryEmployee != null) {
            System.out.println("Employee with highest salary: " + highestSalaryEmployee.getName());
        }
        */

        // the highest salary of the employee name in each department
        var eachDepartHighSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(eachDepartHighSalary);
        eachDepartHighSalary.forEach((k, v) -> System.out.println(k + " : " + v));

//        Map<String, Employee> highestSalaryEmployeesByDept = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.collectingAndThen(
//                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
//                                Optional::get
//                        )));

        Map<String, Employee> highestSalaryEmployeesByDept = employeeList.stream()
                .collect(Collectors.toMap(Employee::getDepartment, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        highestSalaryEmployeesByDept.forEach((department, employee) -> {
            System.out.println("Department: " + department + ", Employee with highest salary: " + employee.getName());
        });

        // average salary of the employees in each department
        Map<String, Double> averageSalaryByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble((Employee::getSalary))));
        System.out.println(averageSalaryByDept);
        averageSalaryByDept.forEach((department, avgSalary) -> {
            System.out.println("Department: " + department + ", Average Salary: " + avgSalary);
        });

        // average salary of all employees
        var averageSalaryAllEmployees = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average();
        averageSalaryAllEmployees.ifPresent(System.out::println);

        // GPT - 4
        // Filter employees by age
        var byAge = employeeList.stream()
                .filter(emp -> emp.getAge() >= 25 && emp.getAge() < 30)
                .collect(Collectors.toList());
        System.out.println(byAge);

        // Sort employee by name
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)// If you want names only this line.
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }

}

