package dev.jgregorio.course.functional.design.functional.basics.fibonacci;

public class FibonacciRecursive {

    // Method to calculate factorial
    public static long fibonacci(int n) {
        return n < 1
                ? null
                : n <= 2
                    ? 1
                    : fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 1000; // Example input
        System.out.println("fibonacci de n =" + fibonacci(n));
        System.out.println("execution time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
