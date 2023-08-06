package com.friquerette.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Jdk16 {

    public static void main(String[] args) {
        // Stream to list
        // streamToList();

        // Record
        PointNotRecord pointNotRecord = new PointNotRecord(2, 3);
        System.out.println(pointNotRecord);

        record Point(int x, int y) {
        }
        Point pointRecord = new Point(2, 3);
        System.out.println(pointRecord);

        record PointCustom(int x, int y) {
            @Override
            public String toString() {
                // same as classical
                return "Point[x=" + x + ", y=" + y + "] with a special toString() method";
            }
        }
        PointCustom custom = new PointCustom(2, 3);
        System.out.println(custom);
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

    private static class PointNotRecord {
        int x;
        int y;
        PointNotRecord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            // same as classical
            return "Point[x=" + x + ", y=" + y + "]";
        }
    }


}
