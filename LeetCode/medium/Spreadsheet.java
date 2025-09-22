package com.LeetCode.medium;

import java.util.Arrays;

public class Spreadsheet {
    int[][] sheet ;
    public Spreadsheet(int rows) {
        sheet = new int[rows+1][27];
        for (int i = 0;i<rows;i++){
            Arrays.fill(sheet[i],0);
        }
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        this.sheet[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        this.sheet[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] parts = formula.split("\\+");
        int left = eval(parts[0]);
        int right = eval(parts[1]);
        return left+right;
    }
    private int eval(String part){
        if(Character.isDigit(part.charAt(0))){
            return Integer.parseInt(part);
        }else {
            int pos[] = parseCell(part);
            return sheet[pos[0]][pos[1]];
        }
    }
    private int[] parseCell(String cell) {
        String number = cell.replaceAll("[^0-9]", ""); // row part
        int row = Integer.parseInt(number);
        int col = cell.charAt(0) - 'A' + 1;
        return new int[]{row, col};
    }
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3);
        System.out.println(spreadsheet.getValue("=5+7"));
        spreadsheet.setCell("A1",10);
        System.out.println(spreadsheet.sheet[1][1]);
    }

}
