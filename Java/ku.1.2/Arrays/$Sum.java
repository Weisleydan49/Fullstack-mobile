package Arrays;

import javax.swing.*;

public class $Sum {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter number " + (i + 1) + "of 5"));
            int sum = 0;
            for (int num : arr) {
                sum += num;
                System.out.println(sum);
            }
        }
    }

}