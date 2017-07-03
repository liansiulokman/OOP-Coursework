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
        // Add your code here
        String temp = "Biographies "+name;
        Books newBiographies = new Biographies(temp, price);
        for(int i=0; i<quantity; i++){
            st.add(newBiographies);
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
        // Add your code here
        String temp = "History "+name;
        Books newHistory = new History(temp, price);
        for(int i=0; i<quantity; i++){
            st.add(newHistory);
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
        // Add your code here
        String temp = "Travel "+name;
        Books newTravel = new Travel(temp, price);
        for(int i=0; i<quantity; i++){
            st.add(newTravel);
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
        // Add your code here
        String temp = "Journals "+name;
        Books newJournals = new Journals(temp, price);
        for(int i=0; i<quantity; i++){
            st.add(newJournals);
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
        // Add your code here
        String temp = "ScienceFiction "+name;
        Books newScienceFiction = new ScienceFiction(temp, price);
        for(int i=0; i<quantity; i++){
            st.add(newScienceFiction);
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
        // Add your code here
        String temp = "Mystery "+name;
        Books newMystery = new Mystery(temp, price);
        for(int i=0; i<quantity; i++){
            st.add(newMystery);
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
        // Add your code here
        String temp = "Horror "+name;
        Books newHorror = new Horror(temp, price);
        for(int i=0; i<quantity; i++){
            st.add(newHorror);
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
        // Add your code here
        String temp = "Romance "+name;
        Books newRomance = new Romance(temp, price);
        for(int i=0; i<quantity; i++){
            st.add(newRomance);
        }
    }
    
    /**
     * The GUI frequently invokes this method to display the total price.
     * @param st the list of all added Books
     * @return the total value of all the Books in the list
     */
    public static double getTotalPrice(ArrayList<Books> st) {
        // Add your code here
        double total=0;
        for(int x=0; x<st.size(); x++){
            total += st.get(x).getPrice();
        }
        return total;
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
        // Add your code here
        double result=getTotalPrice(st);
        int count=0;
        if(nfict==true){
            int loop = 0;
            boolean checkNonFict=false;
            int[] books=new int[4];
            boolean[] nonFictBooks = new boolean[4];
            for(int y=0; y<st.size();y++){
                String temp = st.get(y).name.toString();
                String[] split = temp.split(" ",2);
                String category = split[0];
                if((category.compareTo("Biographies")==0)||(category.compareTo("History")==0)||(category.compareTo("Journals")==0)||(category.compareTo("Travel")==0)){
                    checkNonFict=true;
                    count=y;
                    
                    if(category.compareTo("Biographies")==0){
                        nonFictBooks[0]=true;
                        books[0]=y;
                    }
                    else if(category.compareTo("History")==0){
                        nonFictBooks[1]=true;
                        books[1]=y;
                    }
                    else if(category.compareTo("Journals")==0){
                        nonFictBooks[2]=true;
                        books[2]=y;
                    }
                    else if(category.compareTo("Travel")==0){
                        nonFictBooks[3]=true;
                        books[3]=y;
                    }
                    
                }
            }
            if(checkNonFict==true){
                for(int j=0;j<nonFictBooks.length;j++){
                    if(nonFictBooks[j]==true){
                        st.get(books[j]).increasePrice();
                    }
                }
            }
            result=getTotalPrice(st);
        }
        if(fict==true){
            int loop = 0;
            boolean checkFict=false;
            int[] books=new int[4];
            boolean[] fictBooks = new boolean[4];
            for(int x=0; x<st.size();x++){
                String temp = st.get(x).name.toString();
                String[] split = temp.split(" ",2);
                String category = split[0];
                if((category.compareTo("Horror")==0)||(category.compareTo("Mystery")==0)||(category.compareTo("Romance")==0)||(category.compareTo("ScienceFiction")==0)){
                    checkFict=true;
                    count=x;

                    if(category.compareTo("Horror")==0){
                        fictBooks[0]=true;
                        books[0]=x;
                    }
                    else if(category.compareTo("Mystery")==0){
                        fictBooks[1]=true;
                        books[1]=x;
                    }
                    else if(category.compareTo("Romance")==0){
                        fictBooks[2]=true;
                        books[2]=x;
                    }
                    else if(category.compareTo("ScienceFiction")==0){
                        fictBooks[3]=true;
                        books[3]=x;
                    }
                }
            }
            if(checkFict==true){
                for(int j=0;j<fictBooks.length;j++){
                    if(fictBooks[j]==true){
                        st.get(books[j]).increasePrice();
                    }
                }
            }
            result=getTotalPrice(st);
        }
        return result;
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
        // Add your code here
        double result=getTotalPrice(st);
        int count=0;
        if(nfict==true){
            int loop = 0;
            boolean checkNonFict=false;
            int[] books=new int[4];
            boolean[] nonFictBooks = new boolean[4];
            for(int y=0; y<st.size();y++){
                String temp = st.get(y).name.toString();
                String[] split = temp.split(" ",2);
                String category = split[0];
                if((category.compareTo("Biographies")==0)||(category.compareTo("History")==0)||(category.compareTo("Journals")==0)||(category.compareTo("Travel")==0)){
                    checkNonFict=true;
                    count=y;
                    
                    if(category.compareTo("Biographies")==0){
                        nonFictBooks[0]=true;
                        books[0]=y;
                    }
                    else if(category.compareTo("History")==0){
                        nonFictBooks[1]=true;
                        books[1]=y;
                    }
                    else if(category.compareTo("Journals")==0){
                        nonFictBooks[2]=true;
                        books[2]=y;
                    }
                    else if(category.compareTo("Travel")==0){
                        nonFictBooks[3]=true;
                        books[3]=y;
                    }
                    
                }
            }
            if(checkNonFict==true){
                for(int j=0;j<nonFictBooks.length;j++){
                    if(nonFictBooks[j]==true){
                        if((st.get(books[j]).getPrice()>20))
                            st.get(books[j]).decreasePrice();
                    }
                }
            }
            result=getTotalPrice(st);
        }
        if(fict==true){
            int loop = 0;
            boolean checkFict=false;
            int[] books=new int[4];
            boolean[] fictBooks = new boolean[4];
            for(int z=0; z<st.size();z++){
                String temp = st.get(z).name.toString();
                String[] split = temp.split(" ",2);
                String category = split[0];
                if((category.compareTo("Horror")==0)||(category.compareTo("Mystery")==0)||(category.compareTo("Romance")==0)||(category.compareTo("ScienceFiction")==0)){
                    checkFict=true;
                    count=z;

                    if(category.compareTo("Horror")==0){
                        fictBooks[0]=true;
                        books[0]=z;
                    }
                    else if(category.compareTo("Mystery")==0){
                        fictBooks[1]=true;
                        books[1]=z;
                    }
                    else if(category.compareTo("Romance")==0){
                        fictBooks[2]=true;
                        books[2]=z;
                    }
                    else if(category.compareTo("ScienceFiction")==0){
                        fictBooks[3]=true;
                        books[3]=z;
                    }
                }
            }
            if(checkFict==true){
                for(int j=0;j<fictBooks.length;j++){
                    if(fictBooks[j]==true){
                        if((st.get(books[j]).getPrice()>20))
                            st.get(books[j]).decreasePrice();
                    }
                }
            }
            result=getTotalPrice(st);
        }
        return result;
    }
}
