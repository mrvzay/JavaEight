import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThirdStringStreams {

    public static void main(String[] args) {

        // Characters counting
        String s = "string data to count each character";
        Map<String, Long> mapCharacter = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(
                        Collectors.groupingBy
                                (str -> str, LinkedHashMap::new,
                                        Collectors.counting()));
        System.out.println(mapCharacter);

        // Words counting
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity()
                                , Collectors.counting()
                        )
                );
        System.out.println(namesCount);

        //1. Using `Collectors.groupingBy` and `Collectors.counting`
        String input = "aaabbbcccdddeeefzzzdddd";

        Map<Character, Long> characterCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        characterCount.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("-".repeat(30));

        //2. Using `Collectors.toMap`
        Map<Character, Long> characterCount1 = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        c -> c,
                        c -> 1L,
                        Long::sum
                ));
        characterCount1.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("-".repeat(30));

        //3. Using `reduce`
        Map<Character, Long> characterCount2 = input.chars()
                .mapToObj(c -> (char) c)
                .reduce(new HashMap<>(), (map, c) -> {
                    map.put(c, map.getOrDefault(c, 0L) + 1);
                    return map;
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

        wordCount.forEach((word, count) -> System.out.println(word + " : " + count));

        //2. Using `collectors.toMap`
        Map<String, Long> wordCount1 = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1L,
                        Long::sum
                ));

        wordCount1.forEach((word, count) -> System.out.println(word + " : " + count));

        //3. Using `reduce`
        Map<String, Long> wordCount2 = words.stream()
                .reduce(new HashMap<>(), (map, word) -> {
                    map.put(word, map.getOrDefault(word, 0L) + 1);
                    return map;
                }, (map1, map2) -> {
                    map2.forEach((key, value) -> map1.merge(key, value, Long::sum));
                    return map1;
                });

        wordCount2.forEach((word, count) -> System.out.println(word + " : " + count));

        //4. Using `stream.of` and `flatMap`
        Map<String, Long> wordCount3 = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCount3.forEach((word, count) -> System.out.println(word + " : " + count));


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
        long count = strings3.stream()
                .filter(sl -> sl.length() > 5)
                .count();
        System.out.println(count);

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
