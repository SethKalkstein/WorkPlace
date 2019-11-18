package com.practice;

public class Cats extends Pets {
    public String favToy = "Mousey Mouse";

    public void playWith(){
        System.out.println("Yeah " + this.favToy);
    }

    public void walkAround(){
        System.out.println(this.getName() + "pounces around");
    }

    public String getFavToy(){
        return this.favToy;
    }

    public Cats(){
    }

    public Cats(String name, String favToy, String favFood){
        super(name, favFood);
        this.favToy = favToy;
    }
}
