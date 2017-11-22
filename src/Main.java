import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private static final int NUMBERS_AMOUNT = 1000000;


    private void run() {
        long startTimeSimple = System.nanoTime();

        int [] simplePermutationList = simplePermutation(NUMBERS_AMOUNT);

        long elapsedTimeSimple = System.nanoTime() - startTimeSimple;
        System.out.println(elapsedTimeSimple/1000000);


        long startTimeSwap = System.nanoTime();

        int [] swapPermutationList = swapPermutation(NUMBERS_AMOUNT);

        long elapsedTimeSwap = System.nanoTime() - startTimeSwap;
        System.out.println(elapsedTimeSwap/1000000);

    }

    public int [] simplePermutation(int numbersAmount){
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


    public int [] swapPermutation(int numbersAmount){
        int [] permutationList = new int[numbersAmount];
        for(int i = 0; i<numbersAmount; i++){
            permutationList[i] = i;
        }

        for(int j = 0; j<numbersAmount; j++){
            Random rng = new Random();
            int randomNumber = rng.nextInt(numbersAmount);

            int temp = permutationList[j];
            permutationList[j] = permutationList[randomNumber];
            permutationList[randomNumber] = temp;
        }
        return permutationList;
    }
}
