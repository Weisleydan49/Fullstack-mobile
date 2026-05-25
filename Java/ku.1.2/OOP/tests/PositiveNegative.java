import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args){
        Scanner number = new Scanner(System.in);

        System.out.println("Enter the number of times you want to enter numbers: ");

        int times = number.nextInt();
        int positive = 0;
        int negative = 0;
        int zeros = 0;

        for(int count = 1; count <= times; count+=1){
            Scanner num = new Scanner(System.in);

            System.out.println("Enter a positive, negative number or zero: ");
            int p = num.nextInt();
            if( p == 0){
                zeros = zeros + 1;
            } else if ( p < 0 ) {
                negative += 1;
            } else if ( p > 0) {
                positive += 1;
            } else {
                System.out.print("Enter a valid integer, either a zero, positive or negative number");
            }
        }
        System.out.println("The number of zeros is "+ zeros);
        System.out.println("The number of positive numbers is " + positive);
        System.out.println("The number of negative numbers is " + negative);
    }
}