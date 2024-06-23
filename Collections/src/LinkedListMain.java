public class LinkedListMain {

    public static void main(String[] args) {

        //add
        // The add() method add an item to the list.
//        LinkedList<String> cars = new LinkedList<>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");

        // Print normal
//        System.out.println(cars);
//        System.out.println("***");
//        // Enhanced loop
//        for (String n : cars) {
//            System.out.println(n);
//        }
//        System.out.println("***");
//        // Traditional for loop
//        for (int i = 0; i < cars.size(); i++) {
//            System.out.println(cars.get(i));
//        }
//        System.out.println("***");
//        // forEach
//        cars.forEach(System.out::println);

        // addAll
        // The addAll() method adds all of hte items from a collection to the list.
//        LinkedList<String> cars = new LinkedList<>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//
//        LinkedList<String> brads = new LinkedList<>();
//        brads.add("Microsoft");
//        brads.add("W3schools");
//        brads.add("Apple");
//
//        brads.addAll(cars);
//
//        System.out.println(brads);

        // addFirst
        // The addFirst() method adds an item to the beginning of the list.
//        LinkedList<String> cars = new LinkedList<>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//
//        // Use addFirst() to add the item to the beginning
//        cars.addFirst("Mazda");
//        System.out.println(cars);

        // addLast
        // The addLast() method adds an item to the end of the list.
//        LinkedList<String> cars = new LinkedList<>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//
//        // Use addList() to add the item to the beginning
//        cars.addLast("Mazda");
//        System.out.println(cars);

        // clear
        // The clear() removes all items from the list
//        LinkedList<String> cars = new LinkedList<>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//
//        cars.clear();
//        System.out.println(cars);

        // clone
        // The clone() method returns a copy of the LinkedList as an Object.
//        LinkedList<String> cars = new LinkedList<>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//
//        LinkedList<String> cars2 = (LinkedList<String>) cars.clone();
//        cars2.set(0, "Toyota");
//
//        System.out.println(cars);
//        System.out.println(cars2);

        // contains
        // The contains() method returns true if an item exists in a list and false otherwise
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        System.out.println(cars.contains("BMW"));
//        System.out.println(cars.contains("Toyoto"));

        // forEach
        // The forEach method performs an action on every item in a list.
        // The action can be defined by a lambda expression that is compatible with the
        // accept() method of Java's Consumer interface.
//        LinkedList<Integer> numbers = new LinkedList<>();
//        numbers.add(5);
//        numbers.add(9);
//        numbers.add(8);
//        numbers.add(1);
//        numbers.forEach(System.out::println);

        // get
        // The get() method returns the item at a specified position in the list.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        System.out.println(cars.get(0));

        // getFirst
        // Returns the first item in the list
//        System.out.println(cars.getFirst());

        // getLast
        // Return the last item in the list
//        System.out.println(cars.getLast());

        // indexOf
        // The indexOf() method returns the position of the first occurrence of the value
        // in the list. If the item is not found in the list it returns -1.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        System.out.println(cars.indexOf("Ford"));
//        System.out.println(cars.indexOf("Tesla")); // Tesla not in there.

        // isEmpty
        // The isEmpty() method returns true if a list has not items and false otherwise.
//        LinkedList<String> cars = new LinkedList<>();
//        System.out.println(cars.isEmpty());
//        cars.add("Volvo");
//        System.out.println(cars.isEmpty());

        // iterator
        // The iterator() method return an Iterator for the list.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));

        // Get the iterator
//        Iterator<String> it = cars.iterator();

        // Loop through a collection
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        // lastIndexOf
        // The lastIndexOf() method returns the position of the last occurrence of a value in the list.
        // If the item is not found in the list then it returns -1.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "Ford", "BMW", "Ford", "Mazda"));
//        System.out.println(cars.indexOf("Ford"));
//        System.out.println(cars.lastIndexOf("Ford"));

        // listIterator
        // The listIterator() method return a ListIterator for the list.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));

        // Get a iterator
//        ListIterator<String> it = cars.listIterator();

        // Loop through the list
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

//        System.out.println("-----------------");

        // Loop backwards through the list
//        while (it.hasPrevious()) {
//            System.out.println(it.previous());
//        }

        // offer
        // The offer() method inserts the specified element at the end of the list.
        // It's equivalent to add().
//        LinkedList<String> list = new LinkedList<>(List.of("a", "b"));
//        list.offer("A");
//        list.offer("B");
//        list.offer("C");
//        System.out.println(list);

        // offerLast
        // The offerLast() method inserts the specified element at the end of the list.
        // It's also equivalent add() add () offer().
//        list.offerLast("D");
//        list.offerLast("E");
//        list.offerLast("F");
//        System.out.println(list);

        // offerFirst
        // The offerFirst() method inserts the specified element at the beginning of the list.
//        list.offerFirst("X");
//        list.offerFirst("Y");
//        list.offerFirst("Z");
//        System.out.println(list);

        // peek
        // Retrieves the first item in the list -- similar to getFirst()
//        LinkedList<String> list = new LinkedList<>(List.of("a", "b", "c"));
//        System.out.println(list);
//        System.out.println(list.peek());

        // peekFirst
        // Retrieves the first item in the list -- similar to peek()
//        System.out.println(list);
//        System.out.println(list.peekFirst());

        // peekLast
        // Retrieves the last item in the list
//        System.out.println(list);
//        System.out.println(list.peekLast());

        // poll
        // Returns the first element in the list --- Similar to removeFirst()'
//        LinkedList<String> list = new LinkedList<>(List.of("a", "b", "c"));
//        System.out.println(list);
//        System.out.println(list.poll());

        // pollFirst
        // Retrieves and removes the first in the list. --- Similar to poll()
//        System.out.println(list);
//        System.out.println(list.pollFirst());

        // pollLast
        // Retrieves and removes the last in the list.
//        System.out.println(list);
//        System.out.println(list.pollLast());

        // pop
        // Returns the first element in the list. -- Similar to removeFirst()
//        LinkedList<String> list = new LinkedList<>(List.of("vijay", "kumar", "roman"));
//        System.out.println(list);
//        System.out.println(list.pop());
//        list.pop();
//        System.out.println(list);

        // push
        // Adds an item to the beginning of the list. -- Similar to addFirst()
//        System.out.println(list);
//        list.push("aggidi");
//        System.out.println(list);

        // remove
        // The remove() method removes an item from the list, either by position or by value.
        // If a position is specified then this method returns the removed item.
        // If a value is specified then it returns true if the value was found and false otherwise.

//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        cars.remove(); // Default index position 0
//        cars.remove("BMW"); // Passing value
//        System.out.println(cars);

        // removeAll
//        // The removeAll() method removes all items from a list which belong to a specified collection.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        System.out.println(cars);
//        cars.removeAll(cars);
//        System.out.println(cars);

        // removeFirst
        // The removeFirst() method removes the first item in a list.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        System.out.println(cars);
//        cars.removeFirst();
//        System.out.println(cars);

        // removeLastOccurrence
        // Removes the last occurrence of a specified them in the list.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        cars.removeFirstOccurrence("BMW");
//        System.out.println(cars);

        // replaceAll
        // The replaceAll() method replaces every item in a list with the result of
        // performing an operation on the item. The operation can be defined by a
        // lambda expression that is a compatible with Java's UnaryOperator interface.

//        LinkedList<Integer> numbers = new LinkedList<>(List.of(5, 9, 8, 6, 1));
//        System.out.println(numbers);
//
//        numbers.replaceAll((n) -> n + 1);
//        System.out.println(numbers);
//
//        LinkedList<String> names = new LinkedList<>(List.of("vijay", "kumar", "aggidi"));
//        names.replaceAll(String::toUpperCase);
//        System.out.println(names);

        // retailAll
        // he retainAll() method removes all items from a list which do not belong to specified collection.
//        LinkedList<String> languages1 = new LinkedList<>(List.of("Telugu", "English", "Tamil", "Kannada"));
//        System.out.println(languages1);
//        LinkedList<String> languages2 = new LinkedList<>(List.of("Telugu"));
//        System.out.println(languages2);

//        languages1.retainAll(languages2);
//        System.out.println(languages1);

        // set
        // The set() method replaces an item at a specified position
        // in the list and returns the item that was previously  at that position.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        System.out.println(cars);
//        cars.set(0, "Opel");
//        System.out.println(cars);

        // size
        // The size() method indicates how man elements are in the list.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        System.out.println(cars.size());

        // sort
        // The sort() method sorts items in the list.
        // A Comparator can be used to compare pairs of elements.
        // The comparator can be defined by a lambda expression
        // which is compatible with the compare() method of Java's Comparator interface.
//        LinkedList<String> cars = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda"));
//        cars.sort(null);
//        System.out.println(cars);
//
//        // Another example
//        cars.sort((a, b) -> {
//            return -1 * a.compareTo(b);
//        });
//        System.out.println(cars);

        //spliterator
        // The spliterator() method returns a Spliterator for the list.
        // Make a collection
//        LinkedList<String> cars = new LinkedList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//
//        // Get the spliterator and split it
//        Spliterator<String> it1 = cars.spliterator();
//        Spliterator<String> it2 = it1.trySplit();
//
//        // Loop through the first spliterator
//        System.out.println("First spliterator");
//        while( it1.tryAdvance( (n) -> { System.out.println(n); } ) );
//
//        // Loop through the second spliterator
//        System.out.println("\nSecond spliterator");
//        while( it2.tryAdvance( (n) -> { System.out.println(n); } ) );

        // subList
        // The subList() method returns a new list (referred to as a sublist)
        // which contains the items of the list between two indicates.
//        LinkedList<String> cars = new LinkedList<>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//        System.out.println(cars.subList(1, 3));

        // toArray
        // The toArray() method returns an array containing all the items in the list.
//        LinkedList<String> cars = new LinkedList<>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//
//        Object[] carsArray = cars.toArray();
//        for (Object item : carsArray) {
//            System.out.println(item);
//        }


    }
}
