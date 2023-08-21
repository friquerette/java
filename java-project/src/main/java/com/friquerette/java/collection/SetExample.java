package com.friquerette.java.collection;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Stream;

public class SetExample {

    /**
     * Set have the following implementation:
     *  - EnumSet: for enum
     *  - HashSet: a set with no order
     *  - LinkedHashSet: a set order by insertion
     *  - TreeSet: a set order by natural order
     * @param args
     */
    public static void main(String[] args) {
        // HashSet no internal order
        Set<String> set1 = new HashSet<>();
        boolean added1 = set1.add("hello");
        boolean added2 = set1.add("hello");
        // true first time because added
        System.out.println(added1);
        // false second time because already exist
        System.out.println(added2);

        // Set.of
        Set<String> set2 = Set.of("Hello", "world", "1", "2", "3");

        // TreeSet is order its elements internally by the natural order (alphabetic sort or other sorter)
        Set<String>  set3 = new TreeSet<>();
        set3.add("Hello");
        set3.add("world");
        set3.add("1");
        set3.add("2");
        set3.add("3");

        // LinkedHashSet is order : byt the insertion order
        Set<String>  set4 = new LinkedHashSet<>();
        set4.add("Hello");
        set4.add("world");
        set4.add("1");
        set4.add("2");
        set4.add("3");

        // Iterate a Set
        //      - first way for a HashSet to iterate with an Iterator, the order is random,
        Iterator<String> iterator2 = set2.iterator();
        System.out.println("\n-----  Iterate for a HashSet");
        while(iterator2.hasNext()) {
            String next = iterator2.next();
            System.out.println(next);
        }
        //      - first way for a TreeSet to iterate with an Iterator, the order is the natural order
        Iterator<String> iterator3 = set4.iterator();
        //System.out.println("\n----- Iterate for a TreeSet (look for TreeSet order" + (1 / 0));
        while(iterator3.hasNext()) {
            String next = iterator3.next();
            System.out.println(next);
        }
        //      - second way the for each loop
        System.out.println("\n-----  Iterate with the for each loop");
        for(String element : set2) {
            System.out.println(element);
        }
        //      - third way the with java stream
        System.out.println("\n-----  Iterate with java stream ");
        Stream<String> stream = set2.stream();
        stream.forEach(e -> System.out.println(e));

        // to remove an element
        boolean remove1 = set4.remove("Hello");
        boolean remove2 = set4.remove("yes"); // yes doesnt exist
        System.out.println(remove1);
        System.out.println(remove2);

        System.out.println("before addAll: " + set1);

        // addAll method
        set1.addAll(Set.of("Hello", "world", "1", "2", "3"));
        System.out.println("after addAll: " + set1);

        // method removeAll
        set1.removeAll(Set.of("hello", "world", "1", "2", "3"));
        System.out.println("after removeAll: " + set1);

        // method retainAll, which retain all in both collection (here remain only Hello and not hello)
        set1.retainAll(Set.of("Hello", "world", "1", "2", "3"));
        System.out.println("after retainAll: " + set1);

        // method side
        int size = set1.size();
        System.out.println("size:" + size);

        // method contains
        boolean contains1 = set1.contains("hello");
        boolean contains2 = set1.contains("Hello");
        System.out.println("contains hello: " + contains1);
        System.out.println("contains Hello: " + contains2);

        // convert a set to a list
        List<String> list = new ArrayList<>();
        list.addAll(set1);
        System.out.println("a list: " + list);

        // Clear the set
        set1.clear();
        System.out.println("after clear: " + set1);

        // method isEmpty
        boolean isEmpty = set1.isEmpty();
        System.out.println("is empty: " + isEmpty);
    }
}
