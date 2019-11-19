package com.practice;

public interface Drivable {
    //can only have method definitions
    //all methods need to be implemented in class that implements it
    //one exception being constants

    String WHEELSHAPE = "round";

    //int getWheel() is the same thing
    //public abstract is implied
    public abstract int getWheel();

    void setWheels(int numOfWheels);

    double getSpeed();

    void setSpeed(double speed);

}
