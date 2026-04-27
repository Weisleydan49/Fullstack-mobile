
// Import basic AWT classes for windowing and layout management
import java.awt.*;
// Import action event classes for handling button clicks
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Import classes for handling time and formatting it
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
// Import Swing UI components for creating the graphical user interface
import javax.swing.*;
// Import empty border class for adding padding to UI panels
import javax.swing.border.EmptyBorder;

/**
 * Call class implements a premium Mobile Call Billing System GUI.
 * It allows users to select a network, start a call, and calculate charges upon
 * ending.
 * tHE CHARGES ARE CALCULATED PER MINUTE
 */
// The Call class extends JFrame (a window) and implements ActionListener (to
// handle button clicks)
public class Call extends JFrame implements ActionListener {
    // UI Components declarations
    private JButton selectNetworkBtn, startCallBtn, endCallBtn; // Buttons for user actions
    private JLabel timeLabel, durationLabel, statusLabel, chargesLabel; // Labels to display text information
    private JPanel mainPanel; // The main container panel for all components

    // Timers
    private javax.swing.Timer clockTimer, durationTimer; // Timers for the real-time clock and call duration

    // Call State variables
    private int durationSeconds = 0; // Tracks the current call duration in seconds
    private boolean networkSelected = false; // Flag to check if a network has been selected
    private boolean isOtherNetwork = false; // Flag to indicate if the call is to a different network
    private String currentNetwork = ""; // Stores the name of the selected network

    // Constructor to initialize the GUI
    public Call() {
        // Window Setup
        setTitle("Almond's Mobile Billing System"); // Set the window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Make the program exit when the window is closed
        setMinimumSize(new Dimension(450, 400)); // Set the minimum dimensions of the window
        setLocationRelativeTo(null); // Center the window on the screen

        // Main Panel Setup with GridBagLayout for flexible component positioning
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Add 20px padding around the panel
        mainPanel.setBackground(new Color(245, 247, 250)); // Set a sleek light gray background color
        add(mainPanel); // Add the main panel to the JFrame

        // GridBagConstraints is used to configure how components are placed in the
        // GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make components stretch horizontally
        gbc.insets = new Insets(10, 10, 10, 10); // Add 10px margins around each component
        gbc.gridx = 0; // All components will be in the first column

        // --- Header Section ---
        // Create and configure the label displaying the current time
        timeLabel = new JLabel("Time: --:--:--", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        timeLabel.setForeground(new Color(44, 62, 80));
        gbc.gridy = 0; // Place in the first row
        mainPanel.add(timeLabel, gbc);

        // --- Information Section ---
        // Create and configure the label displaying the call duration
        durationLabel = new JLabel("Duration: 00:00", SwingConstants.CENTER);
        durationLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        gbc.gridy = 1; // Place in the second row
        mainPanel.add(durationLabel, gbc);

        // Create and configure the label displaying the current application status
        statusLabel = new JLabel("Status: Please select a network", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        statusLabel.setForeground(new Color(127, 140, 141));
        gbc.gridy = 2; // Place in the third row
        mainPanel.add(statusLabel, gbc);

        // --- Controls Section ---
        // Create a panel to hold the buttons in a single row with 3 columns
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setOpaque(false); // Make the panel transparent

        // Create styled buttons using a helper method
        selectNetworkBtn = createStyledButton("Select Network", new Color(52, 152, 219));
        startCallBtn = createStyledButton("Start Call", new Color(46, 204, 113));
        endCallBtn = createStyledButton("End Call", new Color(231, 76, 60));

        // Disable start and end call buttons initially
        startCallBtn.setEnabled(false);
        endCallBtn.setEnabled(false);

        // Add buttons to the button panel
        buttonPanel.add(selectNetworkBtn);
        buttonPanel.add(startCallBtn);
        buttonPanel.add(endCallBtn);

        gbc.gridy = 3; // Place in the fourth row
        mainPanel.add(buttonPanel, gbc);

        // --- Result Section ---
        // Create and configure the label displaying the calculated charges
        chargesLabel = new JLabel("Charges: KSH 0.00", SwingConstants.CENTER);
        chargesLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        chargesLabel.setForeground(new Color(41, 128, 185));
        gbc.gridy = 4; // Place in the fifth row
        mainPanel.add(chargesLabel, gbc);

        // --- Initialization ---
        initClock(); // Start the real-time clock timer
        setVisible(true); // Make the main window visible
    }

    // Helper method to create customized buttons to reduce repetitive code
    private JButton createStyledButton(String text, Color baseColor) {
        JButton btn = new JButton(text); // Create button with text
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12)); // Set font
        btn.setForeground(Color.WHITE); // Set text color to white
        btn.setBackground(baseColor); // Set background color
        btn.setFocusPainted(false); // Remove the focus outline when clicked
        btn.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Add padding inside the button
        btn.addActionListener(this); // Register the current class as the listener for click events
        return btn;
    }

