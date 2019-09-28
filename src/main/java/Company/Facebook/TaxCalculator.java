package main.java.Company.Facebook;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        new TaxCalculator().start();
    }

    private Scanner scanner = new Scanner(System.in);

    private void start() {
        System.out.println("*****2016 Annual Tax Calculator*****\n");
        System.out.println("0 = Single\n1 = Married\n2 = Head of Household\n");

        FilingStatus status = getFilingStatus();
        BigDecimal taxableIncome = getTaxableIncome();

        BigDecimal tax = calculateTax(status, taxableIncome);

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        System.out.println("Your total tax is: " + currencyFormatter.format(tax.setScale(2, BigDecimal.ROUND_HALF_UP)));
        System.out.println();
    }

    private FilingStatus getFilingStatus() {
        System.out.print("Please enter your filing status: ");

        int status;

        String statusString = scanner.nextLine();
        try {
            status = Integer.parseInt(statusString);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: You must enter either 0, 1 or 2");
            return getFilingStatus();
        }

        if (status < 0 || status >= FilingStatus.values().length) {
            System.out.println("ERROR: You must enter either 0, 1 or 2");
            return getFilingStatus();
        }

        return FilingStatus.values()[status];
    }

    private BigDecimal getTaxableIncome() {
        System.out.print("Please enter your total taxable income: $");

        String incomeString = scanner.nextLine();

        // Remove commas
        incomeString = incomeString.replace(",", "");

        BigDecimal income;
        try {
            income = new BigDecimal(incomeString);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: You must enter a valid number");
            return getTaxableIncome();
        }

        if (income.compareTo(new BigDecimal("0")) < 0) {
            System.out.println("ERROR: You must enter 0 or a positive number");
            return getTaxableIncome();
        }

        return income;
    }


    private BigDecimal calculateTax(FilingStatus status, BigDecimal taxableIncome) {
        if (taxableIncome.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;

        TaxBracket[] taxTable = TAX_TABLES.get(status);

        BigDecimal tax = BigDecimal.ZERO;
        for (TaxBracket taxBracket : taxTable) {
            if (taxBracket.maxSalary.signum() != -1 && taxableIncome.compareTo(taxBracket.maxSalary) >= 0)
                tax = tax.add(taxBracket.maxSalary.subtract(taxBracket.minSalary).multiply(taxBracket.taxRate));
            else if (taxBracket.maxSalary.signum() == -1 || taxableIncome.compareTo(taxBracket.minSalary) >= 0)
                tax = tax.add(taxableIncome.subtract(taxBracket.minSalary).add(new BigDecimal(1)).multiply(taxBracket.taxRate));
            else
                break;
        }

        return tax;
    }

    private enum FilingStatus {
        SINGLE,
        MARRIED_JOINT,
        HEAD_OF_HOUSEHOLD
    }

    private static class TaxBracket {
        final BigDecimal minSalary;
        final BigDecimal maxSalary;
        final BigDecimal taxRate;

        TaxBracket(String minSalary, String maxSalary, String taxRate) {
            this.minSalary = new BigDecimal(minSalary);
            this.maxSalary = new BigDecimal(maxSalary);
            this.taxRate = new BigDecimal(taxRate);
        }
    }

    private static final Map<FilingStatus, TaxBracket[]> TAX_TABLES;

    static {
        TAX_TABLES = new HashMap<>();

        TAX_TABLES.put(FilingStatus.SINGLE, new TaxBracket[]{
                new TaxBracket("0", "9075", "0.10"),
                new TaxBracket("9076", "36900", "0.15"),
                new TaxBracket("36901", "89350", "0.25"),
                new TaxBracket("89351", "186350", "0.28"),
                new TaxBracket("186351", "405100", "0.33"),
                new TaxBracket("405101", "406750", "0.35"),
                new TaxBracket("406751", "-1", "0.396")
        });
        TAX_TABLES.put(FilingStatus.MARRIED_JOINT, new TaxBracket[]{
                new TaxBracket("0", "18150", "0.10"),
                new TaxBracket("18151", "73800", "0.15"),
                new TaxBracket("73801", "148850", "0.25"),
                new TaxBracket("148851", "226850", "0.28"),
                new TaxBracket("226851", "405100", "0.33"),
                new TaxBracket("405101", "457600", "0.35"),
                new TaxBracket("457601", "-1", "0.396")
        });
        TAX_TABLES.put(FilingStatus.HEAD_OF_HOUSEHOLD, new TaxBracket[]{
                new TaxBracket("0", "12950", "0.10"),
                new TaxBracket("12951", "49400", "0.15"),
                new TaxBracket("49401", "127550", "0.25"),
                new TaxBracket("127551", "206600", "0.28"),
                new TaxBracket("206601", "405100", "0.33"),
                new TaxBracket("405101", "432200", "0.35"),
                new TaxBracket("432201", "-1", "0.396")
        });
    }
}
