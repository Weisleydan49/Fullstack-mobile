/*
 * Exercise Product1ToN:
 * 1 to 10: 3628800
 * 1 to 11: 39916800
 * 1 to 12: 479001600
 * 1 to 13: 1932053504 (Wait, 13! is 6227020800, so this is overflowed)
 * 1 to 14: 1278945280 (Overflowed)
 *
 * Explanation: The 'int' type in Java is a 32-bit signed integer with a maximum value of 2,147,483,647.
 * 13! exceeds this limit, resulting in integer overflow and incorrect results.
 */
public class Product1ToN {
    public static void main(String[] args) {
        computeProduct(10);
        computeProduct(11);
        computeProduct(12);
        computeProduct(13);
        computeProduct(14);
    }

    public static void computeProduct(int n) {
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        System.out.println("Product 1 to " + n + " is " + product);
    }
}
