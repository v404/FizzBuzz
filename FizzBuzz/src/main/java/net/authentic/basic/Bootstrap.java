package net.authentic.basic;

import net.authentic.basic.builders.NumberBuilder;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Bootstrap {

    public static void main(final String... args) {
        final Scanner scanner = new Scanner(System.in);
        final Logger logger = Logger.getLogger(Bootstrap.class.getName());
        logger.log(Level.INFO, "Podaj jakąś liczbę");

        while (scanner.hasNext()) {
            final int numbers;
            try {
                numbers = Integer.parseInt(scanner.next());
                IntStream.range(0, numbers).forEachOrdered(i -> {
                    NumberBuilder.of(i).build(3, () -> logger.info(i + " Fizz"));
                    NumberBuilder.of(i).build(5, () -> logger.info(i + " Buzz"));
                    NumberBuilder.of(i).build(15, () -> logger.info(i + " FizzBuzz"));
                    logger.info(i + ".");
                });
            } catch (NumberFormatException ex) {
                logger.log(Level.WARNING, "Podany argument nie jest liczbą!");
            }
        }
    }
}
