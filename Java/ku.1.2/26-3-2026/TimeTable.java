public class TimeTable {
    public static void main(String[] args) {
        int size = 9;
        
        // Print header row
        System.out.print(" * |");
        for (int col = 1; col <= size; col++) {
            System.out.printf("%3d", col);
        }
        System.out.println();
        
        // Print separator
        System.out.println("-------------------------------");
        
        // Print table rows
        for (int row = 1; row <= size; row++) {
            System.out.printf("%2d |", row);
            for (int col = 1; col <= size; col++) {
                System.out.printf("%3d", row * col);
            }
            System.out.println();
        }
    }
}
