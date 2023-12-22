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

        // Створення об'єкта StringBuilder для побудови слова
        StringBuilder guessedWord = new StringBuilder(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord.append("-");
        }

        // Кількість спроб
        int attemptsLeft = 8;

        // Створення об'єкта Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Гра продовжується, доки є спроби та слово не вгадане
        while (attemptsLeft > 0 && guessedWord.toString().contains("-")) {
            // Вивід поточного стану слова та спроб
            System.out.println("Current word: " + guessedWord);
            System.out.println("Attempts left: " + attemptsLeft);

            // Зчитування введеної літери від гравця
            System.out.print("Input a letter: > ");
            char letter = scanner.next().charAt(0);

            // Перевірка, чи літера зустрічається в слові
            if (secretWord.indexOf(letter) != -1) {
                System.out.println("The letter is in the word!");
                // Заміна "-" на вірні літери
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        guessedWord.setCharAt(i, letter);
                    }
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                attemptsLeft--;
            }
        }

        // Вивід результату гри
        if (guessedWord.toString().equals(secretWord)) {
            System.out.println("Congratulations! You survived!");
        } else {
            System.out.println("Thanks for playing! We'll see how well you did in the next stage.");
        }
    }
}
