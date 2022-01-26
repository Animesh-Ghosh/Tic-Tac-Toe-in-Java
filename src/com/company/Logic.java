package com.company;

public class Logic {
    public boolean checkColWinner(char[][] board, char current) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == current && board[i][1] == current && board[i][2] == current) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRowWinner(char[][] board, char current) {
        for(int i = 0; i < 3; i++) {
            if(board[0][i] == current && board[1][i] == current && board[2][i] == current) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonalWinner(char[][] board, char current) {
        return ((board[0][0] == current && board[1][1] == current && board[2][2] == current) || (board[0][2] == current && board[1][1] == current && board[2][0] == current));
    }
}
