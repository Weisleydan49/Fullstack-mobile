import java.util.Scanner;

public class EvenOddSum {
    public static void main(String[] args){
        int sumEven = 0;
        int sumOdd = 0;
        for(int count = 0; count <= 6; count++){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter a number:");
            int num = sc.nextInt();

            if(num % 2 == 0){
                sumEven = sumEven + num;
            }
            else {
                sumOdd = sumOdd + num;
            }
        }
        System.out.println("The sum of the Even numbers is " + sumEven );
        System.out.println("The sum of the Odd numbers is " + sumOdd);
    }
}