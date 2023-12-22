package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printState();
            System.out.println("Write action (buy, fill, take):");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    buyCoffee(scanner);
                    break;
                case "fill":
                    fillMachine(scanner);
                    break;
                case "take":
                    takeMoney();
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }
    }

    private static void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = scanner.nextInt();

        int waterNeeded = 0;
        int milkNeeded = 0;
        int coffeeBeansNeeded = 0;
        int cost = 0;

        switch (choice) {
            case 1: // espresso
                waterNeeded = 250;
                coffeeBeansNeeded = 16;
                cost = 4;
                break;
            case 2: // latte
                waterNeeded = 350;
                milkNeeded = 75;
                coffeeBeansNeeded = 20;
                cost = 7;
                break;
            case 3: // cappuccino
                waterNeeded = 200;
                milkNeeded = 100;
                coffeeBeansNeeded = 12;
                cost = 6;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        makeCoffee(waterNeeded, milkNeeded, coffeeBeansNeeded, cost);
    }

    private static void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            disposableCups--;
            money += cost;
        } else {
            System.out.println("Not enough resources to make coffee!");
        }
    }

    private static void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int addedWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addedMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addedCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        int addedCups = scanner.nextInt();

        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        disposableCups += addedCups;
    }

    private static void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    private static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
