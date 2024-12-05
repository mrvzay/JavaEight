import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        // We have a input array as
        String[] arr = {"abcd", "java", "ajav", "xyz", "epam", "pame", "aepm"};

        // Kindly write a java program for following output:
        // Output:
        // [epam, pame, aepm] contains same character
        // [java, ajav] contains same character
        // [abcd, dcba] contains same character

        // Solution 1 :
        Map<String, Double> mapWithAscii = new HashMap<>();
        Arrays.stream(arr).forEach(a -> {
            double asci = Arrays.stream(a.split(""))
                    .map(cha -> (int) cha.toCharArray()[0])
                    .reduce(0, (s1, s2) -> s1 + s2)
                    .doubleValue();
            mapWithAscii.put(a, asci);
        });

        Map<Double, List<String>> groupedBySameAsCIIValue = mapWithAscii.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue
                        , Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(":::::Answer:::::::::\n" + groupedBySameAsCIIValue.values());

        System.out.println("::::::::::::::::::::::::: Second Approach :::::::::::::");

        // Solutions 2 :
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            char[] arrChar = arr[i].toCharArray();
            Arrays.sort(arrChar);
            String sorted = String.valueOf(arrChar);
            if (map.containsKey(sorted)) {
                List<String> addedValue = map.get(sorted);
                if (!addedValue.contains(arr[i]) && !addedValue.contains(sorted)) {
                    addedValue.add(arr[i]);
                    map.put(sorted, addedValue);
                } else {
                    addedValue.add(arr[i]);
                    map.put(sorted, addedValue);
                }
            } else {
                ArrayList<String> a = new ArrayList<>();
                a.add(arr[i]);
                map.put(sorted, a);
            }
        }
        System.out.println(map.values().stream()
                .filter(va -> va.size() > 1)
                .collect(Collectors.toList()));
    }
}
