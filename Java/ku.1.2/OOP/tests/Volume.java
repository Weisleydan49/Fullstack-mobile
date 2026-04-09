import javax.swing.*;

public class Volume{
    public static void main(String[] args){
        String length = JOptionPane.showInputDialog("Enter Length: ");
        String width = JOptionPane.showInputDialog("Enter width: ");
        String heigth = JOptionPane.showInputDialog("Enter height: ");

        int l = Integer.parseInt(length);
        int w = Integer.parseInt(width);
        int h = Integer.parseInt(heigth);

        int volume = l * w * h;

        JOptionPane.showMessageDialog(null, "The volume is " + volume + " cubic cm");


    }
}
