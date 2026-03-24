public class num3and5 {
    public static void main(String[] args){
        int p = 0;
        do {
        if(p % 3 == 0 && p % 5 == 0) {
            System.out.println(p);
        }
        p++;
        } while (p <= 100);

    }
}
