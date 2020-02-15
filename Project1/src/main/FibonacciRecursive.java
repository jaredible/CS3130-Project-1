/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/
package main;

/**
 * @author Jared Diehl
 * 
 *         Contains a function that will calculate
 *         Fibonacci numbers using a recursive definition.
 *         The input of this program is a nonnegative
 *         integer N; the output is the sum of the
 *         Fibonacci sequence up to N and the time in
 *         milliseconds the execution takes.
 */
public class FibonacciRecursive {

  public static long fib(int n) {
    if (n <= 1)
      return n;
    else
      return fib(n - 1) + fib(n - 2);
  }

  public static void main(String[] args) {
    int n = FibonacciHelper.getN(args);

    long millisBefore = System.currentTimeMillis();
    long sum = fib(n);
    long millisAfter = System.currentTimeMillis();

    FibonacciHelper.displayInfo(n, sum, millisAfter - millisBefore);
  }

}
