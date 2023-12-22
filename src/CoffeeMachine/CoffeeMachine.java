// CoffeeMachine.java
package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        checkResources(water, milk, coffeeBeans, cups);
    }

    public static void checkResources(int availableWater, int availableMilk, int availableCoffeeBeans, int cups) {
        int waterPerCup = 200;
        int milkPerCup = 50;
        int coffeeBeansPerCup = 15;

        int maxCupsWater = availableWater / waterPerCup;
        int maxCupsMilk = availableMilk / milkPerCup;
        int maxCupsCoffeeBeans = availableCoffeeBeans / coffeeBeansPerCup;

        int maxCupsPossible = Math.min(maxCupsWater, Math.min(maxCupsMilk, maxCupsCoffeeBeans));

        if (cups == 0) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxCupsPossible - 1) + " more than that)");
        } else if (cups <= maxCupsPossible) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("No, I can make only " + maxCupsPossible + " cups of coffee");
        }
    }
}
