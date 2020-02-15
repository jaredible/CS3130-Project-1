/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/
package main;

/**
 * @author Jared Diehl
 * 
 *         Contains functions that are to be used across the
 *         entire project.
 */
public class FibonacciHelper {

  /**
   * If args[0] contains an integer, then it will be returned
   * instead of the default, {@link FibonacciConstants#N}.
   *
   * @param args the program's command-line arguments.
   * @return a Fibonacci number.
   */
  public static int getN(String[] args) {
    int n = FibonacciConstants.N;

    if (args.length > 0) {
      try {
        n = Integer.valueOf(args[0]);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }

    return n;
  }

  /**
   * Prints to standard out a comma-separated list of values.
   *
   * @param n the Fibonacci number.
   * @param sum the Fibonacci sum.
   * @param millis the time in milliseconds the summation took.
   */
  public static void displayInfo(int n, Object sum, long millis) {
    System.out.println(String.format("n: %d, sum: %s, millis: %d", n, sum, millis));
  }

}
