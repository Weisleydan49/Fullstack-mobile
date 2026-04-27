package com.almond.billing.model;

import java.time.LocalTime;

public class BillingCalculator {
    public static double calculateCharge(int durationSeconds, boolean isOffNet, LocalTime callEndTime) {
        if (durationSeconds <= 0)
            return 0.0;
        int durationMinutes = (durationSeconds + 59) / 60; // ceiling to next minute

        double rate;
        int time = callEndTime.getHour() * 100 + callEndTime.getMinute();

        if (isOffNet) {
            // OffNet ; Other network - higher rate
            rate = (time >= 600 && time <= 1800) ? 5.00 : 4.00;
        } else {
            // On-net; same network
            rate = (time >= 600 && time <= 1800) ? 5.00 : 3.00;
        }
        return rate * durationMinutes;
    }

    public static String getRateDescription(boolean isOffNet, LocalTime time) {
        // For dispay in history
        String period = (time.getHour() >= 6 && time.getHur() <= 18) ? "Daytime" : "NightTime";
        return isOffNet ? "Off-Net (" + period + ")" : "On-Net (" + period + ")";
    }
}
