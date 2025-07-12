package com.Rajpoot.inheritence;

public class Box {
    double length;
    double height;
    double width;
//    initial constructor
    Box(){
        this.length=-1;
        this.height=-1;
        this.width=-1;
    }
//    for cube
    Box(double side){
        this.length=this.height=this.width=side;
    }
    Box(double l,double h,double w){
        this.length=l;
        this.height=h;
        this.width=w;
    }
    Box(Box old){
        this.length=old.length;
        this.height=old.height;
        this.width=old.width;
    }
    public void info(){
        System.out.println("Running the Box ");
    }
    public double Volume(){
        return length*height*width;
    }
}

