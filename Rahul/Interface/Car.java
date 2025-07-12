package com.Rahul.Interface;

public class Car implements Engine, Brake ,Media{
    @Override
    public void brake() {
//        System.out.println("I break like a normal Car");
    }

    @Override
    public void start() {
        System.out.println("I start engine like a normal Car");
    }

    @Override
    public void stop() {
        System.out.println("I stop engine like a normal Car");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate engine like a normal Car");
    }
}
