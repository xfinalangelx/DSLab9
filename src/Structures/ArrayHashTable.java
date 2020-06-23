package Structures;

/**
 * @author Richie
 */

//Q3 : Create an ADT HashTable named ArrayHashTable, maximum size of the ADT is 20
public class ArrayHashTable<K, V> {
    public final int MAX_SIZE = 20;                         //Max size of 20
    private MapNode<K, V>[] arr;

    //Q3a : Constructor
    public ArrayHashTable() {
        arr = new MapNode[MAX_SIZE];
    }


    //Q3b : isEmpty
    public boolean isEmpty() {      //A boolean method
        return getSize() == 0;
    }

    //Q3c : isFull
    public boolean isFull() {       //A boolean method
        return getSize() == 20;     //Since the max size is 20, it'll return 20
    }

    //Q3d : getSize
    public int getSize() {                          //An integer method
        int cnt = 0;                                //Initializing a counter
        while (arr[cnt] != null) {                  //A while loop that runs until the element in the array equals to null
            cnt++;                                  //The counter is incremented
        }
        return cnt;                                 //The method by default also returns the counter
    }

    //Q3e : clear
    public void clear() {                       //A void method because it doesn't require parameters
        for (int i = 0; i < MAX_SIZE; i++) {    //A for loop that loops every element in the Hash Table array
            arr[i] = null;                      //Set every element in the array to be equal to null, hence clearing the array
        }
    }

    //Q3f : showHashTable
    public void showHashTable() {                           //A void method
        for (int i = 0; i < getSize(); i++) {               //A for loop that starts from 0 to the size of Hash Table
            System.out.print(arr[i].toString() + " | ");    //Printing the HashTable by looping through every element in the Hash Table's array
        }
    }

    //Q3g : containsKey
    public boolean containsKey(Comparable<K> keyInput) {    //A boolean method that accepts the key input
        for (int i = 0; i < getSize(); i++) {               //A for loop that starts from 0 to the size of Hash Table
            if (arr[i].getKey().equals(keyInput))           //A condition, if the Hash Table's array element's key equals to the key input
                return true;                                //This method will return true
        }
        return false;                                       //A condition, else the method returns false
    }


    //Q3h : containsValue
    public boolean containsValue(Comparable<V> valueInput) {//A boolean method that accepts the value input
        for (int i = 0; i < getSize(); i++) {               //A for loop that starts from 0 to the size of Hash Table
            if (arr[i].getValue().equals(valueInput))       //A condition, if the Hash Table's array element's key equals to the value input
                return true;                                //This method will return true
        }
        return false;                                       //A condition, else the method returns false
    }

    //Q3i : get
    public V get(Comparable<K> keyInput) {                  //A generic method to get the value based on key input
        for (int i = 0; i < getSize(); i++) {               //A for loop that starts from 0 to the size of the Hash Table
            if (arr[i].getKey().equals(keyInput))           //A condition, if the Hash Table's array element's key equals to the key input
                return arr[i].getValue();                   //The method will return the value of the Hash Table array at the current loop
        }
        return null;                                        //By default the method returns null
    }

    //Q3j : put
    public V put(Comparable<K> keyInput, V valueInput) {      //A generic method to put the key and value based on inputs at the parameter
        MapNode newNode = new MapNode(keyInput, valueInput);  //Creates a new MapNode that accepts the parameters of the method
        if (isFull()) {                                       //A condition, if the HashTable is full
            return null;                                      //The new MapNode will not be added
        } else {
            for (int i = 0; i <= getSize(); i++) {            //A condition, else a for loop from 0 to the size of the HashTable will be executed, meaning loop getSize + 1 times
                if (arr[i] == null) {                         //A condition, if the current element in the Hash Table array equals to null
                    arr[i] = newNode;                         //The current element in the Hash Table will inherit the newNode
                    return valueInput;                        //The value of the newNode will be returned in this method
                } else if (arr[i].getKey().equals(keyInput)) {//A condition, else if the key of the current element in the Hash Table array equals to the key input from the method parameter
                    arr[i] = newNode;                         //The current element in the Hash Table will inherit the newNode
                    return valueInput;                        //The value of the newNode will be returned in this method
                }
            }
        }
        return null;                                          //The method's default return is null
    }

    //Q3k : remove
    public V remove(Comparable<K> key) {                //A generic method to delete the element of the Hash Table array based on the key input
        for (int i = 0; i < getSize(); i++) {           //A for loop that starts from 0 to the size of the Hash Table array
            if (arr[i].getKey().equals(key)) {          //A condition, if the element of the Hash Table array equals to the key value from parameter
                arr[i] = arr[getSize() - 1];            //The current element will be moved to the final slot of the array
                arr[getSize() - 1] = null;              //The final slot of the array is set to null
                return arr[getSize() - 1].getValue();   //The last element in the Hash Table array is returned
            }
        }
        return null;                                  //By default, null is returned
    }
}






