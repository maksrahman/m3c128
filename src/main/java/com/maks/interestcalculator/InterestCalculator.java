package com.maks.interestcalculator;

import java.util.Scanner;
import java.text.DecimalFormat;

public class InterestCalculator {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("How much do you want to invest?");

        double amount = myScanner.nextDouble();

        System.out.println("How many years are you investing?");

        int years = myScanner.nextInt();

        System.out.println("What is the annual interest rate % growth?");

        double apr = myScanner.nextDouble();

        double quaterlyRate = apr/4;

        double interestRate = Math.pow(1 + (quaterlyRate / 100), 4);

        for (int i = 1; i <= years; i++){
            System.out.println("\nYear " + i);
            System.out.println("Began with £" + df.format(amount));
            System.out.println("Earned £" + df.format(amount * (interestRate - 1)));
            amount = amount * interestRate;
            System.out.println("Ended with £" + df.format(amount));
        }

    }
}
