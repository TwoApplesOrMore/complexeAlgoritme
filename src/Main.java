import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private Random RNG = new Random();
    private boolean usedNumber[];

    private void run() {
        usedArrayPermitation(1000000);
        //System.out.println(Arrays.toString(usedArrayPermitation(100000)));
    }

    private int[] usedArrayPermitation(int size) {
        long startTime = System.nanoTime();
        usedNumber = new boolean[size];
        int permitation[] = new int[size];
        for(int i = 0; i < size; i++) {

            boolean unique = false;
            while(!unique) {
                int random = RNG.nextInt(size);
                if(isUnique(random)) {
                    permitation[i] = random;
                    usedNumber[random] = true;
                    unique = true;
                }
            }
        }
        long duration = (System.nanoTime() - startTime) / 1000000;
        System.out.println("Duration: " + duration);
        return permitation;
    }

    private boolean isUnique(int random) {
        if(usedNumber[random]) {
            return false;
        } else {
            return true;
        }
    }
}
