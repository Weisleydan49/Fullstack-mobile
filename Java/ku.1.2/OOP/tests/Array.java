public class Array {
    public static void main(String[] args) {
        int[] _arrays = new int[100];
        for (int i = 0; i < _arrays.length; i++) {
            _arrays[i] = i + 1;
        }
        System.out.println("The numbers are:");
        for (int _array : _arrays) {
            System.out.println(_array + "");
        }
    }

}
