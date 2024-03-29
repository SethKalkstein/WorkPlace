package com.practice;

import java.util.*;
import java.text.DateFormat;

public class CheckSystemTime implements Runnable {

    @Override
    public void run() {

        Date rightNow;
        Locale currentLocale;
        DateFormat timeFormatter;
        String timeOutput;

        rightNow = new Date();
        currentLocale = new Locale("en");

        timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
        timeOutput = timeFormatter.format(rightNow);

        System.out.println("Time: "+timeOutput);
    }
}
