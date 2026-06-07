import java.util.Scanner;
public class Quadratic{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("Enter the value of a :");
        double a = sc.nextDouble();
        System.out.println("Enter thevalue of b: ");
        double b = sc1.nextDouble();
        System.out.println("Enter the value of c: ");
        double c = sc2.nextDouble();

        double x1 = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        double x2 = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);

        System.out.println("The values of x are :" + x1 + " and " + x2);
            
    sc.close();
    sc1.close();
    sc2.close();
}
        
}