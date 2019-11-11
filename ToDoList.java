package com.practice;

import java.util.ArrayList;
import java.util.Iterator; // The Iterator Library
import java.util.Arrays;

public class ToDoList {

    private ArrayList<String> toDos;
    private static String[] sampleTasks = {"Read" , "Learn something", "Meditate", "Clean", "Write", "garden", "make bed", "write email", "run", "gym", "make dinner",
    "practice Java", "stretch", "walk", "walk dog", "eat lunch", "eat breakfast", "fix bike","clean litterbox","clean dishes","oil change",
            "make tea","grocery shopping","vote","Yoga","watch Star Trek", "Feed Cats", "Feed Dog"};

    ToDoList(){
        toDos = new ArrayList<String>();
    }

//this could be any object
/*    ToDoList(){
        toDos = new ArrayList();
    }
//constructor overload for declaring it as a String
    ToDoList(String firstTask){
        toDos = new ArrayList<String>();
        addTask(firstTask);
    }*/
//for an undeclared type
/*    public ArrayList addTask(Object task){
        toDos.add(task);
        return toDos;
    }*/

    public void addTask(String task){
            toDos.add(task);
    }

    public void generateRandomTasks(int numberOfTasks){
        int randomTaskIndex;
        ArrayList<Integer> usedTasks = new ArrayList<>();

        try {
            if (numberOfTasks <= 0 || numberOfTasks > sampleTasks.length) {
                String errorMessage = numberOfTasks <= 0 ? "Must Add at least one random task" :
                        "Must be less than or equal to the total number of random tasks: " + sampleTasks.length;
                throw new ArithmeticException(errorMessage);
            }
            for (int i = 0; i < numberOfTasks; i++ ){

                do {
                    randomTaskIndex = (int) (Math.random() * sampleTasks.length);
                } while (usedTasks.contains(randomTaskIndex));

                usedTasks.add(randomTaskIndex);
                toDos.add(sampleTasks[randomTaskIndex]);
            }
        } catch (ArithmeticException e){
            System.out.println(e);
        }
    }

    public String getListIndex(int index){
        try {
            return toDos.get(index);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
            return "Invalid Input";
        }
    }

    public String removeIndex(int index){
        try {
            return toDos.remove(index);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
            return "Invalid Input";
        }
    }

      public void printToDoList() {
          for (String task : toDos) {
              System.out.println(task);
          }
      }
//for an ArrayList of list of mixed types
/*    public void printToDoList(){
        for(Object task : toDos){
            System.out.println(task);
        }*/
}
