package com.company;
import java.util.*;
public class Main {
    static char[][] board = {
            {'_','_','_'},
            {'_','_','_'},
            {'_','_','_'},
    };

    static char current = 'X';

    public static boolean checkColWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == current && board[i][1] == current && board[i][2] == current) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRowWinner() {
        for(int i = 0; i < 3; i++) {
            if(board[0][i] == current && board[1][i] == current && board[2][i] == current) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonalWinner() {
        return ((board[0][0] == current && board[1][1] == current && board[2][2] == current) || (board[0][2] == current && board[1][1] == current && board[2][0] == current));
    }

    public static int WinnerRez() {
        //winner case
        if(checkColWinner() || checkRowWinner() || checkDiagonalWinner()) {
            return 1;
        }
            //draw case
        if(isBoardFull()) {
            if(!(checkColWinner() || checkRowWinner() || checkDiagonalWinner())) {
                return 2;
            }
        }
        //not full
        return -1;
    }

    public static void display_board() {
        for(char[] row: board) {
            for(char col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void insertion(int position) {
        int row = 0, col = 0;
        if (position <= 3) {
            col = position - 1;
        } else if (position <= 6) {
            row = 1;
            col = position - 3 - 1;
        } else if (position <= 9) {
            row = 2;
            col = position - 6 - 1;
        }
        board[row][col] = current;


    }

    public static boolean isEmptyPosition(int position) {
        int row = 0, col = 0 ;
        if(position <= 3) {
            col = position - 1;
        }else if(position <= 6) {
            row = 1;
            col = position - 3 - 1;
        }else if(position <= 9) {
            row = 2;
            col = position - 6 - 1;
        }
        return board[row][col] == '_';
    }

    public static boolean isBoardFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '_')
                    return false;
            }
        }
        return true;
    }

    public static void switch_player() {
        if(current == 'X') {
            current = 'O';
        }else {
            current = 'X';
        }
    }

    public static boolean isValidInput(int pos) {
        return pos < 10;
    }

    public static void main(String[] args) {

        display_board();

        Scanner sc = new Scanner(System.in);
        int pos = 1;

        while(true) {
            System.out.print("Player " + current + " (1-9) [To end, press '0'] : ");
            pos = sc.nextInt();

            if(pos == 0) break;

            if(isValidInput(pos)) {
                if (isEmptyPosition(pos)) {
                    insertion(pos);

                    int result = WinnerRez();
                    if(result == 1) {
                        //winner
                        display_board();
                        System.out.println("Winner is : " + current);
                        break;
                    }else if(result == 2) {
                        //draw
                        display_board();
                        System.out.println("It's a draw!");
                        break;
                    }
                    switch_player();
                    display_board();
                } else {
                    System.out.print("There is already something, Player" + current + " select something else (1-9) : ");
                    pos = sc.nextInt();
                }
            }
        }
        System.out.println("Game ended! GG");
    }
}
