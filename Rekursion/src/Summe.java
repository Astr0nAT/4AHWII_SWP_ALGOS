public class Summe {
    public static void main(String[] args) {
        System.out.println(sumRecursive(5));
        System.out.println(sumIterative(5));
    }

    private static int sumIterative(int num) {
        int res = 0;

        for (int i = 1; i <= num; i++) {
            res = res + i;
        }

        return res;
    }

    private static int sumRecursive(int num) {
        if(num == 0){
            return 0;
        }

        return num + sumRecursive(num - 1);
    }
}
