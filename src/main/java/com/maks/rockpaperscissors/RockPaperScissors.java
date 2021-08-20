package com.maks.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        boolean play = true;
        int wins = 0;
        int ties = 0;
        int losses = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many rounds do you want to play?");
        int rounds = scanner.nextInt();

        do {
            if (rounds<10 && rounds>1){
                for (int i = 1; i<=rounds; i++){
                    System.out.println("\nPick Rock(1), Paper(2) or Scissors(3)");
                    int userSign = scanner.nextInt();
                    if (userSign > 3 || userSign < 1){
                        System.out.println("Error, please pick one of the options");
                    }
                    int computerSign = random.nextInt(3) + 1;
                    int result = userSign - computerSign;
                    if (userSign == computerSign){
                        System.out.println("TIE!");
                        ties++;
                    } else if (result == 1 || result == -2){
                        System.out.println("Player Win!");
                        wins++;
                    } else if (result == -1 || result == 2){
                        System.out.println("Computer Win!");
                        losses++;
                    }
                    System.out.println("Scoreboard\nWins: " + wins + ", Ties: " + ties + ", Losses: " + losses);
                }
                System.out.println("\nDo you want to play again?");
                String choice = scanner.next();

                if (choice.equalsIgnoreCase("No")){
                    play = false;
                } else {
                    System.out.println("Please select Yes or No");
                }
            } else {
                System.out.println("Error, please pick a number between 1 and 10");
                play = false;
            }
        } while (play);

    }

}
