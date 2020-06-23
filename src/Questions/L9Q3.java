package Questions;

/**
 * @author Richie
 */

import Structures.ArrayHashTable;

import java.util.Scanner;

public class L9Q3 {
    public static void main(String[] args) {
        ArrayHashTable<String, String> a1 = new ArrayHashTable<>();             //Creates an array Hash Table a1
        Scanner sc = new Scanner(System.in);                                    //Calls the scanner class
        a1.put("100-101", "ICND 1");                          //Puts a value with its key into the Hash Table
        a1.put("200-101", "ICND 2");                          //Puts a value with its key into the Hash Table
        a1.put("200-120", "CCNA Routing and Switching");      //Puts a value with its key into the Hash Table
        a1.put("210-260", "CCNA Security");                   //Puts a value with its key into the Hash Table
        System.out.println("The number of course is " + a1.getSize());          //Prints a statement and the size of the current array Hash Table a1
        a1.showHashTable();                                                     //Shows the Hash Table

        System.out.println("\nAdding a new course");
        a1.put("300-101", "ROUTE");                           //Puts a value with its key into the Hash Table
        System.out.println("The number of course is " + a1.getSize());          //Prints a statement and the size of the current array Hash Table a1
        a1.showHashTable();                                                     //Shows the Hash Table

        System.out.println("\nModifying 210-260");
        a1.put("210-260", "CCNA RS Security");                  //Puts a value with its key into the Hash Table
        System.out.println("The number of course is " + a1.getSize());            //Prints a statement and the size of the current array Hash Table a1
        a1.showHashTable();                                                       //Shows the Hash Table


        System.out.print("\nRemove the course ");
        String str = sc.nextLine();                                         //Initializes a String str that takes user input
        a1.remove(str);                                                     //Removes the value if str matches the key of the value
        System.out.println("The number of course is " + a1.getSize());      //Prints a statement and the size of the current array Hash Table a1
        a1.showHashTable();                                                 //Shows the Hash Table


        System.out.print("\nEnter a course code to search : ");
        String key = sc.next();                                            //Initializes a String key that takes user input
        if (a1.containsKey(key)) {                                         //A condition, if the containsKey method from Array Hash Table returns true
            System.out.println("Course " + key + " : " + a1.get(key));     //A statement will be printed plus the value that matches with the input key will be returned
        } else {
            System.out.println(key + " is not found");                     //A condition, if containsKey method returns false, this statement will be printed
        }
    }

}