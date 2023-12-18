import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumOfSubsetPrevious{

    public static int countNumbersAsSum(int[] numbers) {
        int count = 0;
        Set<Integer> seenSums = new HashSet<>();

        for (int num : numbers) {
            if (seenSums.contains(num) || num == 0) {
                count++;
            }

            Set<Integer> newSums = new HashSet<>();
            for (int prevSum : seenSums) {
                newSums.add(prevSum + num);
            }

            seenSums.addAll(newSums);
            seenSums.add(num);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for numbersArray
        System.out.print("Enter the numbers separated by spaces: ");
        String input = scanner.nextLine();
        String[] numbersStringArray = input.split(" ");

        int[] numbersArray = new int[numbersStringArray.length];
        for (int i = 0; i < numbersStringArray.length; i++) {
            numbersArray[i] = Integer.parseInt(numbersStringArray[i]);
        }

        // Count numbers that are the sum of some subset
        int resultCount = countNumbersAsSum(numbersArray);

        System.out.println("Count of numbers that are the sum of some subset: " + resultCount);
    }
}
