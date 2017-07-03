import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.TreeSet;


public class Assign1TestLevel3 extends TestCase{

    private Assign1Interface a1;

    public void setUp() {
        a1 = new Assign1();
    }

    
    public void testInsertToListNTimes() throws Exception {
        ArrayList list = new ArrayList();
        //list.add(20);
        int n = 5;
        Object o = new Object();
        a1.insertToListNTimes(list,o,n);
        int count=0;
        for(int c = 1; c<=5; c++){
            if(list.get(list.size()-c).equals(o))
                count++;
        }
        assertEquals(count,n);
    }
    

    public void testRemoveFromListHead() throws Exception {
        ArrayList list = new ArrayList();
        Object expected = new Object();
        list.add(5);
        list.add(6);
        list.add(7);
        if(list.isEmpty())
            expected = null;
        else
            expected = list.get(0);
        assertEquals(expected,a1.removeFromListHead(list));
    }

    
    public void testGetOddIndexElement() throws Exception {
        Vector vector = new Vector();
        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4);
        vector.addElement(5);
        Vector temp = new Vector();
        for(int y=1; y<vector.size();y+=2){
            temp.add(vector.elementAt(y));
        }
        
        assertEquals(temp,a1.getOddIndexElement(vector));
    }
    
    public void testFindRangeMax() throws Exception {
        ArrayList list = new ArrayList();
        list.add(2.0);
        list.add(4.0);
        list.add(10.0);
        list.add(8.0);
        list.add(70.0);
        list.add(12.0);
        int from = 1;
        int end = 4;
        double expected = 70.0;
        assertEquals(expected,a1.findRangeMax(from, end, list));
    }
    
}