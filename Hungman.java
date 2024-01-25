/*TASK 4

HANGMAN GAME

● Create an array or list of words to choose from.
● Select a random word using the Random class.
● Use a loop to iterate through each turn.
● Prompt the user for a letter using Scanner.
● Check if the letter is in the word and update the display.
● Display the hangman figure based on incorrect guesses. */

import java.util.Scanner;
import java.util.Random;

public class Hungman {
    public static void main(String[] args) {
        String[] words = {"java", "programming", "hangman", "computer", "language"};
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        char[] guessedLetters = new char[wordToGuess.length()];
        boolean[] guessedCorrectly = new boolean[wordToGuess.length()];
        int incorrectGuesses = 0;

        Scanner scanner = new Scanner(System.in);

    
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        while (true) {
            System.out.println("Current word: " + new String(guessedLetters));

            System.out.print("Enter a letter: ");
            char guessedLetter = scanner.next().charAt(0);

            boolean letterGuessedCorrectly = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    guessedLetters[i] = guessedLetter;
                    guessedCorrectly[i] = true;
                    letterGuessedCorrectly = true;
                }
            }

            if (!letterGuessedCorrectly) {
                incorrectGuesses++;
            }

            
            displayHangman(incorrectGuesses);

            if (new String(guessedLetters).equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }

            if (incorrectGuesses == 6) {
                System.out.println("Sorry! You ran out of attempts. The correct word was: " + wordToGuess);
                break;
            }
        }
        scanner.close();
    }

    private static void displayHangman(int incorrectGuesses) {
        String[] hangmanFigures = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
        };

        System.out.println(hangmanFigures[incorrectGuesses]);
        
    }
}