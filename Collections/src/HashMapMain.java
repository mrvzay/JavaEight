import java.util.HashMap;

public class HashMapMain {

    public static void main(String[] args) {

        // clear
        // The clear() method removes all entries from the map.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//        capitalCities.clear();
//        System.out.println(capitalCities);

        // clone
        // The clone() method returns a copy of the map as an Object.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        HashMap copy = (HashMap) capitalCities.clone();
//        copy.remove("England");
//
//        System.out.println(capitalCities);
//        System.out.println(copy);

        // compute
        // The compute() method changes the value of an entry or creates a new value of the entry does not exist.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        capitalCities.compute("England", (k, v) -> v + "(" + k + ")");
//
//        System.out.println(capitalCities);

        // computeIfAbsent
        // The computeIfAbsent() method calculates a value for a new entry based
        // on its key. If an entry with the specified key already exists and its value is
        // not null the map is not changed.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        capitalCities.computeIfAbsent("Canada", (k) -> "Toronto (" + k +  ")" );
//        System.out.println(capitalCities);

        // computeIfPresent
        // The computeIfPreset() method calculates a value for an entry based on
        // its key. If an entry with the specified key does not exist or its value is
        // null then the map is not changed.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        capitalCities.computeIfPresent("England", (k, v) -> v + "(" + k + ")");
//        System.out.println(capitalCities);

        // containsKey
        // The containsKey() method returns true if an entry with the specified
        // key exists in the map and false otherwise.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities.containsKey("England"));
//        System.out.println(capitalCities.containsKey("Canada"));

        // containsValue
        // The containsValue() method returns true if an entry with the specified
        // value exists in the map and false otherwise.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities.containsValue("London"));
//        System.out.println(capitalCities.containsValue("Ottawa"));

        // entrySet
        // The entrySet() method returns a set containing all the entries in the map.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities.entrySet());

        // forEach
        // The forEach() method performs an action on every entry in the map.
        // The action can be defined by a lambda expression that is compatible with
        // the accept() method of Java's BiConsumer interface.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        capitalCities.forEach((k, v) -> System.out.println(k + " -> " + v));

        // get
        // The get() method returns the value of the entry in the map which has a specified key.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities.get("England"));

        // getOrDefault
        // The getOrDefault() method returns the value of the entry in the map
        // which has a specified key. If the entry does not exist then
        // the value of the second parameter is returned.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities.getOrDefault("England", "Unknown"));
//        System.out.println(capitalCities.getOrDefault("Canada", "Unknown"));

        // isEmpty
        // The isEmpty() method returns true if the has no entries and false otherwise.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        System.out.println(capitalCities.isEmpty());
//
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities.isEmpty());

        // keySet
        // The keySet() method returns a set containing all the keys in the map.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities.keySet());

        // merge
        // The merge() method creates an entry with a specified key and value or,
        // if an entry with the specified key already exists, calculates a new value for the entry.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        capitalCities.merge("Canada", "Ottawa", (a, b) -> a + " -> " + b);
//        capitalCities.merge("England", "London", (a, b) -> a + " -> " + b);
//        capitalCities.merge("Germany", "Berlin", (a, b) -> a + " -> " + b);
//
//        System.out.println(capitalCities);

        // put
        // The put() method writes an entry into the map. If an entry with the
        // same key already exists then the value of the entry will be changed.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//        System.out.println(capitalCities);

        // putAll
        // The putAll() method writes all of the entries from another map into the map.
        // If entries exist with the same keys then the values of these entries
        // will be changed.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        HashMap<String, String> moreCities = new HashMap<>();
//        moreCities.put("Canada", "Ottawa");
//        moreCities.put("Japan", "Tokyo");
//
//        capitalCities.putAll(moreCities);
//        System.out.println(capitalCities);

        // putIfAbsent
        // The putIfAbsent() method writes an entry into the map.
        // If an entry with the same key already and its value is not null then the map is not changed.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");

        // Add new entries only if they don't exist
//        capitalCities.putIfAbsent("Canada", "Ottawa");
//        capitalCities.putIfAbsent("England", "Cambridge");
//
//        System.out.println(capitalCities);

        // remove
        // The remove() method removes an entry with a specified key from the map.
        // If a value is provided then the entry will only be removed if its value
        // matches the specified value.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        capitalCities.remove("USA");
//        capitalCities.remove("Germany", "Berlin");
//        capitalCities.remove("England", "Cambridge");
//
//        System.out.println(capitalCities);

        // replace
        // The replace() method writes a new value to an existing entry in the map.
        // The entry can be specified by its key, or by both its key and value.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "Cambridge");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        capitalCities.replace("England", "London");
//        capitalCities.replace("Canada", "Ottawa");
//        capitalCities.replace("USA", "New York", "Washington CD");
//
//        System.out.println(capitalCities);

        // replaceAll
        // The replaceAll() method replaces the value of every entry in the map
        // with the result of an operation using the entry's key and value.
        // The operation can be defined by a lambda expression that is compatible with
        // the apply() method of Java's BiFunction interface.
//        HashMap<String, String> capitalCities = new HashMap<String, String>();
//
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        capitalCities.replaceAll((k, v) -> "The capital of " + k + " is " + v);
//
//        System.out.println(capitalCities);

        // size
        // The size() method returns the number of entries in a map.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities.size());

        // values
        // The value() method returns a collection containing all the values in the map.
//        HashMap<String, String> capitalCities = new HashMap<>();
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//
//        System.out.println(capitalCities.values());


    }

}
