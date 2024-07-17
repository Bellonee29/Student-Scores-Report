package org.waysTech;

import java.util.Scanner;

public class SumOfDigits {

    // Recursive function to calculate the sum of digits
    public static int sumOfDigits(String number) {
        // Base case: if the string is empty, return 0
        if (number.isEmpty()) {
            return 0;
        }
        // Convert the first character to an integer and add to the recursive sum of the remaining string
        return Character.getNumericValue(number.charAt(0)) + sumOfDigits(number.substring(1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput = "yes";

        do {
            System.out.print("Enter a non-negative number: ");
            String input = getValidatedInput(scanner);

            int result = sumOfDigits(input);
            System.out.println("The sum of digits is: " + result);

            System.out.print("Do you want to enter another time? (yes/no): ");
            continueInput = scanner.nextLine().trim(); // Read the whole line for user response
        } while (continueInput.equalsIgnoreCase("yes"));

        scanner.close();
    }

    // Validates the input to ensure it's a non-negative number
    private static String getValidatedInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")) {
                return input;
            } else {
                System.out.print("Invalid input. Please enter a non-negative number: ");
            }
        }
    }
}
