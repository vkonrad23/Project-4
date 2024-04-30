import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//        Write a program to compare time consumption on typical operations with system ArrayList and LinkedList (from java.util).
//        Both of these system Java collection classes implement java.util.List interface. Both of them contain implementation of methods List.add(), List.get() and List.remove().
//        Your aim is to test and compare time of execution of these methods for ArrayList and LinkedList:
//        1. Insertion of element to the beginning of the list: add(0, element).
//        Make a loop and add a large number of items to the collection.
//        2. Access element by its index: get(index)
//        Make a loop and access each element: list.get(i)
//        3. Remove first element: remove(0)
//        Make a loop remove first element on each iteration: list.remove(0)
//        Sample code for the experiment "Test insertion into beginning for ArrayList":

public class Part0 {

    private static long insertTime;
    private static long accessTime;
    private static long removeTime;

    public static void main(String[] args) {

        test(new ArrayList<>());
        test(new LinkedList<>());
    }

    private static void test(List<Integer> list) {
            insert(list);
            access(list);
            remove(list);
            printAverageTimes(list.getClass().getSimpleName());
    }

    private static void insert(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);
        }
        long endTime = System.nanoTime();
        insertTime = endTime - startTime;
    }

    private static void access(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        accessTime = endTime - startTime;
    }
    private static void remove(List<Integer> list) {
        long startTime = System.nanoTime();
        while (!list.isEmpty()) {
            list.remove(0);
        }
        long endTime = System.nanoTime();
        removeTime = endTime - startTime;
    }

    private static void printAverageTimes(String listType) {
        System.out.println(listType + " insertion time: " + insertTime + " ns");
        System.out.println(listType + " access time: " + accessTime + " ns");
        System.out.println(listType + " removal time: " + removeTime + " ns");
    }
}