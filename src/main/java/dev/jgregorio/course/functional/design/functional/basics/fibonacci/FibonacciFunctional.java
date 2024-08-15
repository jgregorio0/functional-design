package dev.jgregorio.course.functional.design.functional.basics.fibonacci;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class FibonacciFunctional {
    private static int[] fibonacciInitialSequence = {0, 1};
    private static UnaryOperator<int[]> fibonacciOperator = fib -> new int[]{fib[1], fib[0] + fib[1]};

    public static int[] getFibonacci(int n) {
        return Stream
                .iterate(fibonacciInitialSequence, fibonacciOperator)
                .limit(n)
                .mapToInt(fib -> fib[0])
                .toArray();
    }

    public static void main(String[] args) {
        int n = 2;
        int[] fibonacciSequence = getFibonacci(n);
        System.out.println("Fibonacci sequence up to " + n + ":");
        Arrays.stream(fibonacciSequence).forEach(System.out::println);
    }
}
