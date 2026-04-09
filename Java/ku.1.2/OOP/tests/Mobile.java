import javax.swing.*;
import java.util.ArrayList; // To use the ArrayList class for managing list data
import java.time.LocalTime; // To access the system's local time

/**
 * The Mobile class simulates a simple billing system for mobile calls.
 * It calculates the total charge based on the call duration, the network type,
 * and the time of day the call is made.
 */
public class Mobile {
    public static void main(String[] args) {
        // Retrieve the current system time
        LocalTime now = LocalTime.now();
        
        // Convert the current time into a format easy for comparison (HHmm)

        int time = now.getHour() * 100 + now.getMinute();
        
        // Display the current system time to the console
        System.out.println("Current system time used: " + String.format("%02d:%02d", now.getHour(), now.getMinute()));
        
        // Prompt the user to input the call duration in minutes using a dialog box
        String minutes = JOptionPane.showInputDialog("Input call duration in minutes");
        int duration = Integer.parseInt(minutes); // Convert the input string to an integer
        
        // Create a list of options for the network selection dialog
        ArrayList<String> networks = new ArrayList<>();
        networks.add("TRUE");
        networks.add("FALSE");
        
        // Ask the user if the call is to another network
        String isOtherNetwork = JOptionPane.showInputDialog("ARE YOU MAKING A CALL TO OTHER NETWORK?", networks);
        
        // Ensure the user didn't cancel the dialog before proceeding
        if (isOtherNetwork != null) {
            switch (isOtherNetwork) {
                case "TRUE":
                    // If calling another network, the rate is fixed at KSH 5.00 per minute
                    System.out.println("===YOUR CHARGES ARE KSH" + duration * 5.00 + "===");
                    break;
                case "FALSE":
                    // If calling the same network, the rate depends on the time of day
                    
                    // Daytime rate: 06:00 to 18:00 (6 AM to 6 PM)
                    if (time >= 600 && time <= 1800) {
                        double charges = 4.00 * duration;
                        System.out.println("===YOUR CHARGES ARE KSH" + charges + "===");
                    } 
                    // Off-peak rate: 18:01 to 06:00 (6 PM to 6 AM)
                    else if ((time >= 1801 && time <= 2400) || (time >= 0 && time <= 600)) {
                        double pay = 3.00 * duration;
                        System.out.println("===YOUR CHARGES ARE KSH" + pay + "===");
                    }
                    break;
                default:
                    // Handle unexpected inputs
                    System.out.println("INVALID INPUT!");
            }
        }
    }
}
