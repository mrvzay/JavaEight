public class StringsMain {

    public static void main(String[] args) {

        // chatAt
        // The charAt() method returns the character at the specified index in a string.
//        String str = "Hello";
//        System.out.println(str);
//        System.out.println(str.charAt(0));

        // codePointAt
        // The codePointAt() method returns the Unicode value of the character at the specified index in a string.
//        String str = "Hello";
//        int result = str.codePointAt(0);
//        System.out.println(result);

        // codePointBefore
        // The codePointBefore() method returns the Unicode value of the character
        // before the specified index in a string.
//        String str = "Hello";
//        int result = str.codePointBefore(1);
//        System.out.println(result);

        // codePointCount
        // The codePointCount() method returns the number of Unicode values
        // found in a string.
//        String str = "Hello";
//        int result = str.codePointCount(0, 5);
//        System.out.println(result);

        // compareTo
        // The compareTo() method compares two strings lexicographically.
        // The comparison is based on the Unicode value of each character in the strings.
//        String str1 = "Hello";
//        String str2 = "Hello";
//        System.out.println(str1.compareTo(str2));

        // compareToIgnoreCase
        // The compareToIgnoreCase() method compares two strings lexicographically,
        // ignoring lower case and upper case difference.
//        String str1 = "HELLO";
//        String str2 = "hello";
//        System.out.println(str1.compareToIgnoreCase(str2));

        // concat
        // The concat() method appends (concatenate) a string to the end of another string.
//        String firstName = "John ";
//        String lastName = "Doe";
//        System.out.println(firstName.concat(lastName));

        // contains
        // The contains() method checks whether a string contains a sequence of characters.
        // Return true if the characters exist and fasle if not.
//        String str = "Hello";
//        System.out.println(str.contains("Hel"));
//        System.out.println(str.contains("e"));
//        System.out.println(str.contains("Hi"));

        // contentEquals
        // The contentEquals() method searches a string to find out if it contains the
        // exact same sequence of characters in the specified string or StringBuffer.
        // Returns true if hte characters exist and false if not.
//        String str = "Hello";
//        System.out.println(str.contentEquals("Hello"));
//        System.out.println(str.contentEquals("e"));
//        System.out.println(str.contentEquals("Hi"));

        // copyValueOf
        // The copyValueOf() method returns a String that represents the characters of the char array.
//        char[] str1 = {'H', 'e', 'l', 'l', 'o'};
//        String str2 = "";
//        str2 = String.copyValueOf(str1, 0, 5);
//        System.out.println("Returned String:  " + str2);

        // endsWith
        // The endsWith() method checks whether a string ends with the specified characters(s).
//        String str = "Hello";
//        System.out.println(str.endsWith("Hel"));
//        System.out.println(str.endsWith("llo"));
//        System.out.println(str.endsWith("o"));

        // equals
        // The equals() method compares two strings, and returns true if hte strings are equals, and false if not.
//        String str1 = "Hello";
//        String str2 = "Hello";
//        String str3 = "Another String";
//        System.out.println(str1.equals(str2));
//        System.out.println(str1.equals(str3));

        // equalsIgnoreCase
        // The equalsIgnoreCase() method compares two strings, ignoring lower case and upper case differences.
//        String str1 = "Hello";
//        String str2 = "HELLO";
//        String str3 = "Another String";
//        System.out.println(str1.equalsIgnoreCase(str2));
//        System.out.println(str1.equalsIgnoreCase(str3));

        // format
        // The format() method returns a formatted string using a locale, format and additional argument.
//        String str = "Hello %s! One kilobyte is %,d bytes.";
//        String result = String.format(str, "World", 1024);
//        System.out.println(result);

        // getBytes
        // The getBytes() method converts a string into an array of bytes.
//        String str = "Hello";
//        byte[] result = str.getBytes();
//        System.out.println(result[0]);
//        System.out.println(Arrays.toString(result));

        // getChars
        // The getChars() method copies characters from a string to a char array.
//        char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//        System.out.println(arr);
//
//        String str = "Hello, World!";
//        str.getChars(7, 12, arr, 4);
//        System.out.println(arr);

        // hashCode
        // The hashCode() method returns object is computed like this:
        /* s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
         * where s[i] is the ith character of the string, n is the length of the string, and ^ indicates exponentiation. */
//        String str = "Hello";
//        System.out.println(str.hashCode());

        // indexOf
        // The indexOf() method returns the position of the first occurrence of specified character(s) in a string.
//        String str = "Hello planet earth, you are a great planet.";
//        System.out.println(str.indexOf("planet"));

        // intern
        /*
        In Java, the intern() method is used with strings to optimize memory usage.
        When you call the intern() method on a String object,
         it checks if an identical string already exists in the Java string pool.
          If it does, the method returns a reference to that existing string.
           If it doesn't, the method adds the string to the pool and then returns a reference to it.
            This helps to ensure that identical strings share the same memory location,
             which can be beneficial in terms of memory efficiency.
         */
//        String str1 = new String("Hello");
//        String str2 = new String("Hello");
//
//        System.out.println(str1 == str2);
//        System.out.println(str1.equals(str2));
//
//        // Intern the strings
//        String str3 = str1.intern();
//        String str4 = str2.intern();
//
//        System.out.println(str3 == str4);
//
//        System.out.println(str3 == "Hello");

        // isEmpty
        // The isEmpty() method checks whether a string is empty or not.
//        String str1 ="Hello";
//        String str2 = "";
//        System.out.println(str1.isEmpty());
//        System.out.println(str2.isEmpty());

        // join
        // The join() method joins one or more strings with a specified separator.
//        String fruits = String.join(" ", "Orange", "Apple","Mango");
//        System.out.println(fruits);

        // lastIndexOf
        // The lastIndexOf() method returns the position of the last occurrence of specified character(s) in a string.
//        String str = "Hello planet earth, you are a great planet.";
//        System.out.println(str.lastIndexOf("planet"));

        // length
        // The length() method returns the length of a specified string.
//        String txt = "ABCDEFJHIJKLMNOPQRSTUVWXZY";
//        System.out.println(txt.length());

        // matches
        // The matches() method searches a string for a match against a regular expression, and returns the matches.
//        String regex = "cat|dog|fish";
//        System.out.println("cat".matches(regex));
//        System.out.println("dog".matches(regex));
//        System.out.println("catfish".matches(regex));
//        System.out.println("doggy bag".matches(regex));

        // offsetByCodePoints
        // The offsetByCodePoints() method returns an index in a string which is offset
        // from another index by a specified number of code points.
//        String str = "Hello, World";
//        int result = str.offsetByCodePoints(3, 2);
//        System.out.println(result);

        // regionMatches
        // The regionMatches() method compares regions in two different strings to check if they are equal.
//        String str1 = "Hello, World!";
//        String str2 = "New World";
//        System.out.println(str1.regionMatches(7, str2, 4, 5));
//        System.out.println(str1.regionMatches(0, str2, 0, 5));

        // replace
        // The replace() method searches a string for specified character, and returns a
        // new string where the specified character(s) are replaced.
//        String str = "Hello";
//        System.out.println(str.replace('l', 'p'));

        // replaceAll
        // The replaceAll() method replaces the first match of a regular expression in a string with a new substring.
//        String str = "I love cats. Cats are very easy to love. Cats are very popular.";
//        String regex = "(?i)cat";
//        System.out.println(str.replaceAll(regex, "dog"));

        // replaceFist
        // The replaceFirst() method replaces the first match of a regular expression in the string with a new substring.
//        String str = "This is W3Schools";
//        String regex = "is";
//        System.out.println(str.replaceFirst(regex, "at"));

        // split
        // The split() method splits a string into an array of substrings using a regular expression as the separator.
//        String str = "Split a string by spaces, and also punctuation.";
//        String regex = "[,\\.\\s]";
//        String[] arr = str.split(regex);
//        for (String s : arr) {
//            System.out.println(s);
//        }

        // startWith
        // The startsWith() method checks whether a string starts with the specified character(s).
//        String str = "Hello";
//        System.out.println(str.startsWith("Helo"));
//        System.out.println(str.startsWith("llo"));
//        System.out.println(str.startsWith("o"));

        // subSequence
        // The subSequence() method returns a subsequence from the string as a CharSequence object.
//        String str = "Hello, World!";
//        System.out.println(str.subSequence(7, 12));

        // subString
        // The substring() method returns a substring from the string.
//        String str = "Hello, World!";
//        System.out.println(str.substring(7, 12));

        // toCharArray
        // The toCharArray() method returns a new char array representing the contents of the string.
//        String str = "Hello";
//        char[] arr = str.toCharArray();
//        System.out.println(arr[0]);

        // toLowerCase
        // The toLowerCase() method converts a string to lower case letters.
//        String str = "Hello World";
//        System.out.println(str.toUpperCase());
//        System.out.println(str.toLowerCase());

        // toString
        // The toString() method returns the string itself.
//        String str = "Hello, World!";
//        System.out.println(str.toString());

        // toUpperCase
        // The toUpperCase() method converts a string to upper case letters.
//        String str = "Hello World";
//        System.out.println(str.toUpperCase());
//        System.out.println(str.toLowerCase());

        // trim
        // The trim() method removes whitespace from both ends of a string.
//        String str = "          Hello World!";
//        System.out.println(str);
//        System.out.println(str.trim());

        // valueOf
        // The valueOf() method returns the string representation of the specified value.
//        char[] myArray = {'a', 'b', 'c'};
//        System.out.println(String.valueOf(myArray));
//        System.out.println(String.valueOf('A'));
//        System.out.println(String.valueOf(true));
//        System.out.println(String.valueOf(4.5f));
//        System.out.println(String.valueOf(5.2));
//        System.out.println(String.valueOf(12));
//        System.out.println(String.valueOf(1400L));
    }

}
