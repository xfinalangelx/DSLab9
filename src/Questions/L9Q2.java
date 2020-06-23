package Questions;

/**
 * @author Richie
 */

import Structures.LinkedList;

import java.util.Random;
import java.util.Scanner;

public class L9Q2 {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList();                                                           //Creates an Integer type LinkedList l1
        Random rng = new Random();                                                                           //Calls the Random Class
        Scanner sc = new Scanner(System.in);                                                                 //Calls the Scanner Class
        for (int i = 0; i < 10; i++) {                                                                       //A for loop that starts from 0 to 9, hence loop 10 times
            l1.addNode(rng.nextInt(21));                                                              //List l1 adds random numbers generated from 0-20
        }
        l1.showList();                                                                                       //Shows the list
        System.out.println("\nLinear Search");
        System.out.print("Enter a number to search: ");
        int input = sc.nextInt();                                                                            //Prompts the user to input an integer and instantiates integer variable input
        if (l1.exist(input)) {                                                                               //A condition based on the exist() boolean method in LinkedList, in this case if fired true
            System.out.println(input + " is found");                                                         //The input will be printed together with the statement
            System.out.println("The number of " + input + " in the data set is " + l1.occurrence(input));    //Prints the input together with it's number of occurrences from the list
        } else {
            System.out.println(input + " is not found");                                                     //A condition, if exist() returns false, this statement will be printed
        }

        System.out.print("Enter two numbers to search(begin end) : ");
        int min = sc.nextInt();                                                                                                                     //Instantiating the integer variable min by prompting user input
        int max = sc.nextInt();                                                                                                                     //Instantiating the integer variable max by prompting user input
        if (l1.exist(min, max)) {                                                                                                                   //A condition based on the exist() with range boolean method in the LinkedList, in this case if fired true
            System.out.println("The integer can be found in between " + min + " and " + max);                                                       //The statement together with the min and max will be printed out
            System.out.println("The number of the elements in between " + min + " and " + max + " in the data set is " + l1.occurrence(min, max));  //The statement together with the min, max and number of occurrences of output within the range from min to max will be printed out
        } else {
            System.out.println("No integer can be found in between " + min + " and " + max);                                                        //A condition, if exist() returns false, this statement will be printed
        }
    }

}
