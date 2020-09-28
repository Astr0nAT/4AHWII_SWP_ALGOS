import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final Scanner reader = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        int power, boundary, search;
        double timeBinary, timeSequential, time, factor;

        System.out.print("10^x?: ");
        power = inputInt(1, 8);

        boundary = (int) Math.pow(10, power);
        System.out.println("Boundary is set to " + boundary + " (= 10^" + power + ")");

        search = random.nextInt(boundary - 1) + 1;
        System.out.println("Beginning search with number: " + search + "\n");

        timeBinary = binarySearch(search, boundary);
        timeSequential = sequentialSearch(search, boundary);
        time = timeSequential - timeBinary;

        System.out.println("The binary search algorithm was " + time + " nanoseconds faster.");
        factor = timeSequential / timeBinary;
        System.out.println("Factor: " + factor);
    }

    private static double sequentialSearch(int search, int boundary) {
        int[] numbers = new int[boundary];
        double timeDiff = 0,
                timestamp;

        fillNumbers(numbers, boundary);
        timestamp = nanos();
        for (int i = 0; i < boundary; i++) {
            if (numbers[i] == search) {
                timeDiff = nanos() - timestamp;
                System.out.println("Number found at index " + i + " in " + timeDiff + " nanoseconds.");
            } else if (numbers[i] > search) {
                break;
            }
        }
        return timeDiff;
    }

    private static int inputInt(int lower, int upper) {
        boolean retry = true;
        int power = 0;

        do {
            try {
                power = Integer.parseInt(reader.nextLine());
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (power >= lower && power <= upper) {
                retry = false;
            } else {
                System.out.println("Only " + lower + " to " + upper + ".");
            }
        } while (retry);
        System.out.println();

        return power;
    }

    private static double binarySearch(int search, int boundary) {
        int[] numbers = new int[boundary];
        double min = 0,
                max = numbers.length - 1,
                timeDiff = 0,
                timestamp;
        int mid;

        fillNumbers(numbers, boundary);
        timestamp = nanos();
        while (min <= max) {
            mid = (int) ((min + max) / 2);
            if (numbers[mid] < search) {
                min = mid + 1;
            } else if (numbers[mid] > search) {
                max = mid - 1;
            } else {
                timeDiff = nanos() - timestamp;
                System.out.println("Number found at index " + mid + " in " + timeDiff + " nanoseconds.");
                break;
            }
        }

        return timeDiff;
    }

    private static void fillNumbers(int[] numbers, int boundary) {
        for (int i = 0; i < boundary; i++) {
            numbers[i] = i + 1;
        }
    }

    private static double nanos() {
        return (double) System.nanoTime();
    }
}
