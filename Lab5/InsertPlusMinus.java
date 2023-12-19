import java.util.Scanner;

public class InsertPlusMinus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the input (two space-separated strings of digits and the target sum): ");
        String inputLine = scanner.nextLine();

        // Split the input line into operands and target sum
        String[] inputParts = inputLine.split(" ");
        String firstOperand = inputParts[0];
        long targetSum = Long.parseLong(inputParts[1]);

        // Find and print the result
        String result = findExpression(firstOperand, targetSum);
        System.out.println(result);

        scanner.close();
    }

    public static String findExpression(String input, long targetSum) {
        return findExpressionHelper(input.toCharArray(), 0, 0, targetSum, "");
    }

    private static String findExpressionHelper(char[] digits, int index, long currentSum, long targetSum, String currentExpression) {
        if (index == digits.length) {
            // Evaluate the current expression
            if (currentSum == targetSum) {
                // If the current expression evaluates to the target sum, return it
                return currentExpression;
            } else {
                // Otherwise, return null
                return null;
            }
        }

        // Skip leading zeros
        int start = index;
        while (index < digits.length && digits[index] == '0') {
            index++;
        }

        long num = 0;
        for (int i = start; i < digits.length; i++) {
            num = num * 10 + (digits[i] - '0');

            String expressionWithPlus = findExpressionHelper(digits, i + 1, currentSum + num, targetSum,
                    currentExpression + (currentExpression.isEmpty() ? "" : "+") + num);

            String expressionWithMinus = findExpressionHelper(digits, i + 1, currentSum - num, targetSum,
                    currentExpression + (currentExpression.isEmpty() ? "" : "-") + num);

            // Return the first valid expression found (with plus or minus sign)
            if (expressionWithPlus != null) {
                return expressionWithPlus;
            } else if (expressionWithMinus != null) {
                return expressionWithMinus;
            }
        }

        // If no valid expression is found, return null
        return null;
    }
}
