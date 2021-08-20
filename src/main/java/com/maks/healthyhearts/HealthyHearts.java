package com.maks.healthyhearts;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How old are you?");

        int age = scanner.nextInt();

        int maximumHR = 220 - age;

        System.out.println("Your maximum heart rate should be " + maximumHR + " beats per minute");

        System.out.println("Your target HR Zone is " + Math.round(maximumHR * 0.5) + " - " + Math.round(maximumHR * 0.85) + " beats per minute");
    }
}
