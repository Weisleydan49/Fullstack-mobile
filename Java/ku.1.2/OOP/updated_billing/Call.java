// Declares this file belongs to the 'OOP.updated_billing' package (folder structure)
package OOP.updated_billing;

// Import all AWT classes for graphics, colors, fonts, layouts, and dimensions
import java.awt.*;
// Import ActionEvent - the object passed to actionPerformed() when a button is clicked
import java.awt.event.ActionEvent;
// Import ActionListener - the interface that allows this class to respond to button clicks
import java.awt.event.ActionListener;
// Import LocalDateTime - stores both date and time (used to record when a call started)
import java.time.LocalDateTime;
// Import LocalTime - stores only the time (used to determine daytime/nighttime billing rate)
import java.time.LocalTime;
// Import DateTimeFormatter - used to format date/time objects into human-readable strings
import java.time.format.DateTimeFormatter;
// Import ArrayList - a resizable list used to store the call history
import java.util.ArrayList;
// Import List - the interface type used to declare the callHistory list (good practice)
import java.util.List;
// Import all Swing components (JFrame, JButton, JLabel, JTable, JScrollPane, etc.)
import javax.swing.*;
// Import EmptyBorder - used to add padding (empty space) around the main panel
import javax.swing.border.EmptyBorder;
// Import DefaultTableModel - manages the data (rows and columns) displayed in the JTable
import javax.swing.table.DefaultTableModel;

/**
 * Almond's Mobile Call Billing System - Improved Version
 * Features: Phone number input, Call history table, Realistic rates
 */
// Call extends JFrame → this class IS a window
// implements ActionListener → this class handles its own button click events
public class Call extends JFrame implements ActionListener {

    // UI Components 
    // Four action buttons: select network, start/end call, and reset everything
    private JButton selectNetworkBtn, startCallBtn, endCallBtn, resetBtn;
    // Labels to display live time, call duration, current status, and total charges
    private JLabel timeLabel, durationLabel, statusLabel, chargesLabel;
    // Input field where the user types the phone number they want to dial
    private JTextField phoneNumberField;
    // Table widget to display the history of all completed calls
    private JTable historyTable;
    // The data model that feeds rows/columns into the JTable
    private DefaultTableModel tableModel;

    //  Timers 
    // clockTimer: fires every second to update the live clock display
    // durationTimer: fires every second during a call to count elapsed seconds
    private javax.swing.Timer clockTimer, durationTimer;

    // Call State Variables
    // Counts how many seconds the current call has been active
    private int durationSeconds = 0;
    // True once the user has selected a network (unlocks the Start Call button)
    private boolean networkSelected = false;
    // True if the user selected "Other Network (Off-net)" - affects billing rate
    private boolean isOtherNetwork = false;
    // Stores the name of the selected network (e.g., "Same Network (On-net)")
    private String currentNetwork = "";
    // Records the exact date and time the call started (used to create a
    // CallRecord)
    private LocalDateTime callStartTime;

    // History 
    // A dynamic list that grows as calls are completed; each entry is a CallRecord
    // object
    private List<CallRecord> callHistory = new ArrayList<>();

