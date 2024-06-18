import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        //1. Find list of students whose first name starts with alphabet A
        List<Student> startWithAStudent = list.stream()
                .filter(df -> df.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(startWithAStudent);

        //2. Group the student by department names
        Map<String, List<Student>> mapData = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName));
        System.out.println(mapData);

        //3. Find the total count of student using stream
        long countStudent = list.stream()
                .count();
        System.out.println(countStudent);

        //4. Find the ma age student
        OptionalInt maxAge = list.stream()
                .mapToInt(Student::getAge)
                .max();
        System.out.println(maxAge.getAsInt());

        //5. Find all department names
        List<String> listDepartNames = list.stream()
                .map(Student::getDepartmentName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listDepartNames);

        //6. Find the cont of student in each department
        Map<String, Long> countStudentDepartment = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        countStudentDepartment.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("****");
        //7. Find the list of students whose age is less than 30
        List<Student> listStudent = list.stream()
                .filter(df -> df.getAge() < 30)
                .collect(Collectors.toList());
        System.out.println(listStudent);

        System.out.println("***");
      
        //8. Find the list of students whose rank is in between 50 and 100
        List<Student> listStudentStudent = list.stream()
                .filter(dt -> dt.getRank() > 50 && dt.getRank() < 100)
                .collect(Collectors.toList());
        System.out.println(listStudentStudent);

        //9. Find the average age of male and females students
        Map<String, Double> mapAvgAge = list.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(mapAvgAge);

        //10. Find the department who is having maximum number of students
        Map.Entry<String, Long> entry = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByKey()).get();
        System.out.println(entry);

        //11. Find the students who stays in delhi and sort them by their names
        List<Student> listDelhiStudent = list.stream()
                .filter(dt -> dt.getCity().equals("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
        System.out.println(listDelhiStudent);

        System.out.println("***");
      
        //12. Find the average rank in all departments
        Map<String, Double> collect = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingInt(Student::getRank)));
        System.out.println(collect);
      
        System.out.println("**");
      
        //13. Find the highest rank in each department
        Map<String, Optional<Student>> studentData = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName,
                        Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println(studentData);

        //14. Find the list of students and sort them by their rank
        List<Student> studentRankSorted = list.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .collect(Collectors.toList());
        System.out.println(studentRankSorted);

        System.out.println("****");
        //15. Find the student who has second rank
        Student student = list.stream()
                .sorted(Comparator.comparing(Student::getRank)//.reversed()
                )
                .skip(1)
                .findFirst()
                .get();
        System.out.println(student);


    }
}

class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String departmentName;
    private int joinedYear;
    private String city;
    private int rank;

    public Student(int id, String firstName, String lastName, int age, String gender, String departmentName, int joinedYear, String city, int rank) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.departmentName = departmentName;
        this.joinedYear = joinedYear;
        this.city = city;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getJoinedYear() {
        return joinedYear;
    }

    public void setJoinedYear(int joinedYear) {
        this.joinedYear = joinedYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", joinedYear=" + joinedYear +
                ", city='" + city + '\'' +
                ", rank=" + rank +
                '}';
    }
}
