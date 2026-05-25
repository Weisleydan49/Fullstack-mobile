import java.util.Scanner;

public class Switch {
    public static void main(String[] args){

        String[] ref = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh"};

        for (int count = 0; count <= 7; count+=1){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer for the day of the week: ");
        int dayNum = sc.nextInt();

        switch (dayNum) {
            case 1:
                System.out.println("Saturday is the " + ref[0] + " day of the week");
                break;
            case 2:
                System.out.println("Sunday is the " + ref[1] + " day of the week");
                break;
            case 3:
                System.out.println("Monday is the " + ref[2] + " day of the week");
                break;
            case 4:
                System.out.println("Tuesday is the " + ref[3] + " day of the week");
                break;
            case 5:
                System.out.println("Wednesday is the " + ref[4] + " day of the week");
                break;
            case 6:
                System.out.println("Thursday is the " + ref[5] + " day of the week");
                break;
            case 7:
                System.out.println("Friday is the " + ref[6] + " day of the week");
                break;
            default:
                System.out.println("Enter a valid number");
        }
        }
    }
}