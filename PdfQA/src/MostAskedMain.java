
import java.util.*;

public class MostAskedMain {

    public static void main(String[] args) {

        //1. Write a Java Program to reverse a string without using String inbuilt function.
        String input = "Hello World";
        System.out.println(reverseString(input));

        //2. Write a Java Program to swap two numbers without using the third variable.
        swapNumbers(2, 3);

        //3. Write a Java Program to count the number of words in a string using HashMap
        input = "Hello World Hello World";
        System.out.println(countWords(input));

        //4. Write a Java Program to iterate HashMap using While and advance for loop
        // Create a Map
        Map<String, String> map = new HashMap<>();

        // Add key-value pairs to the Map
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        iterateHashMap(map);

        //5. Write a Java Program to find whether a number is prime or not in the most efficient way?
//        System.out.println(isPrime(29));
        int number = 29;
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        //6. Write a Java Program to find whether a string or number is palindrome or not
        // Test the string palindrome method
        String str = "madam";
        if (isPalindrome(str)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }

        // Test the integer palindrome method
        int num = 12321;
        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome.");
        } else {
            System.out.println(num + " is not a palindrome.");
        }

        //7. Write a Java Program for the Fibonacci series in recursion
        System.out.println(fibonacci(7));

        //8. Write a Java Program to iterate ArrayList using for-loop, while-loop, and advance for-loop.
        iterateList(Arrays.asList(1, 2, 3, 4, 5, 6));

        //9. Write a Java Program to find the duplicate characters in a string.
        findDuplicates("Hellooo");

        //10. Write a Java Program to find the second-highest number in an array.
        System.out.println(secondHighest(new int[]{1, 2, 3, 4, 5}));

        //11. Write a Java Program to check Armstrong number.
        int[] testNumbers = {153, 370, 371, 407, 123};

        for (int n : testNumbers) {
            if (isArmstrong(n)) {
                System.out.println(n + " is an Armstrong number.");
            } else {
                System.out.println(n + " is not an Armstrong number.");
            }
        }

        //12. Write a Java Program to remove all white spaces from a string without using replace().
        System.out.println(removeWhitespaces("Hello World"));

        //13. Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));

        //14. Write a program that accepts comma-separated strings, sorts the
        //strings in ascending order, and outputs the concatenated string of sorted
        //strings.
        System.out.println(sortAndConcatenate("Hello,World"));

        //15.  Given a string s, return true if s is a "good" string, or false otherwise.
        //A string s is good if all characters that appear in s have the same number of
        //occurrences (i.e., the same frequency).
        System.out.println(areOccurrencesEqual("aabbc")); // aabbcc

        // Test examples
        String s1 = "aabbcc";
        String s2 = "aabbc";
        String s3 = "abcabc";

        System.out.println("Is \"" + s1 + "\" a good string? " + isGoodString(s1)); // true
        System.out.println("Is \"" + s2 + "\" a good string? " + isGoodString(s2)); // false
        System.out.println("Is \"" + s3 + "\" a good string? " + isGoodString(s3)); // true

        //16. Given an array nums and a value val, remove all instances of that
        //value in-place and return the new length of the array. Do not allocate extra
        //space for another array. You must modify the input array in-place with O(1)
        //extra memory.
        System.out.println(removeElement(new int[]{3, 2, 2, 3, 4, 3, 5}, 2));
        // Example array and value to remove
        int[] nums = {3, 2, 2, 3, 4, 2, 5};
        int val = 2;

        // Remove the elements
        int newLength = removeElement(nums, val);

