package com.friquerette.java.collection;

import java.util.Iterator;
import java.util.Stack;

public class StackList {

    /**
     * Stack is like a stack of a plate Last In First Out (LIFO)
     * Stack is since java 1.0 and is synchronized. To not being synchronized, use a Java Deque as Stack
     * @param args
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("zero");
        stack.push("one");
        stack.push("two");
        // peek() Read top of the stack (don't remove)
        String peekTwo = stack.peek();
        System.out.println("peek: " + peekTwo);
        // result [zero, one, two]
        System.out.println(stack);

        // pop() get a element (remove from the stack)
        String two = stack.pop();
        String one = stack.pop();
        System.out.println("pop: " + two + ", " + one);

        // search() get the index position (ranking when it will pop)
        int index1 = stack.search("zero");
        System.out.println("search: zero is at index 1:  " + index1);
        stack.push("one");
        int index2 = stack.search("zero");
        System.out.println("search: zero is at index 2:  " + index2);
        stack.push("two");
        int index3 = stack.search("zero");
        System.out.println("search: zero is at index 3:  " + index3);
        int index_minus_1 = stack.search("ABC");
        System.out.println("search: ABC is at index -1: " + index_minus_1);

        System.out.println("\n---");
        // iterate, the element are display in insertion order: zero, one, two
        System.out.println("Iterate element with an iterator");
        Iterator<String> iterator = stack.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println("Iterate element with a for each");
        for(String next : stack) {
            System.out.println(next);
        }

        System.out.println("Iterate element with a java stream");
        stack.stream().forEach(next -> System.out.println(next));
    }
}
