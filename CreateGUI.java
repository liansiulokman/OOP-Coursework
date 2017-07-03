import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class CreateGUI extends JFrame implements ActionListener{

    // This list is to store all the added books
    private ArrayList<Books> st = new ArrayList<Books>();
    private static SetOfActions setOfActions = new SetOfActions();
    // These two strings may be useful for you to display messages on the screen.
    private String s1 = "The total number of all books is: ";
    private String s2 = "The total value of all books is: ";
    // These are the initial states of the Non-Fiction and Fiction Checkbox
    private boolean nfict = false;
    private boolean fict = false;

    private double totalPrice = 0;
    private int totalNumber = 0;
    private JTextField bkPrice;
    private JTextField bkQuantity;
    private JTextField bkTitle;
    private JLabel priceLbl;
    private JLabel numberLbl;
    
    public CreateGUI() {
        // Add your code here, and you can add some private helper methods for your convenience.
        
        super("GUI");
        this.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(1,2));
        JPanel leftPanel = new JPanel(new GridLayout(7,2));
        JPanel rightPanel = new JPanel(new GridLayout(7,1));
        //panel.setPreferredSize(new Dimension(300,200));

        final JTextField bookName = new JTextField(5);
        bkTitle = bookName;
        leftPanel.add(new JLabel("Book Name"));
        leftPanel.add(bookName);
        
        final JTextField bookPrice = new JTextField(5);
        bkPrice = bookPrice;
        leftPanel.add(new JLabel("Price"));
        leftPanel.add(bookPrice);

        final JTextField quantity = new JTextField(5);
        bkQuantity = quantity;
        leftPanel.add(new JLabel("Quantity"));
        leftPanel.add(quantity);


        final JButton b1 = new JButton("Biographies");
        JButton b2 = new JButton("History");
        JButton b3 = new JButton("Travel");
        JButton b4 = new JButton("Journals");
        JButton b5 = new JButton("Science Fiction");
        JButton b6 = new JButton("Mystery");
        JButton b7 = new JButton("Horror");
        JButton b8 = new JButton("Romance");

        rightPanel.add(new JLabel(""));
        JLabel p = new JLabel(s2+(int)totalPrice);
        priceLbl = p;
        rightPanel.add(p);
        
        JLabel v = new JLabel(s1+totalNumber);
        numberLbl = v;
        rightPanel.add(v);

        b1.setActionCommand("biographies");
        b1.addActionListener(this);
        leftPanel.add(b1);
        b2.setActionCommand("history");
        b2.addActionListener(this);
        leftPanel.add(b2);
        b5.setActionCommand("scienceFiction");
        b5.addActionListener(this);
        leftPanel.add(b5);
        b6.setActionCommand("mystery");
        b6.addActionListener(this);
        leftPanel.add(b6);
        
        JPanel rightMid1 = new JPanel(new GridLayout(1,2));
        JPanel rightMid2 = new JPanel(new GridLayout(1,2));

        b3.setActionCommand("travel");
        b3.addActionListener(this);
        rightMid1.add(b3);
        b4.setActionCommand("journals");
        b4.addActionListener(this);
        rightMid1.add(b4);

        rightPanel.add(rightMid1);

        b7.setActionCommand("horror");
        b7.addActionListener(this);
        rightMid2.add(b7);
        b8.setActionCommand("romance");
        b8.addActionListener(this);
        rightMid2.add(b8);

        rightPanel.add(rightMid2);
        
        final JCheckBox nonF = new JCheckBox("Non-Fiction");
        final JCheckBox fiction = new JCheckBox("Fiction");
        nonF.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(nonF.isSelected()==true){
                    nfict = true;
                }
                else
                    nfict = false;
            }
        });
        leftPanel.add(nonF);
        fiction.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(fiction.isSelected()==true){
                    fict = true;
                }
                else
                    fict = false;
            }
        });
        leftPanel.add(fiction);

        JButton increase = new JButton("Increase Price");
        increase.setBackground(Color.green);
        final JButton decrease = new JButton("Decrease Price");
        decrease.setBackground(Color.red);
        increase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent et){
                totalPrice = setOfActions.increaseTotalPrice(st, nfict, fict);
                priceLbl.setText(s1+totalPrice);
            }
        });
        leftPanel.add(increase);
        decrease.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent et){
                double temp = setOfActions.getTotalPrice(st);
                totalPrice = setOfActions.decreaseTotalPrice(st, nfict, fict);
                if(totalPrice <= 0){
                    JOptionPane.showMessageDialog(decrease, "The price of books cannot be lower than 0", "Error Message", JOptionPane.ERROR_MESSAGE);
                    totalPrice = temp;
                }
                priceLbl.setText(s1+totalPrice);
            }
        });
        leftPanel.add(decrease);
        
        panel.add(leftPanel);
        panel.add(rightPanel);
        this.add(panel, BorderLayout.CENTER);
        this.setSize(800,300);
        this.setLocation(100,100);
        this.setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent e){
        //action
        boolean checkPrice = false;
        boolean checkQuantity = false;
        JButton component = new JButton(e.toString());
        String msg = "Please make sure you have input name, price and quantity the price and quantity must be a number";
        Double price = -1.00;
        int q = -1;
        try{
            q = Integer.parseInt(bkQuantity.getText());
            price = Double.parseDouble(bkPrice.getText());
            if(q==(int)q)
                checkQuantity = true;
            if(price==(Double)price)
                checkPrice = true;
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(component, msg, "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        if(((bkTitle.getText().compareTo("")==0)||(price<=0)||(q<=0))&&(checkPrice==true)&&(checkQuantity==true)){
            JOptionPane.showMessageDialog(component, msg, "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        else if(checkPrice==true && checkQuantity==true){
            double total;
            if(e.getActionCommand().compareTo("biographies")==0)
                setOfActions.addBiographies(st,bkTitle.getText(),price,q);
            if(e.getActionCommand().compareTo("history")==0)
                setOfActions.addHistory(st,bkTitle.getText(),price,q);
            if(e.getActionCommand().compareTo("travel")==0)
                setOfActions.addTravel(st,bkTitle.getText(),price,q);
            if(e.getActionCommand().compareTo("journals")==0)
                setOfActions.addJournals(st,bkTitle.getText(),price,q);
            if(e.getActionCommand().compareTo("scienceFiction")==0)
                setOfActions.addScienceFiction(st,bkTitle.getText(),price,q);
            if(e.getActionCommand().compareTo("mystery")==0)
                setOfActions.addMystery(st,bkTitle.getText(),price,q);
            if(e.getActionCommand().compareTo("horror")==0)
                setOfActions.addHorror(st,bkTitle.getText(),price,q);
            if(e.getActionCommand().compareTo("romance")==0)
                setOfActions.addRomance(st,bkTitle.getText(),price,q);
            totalPrice = setOfActions.getTotalPrice(st);
            totalNumber += q;
            priceLbl.setText(s1+totalPrice);
            numberLbl.setText(s2+totalNumber);
            bkTitle.setText(null);
            bkPrice.setText(null);
            bkQuantity.setText(null);
        }
    }
}
