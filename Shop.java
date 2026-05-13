import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shop extends JFrame {

    private JTextField sugarField;
    private JTextField sugarAmntField;
    private JTextField teaLeavesField;
    private JTextField teaLeavesAmntField;
    private JTextField ungaField;
    private JTextField ungaAmntField;
    private JTextField riceField;
    private JTextField riceAmntField;
    private JTextField totalField;
    private JTextField amountPaidField;
    private JTextField balanceField;

    public Shop() {
        // Main GUI Layout
        setTitle("ALMOND SHOP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(new GridLayout(8, 4, 10, 10));

        // Sugar Fields
        add(new JLabel("Sugar Kilograms"));
        sugarField = new JTextField();
        sugarAmntField = new JTextField();
        sugarAmntField.setEditable(false);
        add(sugarField);
        add(sugarAmntField);

        // Tea Leaves Fields
        add(new JLabel("Tea leaves packets"));
        teaLeavesField = new JTextField();
        teaLeavesAmntField = new JTextField();
        teaLeavesAmntField.setEditable(false);
        add(teaLeavesField);
        add(teaLeavesAmntField);

        // Unga Fields
        add(new JLabel("Unga packets"));
        ungaField = new JTextField();
        ungaAmntField = new JTextField();
        ungaAmntField.setEditable(false);
        add(ungaField);
        add(ungaAmntField);

        // Rice Fields
        add(new JLabel("Rice kilograms"));
        riceField = new JTextField();
        riceAmntField = new JTextField();
        riceAmntField.setEditable(false);
        add(riceField);
        add(riceAmntField);

        // Totals
        JButton totalBtn = new JButton("Total");
        totalBtn.addActionListener(new AddListener());
        add(totalBtn);
        totalField = new JTextField();
        totalField.setEditable(false);
        add(totalField);
        add(new JLabel("")); // Padding for column 2

        // Amount Paid Field
        add(new JLabel("Amount Paid"));
        amountPaidField = new JTextField();
        add(amountPaidField);
        add(new JLabel("")); // Padding for column 3

        // Balance
        add(new JLabel("Balance"));
        balanceField = new JTextField();
        balanceField.setEditable(false);
        add(balanceField);
        add(new JLabel("")); // Padding for column 3

        setVisible(true);

    }

    private double safeParseDouble(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(text);
    }

    private class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double sugar = safeParseDouble(sugarField.getText());
                double teaLeaves = safeParseDouble(teaLeavesField.getText());
                double unga = safeParseDouble(ungaField.getText());
                double rice = safeParseDouble(riceField.getText());
                double amount = safeParseDouble(amountPaidField.getText());

                // Calculations

                // 1. Sugar @ ksh 150 per kg
                double sugarAmnt = sugar * 150;
                sugarAmntField.setText(String.valueOf(sugarAmnt));

                // 2. Tea leaves @ ksh 50 per packet
                double teaLeavesAmnt = teaLeaves * 50;
                teaLeavesAmntField.setText(String.valueOf(teaLeavesAmnt));

                // 3. Unga @ ksh 140 per packet
                double ungaAmnt = unga * 140;
                ungaAmntField.setText(String.valueOf(ungaAmnt));

                // 4. Rice @ ksh 100 per kg
                double riceAmnt = rice * 100;
                riceAmntField.setText(String.valueOf(riceAmnt));

                // Total price
                double total = sugarAmnt + teaLeavesAmnt + ungaAmnt + riceAmnt;
                totalField.setText(String.valueOf(total)); // Fixed: Display total instead of amount

                // Balance
                double balance = amount - total;
                balanceField.setText(String.valueOf(balance));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter valid numeric values");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Shop());
    }

}
