/*
 * Zachary Anderson
 * M2 Data Writer
 * 10/25/25
 * 
 */
import java.io.*;
import java.util.Random;

public class DataWriter {
    public static void main(String[] args) {
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];
        Random rand = new Random();

        // Generate random integers and doubles
        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100); // 0-99
            doubleArray[i] = rand.nextDouble() * 100; // 0.0-99.99
        }

        // File name
        String fileName = "ZacharyDatafile.dat";

        // Write to file (append mode)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Integers: ");
            for (int num : intArray) {
                writer.write(num + " ");
            }
            writer.newLine();

            writer.write("Doubles: ");
            for (double num : doubleArray) {
                writer.write(String.format("%.2f ", num));
            }
            writer.newLine();
            
            System.out.println("Data written successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}