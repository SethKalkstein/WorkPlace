package com.practice;

public class Vehicle implements Drivable {

    private int numOfWheels = 2;
    private double theSpeed = 60.5;


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