    // Method to initialize and start the real-time clock
    private void initClock() {
        // Create a timer that triggers every 1000 milliseconds (1 second)
        clockTimer = new javax.swing.Timer(1000, e -> {
            LocalTime now = LocalTime.now(); // Get the current time
            // Update the time label with the formatted time (HH:mm:ss)
            timeLabel.setText("Time: " + now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        });
        clockTimer.start(); // Start the clock timer
    }

    // Method called automatically when a button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button triggered the event and call the corresponding handler
        // method
        if (e.getSource() == selectNetworkBtn) {
            handleNetworkSelection();
        } else if (e.getSource() == startCallBtn) {
            handleStartCall();
        } else if (e.getSource() == endCallBtn) {
            handleEndCall();
        }
    }

    // Method to handle network selection logic
    private void handleNetworkSelection() {
        // Options for the network selection dialog
        String[] options = { "Same Network", "Other Network" };
        // Show an input dialog with a dropdown list for the user to select the network
        String choice = (String) JOptionPane.showInputDialog(this,
                "Choose network type:", "Network Selection",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // If the user made a choice (didn't cancel)
        if (choice != null) {
            currentNetwork = choice; // Store the selected network name
            isOtherNetwork = choice.equals("Other Network"); // Update flag based on selection
            networkSelected = true; // Mark network as selected
            // Update the status label to show the selection
            statusLabel.setText("Status: " + currentNetwork + " selected");
            statusLabel.setForeground(new Color(39, 174, 96));
            // Enable the start call button and disable the select network button
            startCallBtn.setEnabled(true);
            selectNetworkBtn.setEnabled(false);
        }
    }

    // Method to handle starting a call
    private void handleStartCall() {
        durationSeconds = 0; // Reset call duration
        startCallBtn.setEnabled(false); // Disable start call button to prevent multiple clicks
        endCallBtn.setEnabled(true); // Enable end call button
        // Update status label to indicate a call is ongoing
        statusLabel.setText("Status: CALL IN PROGRESS...");
        statusLabel.setForeground(new Color(230, 126, 34));

        // Create a timer that increments the duration every second
        durationTimer = new javax.swing.Timer(1000, ev -> {
            durationSeconds++; // Increment seconds
            int mins = durationSeconds / 60; // Calculate minutes
            int secs = durationSeconds % 60; // Calculate remaining seconds
            // Update the duration label with the formatted time
            durationLabel.setText(String.format("Duration: %02d:%02d", mins, secs));
        });
        durationTimer.start(); // Start the duration timer
    }

    // Method to handle ending a call and calculating charges
    private void handleEndCall() {
        // Stop the duration timer if it's running
        if (durationTimer != null)
            durationTimer.stop();

        endCallBtn.setEnabled(false); // Disable end call button
        selectNetworkBtn.setEnabled(true); // Allow selecting a new network for a new call
        // Update status label
        statusLabel.setText("Status: Call ended");
        statusLabel.setForeground(new Color(127, 140, 141));

        // --- Calculation logic ---
        // Calculate total minutes, rounding up (e.g., 61 seconds = 2 minutes)
        int durationMinutes = (durationSeconds + 59) / 60;
        LocalTime now = LocalTime.now(); // Get the current time for rate calculation
        // Convert current time to a comparable integer format (HHMM)
        int time = now.getHour() * 100 + now.getMinute();

        double rate;
        if (isOtherNetwork) {
            // Flat rate for other networks
            rate = 5.00;
        } else {
            // Time-based rate for same network
            // Daytime: 06:00 (600) to 18:00 (1800)
            if (time >= 600 && time <= 1800) {
                rate = 4.00;
            } else {
                // Nighttime rate
                rate = 3.00;
            }
        }

        // Calculate final charges based on rate and rounded minutes
        double totalCharges = rate * durationMinutes;
        // Update the charges label with the formatted total
        chargesLabel.setText(String.format("Charges: KSH %.2f", totalCharges));

        // Log the final calculated charges to the console
        System.out.println("=== FINAL CHARGES: KSH " + totalCharges + " (Duration: " + durationMinutes + " min) ===");
    }

    // Main method: entry point of the application
    public static void main(String[] args) {
        // Set System Look and Feel to match the host OS for a more native look
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        // Ensure GUI creation is run on the Event Dispatch Thread (EDT) for thread
        // safety
        SwingUtilities.invokeLater(Call::new);
    }
}
