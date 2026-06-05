import javax.swing.*;
import java.awt.*;


public class RedGreen extends JFrame {

    public RedGreen() {
        setTitle("RED GREEN");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel colorBox = new JPanel();
        colorBox.setOpaque(true);
        add(colorBox, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        // Red and green buttons
        JButton redBtn = new JButton("Red");
        redBtn.setBackground(Color.BLUE);
        redBtn.setForeground(Color.WHITE);
        redBtn.addActionListener(e -> colorBox.setBackground(Color.RED));
        buttonPanel.add(redBtn);

        JButton greenBtn = new JButton("Green");
        greenBtn.setBackground(Color.BLUE);
        greenBtn.setForeground(Color.WHITE);
        greenBtn.addActionListener(e -> colorBox.setBackground(Color.GREEN));
        buttonPanel.add(greenBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RedGreen());
    }

}