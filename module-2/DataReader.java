/*
 * Zachary Anderson
 * M2 Data Reader
 * 10/25/25
 * 
 */
import java.io.*;

public class DataReader {
    public static void main(String[] args) {
        String fileName = "ZacharyDatafile.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading data from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}