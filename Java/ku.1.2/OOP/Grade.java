import javax.swing.*;

public class Grade {
    public static void main(String[] args) {
        String marks = JOptionPane.showInputDialog("===ENTER YOUR MARKS===");
        int score = Integer.parseInt(marks);

        if (score > 100) {
            System.out.println("Invalid Marks");
            System.out.println("You are not serious!!!");
            System.out.println("Marks cannot be more than 100!!");
        } else if (score >= 80) {
            System.out.println("Grade is A");
        } else if (score >= 70) {
            System.out.println("Grade is B");
        } else if (score >= 60) {
            System.out.println("Grade is C");
        } else if (score >= 50) {
            System.out.println("Grade is D");
        } else {
            System.out.println("Grade is E");
        }
    }
}
