package opdrach1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PermutationAlgoritmTest {

    private PermutationAlgoritm main;
    private final int NUMBERS_AMOUNT = 10;

    @Before
    public void setUp() throws Exception {
        main = new PermutationAlgoritm();
    }

    @Test
    public void simplePermutationTestDuplicates() throws Exception {
        int [] simplePermutation =  main.simplePermutation(NUMBERS_AMOUNT);


        for(int i =0; i<simplePermutation.length; i++){
            for(int j = 0; j<simplePermutation.length; j++){
                if(i!=j){
                    assertNotEquals(simplePermutation[i],simplePermutation[j]);
                }
            }
        }
    }

    @Test
    public void usedArrayPermitationTestDuplicates() throws Exception {
        int [] usedPermutation =  main.usedArrayPermitation(NUMBERS_AMOUNT);


        for(int i =0; i<usedPermutation.length; i++){
            for(int j = 0; j<usedPermutation.length; j++){
                if(i!=j){
                    assertNotEquals(usedPermutation[i],usedPermutation[j]);
                }
            }
        }
    }

    @Test
    public void swapPermutationTestDuplicates() throws Exception {
        int [] swapPermutation =  main.swapPermutation(NUMBERS_AMOUNT);

        System.out.println(Arrays.toString(swapPermutation));

        for(int i =0; i<swapPermutation.length; i++){
            for(int j = 0; j<swapPermutation.length; j++){
                if(i!=j){
                    assertNotEquals(swapPermutation[i],swapPermutation[j]);
                }
            }
        }


    }

    @Test
    public void swapPermutationTestUnswapped() throws Exception {
        int [] swapPermutation =  main.swapPermutation(NUMBERS_AMOUNT);


        int unswappedNumbers = 0;
        for(int i = 0; i<swapPermutation.length; i++){
            if(swapPermutation[i]==i){
                unswappedNumbers++;
            }
        }
        System.out.println("[TEST UNSWAPPED] Amount of back swapped Numbers: "+unswappedNumbers);
        assertTrue(unswappedNumbers<(swapPermutation.length/2));
    }
}