import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListPerformanceTest {

    public static void main(String[] args) {

        testPerformance(50000);
        testPerformance(500000);
    }

    private static void testPerformance(int size) {

        LinkedList<Integer> list = new LinkedList<>();

        // load list with values
        for(int i = 0; i < size; i++){
            list.add(i);
        }

        System.out.println("\n--- Testing with " + size + " integers ---");

        // iterator traversal time
        long start1 = System.currentTimeMillis();
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            it.next();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Iterator traversal: " + (end1 - start1) + " ms");


        // get(index) traversal time
        long start2 = System.currentTimeMillis();
        for(int i = 0; i < list.size(); i++){
            list.get(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("get(index) traversal: " + (end2 - start2) + " ms");
    }
}

/*
EXPLANATION:

Iterator traversal is MUCH faster with LinkedList because LinkedList is node based.
An iterator walks node to node sequentially which is O(n). BUT get(index) in a LinkedList must walk from the beginning EACH TIME
to reach the index — which turns traversal into O(n^2) time.

When size jumps from 50k to 500k — the get(index) approach becomes massively slower,
which demonstrates why LinkedList is NOT designed for index based access. This program confirms LinkedList is good for sequential 
traversal but terrible for random access.
*/