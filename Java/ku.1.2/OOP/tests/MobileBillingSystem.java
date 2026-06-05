import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ====================================================
//  SIT203 – Object Oriented Programming Assignment
//  Mobile Phone Billing System
// =============================================================================


// ── Class 1: Call ─────────────────────────────────────────────────────────────
class Call {
    private String callType;       // "local" or "external"
    private int    startHour;      // 0–23 (24-hour format)
    private int    durationSeconds;

    public Call(String callType, int startHour, int durationSeconds) {
        this.callType        = callType.toLowerCase();
        this.startHour       = startHour;
        this.durationSeconds = durationSeconds;
    }

    public String getCallType()        { return callType; }
    public int    getStartHour()       { return startHour; }
    public int    getDurationSeconds() { return durationSeconds; }

    // Duration in minutes (fractional) for per-second billing accuracy
    public double getDurationMinutes() { return durationSeconds / 60.0; }

    // Returns true if this is a cross-network call
    public boolean isExternal() { return callType.equals("external"); }

    // Returns true if call starts between 06:00 and 18:00
    public boolean isDayTime() { return startHour >= 6 && startHour < 18; }
}


// ── Class 2: BillResult ───────────────────────────────────────────────────────
class BillResult {
    private final Call   call;
    private final double baseCharge;
    private final double vatAmount;
    private final double totalCharge;
    private final String rateDescription;

    public BillResult(Call call, double baseCharge, double vatAmount,
                      double totalCharge, String rateDescription) {
        this.call            = call;
        this.baseCharge      = baseCharge;
        this.vatAmount       = vatAmount;
        this.totalCharge     = totalCharge;
        this.rateDescription = rateDescription;
    }

    public Call   getCall()            { return call; }
    public double getBaseCharge()      { return baseCharge; }
    public double getVatAmount()       { return vatAmount; }
    public double getTotalCharge()     { return totalCharge; }
    public String getRateDescription() { return rateDescription; }

    @Override
    public String toString() {
        int mins = call.getDurationSeconds() / 60;
        int secs = call.getDurationSeconds() % 60;
        String type = call.isExternal()
                ? "External (cross-network)"
                : "Local (" + (call.isDayTime() ? "Day" : "Night") + ")";
        return String.format(
                "-----------------------------------------------------%n" +
                        "  Call Type    : %s%n" +
                        "  Duration     : %d min %d sec%n" +
                        "  Start Hour   : %02d:00%n" +
                        "  Rate Applied : %s%n" +
                        "  Base Charge  : Kshs %.2f%n" +
                        "  VAT (16%%)   : Kshs %.2f%n" +
                        "  TOTAL CHARGE : Kshs %.2f%n" +
                        "-----------------------------------------------------",
                type, mins, secs, call.getStartHour(),
                rateDescription, baseCharge, vatAmount, totalCharge
        );
    }
}


// ── Class 3: BillingCalculator ────────────────────────────────────────────────
class BillingCalculator {

    private static final double DAY_RATE_PER_MIN   = 4.00;
    private static final double NIGHT_RATE_PER_MIN = 3.00;
    private static final double EXTERNAL_FLAT_RATE = 5.00;
    private static final double VAT_RATE           = 0.16;
    private static final double VAT_THRESHOLD_MINS = 2.0;

    /**
     * Calculates the bill for a given Call.
     *
     * Rules:
     *  1. External call           -> Kshs 5.00 flat (no VAT)
     *  2. Local day  (06:00-18:00) -> Kshs 4.00 per minute
     *  3. Local night(18:00-06:00) -> Kshs 3.00 per minute
     *  4. Duration > 2 minutes    -> 16% VAT added on base charge
     */
    public BillResult calculate(Call call) {
        double baseCharge;
        double vatAmount = 0.0;
        String rateDescription;

        if (call.isExternal()) {
            baseCharge      = EXTERNAL_FLAT_RATE;
            rateDescription = "External network - flat rate";
        } else {
            double ratePerMinute;
            if (call.isDayTime()) {
                ratePerMinute   = DAY_RATE_PER_MIN;
                rateDescription = "Day rate (06:00-18:00) @ Kshs 4.00/min";
            } else {
                ratePerMinute   = NIGHT_RATE_PER_MIN;
                rateDescription = "Night rate (18:00-06:00) @ Kshs 3.00/min";
            }
            baseCharge = ratePerMinute * call.getDurationMinutes();

            if (call.getDurationMinutes() > VAT_THRESHOLD_MINS) {
                vatAmount = baseCharge * VAT_RATE;
            }
        }

        return new BillResult(call, baseCharge, vatAmount,
                baseCharge + vatAmount, rateDescription);
    }
}


// ── Class 4: Customer ─────────────────────────────────────────────────────────
class Customer {
    private final String          name;
    private final String          phoneNumber;
    private final List<Call>      calls;
    private final BillingCalculator calculator;

    public Customer(String name, String phoneNumber) {
        this.name        = name;
        this.phoneNumber = phoneNumber;
        this.calls       = new ArrayList<>();
        this.calculator  = new BillingCalculator();
    }

    public void addCall(Call call) {
        calls.add(call);
    }

    public void printBill() {
        System.out.println("=====================================================");
        System.out.println("            MOBILE BILLING STATEMENT                ");
        System.out.println("=====================================================");
        System.out.printf ("  Customer   : %s%n", name);
        System.out.printf ("  Phone No   : %s%n", phoneNumber);
        System.out.println("=====================================================");

        double grandTotal = 0.0;
        int    callNumber = 1;

        for (Call call : calls) {
            BillResult result = calculator.calculate(call);
            System.out.printf("%nCall #%d%n", callNumber++);
            System.out.println(result);
            grandTotal += result.getTotalCharge();
        }

        System.out.println();
        System.out.println("=====================================================");
        System.out.printf ("  Total Calls  : %d%n", calls.size());
        System.out.printf ("  AMOUNT DUE   : Kshs %.2f%n", grandTotal);
        System.out.println("=====================================================");
    }
}


// ── Class 5: MobileBillingSystem (main) ───────────────────────────────────────
public class MobileBillingSystem {

    public static void main(String[] args) {

        System.out.println("\n========================================");
        System.out.println("   WELCOME TO MOBILE BILLING SYSTEM    ");
        System.out.println("========================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name   : ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter phone number    : ");
        String phone = scanner.nextLine().trim();

        Customer customer = new Customer(name, phone);
        boolean addMore   = true;

        while (addMore) {
            System.out.println("\n--- New Call Entry ---");

            System.out.print("Call type (local / external): ");
            String type = scanner.nextLine().trim().toLowerCase();

            int hour = 0;
            if (!type.equals("external")) {
                System.out.print("Start hour (0-23, 24-hr format): ");
                hour = Integer.parseInt(scanner.nextLine().trim());
            }

            System.out.print("Duration - minutes: ");
            int mins = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Duration - seconds: ");
            int secs = Integer.parseInt(scanner.nextLine().trim());

            customer.addCall(new Call(type, hour, mins * 60 + secs));

            System.out.print("\nAdd another call? (yes/no): ");
            addMore = scanner.nextLine().trim().toLowerCase().startsWith("y");
        }

        customer.printBill();
        scanner.close();
    }
}