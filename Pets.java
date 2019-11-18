package com.practice;

public class Pets {

    private String name = "Pet";
    public  String favFood = "food";

    protected final void changeName(String newName){
        this.name = newName;
    }

    protected final String getName(){
        return this.name;
    }

    public void eatStuff(){
        System.out.println("Yum " + this.favFood);
    }

    public void walkAround(){
        System.out.println(this.name + " walks around.");
    }
    public Pets (){

    }

    public Pets (String name, String favFood){
        this.changeName(name);
        this.favFood = favFood;
    }
}
