import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // Етап 2: Зчитати і відобразити стан гри
        readAndDisplayGameState();
    }

    static void readAndDisplayGameState() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // Перевірка довжини введеного рядка
        if (input.length() != 9) {
            System.out.println("Error: Invalid input length. Please enter exactly 9 characters.");
            return;
        }

        // Перетворення рядка в масив символів для відображення
        char[] gameState = input.toCharArray();

        // Виведення тире та верхньої границі ігрового поля
        System.out.println("---------");

        // Виведення ігрового поля
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gameState[i * 3 + j] + " ");
            }
            System.out.println("|");
        }

        // Виведення тире та нижньої границі ігрового поля
        System.out.println("---------");
    }
}
