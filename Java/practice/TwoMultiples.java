public class TwoMultiples{
    public static void main(String[] args){
        int sum = 0;
        for(int i = 2; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        System.out.print("The sum of the multiples is " + sum);
    }
}