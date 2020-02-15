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

    long millisBefore, millisAfter, millisElapsed, sum, millisDifference = 0;

    millisBefore = System.currentTimeMillis();
    sum = FibonacciIterative.fib(n);
    millisAfter = System.currentTimeMillis();
    millisElapsed = millisAfter - millisBefore;
    millisDifference -= millisElapsed;
    
    FibonacciHelper.displayInfo(n, sum, millisElapsed);

    millisBefore = System.currentTimeMillis();
    sum = FibonacciRecursive.fib(n);
    millisAfter = System.currentTimeMillis();
    millisElapsed = millisAfter - millisBefore;
    millisDifference += millisElapsed;
    
    FibonacciHelper.displayInfo(n, sum, millisElapsed);
    
    System.out.println(String.format("Summing the Fibonacci sequence using recursion took %d milliseonds longer than iterative.", millisDifference));
  }

}
