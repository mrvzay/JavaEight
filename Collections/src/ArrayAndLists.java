import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayAndLists {

    public static void main(String[] args) {

        ArrayList<String> arraysString = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        System.out.println(arraysString.getClass());
        System.out.println(linkedList.getClass());

        System.out.println("*".repeat(30));

        List<String> listArrays = new ArrayList<>();
        List<String> listLists = new LinkedList<>();

        System.out.println(listArrays.getClass());
        System.out.println(listLists.getClass());

        System.out.println("*".repeat(30));

        List<Integer> example1 = List.of(1, 2, 3);
        List<Integer> example2 = Arrays.asList(1, 2, 3);

        System.out.println(example1.getClass());
        System.out.println(example2.getClass());

        System.out.println("*".repeat(30));

        String[] names = new String[10];
        String[] secondNames = new String[] {"vijay", "kiran"};
        String[] thirdNames;
        thirdNames = new String[] {"one", "Two", "Three"};

        System.out.println(names.getClass());
        System.out.println(secondNames.getClass());
        System.out.println(thirdNames.getClass());

//        System.out.println("*".repeat(30));
//
//        for (int i =0; i < names.length; i++) {
//            System.out.print(names[i]+ " ");
//        }
//        System.out.println();
//        for (int i =0; i < secondNames.length; i++) {
//            System.out.print(secondNames[i] + " ");
//        }
//        System.out.println();
//        for (int i =0; i < thirdNames.length; i++) {
//            System.out.print(thirdNames[i] + " ");
//        }
//        System.out.println();
//        System.out.println("*".repeat(30));
//
//        for (Object nullValues : names) {
//            System.out.print(nullValues + " ");
//        }
//        System.out.println();
//
//        for (String string : secondNames) {
//            System.out.print(string + " ");
//        }
//        System.out.println();
//
//        for (String stringSecond : thirdNames) {
//            System.out.print(stringSecond + " ");
//        }
//        System.out.println();

    }
}
