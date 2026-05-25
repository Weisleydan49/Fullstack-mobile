import java.util.Scanner;

public class WhileNumbers {
     public static void main(String[] args){
         String choice =
         int sum = 0;
         do{
             String[] ref = {'first', 'second'};
             System.out.print("Enter the " + ref[0] + " number");
             Scanner sc = new Scanner(System.in);
             int num = sc.nextInt();
             sum += num;
             System.out.println("Do you wish to continue? {Yes or No (y/n) ?");

         } while(count <= 2)
             count += 1;
     }
     System.out.println("The sum of the numbers is :" + sum);

}