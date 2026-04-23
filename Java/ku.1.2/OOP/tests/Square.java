package tests;

public class Square {
    public static void main(String[] args) {
        int size = 5;
        for (int i = 0; i <= size; i += 1) {
            for (int j = 0; j <= size; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}