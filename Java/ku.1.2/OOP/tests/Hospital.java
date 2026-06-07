
//If temp is above 38 and pressure is above 140: admit patient
//if pressure is below 140, give medication
//if temp is below 38 and pressure is above 140: send to the lab
/*import javax.swing.*;

public class Hospital {
    public static void main(String[] args) {
        int temp = Integer.parseInt(JOptionPane.showInputDialog("Enter the temperature: "));
        String prs = JOptionPane.showInputDialog("Enter the pressure: ");
        int pressure = Integer.parseInt(prs);

        if (temp > 38 && pressure > 140) {
            JOptionPane.showMessageDialog(null, "Admit the patient");
        } else if (pressure < 140) {
            JOptionPane.showMessageDialog(null, "Give medication");
        } else if (temp < 38 && pressure > 140) {
            JOptionPane.showMessageDialog(null, "Send to the lab");
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid integer");
        }
    }
}

*/
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Enter temperature:");
        int temp = sc.nextInt();

        System.out.println("Enter pressure: ");
        int pressure = sc1.nextInt();

        if (temp > 38 && pressure > 140) {
            System.out.println("Admit the patient");
        } else if (pressure < 140) {
            System.out.println("Give medication");
        } else if (temp < 38 && pressure > 140) {
            System.out.println("Send to the lab");
        } else {
            System.out.println("Enter a valid integer");
        }

    }
}