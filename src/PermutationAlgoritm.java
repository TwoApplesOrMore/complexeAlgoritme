import java.util.Random;

public class PermutationAlgoritm {
    public static void main(String[] args) {
        new PermutationAlgoritm().run();
    }

    private Random RNG = new Random();
    private final int AMOUNT_OF_RUNS = 1;

    private void run() {
        int[] numberAmountsSimple = {5000, 10000, 20000, 50000, 100000, 200000};
        int[] numberAmountsUsed = {100000, 200000, 500000, 1000000, 5000000, 10000000};
        int[] numberAmountsSwap = {2000000, 5000000, 10000000, 20000000, 50000000, 100000000};

        for (int i = 0; i < numberAmountsSimple.length; i++) {
            int averagetime = 0;
            for (int j = 0; j < AMOUNT_OF_RUNS; j++) {
                long startTime = System.nanoTime();
                simplePermutation(numberAmountsSimple[i]);
                averagetime += (System.nanoTime() - startTime) / 1000000;
            }
            averagetime = averagetime / AMOUNT_OF_RUNS;
            System.out.println("[SIMPLE] Average time with " + numberAmountsSimple[i] + " numbers is: " + averagetime + "ms");
        }

        System.out.println();

        for (int i = 0; i < numberAmountsUsed.length; i++) {
            int averagetime = 0;
            for (int j = 0; j < AMOUNT_OF_RUNS; j++) {
                long startTime = System.nanoTime();
                usedArrayPermitation(numberAmountsUsed[i]);
                averagetime += (System.nanoTime() - startTime) / 1000000;
            }
            averagetime = averagetime / AMOUNT_OF_RUNS;
            System.out.println("[USED] Average time with " + numberAmountsUsed[i] + " numbers is: " + averagetime + "ms");
        }

        System.out.println();

        for (int i = 0; i < numberAmountsSwap.length; i++) {
            int averagetime = 0;
            for (int j = 0; j < AMOUNT_OF_RUNS; j++) {
                long startTime = System.nanoTime();
               swapPermutation(numberAmountsSwap[i]);
                averagetime += (System.nanoTime() - startTime) / 1000000;
            }
            averagetime = averagetime / AMOUNT_OF_RUNS;
            System.out.println("[SWAP] Average time with " + numberAmountsSwap[i] + " numbers is: " + averagetime + "ms");
        }


    }

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

    private boolean numberExists(int[] list, int number, int bound) {
        for (int j = 0; j < bound; j++) {
            if (number == list[j]) {
                return true;
            }
        }
        return false;
    }


    public int[] swapPermutation(int numbersAmount) {
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

        return permutationList;
    }


    public int[] usedArrayPermitation(int size) {
        boolean usedNumber[];
        usedNumber = new boolean[size];
        int permitation[] = new int[size];
        for (int i = 0; i < size; i++) {
            boolean unique = false;
            while (!unique) {
                int random = RNG.nextInt(size);
                if (isUnique(usedNumber, random)) {
                    permitation[i] = random;
                    usedNumber[random] = true;
                    unique = true;
                }
            }
        }

        return permitation;
    }

    private boolean isUnique(boolean usedNumber[], int random) {
        if (usedNumber[random]) {
            return false;
        } else {
            return true;
        }
    }
}
