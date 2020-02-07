package main;

public class Main {

  private static long fibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  public static void main(String[] args) {
    int n = 9;
    long pre = System.nanoTime();
    long result = fibonacci(n);
    long post = System.nanoTime();
    long elapsed = post - pre;
    System.out.println(String.format("n: %d, result: %d, time: %d", n, result, elapsed));
  }

}