        // Output the result
        System.out.println("New length of the array: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        //17. You are given an integer array nums and an array of queries queries
        //where queries[i] = [val, index]. For each query, add val to nums[index]. Then,
        //return the sum of all even numbers in nums

        // Example input
        int[] nums1 = {1, 2, 3, 4};
        int[][] queries = {
                {1, 0},
                {-3, 1},
                {-4, 0},
                {2, 3}
        };

        // Get the result after processing the queries
        int[] result = sumEvenAfterQueries(nums1, queries);

        // Output the result
        System.out.println("Resulting sums of even numbers after each query: " + Arrays.toString(result));

        //18. Given two strings s and p, find all the start indices of p's anagrams in s
        System.out.println(findAnagrams("vijay", "a"));

        //19. Given a string s, find the length of the longest substring without
        //repeating characters
        System.out.println(lengthOfLongestSubstrings("vijay"));

        // Example strings
        String s11 = "abcabcbb";
        String s22 = "bbbbb";
        String s33 = "pwwkew";
        String s44 = "dvdf";
        String s55 = "";

        // Print the results
        System.out.println("Length of longest substring without repeating characters in \"" + s11 + "\": " + lengthOfLongestSubstring(s11)); // 3
        System.out.println("Length of longest substring without repeating characters in \"" + s22 + "\": " + lengthOfLongestSubstring(s22)); // 1
        System.out.println("Length of longest substring without repeating characters in \"" + s33 + "\": " + lengthOfLongestSubstring(s33)); // 3
        System.out.println("Length of longest substring without repeating characters in \"" + s44 + "\": " + lengthOfLongestSubstring(s44)); // 3
        System.out.println("Length of longest substring without repeating characters in \"" + s55 + "\": " + lengthOfLongestSubstring(s55)); // 0

        //20. Merge two sorted linked lists and return it as a new sorted list.
        // Create first sorted linked list: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // Create second sorted linked list: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Merge the two sorted linked lists
        ListNode mergedList = mergeTwoLists(l1, l2);

        // Print the merged linked list
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        //21. You are given an n x n 2D matrix representing an image, rotate the
        //image by 90 degrees (clockwise).
        // Example matrix
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Rotate the matrix
        rotate(matrix);

        // Print the rotated matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //22. Given a non-negative integer num, repeatedly add all its digits until the
        //result has only one digit.
        System.out.println(addDigits(38));
        System.out.println(addDigits(12345));
        System.out.println(addDigits(0));
        System.out.println(addDigits(999));

        /*
        Example Outputs:
        For num = 38:

        First iteration: sum of 3 + 8 = 11.
        Second iteration: sum of 1 + 1 = 2.
        Output: 2.
        For num = 12345:

        First iteration: sum of 1 + 2 + 3 + 4 + 5 = 15.
        Second iteration: sum of 1 + 5 = 6.
        Output: 6.
        For num = 0:

        Since num is already less than 10, the loop doesn't execute.
        Output: 0.
        For num = 999:

        First iteration: sum of 9 + 9 + 9 = 27.
        Second iteration: sum of 2 + 7 = 9.
        Output: 9.
         */

        //23. Given an integer, write a function to determine if it is a power of two.
        System.out.println(isPowerOfTwo(1)); // Try 2, 3, 16, 18

        //24. Given an array nums, write a function to move all 0's to the end of it
        //while maintaining the relative order of the non-zero elements.
        // Example case
        int[] nums11 = {0, 1, 0, 3, 12};

        // Move zeroes
        moveZeroes(nums);

        // Print the result
        for (int num11 : nums11) {
            System.out.print(num11 + " ");
        }

        //25. Given an array nums of n integers where nums[i] is in the range [1, n],
        //return an array of all the integers in the range [1, n] that do not appear in
        //nums
        // Example cases
        int[] nums12 = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums22 = {1, 1};

        // Find and print the missing numbers
        System.out.println("Missing numbers in nums12: " + findDisappearedNumbers(nums12)); // [5, 6]
        System.out.println("Missing numbers in nums22: " + findDisappearedNumbers(nums22)); // [2]

    }

