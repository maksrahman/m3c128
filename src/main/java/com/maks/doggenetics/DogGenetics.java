package com.maks.doggenetics;

import java.util.*;

public class DogGenetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your dog's name?");

        String name = scanner.next();

        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.");

        System.out.println(name + " is:");

        geneticsReport();

        System.out.println("Wow, that's QUITE the dog!");

    }

    public static void geneticsReport(){
        Random random = new Random();
        List<String> breedsList = Arrays.asList( "Labrador Retriever",
                "Cocker Spaniel",
                "Jack Russell Terrier",
                "Staffordshire Bull Terrier",
                "Cockapoo",
                "French Bulldog",
                "Border Collie",
                "Shih Tzu",
                "Chihuahua",
                "Dachshund",
                "German Shepherd",
                "Golden Retriever",
                "Yorkshire Terrier",
                "English Springer Spaniel",
                "Pug",
                "Cavalier King Charles Spaniel",
                "Beagle",
                "West Highland White Terrier",
                "Bichon Frise");
        ArrayList<String> breedsArray = new ArrayList<>(breedsList);

        int remainingPercent = 100;
        int breedIndex;
        int breedPercent;

        for (int i = 1; i<=5; i++){
            breedIndex = random.nextInt(breedsArray.size());
            breedPercent = random.nextInt(remainingPercent) + 1;
            if (i == 5){
                System.out.println(remainingPercent + "% " + breedsArray.get(breedIndex));
            } else {
                System.out.println(breedPercent + "% " + breedsArray.get(breedIndex));
            }
            remainingPercent = remainingPercent - breedPercent;
            breedsArray.remove(breedIndex);
        }
    }
}
