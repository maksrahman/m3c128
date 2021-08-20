package com.maks.luckysevens;

import java.util.Random;
import java.util.Scanner;

public class LuckySevens {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner myScanner = new Scanner(System.in);

        System.out.println("How much money do you have?");

        int bank = myScanner.nextInt();
        int rolls = 0;
        int optimalRolls = 0;
        int max = bank;

        while (bank > 0){
            rolls++;

            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;

            if (dice1 + dice2 == 7){
                bank += 4;
            } else {
                bank--;
            }

            if (bank > max){
                max = bank;
                optimalRolls = rolls;
            }

        }

        System.out.println("You are broke after " + rolls + " rolls");
        System.out.println("You should have quit after " + optimalRolls + " rolls when you had £" + max);
    }
}
