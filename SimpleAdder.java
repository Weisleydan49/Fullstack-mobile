import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleAdder extends JFrame{
    //Fields
    private JTextField pField;
    private JTextField qField;
    private JTextField addField;

    public SimpleAdder() {
        //The GUI

        setTitle("Almond's Simple Adder");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 15, 15));

        //Rows
        add(new JLabel("Enter P"));
        pField = new JTextField();
        add(pField);

        add(new JLabel("Enter Q"));
        qField = new JTextField();
        add(qField);

        add(new JLabel("Sum"));
        addField = new JTextField();
        addField.setEditable(false);
        add(addField);

        //Add button 
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(new AddListener());
        add(addBtn);

        setVisible(true);

    }

    private class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try{
                double p = Double.parseDouble(pField.getText());
                double q = Double.parseDouble(qField.getText());

                //Calculate sum and show output
                double sum = p + q;
                addField.setText(String.valueOf(sum));
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Enter a valid integer!");
            }
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new SimpleAdder());
    }

}