/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/
package main;

/**
 * @author Jared Diehl
 * 
 *         A program that outputs a Fibonacci number, using a recursive algorithm, given an input N.
 */
public class FibonacciRecursive {

  public static long fib(int n) {
    if (n <= 1)
      return n;
    else
      return fib(n - 1) + fib(n - 2);
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
