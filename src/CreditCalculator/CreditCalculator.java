package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вхідні дані
        System.out.println("What do you want to calculate?\n" +
                "type \"n\" for the number of monthly payments,\n" +
                "type \"a\" for annuity monthly payment amount,\n" +
                "type \"p\" for loan principal:");
        char choice = scanner.next().charAt(0);

        double loanPrincipal = 0;
        double monthlyPayment = 0;
        double loanInterest = 0;
        int numberOfPayments = 0;

        // Обчислення параметрів кредиту
        switch (choice) {
            case 'n':
                // Розрахунок кількості місяців
                System.out.println("Enter the loan principal:");
                loanPrincipal = scanner.nextDouble();
                System.out.println("Enter the monthly payment:");
                monthlyPayment = scanner.nextDouble();
                System.out.println("Enter the loan interest:");
                loanInterest = scanner.nextDouble();
                numberOfPayments = calculateNumberOfPayments(loanPrincipal, monthlyPayment, loanInterest);
                printNumberOfPayments(numberOfPayments);
                break;

            case 'a':
                // Розрахунок щомісячного платежу
                System.out.println("Enter the loan principal:");
                loanPrincipal = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                numberOfPayments = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                loanInterest = scanner.nextDouble();
                monthlyPayment = calculateAnnuityPayment(loanPrincipal, numberOfPayments, loanInterest);
                printMonthlyPayment(monthlyPayment);
                break;

            case 'p':
                // Розрахунок основної суми кредиту
                System.out.println("Enter the annuity payment:");
                monthlyPayment = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                numberOfPayments = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                loanInterest = scanner.nextDouble();
                loanPrincipal = calculateLoanPrincipal(monthlyPayment, numberOfPayments, loanInterest);
                printLoanPrincipal(loanPrincipal);
                break;

            default:
                System.out.println("Invalid choice. Please choose 'n', 'a', or 'p'.");
        }
    }

    // Метод для обчислення кількості місяців
    public static int calculateNumberOfPayments(double principal, double monthlyPayment, double interest) {
        double i = interest / 100 / 12;
        return (int) Math.ceil(Math.log(monthlyPayment / (monthlyPayment - i * principal)) / Math.log(1 + i));
    }

    // Метод для обчислення щомісячного платежу
    public static double calculateAnnuityPayment(double principal, int numberOfPayments, double interest) {
        double i = interest / 100 / 12;
        return principal * (i * Math.pow(1 + i, numberOfPayments)) / (Math.pow(1 + i, numberOfPayments) - 1);
    }

    // Метод для обчислення основної суми кредиту
    public static double calculateLoanPrincipal(double monthlyPayment, int numberOfPayments, double interest) {
        double i = interest / 100 / 12;
        return monthlyPayment / ((i * Math.pow(1 + i, numberOfPayments)) / (Math.pow(1 + i, numberOfPayments) - 1));
    }

    // Метод для виведення кількості місяців
    public static void printNumberOfPayments(int numberOfPayments) {
        int years = numberOfPayments / 12;
        int months = numberOfPayments % 12;

        if (years > 0 && months > 0) {
            System.out.println("It will take " + years + " years and " + months + " months to repay this loan!");
        } else if (years > 0) {
            System.out.println("It will take " + years + " years to repay this loan!");
        } else {
            System.out.println("It will take " + months + " months to repay this loan!");
        }
    }

    // Метод для виведення щомісячного платежу
    public static void printMonthlyPayment(double monthlyPayment) {
        System.out.println("Your monthly payment = " + Math.ceil(monthlyPayment) + "!");
    }

    // Метод для виведення основної суми кредиту
    public static void printLoanPrincipal(double loanPrincipal) {
        System.out.println("Your loan principal = " + (int) Math.ceil(loanPrincipal) + "!");
    }
}
