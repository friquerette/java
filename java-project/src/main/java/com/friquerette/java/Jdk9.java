package com.friquerette.java;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Jdk9 {
    public static void main(String[] args) {
        var message = "collection Factories";
        System.out.println(message);

        // before
        Set<String> oldSet = new HashSet<>();
        oldSet.add("a");
        oldSet.add("b");
        oldSet.add("c");
        oldSet = Collections.unmodifiableSet(oldSet);
        // With Collection Factories
        Set<String> newSet = Set.of("a", "b", "c");
    }
}
