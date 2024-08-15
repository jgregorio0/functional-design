package dev.jgregorio.course.functional.design.functional.basics.fibonacci;

public class FibonacciIterative {

    // Method to calculate factorial
    public static Long fibonacci(int n) {
        // initial condition
        if (n < 1) {
            return null;
        }
        if (n <= 2) {
            return 1L;
        }
        // fibonacci iteration
        Long fib1;
        Long fib2 = 1L;
        Long fib3 = 1L;
        int count = 2;
        while(count <= n) {
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1 + fib2;
            n++;
        }
        // result
        return fib3;
    }

    public static void main(String[] args) {
        int n = 1000; // Example input
        System.out.println("fibonacci de n =" + fibonacci(n));
    }
}
