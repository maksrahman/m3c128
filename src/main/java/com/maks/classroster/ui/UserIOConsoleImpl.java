package com.maks.classroster.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    final Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println("Printing message:");
        System.out.println(message);
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.next();
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int payload;
        do{
            System.out.println("Please enter int between " + min + " and " + max);
            payload = scanner.nextInt();
        }while(payload > max || payload < min);

        return payload;
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        double payload;
        do{
            System.out.println("Please enter double between " + min + " and " + max);
            payload = scanner.nextDouble();
        }while(payload > max || payload < min);

        return payload;
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        return scanner.nextFloat();
    }

    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        float payload;
        do{
            System.out.println("Please enter float between " + min + " and " + max);
            payload = scanner.nextFloat();
        }while(payload > max || payload < min);

        return payload;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        return scanner.nextLong();
    }

    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        long payload;
        do{
            System.out.println("Please enter int between " + min + " and " + max);
            payload = scanner.nextLong();
        }while(payload > max || payload < min);

        return payload;
    }
}
