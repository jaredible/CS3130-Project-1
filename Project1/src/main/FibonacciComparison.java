/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/
package main;

/**
 * @author Jared Diehl
 * 
 *         Outputs the sum of the
 *         Fibonacci sequence using iteration and
 *         recursion up to N and the time in
 *         milliseconds the executions take.
 */
public class FibonacciComparison {

  public static void main(String[] args) {
    int n = FibonacciHelper.getN(args);

    long millisBefore, millisAfter, sum;

    millisBefore = System.currentTimeMillis();
    sum = FibonacciIterative.fib(n);
    millisAfter = System.currentTimeMillis();

    FibonacciHelper.displayInfo(n, sum, millisAfter - millisBefore);

    millisBefore = System.currentTimeMillis();
    sum = FibonacciRecursive.fib(n);
    millisAfter = System.currentTimeMillis();

    FibonacciHelper.displayInfo(n, sum, millisAfter - millisBefore);
  }

}
