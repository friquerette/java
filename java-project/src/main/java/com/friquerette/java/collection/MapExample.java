package com.friquerette.java.collection;

import java.util.*;

public class MapExample {
    private static record Customer(String customerId, String name) {
    }

    ;

    /**
     * List of Map implementation:
     * - HashMap: a hashmap use internally a hashTable to store the object, fast to look up but no order
     * - TreeMap: which implement SortedMap and is sortable, the tree is sorted
     * - HashTable: similar to HashMap, the old version synchronised
     * - ConcurrentHashMap: more save and performant for
     *
     * @param args
     */
    public static void main(String[] args) {
        Customer customer1 = new Customer("123", "Diana Anderson");
        Customer customer2 = new Customer("546", "John Anderson");

        Map<String, Customer> map1 = new HashMap<>();
        // -> the method put() take only object, no primitive
        map1.put(customer1.customerId, customer1);
        map1.put(customer2.customerId, customer2);
        // the value null can be use here
        map1.put(null, customer1);
        System.out.println("for null key:" + map1.get(null));
        map1.put("124zz", null);
        System.out.println("for null value:" + map1.get("124zz"));

        System.out.println("map1: " + map1);
        System.out.println("\n---");

        // -> the method putAll()
        Map<String, Customer> map2 = new HashMap<>();
        map2.putAll(map1);
        System.out.println("map1: " + map1);
        System.out.println("\n---");

        // -> the method size()
        System.out.println("size: " + map1.size());

        // -> the method isEmpty()
        System.out.println("isEmpty: " + map1.isEmpty());
        System.out.println("\n---");

        // -> the method containsKey and containsValue
        System.out.println("containsKey: " + map1.containsKey("124zz"));
        System.out.println("containsValue: " + map1.containsValue(customer1));

        // -> the method remove
        map1.remove("124zz");
        System.out.println("remove here 124zz: " + map1.containsKey("124zz"));
        System.out.println("\n---");

        // -> the method replace: clear the map
        map1.put("124zz", customer2);
        Customer customerTmp = map1.replace("124zz", customer1);
        System.out.println("replace (the previous object value return by the method here customer2): " + customerTmp);
        System.out.println("\n---");

        // ==> The iterator
        // -> with while
        System.out.println("\n--- while");
        Iterator<String> keyIterator = map1.keySet().iterator();
        while (keyIterator.hasNext()) {
            String next = keyIterator.next();
            System.out.println("key is:" + next + ", and value:" + map1.get(next));
        }
        // -> with for each
        System.out.println("\n--- for each");
        for (String next : map1.keySet()) {
            System.out.println("key is:" + next + ", and value:" + map1.get(next));
        }
        // -> with Java Stream using a Key Using
        System.out.println("\n--- for stream");
        map1.entrySet().forEach((Map.Entry<String, Customer> entry) -> {
            System.out.println("key is:" + entry.getKey() + ", and value:" + entry.getValue());
        });

        // -> the method clear: clear the map
        map1.clear();
        System.out.println("clear (isEmpty ??): " + map1.isEmpty());

        // ===> difference between HashMap and TreeMap
        System.out.println("\n--- for HashMap");
        Map<String, Customer> hashMap = new HashMap<>();
        hashMap.put("z", new Customer("z", "Diana Anderson"));
        hashMap.put("g", new Customer("g", "Diana Anderson"));
        hashMap.put("t", new Customer("t", "Diana Anderson"));
        hashMap.put("r", new Customer("t", "Diana Anderson"));
        hashMap.entrySet().forEach((Map.Entry<String, Customer> entry) -> {
            System.out.println("key is:" + entry.getKey() + ", and value:" + entry.getValue());
        });

        System.out.println("--- for TreeMap");
        Map<String, Customer> treeMap = new TreeMap<>();
        treeMap.putAll(hashMap);
        treeMap.entrySet().forEach((Map.Entry<String, Customer> entry) -> {
            System.out.println("key is:" + entry.getKey() + ", and value:" + entry.getValue());
        });

        System.out.println("\n--- for TreeMap");
        TreeMap<String, String> sortedMap = new TreeMap(/** can provide a custom comparator here **/);
        sortedMap.put("a", "one");
        sortedMap.put("b", "two");
        sortedMap.put("c", "three");
        // iterate in reverse order
        sortedMap.descendingKeySet().forEach((String key) -> {
            System.out.println("key is:" + key + ", and value:" + sortedMap.get(key));
        });


        sortedMap.headMap("c");
    }

}
