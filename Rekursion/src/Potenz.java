public class Potenz {
    public static void main(String[] args) {
        System.out.println(pow(2,10));
    }

    private static int pow(int num, int pow) {
        if(pow == 1){
            return num;
        }

        return num * pow(num, pow - 1);
    }
}
