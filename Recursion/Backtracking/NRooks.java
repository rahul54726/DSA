package com.Recursion.Backtracking;

public class NRooks {
    static int nRooks(boolean[][] board, int r){
        if (r==board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
//        placing the queen and checking for every row and column
        for (int c=0; c<board.length;c++){
//            place the queen if it is safe
            if(isSafe(board,r,c)){
                board[r][c]=true;
                count+= nRooks(board,r+1);
                board[r][c]=false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {
//        check vertical row
        for (int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row:board){
            for (boolean element:row){
                if (element){
                    System.out.print("R");
                }
                else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(nRooks(new boolean[4][4],0));
    }
}
