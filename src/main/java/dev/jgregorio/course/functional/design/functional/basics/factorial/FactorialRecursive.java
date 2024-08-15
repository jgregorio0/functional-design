package dev.jgregorio.course.functional.design.functional.basics.factorial;

import java.math.BigInteger;

public class FactorialRecursive {

    // Method to calculate factorial
    public static BigInteger factorial(int n) {
        return n == 0
                ? BigInteger.ONE
                : BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    public static void main(String[] args) {
        int n = 1000; // Example input
        System.out.println(n + "! =" + factorial(n));
    }
}
