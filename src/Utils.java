import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {


    public Utils() {

    }

    /**
     * method to write our result to a .txt file when a sort is done, so we can let it run
     * This way we don't have to monitor the prints or logs.
     * @param result The string we want to print
     */
    public void storeResult(String result) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("results.txt", true));
            writer.write(result);
            writer.newLine();
            writer.flush();

        } catch (Exception e) {
            System.out.println("Could not write to file: " + e.getMessage());
        } finally {

            // always close the file again
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException ioe) {
                    System.out.println("Could not close writer: " + ioe.getMessage());
                }
            }
        }
    }
}
