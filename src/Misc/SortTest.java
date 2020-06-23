package Misc;

/**
 * @author Richie
 */

public class SortTest<T extends Comparable<T>> {
    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;
    private T[][] value;
    private int orderType;

    public SortTest(T[][] value, int orderType) {
        this.value = value;
        this.orderType = orderType;
    }

    //---------------------------------------------------------------------default methods from lecture notes---------------------------------------------------------------//
    public boolean isSorted() {
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length - 1; j++) {
                if (value[i][j].compareTo(value[i][j + 1]) > 0 && orderType == ASCENDING)
                    return false;
                if (value[i][j].compareTo(value[i][j + 1]) < 0 && orderType == DESCENDING)
                    return false;
            }
        }
        return true;
    }

    public void swap(int indexY1, int indexX1, int indexY2, int indexX2) {
        T temp = value[indexY1][indexX1];
        value[indexY1][indexX1] = value[indexY2][indexX2];
        value[indexY2][indexX2] = temp;
    }

    public void showValue() {
        for (int i = 0; i < value.length; i++) {
            for (T item : value[i]) {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }

    //--------------------------------------------------------------------------------------Modified methods--------------------------------------------------------------------------------------------------------//
    //Q1a : A method that returns true if the element can be found.
    public boolean contains(T input) {                      //A boolean method to check whether the 2D-array value contains input argument "input"
        for (int i = 0; i < value.length; i++) {            //The first for loop used to travel through all the elements in 2D-array value on the first dimension
            for (int j = 0; j < value[i].length; j++) {     //The second for loop used to travel through all the elements in 2D-array value on the second dimension
                if (value[i][j].equals(input)) {            //A condition, if the current element of the 2D-array value equals to that of input, it'll return true
                    return true;
                }
            }
        }
        return false;                                       //The default return for this boolean method when the loop stops
    }

    //Q1b : A method that returns the number of occurrence for the element.
    public int occurrence(T input) {                        //A method that returns the number of occurrence of "input"
        int cnt = 0;                                        //Initialize the count
        for (int i = 0; i < value.length; i++) {            //A first for loop to travel through the first dimension of the 2D-array value
            for (int j = 0; j < value[i].length; j++) {     //A second for loop to travel through the second dimension of the 2D-array value
                if (value[i][j].equals(input)) {            //A condition, if the current element equals to the input, the count increases by 1
                    cnt++;
                }
            }
        }
        return cnt;                                         //The return of this method when the loop stops
    }

    //Q1c : A method that returns a list of (row and column) for the element.
    public int[][] rowAndCol(T input) {                     //A method that returns a 2D-array consists of the row number and column number of the input
        int[][] index = new int[occurrence(input)][2];      //Initializing a 2D-array which is the index of the input, the size of first dimension is the occurrence of the input, size of second dimension is 2
        int currentPos = 0;                                 //Initialize a reference to the current position of the loop
        for (int i = 0; i < value.length; i++) {            //A first for loop to travel through the first dimension of the 2D-array value
            for (int j = 0; j < value[i].length; j++) {     //A second for loop to travel through the first dimension of the 2D-array value
                if (value[i][j].equals(input)) {            //A condition, if the current element equals to the input
                    index[currentPos][0] = i;               //The 2D-array will take in the horizontal index of the element
                    index[currentPos][1] = j;               //The 2D-array will take in the vertical index of the element
                    currentPos++;                           //Incrementing the current position by 1 so that it's synchronous with the loop
                }
            }
        }
        return index;                                       //The 2D-array which contains all the occurring inputs' indexes is returned
    }
}
