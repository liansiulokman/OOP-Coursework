import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.Collection;
import java.util.Collections;

public class Assign1TestLevel4 extends TestCase{

    private Assign1Interface a1;

    public void setUp() {
        a1 = new Assign1();
    }

    public void testAverageOfSubListOfIntegers() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int sum = 0;
        int fromIndex = 1;
        int endIndex = 3;
        Object expected = (int) (3+4+5)/3;
        assertEquals(expected, a1.averageOfSubListOfIntegers(fromIndex, endIndex, list));
    }

    public void testGetObjectPositionOfList() throws Exception {
        ArrayList list = new ArrayList();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        Object o =6;
        int pos = 0;
        if(list.indexOf(o)<0){
            pos = list.indexOf(o);
        }
        else
            pos = list.indexOf(o)+1;
        assertEquals(pos,a1.getObjectPositionOfList(list, o));
    }

    
    public void testSortedSpecifiedList() throws Exception {
        ArrayList list = new ArrayList();
        ArrayList a = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        a.add("A");
        a.add("D");
        Collection<String> collection = a;
        if(list.containsAll(collection)){
            Collections.sort(list);
            a=list;
        }
        else
            a = new ArrayList();
        assertEquals(a,a1.sortedSpecifiedList(list, collection));
    }
    
    public void testListComparing () throws Exception {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        assertTrue(a1.listComparing(list1, list2));
        //assertFalse(a1.listComparing(list1, list2));
    }
    
}