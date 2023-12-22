// Hangman.java
package hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            System.out.println("HANGMAN");
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: > ");
            String choice = scanner.next().toLowerCase();

            if ("play".equals(choice)) {
                playGame(scanner);  // Pass the scanner object to the playGame method
            } else if ("exit".equals(choice)) {
                playAgain = false;
                System.out.println("Goodbye, have a nice day!");
            } else {
                System.out.println("Invalid choice. Please type \"play\" or \"exit\".");
            }
        }
    }

    private static void playGame(Scanner scanner) {
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String selectedWord = words[random.nextInt(words.length)];
        char[] guessedWord = new char[selectedWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '-';
        }

        int attemptsLeft = 8;
        boolean wordGuessed = false;

        while (attemptsLeft > 0 && !wordGuessed) {
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.println(new String(guessedWord));
            System.out.print("Input a letter: > ");
            char userInput = scanner.next().charAt(0);

            if (!Character.isLowerCase(userInput)) {
                System.out.println("Please enter a lowercase English letter.");
            } else if (!Character.isLetter(userInput)) {
                System.out.println("You should input a single letter.");
            } else if (alreadyGuessed(userInput, guessedWord)) {
                System.out.println("You've already guessed this letter");
            } else if (containsLetter(userInput, selectedWord)) {
                updateGuessedWord(userInput, selectedWord, guessedWord);
                if (new String(guessedWord).equals(selectedWord)) {
                    wordGuessed = true;
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                attemptsLeft--;
            }
        }

        if (wordGuessed) {
            System.out.println("You guessed the word!");
            System.out.println("You survived!");
        } else {
            System.out.println("You lost! The word was: " + selectedWord);
        }
    }

    private static boolean alreadyGuessed(char letter, char[] guessedWord) {
        return new String(guessedWord).indexOf(letter) != -1;
    }

    private static boolean containsLetter(char letter, String word) {
        return word.indexOf(letter) != -1;
    }

    private static void updateGuessedWord(char letter, String word, char[] guessedWord) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessedWord[i] = letter;
            }
        }
    }
}
