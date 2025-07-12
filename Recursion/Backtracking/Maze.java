package com.Recursion.Backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        path("",3,3);
        System.out.println();
        System.out.println(pathret("",3,3));
        System.out.println(pathretlist("",3,3,new ArrayList<>()));
        System.out.println(pathretlistdia("",3,3,new ArrayList<>()));
        boolean[][] board={
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
        pathwithobs("",0,board,0 );

    }
    static void path(String p, int r, int c){
        if(r==1 && c==1){
            System.out.print(p+" ");
            return;
        }
            if(c>1) path(p+'R',r,c-1);
            if(r>1) path(p+'D',r-1,c);


    }
    static int count( int r, int c){
        if(r==1 || c==1){
            return 1;
        } int ways=0;
             ways+=count(r,c-1);
             ways+=count(r-1,c);

             return ways;

    }
    static ArrayList<String> pathret(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
            if(c>1) ans.addAll(pathret(p+'R',r,c-1));
            if(r>1) ans.addAll(pathret(p+'D',r-1,c));

            return ans;
    }
    static ArrayList<String> pathretlist(String p, int r, int c,ArrayList<String> list){
        if(r==1 && c==1){
            list.add(p);
            return list;
        }
            if(c>1) pathretlist(p+'R',r,c-1,list);
            if(r>1) pathretlist(p+'D',r-1,c,list);

            return list;
    }static ArrayList<String> pathretlistdia(String p, int r, int c,ArrayList<String> list){
        if(r==1 && c==1){
            list.add(p);
            return list;
        }
            if(c>1) pathretlistdia(p+"H",r,c-1,list);
            if(r>1) pathretlistdia(p+"V",r-1,c,list);
            if(c>1&&r>1) pathretlistdia(p+"D",r-1,c-1,list);
            return list;
    }
    static void pathwithobs(String p,int r,boolean[][] maze,int c){
        if(r==maze.length-1&&c==maze[0].length-1){
            System.out.print(p+" ");
            return ;
        }
        if (!maze[r][c]) return ;
        if(c< maze[0].length-1) pathwithobs(p+'R',r,maze,c+1);
        if(r< maze.length-1) pathwithobs(p+'D',r+1,maze,c);
    }


}
