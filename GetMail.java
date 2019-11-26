package com.practice;

public class GetMail implements Runnable {

    private int startTime;

    public GetMail(int startTime){
        this.startTime = startTime;
    }

    public void run(){
        try{
            Thread.sleep(this.startTime*1000);
        } catch (InterruptedException e)
        {}

        System.out.println("Checking your mail\n");

    }
}
