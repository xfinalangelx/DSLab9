package Structures;

/**
 * @author Richie
 */

public class LinkedList<T extends Comparable<T>> {
    private ListNode head;

    public LinkedList() {
        head = null;
    }

    //------------------------------------------------------------default methods in lecture notes----------------------------------------------------------------------//
    public int length() {
        ListNode currentNode = head;
        int cnt = 0;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            cnt++;
        }
        return cnt;
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void showList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }

    public void addNode(T a) {
        ListNode newNode = new ListNode(a, null);
        ListNode currentNode = head;
        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.getLink() != null)
                currentNode = currentNode.getLink();
            currentNode.setLink(newNode);
        }
    }

    public void deleteNode() {
        ListNode currentNode = head;
        ListNode prevNode = head;

        if (head != null) {
            if (currentNode.getLink() != null) {
                head = null;
            } else {
                while (currentNode.getLink() != null) {
                    prevNode = currentNode;
                    currentNode = currentNode.getLink();
                }
                prevNode.setLink(null);
            }
        } else System.out.println("List is empty");
    }

    public void addFront(T a) {
        head = new ListNode(a, head);
    }

    public void deleteFront() {
        if (head != null)
            head = head.getLink();
        else
            System.out.println("The list is empty");
    }

    public boolean contains(T t) {
        ListNode currentNode = head;
        while (currentNode != null) {
            if (t.compareTo((T) currentNode.getData()) == 0) {
                return true;
            }
            currentNode = currentNode.getLink();
        }
        return false;
    }

    public void addNodeAt(T a, int index) {
        if (index == 0)
            addFront(a);
        else if (index == length())
            addNode(a);
        else if (index > length())
            System.out.println("Invalid index. No node inserted");
        else {
            ListNode newNode = new ListNode(a, null);
            ListNode currentNode = head;
            for (int i = 1; i < index; i++)
                currentNode = currentNode.getLink();
            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(newNode);
            newNode.setLink(tempNode);
        }
    }

    public void deleteNodeAt(int index) {
        if (index == 0)
            deleteFront();
        else if (index == length() - 1)
            deleteNode();
        else if (index >= length())
            System.out.println("Invalid index.");
        else {
            ListNode currentNode = head;
            for (int i = 1; i < index; i++)
                currentNode = currentNode.getLink();
            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(tempNode.getLink());
            tempNode = null;
        }
    }

    public void set(T t, int index) {
        if (index == 0)
            setFront(t);
        else if (index == length() - 1)
            setBack(t);
        else if (index >= length())
            System.out.println("Invalid index.");
        else {
            ListNode currentNode = head;
            for (int i = 1; i <= index; i++)
                currentNode = currentNode.getLink();
            currentNode.setData(t);
        }
    }

    public T getFront() {
        if (head != null)
            return (T) head.getData();
        else
            return null;
    }

    public void setFront(T t) {
        if (head != null)
            head.setData(t);
        else
            System.out.println("Invalid update");
    }

    public T getBack() {
        if (head != null) {
            ListNode currentNode = head;
            while (currentNode.getLink() != null)
                currentNode = currentNode.getLink();
            return (T) currentNode.getData();
        } else
            return null;
    }

    public void setBack(T t) {
        if (head != null) {
            ListNode currentNode = head;
            while (currentNode.getLink() != null)
                currentNode = currentNode.getLink();
            currentNode.setData(t);
        } else
            System.out.println("Invalid update");
    }

    public T get(int index) {
        if (index == 0)
            return getFront();
        else if (index == length() - 1)
            return getBack();
        else if (index >= length())
            return null;
        else {
            ListNode currentNode = head;
            for (int i = 1; i <= index; i++)
                currentNode = currentNode.getLink();
            return (T) currentNode.getData();
        }
    }

    //----------------------------------------------------------------------------------------------------Modified methods-------------------------------------------------------------------------------------------------//
    //Q2a : A method that returns true if the element can be found.
    public boolean exist(T input) {                     //A boolean method to check whether user input number exists in the linked list
        ListNode currentNode = head;                    //Making currentNode the head of the list
        while (currentNode != null) {                   //A while loop that runs as long as currentNode has data in it
            if (currentNode.getData().equals(input))    //A condition, if the data on currentNode equals to the user input, it'll fire true
                return true;
            currentNode = currentNode.getLink();        //currentNode pointer will move on to the next node
        }
        return false;                                   //The default return of the boolean method
    }

    //Q2b : A method that returns the number of occurrence for the element.
    public int occurrence(T input) {                    //A method that returns the number of occurrences of user input in the list
        ListNode currentNode = head;                    //Making currentNode the head of the list
        int cnt = 0;                                    //Initializing the counter as 0
        while (currentNode != null) {                   //A while loop that runs as long as currentNode has data in it
            if (currentNode.getData().equals(input))    //A condition, if the data on the currentNode equals to that of user input
                cnt++;                                  //The counter will be incremented
            currentNode = currentNode.getLink();        //currentNode pointer will move on to the next node
        }
        return cnt;                                     //The method returns the counter which is the occurrence number
    }

    //Q2c : A method that returns true if the elements can be found. (search by range)
    public boolean exist(T min, T max) {                                                        //A boolean method that accepts 2 parameters that are min and max. The difference between min and max is the range of query
        ListNode<T> currentNode = head;                                                         //Making currentNode the head of the list
        while (currentNode != null) {                                                           //A while loop that runs as long as currentNode has data in it
            T currentData = currentNode.getData();                                              //Creates a generic container to store the data of currentNode
            if (currentData.compareTo(min) >= 0 && currentData.compareTo(max) <= 0)             //A condition, if the container currentData is more than min and less than max
                return true;                                                                    //The method returns true
            currentNode = currentNode.getLink();                                                //currentNode pointer will move on to the next node
        }
        return false;                                                                           //The else and default return of this boolean method is false
    }

    //Q2d : A method that returns the number of occurrence for the elements. (search by range)
    public int occurrence(T min, T max) {                                                       //An integer method that returns the number of occurrence for the input range
        ListNode<T> currentNode = head;                                                         //Making currentNode the head of the list
        int cnt = 0;                                                                            //Initializing the counter as 0
        while (currentNode != null) {                                                           //A while loop that runs as long as currentNode has data in it
            T currentData = currentNode.getData();                                              //Creates a generic container to store the data of currentNode
            if (currentData.compareTo(min) >= 0 && currentData.compareTo(max) <= 0)             //A condition, if the container currentData is more than min and less than max
                cnt++;                                                                          //The counter will be incremented
            currentNode = currentNode.getLink();                                                //currentNode pointer will move on to the next node
        }
        return cnt;                                                                             //Once loop ends, the method will return the counter
    }

    //Q5 : Used in the HashChain data structure methods such as get() and remove()
    public int indexOfCurrentNode(T t) {                        //An integer method to return the index of the currentNode
        ListNode currentNode = head;                            //Making currentNode the head of the list
        if (!contains(t))                                       //A condition, if the contains() method fire false
            return -1;                                          //Integer -1 is returned
        int cnt = 0;                                            //Initializing the counter as 0
        while (currentNode != null) {                           //A while loop that runs as long as currentNode has data in it
            if (t.compareTo((T) currentNode.getData()) == 0) {  //A condition, if the generic data equals to the data on currentNode
                return cnt;                                     //The counter will be returned by this method
            }
            cnt++;                                              //Or else, the counter will be incremented and not returned
            currentNode = currentNode.getLink();                //currentNode pointer will move on to the next node
        }
        return cnt;                                             //If the while loop ends, the counter will be returned by this method
    }
}


