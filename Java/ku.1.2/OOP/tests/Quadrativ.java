import javax.swing.*;

public class Quadrativ{
static int a, b, c;

//Method to calculate x1
static double FirstX(){
    return ((-b) + (b ^ 2 - (4 * a * c))) / 2 * a;
}

//Method to calculate x2
static double SecondX(){
    return ((-b) - (b ^ 2 - (4 * a * c))) / 2 * a;
}

public static void main(String[] args){
    int a = Integer.parseInt(JOptionPane.showInputDialog("Input the value of a"));
    int b = Integer.parseInt(JOptionPane.showInputDialog("Input the value of b"));
    int c = Integer.parseInt(JOptionPane.showInputDialog("Input the value of c"));

    JOptionPane.showMessageDialog(null, "The first value of x is" + FirstX() + "and the Second value of x is " + SecondX());
}

}