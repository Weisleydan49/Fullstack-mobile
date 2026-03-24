public class prime {
    public static void main(String[] args){
        int p = 2;
        do { if (p ==2 || p == 3 || p == 5 || p == 7){
            System.out.println(p);
        }
        else if(p % 2 != 0 && p % 3 != 0 && p % 5 != 0 && p % 7 != 0){
            System.out.println(p);
        }
        p++;
        } while (p <= 100);
    }
}
