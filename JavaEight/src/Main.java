import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void HideMain(String[] args) {

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
        getCountOfMaleFemale(employeeList);
//        var result = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//        System.out.println(result);
        System.out.println("***");

        //2. Write a program to print the names of all departments in the organization.
        getDepartmentName(employeeList);
//        employeeList.stream()
//                .map(Employee::getDepartment)
//                .distinct()
//                .forEach(System.out::println);

        System.out.println("***");
        //3. Find the average age of Male and Female Employees?
        getGender(employeeList);
//        var result = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
//        System.out.println(result);

        System.out.println("***");
        //4. Get the names of employees who joined after 2015.
        getNameOfEmp(employeeList);
//        employeeList.stream()
//                .filter(e -> e.getYearOfJoining() > 2015)
//                .map(Employee::getName)
//                .forEach(System.out::println);

        System.out.println("***");
        //5. Count the number of employees in each department ?
        countByDept(employeeList);

        var countByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        Set<Map.Entry<String, Long>> entrySet = countByDept.entrySet();
//        for (Map.Entry<String, Long> entry : entrySet) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        countByDept.forEach((department, count) -> {
            System.out.println(department + " : " + count);
        });

        System.out.println("***");
        //6. Find out the average salary of each department ?
        avgSalary(employeeList);
        var avgSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
//        for (Map.Entry<String, Double> entry : entrySet) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        avgSalary.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("***");
        //7. Find out the oldest employee, his/her age and department ?
        oldestEmp(employeeList);
        Optional<Employee> oldestEmp = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge));
        Employee oldestEmployee = oldestEmp.get();
//        System.out.println(oldestEmployee.getName());
//        System.out.println(oldestEmployee.getAge());
//        System.out.println(oldestEmployee.getSalary());

        System.out.println("***");

        //8. Find out the average and total salary of the organization ?
        getEmpSalary(employeeList);
//        var result = employeeList.stream()
//                .collect(Collectors.summarizingDouble(Employee::getSalary));
//        System.out.println(result.getAverage());
//        System.out.println(result.getSum());

        System.out.println("***");

        //9.List down the employees of each department
        listDownDept(employeeList);

        Map<String, List<Employee>> empList = employeeList.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entrySet = empList.entrySet();
        for (Map.Entry<String, List<Employee>> entry : entrySet) {
            System.out.println("--------------------------------------");
            System.out.println("Employees In " + entry.getKey() + " : ");
            System.out.println("--------------------------------------");
            List<Employee> list = entry.getValue();
            for (Employee e : list) {
                System.out.println(e.getName());
            }
        }
        System.out.println("*****************************************");
        Map<String, List<String>> employeesByDept = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        employeesByDept.forEach((department, employeeNames) -> {
            System.out.println(department + ": " + employeeNames);
        });

        System.out.println("***");
        //10. Find out the highest experienced employees in the organization ?
        seniorEm(employeeList);

    }

    public static void getCountOfMaleFemale(List<Employee> employeeList) {

        Map<String, Long> noOfMaleAndFemaleEmployee =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployee);
    }

    public static void getDepartmentName(List<Employee> employeeList) {

        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
    }

    public static void getGender(List<Employee> employeeList) {
        Map<String, Double> avgAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAge);
    }

    public static void getNameOfEmp(List<Employee> employeeList) {

        employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public static void countByDept(List<Employee> employeeList) {
        Map<String, Long> countByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        Set<Map.Entry<String, Long>> entrySet = countByDept.entrySet();
        for (Map.Entry<String, Long> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void avgSalary(List<Employee> employeeList) {
        Map<String, Double> avgSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
        for (Map.Entry<String, Double> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    public static void oldestEmp(List<Employee> employeeList) {
        Optional<Employee> oldestEmp = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge));
        Employee oldestEmployee = oldestEmp.get();

        System.out.println("Name : " + oldestEmployee.getName());
        System.out.println("Age : " + oldestEmployee.getAge());
        System.out.println("Department : " + oldestEmployee.getDepartment());
    }

    public static void getEmpSalary(List<Employee> employeeList) {
        DoubleSummaryStatistics empSalary = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Average Salary = " + empSalary.getAverage());
        System.out.println("Total Salary = " + empSalary.getSum());
    }

    public static void listDownDept(List<Employee> employeeList) {
        Map<String, List<Employee>> empList = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Set<Map.Entry<String, List<Employee>>> entrySet = empList.entrySet();

        for (Map.Entry<String, List<Employee>> entry : entrySet) {
            System.out.println("---------------------------------------");
            System.out.println("Employees In " + entry.getKey() + " : ");
            System.out.println("---------------------------------------");

            List<Employee> list = entry.getValue();
            for (Employee e : list) {
                System.out.println(e.getName());
            }
        }
    }

    public static void seniorEm(List<Employee> emoloyeeList) {
        Optional<Employee> seniorEmp = emoloyeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

        Employee seniorMostEmployee = seniorEmp.get();

        System.out.println("Senior Most Employee Details :");
        System.out.println("------------------------");
        System.out.println("ID : " + seniorMostEmployee.getId());
        System.out.println("Name : " + seniorMostEmployee.getName());
        System.out.println("Age : " + seniorMostEmployee.getAge());
    }

    public static void main(String[] args) {

        List<SecondEmployee> secondEmployees = Arrays.asList(
                new SecondEmployee("Alice", "HR", 60000),
                new SecondEmployee("Bob", "Engineering", 75000),
                new SecondEmployee("Charlie", "HR", 70000),
                new SecondEmployee("David", "Engineering", 80000),
                new SecondEmployee("Edward", "Sales", 50000)
        );

        //1. Find the highest paid employee
        Optional<SecondEmployee> highestPaid = secondEmployees.stream()
                .max(Comparator.comparingDouble(SecondEmployee::getSalary));
//                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        highestPaid.ifPresent(System.out::println);

        //2. Calculate the average salary by department
        Map<String, Double> avgSalaryByDept = secondEmployees.stream()
                .collect(Collectors.groupingBy(SecondEmployee::getDepartment,
                        Collectors.averagingDouble(SecondEmployee::getSalary)));

        avgSalaryByDept.forEach((dept, avgSalary) ->
                System.out.println(dept + " : " + avgSalary));

        //3. List employees by department
        Map<String, List<SecondEmployee>> employeesByDept = secondEmployees.stream()
                .collect(Collectors.groupingBy(SecondEmployee::getDepartment));

        employeesByDept.forEach((dept, empList) -> {
            System.out.println(dept + " : " + empList);
        });

        //4. Find employees with salary above a threshold 70,000.
        List<SecondEmployee> highEarners = secondEmployees.stream()
                .filter(e -> e.getSalary() > 70000)
                .collect(Collectors.toList());
        highEarners.forEach(System.out::println);

        //5. Get names of all employees in a single string
        String employeeNames = secondEmployees.stream()
                .map(SecondEmployee::getName)
                .collect(Collectors.joining(","));
        System.out.println(employeeNames);




    }
}

class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;
    private double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }
}

class SecondEmployee {

    private String name;
    private String department;
    private double salary;

    public SecondEmployee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "SecondEmployee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}