package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Game game = new Game();

        //display the board
        game.displayBoard();

        while(true) {
            //get the current player
            char current = game.getCurrentPlayer();

            System.out.print("Player " + current + " (1-9) [To end, press '0'] : ");
            int pos = sc.nextInt();

            if(pos == 0) break;

            //check if the pos < 10
            if(game.isValidInput(pos)) {
                //check if the given position is free
                if(game.isEmptyPosition(pos)) {
                    //insert the current player symbol in position [row, column]
                    game.insert(pos);

                    //check if there is any winner [win, draw] or not
                    int result = game.winnerType();

                    if(result == 1) {
                        //winner
                        game.displayBoard();
                        System.out.println("Winner is : " + current);
                        break;
                    }else if(result == 2) {
                        //draw
                        game.displayBoard();
                        System.out.println("It's a draw!");
                        break;
                    }

                    //switch player from 'X' to 'O' or vice-verse
                    game.switchPlayer();
                    //display the board
                    game.displayBoard();
                } else {
                    System.out.println("There is already something, Player" + current + " select something else (1-9).");
                }
            }else {
                System.out.println("Please put a valid input [1-9] (Press '0' to end).");
            }
        }
        //end message
        System.out.println("Game ended! GG");
    }
}
