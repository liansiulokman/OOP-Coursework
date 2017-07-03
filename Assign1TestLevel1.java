import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Vector;
import java.util.TreeSet;

public class Assign1TestLevel1 extends TestCase {

    private Assign1Interface a1;

    public void setUp() {
        a1 = new Assign1();
    }

    public void testCreateList() throws Exception {
        assertTrue(a1.createList() instanceof ArrayList);
    }

    public void testCreateVector() throws Exception {
        assertTrue(a1.createVector() instanceof Vector);
    }

    public void testCreateSet() throws Exception {
        assertTrue(a1.createSet() instanceof TreeSet);
    }
}