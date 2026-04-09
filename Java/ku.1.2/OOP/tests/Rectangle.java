import javax.swing.*;

public class Rectangle {
    public static void main(String[] args) {
        String width = JOptionPane.showInputDialog("Enter width");
        String length = JOptionPane.showInputDialog("Enter length");
        int w = Integer.parseInt(width);
        int l = Integer.parseInt(length);
        int area = w * l;
        JOptionPane.showMessageDialog(null, "The are of the rectangle is " + area + "  squared cm");
    }
}