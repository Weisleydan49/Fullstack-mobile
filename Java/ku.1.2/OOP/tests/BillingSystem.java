import java.util.Scanner;

class MobileCall {
    private double durationSeconds;
    private int startHour; // 24-hour format
    private boolean isOtherNetwork;

    // Constructor to initialize call details
    public MobileCall(double durationSeconds, int startHour, boolean isOtherNetwork) {
        this.durationSeconds = durationSeconds;
        this.startHour = startHour;
        this.isOtherNetwork = isOtherNetwork;
    }

    public double calculateTotalBill() {
        double durationMinutes = durationSeconds / 60.0;
        double ratePerMinute;

        // Rule (c): Another network charge
        if (isOtherNetwork) {
            ratePerMinute = 5.0;
        }
        // Rule (a) & (b): Time-based charges for same network
        else if (startHour >= 6 && startHour < 18) {
            ratePerMinute = 4.0; // 6:00 a.m. to 6:00 p.m.
        } else {
            ratePerMinute = 3.0; // 6:00 p.m. to 6:00 a.m.
        }

        double baseCost = durationMinutes * ratePerMinute;

        // Rule (d): 16% VAT for calls longer than 2 minutes
        if (durationMinutes > 2) {
            baseCost += (baseCost * 0.16);
        }

        return baseCost;
    }

    public void displayBill() {
        System.out.printf("Total Bill Amount: Kshs %.2f%n", calculateTotalBill());
    }
}

public class BillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter call duration in seconds: ");
        double duration = scanner.nextDouble();

        System.out.print("Enter start hour (0-23): ");
        int hour = scanner.nextInt();

        System.out.print("Is it to another network? (true/false): ");
        boolean otherNet = scanner.nextBoolean();

        MobileCall call = new MobileCall(duration, hour, otherNet);
        call.displayBill();

        scanner.close();
    }
}