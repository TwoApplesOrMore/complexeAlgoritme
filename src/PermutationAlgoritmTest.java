import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationAlgoritmTest {

    private PermutationAlgoritm main;
    private final int NUMBERS_AMOUNT = 5000;

    @Before
    public void setUp() throws Exception {
        main = new PermutationAlgoritm();
    }

    @Test
    public void simplePermutation() throws Exception {
        int [] simplePermutation =  main.simplePermutation(NUMBERS_AMOUNT);

        for(int i =0; i<simplePermutation.length)
    }

    @Test
    public void swapPermutation() throws Exception {
    }

    @Test
    public void usedArrayPermitation() throws Exception {
    }

}