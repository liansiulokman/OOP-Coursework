
import java.util.*;

/**
 * ***************************************************************************
 * This is for your test purpose, you don't need to submit it.
 * Compilation: javac Assign1Interface.java Assign1.java Assign1Test.java
 * Execution: java -cp . Assign1Test
 * ***************************************************************************
 */
public class Assign1Test {

    // The private member variable
    private Assign1Interface a1;

    // The main method
    public static void main(String[] args) {
        Assign1Test a1test = new Assign1Test();
        a1test.testLevel1();
        a1test.testLevel2();
        a1test.testLevel3();
        a1test.testLevel4();
    }

    // The public constructor
    public Assign1Test() {
        a1 = new Assign1();
    }

    public void testLevel1() {
        // Count how many cases you have passed in this level
        printStartInfo(1);
        int cnt = 0;

        // Test your createList() method
        ArrayList list = a1.createList();
        if (list instanceof ArrayList)
            cnt++;
        else
            printFailMethod("createList()");

        // Test your createList() method
        Vector vector = a1.createVector();
        if (vector instanceof Vector)
            cnt++;
        else
            printFailMethod("createList()");

        // Test your createSet() method 
        TreeSet set = a1.createSet();
        if (set instanceof TreeSet)
            cnt++;
        else
            printFailMethod("createSet()");

        // Print the number of passed cases
        printPassedLevel(cnt, 3, 1);
        printEndInfo(1);
    }

    public void testLevel2() {
        printStartInfo(2);
        int cnt = 0;

        // Test your insertToList() method
        ArrayList list = a1.createList();
        a1.insertToListHead(list, "a");
		a1.insertToListHead(list, "b");
		a1.insertToListHead(list, "c");
        // We check the size and the head of the list to judge
        // whether you have implemented correctly
        if (list.size() == 3 && list.get(0).equals("c")&& list.get(2).equals("a"))
            cnt++;
        else
            printFailMethod("insertToListHead()");

        // Test your insertToVector() method
        Vector vector = a1.createVector();
        a1.insertToVector(vector, "bb");
        if (vector.size() == 1 && vector.get(0).equals("bb"))
            cnt++;
        else
            printFailMethod("insertToVector()");

        // Test your createSet() method
        TreeSet set = a1.createSet();
        a1.insertToSet(set, 18);
		a1.insertToSet(set, 25);
		a1.insertToSet(set, 7);
		a1.insertToSet(set, 99);
        if (set.size() == 4)
            cnt++;
        else
            printFailMethod("insertToSet()");

        // Test your removeLowestValue() method
        if (a1.removeLowestValue(set) != null && a1.removeLowestValue(set).equals(18))
            cnt++;
        else
            printFailMethod("removeLowestValue()");

        printPassedLevel(cnt, 4, 2);
        printEndInfo(2);
    }

    public void testLevel3() {
        printStartInfo(3);
        int cnt = 0;

        // Test your insertToListNTimes() method
        ArrayList list = a1.createList();
        a1.insertToListNTimes(list, "test", 3);
        if ( list.size() == 3)
            cnt++;
        else
            printFailMethod("insertToListNTimes()");

        // Test your removeFromListHead() method
        // Please handle the exception when the list is empty
        if (a1.removeFromListHead(list) != null && a1.removeFromListHead(list).equals("test")) {
            try {
                cnt++;
                for (int i = 0; i < 10; i++)
                    a1.removeFromListHead(list);
            } catch (Exception e) {
                cnt--;
                printFailMethod("removeFromListHead()");
            }

        } else 
        printFailMethod("removeFromListHead()");


        // Test your getOddIndexElement() method
        Vector vector = a1.createVector();
        a1.insertToVector(vector, 1);
        a1.insertToVector(vector, list);
        a1.insertToVector(vector, "test");
        a1.insertToVector(vector, 8);
        a1.insertToVector(vector, null);

		if (a1.getOddIndexElement(vector) != null && a1.getOddIndexElement(vector).size() == 2 &&  a1.getOddIndexElement(vector).get(0) == list && a1.getOddIndexElement(vector).get(1).equals(8) && vector.size() == 5)
            cnt++;
        else
            printFailMethod("getOddIndexElement()");

        // Test your findRangeMax() method
        List<Double> l1 = Arrays.asList(39.2, 12.1, 22.2, 55.4, 42.2, 59.5, 67.6);
        
		if (a1.findRangeMax(0, 2, l1)!=null && a1.findRangeMax(0, 2, l1) == 39.2 && a1.findRangeMax(4, 6, l1) == 67.6 && a1.findRangeMax(4, 6, l1)!=null)
            cnt++;
        else
            printFailMethod("findRangeMax()");

        printPassedLevel(cnt, 4, 3);
        printEndInfo(3);
    }

