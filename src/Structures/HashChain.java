package Structures;

/**
 * @author Richie
 */

public class HashChain<K, V> {

    public final int MAX_SIZE = 20;
    private LinkedList<MapNode<K, V>>[] arr;

    //Q3a : Constructor
    public HashChain() {
        arr = new LinkedList[MAX_SIZE];
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
        for (int i = 0; i < MAX_SIZE ; i++) {
            arr[i] = null;
        }
    }

    //Q3f : showHashTable (modified)
    public void showHashTable() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
                System.out.println(arr[i].toString());
        }
    }

    //Q3g : containsKey (modified)
    public boolean containsKey(Comparable<K> keyInput) {           //A boolean method that takes in keyInput and verifies whether the keyInput exists in the Hash Table
        int position = keyInput.hashCode() % arr.length;           //Initializing an integer variable position with the hashed value of keyInput modulo by the array length
        if (arr[position] == null)                                 //A condition, if the element with index of position is empty
            return false;                                          //The method returns false
        LinkedList<MapNode<K, V>> list = arr[position];            //Creates a linked list of MapNode list with the elements in the array
        MapNode<K, V> m = new MapNode(keyInput, null);             //Creates a MapNode m with the key of keyInput
        return list.contains(m);                                   //The method returns whether the list contains the MapNode m
    }


    //Q3h : containsValue (modified)
    public boolean containsValue(Comparable<V> valueInput) {        //A boolean method that takes in valueInput to check whether it exists in the Hash Table
        for (int i = 0; i < arr.length; i++) {                      //A for loop that loops arr.length times
            if (arr[i] != null) {                                   //A condition, if the current element in the hash table is empty
                LinkedList<MapNode<K, V>> list = arr[i];            //A Linked List of MapNode list will be created with the elements of the array
                for (int j = 0; j < list.length(); j++) {           //A for loop that loops list.length times
                    if (list.get(j).getValue().equals(valueInput))  //A condition, if the current element in the list equals to that of valueInput
                        return true;                                //The method returns true
                }
            }
        }
        return false;                                               //The method by default returns false
    }

    //Q3i : get (modified)
    public V get(Comparable<K> keyInput) {
        if (!containsKey(keyInput)) {                                   //A condition, if the containsKey with keyInput returns false
            return null;                                                //This method will return null
        } else {                                                        //A condition, else the containsKey with keyInput returns true
            int position = keyInput.hashCode() % arr.length;            //Initializing an integer variable position with the hashed keyInput modulo by the length of array
            LinkedList<MapNode<K, V>> list = arr[position];             //Creates a Linked List of MapNode list with the elements of the array at the index position
            MapNode<K, V> m = new MapNode(keyInput, null);              //Creates a MapNode m with the key of keyInput
            return list.get(list.indexOfCurrentNode(m)).getValue();     //The method returns the value of the element which has the same key as keyInput
        }
    }

    //Q3j put (modified)
    public V put(Comparable<K> keyInput, V valueInput) {
        MapNode newNode = new MapNode(keyInput, valueInput);            //Creates a MapNode newNode with the key of keyInput and value of valueInput
        int position = keyInput.hashCode() % arr.length;                //Creates an integer variable position with the hashed keyInput modulo by length of array
        if (arr[position] == null) {                                    //A condition, if the element with index of position is empty
            LinkedList<MapNode<K, V>> newList = new LinkedList<>();     //Creates a Linked List of MapNode newList
            arr[position] = newList;                                    //Assigns the array to newList
        }
        System.out.println(newNode);                                    //Prints out the newly formed MapNode newNode
        arr[position].addNode(newNode);                                 //Adds newNode to the array with the index of position
        return valueInput;                                              //The generic method returns the valueInput
    }

    //Q3k : remove (modified)
    public V remove(Comparable<K> keyInput) {
        if (!containsKey(keyInput)) {                                   //A condition, if the containsKey method with keyInput returns false
            return null;                                                //The method will return null
        } else {                                                        //A condition, else the containsKey method with keyInput returns true
            int position = keyInput.hashCode() % arr.length;            //Creates an integer variable position with the hashed keyInput modulo by length of array
            LinkedList<MapNode<K, V>> list = arr[position];             //Creates a Linked List of MapNode list with the elements of the array on the index position
            MapNode<K, V> m = new MapNode(keyInput, null);              //Creates a new MapNode m with keyInput as key and null as value
            V temp = list.get(list.indexOfCurrentNode(m)).getValue();   //Initializes a generic variable temp with the value of the list
            list.deleteNodeAt(list.indexOfCurrentNode(m));              //Deletes the node at the current index of the node in the list
            return temp;                                                //The method returns temp
        }
    }


    public void location(Comparable<K> keyInput) {
        int position = keyInput.hashCode() % arr.length;    //Creates an integer variable position with the hashed keyInput modulo by the length of array
        LinkedList<MapNode<K, V>> list = arr[position];     //Creates a Linked List of MapNode list with the elements of the array on the index position
        list.showList();                                    //Shows the Linked list of MapNode list
        System.out.println("");
    }
}
