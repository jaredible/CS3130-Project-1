/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/

/**
 * @author Jared Diehl
 * 
 *         Outputs the nth term of the
 *         Fibonacci sequence using iteration and
 *         recursion and the time in
 *         milliseconds the executions take.
 */
public class FibonacciComparison {
  
  public static long fibRecursive(int n) {
    if (n <= 1)
      return n;
    else
      return fibRecursive(n - 1) + fibRecursive(n - 2);
  }
  
  public static long fibIterative(int n) {
    if (n <= 1)
      return n;

    long prevFib = 0;
    long fib = 1;

    long tmp;
    for (int i = 1; i < n; i++) {
      tmp = fib;
      fib += prevFib;
      prevFib = tmp;
    }

    return fib;
  }

  public static void main(String[] args) {
    if (args.length > 0) {
      try {
        int n = Integer.valueOf(args[0]);

        if (n < 1) {
          throw new IllegalArgumentException("Must be a positive integer!");
        }

        long nanosBefore, nanosAfter, nanosElapsed, nanosDifference = 0;

        nanosBefore = System.nanoTime();
        fibIterative(n);
        nanosAfter = System.nanoTime();
        nanosElapsed = nanosAfter - nanosBefore;
        nanosDifference -= nanosElapsed;

        System.out.println(String.format("The iterative algorithm took approximately %.4f milliseconds to execute.", nanosElapsed / 1000.0 / 1000.0));

        nanosBefore = System.nanoTime();
        fibRecursive(n);
        nanosAfter = System.nanoTime();
        nanosElapsed = nanosAfter - nanosBefore;
        nanosDifference += nanosElapsed;

        System.out.println(String.format("The recursive algorithm took approximately %.4f milliseconds to execute.", nanosElapsed / 1000.0 / 1000.0));

        System.out.println(String.format("The recursive algorithm took approximately %.4f milliseconds longer than the iterative algorithm to execute.", nanosDifference / 1000.0 / 1000.0));
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    } else {
      throw new IllegalArgumentException("Must supply a postive integer!");
    }
  }

}
