package com.Recursion.Backtracking;

import java.util.Arrays;

public class AllPath {
    public static void main(String[] args) {
        boolean[][] board={
                {true,true,false},
                {true,true,true},
                {true,true,true},
        };
        allpath("",0,board,0);
        System.out.println();
        allpathprint("",0,board,0,new int[board.length][board[0].length],1);
    }
    static void allpath(String p,int r,boolean[][] maze,int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(p + " ");
            return;
        }
        if (!maze[r][c]) return;
        //I am concidering this block in my path
        maze[r][c] = false;
        if (c < maze[0].length - 1) allpath(p + 'R', r, maze, c + 1);
        if (r > 0) allpath(p + 'U', r - 1, maze, c);

        if (r < maze.length - 1) allpath(p + 'D', r + 1, maze, c);
        if (c > 0) allpath(p + 'L', r, maze, c - 1);
//         this line is where the funtion will be over
//        so before the function gets removed also remove the changes that were made by that funtion
        maze[r][c]=true;
    }
    static void allpathprint(String p,int r,boolean[][] maze,int c,int[][] path,int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c]=step;
            for (int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) return;
        //I am concidering this block in my path
        maze[r][c] = false;
        path[r][c]=step;
        if (c < maze[0].length - 1) allpathprint(p + 'R', r, maze, c + 1,path,step+1);
        if (r > 0) allpathprint(p + 'U', r - 1, maze, c,path,step+1);
        if (r < maze.length - 1) allpathprint(p + 'D', r + 1, maze, c,path,step+1);
        if (c > 0) allpathprint(p + 'L', r, maze, c - 1,path,step+1);
//         this line is where the funtion will be over
//        so before the function gets removed also remove the changes that were made by that funtion
        maze[r][c]=true;
        path[r][c]=0;
    }

}
