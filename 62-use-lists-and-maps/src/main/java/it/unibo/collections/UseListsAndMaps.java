package it.unibo.collections;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private final static int START_VALUE = 1000;
    private final static int END_VALUE = 2000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        var numbersAL = new ArrayList<Integer>(1000);
        for (int i = START_VALUE; i < END_VALUE; i++)
            numbersAL.add(i);
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        var numbersLL = new LinkedList<Integer>();
        numbersLL.addAll(IntStream.range(START_VALUE, END_VALUE).boxed().toList());

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        var temp = numbersAL.get(0);
        numbersAL.set(0, numbersAL.get(numbersAL.size()-1));
        numbersAL.set(numbersAL.size()-1, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        numbersAL.forEach((element) -> {
            System.out.println(element + " ");
        });
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        time = System.nanoTime() - time;
        for (int i = 0; i < 100000; i++)
            numbersAL.addFirst(null);
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Time to add 100'000 element to the head of an array list:"
                + time 
                + "ns (" 
                + millis 
                + "ms)");

        time = System.nanoTime() - time;
        for (int i = 0; i < 100000; i++)
            numbersLL.addFirst(null);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Time to add 100'000 element to the head of a linked list:"
                + time 
                + "ns (" 
                + millis 
                + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime() - time;
        for (int i = 0; i < 1000; i++)
            numbersAL.get(numbersAL.size()/2);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Time to read 1000 element from the middle of an arrayList:"
                + time 
                + "ns (" 
                + millis 
                + "ms)");

                time = System.nanoTime() - time;
        for (int i = 0; i < 1000; i++)
            numbersLL.get(numbersLL.size()/2);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Time to read 1000 element from the middle of a linked list:"
                + time 
                + "ns (" 
                + millis 
                + "ms)");


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
        var population = new HashMap<String, BigInteger>();
        population.put("Africa", new BigInteger("1110635000"));
        population.put("Americas", new BigInteger("972005000"));
        population.put("Antartica", new BigInteger("0"));
        population.put("Asia", new BigInteger("4298723000"));
        population.put("Europe", new BigInteger("742452000"));
        population.put("Oceania", new BigInteger("38304000"));
        /*
         * 8) Compute the population of the world
         */
        for(final var entry : population.entrySet()){
            System.out.println("Continente:"+entry.getKey()+"\tPopolazione:" + entry.getValue().toString());
        }
    }
}
