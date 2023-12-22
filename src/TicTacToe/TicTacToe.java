import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // Етап 2: Зчитати і відобразити стан гри
        readAndDisplayGameState();

        // Етап 3: Аналіз і виведення результату
        analyzeAndPrintResult();
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

    static void analyzeAndPrintResult() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // Перевірка довжини введеного рядка
        if (input.length() != 9) {
            System.out.println("Error: Invalid input length. Please enter exactly 9 characters.");
            return;
        }

        // Перетворення рядка в масив символів для аналізу
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

        // Аналіз стану гри та виведення результату
        if (isImpossible(gameState)) {
            System.out.println("Impossible");
        } else if (isXWins(gameState)) {
            System.out.println("X wins");
        } else if (isOWins(gameState)) {
            System.out.println("O wins");
        } else if (isDraw(gameState)) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    static boolean isImpossible(char[] gameState) {
        int countX = countSymbol(gameState, 'X');
        int countO = countSymbol(gameState, 'O');

        int diff = Math.abs(countX - countO);
        return countX > countO + 1 || countO > countX + 1 || (diff >= 2 && (countX + countO) < 9);
    }

    static boolean isXWins(char[] gameState) {
        return isWinner(gameState, 'X');
    }

    static boolean isOWins(char[] gameState) {
        return isWinner(gameState, 'O');
    }

    static boolean isDraw(char[] gameState) {
        return !isXWins(gameState) && !isOWins(gameState) && !containsEmptyCells(gameState);
    }

    static boolean isWinner(char[] gameState, char symbol) {
        // Перевірка рядків, стовпців та діагоналей
        return checkRows(gameState, symbol) || checkColumns(gameState, symbol) || checkDiagonals(gameState, symbol);
    }

    static boolean checkRows(char[] gameState, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameState[i * 3] == symbol && gameState[i * 3 + 1] == symbol && gameState[i * 3 + 2] == symbol) {
                return true;
            }
        }
        return false;
    }

    static boolean checkColumns(char[] gameState, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameState[i] == symbol && gameState[i + 3] == symbol && gameState[i + 6] == symbol) {
                return true;
            }
        }
        return false;
    }

    static boolean checkDiagonals(char[] gameState, char symbol) {
        return (gameState[0] == symbol && gameState[4] == symbol && gameState[8] == symbol) ||
                (gameState[2] == symbol && gameState[4] == symbol && gameState[6] == symbol);
    }

    static boolean containsEmptyCells(char[] gameState) {
        for (char cell : gameState) {
            if (cell == ' ' || cell == '_') {
                return true;
            }
        }
        return false;
    }

    static int countSymbol(char[] gameState, char symbol) {
        int count = 0;
        for (char cell : gameState) {
            if (cell == symbol) {
                count++;
            }
        }
        return count;
    }
}
