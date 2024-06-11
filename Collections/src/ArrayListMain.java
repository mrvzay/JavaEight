import java.util.*;

public class ArrayListMain {

    public static void main(String[] args) {

        ArrayList<String> languages = new ArrayList<>();

        // addFirst()
        languages.addFirst("C++");

        // add(), ---> all so specify index position
        // index position optional
        languages.add(1, "Java");
        languages.add("Python");
        System.out.println("ArrayList: " + languages);

        // create another arrayList
        ArrayList<String> programmingLang = new ArrayList<>();
        // addAll()
        // index position is optional
        programmingLang.addAll(languages);
        System.out.println("Programming languages: " + programmingLang);

        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("five");

        ArrayList<String> insertedNumbers = new ArrayList<>();
        insertedNumbers.add("three");
        insertedNumbers.add("four");

        numbers.addAll(2, insertedNumbers);
        System.out.println("Second ArrayList: " + numbers);

        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("JavaScript");
        System.out.println("HashSet: " + set);
        System.out.println(set.getClass().getSimpleName());
        System.out.println(set.getClass());

        ArrayList<String> list = new ArrayList<>();

        list.add("English");
        System.out.println("Initial ArrayList: " + list);

        list.addAll(set);
        System.out.println("Updated ArrayList: " + list);
        System.out.println(list.getClass().getSimpleName());
        System.out.println(list.getClass());

        // clear()
        ArrayList<String> clearList = new ArrayList<>(List.of("Java", "JavaScript", "Python"));
        System.out.println("Clear list: " + clearList);
        clearList.clear();
        System.out.println("Clear list: " + clearList);

        // removeAll()
        ArrayList<String> removeAll = new ArrayList<>(List.of("one", "two", "three"));
        System.out.println("Remove All: " + removeAll);
        removeAll.removeAll(removeAll);
        System.out.println("Remove All: " + removeAll);

        // clone
        ArrayList<Integer> cloneNumbers = new ArrayList<>(List.of(1, 2, 3));

        ArrayList<Integer> cloneNumbersMethod = (ArrayList<Integer>) cloneNumbers.clone();
        System.out.println(cloneNumbersMethod);

        // contains()
        System.out.println(languages.contains("Java"));

        // String contains
        String str1 = "Java String contains()";

        boolean result = str1.contains("Java");
        System.out.println(result);

        // containsAll
        ArrayList<Integer> numbers1 = new ArrayList<>(List.of(1, 2, 3));
        HashSet<Integer> primeNumbers1 = new HashSet<>(List.of(2, 3));

        System.out.println(numbers1.containsAll(primeNumbers1));

        // get()
        System.out.println(languages.get(0));

        // indexOf
        ArrayList<Integer> indexOfNumbers = new ArrayList<>();
        indexOfNumbers.add(22);
        indexOfNumbers.add(13);
        indexOfNumbers.add(35);
        System.out.println(indexOfNumbers);

        System.out.println(indexOfNumbers.indexOf(13));
        System.out.println(indexOfNumbers.indexOf(55));

        // removeAll
        indexOfNumbers.removeAll(indexOfNumbers);
        System.out.println(indexOfNumbers);

        ArrayList<String> languages1 = new ArrayList<>(List.of("Java", "English", "C", "Spanish"));
        System.out.println(languages1);

        ArrayList<String> languages2 = new ArrayList<>(List.of("English", "Spanish"));

        languages1.removeAll(languages2);
        System.out.println(languages1);

        // remove()
        languages1.remove(0);
        System.out.println(languages1);

        ArrayList<Integer> removeNumbers = new ArrayList<>(List.of(22, 13, 25, 13, 40));
        System.out.println(removeNumbers);

        boolean result1 = removeNumbers.remove(Integer.valueOf(13));
        System.out.println(result1);
        System.out.println(removeNumbers);

        // size()
        ArrayList<String> sizeStrings = new ArrayList<>(List.of("English", "Spanish"));
        System.out.println(sizeStrings);
        System.out.println(sizeStrings.size());

        ArrayList<Integer> sizeInteger = new ArrayList<>(List.of(22, 13, 25, 13, 40));
        System.out.println(sizeInteger);
        System.out.println(sizeInteger.size());

        // isEmpty()
        ArrayList<String> isEmptyList = new ArrayList<>();
        System.out.println(isEmptyList);
        System.out.println(isEmptyList.isEmpty());
        isEmptyList.add("One");
        System.out.println(isEmptyList);
        System.out.println(isEmptyList.isEmpty());

        // subList()
        ArrayList<String> subListLanguages = new ArrayList<>(List.of("JavaScript", "Java", "Python", "C++"));
        System.out.println(subListLanguages);
        System.out.println(subListLanguages.subList(0, 3));

        ArrayList<Integer> subListAges = new ArrayList<>(List.of(10, 12, 15, 19, 23, 36));
        System.out.println(subListAges);
        System.out.println("Ages below 18: " + subListAges.subList(0, 3));
        System.out.println("Ages above 18: " + subListAges.subList(3, subListAges.size()));

        // set()
        ArrayList<String> setLanguages = new ArrayList<>();
        setLanguages.add("Python");
        setLanguages.add("English");
        setLanguages.add("JavaScript");
        System.out.println(setLanguages);
        setLanguages.set(1, "Java"); // replace element
        System.out.println(setLanguages);

        // set() vs add()
        // add method adding in arraylist
        // set method replace element in existing element

        // sort()
        ArrayList<Integer> sortNumbers = new ArrayList<>();
        sortNumbers.add(7);
        sortNumbers.add(3);
        sortNumbers.add(9);
        sortNumbers.add(-33);
        System.out.println(sortNumbers);

        sortNumbers.sort(Comparator.naturalOrder());
        System.out.println(sortNumbers);

        ArrayList<Character> charSort = new ArrayList<>(List.of('A', 'C', 'E', 'B'));
        System.out.println(charSort);

        charSort.sort(Comparator.naturalOrder());
        System.out.println(charSort);
        charSort.sort(Comparator.reverseOrder());
        System.out.println(charSort);

        // toArray
        ArrayList<String> toArrayLanguages = new ArrayList<>();
        toArrayLanguages.add("Java");
        toArrayLanguages.add("Python");
        toArrayLanguages.add("C");
        System.out.println("ArrayList: " + toArrayLanguages);

        String[] arr = new String[toArrayLanguages.size()];

        toArrayLanguages.toArray(arr);

        System.out.print("Array: ");
        for (String item : arr) {
            System.out.print(item + ", ");
        }

        System.out.println();

        System.out.println(toArrayLanguages.getClass());
        System.out.println(arr.getClass());

        Object[] obj = toArrayLanguages.toArray();
        for (Object item : obj) {
            System.out.print(item + ", ");
        }
        System.out.println();

        // toString
        System.out.println(toArrayLanguages.toString());

        // ensureCapacity()
        ArrayList<String> ensureCapacityLanguages = new ArrayList<>();

        ensureCapacityLanguages.ensureCapacity(3);

        ensureCapacityLanguages.add("Java");
        ensureCapacityLanguages.add("Python");
        ensureCapacityLanguages.add("C");

        // You can add more then three elements no problem, dynamically adjusted
        ensureCapacityLanguages.add("C");
        System.out.println(ensureCapacityLanguages);

        // lastIndexOf()
        System.out.println(ensureCapacityLanguages.lastIndexOf("C"));

        // retailAll()
        ArrayList<String> retailAllLanguageOne = new ArrayList<>();
        retailAllLanguageOne.add("JavaScript");
        retailAllLanguageOne.add("Python");
        retailAllLanguageOne.add("Java");
        System.out.println(retailAllLanguageOne);

        ArrayList<String> retailAllLanguageTwo = new ArrayList<>();
        retailAllLanguageTwo.add("English");
        retailAllLanguageTwo.add("Java");
        retailAllLanguageTwo.add("Python");
        System.out.println(retailAllLanguageTwo);

        System.out.println("***");
        retailAllLanguageOne.retainAll(retailAllLanguageTwo);
        System.out.println(retailAllLanguageOne);

        List<Integer> num1 = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> num2 = new ArrayList<>(List.of(23, 2, 32));

        // retailAll method only common elements retail like duplicate values elements
        num1.retainAll(num2);
        System.out.println(num1);

        // containAll()
        ArrayList<String> containAllLanguagesOne = new ArrayList<>();

        containAllLanguagesOne.add("JavaScript");
        containAllLanguagesOne.add("Python");
        containAllLanguagesOne.add("Java");
        System.out.println("ArrayList One : " + containAllLanguagesOne);

        ArrayList<String> containAllLanguagesTwo = new ArrayList<>();

        containAllLanguagesTwo.add("Java");
        containAllLanguagesTwo.add("Python");

        System.out.println("Contain all One: " + containAllLanguagesOne.containsAll(containAllLanguagesTwo));
        System.out.println("Contain all Two: " + containAllLanguagesTwo.containsAll(containAllLanguagesOne));

        //trimToSize()
        ArrayList<String> trimToSizeLanguages = new ArrayList<>();

        trimToSizeLanguages.add("JavaScript");
        trimToSizeLanguages.add("Python");
        trimToSizeLanguages.add("Java");
        System.out.println("ArrayList: " + trimToSizeLanguages);

        trimToSizeLanguages.trimToSize();
        System.out.println("Size of ArrayList: " + trimToSizeLanguages.size());

        // removeRange()
        ArrayList<String> removeToRangeLanguages = new ArrayList<>();
        removeToRangeLanguages.add("Python");
        removeToRangeLanguages.add("English");
        removeToRangeLanguages.add("Spanish");
        removeToRangeLanguages.add("JavaScript");
        removeToRangeLanguages.add("Java");
        System.out.println(removeToRangeLanguages);
        removeToRangeLanguages.subList(1, 3).clear();
        System.out.println(removeToRangeLanguages);

        // replaceAll()
        ArrayList<String> replaceAllLanguages = new ArrayList<>();

        replaceAllLanguages.add("Java");
        replaceAllLanguages.add("JavaScript");
        replaceAllLanguages.add("Swift");
        replaceAllLanguages.add("Python");
        System.out.println("ArrayList: " + replaceAllLanguages);

        replaceAllLanguages.replaceAll(String::toUpperCase);
        System.out.println("Updated ArrayList : " + replaceAllLanguages);

        ArrayList<Integer> replaceAllNumbers = new ArrayList<>(List.of(1, 2, 3, 4));
        System.out.println(replaceAllNumbers);
        replaceAllNumbers.replaceAll(e -> e * 2);
        System.out.println(replaceAllNumbers);

        // removeIf()
        ArrayList<Integer> removeIfNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        System.out.println(removeIfNumbers);
        removeIfNumbers.removeIf(e -> (e % 2) == 0);
        System.out.println(removeIfNumbers);

        ArrayList<String> countries = new ArrayList<>();

        // add elements to the ArrayList
        countries.add("Iceland");
        countries.add("America");
        countries.add("Ireland");
        countries.add("Canada");
        countries.add("Greenland");
        System.out.println("Countries: " + countries);

        // remove all even countries
        countries.removeIf(e -> e.contains("land"));;
        System.out.println("Countries without land: " + countries);

        // forEach()
        ArrayList<Integer> forEachNumbers = new ArrayList<>(List.of(1, 2, 3, 4));
        System.out.println(forEachNumbers);
        System.out.println("Updated forEachNumbers: ");
        forEachNumbers.forEach((e) -> {
            e = e * 10;
            System.out.print(e + " ");
        });

        System.out.println();
        // Iterator()
        ArrayList<String> iteratorLanguages = new ArrayList<>(List.of("Java", "Python", "JavaScript", "Swift"));

        Iterator<String> iterate = iteratorLanguages.iterator();
        while (iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }

    }
}


