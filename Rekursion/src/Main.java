public class Main {
    public static void main(String[] args) {
        System.out.println(summeRekursiv(4));
    }

    private static int summeRekursiv(int n) {
        if(n == 0){
            return 1;
        }

        return summeRekursiv(n - 1) * n;
    }
}
