import java.util.ArrayList;
import java.util.List;

public class Streams {

    public static void main(String[] args) {

        List<Employee> employeeList = getEmployeeList();

//        List<Employee> employeeList1 = getEmployeeList();
//        employeeList.removeIf(g -> g.getbTechPercentage() < 70);
//
//        employeeList.stream()
//                .filter(k -> k.getbTechPercentage() >= 70)
//                .collect(Collectors.toList());
//
//        for (Employee e : employeeList) {
//            System.out.println(e);
//        }
//        System.out.println("----------");
//        for (Employee e : employeeList1) {
//            System.out.println(e);
//        }
//
//
//        int startingPoint = 0;
//
//        for (int i = 0; i < 3; i++) {
//
//            List<Employee> employeeList1 = employeeList.stream()
//                    .skip(startingPoint)
//                    .limit(5)
//                    .collect(Collectors.toList());
//
//            for (Employee e: employeeList1) {
//                System.out.println(e);
//            }
//            System.out.println("-----------------------");
//            startingPoint = startingPoint + 5;
//        }

//        long count = employeeList.stream()
//                .filter(e -> e.getbTechPercentage() >= 70)
//                .count();
//        System.out.println(count);

        String str = "abbade";

//        Map<Object, Long> output = str
//                .chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//        System.out.println(output);
    }

    private static List<Employee> getEmployeeList() {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("1", "a", 90, "ab", "JAVA")); //1
        employeeList.add(new Employee("2", "b", 70, "df", "Python")); //2
        employeeList.add(new Employee("3", "c", 60, "ab", "SQL")); // 3
        employeeList.add(new Employee("4", "d", 30, "df", "JAVA")); // 4
        employeeList.add(new Employee("5", "e", 96, "df", "JAVA")); // 5
        employeeList.add(new Employee("6", "f", 88, "ab", "Redis")); // 6
        employeeList.add(new Employee("7", "g", 82, "df", "Maven")); // 7
        employeeList.add(new Employee("8", "h", 79, "ab", "JAVA")); // 8
        employeeList.add(new Employee("9", "i", 71, "ab", "MBA")); // 9
        employeeList.add(new Employee("10", "j", 60, "gf", "CA")); // 10
        employeeList.add(new Employee("11", "k", 50, "ab", "JAVA")); // 11

        return employeeList;

    }
}

class Employee {

    private String id;
    private String company;
    private int bTechPercentage;
    private String bTechCollege;
    private String technology;

    public Employee(String id, String company, int bTechPercentage, String bTechCollege, String technology) {
        this.id = id;
        this.company = company;
        this.bTechPercentage = bTechPercentage;
        this.bTechCollege = bTechCollege;
        this.technology = technology;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getbTechPercentage() {
        return bTechPercentage;
    }

    public void setbTechPercentage(int bTechPercentage) {
        this.bTechPercentage = bTechPercentage;
    }

    public String getbTechCollege() {
        return bTechCollege;
    }

    public void setbTechCollege(String bTechCollege) {
        this.bTechCollege = bTechCollege;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", company='" + company + '\'' +
                ", bTechPercentage='" + bTechPercentage + '\'' +
                ", bTechCollege='" + bTechCollege + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }
}