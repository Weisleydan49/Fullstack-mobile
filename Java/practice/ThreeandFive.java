public class ThreeandFive{
    public static void main(String args[]){
        int count = 1;
        do{
            if(count % 3 != 0 && count % 5 != 0) {
                System.out.println(count);
            }
       count++;
        }
        while(count < 100);
    }
}