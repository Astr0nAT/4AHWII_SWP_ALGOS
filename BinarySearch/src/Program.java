import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        int power;
        System.out.println("10^x?: ");
        power = inputInt(1, 7);

        int search = new Random().nextInt(1000000);
        System.out.println("Beginning search with number: " + search);

        double timeDiff;
        timeDiff = binarySearch(search);


    }

    private static int inputInt(int lower, int upper) {
        boolean retry = true;
        int power;
        do {
            power = reader.nextInt();
            if (power > lower && power < upper) {
                retry = false;
            } else {
                System.out.println("Only 1 to 7.");
            }
        } while (retry);
        System.out.println();

        return power;
    }

    private static double binarySearch(int search) {
        int[] numbers = new int[search];


        return 0;
    }
}
