package com.friquerette.java.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeExample {
    /**
     * Deque is abbreviation for Double Ended QUEue and represents a double ended queue where this is possible to
     * add/remove from both end of the queue. It means that can use as a queue or a stack. Java has two implementation:
     *  - {@link ArrayDeque}: keep the element into a list
     *  - {@link LinkedList}: keep the element with traditional link between element
     *
     *  For the queue the element is added at the end (in the queue) and the first element is taken from head
     *  For the stack the element is added at the head and this is the head which is read first
     * @param args
     */
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque();
        // -> Queue mode
        deque.offerLast("element 1");
        deque.offerLast("element 2");
        String element1 = deque.pollFirst();
        String element2 = deque.pollFirst();

        // -> Stack mode
        deque.offerFirst("element 1");
        deque.offerFirst("element 2");
        element2 = deque.pollFirst();
        element1 = deque.pollFirst();

        // ===> ADD ELEMENT INTO THE DECK
        // -> add element into a Deque
        // add() add the element to the end like for addLast()
        deque.add("element 1");
        deque.addLast("element 2");
        deque.addFirst("element 3");
        // result [element 3, element 1, element 2]
        System.out.println(deque);

        // -> offer (like add) element into a Deque and can throw an exception if not possible
        // offer() add the element to the end like for addLast()/offerLast()
        deque.offer("element 4");
        deque.offerLast("element 5");
        deque.offerFirst("element 6");
        // result [element 6, element 3, element 1, element 2, element 4, element 5]
        System.out.println(deque);

        // -> push() add the element to the beginning and can throw an exception if not possible
        deque.push("element 7");
        // result [element 7, element 6, element 3, element 1, element 2, element 4, element 5]
        System.out.println(deque);

        // ===> GET ELEMENT FROM THE DECK (don't remove the element)
        // -> peek() return null if the stack is empty
        String element7a = deque.peek();
        String element7b = deque.peekFirst();
        String element5a = deque.peekLast();
        System.out.println(element7a + ", " + element7b + ", " + element5a);
        // -> getLast()/getFirst() can throw the exception NoSuchElementException
        String element7c = deque.getFirst();
        String element5c = deque.getLast();
        System.out.println(element7c + ", " + element5c);

        // copy the element into a new Deque
        Deque<String> deque2 = new ArrayDeque();
        deque2.addAll(deque);

        // ===> TAKE OUT ELEMENT FROM THE DECK
        // -> remove() also take the first element like removeFirst(), throw an exception if the Deck is empty
        System.out.println("\nremove()");
        System.out.println("element 5: " + deque2.removeLast());
        System.out.println("element 7: " + deque2.remove());
        System.out.println("element 6: " + deque2.removeFirst());
        deque2 = new ArrayDeque();
        deque2.addAll(deque);
        // -> poll() also take the first element like pollFirst(), return null if the stack is empty
        System.out.println("\npoll()");
        System.out.println("element 5: " + deque2.pollLast());
        System.out.println("element 7: " + deque2.poll());
        System.out.println("element 6: " + deque2.pollFirst());
        deque2 = new ArrayDeque();
        deque2.addAll(deque);
        // -> pop() similar to removeFirst(), throw an exception if the Deck is empty
        System.out.println("\npop()");
        System.out.println("element 7: " + deque2.pop());

        // copy the element into a new Deque
        deque2 = new ArrayDeque();
        deque2.addAll(deque);

        // ===> contains method
        System.out.println("\ncontains()");
        System.out.println("is element 5 present: " + deque2.contains("element 5"));

        // ===> contains method
        deque2 = new ArrayDeque();
        deque2.addAll(deque);
        System.out.println("\nsize(): " + deque2.size());

        // ===> ITERATE
        deque2 = new ArrayDeque();
        deque2.offerLast("element 1");
        deque2.offerLast("element 2");
        deque2.offerLast("element 3");
        System.out.println("Iterate element with an iterator");
        Iterator<String> iterator = deque2.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("\n---");

        System.out.println("Iterate element with a for each");
        for(String next : deque2) {
            System.out.println(next);
        }
        System.out.println("\n---");

        System.out.println("Iterate element with a java stream");
        deque2.stream().forEach(next -> System.out.println(next));
        System.out.println("\n---");
    }
}