    public void testLevel4() {
        printStartInfo(4);
        int cnt = 0;

        // Test your averageOfSubListOfIntegers() method
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        if (a1.averageOfSubListOfIntegers(1, 4, l1) != null && a1.averageOfSubListOfIntegers(1, 4, l1) == 3 && a1.averageOfSubListOfIntegers(3, 6, l1) == 5 && a1.averageOfSubListOfIntegers(3, 6, l1) != null)
            cnt++;
        else
            printFailMethod("averageOfSubListOfIntegers()");

        // Test your getObjectPositionOfList() method
        ArrayList list = a1.createList();
        a1.insertToListHead(list, l1);
        a1.insertToListHead(list, "test");
        a1.insertToListHead(list, 8.4);
        a1.insertToListHead(list, 99);
        if (a1.getObjectPositionOfList(list, 8.4) == 2 && a1.getObjectPositionOfList(list, 7) == -1 && list.size() == 4)
            cnt++;
        else
            printFailMethod("getObjectPositionOfList()");

		//test your sortedSpecifiedList() method	
		String names[] = { "Japan", "Vietnam"};
		Collection countries = new ArrayList();
		for (int i = 0, n = names.length; i < n; i++) {
			countries.add(names[i]);
		}
		
		ArrayList countryList1 = a1.createList();
		a1.insertToListHead(countryList1, "India");
        a1.insertToListHead(countryList1, "Japan");
        a1.insertToListHead(countryList1, "Cuba");
        a1.insertToListHead(countryList1, "Germany");
		a1.insertToListHead(countryList1, "America");
		
		if(a1.sortedSpecifiedList(countryList1, countries) != null && a1.sortedSpecifiedList(countryList1, countries).isEmpty())
			cnt++;
        else
            printFailMethod("sortedSpecifiedList()");
			
		//test your listComparing() method
		ArrayList countryList2 = a1.createList();
		a1.insertToListHead(countryList2, "China");
        a1.insertToListHead(countryList2, "Thailand");
        a1.insertToListHead(countryList2, "Japan");
        a1.insertToListHead(countryList2, "Singapore");
		a1.insertToListHead(countryList2, "Vietnam");
		
		ArrayList countryList3 = a1.createList();
		a1.insertToListHead(countryList3, "Vietnam");
		a1.insertToListHead(countryList3, "Thailand");
		a1.insertToListHead(countryList3, "Singapore");
		a1.insertToListHead(countryList3, "Japan");
		a1.insertToListHead(countryList3, "China");
		
		if(a1.sortedSpecifiedList(countryList2, countries) != null && a1.listComparing(a1.sortedSpecifiedList(countryList2, countries), countryList3))
			cnt++;
		else
            printFailMethod("listComparing()");
			
		printPassedLevel(cnt, 4, 4);
        printEndInfo(4);
    }

    public void printPassedLevel(int cnt, int levelTotal, int level) {
        System.out.println("* You have passed " + cnt + "/" + levelTotal + " cases of level " + level);
    }

    public void printStartInfo(int level) {
        System.out.println("****************************************");
        System.out.println("* Start testing Level " + level);
    }

    public void printEndInfo(int level) {
        System.out.println("* End testing Level " + level);
        System.out.println("****************************************");
    }

    public void printFailMethod(String method) {
        System.out.println("* " + method + " Failed");
    }
}
