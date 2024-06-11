import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Differences {

    public static void main(String[] args) {

        //flatMap and map

        //Map
        List<String> words = Arrays.asList("hello", "world", "java");
        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseWords);

        // Flattening a List of Lists of Strings
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("hello", "world"),
                Arrays.asList("java", "streams"),
                Arrays.asList("flatMap", "example")
        );

        List<String> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flatList);

        // Flattening a List of Arrays of Integers
        List<Integer[]> listOfArrays = Arrays.asList(
                new Integer[]{1, 2, 3},
                new Integer[]{4, 5, 6},
                new Integer[]{7, 8, 9}
        );
        List<Integer> flatListArray = listOfArrays.stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(flatListArray);

        // Flattening a List of Strings to List of Characters
        List<String> words1 = Arrays.asList("hello", "world");

        List<Character> characters = words1.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println(characters);

        //4. Flattening a Stream of Optional values
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.of("hello"),
                Optional.empty(),
                Optional.of("world")
        );

        List<String> flatListOptional = listOfOptionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        System.out.println(flatListOptional);

        //5. Flattening nested lists and removing duplicates
        List<List<String>> listOfListsDuplicates = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("banana", "cherry"),
                Arrays.asList("cherry", "date")
        );

        List<String> uniqueElements = listOfListsDuplicates.stream()
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueElements);

        //6. Combining multiple streams
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("1", "2", "3");
        List<String> list3 = Arrays.asList("x", "y", "z");

        List<String> combinedList = Stream.of(list1, list2, list3)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(combinedList);

        // Above the list removing numbers from a list of strings
        System.out.println(combinedList);

        List<String> filteredList = combinedList.stream()
                .filter(s -> !s.matches("\\d+"))
                .collect(Collectors.toList());
        System.out.println(filteredList);

        // Using `Iterator`
        Iterator<String> iterator = combinedList.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.matches("\\d")) {
                iterator.remove();
            }
        }

        System.out.println(combinedList);

        // Using `for` loop
        List<String> combinedList1 = new ArrayList<>(Arrays.asList("a", "b", "c", "1", "2", "3", "x", "y", "z"));

        for (int i = 0; i < combinedList1.size(); i++) {
            if (combinedList1.get(i).matches("\\d")) {
                combinedList1.remove(i);
                i--;
            }
        }
        System.out.println(combinedList1);

        //3 Using removeIf with Lambda expression
        List<String> combinedList2 = new ArrayList<>(Arrays.asList("a", "b", "c", "1", "2", "3", "x", "y", "z"));

        combinedList2.removeIf(element -> element.matches("\\d"));
        System.out.println(combinedList2);

        //4 Using for Loop and Separate List for Removal
        List<String> combinedList3 = new ArrayList<>(Arrays.asList("a", "b", "c", "1", "2", "3", "x", "y", "z"));
        List<String> combinedList3Add = new ArrayList<>();

        for (String element : combinedList3) {
            if(element.matches("\\d")) {
                combinedList3Add.add(element);
            }
        }
//        combinedList3.retainAll(combinedList3Add);

        System.out.println(combinedList3Add);





    }


}
