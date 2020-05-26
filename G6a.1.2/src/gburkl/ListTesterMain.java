package gburkl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Callable;


/**
 * @author Georg Burkl
 * @version 2020-02-18
 */
public class ListTesterMain {

    private LinkedList<Integer> linkedList;
    private ArrayList<Integer> arrayList;

    public static void main(String[] args) {
        new ListTesterMain().test();
    }

    public void test() {
        this.linkedList = time((Callable<LinkedList<Integer>>) LinkedList::new, "create : LinkedList : ");
        this.arrayList = time((Callable<ArrayList<Integer>>) ArrayList::new, "create : ArrayList : ");
        time(() -> ListTester.addEnd(linkedList, 1000000), "addEnd : LinkedList : ");
        time(() -> ListTester.addEnd(arrayList, 1000000), "addEnd : ArrayList : ");
        time(() -> ListTester.addFirst(linkedList, 1000000), "addFirst : LinkedList : ");
        time(() -> ListTester.addFirst(arrayList, 1000000), "addFirst : ArrayList : ");
        time(() -> ListTester.deleteHalf(linkedList), "deleteHalf : LinkedList : ");
        time(() -> ListTester.deleteHalf(arrayList), "deleteHalf : ArrayList : ");
        System.out.println("sum LinkedList = " + time(() -> ListTester.sumIterator(linkedList), "sumIterator : LinkedList : "));
        System.out.println("sum ArrayList = " + time(() -> ListTester.sumIterator(arrayList), "sumIterator : ArrayList : "));
        System.out.println("sum LinkedList = " + time(() -> ListTester.sumIndex(linkedList), "sumIndex : LinkedList : "));
        System.out.println("sum ArrayList = " + time(() -> ListTester.sumIndex(arrayList), "sumIndex : ArrayList : "));
        /*System.out.println("LinkedList = " + */time(() -> ListTester.listIterator(linkedList), "listIterator : LinkedList : ")/*)*/;
        /*System.out.println("ArrayList = " + */time(() -> ListTester.listIterator(arrayList), "listIterator : ArrayList : ")/*)*/;
        /*System.out.println("LinkedList = " + */time(() -> ListTester.listIndex(linkedList), "listIndex : LinkedList : ")/*)*/;
        /*System.out.println("ArrayList = " + */time(() -> ListTester.listIndex(arrayList), "listIndex : ArrayList : ")/*)*/;
    }

    void time(Runnable runnable, String text) {
        long start = System.nanoTime();
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println(text + (end - start));
    }

    <T> T time(Callable<T> callable, String text) {
        T ret = null;
        long start = System.nanoTime();
        try {
            ret = callable.call();
        } catch (Exception ignored) {
        }
        long end = System.nanoTime();
        System.out.println(text + (end - start));
        return ret;
    }
}
