
import java.util.*;

public class Assign1 implements Assign1Interface {

//Level 1
    public ArrayList createList() {
        return new ArrayList();
    }

    public Vector createVector() {
        return new Vector();
    }

    public TreeSet createSet() {
        return new TreeSet();
    }

// Level2
    public void insertToListHead(ArrayList list, Object o) {
        list.add(0,o);
    }

    public void insertToVector(Vector vector, Object o) {
        vector.add(o);
    }

    public void insertToSet(TreeSet set, Object o) {
        set.add(o);
    }

    public Object removeLowestValue(TreeSet set) {
        return set.pollFirst();
    }

// Level 3
    public void insertToListNTimes(ArrayList list, Object o, int n) {
        for (int i = 0; i < n; i++)
            list.add(o);
    }

    public Object removeFromListHead(ArrayList list) {
        if (list.isEmpty())
            return null;
        else
            return list.remove(0);
    }

    public Vector getOddIndexElement(Vector vector) {
		Vector v = new Vector();
		for(int i = 1; i <= vector.size()-1; i=i+2)
			v.add(vector.get(i));
        return v;
    }

    public Double findRangeMax(int fromIndex, int endIndex, List<Double> list) {
        double max = list.get(fromIndex);
		if(fromIndex != endIndex){
			for (int i = fromIndex + 1; i < endIndex + 1; i++) {
				double temp = list.get(i);
				if(temp > max)
					max = temp;
			}
		}
        return max;
    }

// Level 4
    public Integer averageOfSubListOfIntegers(int fromIndex, int endIndex, List<Integer> list) {
        int sum = 0;
        for (int i = fromIndex; i < endIndex + 1; i++)
            sum += list.get(i);
		int average = sum / (endIndex - fromIndex + 1);

        return average;
    }

    public int getObjectPositionOfList(ArrayList list, Object o) {
        ArrayList q1 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext())
            q1.add(it.next());
        int pos = 0;
        while (!q1.isEmpty()) {
            pos++;
            if (q1.remove(0).equals(o))
                return pos;
        }
        return -1;
    }
	
	public ArrayList sortedSpecifiedList(ArrayList list, Collection<String> collection) {
		ArrayList q1 = new ArrayList();
		Iterator it = list.iterator();
        while (it.hasNext())
            q1.add(it.next());
		if(q1.containsAll(collection)){
			Collections.sort(q1);
			return q1;
		}
		
		return new ArrayList();
	}
	
	public boolean listComparing (ArrayList list1, ArrayList list2) {
		if(list1.size() == list2.size()){
			for(int i=0; i<list1.size(); i++) {
				if(list1.get(i) != list2.get(i)){
					return false;
				}
			
			}
			return true;
		}
		return false;
	}
}
