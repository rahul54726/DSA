package com.Rajpoot.Generics;
import java.util.ArrayList;
public class LambdaFunction {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(i+1);
        }
        list.forEach((item)  -> System.out.print(item*2 +" "));
        System.out.println();
        Operation sum=(a,b) -> (a+b);
        Operation product=(a,b) -> (a*b);
        Operation divide=(a,b) -> (a/b);
        Operation sub=(a,b) -> (a-b);
        LambdaFunction calc=new LambdaFunction();
        System.out.println(calc.operate(5,3,product));
        System.out.println(calc.operate(10,5,divide));
        System.out.println(calc.operate(1,5,sum));
        System.out.println(calc.operate(1,5,sub));
    }

    private int operate(int a,int b,Operation op){
        return op.operation(a,b);
    }
    interface Operation{
        int operation(int a, int b);
    }
}
