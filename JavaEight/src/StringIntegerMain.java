import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringIntegerMain {

    public static void main(String[] args) {

        //1. Given a list of integers, find out all even numbers that exist in the list using Stream functions?
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 22);

        list.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        //2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        list.stream()
                .map(s -> s + " ") // Convert integer to String
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);

        //3. How to find duplicate elements in a given integers list in java using Stream functions?
        List<Integer> list1 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        Set<Integer> set = new HashSet<>();
        list1.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);

        //4. Given the list of integers, find the first element of the list using Stream functions?
        list1.stream()
                .findFirst()
                .ifPresent(System.out::println);

        //5. Given a list of integers, find the total number of elements present in the list using Stream functions?
//        long count = list1.stream().count();
        long count = list1.size();
        System.out.println(count);

        //6. Given a list of integers, find the maximum value element present in it using Stream functions?
        int max = list1.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);

        //7. Given a String, find the first non-repeated character in it using Stream functions?
        String input = "Java Articles are Awesome";

        Character result = input.chars()
//                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .mapToObj(s -> Character.toLowerCase((char) s)) // First convert to a Character object and then lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Store the chars in a map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
//                .map(entry -> entry.getKey())
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(result);

        //8. Given a String, find the first repeated character in it using Stream functions?
        Character result1 = input.chars()// Stream of String
