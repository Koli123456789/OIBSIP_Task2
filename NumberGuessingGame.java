package Task2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        // Play multiple rounds
        for (int round = 1; round <= 3; round++) {
            System.out.println("\nRound " + round);
            int randomNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            // Allow the user to guess up to MAX_ATTEMPTS times
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    // Calculate score based on the number of attempts
                    totalScore += (MAX_ATTEMPTS - attempts + 1);
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts! The correct number was " + randomNumber);
            }
        }

        // Display the final score after all rounds
        System.out.println("\nGame Over! Your total score is: " + totalScore);
        scanner.close();
    }
}
