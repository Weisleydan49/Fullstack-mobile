import javax.swing.*;
import java.util.ArrayList;

public class Subject {
    public static void main(String[] args) {
        System.out.println("===SUBJECTS SELECTION===");
        ArrayList<String> categories = new ArrayList<>();
        categories.add("1. SCIENCE");
        categories.add("2. ARTS");
        String input = JOptionPane.showInputDialog("SELECT A CATEGORY: ", categories);

        if (input != null) {
            switch (input) {
                case "1. SCIENCE":
                    System.out.println("You selected Science.");
                    break;
                case "2. ARTS":
                    System.out.println("You selected Arts.");
                    break;
                default:
                    System.out.println("Invalid selection: " + input);
            }
        } else {
            System.out.println("Selection cancelled.");
        }

        if (input.equals("1. SCIENCE")) {
            ArrayList<String> subjects = new ArrayList<>();
            subjects.add("1. CHEMISTRY");
            subjects.add("2. PHYSICS");

            String subject = JOptionPane.showInputDialog("SELECT A SUBJECT: ", subjects);

            if (subject != null) {
                switch (subject) {
                    case "1. CHEMISTRY":
                        System.out.println("You chose Chemistry");
                        break;
                    case "2. PHYSICS":
                        System.out.println("You chose Physics");
                        break;
                    default:
                        System.out.println("Invalid selection");
                }
            }
        } else if (input.equals("2. ARTS")) {
            ArrayList<String> options = new ArrayList<>();
            options.add("1. HISTORY");
            options.add("2. C.R.E");

            String option = JOptionPane.showInputDialog("Select a ART option", options);

            if (option != null) {
                switch (option) {
                    case "1. HISTORY":
                        System.out.println("You selected HISTORY");
                        break;
                    case "2. C.R.E":
                        System.out.println("You selected C.R.E");
                        break;
                    default:
                        System.out.println("Invalid Option!!");
                }
            }

        }

    }
}
