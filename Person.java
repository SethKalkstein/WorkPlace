package com.practice;

public class Person {

    public final String IDENTIFY = "I am a person";

    private int birthMonth = 1;
    private int birthDay = 1;
    private int birthYear = 1970;
    private int heartRate = 60;

    private double weightPounds = 150.0;

    private String firstName = "None";
    private String lastName = "None";

    private boolean breathing = true;

    public boolean smiling = true;

    public Person(String newFirstName, String newLastName, int newBirthDay, int newBirthMonth,
                  int newBirthYear, double weightPounds){
        this(newFirstName, newLastName); //calls the 2 two string constructor
        birthDay = newBirthDay;
        birthMonth = newBirthMonth;
        birthYear = newBirthYear;
        this.weightPounds = weightPounds; //this.weightPounds = class variable, weightPounds = method variable.
    }
    //same as what the default would be if no constructor declared
    public Person(){

    }
    public Person(String newFirstName, String newLastName){
        firstName = newFirstName;
        lastName = newLastName;
    }
    public int getBirthMonth(){
        return birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getWeightPounds() {
        return weightPounds;
    }

    public String getFullName(){
        return lastName + ", " + firstName;
    }

    public void setHeartRate(int rate){
        heartRate = rate;
        if(heartRate < 0) {
            breathing = false;
        }
    }

    public void  setHeartRate(double rate){
        int intRate = (int) rate;
        setHeartRate(intRate);
    }

}
