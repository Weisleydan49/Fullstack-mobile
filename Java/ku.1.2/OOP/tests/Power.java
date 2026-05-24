import java.util.Scanner;

public class Power{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.print("Enter the base number : ");
        int base = sc.nextInt();
        System.out.print("Enter the exponent number : ");
        int exponent = sc1.nextInt();
        int result = 1;
        for(int i = 1; i <= exponent; i +=1){
            result *= base;
        }
        System.out.println("The number " + base + " raised to " + exponent + " is " +result);
    }
}