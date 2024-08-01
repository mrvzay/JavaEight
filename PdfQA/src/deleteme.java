import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String input = "Hello World Hello World";
        System.out.println(countWords(input));

        String inputString = "This is a test. This test is only a test.";

        String[] words = inputString.toLowerCase().split("\\W+");

        Map<String, Integer> wordsCountMap = new HashMap<>();

        for (String word : words) {
            if (wordsCountMap.containsKey(word)) {
                wordsCountMap.put(word, wordsCountMap.get(word) + 1);
            } else {
                wordsCountMap.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("**");

        wordsCountMap.entrySet().forEach(System.out::println);

        System.out.println("-".repeat(30));
        String str = "This is a test. This test is only a test.";

        String[] wordsStr = str.toLowerCase().replaceAll("[^a-zA-Z]", "").split("\\s+");
        Map<String, Long> wordCountMap = Arrays.stream(wordsStr)
                .collect(Collectors.groupingBy(w -> w, HashMap::new, Collectors.counting()));

        for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("&".repeat(30));
        String strStream = "This is a test. This test is only a test.";

        String[] wordsStream = strStream.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

        HashMap<String, Integer> wordCountStreamMap = new HashMap<>();

        Arrays.stream(wordsStream).forEach(word -> wordCountStreamMap.merge(word, 1, Integer::sum));

        for (Map.Entry<String, Integer> entry : wordCountStreamMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("#".repeat(30));
        String[] multiLineString = {
                "This is a test",
                "This test is only a test",
                "Another test to count words",
                "Count words in this test"
        };

        Map<String, Long> wordCountMulti = Arrays.stream(multiLineString)
                .flatMap(line -> Arrays.stream(line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+")))
                .collect(Collectors.groupingBy(word -> word, HashMap::new, Collectors.counting()));
        wordCountMulti.forEach((k, v) -> System.out.println(k + " : " + v));

    }

    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = input.split("\\s+");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

}
