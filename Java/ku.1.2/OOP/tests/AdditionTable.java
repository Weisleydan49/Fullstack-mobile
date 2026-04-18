public class AdditionTable {
    public static void main(String[] args) {
        int[][] addition = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                addition[i][j] = (i + 1) + (j + 1);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%4d", addition[i][j]);
                System.out.println();
            }
        }
    }

}
