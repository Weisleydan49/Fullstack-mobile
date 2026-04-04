import javax.swing.*;

    public class ComputeArea {
        public static void main(String[] args) {
            String R = JOptionPane.showInputDialog("Enter the radius:");
            int radius = Integer.parseInt(R);
            double PI = 3.14;
            double area = PI * radius * radius;
            JOptionPane.showMessageDialog(null, "The are is " + area);
        }
    }