//                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .mapToObj(s -> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
//                .map(entry -> entry.getKey())
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(result1);

        //9. Given a list of integers, sort all the values present in it using Stream functions?
        list1.stream()
                .sorted()
                .forEach(System.out::println);

        //10. Given a list of integers, sort all the values present in it in descending order using Stream functions?
        list1.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        //11. Given an integer array number, return true if nay value appears at least twice in the array, and return false if every element is distinct?
        List<Integer> l1 = Arrays.stream(new int[]{1, 2, 3, 1}) // Change value -> new int[] {1, 2, 3, 4}
                .boxed()
                .toList();
        Set<Integer> s1 = new HashSet<>(l1);
        boolean r1 = s1.size() == l1.size() ? true : false;
        System.out.println(r1);

        //12. How will you get the current date and time using Java 8 Date and Time API?
        System.out.println("Current Local Date: " + LocalDate.now());
        System.out.println("Current Local Time: " + LocalTime.now());
        System.out.println("Current Local Date and Time: " + LocalDateTime.now());

        //13. Write a Java 8 program to concatenate two Streams?
        List<String> str1 = Arrays.asList("Java", "8");
        List<String> str2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream = Stream.concat(str1.stream(), str2.stream());

        //  concatenate the list1 and list2 by converting them into stream
        concatStream.forEach(str -> System.out.print(str + " "));
        System.out.println();

        //14. Java 8 program to perform cube on list elements and filter numbers greater than 50?
        List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
        integerList.stream()
                .map(i -> i * i * i)
                .filter(i -> i > 50)
                .forEach(System.out::println);

        //15. Write a Java 8 program to sort an array and then covert then sort an array into stream?
        int[] arr = {99, 55, 203, 99, 4, 91};
        Arrays.parallelSort(arr);

        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        System.out.println();

        //16. How to use a map to convert an object into Uppercase in java 8?
        List<String> names = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> namesList = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(namesList);

        //17. How to convert a list of objects into a map by considering duplicated keys and store them in sorted order?


        //18. How to count each element/word from the String ArrayList in java 8?
        List<String> names1 = Arrays.asList("aa", "bb", "aa", "cc");
        Map<String, Long> namesCount = names1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(namesCount);

        //19. How to find only duplicate elements with its count from the String ArrayList in Java8?
        List<String> names2 = Arrays.asList("AA", "BB", "AA", "CC");
        var nameCount2 = names2.stream()
                .filter(x -> Collections.frequency(names2, x) > 1)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
        System.out.println(nameCount2);

        //20. How to check if a list is empty in Java 8 using Optional, if not null iterating through the list and print the object?

        //21. Write a program to find the Maximum element in an array?
        var findMax = Arrays.stream(new int[]{12, 19, 20, 88, 00, 9}).max().getAsInt();
        System.out.println(findMax);

        //22. Write a program to print the count of each Character in a String?
        String string = "string data to count each character";
        var map = Arrays.stream(string.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);

        /////////////////////////////////////////////////

        // sum of all even numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream()
                .filter(num -> num % 2 == 0) // Odd number change operator ==, !=
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        // Filter even numbers
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList()
                .forEach(System.out::println);

        // Filter odd numbers
        numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList()
                .forEach(System.out::println);

        // Filter even numbers and then find max value
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo)
                .ifPresent(System.out::println);

        //2. Find the maximum integer in the list
        numbers.stream()
                .max(Integer::compare)
                .ifPresent(System.out::println);

        //3. Find the minimum integer in a list
        numbers.stream()
                .min(Integer::compare)
                .ifPresent(System.out::println);

        //4. Find the average of all integers in the list
        numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(System.out::println);

        //5. Count the number even integers in the list
        long c = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(c);

        //6. Convert all integers to their squares
        numbers.stream()
                .map(n -> n * n)
                .toList()
                .forEach(System.out::println);

        //7. Remove duplicates from a list
        List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 6, 5, 4, 3);

        numbers1.stream()
                .distinct()
                .toList()
                .forEach(System.out::println);

        //8. Sort the list of integers
        List<Integer> numbers2 = Arrays.asList(6, 4, 2, 1, 3, 9);

        numbers2.stream()
                .sorted()
                .toList()
                .forEach(System.out::println);

        //9. Find the second-largest integer in the list
        numbers.stream()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        //10. Find the frequency of each integer in the list
        List<Integer> numbers3 = Arrays.asList(1, 2, 2, 2, 3, 3, 5, 6, 34, 34, 234, 645);

        var frequencyMap = numbers3.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        frequencyMap.forEach((k, v) -> System.out.println(k + " : " + v));

        ////////////////////////////////////////////////////////////////////
        // Each task different solutions it's up to you which one you pick!!!

         /*
        Fix some issues down below!!!!!!!!!!!!!!!!!!!!! :)
        Working!!!!!!!
         */

        String string1 = "string data to count each character";
        var mapCharacter = Arrays.stream(string1.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
        System.out.println(mapCharacter);

        // Words counting
        List<String> wordsNames = Arrays.asList("XX", "YY", "ZZ", "XX");
        Map<String, Long> wordsNamesCount = wordsNames.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(wordsNamesCount);

        //1. Using `Collectors.groupingBy` and `Collectors.counting`
        String input1 = "aaabbbcccdddeeefzzzdddd";

        Map<Character, Long> characterCount = input.chars()
                .mapToObj(c1 -> (char) c1)
                .collect(Collectors.groupingBy(c1 -> c1, Collectors.counting()));
        characterCount.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("-".repeat(30));

        //2. Using `Collectors.toMap`
        Map<Character, Long> characterCount1 = input.chars()
                .mapToObj(c2 -> (char) c2)
                .collect(Collectors.toMap(
                        c2 -> c2,
                        c2 -> 1L,
                        Long::sum
                ));
        characterCount1.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("-".repeat(30));

        //3. Using `reduce`
        Map<Character, Long> characterCount2 = input.chars()
                .mapToObj(c3 -> (char) c3)
                .reduce(new HashMap<>(), (map3, c3) -> {
                    map3.put(c3, map3.getOrDefault(c3, 0L) + 1);
                    return map3;
                }, (map1, map2) -> {
                    map2.forEach((key, value) -> map1.merge(key, value, Long::sum));
                    return map1;
                });
        characterCount2.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("-".repeat(30));

        //4. Using `stream.of` and flatMap
        Map<String, Long> characterCount3 = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        characterCount3.forEach((k, v) -> System.out.println(k + " : " + v));

        // Words counting GPT-4

        //1. Using `collectors.gropingBy` and `collectors.counting`
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        wordCount.forEach((word, countL) -> System.out.println(word + " : " + countL));

        //2. Using `collectors.toMap`
        Map<String, Long> wordCount1 = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1L,
                        Long::sum
                ));

        wordCount1.forEach((word, countM) -> System.out.println(word + " : " + countM));

        //3. Using `reduce`
        Map<String, Long> wordCount2 = words.stream()
                .reduce(new HashMap<>(), (map4, word) -> {
                    map4.put(word, map4.getOrDefault(word, 0L) + 1);
                    return map4;
                }, (map1, map2) -> {
                    map2.forEach((key, value) -> map1.merge(key, value, Long::sum));
                    return map1;
                });

        wordCount2.forEach((word, countN) -> System.out.println(word + " : " + countN));

        //4. Using `stream.of` and `flatMap`
        Map<String, Long> wordCount3 = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCount3.forEach((word, countK) -> System.out.println(word + " : " + countK));


        //1. Convert a List of Strings to Uppercase
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        List<String> uppercased = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(uppercased);

        //2. Filter Strings that Start with a Given Letter
        List<String> strings1 = Arrays.asList("apple", "banana", "cherry", "avocado");
        List<String> filtered = strings1.stream()
                .map(String::toLowerCase)
                .filter(sf -> sf.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(filtered);

        //3. Join Strings with a Delimiter
        List<String> strings2 = Arrays.asList("apple", "banana", "cherry");
        String joined = strings2.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joined);

        //4. Count the Number of Strings with a given length
        List<String> strings3 = Arrays.asList("apple", "banana", "cherry", "date");
        long countA = strings3.stream()
                .filter(sl -> sl.length() > 5)
                .count();
        System.out.println(countA);

        //5. Find the longest string in a list
        List<String> strings4 = Arrays.asList("apple", "banana", "cherry", "date");
        String longest = strings4.stream()
                .max(Comparator.comparingInt(String::length))
//                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .orElse(null);
        System.out.println(longest);

        //6. Groping strings by their length
        Map<Integer, List<String>> gropingByLength = strings3.stream()
                .collect(Collectors.groupingBy(String::length));

        gropingByLength.forEach((length, strList) ->
                System.out.println(length + " : " + strList));

    }
}
