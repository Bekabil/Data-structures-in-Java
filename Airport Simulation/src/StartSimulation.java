import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;
/**
 * @author Bekabil
 * class: ICS 240
 * 
 */
public class StartSimulation {

	private double arrivalProb; 
	private double departureProb;
	private int landingTime;
	private int takeOffTime; 
	private int timeOutOfFuel; 
	private int numOfRunWays; 
	private int totalTime;
	private String information;
	private int next;
	private int currentSecond;
	private int planesCrashed;
	private static int totalPlanesCrashed;
	
	private Averager arrialWaitTimes;
	private Averager departureWaitTimes;
	
	
	private BooleanSource arrival;
	private BooleanSource departure; 
	
	private Queue <Integer> departurePlanes;
	private Queue <Integer> arrivalPlanes;
	
	
	private Runway[] arrayOfRunway;
	
	private DecimalFormat format;
	
	
	public StartSimulation() {
		
	}
/**
 
 * @param arrivalProb
 * @param departureProb
 * @param landingTime
 * @param takeOffTime
 * @param timeOutOfFuel
 * @param numOfRunWays
 * @param totalTime
 * constructor StartSimulation
 */
public StartSimulation(double arrivalProb, double departureProb, 
						int landingTime, int takeOffTime,
						int timeOutOfFuel, int numOfRunWays, int totalTime) {
	
	this.arrivalProb= arrivalProb;
	this.departureProb= departureProb;
	this.landingTime= landingTime;
	this.takeOffTime= takeOffTime;
	this.timeOutOfFuel= timeOutOfFuel;
	this.numOfRunWays= numOfRunWays;
	this.totalTime= totalTime;
	
	information= "\n";
	next= 0;
	currentSecond= 0;
	planesCrashed= 0;
	arrayOfRunway = new Runway[this.numOfRunWays];
	
	arrialWaitTimes = new Averager();
	departureWaitTimes = new Averager();
	arrivalPlanes = new LinkedList<Integer>();
	departurePlanes = new LinkedList<Integer>();
	arrival = new BooleanSource(this.arrivalProb);
	departure = new BooleanSource(this.departureProb);
	
	format = new DecimalFormat("#,###,##0.00");
	}
	
		
public void simulationStarter ( ) {

		for(int i=0; i < arrayOfRunway.length; i++){
			arrayOfRunway[i] = new Runway();
		}
		
		
		if(landingTime <= 0 || arrivalProb < 0 || arrivalProb > 1 || totalTime < 0)
			throw new IllegalArgumentException("Values out of range.");
		for(currentSecond = 0; currentSecond < totalTime; currentSecond++ ) {
			//simulate the passage of one second of time.
			
			//check whether a new customer has arrived.
			if(arrival.query())
				arrivalPlanes.add(currentSecond);
				
			if(departure.query())
				departurePlanes.add(currentSecond);
			
			
			for(Runway runway : arrayOfRunway){
				//check whether we can start simulation.
				if ((!runway.isBusy()) && (!arrivalPlanes.isEmpty())) {
					while(!arrivalPlanes.isEmpty()) {
						next = arrivalPlanes.remove();
						if((currentSecond - next) > timeOutOfFuel  ){
							planesCrashed++;
						}else{
							arrialWaitTimes.addNumber(currentSecond - next);
							runway.makeRunwayBusy(landingTime);
							break;
						}
						
					}
					
				}else if((!runway.isBusy()) && (!departurePlanes.isEmpty())) {
					next = departurePlanes.remove();
					departureWaitTimes.addNumber(currentSecond - next);
					runway.makeRunwayBusy(takeOffTime);
				}
				//subtract one second from the remaining time in the current cycle.
				runway.reduceRemainingTime();
			}
			
		}
		
		totalPlanesCrashed += planesCrashed;
		

	}
	public String getSimilationReport () {
		
		//System.out.printf("kkkk", 4f, 5 );
		
		String output = "\n";
		output += "Probability of airplane arrival for landing: " + arrivalProb + "\n";
		output += "Departure rate: " + departureProb + "\n";
		output += "Seconds for one airplane to land: " + landingTime + "\n";
		output += "Time to take off: " + takeOffTime + "\n";	
		output += "Minutes of fuel remaining: " + timeOutOfFuel + "\n";
		output += "Number of runways: " + numOfRunWays + "\n";
		output += "Total simulation in seconds: " + currentSecond + "\n\n";
		output += "  Simulation report... \n";
		
		information += "Number of planes departed: " + departureWaitTimes.howManyNumbers() + "\n";
		information += "Number of planes landed: " + arrialWaitTimes.howManyNumbers() + "\n";
		information += "Number of planes crushed: " + planesCrashed + "\n"; 
		information += "Average time planes spends in the departing queue: " + format.format(departureWaitTimes.average()) + "\n";
		information += "Average time planes spends in the landing queue: " + format.format(arrialWaitTimes.average()) + "\n\n";
		
		 output += information;
		 
		return output;
	}
	
	//method saveReport
    public void saveReport(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
    	
    	
    	String newReport = "";
    	String oldreport = loadReport(file);
    	Date reportDate = new Date();
    	newReport += oldreport; 
    	
    	newReport += "\nThis similation report was saved on: " + reportDate + "\n" ;
    	newReport += information;
    	
        //create an output stream for file ArraySalesObjects
        ObjectOutputStream output = new ObjectOutputStream(
            new FileOutputStream(file));

        //array list ticket and snack are written to the file
        output.writeObject(newReport);
        

        //close output stream
        output.close();

    }

    //method loadReport
    public String loadReport(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
    	String temp="";
    	if (file == null) {
    		return "";
    	}
    	try{
            ObjectInputStream input = new ObjectInputStream(
            new FileInputStream(file));
       
        
                
        temp = (String) input.readObject();
    	
        //close input stream 	
        input.close();
    	}
    	catch(FileNotFoundException e) {
    		System.out.println("Sorry, your trial reports is not save. This functionality is under construction!");
    	}
        //string temp is returned	
        return temp;
    }
	
    public String getNumOfCrashes () {
    	return "\n " + totalPlanesCrashed;
    }
	
	
} 


