package com.Recursion.Backtracking;

public class Sudoku {
    public static void main(String[] args) {
    int[][] board={
            {3,0,6,5,0,8,4,0,0},
            {5,2,0,0,0,0,0,0,0},
            {0,8,7,0,0,0,0,3,1},
            {0,0,3,0,1,0,0,8,0},
            {9,0,0,8,6,3,0,0,5},
            {0,5,0,0,9,0,6,0,0},
            {1,3,0,0,0,0,2,5,0},
            {0,0,0,0,0,0,0,7,4},
            {0,0,5,2,0,6,3,0,0}
    };
        if (solve(board)){
            display(board);
        }
        else {
            System.out.println("cannot solve");
        }
    }
    static boolean isSafe(int[][] board,int r,int c,int num){
//        check row
        for (int i=0;i<board.length;i++){
//            check num is there??
            if (board[r][c]==num){
                return false;
            }
        }
        //        check col
        for (int[] nums:board){
//            check num is there??
            if (nums[c]==num){
                return false;
            }
        }
        int sqrt=(int)(Math.sqrt(board.length));
        int rstart=r-r%sqrt;
        int cstart=c-c%sqrt;
        for (int i = rstart; i <rstart+sqrt ; i++) {
            for (int j = cstart; j < cstart+sqrt; j++) {
                if (board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }

                    rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true;
                }
            }
        }
        return true;
    }
    static boolean solve(int[][] board){
//        this is how we are replacing r,c from arguments
        int n=board.length;
        int r=-1;
        int c=-1;
        boolean emptyLeft=true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==0){
                    r=i;
                    c=j;
                    emptyLeft=false;
                    break;
                }
            }
//            if you found empty element in row then break
                if(!emptyLeft){
                    break;
                }
        }
        if (emptyLeft){
            return true;
//            sudoku solved
        }
//        backtrack
        for (int nummber = 1; nummber <=n ; nummber++) {
            if (isSafe(board,r,c,nummber)){
                board[r][c]=nummber;
                if(solve(board)){
                    // found the ans
                    return true;
                } else {
                    //backtrack
                    board[r][c]=0;
                }
            }
        }
        return false;
    }

    private static void display(int[][] board) {
        for(int[] row:board){
            for (int num:row){
                System.out.print(num+" ");

            }
            System.out.println();
        }
    }
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(board[i][j] == word.charAt(0) && find(i,j,word.substring(1),board)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(int i, int j, String str, char[][] board) {
        if(str.isEmpty()){
            return true;
        }
        if(i<0||j<0||i>= board.length ||j>= board[0].length || board[i][j] == '0'){
            return false;
        }
        if(board[i][j] != str.charAt(0)){
            return false;
        }
        char temp = board[i][j];
        board[i][j]='0';
        //backtrack
        boolean found =  find(i+1,j,str.substring(1),board)
                ||find(i-1,j,str.substring(1),board)
                ||find(i,j+1,str.substring(1),board)
                || find(i,j-1,str.substring(1),board);
        board[i][j] = temp;
        return found;
    }


}
