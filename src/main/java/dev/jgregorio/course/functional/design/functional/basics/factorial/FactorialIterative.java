package dev.jgregorio.course.functional.design.functional.basics.factorial;

import java.math.BigInteger;

public class FactorialIterative {

    // Method to calculate factorial iteratively
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE; // Initialize result
        
        // Iterative loop until n becomes 0
        while (n > 0) {
            result = result.multiply(BigInteger.valueOf(n)); // Multiply result by n
            n--; // Decrement n by 1
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(n + "! = " + factorial(n));
    }
}