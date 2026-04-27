import javax.swing.JOptionPane;

public class AreaRec {
    static int length, width;

    // Method to compute the area of the rectangle
    static int ComputeArea() {
        return length * width;
    }
    //Method to display perimeter
    static int Perimeter(){
        return 2* (length + width);
    }  
    

    public static void main(String[] args) {
        length = Integer.parseInt(JOptionPane.showInputDialog("Input length"));
        width = Integer.parseInt(JOptionPane.showInputDialog("Input width"));
        JOptionPane.showMessageDialog(null, "The area is " + ComputeArea() + "and the perimeter is " + Perimeter());
    }
}


