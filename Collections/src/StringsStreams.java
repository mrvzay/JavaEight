import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringsStreams {

    public static void main(String[] args) {

        String input = "aaabbbcccdddeeefzzddd";

        Map<Character, Long> characterCount1 = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        characterCount1.forEach((k, v) -> System.out.print(k + " : " + v));
        System.out.println();
        System.out.println("***");

        Map<Character, Long> characterCount2 = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        c -> c,
                        c -> 1L,
                        Long::sum));
        characterCount2.forEach((k, v) -> System.out.print(k + " : " + v));

        System.out.println();
        System.out.println("***");

        Map<Character, Long> characterCount3 = input.chars()
                .mapToObj(c -> (char) c)
                .reduce(new HashMap<>(), (map, c) -> {
                    map.put(c, map.getOrDefault(c, 0L) + 1);
                    return map;
                }, (map1, map2) -> {
                    map2.forEach((key, value) -> map1.merge(key, value, Long::sum));
                    return map1;
                });

        characterCount3.forEach((k, v) -> System.out.print(k + " : " + v));

        System.out.println();
        System.out.println("***");

        Map<String, Long> characterCount4 = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        characterCount4.forEach((k, v) -> System.out.print(k + " : " + v));
    }
}
