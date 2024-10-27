package com.Esport.Util;

import java.util.Scanner;
import java.time.Duration;
import java.time.format.DateTimeParseException;



public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int validateMenuChoice(int min, int max) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            LoggerUtil.info("Enter your choice (" + min + "-" + max + "): ");
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && input <= max) {
                    validInput = true;
                } else {
                    LoggerUtil.info("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                LoggerUtil.error("Invalid input: Not a number", e);
                LoggerUtil.info("Invalid input. Please enter a valid number.");
            }
        }   

        return input;
    }

    // Jeux input validation
    public static String validateStringInput(){
        LoggerUtil.info("Enter a string: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            LoggerUtil.error("Invalid input: String is empty");
            return validateStringInput();
        }
        // check if the string contains only letters
        if (!input.matches("[a-zA-Z]+")) {
            LoggerUtil.error("Invalid input: String contains non-letter characters");
            return validateStringInput();
        }
        return input;
    }

    public static long validateLongInput(){
        LoggerUtil.info("Enter a long: ");
        long input = 0;
        try {
            input = Long.parseLong(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            LoggerUtil.error("Invalid input: Not a number", e);
            return validateLongInput();
        }
        return input;
    }

    public static Duration validateDurationInput() {
        while (true) {
            LoggerUtil.info("Enter a duration (HH:MM:SS): ");
            String inputString = scanner.nextLine().trim();
            if (inputString.isEmpty()) {
                LoggerUtil.error("Invalid input: Duration is empty");
                continue;
            }

            try {
                String formattedInput = "PT" + inputString.replaceFirst(":", "H").replace(":", "M") + "S";
                return Duration.parse(formattedInput);
            } catch (DateTimeParseException e) {
                LoggerUtil.error("Invalid input: Unable to parse duration. Please use the format HH:MM:SS.", e);
            }
        }
    }

}
