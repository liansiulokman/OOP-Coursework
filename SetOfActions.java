import java.util.ArrayList;

public class SetOfActions {

    /**
     * When users click the Biographies button, the GUI will invoke this method to add a Biographies object into a list of Books.
     * @param st the list which contains all the added books
     * @param name the name of the Books the GUI gets from the name field
     * @param price the basic price of the Books the GUI gets from the price field
	 * @param quantity the quantity of the Books needed to be added in the list
     */
    public static void addBiographies(ArrayList<Books> st, String name, double price, int quantity) {
        for(int i = 0; i < quantity; i++){
			Books s = new Biographies(name, price);
			st.add(s);
		}
    }

    /**
     * When users click the History button, the GUI will invoke this method to add a History object into a list of Books.
     * @param st
     * @param name
     * @param price
	 * @param quantity
     */
    public static void addHistory(ArrayList<Books> st, String name, double price, int quantity) {
		for(int i = 0; i < quantity; i++){
			Books s = new History(name, price);
			st.add(s);
		}
    }

    /**
     * When users click the Travel button, the GUI will invoke this method to add a Travel object into a list of Books.
     * @param st
     * @param name
     * @param price
	 * @param quantity
     */
    public static void addTravel(ArrayList<Books> st, String name, double price, int quantity) {
		for(int i = 0; i < quantity; i++){
			Books s = new Travel(name, price);
			st.add(s);
		}
	}

    /**
     * When users click the Journals button, the GUI will invoke this method to add an Journals object into a list of Books.
     * @param st
     * @param name
     * @param price
	 * @param quantity
     */
    public static void addJournals(ArrayList<Books> st, String name, double price, int quantity) {
		for(int i = 0; i < quantity; i++){
			Books s = new Journals(name, price);
			st.add(s);
		}
    }

    /**
     * When users click the ScienceFiction button, the GUI will invoke this method to add an ScienceFiction object into a list of Books.
     * @param st
     * @param name
     * @param price
	 * @param quantity
     */
    public static void addScienceFiction(ArrayList<Books> st, String name, double price, int quantity) {
		for(int i = 0; i < quantity; i++){
			Books s = new ScienceFiction(name, price);
			st.add(s);
		}
    }

    /**
     * When users click the Mystery button, the GUI will invoke this method to add a Mystery object into a list of Books.
     * @param st
     * @param name
     * @param price
	 * @param quantity
     */
    public static void addMystery(ArrayList<Books> st, String name, double price, int quantity) {
		for(int i = 0; i < quantity; i++){
			Books s = new Mystery(name, price);
			st.add(s);
		}
    }

    /**
     * When users click the Horror button, the GUI will invoke this method to add an Horror object into a list of Books.
     * @param st
     * @param name
     * @param price
	 * @param quantity
     */
    public static void addHorror(ArrayList<Books> st, String name, double price, int quantity) {
		for(int i = 0; i < quantity; i++){
			Books s = new Horror(name, price);
			st.add(s);
		}
    }

	 /**
     * When users click the Romance button, the GUI will invoke this method to add an Romance object into a list of Books.
     * @param st
     * @param name
     * @param price
	 * @param quantity
     */
    public static void addRomance(ArrayList<Books> st, String name, double price, int quantity) {
		for(int i = 0; i < quantity; i++){
			Books s = new Romance(name, price);
			st.add(s);
		}
    }
	
    /**
     * The GUI frequently invokes this method to display the total price.
     * @param st the list of all added Books
     * @return the total value of all the Books in the list
     */
    public static double getTotalPrice(ArrayList<Books> st) {
        double sum = 0;
        for (Books s : st)
            sum += s.getPrice();
        return sum;
    }

    /**
     * When users click the Increase price button, the GUI will invoke this method to increase the prices of selected Book categories,
     * and the new total price will be displayed on the GUI
     * @param st the list of all added Books
	 * @param nfict the state of the checkbox of NonFiction, if the checkbox of NonFiction is checked, then nfict is true
	 * @param fict the state of the checkbox of Fiction, if the checkbox of Fiction is checked, then fict is true
     * @return the new total prices of all the Books in the list after increased
     */
    public static double increaseTotalPrice(ArrayList<Books> st, boolean nfict, boolean fict) {
        for (Books s : st) {
		if((s.getClass().getSuperclass().getName() == "NonFiction" && nfict == true) || (s.getClass().getSuperclass().getName() == "Fiction" && fict == true))
            s.increasePrice();
        
		}
        return getTotalPrice(st);
    }

    /**
     * When users click the Decrease price button, the GUI will invoke this method to decrease the prices of selected Book categories,
     * and the new total price will be displayed on the GUI
     * @param st the list of all added Books
	 * @param nfict the state of the checkbox of NonFiction, if the checkbox of NonFiction is checked, then nfict is true
	 * @param fict the state of the checkbox of Fiction, if the checkbox of Fiction is checked, then fict is true
     * @return the new total prices of all the Books in the list after decreased
     */	
	public static double decreaseTotalPrice(ArrayList<Books> st, boolean nfict, boolean fict) {
        for (Books s : st) {
			if((s.getClass().getSuperclass().getName() == "NonFiction" && nfict == true) || (s.getClass().getSuperclass().getName() == "Fiction" && fict == true)){
				if(!s.testDecreasePrice())
					return -1;
			}
		}
		for (Books s : st) {
			if((s.getClass().getSuperclass().getName() == "NonFiction" && nfict == true) || (s.getClass().getSuperclass().getName() == "Fiction" && fict == true)){
				s.decreasePrice();
			}
		}

        return getTotalPrice(st);
    }
}
