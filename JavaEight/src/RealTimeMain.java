
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RealTimeMain {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 60000));
        employees.add(new Employee("Charlie", 70000));
        employees.add(new Employee("David", 60000));
        employees.add(new Employee("Eve", 80000));

        // Create a list of students
        List<Student> students = new ArrayList<>();

        // Initialize student objects and add them to the list
        students.add(new Student("Alice", "female", 1, "New York"));
        students.add(new Student("Bob", "male", 2, "Los Angeles"));
        students.add(new Student("Charlie", "male", 3, "Chicago"));
        students.add(new Student("Diana", "female", 4, "Houston"));
        students.add(new Student("Eve", "female", 5, "Phoenix"));

        // find even numbers from a given array with using java8 or without
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(numbers)
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);

        // find even numbers from a given array with using java8 or without reverse order

        // Find even numbers
        int[] evens = new int[numbers.length];
        int index = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evens[index++] = number;
            }
        }

        // Print even numbers in reverse order
        System.out.print("Even numbers in reverse order: ");
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(evens[i] + " ");
        }
        System.out.println();

        // Using Streams
        int[] evensStream = Arrays.stream(numbers)
                .filter(num -> num % 2 == 0)
                .boxed() // Convert int to Integer for reverse order
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();

        // Print even numbers in reverse order
        System.out.print("Even numbers in reverse order: ");
        Arrays.stream(evensStream).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // get maximum number from given array
        int[] numbers1 = {10, 4, 7, 21, 8, 12, 15};

        // Initialize max with the first element
        int max = numbers1[0];

        // Iterate through the array to find the maximum number
        for (int i = 1; i < numbers1.length; i++) {
            if (numbers1[i] > max) {
                max = numbers1[i];
            }
        }

        System.out.println("Maximum number in the array: " + max);

        int[] numbers1Streams = {10, 4, 7, 21, 8, 12, 15};
        // Using java 8 streams to find the maximum number
        int maxStream = Arrays.stream(numbers1Streams)
                .max()
                .getAsInt();
        System.out.println("Maximum number in the array: " + maxStream);

        // get second maximum number from given array
        int[] numbersMaximum = {10, 4, 7, 21, 8, 12, 15};

        // initialize max and secondMax wih lowest possible value
        int maxValue = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        // Iterate through the array to find the second maximum number
        for (int number : numbersMaximum) {
            if (number > maxValue) {
                secondMax = maxValue;
                maxValue = number;
            } else if (number > secondMax && number != maxValue) {
                secondMax = number;
            }

            // Output the second maximum number
            System.out.println("Second maximum number in the array: " + secondMax);

            // Using java 8 Streams to find the second maximum number
            int secondMaxStream = Arrays.stream(numbersMaximum)
                    .distinct() // Remove duplicates (optional)
                    .sorted() // Sort the stream
                    .skip(numbersMaximum.length - 2) // Skip to the second last element
                    .findFirst() // Get the first element, which is the second maximum
                    .orElseThrow(() -> new RuntimeException("Array is empty or has less then two elements"));

            // Output the second maximum number
            System.out.println("Second maximum number in the array: " + secondMaxStream);
        }

        //  separate even number first position and odd numbers last position from the given array.
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            // Move left pointer until finding an odd number
            while (numbers[left] % 2 == 0 && left < right) {
                left++;
            }

            // Move right pointer until finding an even number
            while (numbers[right] % 2 != 0 && left < right) {
                right--;
            }

            // Swap the elements at left and right pointers
            if (left < right) {
                int temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
                left++;
                right--;
            }
        }

        // Print the modified array
        System.out.print("Array with even numbers first and odd numbers last: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] array = {3, 2, 5, 8, 7, 4, 1, 6};

        List<Integer> sortedList = Stream.concat(
                Arrays.stream(array).filter(x -> x % 2 == 0).boxed(),
                Arrays.stream(array).filter(x -> x % 2 != 0).boxed()
        ).toList();

        int[] sortedArray = sortedList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(sortedArray));

        // Collectors.partitioningBy
        Integer[] array1 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};

        // Using Collectors.partitioningBy
        Map<Boolean, List<Integer>> partitioned = Arrays.stream(array1)
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        List<Integer> result = Stream.concat(partitioned.get(true).stream(), partitioned.get(false).stream())
                .collect(Collectors.toList());
        System.out.println(result);

        // Collectors.groupingBy
        // Using Collectors.groupingBy
        Map<Boolean, List<Integer>> grouped = Arrays.stream(array1)
                .collect(Collectors.groupingBy(num -> num % 2 == 0));

        List<Integer> result1 = grouped.get(true);
        result1.addAll(grouped.get(false));
        System.out.println(result1);

        // get count the duplicate numbers from the given int array

        int[] arrayDuplicates = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};

        // Using a HashMap to count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arrayDuplicates) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        /// Counting duplicates
        int duplicateCount = 0;
        for (int count : frequencyMap.values()) {
            if (count > 1) {
                duplicateCount++;
            }
        }
        System.out.println("Number of duplicate elements: " + duplicateCount);

        // With streams
        Integer[] arrayDuplicateStream = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        // Using Streams to count frequencies and find duplicates
        Map<Integer, Long> frequencyMapStream = Arrays.stream(arrayDuplicateStream)
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        long duplicateCountStream = frequencyMapStream.values().stream()
                .filter(count -> count > 1)
                .count();
        System.out.println(duplicateCountStream);

        //  get count the duplicate String from the given string array
        // ************** same above solutions just replace String arrays ****************  ///
        String[] fruits = {"apple", "banana", "apple", "orange", "banana", "apple"};
        // Using  a HashMap to count frequencies
        Map<String, Integer> frequencyMapString = new HashMap<>();
        for (String str : fruits) {
            frequencyMapString.put(str, frequencyMapString.getOrDefault(str, 0) + 1);
        }

        // Counting duplicates
        int duplicateCountFruits = 0;
        for (int count : frequencyMapString.values()) {
            if (count > 1) {
                duplicateCountFruits++;
            }
        }
        System.out.println("Number of duplicate elements: " + duplicateCountFruits);

        // Streams
        String[] fruitsStringStreams = {"apple", "banana", "apple", "orange", "banana", "apple"};

        Map<String, Long> fruitsFrequencyMapStream = Arrays.stream(fruitsStringStreams)
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()));

        long fruitsDuplicateCount = fruitsFrequencyMapStream.values().stream()
                .filter(count -> count > 1)
                .count();

        System.out.println("Number of duplicate elements: " + fruitsDuplicateCount);

        //  get count the duplicate char from the given characters from given string array
        String[] charArrayFruits = {"apple", "banana", "apple", "orange", "banana", "apple"};

        // Using a HashMap to count frequencies of characters
        Map<Character, Integer> frequencyMapChar = new HashMap<>();
        for (String str : charArrayFruits) {
            for (char ch : str.toCharArray()) {
                frequencyMapChar.put(ch, frequencyMapChar.getOrDefault(ch, 0) + 1);
            }
        }

        /// Counting duplicates
        int duplicateCharCount = 0;
        for (int count : frequencyMapChar.values()) {
            duplicateCharCount++;
        }
        System.out.println("Number of duplicate characters: " + duplicateCharCount);

        // With streams
        String[] fruitsCharStream = {"apple", "banana", "apple", "orange", "banana", "apple"};

        // Using Streams to count frequencies and find duplicates
        Map<Character, Long> frequencyMapCharStreams = Arrays.stream(fruitsCharStream)
                .flatMapToInt(String::chars) // Converts each string to an IntStream of characters
                .mapToObj(c -> (char) c) // Converts the IntStream to a stream of characters
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        long fruitsCharDuplicateCountStream = frequencyMapCharStreams.values().stream()
                .filter(count -> count > 1)
                .count();
        System.out.println("Number of duplicate characters: " + fruitsCharDuplicateCountStream);

        //  get the second height salary from given Employee list.
