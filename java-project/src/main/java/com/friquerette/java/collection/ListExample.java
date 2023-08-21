package com.friquerette.java.collection;

import java.util.*;

public class ListExample {


    /**
     * List have the following implementation:
     *  - ArrayList: dynamic array which implement list can be read in one direction
     *  - LinkedList: a double link list, can be read in both direction
     *  - Vector: like a List but synchronized, so slower than a List
     *  - Stack: inherit of Vector to handle a stack LIFO (Last In First Out)
     *
     * @param args
     */
    public static void main(String[] args) {
        // with no generic here
        LinkedList linkedList = new LinkedList();
        List myList = new ArrayList();

        myList.add("test 1");
        myList.add("test 2");
        myList.add("test 3");

        // by a reference of an object in the list or a index, here by index
        myList.remove(2);

        // Access by index
        String string = (String) myList.get(0);

        // to get the size of the list, number of object in  the list
        int size = myList.size();

        // three ways to iterate tbe list
        //      - first way, here by iterator
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
        }
        //      - second way, the for each loop from java
        for (Object object : myList) {
            String next = (String) object;
        }
        //      - third with the standard for loop
        for (int i = 0; i < myList.size(); i++) {
            Object next = myList.get(i);
        }

        // empty a list
        myList.clear();
    }
}
