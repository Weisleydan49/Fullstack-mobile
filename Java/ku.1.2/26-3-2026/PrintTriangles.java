import java.util.Scanner;

public class PrintTriangles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int numRows = in.nextInt();

        System.out.println("(a) PowerOf2Triangle");
        printPowerOf2Triangle(numRows);

        System.out.println("(b) PascalTriangle1");
        printPascalTriangle1(numRows);

        System.out.println("(c) PascalTriangle2");
        printPascalTriangle2(numRows);
        
        in.close();
    }

    public static void printPowerOf2Triangle(int numRows) {
        for (int row = 0; row < numRows; row++) {
            // Print leading spaces
            for (int col = 0; col < (numRows - row - 1) * 4; col++) {
                System.out.print(" ");
            }
            // Print increasing powers of 2
            for (int col = 0; col <= row; col++) {
                System.out.printf("%4d", (int) Math.pow(2, col));
            }
            // Print decreasing powers of 2
            for (int col = row - 1; col >= 0; col--) {
                System.out.printf("%4d", (int) Math.pow(2, col));
            }
            System.out.println();
        }
    }

    public static void printPascalTriangle1(int numRows) {
        for (int i = 0; i < numRows; i++) {
            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static void printPascalTriangle2(int numRows) {
        for (int i = 0; i < numRows; i++) {
            // Print leading spaces
            for (int col = 0; col < (numRows - i - 1) * 2; col++) {
                System.out.print(" ");
            }
            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
