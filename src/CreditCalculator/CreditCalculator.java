package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вхідні дані
        System.out.println("Enter the loan principal:");
        double loanPrincipal = scanner.nextDouble();

        System.out.println("What do you want to calculate?\n" +
                "type \"m\" – for the number of monthly payments,\n" +
                "type \"p\" – for the monthly payment:");
        char choice = scanner.next().charAt(0);

        double monthlyPayment = 0;
        double lastPayment = 0;

        if (choice == 'm') {
            // Розрахунок кількості місяців
            System.out.println("Enter the monthly payment:");
            monthlyPayment = scanner.nextDouble();
            lastPayment = calculateLastPayment(loanPrincipal, monthlyPayment);
            int numberOfMonths = calculateNumberOfMonths(loanPrincipal, monthlyPayment);
            System.out.println("It will take " + numberOfMonths + " months to repay the loan");
        } else if (choice == 'p') {
            // Розрахунок щомісячного платежу
            System.out.println("Enter the number of months:");
            int numberOfMonths = scanner.nextInt();
            monthlyPayment = calculateMonthlyPayment(loanPrincipal, numberOfMonths);
            lastPayment = calculateLastPayment(loanPrincipal, monthlyPayment);
            System.out.println("Your monthly payment = " + Math.ceil(monthlyPayment));
        }

        // Перевірка останнього платежу
        if (lastPayment != monthlyPayment) {
            System.out.println("and the last payment = " + (int) lastPayment + ".");
        }
    }

    // Метод для обчислення кількості місяців
    public static int calculateNumberOfMonths(double principal, double monthlyPayment) {
        return (int) Math.ceil(principal / monthlyPayment);
    }

    // Метод для обчислення щомісячного платежу
    public static double calculateMonthlyPayment(double principal, int numberOfMonths) {
        return principal / numberOfMonths;
    }

    // Метод для обчислення останнього платежу
    public static double calculateLastPayment(double principal, double monthlyPayment) {
        return principal - (calculateNumberOfMonths(principal, monthlyPayment) - 1) * monthlyPayment;
    }
}
