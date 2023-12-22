package CreditCalculator;

import java.util.ArrayList;

public class CreditCalculator {

    public static void main(String[] args) {
        CalculatorLogic calculatorLogic = new CalculatorLogic();
        String type = System.getProperty("type");

        String principalStr = System.getProperty("principal");
        String periodsStr = System.getProperty("periods");
        String interestStr = System.getProperty("interest");

        if (principalStr != null && periodsStr != null && interestStr != null) {
            double loanPrincipal = Double.parseDouble(principalStr);
            int numberOfPayments = Integer.parseInt(periodsStr);
            double loanInterest = Double.parseDouble(interestStr);

            if ("annuity".equals(type)) {
                double monthlyPayment = calculatorLogic.calculateAnnuityPayment(loanPrincipal, numberOfPayments, loanInterest);
                printMonthlyPayment(monthlyPayment);
            } else if ("diff".equals(type)) {
                ArrayList<Double> differentialPayments = calculatorLogic.calculateDifferentialPayments(loanPrincipal, numberOfPayments, loanInterest);
                printDifferentialPayments(differentialPayments);
            } else {
                System.out.println("Incorrect parameters");
            }
        } else {
            System.out.println("Some parameters are missing");
        }
    }

    // Вивід щомісячного платежу
    public static void printMonthlyPayment(double monthlyPayment) {
        System.out.printf("Your annuity payment = %.0f%n", Math.ceil(monthlyPayment));
    }

    // Вивід диференційованих платежів
    public static void printDifferentialPayments(ArrayList<Double> payments) {
        for (int month = 1; month <= payments.size(); month++) {
            System.out.printf("Month %d: payment is %.0f%n", month, Math.ceil(payments.get(month - 1)));
        }
        System.out.printf("Overpayment = %.0f%n", Math.ceil(payments.stream().mapToDouble(Double::doubleValue).sum()));
    }
}
