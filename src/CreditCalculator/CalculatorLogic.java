package CreditCalculator;

import java.util.ArrayList;

public class CalculatorLogic {

    // Розрахунок щорічного платежу (annuity)
    public double calculateAnnuityPayment(double principal, int numberOfPayments, double interestRate) {
        double monthlyInterestRate = interestRate / 100 / 12;
        return principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }

    // Розрахунок основної суми кредиту (loan principal)
    public double calculateLoanPrincipal(double annuityPayment, int numberOfPayments, double interestRate) {
        double monthlyInterestRate = interestRate / 100 / 12;
        return annuityPayment / ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }

    // Розрахунок кількості платежів (number of payments)
    public int calculateNumberOfPayments(double principal, double annuityPayment, double interestRate) {
        double monthlyInterestRate = interestRate / 100 / 12;
        return (int) Math.ceil(Math.log(annuityPayment / (annuityPayment - monthlyInterestRate * principal))
                / Math.log(1 + monthlyInterestRate));
    }

    // Розрахунок диференційованих платежів (diff)
    public ArrayList<Double> calculateDifferentialPayments(double principal, int numberOfPayments, double interestRate) {
        double monthlyInterestRate = interestRate / 100 / 12;
        ArrayList<Double> payments = new ArrayList<>();

        for (int month = 1; month <= numberOfPayments; month++) {
            double payment = principal / numberOfPayments + monthlyInterestRate * (principal - principal * (month - 1) / numberOfPayments);
            payments.add(payment);
        }

        return payments;
    }
}
