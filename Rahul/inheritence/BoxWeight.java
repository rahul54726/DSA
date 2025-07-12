package com.Rahul.inheritence;

class BoxWeight extends Box{
    double weight;

    public BoxWeight() {
        this.weight = -1;
    }
    public BoxWeight(double l, double h, double w,double m) {
        super(l, h, w);
        this.weight=m;
    }
}
