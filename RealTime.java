import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RealTime {

    public static void main(String[] args) {

        // You are give a list of sorting, and you have to calculate the frequency of sorting by using stream API ?
        List<String> wordsList = List.of("hello", "bye", "ciao", "bye", "ciao");
        // The result be:
        // ciao=2, hello=1, bye=2

        // Solution 1
        Map<String, Long> collect = wordsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.entrySet().forEach(System.out::println);

        // Solution 2
        Map<String, Integer> collect1 = wordsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        collect1.entrySet().forEach(System.out::println);

        System.out.println("********************");
        // Solution 3
        LinkedHashMap<String, Long> countByWordSorted = collect.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        },
                        LinkedHashMap::new
                ));
        countByWordSorted.entrySet().forEach(System.out::println);

    }
}
