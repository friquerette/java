package com.friquerette.java;

public class Jdk15 {
    public static void main(String[] args) {
        var message = """
                text block feature (start at the second line
                    From JDK15 (here with only one tab at the begining of the line)
                """;
        // formatted() method since JDK15   
        var secondMessage = """
                Message number %s.
                """.formatted(2);
        System.out.println(message);
        System.out.println(secondMessage);
    }
}
