package com.practice;

import java.util.ArrayList;
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

    public void addMultiple(String[] multipleEntries){
        for(String task : multipleEntries){
            toDos.add(task);
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

    public void toDoSillyStrings(){
        try{
            System.out.println("the third character in the first list item is: \"" + toDos.get(0).charAt(2) + "\".");

            int stringComparison = toDos.get(3).compareToIgnoreCase(toDos.get(4));
            System.out.println("Are the fourth item, \""+toDos.get(3)+ "\" and fifth item, \"" +toDos.get(4)+ "\" the same?\n" +
                    (stringComparison == 0 ? "Yes they are!" : "No, their first different character is " +
                            stringComparison + " characters apart in the alphabet") );
            String compPhrase = "urr";
            String startPhrase = "q";
            System.out.println("\nDoes \"" + toDos.get(4) + "\" contain \""+compPhrase+"\"? " + toDos.get(4).contains(compPhrase));
            System.out.println(toDos.get(7) + " starts with: " + startPhrase +"? " + toDos.get(7).startsWith(startPhrase));

            System.out.println(toDos.get(7).indexOf("rk") + " is the index of \"rk\" in \"" + toDos.get(7) +".\"");
            //the above can also be used with a start position, and there's a lastIndexOf() method
            System.out.println(toDos.get(8).length() + " is the length of \""+toDos.get(8)+"\"");
            System.out.println(toDos.get(8).replace("ve", "nk"));
            System.out.println("split method " + Arrays.toString(toDos.get(9).split("")) );
            System.out.println("to char array " + Arrays.toString(toDos.get(9).toCharArray()) );

            String randString = "      sdg fsddfg dfg dfg dfgdfg      ";
            System.out.println(randString + " a random string");
            System.out.println(randString.trim() + " a random string with the trim method.");
            String fakeHtml = "<p> Hello how are you doing</p>" +
                    "<h1>Well, I'm doing good today.</h1>";
            String tagh1 = "<h1>";
            int headingStart = fakeHtml.indexOf(tagh1) + tagh1.length();
            int headingEnd = fakeHtml.indexOf("</h1>");
            System.out.println("\nHere is some fake html: " + fakeHtml);
            System.out.println("Here is a header being parsed with the indexOf, " +
                    " length, and most importantly substring method of the String Class: "+ fakeHtml.substring(headingStart, headingEnd));

            StringBuilder everything = new StringBuilder("All of our tasks in string builder form:");
            for (int i = 0; i < toDos.size(); i++) {
                everything.append(" " + toDos.get(i) + (i == toDos.size() - 1 ? "." : "," ));
            }
            System.out.println(everything);

            System.out.println(everything.delete(30, 40) + " deleted some stuff from that string builder.");
            System.out.println("The capacity of that string builder is: " + everything.capacity());
            everything.ensureCapacity(600); //capacity is now 600 chars
            everything.trimToSize(); //trims it back to the number of chars being used
            everything.insert(68, "Random word in here");
            System.out.println("Here is the builder with a random sting put in the middle with the insert method: " + everything);

            //StringBuilder also has indexOf(), substring(), charAt(), etc...

            String everythingString = everything.toString();

            System.out.println("Now the builder has been converted back into a string. Cool!" + everythingString);

            String fullSentence = "Hello my name is Joe and I work in a button factory.";
            String[] splitSentence = fullSentence.split(" ");
            char[] sentArray = fullSentence.toCharArray();
            ArrayList<Character[]> splitCharSent = new ArrayList<>();
            for(int i = 0; i < splitSentence.length; i++){
                char[] tempCharsPrim = splitSentence[i].toCharArray();
                Character[] tempCharObj = new Character[tempCharsPrim.length];
                for(int j = 0; j < tempCharsPrim.length; j++) {
                    tempCharObj[j] = Character.valueOf(tempCharsPrim[j]);
                }
                splitCharSent.add(tempCharObj);
            }

            System.out.println(Arrays.deepToString(splitCharSent.toArray()));
            System.out.println(Arrays.toString(sampleTasks));

        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Here's our problem" + e);
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
