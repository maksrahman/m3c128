package com.maks.statecapitals2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class StateCapitals2 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, String> capitals = loadCapitals();

        System.out.println("50 STATES & CAPITALS ARE LOADED.");
        System.out.println("================================");
        System.out.println("HERE ARE THE STATES:");
        System.out.println(capitals.keySet());

        Random rng = new Random();
        int rIndex = rng.nextInt(capitals.size());
        String[] states = capitals.keySet().toArray(new String[0]);
        String rState = states[rIndex];
        String answer = capitals.get(rState);
        System.out.println("READY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF " + rState + "?");

        Scanner scanner = new Scanner(System.in);
        String userAnswer;
        do {
            userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase(answer)){
                System.out.println("NICE WORK! " + userAnswer.toUpperCase() + " IS CORRECT!");
            } else {
                System.out.println("Oooo Nope! Try again");
            }
        } while (!userAnswer.equalsIgnoreCase(answer));

    }

    private static HashMap<String, String>  loadCapitals() throws FileNotFoundException {
        HashMap<String, String> capitals = new HashMap<>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader("src/main/java/com/maks/statecapitals2/StateCapitals.txt")));
        while (sc.hasNextLine()){
            String[] currentLine = sc.nextLine().split("::");
            capitals.put(currentLine[0], currentLine[1]);
        }
        return capitals;
    }
}
