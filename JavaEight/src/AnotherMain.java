import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnotherMain {

    public static void main(String[] args) {

        //1. How would you reverse a string ?

        // Solution 1:
        String input = "Hello";
        char[] charArray = input.toCharArray();

        // Swap characters from both ends
        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }

        // Create the reversed string
        String reversedString = new String(charArray);
        System.out.println("Reversed string: " + reversedString);

        // Solution 2: chatAt()
        String originalStr = "Hello";
        StringBuilder reversedStr = new StringBuilder();
        for (int i = 0; i < originalStr.length(); i++) {
//            reversedStr = originalStr.charAt(i) + reversedStr;
            reversedStr.insert(0, originalStr.charAt(i));
        }
        System.out.println("Reversed string: " + reversedStr);

        // Solution 3 : getBytes()
        String input1 = "GeeksforGeeks";
        byte[] strAsByteArray = input1.getBytes();
        byte[] result = new byte[strAsByteArray.length];
        for (int i = 0; i < strAsByteArray.length; i++) {
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }
        System.out.println(new String(result));

        // Solution, StringBuilder
        String input2 = "Geeks for Geeks";
        StringBuilder result1 = new StringBuilder();
        result1.append(input2);
        result1.reverse();
        System.out.println(result1);

        System.out.println("*****");

        // ChatGPT
        String str = "Hello, World!";
        // Convert string to character array
        char[] charArray1 = str.toCharArray();
        // Initialize pointers for the beginning and end of the array
        int start = 0;
        int end = charArray1.length - 1;

        // Swap characters from start to end
        while (start < end) {
            // Swap characters
            char temp = charArray1[start];
            charArray1[start] = charArray1[end];
            charArray1[end] = temp;

            // Move pointer towards the center
            start++;
            end--;
        }
        // Convert character back to String
        String result2 = new String(charArray1);
        System.out.println(result2);

        //2. How can you find the missing number in an array in integers ?
        int[] arr = {1, 2, 4, 6, 7};
        int max = 7;
        for (int i = 1; i <= max; i++) {
            boolean found = false;
            for (int num : arr) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        /// HashMap
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        //3. How do you check if a given string is a palindrome ?
        String testStr1 = "A man, a plan, a canal, Panama";
        String testStr2 = "Hello, World!";

        System.out.println(testStr1 + " is a palindrome: " + isPalindrome(testStr1));
        System.out.println(testStr2 + " is a palindrome: " + isPalindrome(testStr2));

        //4. How can you generate the first n numbers in the Fibonacci sequence ?
        int n = 10;
        printFibonacci(n);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        generateFibonacci(n);
        System.out.println();

        //5. How would you find two numbers in an array that add up to a specific target ?
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 4)));
        System.out.println(Arrays.toString(twoSumBruteForce(new int[]{1, 2, 3, 4, 5}, 4)));

        //6. How do you merge two sorted linked list into one sorted list ?

        // Creating first sorted linked list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        // Merging the lists
        ListNode mergedList = mergeTwoLists(l1, l2);

        // Printing the merged linked list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }

        //7. How would you find the maximum sum of a contiguous sub array in  a given array ?
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArray(nums);
        System.out.println("Maximum sum of a contiguous subarray: " + maxSum);

        //8. How can you check if two strings are anagrams of each other ?
        String str1 = "listen";
        String str2 = "silent";

        boolean resultOne = areAnagramsUsingSorting(str1, str2);
        System.out.println("Are the strings anagrams (using sorting)? " + resultOne);

        boolean resultTwo = areAnagramsUsingFrequencyCount(str1, str2);
        System.out.println("Are the strings anagrams (using frequency count)? " + resultTwo);


        //9. How do you implement a function to remove duplicates from an array ?
        int[] numsOne = {1, 2, 2, 3, 4, 4, 5};
        int[] uniqueNums = removeDuplicates(numsOne);
        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueNums));

        int[] numsTwo = {1, 2, 2, 3, 4, 4, 5};
        int[] uniqueNumsTwo = removeDuplicates(numsTwo);
        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueNumsTwo));

        int[] numsThree = {1, 2, 2, 3, 4, 4, 5};
        int uniqueLength = removeDuplicatesInPlace(numsThree);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOf(numsThree, uniqueLength)));

        //10. How would you find the first non-repeating character in  string ?
        String strLast = "swiss";
        char resultLast = firstNonRepeatingCharacter(strLast);

        if (resultLast != 0) {
            System.out.println("The first non-repeating character is: " + resultLast);
        } else {
            System.out.println("No non-repeating character found.");
        }
        String strLast1 = "swiss";
        char resultLast1 = firstNonRepeatingCharacter(strLast1);

        if (resultLast1 != 0) {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        String strStreamOne = "swiss";
        Character resultStreamOne = firstNonRepeatingCharacterStream(strStreamOne);

        if (resultStreamOne != null) {
            System.out.println("The first non-repeating character is: " + resultStreamOne);
        } else {
            System.out.println("No non-repeating character found.");
        }

        String strStreamTwo = "swiss";
        Character resultStreamTwo = firstNonRepeatingCharacterStreamOne(strStreamTwo);

        if (resultStreamTwo != null) {
            System.out.println("The first non-repeating character is: " + resultStreamTwo);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    public static boolean isPalindrome(String str) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Reverse the cleaned string
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();

        // Compare the cleaned string with the reversed string
        return cleanedStr.equals(reversedStr);
    }

    public static void printFibonacci(int n) {
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.print(a + " "); // Print the nth number after the loop
        for (int i = 1; i < n; i++) { // Print the remaining numbers (0 to n-1)
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void generateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        int first = 0, second = 1;
        System.out.print("First " + n + " Fibonacci numbers: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must contain at least one element.");
        }

        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

    public static boolean areAnagramsUsingSorting(String str1, String str2) {
        // If lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to char arrays
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Sort the char arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static boolean areAnagramsUsingFrequencyCount(String str1, String str2) {
        // If lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a frequency map for characters in str1
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Decrease the frequency count based on characters in str2
        for (char c : str2.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false; // Character not found in str1
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) == 0) {
                charCountMap.remove(c);
            }
        }

        // If map is empty, strings are anagrams
        return charCountMap.isEmpty();
    }

    public static int[] removeDuplicates(int[] nums) {
        // Use a HashSet to store unique elements
        HashSet<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }

        // Convert the set back to an array
        int[] uniqueArray = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            uniqueArray[index++] = num;
        }

        return uniqueArray;
    }

    public static int[] removeDuplicatesOne(int[] nums) {
        // Use a stream to remove duplicates and collect to an array
        return Arrays.stream(nums)
                .distinct()
                .toArray();
    }

    public static int removeDuplicatesInPlace(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

    public static char firstNonRepeatingCharacter(String str) {
        // Use LinkedHashMap to maintain the order of characters
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        // Traverse the string and store the frequency of each character
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Traverse the LinkedHashMap to find the first non-repeating character
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // Return 0 if no non-repeating character is found
        return 0;
    }

    public static char firstNonRepeatingCharacterOne(String str) {
        int[] charCount = new int[256]; // Assuming ASCII character set

        // Traverse the string and store the frequency of each character
        for (char c : str.toCharArray()) {
            charCount[c]++;
        }

        // Traverse the string again to find the first non-repeating character
        for (char c : str.toCharArray()) {
            if (charCount[c] == 1) {
                return c;
            }
        }

        // Return 0 if no non-repeating character is found
        return 0;
    }

    public static Character firstNonRepeatingCharacterStream(String str) {
        // Create a LinkedHashMap to maintain insertion order
        Map<Character, Long> charCountMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Find the first character with a count of 1
        return charCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static Character firstNonRepeatingCharacterStreamOne(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        Map<Character, Integer> charIndexMap = new HashMap<>();

        // Populate the maps with counts and first occurrence indices
        str.chars().forEachOrdered(c -> {
            charCountMap.put((char) c, charCountMap.getOrDefault((char) c, 0) + 1);
            charIndexMap.putIfAbsent((char) c, str.indexOf(c));
        });

        // Find the first non-repeating character based on the first occurrence index
        Optional<Character> firstNonRepeating = charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted((c1, c2) -> Integer.compare(charIndexMap.get(c1), charIndexMap.get(c2)))
                .findFirst();

        return firstNonRepeating.orElse(null);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to serve as the start of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Iterate through both lists, adding the smaller node to the merged list
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If there are remaining nodes in either list, append them
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Return the merged list, which starts at dummy.next
        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
