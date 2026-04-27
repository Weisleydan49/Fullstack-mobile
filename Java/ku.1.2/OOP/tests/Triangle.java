//Chekcerboard
public class Triangle {
    public static void main(String[] args) {
        int size = 8;
        for (int row = 0; row <= size; row++) {
            if (row % 2 == 0) {
                System.out.print(" ");
            }
            for (int col = 1; col < size; col += 1) {
                System.out.print("# ");
            }
            System.out.println();
        }

        // Triangle
        System.out.println();
        System.out.println();

        int size1 = 6;
        for (int col = 0; col <= size1; col++) {
            System.out.println(" ");
        }
        for (int row = 0; row <= size1; row += 1) {
            System.out.print("# ");
            // for (int col = 0; col <= size1; col += 1) {
            // System.out.print("# ");
            // }
        }
        System.out.println();

    }
}
