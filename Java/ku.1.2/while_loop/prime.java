public class prime {
    public static void main(String[] args) {
        System.out.println("===Prime Numbers between 1 and 100===");
        int p = 2;
        while(p <+ 100){
            if(p == 2 || p == 3 || p == 5 || p == 7){
                System.out.println(p);
            }
            else if(p % 2 != 0 && p % 3 != 0 && p % 5 != 0 && p % 7 != 0){
                System.out.println(p);
            }
            p++;
        }
    }
}