    //  Constructor
    public Call() {
        // Set the window title bar text
        setTitle("Almond's Mobile Billing System - Improved");
        // Close the application entirely when the user clicks the X button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set a minimum window size so components don't get squashed
        setMinimumSize(new Dimension(550, 650));
        // Center the window on the screen (null = relative to nothing = screen center)
        setLocationRelativeTo(null);

        // Create the main panel using GridBagLayout - a flexible grid that lets us
        // control exactly where each component sits using GridBagConstraints
        JPanel mainPanel = new JPanel(new GridBagLayout());
        // Add 20px of padding on all four sides so components don't touch the window
        // edge
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        // Set a light gray background (R=245, G=247, B=250)
        mainPanel.setBackground(new Color(245, 247, 250));
        // Add the main panel into the JFrame window
        add(mainPanel);

        // GridBagConstraints controls placement rules for each component added to mainPanel
        GridBagConstraints gbc = new GridBagConstraints();
        // Let components stretch left-to-right to fill the column width
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Add 10px of space (margin) around every component on all four sides
        gbc.insets = new Insets(10, 10, 10, 10);
        // Place all components in column 0 (the only column)
        gbc.gridx = 0;

        // Row 0: Live Clock Label
        timeLabel = new JLabel("Time: --:--:--", SwingConstants.CENTER); // Default placeholder text, centered
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Bold, 18pt font
        timeLabel.setForeground(new Color(44, 62, 80)); // Dark blue-gray text color
        gbc.gridy = 0; // Place in the first row
        mainPanel.add(timeLabel, gbc);

        // Row 1: Call Duration Label
        durationLabel = new JLabel("Duration: 00:00", SwingConstants.CENTER); // Shows MM:SS of current call
        durationLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        gbc.gridy = 1;
        mainPanel.add(durationLabel, gbc);

        // Row 2: Status Label 
        statusLabel = new JLabel("Status: Please select a network", SwingConstants.CENTER); // Guides the user
        statusLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        statusLabel.setForeground(new Color(127, 140, 141)); // Gray - neutral/idle color
        gbc.gridy = 2;
        mainPanel.add(statusLabel, gbc);

        // Row 3: Phone Number Input
        // A sub-panel using FlowLayout so the label and text field sit side by side
        JPanel dialPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dialPanel.setOpaque(false); // Transparent - lets the parent panel's background show through
        dialPanel.add(new JLabel("Phone Number:")); // Static label next to the input box
        phoneNumberField = new JTextField(15); // Input box, 15 characters wide
        dialPanel.add(phoneNumberField);
        gbc.gridy = 3;
        mainPanel.add(dialPanel, gbc);

        // Row 4: Action Buttons
        // GridLayout(1, 4, 8, 0) = 1 row, 4 columns, 8px horizontal gap, 0px vertical
        // gap
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 8, 0));
        buttonPanel.setOpaque(false);

        // Create each button with a distinct color using the helper method
        selectNetworkBtn = createStyledButton("Select Network", new Color(52, 152, 219)); // Blue
        startCallBtn = createStyledButton("Start Call", new Color(46, 204, 113)); // Green
        endCallBtn = createStyledButton("End Call", new Color(231, 76, 60)); // Red
        resetBtn = createStyledButton("Reset All", new Color(149, 165, 166)); // Gray

        // Disable Start/End buttons at launch - user must select a network first
        startCallBtn.setEnabled(false);
        endCallBtn.setEnabled(false);

        // Add all buttons to the button panel in left-to-right order
        buttonPanel.add(selectNetworkBtn);
        buttonPanel.add(startCallBtn);
        buttonPanel.add(endCallBtn);
        buttonPanel.add(resetBtn);

        gbc.gridy = 4;
        mainPanel.add(buttonPanel, gbc);

        // Row 5: Charges Display Label
        chargesLabel = new JLabel("Charges: KSH 0.00", SwingConstants.CENTER); // Updated after each call
        chargesLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        chargesLabel.setForeground(new Color(41, 128, 185)); // Blue
        gbc.gridy = 5;
        mainPanel.add(chargesLabel, gbc);

        // Row 6: Call History Table
        // Define the column headers for the table
        String[] columns = { "Start Time", "Duration", "Network", "Number", "Charges (KSH)" };
        // DefaultTableModel holds the actual data (rows added dynamically after each
        // call)
        tableModel = new DefaultTableModel(columns, 0); // 0 = start with zero rows
        historyTable = new JTable(tableModel);
        // Make the table fill any remaining vertical space (even if rows are few)
        historyTable.setFillsViewportHeight(true);
        // Wrap the table in a scroll pane so it can scroll if many calls are logged
        JScrollPane scrollPane = new JScrollPane(historyTable);
        gbc.gridy = 6;
        gbc.weighty = 1.0; // Allow this row to consume all remaining vertical space
        gbc.fill = GridBagConstraints.BOTH; // Stretch both horizontally and vertically
        mainPanel.add(scrollPane, gbc);

        initClock(); // Start the live clock ticking
        setVisible(true); // Make the window appear on screen
    }

    /**
     * Helper method to avoid writing the same button styling code four times.
     * Creates a JButton, applies a consistent look, and registers this class as its
     * listener.
     */
    private JButton createStyledButton(String text, Color baseColor) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setForeground(Color.WHITE); // White text on colored background
        btn.setBackground(baseColor); // The color passed in (blue, green, red, gray)
        btn.setFocusPainted(false); // Remove the dotted focus rectangle when clicked
        btn.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Inner padding
        btn.addActionListener(this); // 'this' = the Call object handles all button events
        return btn;
    }

    /**
     * Starts a Swing Timer that fires every 1000ms (1 second) to update the clock
     * label.
     */
    private void initClock() {
        // Lambda expression: runs every time the timer fires
        clockTimer = new javax.swing.Timer(1000, e -> {
            LocalTime now = LocalTime.now(); // Get the current system time
            // Format it as HH:mm:ss and update the label text
            timeLabel.setText("Time: " + now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        });
        clockTimer.start(); // Begin the timer immediately
    }

    /**
     * Required by ActionListener. Called automatically whenever any registered
     * button is clicked.
     * Routes the event to the appropriate handler method.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // e.getSource() returns the button object that was clicked
        if (e.getSource() == selectNetworkBtn) {
            handleNetworkSelection();
        } else if (e.getSource() == startCallBtn) {
            handleStartCall();
        } else if (e.getSource() == endCallBtn) {
            handleEndCall();
        } else if (e.getSource() == resetBtn) {
            resetAll();
        }
    }

    /**
     * Validates if a phone number is a valid Kenyan number.
     * Accepts formats:
     * - 0712345678 (10 digits starting with 0)
     * - +254712345678 (starts with +254, then 9 more digits)
     * - Valid prefixes for mobile: 07, 01
     */
    private boolean isValidKenyanPhoneNumber(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }

        // Format 1: Starts with 0 (national format)
        if (number.startsWith("0")) {
            // Should be exactly 10 digits and start with 07 or 01
            if (number.length() == 10 && number.matches("^0[17][0-9]{8}$")) {
                return true;
            }
        }
        // Format 2: Starts with +254 (international format)
        else if (number.startsWith("+254")) {
            // Should be +254 followed by 9 digits (which represents the 0 prefix)
            // Total length = 13 characters
            if (number.length() == 13 && number.matches("^\\+254[17][0-9]{8}$")) {
                return true;
            }
        }

        return false;
    }

    /**
     * Shows a dropdown dialog for the user to choose between On-net and Off-net.
     * Updates state and enables the Start Call button only after a selection is
     * made.
     */
    private void handleNetworkSelection() {
        String[] options = { "Same Network (On-net)", "Other Network (Off-net)" };

        // showInputDialog returns null if the user cancels; otherwise returns the
        // chosen string
        // 'this' = parent window (dialog will be centered over this window)
        String choice = (String) JOptionPane.showInputDialog(this,
                "Choose call type:", "Network Selection",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]); // options[0] = default selection

        if (choice != null) { // Only proceed if the user didn't click Cancel
            currentNetwork = choice;
            // Check if the chosen string contains "Other" to set the off-net flag
            isOtherNetwork = choice.contains("Other");
            networkSelected = true;
            statusLabel.setText("Status: " + currentNetwork + " selected");
            statusLabel.setForeground(new Color(39, 174, 96)); // Green = ready
            startCallBtn.setEnabled(true); // Now the user can start a call
            selectNetworkBtn.setEnabled(false); // Prevent changing network mid-setup
        }
    }

    /**
     * Validates input, then begins timing the call and updates the UI state.
     */
    private void handleStartCall() {
        // Read and trim whitespace from the phone number field
        String number = phoneNumberField.getText().trim();

        // Validation: check if the phone number is a valid Kenyan number
        if (!isValidKenyanPhoneNumber(number)) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid Kenyan phone number.\n\nAccepted formats:\n" +
                "- 0712345678 (10 digits starting with 0)\n" +
                "- +254712345678 (country code +254)", 
                "Invalid Phone Number", 
                JOptionPane.WARNING_MESSAGE);
            return; // Stop here - don't start the call
        }

        callStartTime = LocalDateTime.now(); // Record the exact start time for the call record
        durationSeconds = 0; // Reset the duration counter
        startCallBtn.setEnabled(false); // Prevent double-clicking start
        endCallBtn.setEnabled(true); // Allow the user to end the call

        statusLabel.setText("Status: CALL IN PROGRESS...");
        statusLabel.setForeground(new Color(230, 126, 34)); // Orange = active call

        // Timer fires every 1 second to increment durationSeconds and refresh the label
        durationTimer = new javax.swing.Timer(1000, ev -> {
            durationSeconds++;
            int mins = durationSeconds / 60; // Integer division → full minutes
            int secs = durationSeconds % 60; // Remainder → leftover seconds
            // %02d = format as 2 digits with leading zero (e.g., 3 → "03")
            durationLabel.setText(String.format("Duration: %02d:%02d", mins, secs));
        });
        durationTimer.start(); // Begin counting
    }

    /**
     * Stops the call, calculates charges, saves a record, updates the UI, and
     * resets for the next call.
     */
    private void handleEndCall() {
        // Null check - durationTimer might be null if end was called before start
        // (safety guard)
        if (durationTimer != null)
            durationTimer.stop(); // Freeze the duration counter

        endCallBtn.setEnabled(false); // Can no longer end a call that's already ended
        selectNetworkBtn.setEnabled(true); // Allow the user to pick a network for the next call

        // Delegate the charge calculation to the dedicated method
        double totalCharges = calculateCharges();

        // Create a CallRecord object capturing all details of this completed call
        CallRecord record = new CallRecord(callStartTime, durationSeconds, currentNetwork,
                totalCharges, phoneNumberField.getText().trim());

        callHistory.add(record); // Add to the in-memory list
        addToHistoryTable(record); // Add a new row to the visible JTable

        // Display the final charge in the charges label (formatted to 2 decimal places)
        chargesLabel.setText(String.format("Charges: KSH %.2f", totalCharges));

        statusLabel.setText("Status: Call ended - KSH " + String.format("%.2f", totalCharges));
        statusLabel.setForeground(new Color(127, 140, 141)); // Gray = idle

        // Print a summary line to the console for debugging/logging purposes
        System.out
                .println("=== Call Ended | Charges: KSH " + totalCharges + " | Duration: " + durationSeconds + "s ===");

        // Clear the fields for the next call, but do NOT wipe the history table
        resetForNewCall();
    }

    /**
     * Calculates the call charges based on duration and the current time of day.
     * Uses ceiling division so any partial minute is billed as a full minute.
     *
     * Rate table:
     * Off-net (Other Network): KSH 5.50/min (day) | KSH 4.50/min (night)
     * On-net (Same Network): KSH 4.00/min (day) | KSH 2.80/min (night)
     *
     * Daytime = 06:00 to 18:00
     */
    private double calculateCharges() {
        if (durationSeconds <= 0)
            return 0.0;
        // Ceiling division: (durationSeconds + 59) / 60
        // e.g., 61 seconds → (61+59)/60 = 120/60 = 2 minutes (rounds up from 1m 1s)
        int durationMinutes = (durationSeconds + 59) / 60;

        LocalTime now = LocalTime.now(); // Get current time to determine the billing period
        int currentTime = now.getHour() * 100 + now.getMinute();// e.g 14.30 becomes 1430

        double rate;
        if (isOtherNetwork) {
            // Flat rate regardless of time
            rate = 5.00;
        } else {
            // Same network- time based
            if (currentTime >= 600 && currentTime <= 1800) {
                rate = 4.00; // Daytime- 6 am to 6 pm
            } else {
                rate = 3.00; // Night time 6 pm to 6 am
            }
        }

        return rate * durationMinutes; // Total = rate per minute × number of minutes
    }

    /**
     * Appends a new row to the history JTable using the data from a CallRecord.
     * Each cell value is formatted to be human-readable.
     */
    private void addToHistoryTable(CallRecord record) {
        // addRow takes an Object[] - each element maps to one column in order
        tableModel.addRow(new Object[] {
                record.getFormattedStart(), // "yyyy-MM-dd HH:mm:ss"
                record.getFormattedDuration(), // "MM:SS"
                record.getNetworkType(), // "Same Network (On-net)" etc.
                record.getPhoneNumber(), // The number that was dialed
                String.format("%.2f", record.getCharges()) // e.g., "14.50"
        });
    }

    /**
     * Resets only the per-call fields so the user can start a new call.
     * Does NOT clear the history table or the charges label.
     */
    private void resetForNewCall() {
        durationSeconds = 0;
        durationLabel.setText("Duration: 00:00");
        phoneNumberField.setText(""); // Clear the phone number input
        startCallBtn.setEnabled(false); // Must select a network again before starting
        endCallBtn.setEnabled(false);
    }

    /**
     * Full application reset - wipes everything including call history.
     * Called when the user clicks "Reset All".
     */
    private void resetAll() {
        if (durationTimer != null)
            durationTimer.stop(); // Stop any in-progress call timer first
        resetForNewCall(); // Reset per-call state
        callHistory.clear(); // Empty the in-memory list
        tableModel.setRowCount(0); // Remove all rows from the JTable (setRowCount(0) = clear)
        chargesLabel.setText("Charges: KSH 0.00");
        statusLabel.setText("Status: Please select a network");
        statusLabel.setForeground(new Color(127, 140, 141));
        selectNetworkBtn.setEnabled(true); // Allow picking a network again
        networkSelected = false; // Reset the network selection flag
    }

    // Inner Class: CallRecord
    /**
     * A simple data class that stores information about one completed call.
     * Declared 'static' because it doesn't need access to the outer Call class's
     * instance fields.
     * All fields are 'final' because a call record should never change after
     * creation.
     */
    private static class CallRecord {
        private final LocalDateTime startTime; // When the call began
        private final int durationSeconds; // How long it lasted in total seconds
        private final String networkType; // "Same Network (On-net)" or "Other Network (Off-net)"
        private final double charges; // The calculated cost in KSH
        private final String phoneNumber; // The number that was dialed

        // Constructor - all values are set once and cannot be changed (final)
        public CallRecord(LocalDateTime start, int dur, String net, double chg, String num) {
            this.startTime = start;
            this.durationSeconds = dur;
            this.networkType = net;
            this.charges = chg;
            this.phoneNumber = num;
        }

        // Returns the start time formatted as "yyyy-MM-dd HH:mm:ss" for the table
        public String getFormattedStart() {
            return startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }

        // Converts raw seconds into a "MM:SS" string for the Duration column
        public String getFormattedDuration() {
            int min = durationSeconds / 60;
            int sec = durationSeconds % 60;
            return String.format("%02d:%02d", min, sec);
        }

        // Standard getter - returns the network type string
        public String getNetworkType() {
            return networkType;
        }

        // Standard getter - returns the dialed phone number
        public String getPhoneNumber() {
            return phoneNumber;
        }

        // Standard getter - returns the charge amount
        public double getCharges() {
            return charges;
        }
    }

    // Entry Point
    public static void main(String[] args) {
        // Apply the operating system's native look and feel
        // Wrapped in try-catch because it can fail on some systems
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        // invokeLater ensures the GUI is created on the Event Dispatch Thread
        // This prevents race conditions and rendering bugs
        // Call::new is shorthand for () -> new Call()
        SwingUtilities.invokeLater(Call::new);
    }
}