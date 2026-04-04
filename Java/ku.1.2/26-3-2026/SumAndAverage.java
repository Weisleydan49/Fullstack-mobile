public class SumAndAverage {
    public static void main(String[] args) {
        int sum = 0;
        int lowerbound = 1;
        int upperbound = 100;

        for (int number = lowerbound; number <= upperbound; ++number) {
            sum += number;
        }

        double average = (double) sum / upperbound;

        System.out.println("The sum is " + sum);
        System.out.println("The average is " + average);
    }
}
