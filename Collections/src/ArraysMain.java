import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysMain {

    public static void main(String[] args) {

        // Create a map where the key is an Integer and the value is a List of Strings
        Map<Integer, List<String>> map = new HashMap<>();

        // Add entries to the map
        map.put(1, Arrays.asList("Apple", "Banana", "Cherry"));
        map.put(2, Arrays.asList("Dog", "Elephant", "Frog"));
        map.put(3, Arrays.asList("Giraffe", "Hippo", "Iguana"));

        // Print the map
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println("Key: " + key + " -> Value: " + value);
        }

//        System.out.println("***");
//        map.forEach((key, value) -> System.out.println(key + " : " + value));

//        // Accessing a specific value
//        int keyToAccess = 2;
//        List<String> accessedValue = map.get(keyToAccess);
//        if (accessedValue != null) {
//            System.out.println("Accessed Value for Key " + keyToAccess + ": " + accessedValue);
//        } else {
//            System.out.println("No value found for Key " + keyToAccess);
//        }
//
//        // Adding a new list to an existing key
//        map.put(2, Arrays.asList("Horse", "Ibis"));
//        System.out.println("Updated Value for Key 2: " + map.get(2));
//
//        // Appending to an existing list
//        List<String> listForKey3 = map.get(3);
//        if (listForKey3 != null) {
//            listForKey3 = new ArrayList<>(listForKey3); // create a modifiable list
//            listForKey3.add("Jaguar");
//            map.put(3, listForKey3);
//        }
//        System.out.println("Appended Value for Key 3: " + map.get(3));

    }

}
