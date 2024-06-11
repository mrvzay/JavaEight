import java.util.*;

public class LinkedListMain {

    public static void main(String[] args) {

        LinkedList<String> languages = new LinkedList<>();

        // addFirst()
        languages.addFirst("C++");

        // add(), ---> all so specify index position
        // index position optional
        languages.add(1, "Java");
        languages.add("Python");
        System.out.println("LinkedList: " + languages);

        // create another LinkedList
        LinkedList<String> programmingLang = new LinkedList<>();
        // addAll()
        // index position is optional
        programmingLang.addAll(languages);
        System.out.println("Programming languages: " + programmingLang);

        LinkedList<String> numbers = new LinkedList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("five");

        LinkedList<String> insertedNumbers = new LinkedList<>();
        insertedNumbers.add("three");
        insertedNumbers.add("four");

        numbers.addAll(2, insertedNumbers);
        System.out.println("Second LinkedList: " + numbers);

        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("JavaScript");
        System.out.println("HashSet: " + set);
        System.out.println(set.getClass().getSimpleName());
        System.out.println(set.getClass());

        LinkedList<String> list = new LinkedList<>();

        list.add("English");
        System.out.println("Initial LinkedList: " + list);

        list.addAll(set);
        System.out.println("Updated LinkedList: " + list);
        System.out.println(list.getClass().getSimpleName());
        System.out.println(list.getClass());

        // clear()
        LinkedList<String> clearList = new LinkedList<>(List.of("Java", "JavaScript", "Python"));
        System.out.println("Clear list: " + clearList);
        clearList.clear();
        System.out.println("Clear list: " + clearList);

        // removeAll()
        LinkedList<String> removeAll = new LinkedList<>(List.of("one", "two", "three"));
        System.out.println("Remove All: " + removeAll);
        removeAll.removeAll(removeAll);
        System.out.println("Remove All: " + removeAll);

        // clone
        LinkedList<Integer> cloneNumbers = new LinkedList<>(List.of(1, 2, 3));

        LinkedList<Integer> cloneNumbersMethod = (LinkedList<Integer>) cloneNumbers.clone();
        System.out.println(cloneNumbersMethod);

        // contains()
        System.out.println(languages.contains("Java"));

        // String contains
        String str1 = "Java String contains()";

        boolean result = str1.contains("Java");
        System.out.println(result);

        // containsAll
        LinkedList<Integer> numbers1 = new LinkedList<>(List.of(1, 2, 3));
        HashSet<Integer> primeNumbers1 = new HashSet<>(List.of(2, 3));

        System.out.println(numbers1.containsAll(primeNumbers1));

        // get()
        System.out.println(languages.get(0));

        // indexOf
        LinkedList<Integer> indexOfNumbers = new LinkedList<>();
        indexOfNumbers.add(22);
        indexOfNumbers.add(13);
        indexOfNumbers.add(35);
        System.out.println(indexOfNumbers);

        System.out.println(indexOfNumbers.indexOf(13));
        System.out.println(indexOfNumbers.indexOf(55));

        // removeAll
        indexOfNumbers.removeAll(indexOfNumbers);
        System.out.println(indexOfNumbers);

        LinkedList<String> languages1 = new LinkedList<>(List.of("Java", "English", "C", "Spanish"));
        System.out.println(languages1);

        LinkedList<String> languages2 = new LinkedList<>(List.of("English", "Spanish"));

        languages1.removeAll(languages2);
        System.out.println(languages1);

        // remove()
        languages1.remove(0);
        System.out.println(languages1);

        LinkedList<Integer> removeNumbers = new LinkedList<>(List.of(22, 13, 25, 13, 40));
        System.out.println(removeNumbers);

        boolean result1 = removeNumbers.remove(Integer.valueOf(13));
        System.out.println(result1);
        System.out.println(removeNumbers);

        // size()
        LinkedList<String> sizeStrings = new LinkedList<>(List.of("English", "Spanish"));
        System.out.println(sizeStrings);
        System.out.println(sizeStrings.size());

        LinkedList<Integer> sizeInteger = new LinkedList<>(List.of(22, 13, 25, 13, 40));
        System.out.println(sizeInteger);
        System.out.println(sizeInteger.size());

        // isEmpty()
        LinkedList<String> isEmptyList = new LinkedList<>();
        System.out.println(isEmptyList);
        System.out.println(isEmptyList.isEmpty());
        isEmptyList.add("One");
        System.out.println(isEmptyList);
        System.out.println(isEmptyList.isEmpty());

        // subList()
        LinkedList<String> subListLanguages = new LinkedList<>(List.of("JavaScript", "Java", "Python", "C++"));
        System.out.println(subListLanguages);
        System.out.println(subListLanguages.subList(0, 3));

        LinkedList<Integer> subListAges = new LinkedList<>(List.of(10, 12, 15, 19, 23, 36));
        System.out.println(subListAges);
        System.out.println("Ages below 18: " + subListAges.subList(0, 3));
        System.out.println("Ages above 18: " + subListAges.subList(3, subListAges.size()));

        // set()
        LinkedList<String> setLanguages = new LinkedList<>();
        setLanguages.add("Python");
        setLanguages.add("English");
        setLanguages.add("JavaScript");
        System.out.println(setLanguages);
        setLanguages.set(1, "Java"); // replace element
        System.out.println(setLanguages);

        // set() vs add()
        // add method adding in LinkedList
        // set method replace element in existing element

        // sort()
        LinkedList<Integer> sortNumbers = new LinkedList<>();
        sortNumbers.add(7);
        sortNumbers.add(3);
        sortNumbers.add(9);
        sortNumbers.add(-33);
        System.out.println(sortNumbers);

        sortNumbers.sort(Comparator.naturalOrder());
        System.out.println(sortNumbers);

        LinkedList<Character> charSort = new LinkedList<>(List.of('A', 'C', 'E', 'B'));
        System.out.println(charSort);

        charSort.sort(Comparator.naturalOrder());
        System.out.println(charSort);
        charSort.sort(Comparator.reverseOrder());
        System.out.println(charSort);

        // toArray
        LinkedList<String> toArrayLanguages = new LinkedList<>();
        toArrayLanguages.add("Java");
        toArrayLanguages.add("Python");
        toArrayLanguages.add("C");
        System.out.println("LinkedList: " + toArrayLanguages);

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
//        LinkedList<String> ensureCapacityLanguages = new LinkedList<>();
//
//        ensureCapacityLanguages.ensureCapacity(3);
//
//        ensureCapacityLanguages.add("Java");
//        ensureCapacityLanguages.add("Python");
//        ensureCapacityLanguages.add("C");
//
//        // You can add more then three elements no problem, dynamically adjusted
//        ensureCapacityLanguages.add("C");
//        System.out.println(ensureCapacityLanguages);

        // lastIndexOf()
//        System.out.println(ensureCapacityLanguages.lastIndexOf("C"));

        // retailAll()
        LinkedList<String> retailAllLanguageOne = new LinkedList<>();
        retailAllLanguageOne.add("JavaScript");
        retailAllLanguageOne.add("Python");
        retailAllLanguageOne.add("Java");
        System.out.println(retailAllLanguageOne);

        LinkedList<String> retailAllLanguageTwo = new LinkedList<>();
        retailAllLanguageTwo.add("English");
        retailAllLanguageTwo.add("Java");
        retailAllLanguageTwo.add("Python");
        System.out.println(retailAllLanguageTwo);

        retailAllLanguageOne.retainAll(retailAllLanguageTwo);
        System.out.println(retailAllLanguageOne);

        List<Integer> num1 = new LinkedList<>(List.of(1, 2, 3));
        List<Integer> num2 = new LinkedList<>(List.of(23, 2, 32));

        // retailAll method only common elements retail like duplicate values elements
        num1.retainAll(num2);
        System.out.println(num1);

        // containAll()
        LinkedList<String> containAllLanguagesOne = new LinkedList<>();

        containAllLanguagesOne.add("JavaScript");
        containAllLanguagesOne.add("Python");
        containAllLanguagesOne.add("Java");
        System.out.println("LinkedList One : " + containAllLanguagesOne);

        LinkedList<String> containAllLanguagesTwo = new LinkedList<>();

        containAllLanguagesTwo.add("Java");
        containAllLanguagesTwo.add("Python");

        System.out.println("Contain all One: " + containAllLanguagesOne.containsAll(containAllLanguagesTwo));
        System.out.println("Contain all Two: " + containAllLanguagesTwo.containsAll(containAllLanguagesOne));

//        //trimToSize()
//        LinkedList<String> trimToSizeLanguages = new LinkedList<>();
//
//        trimToSizeLanguages.add("JavaScript");
//        trimToSizeLanguages.add("Python");
//        trimToSizeLanguages.add("Java");
//        System.out.println("LinkedList: " + trimToSizeLanguages);
//
//        trimToSizeLanguages.trimToSize();
//        System.out.println("Size of LinkedList: " + trimToSizeLanguages.size());

        // removeRange()
        LinkedList<String> removeToRangeLanguages = new LinkedList<>();
        removeToRangeLanguages.add("Python");
        removeToRangeLanguages.add("English");
        removeToRangeLanguages.add("Spanish");
        removeToRangeLanguages.add("JavaScript");
        removeToRangeLanguages.add("Java");
        System.out.println(removeToRangeLanguages);
        removeToRangeLanguages.subList(1, 3).clear();
        System.out.println(removeToRangeLanguages);

        // replaceAll()
        LinkedList<String> replaceAllLanguages = new LinkedList<>();

        replaceAllLanguages.add("Java");
        replaceAllLanguages.add("JavaScript");
        replaceAllLanguages.add("Swift");
        replaceAllLanguages.add("Python");
        System.out.println("LinkedList: " + replaceAllLanguages);

        replaceAllLanguages.replaceAll(String::toUpperCase);
        System.out.println("Updated LinkedList : " + replaceAllLanguages);

        LinkedList<Integer> replaceAllNumbers = new LinkedList<>(List.of(1, 2, 3, 4));
        System.out.println(replaceAllNumbers);
        replaceAllNumbers.replaceAll(e -> e * 2);
        System.out.println(replaceAllNumbers);

        // removeIf()
        LinkedList<Integer> removeIfNumbers = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6));
        System.out.println(removeIfNumbers);
        removeIfNumbers.removeIf(e -> (e % 2) == 0);
        System.out.println(removeIfNumbers);

        LinkedList<String> countries = new LinkedList<>();

        // add elements to the LinkedList
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
        LinkedList<Integer> forEachNumbers = new LinkedList<>(List.of(1, 2, 3, 4));
        System.out.println(forEachNumbers);
        System.out.println("Updated forEachNumbers: ");
        forEachNumbers.forEach((e) -> {
            e = e * 10;
            System.out.print(e + " ");
        });

        System.out.println();
        // Iterator()
        LinkedList<String> iteratorLanguages = new LinkedList<>(List.of("Java", "Python", "JavaScript", "Swift"));

        Iterator<String> iterate = iteratorLanguages.iterator();
        while (iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }

    }
}


