import java.util.Scanner;

public class Results{
    //Attributes
    private String name;
    private int math, eng, kis;


    //Constructors
    public Results(String name){
        this.name = name;
    }
//Method to enter marks
        public void inputMarks(){
            Scanner sc = new Scanner(System.in);


            System.out.println("Enter the marks for Math: ");
            this.math = sc.nextInt();


            System.out.println("Enter the marks for Eng: ");
            this.eng = sc.nextInt();


            System.out.println("Enter the marks for Kis: ");
            this.kis = sc.nextInt();
        }
//Method to calculate total
public double calcTotal() {
    double total = math + eng + kis;
    return total;
}
//Method to calculate average
public double calcAverage() {
    return calcTotal() / 3;
}
    //Method to display results
    public void display(){
        System.out.println("===MARKS === ");
        System.out.println("Name: " + name);
        System.out.println("Mathematics :" + math);
        System.out.println("English: " + eng);
        System.out.println("Kiswahili: " + kis);
        System.out.println("Total: " + calcTotal());
        System.out.println("Average: " + calcAverage());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    for (int count = 0; count < 3; count++) {

        System.out.println("Enter your name: ");
        String studName = sc.nextLine();

        //Create object
        Results student = new Results(studName);


        student.inputMarks();
        student.display();
    }
    sc.close();
}

}