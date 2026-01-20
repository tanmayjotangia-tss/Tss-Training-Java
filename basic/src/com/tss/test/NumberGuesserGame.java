package com.tss.test;

import java.util.Scanner;

public class NumberGuesserGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean replay;
        do {
            int randomizer = (int) (Math.random() * 100);

            System.out.println("Guessed number " + randomizer);
            for (int i = 1; i <=5 ; i++) {

                System.out.println("Enter your " + i + " guess (limit between 1-100):");
                int guessed = scanner.nextInt();

                if (guessed < 1 || guessed > 100) {
                    System.out.println("Guess value within limit");
                } else if (randomizer > guessed) {
                    System.out.println("Too LOW");
                } else if (randomizer < guessed) {
                    System.out.println("Too High");
                }
                else {
                    System.out.println("You Won in " + i + " attempt");
                    break;
                }
            }

            System.out.println("Do you want to play again? (true/false)");
            replay = scanner.nextBoolean();
        } while (replay);
    }
}
