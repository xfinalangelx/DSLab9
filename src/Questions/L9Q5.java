package Questions;

/**
 * @author Richie
 */

import Structures.HashChain;
import java.io.FileInputStream;
import java.util.Scanner;

public class L9Q5 {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new FileInputStream("lab9Q4.txt"));    //Calls the Scanner Class with FileInputStream to read the text file
            System.out.println("The data set from the File");
            HashChain<Integer, String> table = new HashChain<>();                     //Creates a HashChain table
            while (reader.hasNextLine()) {                                            //A while loop that runs as long as the text file has lines
                table.put(reader.nextInt(), reader.nextLine());                       //Puts the integer and string in the HashChain
            }
            System.out.println("Hash Table using Hash Chain");
            System.out.println("The Hash Table size is " + table.getSize());           //Prints a statement with the size of table
            System.out.print("Enter a PID to search : ");
            Scanner sc = new Scanner(System.in);                                        //Calls the Scanner Class
            int pid = sc.nextInt();                                                     //Creates an integer variable pid that takes in user input of integer
            if (table.containsKey(pid)) {                                               //A condition, if the containsKey method with pid returns true
                System.out.println("Product ID : " + pid + "　" + table.get(pid));      //Prints the statement with pid and the value from the table
                System.out.println("The elements in the same location are : ");
                table.location(pid);                                                    //Shows the location of the value
            } else {
                System.out.println("Product ID " + pid + " cannot be found");           //A condition, else this statement will be printed
            }
        } catch (Exception e) {                                                         //Catches the exception
            System.out.println("ERROR");                                                //If an exception is caught, this statement will be printed
        }
    }
}
