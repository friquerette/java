package com.friquerette.java;

import java.time.DayOfWeek;


public class Jdk14 {

    public static void main(String[] args) throws Exception {
        var message = "Switch expression";
        System.out.println(message);
    }
    public static int before(DayOfWeek day) throws Exception {
        int numLetters;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
            case THURSDAY:
                numLetters = 7;
                break;
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalAccessException("not a day:" + day);
        }
        return numLetters;
    }

    public static int withSwitchStatement(DayOfWeek day) {
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY, THURSDAY -> 7;
            case SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
    }

}
