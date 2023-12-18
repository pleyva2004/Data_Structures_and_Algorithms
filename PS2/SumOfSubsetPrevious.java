import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PS2HWSumOfSubsetPrevious {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        int n = scanner.nextInt();

        // Read the array elements
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Check if there is an integer that is the sum of some subset of previous integers
        boolean result = hasSumInSubset(array);

        // Print the result
        System.out.println(result);

        scanner.close();
    }

    // Method to check if there is an integer that is the sum of some subset of previous integers
    public static boolean hasSumInSubset(int[] array) {
        Set<Integer> subsetSums = new HashSet<>();
        subsetSums.add(0); // Include an empty subset

        for (int i = 0; i < array.length - 1; i++) {
            Set<Integer> newSums = new HashSet<>(subsetSums);

            for (int sum : subsetSums) {
                newSums.add(sum + array[i]);
            }

            subsetSums = newSums;

            if (subsetSums.contains(array[i + 1])) {
                return true;
            }
        }

        return false;
    }
}
