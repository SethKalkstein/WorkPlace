package com.practice;

import java.text.RuleBasedCollator;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit.*;

public class WorkPlace {

    static Scanner employeeInput = new Scanner(System.in);

    public static void main(String[] args) {

        /*Pets genericPet = new Pets();
        System.out.println(genericPet.getName());
        System.out.println(genericPet.favFood);
        genericPet.walkAround();

        Cats slayer = new Cats("Slayer The Cat", "crumpled receipt", "tuna");

        slayer.playWithToy();

        slayer.eatStuff();

        System.out.println(slayer.getName());

        slayer.walkAround();*/

        //All Cats are Pets (be Animals in real life) but not all Pets are Cats, so Cats blah = new Pet()
        //wouldn't work

/*        Pets tuxedoCat = new Cats("Nougat", "Ostrich Mouse", "greenies");

        System.out.println(tuxedoCat.getName());
        System.out.println(tuxedoCat.favFood);

        acceptPet(tuxedoCat);

        Vehicle car = new Vehicle(4, 140.5);

        System.out.println("the vehicle's max speed is " + car.getSpeed());

        System.out.println("the vehicle's number of wheels is " + car.getWheel());

        Vehicle genericV = new Vehicle();
        System.out.println("the vehicle's max speed is " + genericV.getSpeed());

        System.out.println("the vehicle's number of wheels is " + genericV.getWheel());

        System.out.println("the shape of the wheels are " + genericV.WHEELSHAPE);

        car.setCarStrength(100);

        System.out.println("Car strength is " + car.getCarStrength() );

        //have to cast Vehicle because clone returns the object class
        Vehicle car2 = (Vehicle) car.clone();*/



        /*ToDoList myList = new ToDoList();

        myList.addTask("Meow");
        myList.addTask("Moo");
        myList.addTask("Bark");
        myList.addTask("Hiss");
        myList.addTask("Purr");

        String[] multipleTasks = {"Draw", "Whistle", "Work", "Drive", "Fly"};
        myList.addMultiple(multipleTasks);

        myList.generateRandomTasks(15);

        System.out.println("Index List Number 4: " + myList.getListIndex(4));

        System.out.println(("Removed Index 3: " + myList.removeIndex(15)));

        myList.printToDoList();

        myList.toDoSillyStrings();
*/


//        double[][] sales = generateMonthlySales();
//        double payRate = dollarsPerHour();
//        Person person1 = new Person("Frank", "Thetank");

/*        displayMonthlySales(sales);
        double salesPerDay = monthlySalesStats(sales);
        System.out.printf("Average Sales per day for the month are: $%.2f", salesPerDay);*/

//        System.out.println(person1.getFullName());

//        System.out.printf("Your Pay rate is: $%.2f/hr", payRate);

/*        Thread getTime = new TimeCounter20();
        getTime.start();
        Runnable myMail = new GetMail(10);
        Runnable myMail2 = new GetMail(15);

        new Thread(myMail).start();
        new Thread(myMail2).start();
*/

        addThreadToPool();

    }

    public static void addThreadToPool(){
        ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(10);

        eventPool.scheduleAtFixedRate(new CheckSystemTime(), 0, 2, TimeUnit.SECONDS);
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Mail"), 5, 5, TimeUnit.SECONDS);
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Calander"), 10, 10, TimeUnit.SECONDS);

        System.out.println("NUmber of Threads: " + Thread.activeCount());

        Thread[] listOfThreads = new Thread[Thread.activeCount()];

        Thread.enumerate(listOfThreads);

        for(Thread eachThread : listOfThreads){
            System.out.println(eachThread.toString() );
        }

        for(Thread eachThread : listOfThreads){
            System.out.println(eachThread.getPriority() );
        }

//        listOfThreads[2].setPriority(1); this would set it to lowest priority lower number is lower priority

        try{ //stops the thread
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
        }

        eventPool.shutdown();
    }

