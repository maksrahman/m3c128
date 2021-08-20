package com.maks.factorizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factorizer {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Which number would you like to factor?");

        int userNumber = myScanner.nextInt();

        System.out.println("You picked " + userNumber);

        List<Integer> factors = factorizer(userNumber);

        int nFactors = factors.size() + 2;

        int sumFactors = factors.stream().mapToInt(Integer::intValue).sum() + 1;

        if (nFactors > 2){
            System.out.println("The factors are: " + factors.toString().replace("[", "").replace("]", ""));

            System.out.println(userNumber + " has " + nFactors + " factors (including 1 and itself)");

            if (sumFactors == userNumber){
                System.out.println(userNumber + " is a perfect number!");
            }

        } else if (nFactors == 2) {
            System.out.println(userNumber + " is a prime number!");
        }

    }

    public static List<Integer> factorizer(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                factors.add(i);
            }
        }
        return factors;
    }
}
