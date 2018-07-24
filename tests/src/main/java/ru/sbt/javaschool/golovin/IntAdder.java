package ru.sbt.javaschool.golovin;

public class IntAdder {
    public static int add(final int a, final int b) {
        final long result = (long)a + b;
        if (result > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return (int)result;
    }
}
