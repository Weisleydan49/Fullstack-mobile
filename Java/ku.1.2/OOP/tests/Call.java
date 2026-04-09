import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Call class implements a premium Mobile Call Billing System GUI.
 * It allows users to select a network, start a call, and calculate charges upon ending.
 */
public class Call extends JFrame implements ActionListener {
    // UI Components
    private JButton selectNetworkBtn, startCallBtn, endCallBtn;
    private JLabel timeLabel, durationLabel, statusLabel, chargesLabel;
    private JPanel mainPanel;
    
    // Timers
    private javax.swing.Timer clockTimer, durationTimer;
    
    // Call State
    private int durationSeconds = 0;
    private boolean networkSelected = false;
    private boolean isOtherNetwork = false;
    private String currentNetwork = "";

    public Call() {
        // Window Setup
        setTitle("Premium Mobile Billing System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(450, 400));
        setLocationRelativeTo(null); // Center on screen

        // Main Panel with Padding
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 247, 250)); // Sleek light gray background
        add(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        // --- Header Section ---
        timeLabel = new JLabel("Time: --:--:--", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        timeLabel.setForeground(new Color(44, 62, 80));
        gbc.gridy = 0;
        mainPanel.add(timeLabel, gbc);

        // --- Information Section ---
        durationLabel = new JLabel("Duration: 00:00", SwingConstants.CENTER);
        durationLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        gbc.gridy = 1;
        mainPanel.add(durationLabel, gbc);

        statusLabel = new JLabel("Status: Please select a network", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        statusLabel.setForeground(new Color(127, 140, 141));
        gbc.gridy = 2;
        mainPanel.add(statusLabel, gbc);

        // --- Controls Section ---
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setOpaque(false);

        selectNetworkBtn = createStyledButton("Select Network", new Color(52, 152, 219));
        startCallBtn = createStyledButton("Start Call", new Color(46, 204, 113));
        endCallBtn = createStyledButton("End Call", new Color(231, 76, 60));

        startCallBtn.setEnabled(false);
        endCallBtn.setEnabled(false);

        buttonPanel.add(selectNetworkBtn);
        buttonPanel.add(startCallBtn);
        buttonPanel.add(endCallBtn);

        gbc.gridy = 3;
        mainPanel.add(buttonPanel, gbc);

        // --- Result Section ---
        chargesLabel = new JLabel("Charges: KSH 0.00", SwingConstants.CENTER);
        chargesLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        chargesLabel.setForeground(new Color(41, 128, 185));
        gbc.gridy = 4;
        mainPanel.add(chargesLabel, gbc);

        // --- Initialization ---
        initClock();
        setVisible(true);
    }

    private JButton createStyledButton(String text, Color baseColor) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setForeground(Color.WHITE);
        btn.setBackground(baseColor);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        btn.addActionListener(this);
        return btn;
    }

    private void initClock() {
        clockTimer = new javax.swing.Timer(1000, e -> {
            LocalTime now = LocalTime.now();
            timeLabel.setText("Time: " + now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        });
        clockTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectNetworkBtn) {
            handleNetworkSelection();
        } else if (e.getSource() == startCallBtn) {
            handleStartCall();
        } else if (e.getSource() == endCallBtn) {
            handleEndCall();
        }
    }

    private void handleNetworkSelection() {
        String[] options = {"Same Network", "Other Network"};
        String choice = (String) JOptionPane.showInputDialog(this, 
                "Choose network type:", "Network Selection",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice != null) {
            currentNetwork = choice;
            isOtherNetwork = choice.equals("Other Network");
            networkSelected = true;
            statusLabel.setText("Status: " + currentNetwork + " selected");
            statusLabel.setForeground(new Color(39, 174, 96));
            startCallBtn.setEnabled(true);
            selectNetworkBtn.setEnabled(false);
        }
    }

    private void handleStartCall() {
        durationSeconds = 0;
        startCallBtn.setEnabled(false);
        endCallBtn.setEnabled(true);
        statusLabel.setText("Status: CALL IN PROGRESS...");
        statusLabel.setForeground(new Color(230, 126, 34));

        durationTimer = new javax.swing.Timer(1000, ev -> {
            durationSeconds++;
            int mins = durationSeconds / 60;
            int secs = durationSeconds % 60;
            durationLabel.setText(String.format("Duration: %02d:%02d", mins, secs));
        });
        durationTimer.start();
    }

    private void handleEndCall() {
        if (durationTimer != null) durationTimer.stop();
        
        endCallBtn.setEnabled(false);
        selectNetworkBtn.setEnabled(true); // Allow new call
        statusLabel.setText("Status: Call ended");
        statusLabel.setForeground(new Color(127, 140, 141));

        // Calculation logic
        int durationMinutes = (durationSeconds + 59) / 60; // Round up
        LocalTime now = LocalTime.now();
        int time = now.getHour() * 100 + now.getMinute();

        double rate;
        if (isOtherNetwork) {
            rate = 5.00;
        } else {
            // Daytime: 06:00 to 18:00
            if (time >= 600 && time <= 1800) {
                rate = 4.00;
            } else {
                rate = 3.00;
            }
        }

        double totalCharges = rate * durationMinutes;
        chargesLabel.setText(String.format("Charges: KSH %.2f", totalCharges));
        
        // Log to console as requested
        System.out.println("=== FINAL CHARGES: KSH " + totalCharges + " (Duration: " + durationMinutes + " min) ===");
    }

    public static void main(String[] args) {
        // Set System Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        
        SwingUtilities.invokeLater(Call::new);
    }
}
