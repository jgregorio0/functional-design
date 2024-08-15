package dev.jgregorio.course.functional.design.functional.basics.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class FibonacciFunctionalMemoize {
    // Example cache size, adjust based on needs
    private static final int arraySizeFactor = 100;
    private static List<Integer> fibCache = new ArrayList<>(arraySizeFactor);
    static {
        fibCache.add(null);// fibonacci 0 do not exist
        fibCache.add(0); // fibonacci 1 = 0
        fibCache.add(1); // fibonacci 2 = 1
    }
    private static UnaryOperator<int[]> fibonacciOperator = fib -> new int[]{fib[1], fib[0] + fib[1]};

    private static void calcFibonacciMemoized(int n) {
        try {
            if (n <= fibCache.size()) {
                // IF fibonacci n is calculated already
                return;
            }
            // IF fibonacci n is NOT calculated AND there is size
            calcFibonacciRecursive(n);
        } catch (IndexOutOfBoundsException e) {
            // IF fibonacci n is NOT calculated AND there is NOT size
            ((ArrayList)fibCache).ensureCapacity(fibCache.size() + arraySizeFactor);
            calcFibonacciRecursive(n);
        }
    }

    private static void calcFibonacciRecursive(int n) {
        fibCache.add(fibCache.get(n - 1) + fibCache.get(n - 2));
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Fibonacci sequence up to " + n + ":");
        calcFibonacciMemoized(n);
        IntStream.range(1, n + 1)
                .forEach(i -> System.out.println(fibCache.get(i)));
    }

}
