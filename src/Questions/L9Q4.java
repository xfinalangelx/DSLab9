package Questions;

/**
 * @author Richie
 */

import Structures.ArrayHashTableHashing;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L9Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                                                    //Calls the Scanner Class
        ArrayHashTableHashing<Integer, String> products = new ArrayHashTableHashing<>();        //Creates a new hashed Hash Table products
        try {                                                                                   //A try-catch clause when trying to implement the FileInputStream
            Scanner scan = new Scanner(new FileInputStream(new File("lab9Q4.txt")));  //Probes the scanner to read the lines from the text file lab9Q4.txt
            String line;                                                                        //Initializes a String variable line
            while (scan.hasNextLine()) {                                                        //A while loop that runs as long as the text file contains word lines
                line = scan.nextLine();                                                         //Adds the scanned lines from the text file into line
                products.put(Integer.valueOf(line.substring(0, 5)), line.substring(6));         //Extracts the value number by using substring method
            }
        } catch (FileNotFoundException e) {                                                     //Catches exceptions
            e.printStackTrace();
        }
        System.out.println("The data set from the File");
        products.showHashTable();                                                                       //Shows the products HashTable
        System.out.println("The Hash Table size is " + products.getSize());                             //Prints a statement together with the size of the Hash Table
        System.out.print("Enter a PID to search : ");
        String inputKey = sc.nextLine();                                                                //Takes the user input and assigns it as inputKey
        if (products.containsKey(Integer.valueOf(inputKey))) {                                                  //A condition, if the Hash Table contains the Integer-casted value of keyInput
            System.out.println("Product ID : " + inputKey + " " + products.get(Integer.valueOf(inputKey)));     //A statement will be printed together with the value corresponding to the inputKey
            System.out.println("Location : " + products.getLocation(Integer.valueOf(inputKey)));                //The location of the value will be printed
        } else {                                                                                                //A condition, if the inputKey doesn't exist in the Hash Table
            System.out.println("Product ID " + inputKey + " cannot be found");                                  //Another statement will be printed
        }
    }
}