    public static String reverseString(String input) {

        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void swapNumbers(int a, int b) {
        
        System.out.println("Before swap: a = a " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swap: a = a " + a + ", b = " + b);
    }

    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = input.split("\\s+");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public static void iterateHashMap(Map<String, String> map) {
        // Using advanced for-loop
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Using while-loop with iterator
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

//    public static boolean isPrime(int number) {
//        // Corner cases
//        if (number <= 1) {
//            return false;
//        }
//        if (number <= 3) {
//            return true;
//        }
//        // This is checked so that we can skip middle five numbers in below loop
//        if (number % 2 == 0 || number % 3 == 0) {
//            return false;
//        }
//        // Check from 5 to square root of the number
//        // Checking i, i+2 for 6k +/- 1 optimization
//        for (int i = 5; i * i <= number; i += 6) {
//            if (number % i == 0 || number % (i + 2) == 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static boolean isPalindrome(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to check if an integer is a palindrome
    public static boolean isPalindrome(int number) {
        // Convert the number to a string and use the isPalindrome(String) method
        return isPalindrome(String.valueOf(number));
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void iterateList(List<Integer> list) {
        // Using for-loop
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Using while-loop
        int j = 0;
        while (j < list.size()) {
            System.out.println(list.get(j));
            j++;
        }

        // Using advanced for-loop
        for (int item : list) {
            System.out.println(item);
        }
    }

    public static void findDuplicates(String input) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " appears " + entry.getValue() + " items");
            }
        }
    }

    public static int secondHighest(int[] nums) {
        int highest = Integer.MIN_VALUE, secondHighest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest && num != highest) {
                secondHighest = num;
            }
        }
        return secondHighest;
    }

    public static boolean isArmstrong(int number) {
        int original = number, sum = 0;
        int digits = String.valueOf(number).length();
        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }
        return sum == original;
    }

    public static String removeWhitespaces(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static String sortAndConcatenate(String input) {
        String[] parts = input.split(",\\s*");
        Arrays.sort(parts);
        return String.join("", parts);
    }

    public static boolean areOccurrencesEqual(String s) {
        int[] count = new int[26]; // There are 20 lowercase English letters
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int frequency = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                if (frequency == 0) {
                    frequency = count[i]; // Set the first non-zero frequency found
                } else if (frequency != count[i]) {
                    return false; // Return false if nay frequency doesn't match the first found
                }
            }
        }
        return true;
    }

    public static boolean isGoodString(String s) {
        // Create a HashMap to store the frequency of each character
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Iterate over the string and count the frequency of each character
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Get the frequency of the first character
        int frequency = charCountMap.get(s.charAt(0));

        // Check if all characters have the same frequency
        for (int count : charCountMap.values()) {
            if (count != frequency) {
                return false;
            }
        }

        return true;
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sumEven = 0;
        for (int num : nums) {
            if (num % 2 == 0) sumEven += num; // Calculate initial sum of even numbers
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], index = queries[i][1];
            if (nums[index] % 2 == 0) sumEven -= nums[index]; // Remove old value if it was even
            nums[index] += val;
            if (nums[index] % 2 == 0) sumEven += nums[index]; // Add new value if it is even
            result[i] = sumEven;

        }
        return result;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || p.length() > s.length()) return result;

        int[] charCount = new int[26];
        for (char c : p.toCharArray()) {
            charCount[c - 'a']++;
        }

        int start = 0, end = 0, count = p.length();
        while (end < s.length()) {
            if (charCount[s.charAt(end++) - 'a']-- >= 1) count--;

            if (count == 0) result.add(start);

            if (end - start == p.length() && charCount[s.charAt(start++) - 'a']++ >= 0) count++;
        }
        return result;
    }

    public static int lengthOfLongestSubstrings(String s) {
        int[] chars = new int[128]; // There are 128 ASCII characters
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Map to store the last index of each character
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        // Iterate through the string
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and its index is within the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                // Move the start pointer to the right of the last occurrence of the current character
                start = charIndexMap.get(currentChar) + 1;
            }

            // Update the last seen index of the current character
            charIndexMap.put(currentChar, end);

            // Calculate the length of the current window and update maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to act as the head of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Iterate through both lists
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

        // Attach the remaining nodes of l1 or l2
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Return the merged list, starting from the next node of dummy
        return dummy.next;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int insertPos = 0;

        // Move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill remaining positions with zeroes
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Mark the presence of each number
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Identify the missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

}
