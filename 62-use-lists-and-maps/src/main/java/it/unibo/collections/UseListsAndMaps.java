package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> aList = new ArrayList<Integer>();
        for ( int i = 0; i < 1000; i++) {
            aList.add(i + 1000);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> lList = new LinkedList<Integer>(aList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = aList.get(0);
        aList.set(0, aList.get(aList.size() - 1));
        aList.set(aList.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer elem : aList) {
            System.out.println(elem);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time;
        long millis;

        time = countAddTime(lList);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Adding elements in LinkedList in " + time + "ns (" + millis + "ms)");
        countAddTime(aList);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Adding elements in ArrayList in " + time + "ns (" + millis + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = countReadTime(lList);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Reading 1000 time the element in the middle of the LinkedList in " + time + "ns (" + millis + "ms)");
        countReadTime(aList);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Reading 1000 time the element in the middle of the ArrayList in " + time + "ns (" + millis + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> map = new HashMap<String, Long>();
        map.put("Africa", 1_110_635_000l);
        map.put("Americas", 972_005_000l);
        map.put("Antartica", 0l);
        map.put("Asia", 4_298_723_000l);
        map.put("Europe", 742_452_000l);
        map.put("Oceania", 38_304_000l);
        /*
         * 8) Compute the population of the world
         */
        Long tot = 0l;
        for (final Long elem : map.values()) {
            tot = tot + elem;
        }
        System.out.println(tot);
    }

    static long countAddTime (List<Integer> l) {
        long time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            l.add(0, i);
        }
        time = System.nanoTime() - time;
        return time;
    }

    static long countReadTime (List<Integer> l) {
        long time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            l.get(l.size() / 2);
        }
        time = System.nanoTime() - time;
        return time;
    }
}
