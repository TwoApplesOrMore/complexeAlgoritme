package opdrach1;

import java.util.Arrays;
import java.util.Random;

public class PermutationAlgoritm {
    public static void main(String[] args) {
        new PermutationAlgoritm().run();
    }

    private Random rng = new Random();
    private final int AMOUNT_OF_RUNS = 1;

    private void run() {
        int[] numberAmountsSimple = {5000, 10000, 20000, 50000, 100000, 200000};
        int[] numberAmountsUsed = {100000, 200000, 500000, 1000000, 5000000, 10000000};
       // int[] numberAmountsSwap = {2000000, 5000000, 10000000, 20000000, 50000000, 100000000};
        int[] numberAmountsSwap = {10000};

//        for (int i = 0; i < numberAmountsSimple.length; i++) {
//            int averagetime = 0;
//            for (int j = 0; j < AMOUNT_OF_RUNS; j++) {
//                long startTime = System.nanoTime();
//                simplePermutation(numberAmountsSimple[i]);
//                averagetime += (System.nanoTime() - startTime) / 1000000;
//            }
//            averagetime = averagetime / AMOUNT_OF_RUNS;
//            String print = "[SIMPLE] Average time over "+AMOUNT_OF_RUNS+" runs with " + numberAmountsSimple[i] + " numbers is: " + averagetime + "ms";
//            System.out.println(print);
//            Utils.storeResult(print);
//        }
//
//        System.out.println();
//
//        for (int i = 0; i < numberAmountsUsed.length; i++) {
//            int averagetime = 0;
//            for (int j = 0; j < AMOUNT_OF_RUNS; j++) {
//                long startTime = System.nanoTime();
//                usedArrayPermitation(numberAmountsUsed[i]);
//                averagetime += (System.nanoTime() - startTime) / 1000000;
//            }
//            averagetime = averagetime / AMOUNT_OF_RUNS;
//            String print = "[USED] Average time over "+AMOUNT_OF_RUNS+" runs with " + numberAmountsUsed[i] + " numbers is: " + averagetime + "ms";
//            System.out.println(print);
//            Utils.storeResult(print);
//        }
//
//        System.out.println();

//        for (int i = 0; i < numberAmountsSwap.length; i++) {
//            int averagetime = 0;
//            for (int j = 0; j < AMOUNT_OF_RUNS; j++) {
//                long startTime = System.nanoTime();
//                swapPermutation(numberAmountsSwap[i]);
//                averagetime += (System.nanoTime() - startTime) / 1000000;
//            }
//            averagetime = averagetime / AMOUNT_OF_RUNS;
//            String print = "[SWAP] Average time over "+AMOUNT_OF_RUNS+" runs with " + numberAmountsSwap[i] + " numbers is: " + averagetime + "ms";
//            System.out.println(print);
//            Utils.storeResult(print, );
//        }


    }

    /**
     * puts an unique random numer on every index of an integer arraylist.
     * numbers are valued from 0 to the total integerarray length.
     * if a number already exists in the list, a new number wil be generated until a unique number is found.
     * @param numbersAmount the amount of numbers to generate
     * @return an integer Array permutation.
     */
    public int[] simplePermutation(int numbersAmount) {
        int[] permutationList = new int[numbersAmount];
        for (int i = 0; i < numbersAmount; i++) {
            boolean numberfound = false;
            while (!numberfound) {
                Random rng = new Random();
                int randomNumber = rng.nextInt(numbersAmount);

                if (!numberExists(permutationList, randomNumber, i)) {
                    permutationList[i] = randomNumber;
                    numberfound = true;
                }
            }
        }

        return permutationList;
    }

    /**
     * helper method used by the simplePermutation method.
     * checks if a number already exists in the list
     * @param list the list to check in
     * @param number the number to check
     * @param bound the bound of the list that have already been filled
     * @return true if the number exists, false if it doesn't
     */
    private boolean numberExists(int[] list, int number, int bound) {
        for (int j = 0; j < bound; j++) {
            if (number == list[j]) {
                return true;
            }
        }
        return false;
    }

    /**
     * first goes trough all numbers and swapts each already filled index with j.
     * then it adds a new number which is equal to j.
     *
     * @param numbersAmount the amount of numbers to generate
     * @return an integer Array permutation.
     */
    public int[] swapPermutation(int numbersAmount) {
        int[] permutationList = new int[numbersAmount];

        for (int j = 0; j < numbersAmount; j++) {
            int randomNumber = (int) (Math.random()*j);

            permutationList[j] = permutationList[randomNumber];
            permutationList[randomNumber] = j;

        }

//        Utils.storeResult(Arrays.toString(permutationList));

        return permutationList;
    }

    /**
     * First makes a boolean Arraylist with the same length as the given numbersAmount.
     * then does the same for an interger Arraylist.
     * after that it itterates all positions in the integer Arraylist and picks a random number.
     * if the number picked does not have a value of true in the boolean Arraylist it will add it to the integer Arraylist.
     * if the number has a value of false it will pick another random number until a unique number is found.
     * @param numbersAmount the amount of numbers to generate
     * @return an integer Array permutation.
     */
    public int[] usedArrayPermitation(int numbersAmount) {
        boolean usedNumber[];
        usedNumber = new boolean[numbersAmount];
        int permitation[] = new int[numbersAmount];
        for (int i = 0; i < numbersAmount; i++) {
            boolean unique = false;
            while (!unique) {
                int random = rng.nextInt(numbersAmount);
                if(!usedNumber[random]){
                    permitation[i] = random;
                    usedNumber[random] = true;
                    unique = true;
                }
            }
        }

        return permitation;
    }
}
