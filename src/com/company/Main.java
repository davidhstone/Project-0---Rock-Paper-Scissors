package com.company;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.security.SecureRandom;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        // write your code here

        String mainChoice = "";
        String playChoice = "";
        String compMove = "";

        //so I call methods in here

        mainMenu("wow");
        playGame("wow", "huh");
        machineMoveGenerator();


        List<String> gameHistory = new ArrayList<>();

    }

    //and I write my methods in here


    public static String mainMenu(String inputString) {


        String mainChoice = "invalid";

        System.out.println("Welcome to Rock Paper Scissors");
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("");
        System.out.println("=======");
        System.out.println("");
        System.out.println("1. Type 'play' to play");
        System.out.println("2. Type 'history' to view your game history");
        System.out.println("Type 'quit' to stop playing");

        //scanner

        do {
            Scanner input = new Scanner(System.in);
            String userString = input.nextLine();
            if (userString.equals("play")) {
                mainChoice = "play";
            } else if (userString.equals("history")) {
                mainChoice = "history";
            } else if (userString.equals("quit")) {
                mainChoice = "quit";
            } else {
                mainChoice = "invalid";
                System.out.println("That's not a valid entry. Please enter 'play,' 'history,' or 'quit'");
            }
        } while (mainChoice.equals("invalid"));
        playGame(mainChoice, machineMoveGenerator());
        //System.out.println(mainChoice);
        return mainChoice;


    }


    //THIS IS MY COMPUTER MOVE GENERATOR... NEED TO MOVE IT INTO PLAY METHOD!
    public static String machineMoveGenerator() {

        String compMove = "";
        Random rand = new SecureRandom();
        int randomNum = rand.nextInt(3);
        switch (randomNum) {
            case 0:
                compMove = "rock";
                break;
            case 1:
                compMove = "paper";
                break;
            case 2:
                compMove = "scissors";
                break;
        }
        // System.out.println("Computer picks: " + compMove);
        return compMove;

    }




    //THIS IS MY PLAY METHOD... NEED TO FILL IT OUT!
    public static String playGame(String mainchoice, String compMove) {

        String playChoice = "";
        String gameResult = "";

        if (mainchoice.equals("play")) {

            boolean validMove = false;

            do {

                System.out.println("Type in 'rock' 'paper' or 'scissors' to play.");
                System.out.println("Type 'quit' to go back to the Main Menu");
                Scanner move = new Scanner(System.in);
                playChoice = move.nextLine();

                if (playChoice.equals("rock")) {
                    playChoice = "rock";
                    validMove = true;
                    System.out.println("User picks: " + playChoice);


                } else if (playChoice.equals("paper")) {
                    playChoice = "paper";
                    validMove = true;
                    System.out.println("User picks: " + playChoice);


                } else if (playChoice.equals("scissors")) {
                    playChoice = "scissors";
                    validMove = true;
                    System.out.println("User picks: " + playChoice);
                } else {
                    playChoice = "invalid";
                    validMove = false;
                    System.out.println("That's not a valid move. Please enter 'rock,' 'paper,' or 'scissors'");
                }

                System.out.println("Computer picks: " + compMove);

            } while (validMove == false);



        }

        if ((playChoice.equals("rock") && compMove.equals("scissors")) ||
                (playChoice.equals("paper") && compMove.equals("rock")) ||
                (playChoice.equals("scissors") && compMove.equals("paper"))) {

            System.out.println("You win!");
            gameResult = "Win";
        }
        else if ((playChoice.equals("paper") && compMove.equals("scissors")) ||
                (playChoice.equals("scissors") && compMove.equals("rock")) ||
                (playChoice.equals("rock") && compMove.equals("paper"))) {

            System.out.println("You lose!");
            gameResult = "Loss";
        }
        else if ((playChoice.equals("paper") && compMove.equals("paper")) ||
                (playChoice.equals("scissors") && compMove.equals("scissors")) ||
                (playChoice.equals("rock") && compMove.equals("rock"))){

            System.out.println("It's a tie!!");
            gameResult = "Tie";
        };



        return gameResult;
    }





}



