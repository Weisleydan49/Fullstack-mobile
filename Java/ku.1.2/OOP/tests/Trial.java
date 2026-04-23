package OOP.tests;

public class Trial {
    public static void main(String[] args) {
        int size = 10;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= size; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Trianlge
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}