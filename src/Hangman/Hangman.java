// Hangman.java
package hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        // Слово, яке гравець повинен вгадати
        String secretWord = "java";

        // Вивід вказівки для гравця
        System.out.print("Guess the word: > ");

        // Створення об'єкта Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Зчитування введеного слова від гравця
        String playerGuess = scanner.nextLine();

        // Перевірка, чи вгадане слово вірне
        if (playerGuess.equalsIgnoreCase(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
