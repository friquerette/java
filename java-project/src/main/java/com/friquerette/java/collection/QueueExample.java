package com.friquerette.java.collection;

import java.util.*;

/**
 * Queue implementation:
 *  - {@link LinkedList}: this is a standard link list
 *  - {@link ArrayDeque}: the element are store into an Array and can be read from both side (start or end of queue)
 *  - {@link PriorityQueue}: special queue where some element have "higher priority" then they can by-pass the other
 */
public class QueueExample {
    private record Customer(String name) { };

    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();
        queue.add(new Customer("Anna"));
        queue.add(new Customer("Alfred"));
        Customer anna = queue.poll();
        Customer alfred = queue.poll();
        System.out.println("first element pop is: " + anna);
        System.out.println("second element pop is: " + alfred);

        Queue<String> queue2 = new ArrayDeque<>(3);
        boolean added1 = queue2.add("1");
        System.out.println("is element added: " + added1);
        boolean added2 = queue2.offer("2");
        System.out.println("is element added: " + added2);
        boolean added3 = queue2.offer("3");
        System.out.println("is element added: " + added3);
        // -> the offer() return false if the element can't be added
        boolean added4 = queue2.offer("4");
        System.out.println("is element added: " + added4);
        // -> the add() return an exception if the element can't be added
        boolean added5 = queue2.add("5");
        System.out.println("is element added: " + added5);

        System.out.println("\n---");
        System.out.println("the list is 'full': " + queue2);
        System.out.println("\n---");

        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());

        // -> the method poll() return null if there is no element anymore
        System.out.println(queue2.poll()); // here null
        // -> the method remove() throw an exception if there is no element anymore
        // System.out.println(queue2.remove()); // here an exception

        System.out.println("\n---");
        System.out.println("the list is empty" + queue2);
        System.out.println("\n---");

        // peek() method read the first element (the element is not remove)
        queue.add(new Customer("Anna"));
        queue.add(new Customer("Alfred"));
        Customer newAnna = queue.peek();
        System.out.println("first element peek is: " + newAnna);
        System.out.println("the list is still 'full': " + queue);
        System.out.println("\n---");

        // -> the method size()
        System.out.println("size here three: " + queue.size());
        System.out.println("\n---");

        // -> the method contains()
        boolean contains1 = queue.contains(newAnna);
        System.out.println("contains Anna: " + contains1);
        System.out.println("\n---");

        // ===> Iterator
        System.out.println("Iterate element with an iterator");
        Iterator<Customer> iterator = queue.iterator();
        while(iterator.hasNext()) {
            Customer next = iterator.next();
            System.out.println(next);
        }
        System.out.println("\n---");

        System.out.println("Iterate element with a for each");
        for(Customer next : queue) {
            System.out.println(next);
        }
        System.out.println("\n---");

        System.out.println("Iterate element with a java stream");
        queue.stream().forEach(next -> System.out.println(next));
        System.out.println("\n---");

        // -> the method clear()
        System.out.println("the list is still 'full': " + queue);
        queue.clear();
        System.out.println("after clear, size is zero: " + queue.size());
    }
}