//        if (employees.size() < 2) {
//            System.out.println("Not enough employees to determine the second-highest salary. ");
//            return;
//        }
//
//        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
//
//        double highestSalary = employees.getFirst().getSalary();
//        for (Employee employee : employees) {
//            if(employee.getSalary() < highestSalary){
//                System.out.println("Second highest salary is : " + employee.getSalary());
//                return;
//            }
//        }
//        System.out.println("There is no distinct second-highest salary");

        // With streams
        OptionalDouble secondHighestSalaryStream = employees.stream()
                .mapToDouble(Employee::getSalary)
                .distinct()
                .sorted()
                .skip(employees.size() > 1 ? employees.size() - 2 : 0)
                .findFirst();

        if (secondHighestSalaryStream.isPresent()) {
            System.out.println("Second highest salary is : " + secondHighestSalaryStream);
        } else {
            System.out.println("There is no distinct second highest salary.");
        }

        //  Get the max height salary from a given Employee list.
        if (employees.isEmpty()) {
            System.out.println("The employee list is empty.");
        }

        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        System.out.println("Maximum salary is: " + maxSalary);

        // Streams
        OptionalDouble maxSalaryStream = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max();

        if (maxSalaryStream.isPresent()) {
            System.out.println("Maximum salary is : " + maxSalaryStream.getAsDouble());
        } else {
            System.out.println("The employee list is empty.");
        }

        //  sort the employee details using employee salary
        // Sort employees by salary
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        });

        // Print sorted employees
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("-----------------");
        // Streams
        // Sort employees by salary using streams
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .toList();

        // Print sorted employees
        sortedEmployees.forEach(System.out::println);

        //  sort the employee details using employee name
        // Sort employees by name
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });

        // Print sorted employees
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Streams
        // Sort employees by name using streams
        List<Employee> sortedEmployeesStream = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();

        // Print sorted employees
        sortedEmployeesStream.forEach(System.out::println);

        //  int a[]={20,12,10,3,4,2};
        //  int b[]={9,6,3,2,1};
        //  combine both the int arrays and display in sorting order
        int[] a = {20, 12, 10, 3, 4, 2};
        int[] b = {9, 6, 3, 2, 1};

        // Combine both arrays
        int[] combined = new int[a.length + b.length];
        System.arraycopy(a, 0, combined, 0, a.length);
        System.arraycopy(b, 0, combined, a.length, b.length);

        // Sort the combined array
        Arrays.sort(combined);

        // Print sorted combined array
        System.out.println("Sorted Combined Array: " + Arrays.toString(combined));

        // Streams
        int[] a1 = {20, 12, 10, 3, 4, 2};
        int[] b1 = {9, 6, 3, 2, 1};

        // Combine both arrays and sort using streams
        int[] combinedAndSorted = IntStream.concat(Arrays.stream(a1), Arrays.stream(b1))
                .sorted()
                .toArray();

        // Print sorted combined array
        System.out.println("Sorted Combined Array: " + Arrays.toString(combinedAndSorted));

        //  Rotate the last two integers to the first position in a given array
        int[] arr = {1, 2, 3, 4, 5, 6};
        arr = rotateLastTwoToFirst(arr);
        System.out.println(Arrays.toString(arr));

        // Calculate a sum in given an array
        int[] sumArr = {1, 2, 3, 4, 5, 6};
        int sum = 0;
        for (int n : sumArr) {
            sum += n;
        }
        System.out.println(sum);

        // Streams
        int sumStream = Arrays.stream(sumArr).sum();
        System.out.println(sumStream);

        // Even calculated only a number sum in a given array
        int[] evenSum = {1, 2, 3, 4, 5, 6};
        int resultEvenSum = 0;
        for (int n : evenSum) {
            if (n % 2 == 0) {
                resultEvenSum += n;
            }
        }
        System.out.println(resultEvenSum);

        // Streams
        int evenSumStreams = Arrays.stream(evenSum)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println(evenSumStreams);

        //  Give me a number of female and male students.
        var genderCount = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        genderCount.entrySet().forEach(System.out::println);

        // Give me students who live in New York.
        var newYorkLive = students.stream()
                .filter(n -> n.getCity().equalsIgnoreCase("new york"))
                .toList();
        System.out.println(newYorkLive);

        //  Find out who is holding first rank
        students.add(new Student("Alice", "female", 1, "New York"));
        students.add(new Student("Bob", "male", 2, "Los Angeles"));
        students.add(new Student("Charlie", "male", 3, "Chicago"));
        students.add(new Student("Diana", "female", 4, "Houston"));
        students.add(new Student("Eve", "female", 5, "Phoenix"));

        var firstRank = students.stream()
                .filter(student -> student.getRank() == 1)
                .findFirst();
        System.out.println(firstRank);

        // Find duplicates in List<Integer> numbers = Arrays.asList(new Integer[]{1,2,1,3,4,4});
        List<Integer> nums = Arrays.asList(1, 2, 1, 3, 4, 4);
        var duplicatesSet = nums.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(duplicatesSet);

        // Find missing elements from the given array.
        List<Integer> missingNumbers = Arrays.asList(1, 2, 4, 6);
        int maxElement = 6; // Assuming 6 is the maximum element that should be in the array

        Set<Integer> missingElements = IntStream.rangeClosed(1, maxElement)
                .boxed()
                .filter(n -> !missingNumbers.contains(n))
                .collect(Collectors.toSet());
        System.out.println("Missing elements: " + missingElements);

        // Get fibonacci series from given number
        int maxFibonacci = 30; // Change this to your desired maxium number

        List<Integer> fibonacciSeries = Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .map(fib -> fib[0])
                .takeWhile(n -> n <= maxFibonacci)
                .toList();
        System.out.println("Fibonacci series up to " + maxFibonacci + " : " + fibonacciSeries);

        // Another way
        int number = 10; // The number up to which Fibonacci series is to be generated

        System.out.println("Fibonacci series up to " + number + " terms:");
        for (int i = 0; i < number; i++) {
            System.out.print(fibonacci(i) + " ");
        }

    // prime number from given number
        int primeNumber = 50; // The number up to which prime numbers are to be found

        System.out.println("Prime numbers up to " + primeNumber + ":");
        for (int i = 2; i <= primeNumber; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

    // Given int array find number which staring with 1 number
        int[] oneStartNumbers = {123, 45, 176, 81, 102, 19};

        System.out.println("Numbers starting with 1:");
        Arrays.stream(oneStartNumbers)
                .filter(num -> String.valueOf(num).startsWith("1"))
                .forEach(System.out::println);

    // Write sample program for rest API controller.
    }

    public static int[] rotateLastTwoToFirst(int[] arr) {
        if (arr.length < 2) {
            return arr; // If the array has fewer than 2 elements, no change is needed.
        }

        int n = arr.length;
        int[] result = new int[n];

        // Copy the last two elements to the beginning of the new array
        result[0] = arr[n - 2];
        result[1] = arr[n - 1];

        // Copy the rest of the elements
        for (int i = 0; i < n - 2; i++) {
            result[i + 2] = arr[i];
        }

        return result;
    }

    public static int[] rotateLastTwoToFirstStreams(int[] arr) {
        if (arr.length < 2) {
            return arr; // If the array has fewer than 2 elements, no change is needed.
        }

        int n = arr.length;

        // Create a new array that starts with the last two elements of the original array
        int[] result = IntStream.concat(
                IntStream.of(arr[n - 2], arr[n - 1]), // Stream of the last two elements
                IntStream.range(0, n - 2).map(i -> arr[i]) // Stream of the rest of the elements
        ).toArray();

        return result;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

//    public static int fibonacci(int n) {
//        if (n <= 1) {
//            return n;
//        }
//
//        int a = 0, b = 1;
//        int c;
//        for (int i = 2; i <= n; i++) {
//            c = a + b;
//            a = b;
//            b = c;
//        }
//        return b;
//    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Student {
    private String name;
    private String gender;
    private int rank;
    private String city;

    // Constructor
    public Student(String name, String gender, int rank, String city) {
        this.name = name;
        this.gender = gender;
        this.rank = rank;
        this.city = city;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getRank() {
        return rank;
    }

    public String getCity() {
        return city;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // toString method for printing the student details
    @Override
    public String toString() {
        return "Student{name='" + name + "', gender='" + gender + "', rank=" + rank + ", city='" + city + "'}";
    }
}
