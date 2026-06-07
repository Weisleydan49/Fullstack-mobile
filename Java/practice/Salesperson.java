import java.util.Scanner;

public class Salesperson{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the price of goods from Salesperson A: ");
        double a = sc.nextDouble();
        System.out.println("Enter the price of goods from salesperson B: ");
        Scanner sc1 = new Scanner(System.in);
        double b = sc1.nextDouble();
        System.out.println("Enter the price of goods from salesperson C: ");
        Scanner sc3 = new Scanner(System.in);
        double c = sc3.nextDouble();

        double disca = 0.1 * a;
        double amnta = a - disca;
        double discb = 0.1 * b;
        double amntb = b - discb;
        double discc = 0.1 * c;
        double amntc = c - discc;

        Double sum = amnta + amntb + amntc;
        System.out.println("The Total amount is : " + sum );


    }
}