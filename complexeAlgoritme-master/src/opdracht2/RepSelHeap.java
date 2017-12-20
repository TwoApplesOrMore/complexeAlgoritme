package opdracht2;

import opdrach1.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class RepSelHeap {

    public final int HEAP_SIZE = 10;
    public final String OUT_FILE_NAME = "output.txt";
    public final String IN_FILE_NAME = "test.txt";
    private int[] heap = new int[HEAP_SIZE];
    private int deadSpaceSize = 0;
    private int biggestElement;

    private Scanner sc;

    private int maxInput = 50;

    public static void main(String[] args) throws FileNotFoundException {
        new RepSelHeap().run();
    }

    public void run() throws FileNotFoundException {
        sc = new Scanner(new File(IN_FILE_NAME));


        long totaltime = 0;
        int runs = 1;
        int numbersHad = 0;

        fillHeap(HEAP_SIZE);
        numbersHad += HEAP_SIZE;

        buildHeap();
        biggestElement = heap[0];
        while(sc.hasNext() && numbersHad < maxInput){
            numbersHad++;
            long startTime = System.nanoTime();
            System.out.print(Arrays.toString(heap));
            Utils.storeResult(String.valueOf(heap[0]),OUT_FILE_NAME);
            biggestElement = heap[0];
            fillHeap(1);
            if(heap[0] <= biggestElement){
                percolate(0);
            }else{
                int newElement = heap[0];
                heap[0] = heap[HEAP_SIZE-deadSpaceSize-1];
                deadSpaceSize++;
                percolate(0);
                heap[HEAP_SIZE-deadSpaceSize] = newElement;
            }

            if(deadSpaceSize == HEAP_SIZE){
                totaltime += (System.nanoTime() - startTime);
                runs++;
                deadSpaceSize = 0;
                buildHeap();
                Utils.storeResult("NEW RUN!",OUT_FILE_NAME);
            }
        }
        Utils.storeResult("DONE WHILE, DEADSPACE: "+deadSpaceSize,OUT_FILE_NAME);
        long average = (totaltime / runs) / 1000000;
        System.out.println("Heap is: " + Arrays.toString(heap));
        writeHeap();
        System.out.println(runs + "numbers had: " + numbersHad);
        Utils.storeResult("Average of the runs with ( heapsize: " + heap.length + ", totalInput: " + maxInput + "): " + average + "ms", OUT_FILE_NAME);

    }

    public void writeHeap(){
        for(int i =0; i<HEAP_SIZE; i++){
            Utils.storeResult(String.valueOf(heap[0]), OUT_FILE_NAME);
            heap[0] = heap[HEAP_SIZE-deadSpaceSize-1];
            deadSpaceSize++;
            if(!(i+1 == HEAP_SIZE-deadSpaceSize)) {
                percolate(0);
            }
        }
        deadSpaceSize = 0;
        buildHeap();
    }


    public void fillHeap(int amountOfNumbersToFill) throws FileNotFoundException {
        for (int i = 0; i < amountOfNumbersToFill; i++) {
            if (sc.hasNext()) {
                String numberString = sc.next();
                if (numberString.charAt(0) == '[') {
                    numberString = numberString.substring(1);
                }
                if (numberString.charAt(numberString.length() - 1) == ']' || numberString.charAt(numberString.length() - 1) == ',') {
                    numberString = numberString.substring(0, numberString.length() - 1);
                }
                int number = Integer.valueOf(numberString);
                heap[i] = number;
                System.out.print(" NEW NUMBER: "+number);
                System.out.println(" DEAD_SPACE_SIZE: "+deadSpaceSize);
            }
        }
    }

    public void buildHeap(){
        for (int i = (heap.length-1)/2; i >= 0; i--) {
            percolate(i);
        }
    }

    public void percolate(int index) {
        int largestIndex = index;
        int leftIndex = (2 * index);
        int rightIndex = (2 * index) + 1;

        if (leftIndex < heap.length-deadSpaceSize && heap[leftIndex] > heap[largestIndex]) {
            largestIndex = leftIndex;
        }

        if (rightIndex < heap.length-deadSpaceSize && heap[rightIndex] > heap[largestIndex]) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            int swap = heap[index];
            heap[index] = heap[largestIndex];
            heap[largestIndex] = swap;

            //System.out.println(Arrays.toString(heap));
            percolate(largestIndex);
        }
    }
}

