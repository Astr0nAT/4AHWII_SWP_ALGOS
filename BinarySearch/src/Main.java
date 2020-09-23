import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[100];
        fillRandomly(a);
        printA(a);
        long timeDiff;
        long ts;

        ts = nanos();                          // timestamp
        int status = binarySearch(a, 150);
        timeDiff = nanos() - ts;               // calculate time difference
        System.out.println(timeDiff);

        if(status < 0){
            System.out.println("Number not found!");
        }
        else{
            System.out.println("Number found at index " + status + "!");
        }
    }

    public static void fillInOrder(int[] a){
        for(int i = 0; i < a.length; i++){
            a[i] = i + 1;
        }
    }
    public static void fillRandomly(int[] a){
        int value = 1;
        int offset = 1;
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            a[i] = value;
            value += offset * (random.nextInt(3) + 1);
        }
    }

    public static int binarySearch(int[] a, int X){
        int mid = a.length / 2;
        for(int i = 0; i < 7; i++){
            int offset = a.length / (int)(Math.pow(2, i+2));
            if(a[mid] == X){
                return mid;
            }
            else if(a[mid] < X){
                mid = mid + offset;
            }
            else{
                mid = mid - offset;
            }
        }
        return -1;
    }
    public static int sequentialSearch(int[] a, int X){
        for(int i = 0; i < a.length; i++){
            if(a[i] == X){
                return i;
            }
            if(a[i] > X){
                break;
            }
        }
        return -1;
    }

    public static void printA(int[] a){
        for(int i = 0; i < 100; i++){
            System.out.printf("%3d %3d%n", i, a[i]);
        }
        System.out.println();
    }
    public static long nanos(){
        return java.lang.System.nanoTime();
    }
}
