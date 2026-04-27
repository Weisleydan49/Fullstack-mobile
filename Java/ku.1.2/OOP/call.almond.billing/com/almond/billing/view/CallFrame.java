private JTextField phoneNumberField;
private JTable historyTable;
private DefaultTableModel tableModel;
private java.util.List<CallRecord> callHistory = new ArrayList<>();
private LocalDateTime callStartTime; // To record exact start

//Constructors
// Phone number input
JPanel dialPanel = new JPanel(new FlowLayout());
dialPanel.add(new JLabel("Dial Number:"));
phoneNumberField = new JTextField(15);
dialPanel.add(phoneNumberField);
gbc.gridy = 5;
mainPanel.add(dialPanel, gbc);

// History section
String[] columns = {"Start Time", "Duration", "Type", "Number", "Charges (KSH)"};
tableModel = new DefaultTableModel(columns, 0);
historyTable = new JTable(tableModel);
JScrollPane scroll = new JScrollPane(historyTable);
gbc.gridy = 6;
gbc.weighty = 1.0;
gbc.fill = GridBagConstraints.BOTH;
mainPanel.add(scroll, gbc);

private void handlestartCall(){
    String number = phoneNumberField.getText().trim();
    if(number.isEmpty()){
        JOptionPane.showMessageDialog(this, "Please enter a phone number to dial.", "Waring", JOptionPane.WARING_MESSAGE);
        return;
    }
    callStartTime = LocalDateTime.now();
    durationSeconds = 0;
}

private void handleEndCall() {
    if (durationTimer != null) durationTimer.stop();

    LocalDateTime endTime = LocalDateTime.now();
    int durationSec = durationSeconds;

    double totalCharges = BillingCalculator.calculateCharge(
        durationSec, isOtherNetwork, endTime.toLocalTime()
    );

    CallRecord record = new CallRecord(callStartTime, durationSec, currentNetwork, totalCharges, phoneNumberField.getText().trim());

    callHistory.add(record);
    addToHistoryTable(record);

    // Update charges label
    chargesLabel.setText(String.format("Charges: KSH %.2f", totalCharges));

    System.out.println("=== Call Ended - Charges: KSH " + totalCharges + " ===");

    // Reset for next call
    resetForNewCall();
}

private void addToHistoryTable(CallRecord record) {
    tableModel.addRow(new Object[]{
        record.getFormattedStart(),
        record.getFormattedDuration(),
        record.getNetworkType(),
        record.getPhoneNumber(),
        String.format("%.2f", record.getCharges())
    });
}

private void resetForNewCall() {
    startCallBtn.setEnabled(false);
    endCallBtn.setEnabled(false);
    selectNetworkBtn.setEnabled(true);
    phoneNumberField.setText("");
    durationLabel.setText("Duration: 00:00");
    statusLabel.setText("Status: Ready for next call");
}