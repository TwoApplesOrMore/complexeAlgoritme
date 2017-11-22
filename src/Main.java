import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private Random RNG = new Random();
    private boolean usedNumber[];
    private Utils utils = new Utils();

    private void run() {


        //int [] simplePermutationList = simplePermutation(10000);
        //int [] swapPermutationList = swapPermutation(10000);

        int testSizes[] = {100000, 200000, 500000, 1000000, 5000000, 10000000};
        long totaltime = 0;
        for(int i = 0; i < testSizes.length; i++) {
            for(int j = 0; j < 10; j++) {

                long starttime = System.nanoTime();
                usedArrayPermitation(testSizes[i]);
                long duration = (System.nanoTime() - starttime) / 1000000;
                totaltime += duration;
            }

            long average = totaltime / 10;
            utils.storeResult("Testsize is: " + testSizes[i] + ", average duration: " + average + " ms.");
            totaltime = 0;
        }



    }

    /**
     *
     * @param numbersAmount
     * @return
     */
    public int [] simplePermutation(int numbersAmount){
        long startTimeSimple = System.nanoTime();

        int [] permutationList = new int[numbersAmount];
        for(int i = 0 ; i<numbersAmount; i++){
            boolean numberfound = false;
            while(!numberfound){
                Random rng = new Random();
                int randomNumber = rng.nextInt(numbersAmount);

                if(!numberExists(permutationList,randomNumber,i)) {
                    permutationList[i] = randomNumber;
                    numberfound = true;
                }
            }
        }
        long elapsedTimeSimple = System.nanoTime() - startTimeSimple;
        System.out.println(elapsedTimeSimple/1000000);

        return permutationList;
    }

    /**
     *
     * @param list
     * @param number
     * @param bound
     * @return
     */
    private boolean numberExists(int[] list, int number, int bound){
        for(int j = 0; j< bound; j++){
            if(number == list[j]){
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @param numbersAmount
     * @return
     */
    public int [] swapPermutation(int numbersAmount) {
        long startTimeSwap = System.nanoTime();

        int[] permutationList = new int[numbersAmount];
        for (int i = 0; i < numbersAmount; i++) {
            permutationList[i] = i;
        }

        for (int j = 0; j < numbersAmount; j++) {
            Random rng = new Random();
            int randomNumber = rng.nextInt(numbersAmount);

            int temp = permutationList[j];
            permutationList[j] = permutationList[randomNumber];
            permutationList[randomNumber] = temp;
        }

        long elapsedTimeSwap = System.nanoTime() - startTimeSwap;
        System.out.println(elapsedTimeSwap/1000000);

        return permutationList;
    }

    /**
     *
     * @param size
     * @return
     */
    private int[] usedArrayPermitation(int size) {
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
