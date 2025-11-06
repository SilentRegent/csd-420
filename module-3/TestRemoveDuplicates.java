/*
Zachary Anderson
M3 Programming Assignment
11/5/25
*/
import java.util.ArrayList;
import java.util.Random;

public class TestRemoveDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        // Fill ArrayList with 50 random values between 1 and 20
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        System.out.println("Original ArrayList:");
        System.out.println(originalList);

        ArrayList<Integer> result = removeDuplicates(originalList);

        System.out.println("\nArrayList After Removing Duplicates:");
        System.out.println(result);
    }

    // static generic method that returns a NEW ArrayList with no duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();

        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
