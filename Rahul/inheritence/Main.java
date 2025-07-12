package com.Rahul.inheritence;

public class Main {
    public static void main(String[] args) {
         Box b1=new Box(4.6,9.8,7.0);
         Box b2=new Box(5);
         Box b3=new Box(b2);
         BoxWeight b4=new BoxWeight();
         BoxWeight b5=new BoxWeight(4,8,7,9);
         Box b6 = new BoxWeight(1,2,8,10);
         BoxPrice b7=new BoxPrice(5,4,7,2,6);
         BoxShipingCost b8=new BoxShipingCost(7,8,9,4);
        System.out.println(b1.length);
        System.out.println(b2.length+" "+ b2.height+" "+ b2.width);
        System.out.println(b3.length+" "+ b3.height+" "+ b3.width);
        System.out.println("The volume of b1: "+ b1.Volume());
        System.out.println("The volume of b2: "+ b2.Volume());
        System.out.println("The volume of b3: "+ b3.Volume());
        System.out.println(b4.length);
        System.out.println(b4.weight);
        System.out.println("The volume of b5: "+ b6.Volume());
        System.out.println(b6.length);
//        System.out.println();
        System.out.println(b7.length);
        System.out.println(b7.height);
        System.out.println(b7.width);
        System.out.println(b7.weight);
        System.out.println(b7.price);
        System.out.println(b8.shipingcost);


    }
}
