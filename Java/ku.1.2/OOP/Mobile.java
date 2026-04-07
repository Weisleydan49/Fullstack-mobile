import javax.swing.*;
import java.util.ArrayList;

public class Mobile {
    public static void main(String[] args) {
        String callTime = JOptionPane.showInputDialog("Input call time without colon");
        int time = Integer.parseInt(callTime);
        String minutes = JOptionPane.showInputDialog("Input call duration in minutes");
        int duration = Integer.parseInt(minutes);
        ArrayList<String> networks = new ArrayList<>();
        networks.add("TRUE");
        networks.add("FALSE");
        String isOtherNetwork = JOptionPane.showInputDialog("ARE YOU MAKING A CALL TO OTHER NETWORK?", networks);
        if (isOtherNetwork != null) {
            switch (isOtherNetwork) {
                case "TRUE":
                    System.out.println("===YOUR CHARGES ARE KSH" + duration * 5.00 + "===");
                    break;
                case "FALSE":
                    if (time >= 0600 && time <= 1800) {
                        double charges = 4.00 * duration;
                        System.out.println("===YOUR CHARGES ARE KSH" + charges + "===");
                    } else if (time >= 1801 && time <= 2400 || time >= 0000 && time <= 0600) {
                        double pay = 3.00 * duration;
                        System.out.println("===YOUR CHARGES ARE KSH" + pay + "===");
                    }
                    break;
                default:
                    System.out.println("INVALID INPUT!");
            }
        }
    }
}
