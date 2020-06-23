package Structures;

/**
 * @author Richie
 */

//Q4 : Create a data structure ArrayHashTableHashing by modifying the ArrayHashTable created in Q3
public class ArrayHashTableHashing<K, V> {

    public final int MAX_SIZE = 20;
    private MapNode<K, V>[] arr;

    //Q3a : Constructor
    public ArrayHashTableHashing() {
        arr = new MapNode[MAX_SIZE];
    }

    //Q3b : isEmpty
    public boolean isEmpty() {
        return getSize() == 0;
    }

    //Q3c : isFull
    public boolean isFull() {
        return getSize() == MAX_SIZE;
    }

    //Q3d : getSize
    public int getSize() {
        int cnt = 0;
        while (arr[cnt] != null) {
            cnt++;
        }
        return cnt;
    }

    //Q3e : clear
    public void clear() {
        for (int i = 0; i < MAX_SIZE; i++) {
            arr[i] = null;
        }
    }

    //Q3f : showHashTable (modified)
    public void showHashTable() {                                                                               //A void method that shows the Hash Table
        for (int i = 0; i < MAX_SIZE; i++)                                                                      //A for loop that loops 20 times
            if (arr[i] != null)
                System.out.println(arr[i].toString().replace(" |", ""));      //A condition, if the current element of the array isn't empty, print the current element and replace the symbol | with nothing
    }

    //Q3g : containsKey (modified)
    public boolean containsKey(Comparable<K> keyInput) {    //A boolean method that checks whether the array has key matching with keyInput
        int probeCount = 1;                                 //Initializes an integer variable probeCount as 1
        int keyHash = getKeyHash((Integer) keyInput);           //Initializes the integer variable keyHash as the hashed key from the method getKeyHash by passing in the Integer casted keyInput in the method
        int index = keyHash;                                    //Initializes the integer variable index with the hashed key as a reference pointer

        if (arr[keyHash] != null && keyInput.compareTo(arr[keyHash].getKey()) == 0)                     //A condition, if the element of the array with the key keyHash isn't empty AND the keyInput equals to the key of the element of the array with the key keyHash
            return true;                                                                                //The method returns true
        while (arr[index] != null) {                                                                    //A while loop that runs as long the element of the index isn't empty
            index = keyHash + P(probeCount);                                                            //Sets the index to the sum of the hashed key and probing function to handle collision
            probeCount++;                                                                               //Increments the probeCount each loop runs
            if (arr[index] != null && keyInput.compareTo(arr[index].getKey()) == 0)                     //A condition, if the current element in the array isn't empty AND the keyInput equals to the key of the current element element in the array
                return true;                                                                            //The method returns true
        }
        return false;                                                                                   //The method by default returns false
    }

    //Q3h : containsValue (modified)
    public boolean containsValue(Comparable<V> valueInput) {                         //A boolean method that checks whether the array has the valueInput
        for (int i = 0; i < MAX_SIZE; i++) {                                         //A for loop that starts from 0 and ends at 19, loop 20 times
            if (arr[i] != null && valueInput.compareTo(arr[i].getValue()) == 0)      //A condition, if the current element in the array isn't empty AND the valueInput equals to the current element's value
                return true;                                                         //The method returns true
        }
        return false;                                                                //This method by default returns false
    }

    //Q3i : get (modified)
    public V get(Comparable<K> keyInput) {
        int probeCount = 1;                                     //Initializes the integer variable probeCount as 1
        int keyHash = getKeyHash((Integer) keyInput);           //Initializes the integer variable keyHash as the hashed key from the method getKeyHash by passing in the Integer casted keyInput in the method
        int index = keyHash;                                    //Initializes the integer variable index with the hashed key as a reference pointer

        if (arr[keyHash] != null && keyInput.compareTo(arr[keyHash].getKey()) == 0)                     //A condition, if the element of the array with the key keyHash isn't empty AND the keyInput equals to the key of the element of the array with the key keyHash
            return arr[keyHash].getValue();
        while (arr[index] != null) {                                                                    //A while loop that runs as long the element of the index isn't empty
            index = keyHash + P(probeCount);                                                            //Sets the index to the sum of the hashed key and probing function to handle collision
            probeCount++;                                                                               //Increments the probeCount each loop runs
            if (arr[index] != null && keyInput.compareTo(arr[index].getKey()) == 0)                     //A condition, if the element of the array isn't empty AND the keyInput equals to the key of the element in the array
                return arr[index].getValue();                                                           //The method returns the value of the element in the array
        }
        return null;                                                                                    //The method by default returns null
    }

