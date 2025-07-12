package com.Rahul.inheritence;

public class BoxPrice extends BoxWeight{
    double price;

    public BoxPrice(double l, double h, double w, double m, double p) {
        super(l, h, w, m);
        this.price = p;
    }
}
