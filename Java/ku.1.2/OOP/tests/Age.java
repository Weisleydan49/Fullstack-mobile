import javax.swing.*;

public class Age{
    public static void main(String[] args){
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));

        if(age >= 18){
            JOptionPane.showMessageDialog(null,"ADULT");
        }
        else{
            JOptionPane.showMessageDialog(null,"CHILD");
            }
    }
}