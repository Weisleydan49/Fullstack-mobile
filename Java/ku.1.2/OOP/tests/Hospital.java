import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hospital extends JFrame {

    // Fields
    private JTextField tempField;
    private JTextField pressureField;
    private JTextField conclusionField;

    // Main GUI
    public Hospital() {
        setTitle("ALMOND HOSPITAL");
        setSize(1200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 20, 20));

        // Font
        Font font = new Font("Arial", Font.PLAIN, 30);

        // Temperature
        JLabel tmp = new JLabel("Enter temperature");
        tmp.setFont(font);
        tempField = new JTextField();
        add(tmp);
        tempField.setFont(font);
        add(tempField);

        // Pressure field
        JLabel pressure = new JLabel("Enter pressure");
        pressure.setFont(font);
        pressureField = new JTextField();
        add(pressure);
        pressureField.setFont(font);
        add(pressureField);

        JButton conclusionBtn = new JButton("Diagnosis");
        conclusionBtn.setFont(font);
        conclusionBtn.addActionListener(new AddListener());
        add(conclusionBtn);

        conclusionField = new JTextField();
        conclusionField.setFont(font);
        conclusionField.setEditable(false);
        add(conclusionField);

        setVisible(true); // makes the window actually appear
    }

    private class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                // Get the values of temperature and pressure
                double t = Double.parseDouble(tempField.getText());
                double p = Double.parseDouble(pressureField.getText());

                // Analyse and give a conclusion
                if (t > 38 && p > 140) {
                    conclusionField.setText(String.valueOf("Admit"));
                } else if (t < 38 && p < 140) {
                    conclusionField.setText(String.valueOf("Give Medication"));
                } else if (p < 140) {
                    conclusionField.setText(String.valueOf("Send to the lab"));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter valid values");
            }

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Hospital());
    }
}