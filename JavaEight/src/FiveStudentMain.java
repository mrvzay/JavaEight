import java.util.*;
import java.util.stream.Collectors;

public class FiveStudentMain {

    public static void main(String[] args) {

        // Initialize the list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 85.5, "Computer Science"),
                new Student("Bob", 22, 90.0, "Mathematics"),
                new Student("Charlie", 19, 70.0, "Computer Science"),
                new Student("David", 23, 88.0, "Physics"),
                new Student("Eve", 21, 95.5, "Mathematics"),
                new Student("Frank", 20, 60.0, "Physics")
        );

        //1. Filter by department
        List<Student> csStudents = students.stream()
                .filter(student -> "Computer Science".equals(student.getDepartment()))
                .collect(Collectors.toList());
        System.out.println("Computer Science Students: " + csStudents);

        //2. Find the student with the highest grade
        Optional<Student> topStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getGrade));
        topStudent.ifPresent(student -> System.out.println("Top student: " + student));

        //3. Calculate the average grade of all students
        OptionalDouble averageGrade = students.stream()
                .mapToDouble(Student::getGrade)
                .average();
        averageGrade.ifPresent(avg -> System.out.println("Average grade: " + avg));

        //4. Group students by department
        Map<String, List<Student>> studentsByDepartment = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        studentsByDepartment.forEach((department, deptStudents) -> {
            System.out.println(department + " : " + deptStudents);
        });

        //5. Count students in each department
        Map<String, Long> countByDepartment = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        countByDepartment.forEach((department, count) -> {
            System.out.println(department + " : " + count);
        });

        //6. Find the youngest student
        Optional<Student> youngestStudent = students.stream()
                .min(Comparator.comparingInt(Student::getAge));
        youngestStudent.ifPresent(student -> System.out.println("Youngest student: " + youngestStudent));

        //7. Convert list of students to a Map with name as key
        Map<String, Student> studentMap = students.stream()
                .collect(Collectors.toMap(Student::getName, student -> student));
        studentMap.forEach((name, student) -> {
            System.out.println(name + " : " + student);
        });

    }
}

class Student {

    private String name;
    private int age;
    private double grade;
    private String department;

    public Student(String name, int age, double grade, String department) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", department='" + department + '\'' +
                '}';
    }
}