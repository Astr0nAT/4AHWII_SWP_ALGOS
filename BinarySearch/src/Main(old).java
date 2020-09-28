import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[100];
        fillRandomly(a);
        printA(a);
        long timeDiff;
        long ts;

        ts = nanos();                          // timestamp
        int status = binarySearch(a, 100);
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
        for(int i = 0; i < a.length; i++){
            a[i] = value;
            value += offset * (random.nextInt(3) + 1);
        }
    }

    public static int binarySearch(int[] a, int X){
        double min = 0;
        double max = a.length - 1;
        int m;

        while(min <= max){
            m = (int)((min + max) / 2);
            if(a[m] < X){
                min = m + 1;
            }
            else if(a[m] > X){
                max = m - 1;
            }
            else{
                return m;
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
        for(int i = 0; i < a.length; i++){
            System.out.printf("%3d %3d%n", i, a[i]);
        }
        System.out.println();
    }
    public static long nanos(){
        return java.lang.System.nanoTime();
    }
}
