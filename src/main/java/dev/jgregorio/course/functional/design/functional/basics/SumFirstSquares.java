package dev.jgregorio.course.functional.design.functional.basics;

public class SumFirstSquares {

    static int sumFirstTenSquaresRecursively(int sum, int i) {
        return (i > 10) ? sum : sumFirstTenSquaresRecursively(sum + i * i, i + 1);
    }

  final  public static void main(String[] args) {
        System.out.println("Result: " + sumFirstTenSquaresRecursively(0, 1));
    }
}
