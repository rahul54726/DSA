package com.Rahul.inheritence;

public class BoxShipingCost extends Box{
    double shipingcost;

    public BoxShipingCost(double l, double h, double w, double shipingcost) {
        super(l, h, w);
        this.shipingcost = shipingcost;
    }
}
