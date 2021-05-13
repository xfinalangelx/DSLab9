package Questions;

/**
 * @author Richie
 */

import Misc.SortTest;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class L9Q1 {
    public static void main(String[] args) {
        Random rng = new Random();              //Calls the Random class
        Scanner sc = new Scanner(System.in);//Calls the Scanner class
        System.out.println("HEHEHEHHEHEHEHE");
        System.out.println("HAHAHAHAHAHAHAHHA");
        System.out.println("HIHIHIIHIHIH");
        System.out.print("Enter N : ");
        int n = sc.nextInt();                   //Prompts user input for N
        Integer[][] matrix = new Integer[n][n]; //Generates an Integer type 2D-array with dimensions NxN
        for (int i = 0; i < n; i++) {           //A first for loop to travel through the first dimension of the 2D-array matrix
            for (int j = 0; j < n; j++) {       //A second for loop to travel through the second dimension of the 2D-array matrix
                matrix[i][j] = rng.nextInt(10) + 10;    //Fills the 2D-array matrix with random integers from 10 to 19
            }
        }
        System.out.println("The matrix are : ");
        SortTest s1 = new SortTest(matrix, 1);      //Calls SortTest in order to sort the 2D-array matrix with an ASCENDING order
        s1.showValue();                                       //Shows the sorted 2D-array matrix
        System.out.println("\nLinear Search");
        System.out.print("Enter a number to search: ");
        int input = sc.nextInt();                            //Prompts user to input the integer to be searched in the 2D-array matrix
        if (s1.contains(input)) {                            //A condition, if the 2D-array matrix has user input number, it will fire true,then proceed
            System.out.println(input + " is found");
            System.out.println("The number of " + input + " in the matrix is " + s1.occurrence(input)); //The occurrence of the input number is displayed
            System.out.print("The location of " + input + " are : ");
            for (int[] location : s1.rowAndCol(input)) {                //A for loop to travel through the 2D-array of the indexes of occurring inputs
                System.out.print(Arrays.toString(location) + " ");      //Prints out the indexes for all the occurring inputs
            }
        } else {
            System.out.println(input + " is not found");      //A condition, if the 2D-array matrix doesn't have the user input number, fires false for contains method
        }
    }
}