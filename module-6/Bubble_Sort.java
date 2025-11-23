 /*
 Zachary Anderson
 11/22/25
 M6 Programming Assignment
 */
 public class Bubble_Sort {

    public static void main(String[] args) {

        int[] testValues = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        // Print arrays to show no sorting yet
        printArray(testValues);

        int temp;

        // Outer loop – controls how many passes occur
        for (int i = 0; i < testValues.length - 1; i++) {

            // Inner loop shrinks each pass, matching classic bubble sort
            for (int j = 0; j < testValues.length - 1 - i; j++) {

                // Compare and swap if out of order
                if (testValues[j] > testValues[j + 1]) {
                    temp = testValues[j];
                    testValues[j] = testValues[j + 1];
                    testValues[j + 1] = temp;

                    System.out.println("Switch made");
                }
            }

            // Print array after each full pass of j
            printArray(testValues);
        }

        // Final sorted result
        printArray(testValues);
    }

    
    // Prints array/Tests Code
    
    public static void printArray(int[] arrayParam) {

        System.out.print("\narray = {");

        for (int e : arrayParam) {
            System.out.print(" [" + e + "] ");
        }

        System.out.println("};\n");
    }
}
