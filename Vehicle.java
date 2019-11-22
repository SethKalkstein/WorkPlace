package com.practice;

public class Vehicle extends Crashable implements Drivable {

    private int numOfWheels = 2;
    private double theSpeed = 60.5;
    private int carStrength = 0;

    public void setCarStrength(int carStrength){
        this.carStrength = carStrength;
    }

    public int getCarStrength(){
        return this.carStrength;
    }

    public int getWheel(){
        return this.numOfWheels;
    }

    public void setWheels(int numOfWheels){
        this.numOfWheels = numOfWheels;
    }

    public double getSpeed(){
        return this.theSpeed;
    }

    public void setSpeed(double speed){
        this.theSpeed = speed;
    }

    public Vehicle(){}

    public Vehicle(int numOfWheels, double theSpeed){
        this.numOfWheels = numOfWheels;
        this.theSpeed = theSpeed;
    }

}