    public static void acceptPet(Pets randomPets){
        System.out.println(randomPets.getName());
        //access to method that is overRidden due to Polymorphism Cats as Animals type
        randomPets.walkAround();
        //Cats unique methods cannot be called randomPets.playWithToy(); will not work
        //but casting it to the Cats subclass will provide access to those methods
        Cats tempCat = (Cats) randomPets;
        tempCat.playWithToy();
        //or cast directly on the object as follows
        System.out.println(((Cats)randomPets).getFavToy());
        //(Cats)randomPets is the snippet of direct casting (but wrap the whole thing in
        //parenthesis to insure that the method dot is applied to the whole cast object instead
        //of just the parent before the interpreter calls the method
        if(randomPets instanceof Pets ){
            System.out.println(randomPets.getName() + " is an instance of the Pets Class");
        }
        if(randomPets instanceof Cats ){
            System.out.println(randomPets.getName() + " is an instance of the Cats Class");
        }
        if(tempCat instanceof Pets ){
            System.out.println(tempCat.getName() + " is an instance of the Pets Class");
        }
        if(tempCat instanceof Cats ){
            System.out.println(tempCat.getName() + " is an instance of the Cats Class");
        }
    }

    public static double dollarsPerHour(){
        double weeklyPay = 0;
        double hoursWorked = 0;
        double hourlyWage = 0;


        System.out.print("Please enter your total pay for the week: $");
        weeklyPay = getDoubleInput();


        System.out.print("Please enter the total hours you worked this week: ");
        hoursWorked = getDoubleInput();

        try {
            if((hoursWorked <= 0  || weeklyPay <= 0) && !(hoursWorked == 0 && weeklyPay == 0) ) {
                String errorMessage = "";
                errorMessage += hoursWorked < 0 ? "Hours Worked must be positive. " : hoursWorked == 0 ? "You can't get paid if you don't work. " : "";
                errorMessage += weeklyPay < 0 ? "Weekly Pay must be positive. " : weeklyPay == 0 ?  "If you work, You have to get paid. " : "";
                throw new ArithmeticException(errorMessage);
            }

            hourlyWage = weeklyPay / hoursWorked;

            if(Double.isInfinite(hourlyWage) ){
                throw new ArithmeticException("Number out of range");
            }
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
            hourlyWage = 0;
        }
        finally {
            if(Double.isNaN(hourlyWage)){
                hourlyWage = 0;
            }
        }


        return hourlyWage;
    }

    private static double getDoubleInput() {
        try {
            return employeeInput.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("That isn't a valid number");
            employeeInput.next();
            return 0;
        }
    }

    public static double monthlySalesStats(double[][] monthlySales){
        //would usually hardcode 7 days for efficiency in runtime but this is Practice!
        int daysInWeek = monthlySales[0].length;
        int weeksInMonth = monthlySales.length;
        int daysInMonth = daysInWeek*weeksInMonth;

        double[] weeklySum = new double[weeksInMonth];
        double[] sumPerDayOfWeek = new double[daysInWeek];
        double monthlySum = 0;

        for (int i = 0; i < weeksInMonth; i++){
            for (int j = 0; j < daysInWeek; j++){
                sumPerDayOfWeek[j] += monthlySales[i][j];
                weeklySum[i] += monthlySales[i][j];
                monthlySum += monthlySales[i][j];
            }
        }

        for (int i = 0; i < sumPerDayOfWeek.length; i++) {
            System.out.println("average for day " + (i+1) +" is $" + (Math.floor( (sumPerDayOfWeek[i]/4) * 100 ) / 100) );
        }
        for(int i = 0; i < weeklySum.length; i++ ){
            System.out.printf("Total sales for week " + (i + 1) + " is: $%.2f\n", weeklySum[i] );
        }

        System.out.printf("Total sales for the month: $%.2f\n",  monthlySum);
        System.out.printf("Average sales per week: $%.2f\n", (monthlySum/4));

        return monthlySum / (daysInMonth);
    }


    public static void displayMonthlySales(double[][] monthlySales){
        int daysInWeek = monthlySales[0].length; //scalable, in case we decide that 7 days is no longer adequate! (just kidding)

        //print labels
        for(int i = 1; i <= daysInWeek; i++){
            if(i == 1){
                System.out.print("| ");
            }
            System.out.print("Day "+(i)+"    | ");
        }
        System.out.println("\n");
        //print sales for each day
        for (double week[] : monthlySales){
            System.out.print("| ");
            for(double day : week){
                System.out.printf("$%4.2f", day);
                int addSpaces = Integer.toString((int) day).length();
                //resolve formatting for sales under $1,000
                for(int k = addSpaces; k < 4; k++){
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.println("\n");
        }
    }

    public static double[][] generateMonthlySales(){
        double[][] theSales = new double[4][7];

        for (int i = 0; i < theSales.length; i++) {
            for (int j = 0; j < theSales[i].length; j++) {
                theSales[i][j] = Math.random() * 10000;
            }
        }
        return theSales;
    }


}
