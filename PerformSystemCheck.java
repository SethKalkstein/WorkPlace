package com.practice;

import java.util.concurrent.locks.ReentrantLock;

public class PerformSystemCheck implements Runnable{

    private String checkWhat;

    ReentrantLock myLock = new ReentrantLock();

    public PerformSystemCheck(String checkWhat){
        this.checkWhat = checkWhat;
    }

    @Override
    public void run() {

        myLock.lock();

        System.out.println("checking: "+this.checkWhat);

        myLock.unlock();
    }

    //another way of avoiding two things clashing whilst being called simultaneously
/*    synchronized public void run() {

    }*/
}
