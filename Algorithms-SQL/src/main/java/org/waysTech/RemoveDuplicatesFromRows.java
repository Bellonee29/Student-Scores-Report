package org.waysTech;

import java.util.Scanner;

public class RemoveDuplicatesFromRows {

    public static void removeDuplicates(int[][] array) {
        for (int[] row : array) {
            if (row.length == 0) continue; // To skip empty rows

            int max = getMax(row);
            boolean[] seen = new boolean[max + 1];

            for (int i = 0; i < row.length; i++) {
                if (seen[row[i]]) {
                    row[i] = 0;
                } else {
                    seen[row[i]] = true;
                }
            }
        }
    }

    private static int getMax(int[] row) {
        int max = 0;
        for (int num : row) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows (n): ");
        int n = getValidatedIntInput(scanner);

        int[][] array = new int[n][];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the number of elements in row " + (i + 1) + ": ");
            int m = getValidatedIntInput(scanner);
            array[i] = new int[m];
            System.out.println("Enter the elements of row " + (i + 1) + " (space-separated): ");
            array[i] = getValidatedRow(scanner, m);
        }
        scanner.close();

        removeDuplicates(array);

        System.out.println("Array after removing duplicates:");
        printArray(array);
    }

    private static int getValidatedIntInput(Scanner scanner) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input < 0) {
                    System.out.print("Invalid input. Please enter a non-negative integer: ");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }

    private static int[] getValidatedRow(Scanner scanner, int length) {
        while (true) {
            String[] tokens = scanner.nextLine().trim().split("\\s+");
            if (tokens.length == length) {
                int[] row = new int[length];
                try {
                    for (int i = 0; i < length; i++) {
                        row[i] = Integer.parseInt(tokens[i]);
                    }
                    return row;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter " + length + " integers (space-separated): ");
                }
            } else {
                System.out.print("Invalid input. Please enter exactly " + length + " integers (space-separated): ");
            }
        }
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
