import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegersStreams {

    public static void main(String[] args) {

        // 1. Given a list integers, find out all the even numbers that exist in the list suing stream functions ?
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        list.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("***");

        // 2. Given a list integers, find out all the numbers starting with 1 using Stream functions ?
        list.stream()
                .map(s -> s + "") // Convert integer to String
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);

        System.out.println("***");

        // 3. How to find duplicate elements in a given integers list in java using Stream functions ?
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> set = new HashSet<>();
        myList.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);

        System.out.println("***");

        //4. Given the list of integers, find the first element of the list using Stream functions?
        myList.stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("***");

        //5. Given a list integers, find the total number of elements present in the list using stream functions ?
        long count = myList.stream()
                .count();
        System.out.println(count);

        System.out.println("***");

        //5. Given a list integers, find the maximum value element present in it using stream functions?
        int max = myList.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);

        System.out.println("***");

        //7. Given a String, find the list non-repeated character in it using stream functions?

        String input = "Java Articles are Awesome";

        Character result = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase((char) s)) // First covert to Character object and then to lowercase
//                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
//                .map(entry -> entry.getKey())
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(result);

        System.out.println("***");
        //8. Given a String, find the first repeated character in it using stream functions?
        Character result1 = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result1);

        System.out.println("***");

        //9. Given a list of integers, sort all the present in it using Stream functions?
        myList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("***");

        //10. Given a list integers, sort all the values present in it in descending order using Stream functions?
        myList.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        System.out.println("***");

        //11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));

        System.out.println("***");

        //12. How will you get current data and time using Java 8 Date and Time API?
        System.out.println("Current Local Date: " + java.time.LocalDate.now());
        //Used LocalDate API to get the date
        System.out.println("Current Local Time: " + java.time.LocalTime.now());
        //Used LocalTime API to get the time
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
        //Used LocalDateTime API to get both date and time

        System.out.println("***");
        //13. Write a Java 8 program to concatenate two Streams?
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());

        // Concatenated the list1 and list2 by converting them into Stream
        concatStream.forEach(str -> System.out.print(str + " "));

        System.out.println("***");

        //14. Java 8 program to perform cube on list elements and filter numbers greater than 50.
        List<Integer> intergerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
        intergerList.stream()
                .map(i -> i * i * i)
                .filter(i -> i > 50)
                .forEach(System.out::println);

        System.out.println("***");

        //15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
        int[] arr = {99, 55, 203, 99, 4, 91};
        // Sorted the Array using parallelSort
        Arrays.parallelSort(arr);

        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("***");

        //16. How to use map to convert object into Uppercase in Java 8?
        List<String> names = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> nameList = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(nameList);

        System.out.println("***");

        //17.

        //18. How to count each element/word from the String ArrayList in Java8?
        List<String> names1 = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names1
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(namesCount);

        System.out.println("***");

        //19. How to find only duplicate elements with its count from the String ArrayList in java8?
        Map<String, Long> namesCount1 = names1
                .stream()
                .filter(x -> Collections.frequency(names1, x) > 1)
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        System.out.println(namesCount1);

        System.out.println("***");

        //21. Write a program to find the maximum element in an Array ?
        System.out.println(findMaxElement(new int[]{12, 19, 20, 88, 00, 9}));

        System.out.println("***");

        //22. Write a program to print the count of each character in a String?
        String s = "string data to count each character";
        findCountOfChars(s);
        System.out.println(s);

    }

    public static boolean containsDuplicate(int[] nums) {

        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .toList();

        Set<Integer> set = new HashSet<>(list);
        if (set.size() == list.size()) {
            return false;
        }
        return true;
    }

    public static int findMaxElement(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public static void findCountOfChars(String s) {
        Map<String, Long> map = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors
                        .groupingBy(str -> str,
                                LinkedHashMap::new, Collectors.counting()));
    }
}

