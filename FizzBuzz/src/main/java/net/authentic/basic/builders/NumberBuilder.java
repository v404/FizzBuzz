package net.authentic.basic.builders;

public class NumberBuilder {

    private int number;

    private NumberBuilder(int number) {
        this.number = number;
    }

    public void build(int value, Runnable runnable) {
        if (number % value == 0) {
            runnable.run();
        }
    }

    public static NumberBuilder of(int value) {
        return new NumberBuilder(value);
    }
}
