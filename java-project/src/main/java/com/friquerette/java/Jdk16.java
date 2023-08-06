package com.friquerette.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Jdk16 {

    public static void main(String[] args) {
        streamToList();
    }

    public static void streamToList() {
        List<String> integersAsString = Arrays.asList("1", "2", "3");

        // with the collect and the Collectors.toList()
        List<Integer> intsOldWay = integersAsString.stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(intsOldWay);

        // with the streams toList(), an unmodifiableList list
        List<Integer> intsNewWay = integersAsString.stream().map(Integer::parseInt)
                .toList();
        System.out.println(intsNewWay);


    }
}
