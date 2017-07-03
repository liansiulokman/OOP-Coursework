import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Vector;
import java.util.TreeSet;

public class Assign1TestLevel2 extends TestCase{

    private Assign1Interface a1;

    public void setUp() {
        a1 = new Assign1();
    }

    public void testInsertToListHead() throws Exception {
        ArrayList list = new ArrayList();
        Object o = new Object();
        a1.insertToListHead(list,o);
        assertEquals(o,list.get(0));
    }

    public void testInsertToVector() throws Exception {
        Vector vector = new Vector();
        Object o = new Object();
        a1.insertToVector(vector,o);
        assertEquals(o,vector.elementAt(0));
    }

    
    public void testInsertToSet() throws Exception {
        TreeSet set = new TreeSet();
        Object expected = new Object();
        expected = null;
        a1.insertToSet(set,5);
        if(set.contains(5)) 
            expected = true;
        assertEquals(expected,set.contains(5));
    }
    
    public void testRemoveLowestValue() throws Exception {
        TreeSet set = new TreeSet();
        set.add(20);
        set.add(40);
        set.add(60);
        Object expected = new Object();
        if(set.size()==0)
            expected = null;
        else
            expected = set.first();
        assertEquals(expected,a1.removeLowestValue(set));
    }
    
}