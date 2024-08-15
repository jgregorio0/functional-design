package dev.jgregorio.course.functional.design.functional.basics.fibonacci;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Long> {
    public static Map<Integer, Long> fibonaccis = new HashMap<>();
    private Long fib1 = 0L;
    private Long fib2 = 1L;
    private int count = 0;
    private int n;

    public FibonacciIterator(int n) {
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        return count < n;
    }

    @Override
    public Long next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Long current = fib1;
        fib1 = fib2;
        fib2 = fib1 + current;
        count++;
        return current;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
