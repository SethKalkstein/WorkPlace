package com.practice;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkPlace {

    static Scanner employeeInput = new Scanner(System.in);

    public static void main(String[] args) {
        double[][] sales = generateMonthlySales();
//        double payRate = dollarsPerHour();
        Person person1 = new Person("Frank", "Thetank");

        displayMonthlySales(sales);
        double salesPerDay = monthlySalesStats(sales);
        System.out.printf("Average Sales per day for the month are: $%.2f", salesPerDay);

//        System.out.println(person1.getFullName());

//        System.out.printf("Your Pay rate is: $%.2f/hr", payRate);
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
