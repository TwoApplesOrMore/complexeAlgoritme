package opdrach1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    /**
     * method to write our result to a .txt file when a sort is done, so we can let it run
     * This way we don't have to monitor the prints or logs.
     * @param result The string we want to print
     */
    public static void storeResult(String result, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
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