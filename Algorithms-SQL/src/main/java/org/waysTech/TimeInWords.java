package org.waysTech;

import java.util.Scanner;

public class TimeInWords {
    private static final String[] NUMBER_WORDS = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen",
            "seventeen", "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two",
            "twenty-three", "twenty-four", "twenty-five", "twenty-six", "twenty-seven",
            "twenty-eight", "twenty-nine", "half"
    };

    private static final String[] HOUR_WORDS = {
            "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve"
    };

    public static String timeInWords(int H, int M) {
        int hour = H % 12 == 0 ? 12 : H % 12;
        int nextHour = (hour % 12) + 1;

        String minuteWord = M == 1 ? "minute" : "minutes";
        String direction = M <= 30 ? "past" : "to";
        int displayMinute = direction.equals("past") ? M : 60 - M;
        int displayHour = direction.equals("to") ? nextHour : hour;

        String timeWord;
        switch (displayMinute) {
            case 0:
                timeWord = HOUR_WORDS[hour] + " o’clock";
                break;
            case 15:
            case 30:
            case 45:
                timeWord = NUMBER_WORDS[displayMinute] + " " + direction + " " + HOUR_WORDS[displayHour];
                break;
            default:
                timeWord = NUMBER_WORDS[displayMinute] + " " + minuteWord + " " + direction + " " + HOUR_WORDS[displayHour];
                break;
        }

        return timeWord;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput = "yes";

        do {
            System.out.print("Enter Time hours: ");
            int H = scanner.nextInt();
            if (H < 0 || H > 24) {
                System.out.println("Invalid time Hours");
                continue;
            }

            System.out.print("Enter Time Minutes: ");
            int M = scanner.nextInt();
            if (M < 0 || M > 59) {
                System.out.println("Invalid minutes input");
                continue;
            }

            System.out.println(timeInWords(H, M));

            System.out.print("Do you want to enter another time? (yes/no): ");
            continueInput = scanner.next();
        } while (continueInput.equalsIgnoreCase("yes"));

        scanner.close();
    }
}
