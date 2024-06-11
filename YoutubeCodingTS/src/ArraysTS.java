import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class ArraysTS {

    public static void main(String[] args) {

        /*
         1. Using a HashSet
         A `HashSet` automatically handles duplicates because sets dot allow duplicates elements.
         */
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        int[] result = removeDuplicateUsingSet(array);
        System.out.println(Arrays.toString(result));

        /*
        2. Using a stream (Java 8+)
        Java 8 introduced the Stream API, which can be used to remove duplicates in a concise way.
         */
        int[] result2 = removeDuplicatesUsingStream(array);
        System.out.println(Arrays.toString(result2));

        /*
        3. Using a LinedHashSet
        A `LinkedHashSet` maintains the order of elements as they were inserted, which can be useful if you need the order of the original array.
         */
        int[] result3 = removeDuplicatesUsingLinkedHashSet(array);
        System.out.println(Arrays.toString(result3));

        /*
        4. Using a temporary array
        This method involves sorting the array first, then copying unique elements to a new array.
         */
        int[] result4 = removeDuplicatesUsingTemArray(array);
        System.out.println(Arrays.toString(result4));

        /*
        5. Using a boolean array (for small ranges)
        If the range of values in the array is small, a boolean array can be used to track occurrences.
         */
        int[] result5 = removeDuplicatesUsingBooleanArray(array);
        System.out.println(Arrays.toString(result5));


    }

    public static int[] removeDuplicateUsingSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            set.add(value);
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (int value : set) {
            result[i++] = value;
        }
        return result;
    }

    public static int[] removeDuplicatesUsingStream(int[] array) {
        return IntStream.of(array).distinct().toArray();
    }

    public static int[] removeDuplicatesUsingLinkedHashSet(int[] array) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int value : array) {
            set.add(value);
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (int value : set) {
            result[i++] = value;
        }
        return result;
    }

    public static int[] removeDuplicatesUsingTemArray(int[] array) {
        if (array.length == 0) return array;

        Arrays.sort(array);
        int[] tempArray = new int[array.length];
        int j = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                tempArray[j++] = array[i];
            }
        }

        tempArray[j++] = array[array.length - 1];
        return Arrays.copyOf(tempArray, j);
    }

    public static int[] removeDuplicatesUsingBooleanArray(int[] array) {
        boolean[] seen = new boolean[100]; // Assuming values are in range 0 to 99
        int uniqueCount = 0;

        for (int value : array) {
            if (!seen[value]) {
                seen[value] = true;
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];
        int index = 0;
        for (int value : array) {
            if (seen[value]) {
                result[index++] = value;
                seen[value] = false; // Ensure each value is added only once
            }
        }
        return result;
    }
}
