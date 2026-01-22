package com.tss.day2.test;

import java.util.Random;
import java.util.Scanner;

public class PIGDiceGame {

    static Scanner scanner = new Scanner(System.in);

    final static int max_score = 20;
    final static int max_turn = 5;

    static int score = 0;
    static int turn = 0;
    static int turnScore=0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Dice Game !!");
        diceGame();
    }

    private static void diceGame() {

        while (score < max_score && turn < max_turn) {
            turn++;
            boolean turnOver = false;

            System.out.println("\nTurn " + turn);
            System.out.println("Current Total Score: " + turnScore);

            while (!turnOver) {
                System.out.println("\n1. Roll\n2. Hold\n\nEnter your choice:");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        int diceValue = rollDice();

                        if (diceValue == 1) {
                            System.out.println("Rolled 1! Turn over.");
                            turnScore = 0;
                            turnOver = true;
                        } else {
                            turnScore += diceValue;
                            score+=diceValue;
                            System.out.println("Turn Score: " + turnScore);
                            if(turnScore>=20){
                                displayResult();
                                turn=6;
                                turnOver=true;
                            }
                        }
                        break;

                    case 2:
                        turnOver = true;
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    }

    private static int rollDice() {
        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        System.out.println("Dice rolled: " + dice);
        return dice;
    }

    private static void displayResult() {
        if (turnScore >= max_score) {
            System.out.println("\nFinal Score: " + turnScore + "\nWON the game in " + turn + " turns");
        } else {
            System.out.println("\nFinal Score: " + turnScore + "\nLOST the game");
        }
    }
}
