/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/
package main;

import java.util.concurrent.TimeUnit;

/**
 * @author Jared Diehl
 * 
 *         Contains a function that will calculate
 *         Fibonacci numbers using a recursive definition.
 *         The input of this program is a nonnegative
 *         integer N; the output is the nth term of the
 *         Fibonacci sequence and the time in
 *         milliseconds the execution takes.
 */
public class FibonacciRecursive {

  /**
   * Calculates the nth term of the Fibonacci sequence
   * using a recursive algorithm.
   *
   * @param n the nth number of the Fibonacci sequence.
   * @return the nth term of the Fibonacci sequence.
   */
  public static long fib(int n) {
    if (n <= 1)
      return n;
    else
      return fib(n - 1) + fib(n - 2);
  }

  public static void main(String[] args) {
    if (FibonacciConstants.TEST) {
      long nanosBefore, nanosAfter, nanosElapsed;

      for (int i = 0; i <= FibonacciConstants.N; i++) {
        nanosBefore = System.nanoTime();
        fib(i);
        nanosAfter = System.nanoTime();
        nanosElapsed = nanosAfter - nanosBefore;

        System.out.println(String.format("%.4f", TimeUnit.MILLISECONDS.convert(nanosElapsed, TimeUnit.NANOSECONDS)));
      }
    } else {
      int n = FibonacciHelper.getN(args);

      long millisBefore = System.currentTimeMillis();
      long sum = fib(n);
      long millisAfter = System.currentTimeMillis();
      long millisElapsed = millisAfter - millisBefore;

      FibonacciHelper.displayInfo(n, sum, millisElapsed);
    }
  }

}
