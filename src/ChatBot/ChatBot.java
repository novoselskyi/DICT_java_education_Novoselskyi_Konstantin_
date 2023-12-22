import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        // Встановлюємо ім'я бота
        String botName = "MyBot";

        // Отримуємо поточний рік
        int currentYear = java.time.Year.now().getValue();

        // Виводимо привітання з ім'ям бота та роком його створення
        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + currentYear + ".");

        // Комітимо перший етап
        System.out.println("ChatBot 1-st stage");

        // Створюємо об'єкт Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Просимо користувача назвати його ім'я
        System.out.println("Please, remind me your name.");

        // Зчитуємо ім'я користувача
        String userName = scanner.nextLine();

        // Виводимо вітання з ім'ям користувача
        System.out.println("What a great name you have, " + userName + "!");

        // Комітимо другий етап
        System.out.println("ChatBot 2-nd stage");
    }
}
