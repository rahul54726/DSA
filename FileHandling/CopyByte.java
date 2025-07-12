package com.FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyByte {
    public static void main(String[] args) throws IOException {
        FileInputStream in=null;
        FileOutputStream out=null;
        try {
            in=new FileInputStream("xanadu.txt");
            out=new FileOutputStream("outagain.txt");
            int c;
            while ((c=in.read()) !=-1){
                out.write(c);
            }
        }finally {
            if (in != null){
                in.close();
            }
            if (out!=null){
                out.close();
            }
        }
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        char ch=input.next().trim().charAt(0);
        System.out.println(ch);
        System.out.println(a);
    }

}
