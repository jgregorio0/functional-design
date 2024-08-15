package dev.jgregorio.course.functional.design.functional.basics.fibonacci;

import sun.awt.X11.XSystemTrayPeer;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterable implements Iterable<Long> {
    private int n;

    public FibonacciIterable(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid index for Fibonacci sequence: " + n);
        }
        this.n = n;
    }

    @Override
    public Iterator<Long> iterator() {
        return new FibonacciIterator(n);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n1 = 1000;
        Iterator<Long> iterator = new FibonacciIterable(n1).iterator();
        Long fib = 0L;
        while(iterator.hasNext()){
            fib = iterator.next();
        }
        System.out.println("Fibonacci " + n1 + " = " + fib);
        System.out.println("execution time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
