/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/

/**
 * @author Jared Diehl
 * 
 *         This program outputs the biggest Fibonacci number
 *         less than 100 digits and throws an exception
 *         when the 100 digits have been reached.
 */
import java.math.BigInteger;
import java.util.Arrays;

public class FibonacciArray {

  private static final int DIGITS_MAX = 100;

  public static void fib() throws Exception {
    int[][] array = new int[3][DIGITS_MAX];

    array[1][DIGITS_MAX - 1] = 1;

    int counter = 2;
    int carry = 0;
    int num;
    while (true) {
      for (int i = DIGITS_MAX - 1; i >= 0; i--) {
        num = array[(counter + 1) % 3][i] + array[(counter + 2) % 3][i] + carry;
        array[(counter + 3) % 3][i] = num % 10;
        carry = num / 10;
      }

      if (array[(counter - 1) % 3][0] != array[(counter + 0) % 3][0]) {
        System.out.println(String.format("The biggest Fibonacci number less than %d digits is:\n%s", DIGITS_MAX, arrayToString(array[(counter - 1) % 3])));
        throw new Exception(String.format("Reached %d digits!", DIGITS_MAX));
      }

      counter++;
    }
  }

  private static String arrayToString(int[] array) {
    String str = Arrays.toString(array).replaceAll("\\[|\\]|,|\\s", "");
    return new BigInteger(str).toString();
  }

  public static void main(String[] args) {
    try {
      fib();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
