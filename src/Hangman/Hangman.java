// Hangman.java
package hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        // Список слів
        String[] words = {"python", "java", "javascript", "kotlin"};

        // Випадковим чином вибираємо слово зі списку
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String secretWord = words[randomIndex];

        // Вивід підказки гравцеві (перші 2 літери)
        StringBuilder hint = new StringBuilder(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            if (i < 2) {
                hint.append(secretWord.charAt(i));
            } else {
                hint.append("-");
            }
        }

        // Вивід вказівки для гравця
        System.out.print("Guess the word " + hint + ": > ");

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
