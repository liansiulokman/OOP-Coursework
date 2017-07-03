/**
 * **********************************************************************
 * You don't need to submit it, we will provide it.
 * This Interface describes all the methods you need to implement in your
 * Assign1.java.
 * In this assignment, you will learn how to use the various APIs of List, Vector and Set
 * to finish your programming task.
 * Compilation: javac Assign1Interface.java Assign1.java Assign1Test.java
 * Execution: java -cp . Assign1Test
 * ***********************************************************************
 */

import java.util.*;

public interface Assign1Interface {

// The interface methods are ordered by the level of difficulty, from low to high.

// Level 1
    /**
     * Level 1<br>
     * This method will return a new List.
     * @return the created new List
     */
    public ArrayList createList();

    /**
     * Level 1<br>
     * This method will return a new Vector.
     * @return the created new Vector
     */
    public Vector createVector();

    /**
     * Level 1 <br>
     * This method will return a new Set
     * @return the created new Set
     */
    public TreeSet createSet();

// Level 2
    /**
     * Level 2 <br>
     * This method will add object o into the head of list
     * @param list the list to which the object will be added
     * @param o the object needed to be added
     */
    public void insertToListHead(ArrayList list, Object o);

    /**
     * Level 2 <br>
     * This method will add object o into the tail of vector
     * @param vector the vector to which the object will be added
     * @param o the object needed to be added
     */
    public void insertToVector(Vector vector, Object o);

    /**
     * Level 2 <br>
     * This method will add object o into set
     * @param set the set to which the object will be added
     * @param o the object needed to be added
     */
    public void insertToSet(TreeSet set, Object o);

    /**
     * Level 2 <br>
     * Remove the lowest value element from the treeset.
     * @param set the set needs to be tested
     * @return the lowest value element
     */
    public Object removeLowestValue(TreeSet set);

// Level 3
    /**
     * Level 3 <br>
     * This method will add object o into the tail of list, n means repeating this operation n times.
     * @param list the list to which the object will be added
     * @param o the object needed to be added
     * @param n the number of repeating time
     */
    public void insertToListNTimes(ArrayList list, Object o, int n);

    /**
     * Level 3 <br>
     * This method will remove the head element from the list and return the removed element.<br>
     * But if list is empty, just return null, please don't throw out exception, and we will check this.
     * @param list the list which will be operated
     * @return null if list is empty, don't throw out exception
     */
    public Object removeFromListHead(ArrayList list);

    /**
     * Level 3 <br>
     * This method will return the vector of odd index elements.<br>
     * For example, [a, b, c, d] => [b, d] <br>
     * If list is empty, just return null.
     * @param vector the vector which will be operated
     * @return the new vector selected from odd index vector
     */
    public Vector getOddIndexElement(Vector vector);

    /**
     * Level 3 <br>
     * This method returns the maximum value of a sublist of the input list;<br>
     * the sublist starts with fromIndex(inclusive),ends with endIndex(inclusive), <br>
     * for example, for list [0.1, 1.1, 2.2,3.3, 4.4, 5.5, 6.6]<br>
     * findRangeMax(1, 4, list) = 4.4
     * @param fromIndex the sublist's start index
     * @param endIndex the sublist's end index
     * @param list the original list
     * @return the maximum value of the sublist
     */
    public Double findRangeMax(int fromIndex, int endIndex, List<Double> list);

// Level 4
    /**
     * Level 4 <br>
     * This method will return the average of a sublist of the passed list, the elements at fromIndex and endIndex are included <br>
     * We will always pass a list of integers, but the parameter type of the method is just List<Object><br>
     * For example, for list [1, 2, 3, 4, 5, 6, 7, 3, 3, 2, 2, 1]<br>
     * averageOfSubListOfIntegers(0, 1, list) = (1+2)/2 = 3/2 = 1.5, then round down to 1<br>
     * averageOfSubListOfIntegers(7, 11, list) = (3+3+2+2+1)/5 = 11/5 = 2.2, then round down to 2
     * @param fromIndex the sublist's start index
     * @param endIndex the sublist's end index
     * @param list the original list
     * @return the average value of the sublist
     */
    public Integer averageOfSubListOfIntegers(int fromIndex, int endIndex, List<Integer> list);

    /**
     * Level 4 <br>
     * If an object is in a list, return the position.If no, return -1<br>
     * Notice that the position is 1-based, and starts from head<br>
     * And this list should be left untouched, we will check it<br>
     * For example, for list [a, b, c, d], if a is the head, d is the tail<br>
     * then the position of c is 3
     * @param list the list which will be operated
     * @param o the object which will be searched
     * @return the position of the object in the list, -1 if not found
     */
    public int getObjectPositionOfList(ArrayList list, Object o);
	
	/**
     * Level 4 <br>
     * If the list contain all elements in the second input "collection",<br>
     * then return a sorted list, otherwise return an empty list<br>
     * For example, for list [b, a, d, c], if collection is [a, c], then<br>
     * return the sorted list [a, b, c, d]
     * @param list the list which will be operated
     * @param collection the list should contain all of the elements determined in collection
     * @return the sorted list, return empty list if not found
     */
	public ArrayList sortedSpecifiedList(ArrayList list, Collection<String> collection);
	
	/**
     * Level 4 <br>
     * Return true if the two lists contain the same set of elements in the same order; otherwise return false<br>
     * For example, for list1 [a, b, c, d], if list2 is [a, b, c, d], then return true<br>
     * @param list1 the list which will be compared
     * @param list2 the list which will be compared
     * @return true, false if they are not the same
     */
	public boolean listComparing (ArrayList list1, ArrayList list2);
	
}
