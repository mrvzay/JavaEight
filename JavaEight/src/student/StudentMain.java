package student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentMain {

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

        //1. Find a list of students whose first name starts with alphabet A
        list.stream()
                .filter(df -> df.getFirstName().startsWith("A"))
                .toList()
                .forEach(System.out::println);

        //2. Group the student by department names
        Map<String, List<Student>> mapDep = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName));
        mapDep.forEach((k, v) -> System.out.println(k + " : " + v));

        //3. Find the total count of a student using stream
        long countStudent = list.stream().count();
//        long countStudent = list.size();
        System.out.println(countStudent);

        //4. Find a max age student
        var maxAge = list.stream()
                .max(Comparator.comparing((Student::getAge)))
                .get();
        System.out.println(maxAge);

        var max2 = list.stream()
                .mapToInt(Student::getAge)
                .max();
        System.out.println(max2);

        //5. Find all department names
        var allDepartmentNames = list.stream()
                .map(Student::getDepartmentName)
                .distinct()
                .toList();
        System.out.println(allDepartmentNames);

        //6. Find the cont of student in each department
        var countDepartmentEach = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        countDepartmentEach.forEach((k, v) -> System.out.println(k + " : " + v));

        //7. Find the list of students whose age is less than 30
        var lessThan30Age = list.stream()
                .filter(df -> df.getAge() < 30)
                .collect(Collectors.toList());
        lessThan30Age.forEach(System.out::println);

        System.out.println("***");
        //8. Find the list of students whose rank is in between 50 and 100
        var listStudentWithInLimit = list.stream()
                .filter(df -> df.getRank() > 50 && df.getRank() < 100)
                .collect(Collectors.toList());
        listStudentWithInLimit.forEach(System.out::println);

        //9. Find the average age of male and females students
        var averageFMStudents = list.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getAge)));
        averageFMStudents.forEach((k, v) -> System.out.println(k + " : " + v));

        //10. Find the department having the maximum number of students

        Map.Entry<String, Long> entry = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();

        System.out.println(entry);

//        Map.Entry<String, Long> entry = list.stream()
//                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()))
//                .entrySet().stream()
//                .collect(Collectors.maxBy(Map.Entry.comparingByValue()))
//                .get();
//
//        System.out.println(entry);

//        Map<String, Long> departmentCount = new HashMap<>();
//
//        list.forEach(student ->
//                departmentCount.merge(student.getDepartmentName(), 1L, Long::sum)
//        );
//
//        Map.Entry<String, Long> entry = departmentCount.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .get();
//
//        System.out.println(entry);

//        Map<String, Long> departmentCount = list.stream()
//                .collect(Collectors.toMap(
//                        Student::getDepartmentName,
//                        student -> 1L,
//                        Long::sum
//                ));
//
//        Map.Entry<String, Long> entry = departmentCount.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .get();
//
//        System.out.println(entry);

        //11. Find the students who stay in delhi and sort them by their names
        var studentDelhi = list.stream()
                .filter(df -> df.getCity().equals("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
        System.out.println(studentDelhi);

        //12. Find the average rank in all departments
        var averageDepartment = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingInt(Student::getRank)));
        averageDepartment.forEach((k, v) -> System.out.println(k + " : " + v));

        //13. Find the highest rank in each department
        var studentData = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName,
                        Collectors.minBy(Comparator.comparing(Student::getRank))));
        studentData.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("**");
        //14. Find the list of students and sort them by their rank
        var studentRankSorted = list.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .collect(Collectors.toList());
        studentRankSorted.forEach(System.out::println);

        //15. Find the student who has second rank
        Student student = list.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1)
                .findFirst()
                .get();
        System.out.println(student);

        //1. Filter by department
        var ceStudent = list.stream()
                .filter(s -> "Computer Engineering".equals(s.getDepartmentName()))
                .toList();
        System.out.println("Computer Engineering students : " + ceStudent);
        ceStudent.forEach(System.out::println);

        System.out.println("**");
        //2. Find the student with the highest grade
        Optional<Student> topStudent = list.stream()
                .max(Comparator.comparingDouble(Student::getRank));
        topStudent.ifPresent(System.out::println);

        //3. Calculate the average grade of all students
        var averageRank = list.stream()
                .mapToDouble(Student::getRank)
                .average();
        averageRank.ifPresent(System.out::println);

        //4. Group students by department
        var studentsByDepartment = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName));
        studentsByDepartment.forEach((k, v) -> System.out.println(k + " : " + v));
        //5. Count students in each department
        var countByDepartment = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        countByDepartment.forEach((k, v) -> System.out.println(k + " : " + v));

        //6. Find the youngest student
        var youngestStudent = list.stream()
                .min(Comparator.comparingInt(Student::getAge));
        youngestStudent.ifPresent(System.out::println);

        //7. Convert a list of students to a Map with name as a key
        var studentMap = list.stream()
                .collect(Collectors.toMap(Student::getFirstName, s -> s));
        studentMap.forEach((k, v) -> System.out.println(k + " : " + v));


    }
}