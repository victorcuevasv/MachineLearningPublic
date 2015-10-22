package datamining;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;


public class InformationGain {
	
	
	private ArrayList<String> atts;
	private ArrayList<ArrayList<String>> attValues;
	private ArrayList<ArrayList<String>> matrix;
	
	
	public InformationGain() {
		this.atts = new ArrayList<String>();
		this.matrix = new ArrayList<ArrayList<String>>();
		this.attValues = new ArrayList<ArrayList<String>>();
	}
	
    public static void main( String[] args ) {
        InformationGain program = new InformationGain();
        program.readAtts(args[0], program.atts, program.attValues);
        program.printAtts(program.atts, program.attValues);
        System.out.println();
        program.readData(args[1], program.matrix);
        program.printData(program.matrix);
    }
    
        
    public void readAtts(String attsFile, ArrayList<String> atts,
    		ArrayList<ArrayList<String>> attValues) {
    	try {
    		String line = null;
    		//Read the attributes
			BufferedReader infileBR = new BufferedReader(new FileReader(attsFile));
			while( (line = infileBR.readLine()) != null ) {
				if(line.trim().length() == 0)
					break;
				StringTokenizer tokenizer = new StringTokenizer(line);
				String attName = tokenizer.nextToken();
				atts.add(attName);
				ArrayList<String> valuesList = new ArrayList<String>();
				while(tokenizer.hasMoreTokens()) {
					String attVal = tokenizer.nextToken();
					valuesList.add(attVal);
				}
				attValues.add(valuesList);
			}
			infileBR.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
    }
    
    
    public void readData(String dataFile, ArrayList<ArrayList<String>> matrix) {
    	try {
    		String line = null;
    		//Read the data
			BufferedReader infileBR = new BufferedReader(new FileReader(dataFile));
			while( (line = infileBR.readLine()) != null ) {
				if(line.trim().length() == 0)
					break;
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				ArrayList<String> row = new ArrayList<String>();
				while(tokenizer.hasMoreTokens()) {
					String datum = tokenizer.nextToken();
					row.add(datum);
				}
				matrix.add(row);
			}
			infileBR.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
    }
    
    
    public void printAtts(ArrayList<String> atts,
    		ArrayList<ArrayList<String>> attValues) {
    	for(int i = 0; i < atts.size(); i++) {
    		System.out.print(atts.get(i) + ": ");
    		ArrayList<String> values = attValues.get(i);
    		for(int j = 0; j < values.size(); j++)
    			System.out.print(values.get(j) + " ");
    		System.out.println();
    	}
    }
    
    
    public void printData(ArrayList<ArrayList<String>> matrix) {
    	for(int i = 0; i < matrix.size(); i++) {
    		ArrayList<String> row = matrix.get(i);
    		for(int j = 0; j < row.size(); j++)
    			System.out.print(row.get(j) + ",");
    		System.out.println();
    	}
    }
    
    
}



