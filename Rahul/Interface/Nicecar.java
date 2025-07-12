package com.Rahul.Interface;

public class Nicecar {
    private Engine engine;
    private Media music=new CDPlayer();
    public Nicecar(){
        engine=new PowerEngine();
    }

    public Nicecar(Engine engine) {
        this.engine = engine;
    }
    public void start(){
        engine.start();
    }
    public void stop(){
        engine.stop();
    } public void acc(){
        engine.acc();
    }
    public void startMusic(){
        music.start();
    }
    public void stopMusic(){
        music.stop();
    }
    public void upgradeengine(){
        this.engine=new ElectricEngine();
    }

}
