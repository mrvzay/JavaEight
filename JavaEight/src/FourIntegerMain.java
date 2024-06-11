import java.util.*;
import java.util.stream.Collectors;

public class FourIntegerMain {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: " + sum);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Sum of even numbers
        int sumEven = numbers1.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        // Sum of odd numbers
        int sumOdd = numbers1.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of even numbers: " + sumEven);
        System.out.println("Sum of odd numbers: " + sumOdd);

        // Filter even numbers
        numbers1.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // Filter odd numbers
        numbers1.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // Filter even numbers and then find max value
        Optional<Integer> maxEven = numbers1.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo);
        maxEven.ifPresentOrElse(
                max -> System.out.println("Maximum even number: " + max),
                () -> System.out.println("No even numbers found")
        );

        //2. Find the maximum integer in the list
        Optional<Integer> max = numbers1.stream()
                .max(Integer::compareTo);
        max.ifPresent(maxValue -> System.out.println("Max: " + maxValue));

        //3. Find the minimum integer in the list
        Optional<Integer> min = numbers1.stream()
                .min(Integer::compare);
        min.ifPresent(maxValue -> System.out.println("Min: " + maxValue));

        //4. Find the average of all integers in the list
        OptionalDouble average = numbers1.stream()
                .mapToInt(Integer::intValue)
                .average();

        average.ifPresent(avg -> System.out.println("Average: " + avg));

        //5. Count the number even integers in the list
        long count = numbers1.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Number of even integers: " + count);

        //6. Convert all integers to their squares
        List<Integer> squares = numbers1.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        //7. Remove duplicates from the list
        List<Integer> numbers2 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = numbers2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique numbers: " + uniqueNumbers);

        //8. Sort the list of integers
        List<Integer> numbers3 = Arrays.asList(5, 3, 1, 4, 2);
        List<Integer> sortedNumbers = numbers3.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted numbers: " + sortedNumbers);

        //9. Find the second-largest integer in the list
        Optional<Integer> secondLargest = numbers1.stream()
                .sorted((a, b) -> b - a) // Sort in descending order
                .skip(1) // Skip the first element
                .findFirst(); // Get the second element

        secondLargest.ifPresent(value -> System.out.println("Second largest: " + secondLargest));

        //10. Find the frequency of each integer in the list
        List<Integer> numbers4 = Arrays.asList(1, 2, 2, 2, 3, 3, 4, 4, 4, 4);
        Map<Integer, Long> frequencyMap = numbers4.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        frequencyMap.forEach((number, nCont) -> System.out.println(number + " : " + nCont));

    }
}
