/*
Zachary Anderson
11/8/25
M5 Programming Assignment
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class WordsSorter {
    

  
    public static Set<String> getUniqueWords(String filename) {
        Set<String> words = new TreeSet<>(); // TreeSet sorts automatically in ascending order
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                // Remove punctuation and convert to lowercase for uniformity
                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return words;
    }

    /*
     Displays words in ascending order.
    */
    public static void displayAscending(Set<String> words) {
        System.out.println("Words in ascending order:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    /**
     * Displays words in descending order.
     */
    public static void displayDescending(Set<String> words) {
        System.out.println("Words in descending order:");
        List<String> list = new ArrayList<>(words);
        Collections.reverse(list);
        for (String word : list) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        String filename = "collection_of_words.txt";
        Set<String> uniqueWords = getUniqueWords(filename);

        // Test: ensure the program reads words and removes duplicates
        System.out.println("Total unique words: " + uniqueWords.size());

        displayAscending(uniqueWords);
        displayDescending(uniqueWords);

        // Additional simple test to verify uniqueness
        assert uniqueWords.size() == new TreeSet<>(uniqueWords).size() : "Duplicate detected!";
    }
}
