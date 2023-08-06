package com.friquerette.java;

public class Jdk17 {

    public static void main(String[] args) {
        // here the interface "JungleAnimal" can inherit only of Monkey or Snake and is "sealed"
        // All inheriting classes of a sealed class must be marked with final, sealed or non-sealed
        // "non-sealed" allows any class to inherit of it (see Snake)
        var message = "sealed class (interface)";
        System.out.println(message);
    }

    /**
     * JungleAnimal, the sealed interface (can be a class)
     */
    public sealed interface JungleAnimal permits Monkey, Snake  {
    }

    /**
     * Monkey a final class (not inherit allowed), can be sealed also
     */
    public final class Monkey implements JungleAnimal {
    }

    /**
     * Snake a non-sealed all is permit now
     */
    public non-sealed class Snake implements JungleAnimal {
    }
}