    //Q4
    public int getLocation(Comparable<K> keyInput) {            //An integer method that gets the location of the element by taking the keyInput
        int probeCount = 1;                                     //Initializes the integer variable probeCount as 1
        int keyHash = getKeyHash((Integer) keyInput);           //Initializes the integer variable keyHash as the hashed key from the method getKeyHash by passing in the Integer casted keyInput in the method
        int index = keyHash;                                    //Initializes the integer variable index with the hashed key as a reference pointer

        if (arr[keyHash] != null && keyInput.compareTo(arr[keyHash].getKey()) == 0)                     //A condition, if the element of the array with the key keyHash isn't empty AND the keyInput equals to the key of the element of the array with the key keyHash
            return keyHash;                                                                             //The method returns the hashed key
        while (arr[index] != null) {                                                                    //A while loop that runs as long the element of the index isn't empty
            index = keyHash + P(probeCount);                                                            //Sets the index to the sum of the hashed key and probing function to handle collision
            probeCount++;                                                                               //Increments the probeCount each loop runs
            if (arr[index] != null && keyInput.compareTo(arr[index].getKey()) == 0)                     //A condition, if the current element of the array isn't empty AND the keyInput equals to the key of the element in the array
                return index;                                                                           //The method returns index
        }
        return -1;                                                                                      //The method by default returns negative one
    }

    //Q3j put (modified)
    public V put(Comparable<K> keyInput, V valueInput) {              //A generic method that puts the keyInput and valueInput into the Hash Table
        if (isFull()) {                                               //A condition, if the isFull() method fires true
            System.out.println("The Hash Table is full");
            return null;                                              //The method returns null
        } else {                                                      //A condition, if the isFull() method fires false
            int probeCount = 1;                                       //Initializes an integer variable probeCount as 1
            int keyHash = getKeyHash((Integer) keyInput);             //Initializes an integer variable keyHash by casting Integer and putting the keyInput into the getKeyHash method
            int index = keyHash;                                      //Initializes an integer variable with the value of keyHash as the reference pointer

            if (arr[keyHash] != null && keyInput.compareTo(arr[keyHash].getKey()) == 0) {   //A condition, id the hashed key element isn't empty AND the keyInput equals to the current hashed key element
                V temp = arr[keyHash].getValue();                                           //Initializes a generic variable temp with the value of the current hashed key element
                arr[keyHash].setValue(valueInput);                                          //Assign the value of the hashed key element with valueInput
                return temp;                                                                //Returns the generic variable temp
            }

            while (arr[index] != null) {                                                    //A while loop that runs as long as the current element isn't empty
                index = keyHash + P(probeCount);                                            //Sets the index to the sum of the hashed key and the probing function to handle collisions
                probeCount++;                                                               //Increments the probeCount number in each loop
                if (arr[index] != null && keyInput.compareTo(arr[index].getKey()) == 0) {   //A condition, if the current element isn't empty AND the keyInput equals to the current element's key
                    V temp = arr[index].getValue();                                         //Initializes a generic variable temp with the value of the current element in the array
                    arr[index].setValue(valueInput);                                        //Sets the value of current element in the array with valueInput
                    return temp;                                                            //Returns temp
                }
            }
            arr[index] = new MapNode(keyInput, valueInput);                                 //Assigns the current element in the array with key keyInput and value valueInput
        }
        return null;                                                                        //The method by default returns null
    }

    //Q3k : remove (modified)
    public V remove(Comparable<K> keyInput) {                //A generic method that removes value of element based on parameter keyInput
        if (isEmpty()) {                                     //A condition, if the method isEmpty() fires true
            return null;                                     //The method returns null
        } else {                                             //A condition, else
            int probeCount = 1;                              //Initialize an integer variable probeCount with the value of 1
            int keyHash = getKeyHash((Integer) keyInput);    //Initializes an integer variable keyHash by casting Integer and putting the keyInput into the getKeyHash method
            int index = keyHash;                             //Initializes an integer variable with the value of keyHash as the reference pointer

            if (arr[keyHash] != null && keyInput.compareTo(arr[keyHash].getKey()) == 0) {   //A condition, if the current element doesn't equal to null AND the keyInput equals to the element in the array
                V value = arr[keyHash].getValue();                                          //Initializes a generic variable value with the value of the array based on the hashed key
                arr[keyHash] = null;                                                        //Sets the current element equals to null, removing it from the array
                return value;                                                               //Returns the value
            }
            while (arr[index] != null) {                                                    //A while loop that runs as long as the current element in the array doesn't equal to null
                index = keyHash + P(probeCount);                                            //Sets the index to the sum of keyHash and the probing function to handle collisions
                probeCount++;                                                               //Increments the probeCount number in each loop
                if (arr[index] != null && keyInput.compareTo(arr[index].getKey()) == 0) {   //A condition, if the current element in the array isn't empty AND the keyInput equals to the key of the current element
                    V value = arr[index].getValue();                                        //Initializes a generic variable value with the value of the current element
                    arr[index] = null;                                                      //Sets the current element in the array to null, removing it
                    return value;                                                           //Returns the value
                }
            }
            return null;                                                                    //The method by default returns null
        }
    }

    //Q4 : getKeyHash
    public int getKeyHash(int value) {  //An integer method that hashes the parameter value
        return value % MAX_SIZE;        //After taking the parameter value and modulus MAX_SIZE which is 20, returns the hashed key
    }

    //Q4 : Probing function
    public int P(int cnt) {
        return 1 * cnt;     //P(k) = 1*x
    }
}