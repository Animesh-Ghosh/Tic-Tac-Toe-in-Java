package com.company;

public class Game extends Logic {
    private static final char[][] board = {
            {'_','_','_'},
            {'_','_','_'},
            {'_','_','_'},
    };
    private static char current = 'X';

    public void displayBoard() {
        for(char[] row: board) {
            for(char col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public void insert(int position) {
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

    public int winnerType() {
        //winner case
        if(checkColWinner(board, current) || checkRowWinner(board, current) || checkDiagonalWinner(board, current))
            return 1;

        //draw case
        if(isBoardFull()) {
            if(!(checkColWinner(board, current) || checkRowWinner(board, current) || checkDiagonalWinner(board, current)))
            return 2;
        }
        //not full
        return -1;
    }

    public boolean isEmptyPosition(int position) {
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

    public boolean isBoardFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '_')
                    return false;
            }
        }
        return true;
    }

    public void switchPlayer() {
        if(current == 'X') {
            current = 'O';
        }else {
            current = 'X';
        }
    }

    public boolean isValidInput(int pos) {
        return 1 <= pos && pos < 10;
    }

    public char getCurrentPlayer() {
        return current;
    }
}
