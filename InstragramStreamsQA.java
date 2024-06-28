import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InstragramStreamsQA {

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

        List<Movie> movies = Arrays.asList(
                new Movie("The Shawshank Redemption", "Drama"),
                new Movie("The Godfather", "Crime"),
                new Movie("The Dark Knight", "Action"),
                new Movie("Pulp Fiction", "Crime"),
                new Movie("The Lord of the Rings: The Return of the King", "Fantasy"),
                new Movie("Forrest Gump", "Drama")
        );

        List<Person> persons = Arrays.asList(
                new Person("John", "Doe", 25),
                new Person("Jane", "Smith", 30),
                new Person("Max", "Johnson", 40),
                new Person("Emily", "Davis", 35)
        );

        //1. Find the employee with the highest salary from a list of employee objects using streams.
        Optional<Employee> highestPaidEmployee = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaidEmployee.ifPresent(System.out::println);

        //2. Concatenate a list strings into a single string, separated by commas, using streams.
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        String result = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println(result);

        //3. Find the first non-repeating character in a string using streams.
        String input = "swiss";

        Character firstNonRepeatingChar = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(firstNonRepeatingChar); // Output: w

        //4. Filter out movies of a specific genre and collect them into a set using streams.
        String genreToFilter = "Crime";
        Set<Movie> filteredMovies = movies.stream()
                .filter(movie -> movie.getGenre().equals(genreToFilter))
                .collect(Collectors.toSet());

        filteredMovies.forEach(System.out::println);

        //5. Find the first name of the oldest person in a list of persons' objects using streams.
        Optional<Person> oldestPerson = persons.stream()
                .max(Comparator.comparingInt(Person::getAge));

        String oldestFirstName = oldestPerson
                .map(Person::getFistName)
                .orElse(null);

        System.out.println(oldestFirstName);

        //6. Filter out null values from a list of strings using streams.
        List<String> str = Arrays.asList("apple", null, "banana", null, "cherry", "date");

        List<String> filteredStrings = str.stream()
//                .filter(s -> s != null)
                .filter(Objects::nonNull)
                .toList();
        filteredStrings.forEach(System.out::println);

        //7. Find the sum of the squares of a list of integers using streams.
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        int sumOfSquares = integers.stream()
                .mapToInt(i -> i * i)
                .sum();
        System.out.println("Sum of squares: " + sumOfSquares);

        //8. Skip the first 7 elements in a list and then print the rest usings streams.
        List<String> strOneToTen = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        strOneToTen.stream()
                .skip(7)
                .forEach(System.out::println);

        //9. Generate an infinite sequence of random numbers and print the first 10 using streams.
        Random random = new Random();
        Stream.generate(random::nextInt)
                .limit(10)
                .forEach(System.out::println);
//                .forEach(n -> System.out.println(Math.abs(n)));

        //10. Check if any string a list starts with a specific prefix usings streams.
        List<String> strings1 = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        String prefix = "ch";

        boolean anyStartsWithPrefix = strings1.stream()
                .anyMatch(s -> s.startsWith(prefix));
        System.out.println(anyStartsWithPrefix);

        var r = strings1.stream()
                .filter(s -> s.startsWith("c"))
                .collect(Collectors.toList());
        System.out.println(r);

        //11. Merge two lists of integers and remove duplicates using streams.
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);

        Set<Integer> mergedListWithoutDuplicates = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toSet());
        mergedListWithoutDuplicates.forEach(System.out::println);

        //12. Filter a list of numbers to only include those greater than 10 and then find their average.
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        OptionalDouble average = numbers.stream()
                .filter(num -> num > 10)
                .mapToDouble(num -> num) // Convert Integer to double for average.
                .average();

        if (average.isPresent()) {
            System.out.println("Average of number greater then 10: " + average.getAsDouble());
        } else {
            System.out.println("No numbers greater then 10 found.");
        }

        //13. Partition a list of integers into even and odd numbers using streams.
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> evenOddPartition = nums.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        List<Integer> evenNumbers = evenOddPartition.get(true);
        List<Integer> oddNumbers = evenOddPartition.get(false);

        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);

        //14. Collect all unique words form a list of sentences using streams.
        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "Unique words from sentences"
        );

        Set<String> uniqueWords = sentences.stream()
                // Split each sentence into words
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                // Remove duplicates by collecting into a Set
                .collect(Collectors.toSet());

        System.out.println("Unique words: " + uniqueWords);

        //15. Flatten a list of integers into a single list of integers usings streams.
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream) // Flattens each inner list int a single list
                .collect(Collectors.toList());
        System.out.println(flattenedList);

        //16. Convert a list of strings to a map where the key is the string and the value is the length.
        List<String> fruitsNames = Arrays.asList("apple", "banana", "cherry", "date");
        Map<String, Integer> stringLength = fruitsNames.stream()
                .collect(Collectors.toMap(
                        s -> s,
//                        s -> s.length()
                        String::length
                ));
        System.out.println(stringLength);

        //17. Create a stream pipeline to group a list of strings by their length.
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "fig");
        Map<Integer, List<String>> groupingByLength = fruits.stream()
                .collect(Collectors.groupingBy(
                        String::length // Classifier: groups by length of each string
                ));
        groupingByLength.entrySet().forEach(System.out::println);

        //18. Convert a list a strings to a list of their respective lengths using streams.
        List<String> str1 = Arrays.asList("apple", "banana", "cherry", "date", "fig");
        List<Integer> lengths = str1.stream()
                .map(String::length) // Map each string to its length
                .collect(Collectors.toList());
        System.out.println("Lengths of strings: " + lengths);

        //19. Count the number of occurrences of each character in a string using streams.
        String str2 = "hello world";

        // Count occurrences of each character
        Map<Character, Long> charCountMap = str2.chars()
                .mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
                .collect(Collectors.groupingBy(
                        c -> c, // Group by character
                        Collectors.counting() // Count occurrences
                ));
        charCountMap.entrySet().forEach(System.out::println);

        //20. Find the product of all elements in a list of integers using streams.
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);

        // Calculate the product of all elements in the list
        int product = numbers1.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product of all elements: " +  product);
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

class Movie {

    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

class Person {

    private String fistName;
    private String lastName;
    private int age;

    public Person(String fistName, String lastName, int age) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
