public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println((i + 1) + ": " + fib(i));
        }
    }

    private static int fib(int n){
        if(n < 2){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
