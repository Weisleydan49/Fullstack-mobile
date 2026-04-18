/*Write a Java program that reads Temperature in degrees Fahrenheit and converts it to degrees centigrade. 
* Formula: C = (F - 32) * 5/9
**/ 

import javax.swing.*;

public class Temperature{
    public static void main(String[] args){
        double farenheight = Double.parseDouble(JOptionPane.showInputDialog("Enter temp in degrees farenheight"));
        double centigrade = (farenheight - 32) * 5/9;
        JOptionPane.showMessageDialog(null, "The temperature in centigrade is: " + centigrade);
    }
}