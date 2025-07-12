package com.Recursion.Backtracking;

public class N_Queens {
    public static void main(String[] args) {
        System.out.println( nqueens(new boolean[4][4],0));
    }
    static int nqueens(boolean[][] board,int r){
        if (r==board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
//        placing the queen and checking for every row and coloumn
        for (int c=0; c<board.length;c++){
//            place the queen if it is safe
            if(isSafe(board,r,c)){
                board[r][c]=true;
                count+=nqueens(board,r+1);
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
//        diagonal left
        int maxLeft=Math.min(r,c);
        for (int i=1;i<=maxLeft;i++){
            if (board[r-i][c-i]){
                return false;
            }
        }
//        diagonal right
        int maxRight=Math.min(r,board.length-1-c);
        for (int i=1;i<=maxRight;i++){
            if (board[r-i][c+i]){
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row:board){
            for (boolean element:row){
                if (element){
                    System.out.print("Q");
                }
                else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
