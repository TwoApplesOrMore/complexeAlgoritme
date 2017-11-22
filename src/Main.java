import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private Random RNG = new Random();
    private boolean usedNumber[];

    private void run() {


        int [] simplePermutationList = simplePermutation(10000);
        int [] swapPermutationList = swapPermutation(10000);
        usedArrayPermitation(10000);


    }

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
    private boolean numberExists(int[] list, int number, int bound){
        for(int j = 0; j< bound; j++){
            if(number == list[j]){
                return true;
            }
        }
        return false;
    }


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
