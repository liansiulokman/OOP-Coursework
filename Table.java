package simpledatabase;



import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Table extends Operator{
	private BufferedReader br = null;
	private boolean getAttribute=false;
	private Tuple tuple;
	private ArrayList<String> record = new ArrayList<String>();
	private String names;
	private String types;
	private ArrayList<String> values = new ArrayList<String>();
	private ArrayList<String> values1 = new ArrayList<String>();
	private int rowNumber=0;
	private int countStudent = 0;
	private int countCE = 0;
	
	public Table(String from){
		this.from = from;
		
		//Create buffer reader
		try{
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/datafile/"+from+".csv")));
			String test;
			while((test=br.readLine())!=null){
				record.add(test);
			}
			String row;
			while(rowNumber<record.size()){
				row=record.get(rowNumber);
				if(rowNumber==0){
					names=row;					
				}
				else if(rowNumber==1){
					types=row;
				}
				else{
					if(from.compareTo("CourseEnroll")==0){
						values.add(row);
					}
					else{
						values1.add(row);
					}
				}
				rowNumber++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	
	/**
     * Create a new tuple and return the tuple to its parent.
     * Set the attribute list if you have not prepare the attribute list
     * @return the tuple
     */
	@Override
	public Tuple next(){
		if(from.compareTo("Student")==0){
			if(countStudent<values1.size() && countCE==0){
				String aName = names;
				String aType = types;
				String aValue = values1.get(countStudent);
				Tuple newTuple = new Tuple(names,types,aValue);
				newTuple.setAttributeName();
				newTuple.setAttributeType();
				newTuple.setAttributeValue();
				newTuple.addAttriubteList();
				countStudent++;
				return newTuple;
			}
			else{
				countStudent=0;
				return null;
			}
		}
		else{
			if(countCE<values.size()){
				String aName = names;
				String aType = types;
				String aValue = values.get(countCE);
				Tuple newTuple = new Tuple(names,types,aValue);
				newTuple.setAttributeName();
				newTuple.setAttributeType();
				newTuple.setAttributeValue();
				newTuple.addAttriubteList();
				countCE++;
				return newTuple;
			}
			else{
				countCE=0;
				return null;
			}
		}
	}

	/**
     * The function is used to get the attribute list of the tuple
     * @return the attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return tuple.getAttributeList();
	}
	
}