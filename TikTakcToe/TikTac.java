package com.TikTakcToe;

import java.util.Scanner;

public class TikTac {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col]=' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner sc= new Scanner(System.in);
        while (!gameOver){
            printBoard(board);
            System.out.println("Player " + player + " Enter: ");
            int row=sc.nextInt();
            int col=sc.nextInt();
            if (board[row][col] ==' '){
//                place the Element
                board[row][col]=player;
                gameOver=haveWon(board,player);
                if (gameOver){
                    System.out.println("Player " + player + " has Won");
                }
                else {
//                    if (player=='X'){
//                        player='O';
//                    }
//                    else {
//                        player='X';
//                    }
                    player=(player=='X') ? 'O' : 'X';
                }
            }else {
                System.out.println("Invalid Move. Try Again!");
            }

        }
        printBoard(board);
    }

    private static boolean haveWon(char[][] board, char player) {
        //check rows

        for (int row = 0; row < 3; row++) {
            if (board[row][0]== player &&board[row][1]== player&&board[row][2]== player ){
                return true;
            }
        }
        // check col
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col]== player &&board[1][col]== player&&board[2][col]== player ){
                return true;
            }
        }
        // check diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player ){
            return true;
        }
        if ( board[1][1] == player&& board[0][2] == player &&board[2][0] == player){
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }
}
