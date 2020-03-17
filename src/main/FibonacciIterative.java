/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/
package main;

/**
 * @author Jared Diehl
 * 
 *         A program that outputs a Fibonacci number, using an iterative algorithm, given an input N.
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
    if (args.length > 0) {
      try {
        int n = Integer.valueOf(args[0]);

        if (n < 1) {
          throw new IllegalArgumentException("Must be a positive integer!");
        }

        System.out.println(fib(n));
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    } else {
      throw new IllegalArgumentException("Must supply a postive integer!");
    }
  }

}
