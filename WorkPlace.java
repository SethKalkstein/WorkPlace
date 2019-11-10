package com.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkPlace {

    static Scanner employeeInput = new Scanner(System.in);

    public static void main(String[] args) {
        Person person1 = new Person("Frank", "Thetank");

        System.out.println(person1.getFullName());

        double payRate = dollarsPerHour();
        System.out.printf("Your Pay rate is: $%.2f/hr", payRate);
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

}
