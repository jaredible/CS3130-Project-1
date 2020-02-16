/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/
package main;

/**
 * @author Jared Diehl
 * 
 *         Contains a function that will calculate
 *         Fibonacci numbers using an integer array.
 *         The input of this program is a nonnegative
 *         integer N; the output is the largest Fibonacci
 *         number that is less than the maximum digits
 *         specified; the time in milliseconds the execution
 *         takes; and an error message when the max amount
 *         of digits have been reached.
 */
import java.math.BigInteger;
import java.util.Arrays;

public class FibonacciArray {

  private static final int DIGITS_MAX = 100;
  private static final boolean ALLOW_REACH_DIGITS_MAX = true;

  /**
   * Calculates the nth term of the Fibonacci sequence
   * using arrays or throws an {@link FibonacciException}
   * if the max amount of digits have been reached.
   *
   * @param n the nth number of the Fibonacci sequence.
   * @param flag used to allow the max amount of digits to be reached.
   * @return the nth term of the Fibonacci sequence.
   */
  public static String fib(int n, boolean flag) throws FibonacciException {
    int[][] array = new int[3][DIGITS_MAX];

    array[1][DIGITS_MAX - 1] = 1;

    int i = 2;
    int carry = 0;
    int num;
    for (i = 2; i <= n || flag; i++) {
      for (int j = DIGITS_MAX - 1; j >= 0; j--) {
        num = array[(i + 1) % 3][j] + array[(i + 2) % 3][j] + carry;
        array[(i + 3) % 3][j] = num % 10;
        carry = num / 10;
      }

      if (array[(i - 1) % 3][0] != array[(i + 0) % 3][0]) {
        System.out.println(String.format("Biggest Fibonacci number less than %d digits is:\n%s", DIGITS_MAX, arrayToString(array[(i - 1) % 3])));
        throw new FibonacciException(String.format("Reached %d digits!", DIGITS_MAX));
      }
    }

    return new BigInteger(arrayToString(array[(i - 1) % 3])).toString();
  }

  /**
   * Converts an array into a {@link String}.
   *
   * @param array the integer array to convert.
   * @return a converted integer array into a {@link String}.
   */
  private static String arrayToString(int[] array) {
    String str = Arrays.toString(array).replaceAll("\\[|\\]|,|\\s", "");
    return new BigInteger(str).toString();
  }

  public static void main(String[] args) {
    int n = FibonacciHelper.getN(args);

    try {
      long millisBefore = System.currentTimeMillis();
      String sum = fib(n, ALLOW_REACH_DIGITS_MAX);
      long millisAfter = System.currentTimeMillis();
      long millisElapsed = millisAfter - millisBefore;

      FibonacciHelper.displayInfo(n, sum, millisElapsed);
    } catch (FibonacciException e) {
      e.printStackTrace();
    }
  }

}
