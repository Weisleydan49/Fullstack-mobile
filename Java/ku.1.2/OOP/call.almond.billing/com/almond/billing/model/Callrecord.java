import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Callrecord {
    private final LocalDateTime startTime;
    private final int durationSeconds;
    private final String networkType; // same network or other network
    private final double charges;
    private final String phoneNumber; // optional, dialied number

    public Callrecord(LocalDateTime start, int durationSec, String netType, double chg, String number) {
        this.startTime = start;
        this.durationSeconds = durationSec;
        this.networkType = netType;
        this.charges = chg;
        this.phoneNumber = number != null ? number : "N/A";
    }

    // Getter methods for table display
    public String getFormattedStart() {
        return startTime.format(DateTimeFormatter.ofPattern("MM-dd-yyy HH:mm:ss"));
    }

    public String getFormattedDuration() {
        int min = durationSeconds / 60;
        int sec = durationSeconds % 60;
        return String.format("%02d:%02d", min, sec);
    }

    // Other getters
    public double getCharges() {
        return charges;
    }

    public String networkType() {
        return networkType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}