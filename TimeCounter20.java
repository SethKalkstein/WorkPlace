package com.practice;

import java.util.*;
import java.text.DateFormat;

public class TimeCounter20 extends Thread {

    public void run(){
        Date rightNow;
        Locale currentLocale;
        DateFormat  dateFormatter;
        DateFormat timeFormatter;
        String timeOutput;
        String dateOutput;

        for(int i = 0; i < 20; i++){
            rightNow = new Date();
            currentLocale = new Locale("en");
            timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
            dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);

            timeOutput = timeFormatter.format(rightNow);
            dateOutput = dateFormatter.format(rightNow);

            System.out.println(timeOutput+"\n"+dateOutput+"\n");

            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e){

            }

        }
    }
}
