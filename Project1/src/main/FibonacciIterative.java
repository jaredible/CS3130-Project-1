/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/
package main;

/**
 * @author Jared Diehl
 * 
 *         Contains a function that will calculate
 *         Fibonacci numbers using an iterative definition.
 *         The input of this program is a nonnegative
 *         integer N; the output is the sum of the
 *         Fibonacci sequence up to N and the time in
 *         milliseconds the execution takes.
 */
public class FibonacciIterative {

  public static long fib(int n) {
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
    int n = FibonacciHelper.getN(args);

    long millisBefore = System.currentTimeMillis();
    long sum = fib(n);
    long millisAfter = System.currentTimeMillis();
    long millisElapsed = millisAfter - millisBefore;

    FibonacciHelper.displayInfo(n, sum, millisElapsed);
  }

}
