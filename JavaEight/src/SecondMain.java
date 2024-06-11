import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondMain {

    public static void main(String[] args) {


        //1. Given a list of integers, find out all even numbers that exist in the list using Stream functions?
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 22);

        list.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("****");

        //2. Given a list integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        myList.stream()
                .map(s -> s + " ") // Convert integer to String
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);

        System.out.println("****");

        //3. How to find duplicate elements in a given integers list in java using Stream functions?
        List<Integer> myList1 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> set = new HashSet<>();
        myList1.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);

        System.out.println("****");

        //4. Given the list of integers, find the first element of the list using Stream functions?
        myList1.stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("****");

        //5. Given a list of integers, find the total number of elements present in the list using Stream functions ?
//        long count = myList1.stream()
//                .count();
        long count = myList1.size();
        System.out.println(count);

        System.out.println("****");

        //6. Given a list of integers, find the maximum value element present in it using Stream functions?
        int max = myList1.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);

        System.out.println("****");

        //7. Given a String, find the first non-repeated character in it using Stream functions?

        String input = "Java Articles are Awesome";

        Character result = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then tolowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result);

        System.out.println("****");

        //8. Given a String, find hte first repeated character in it using Stream functions?
        Character result1 = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result1);

        System.out.println("****");

        //9. Given a list of integers, sort all the values present in it using Stream functions?
        myList1.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("****");

        //10. Given a list integers, sort all the values present in it in descending order using Stream functions?
        myList1.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        System.out.println("****");

        //11. Given an integer array nums, return true if nay value appears at least twice in the array, and return false if every element is distinct ?
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));

        System.out.println("****");

        //12. How will you get the current date and time using Java 8 Date and Time API ?
        System.out.println("Current Local Date: " + java.time.LocalDate.now());
        System.out.println("Current Local Time: " + java.time.LocalDateTime.now());
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());

        System.out.println("****");

        //13. Write a Java 8 program to concatenate two Streams ?
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());

        // concatenated the list1 and list2 by converting them into stream

        concatStream.forEach(str -> System.out.print(str + " "));
        System.out.println();

        System.out.println("****");

        //14. Java 8 program to perform cube on list elements and filter numbers greater then 50 ?
        List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
        integerList.stream()
                .map(i -> i * i * i)
                .filter(i -> i > 50)
                .forEach(System.out::println);

        System.out.println("****");

        //15. Write a Java 8 program to sort an array and then covert then sorted array into stream ?
        int arr[] = {99, 55, 203, 99, 4, 91};
        Arrays.parallelSort(arr);

        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("****");

        //16. How to use map to convert object into Uppercase in java 8 ?
        List<String> names = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> nameList = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(nameList);

        System.out.println("****");

        //17. How to convert a list of objects into a map by considering duplicated keys and store themin sorted order?


        //18. How to count each element/word from the String ArrayList in java 8?
        List<String> names1 = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names1
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(namesCount);


        System.out.println("****");

        //19. How to find only duplicate elements with its count from the String ArrayList in Java8?
        List<String> names2 = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount2 = names2
                .stream()
                .filter(x -> Collections.frequency(names2, x) > 1)
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        System.out.println(namesCount2);

        System.out.println("****");

        //20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?


        //21. Write a program to find the Maximum element in an array?
        System.out.println(findMaxElement(new int[]{12, 19, 20, 88, 00, 9}));

        //22. Write a program to print the count of each Character in a String?
        String s = "string data to count each character";
        findCountOfChars(s);

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
                .collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);
    }
}
