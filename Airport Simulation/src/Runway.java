

/**
 *  
 * @author Bekabil Tolassa
 *
 */
public class Runway {
	
	private int secondsForOnRunway; //seconds for use of runway
	private int RunTimeLeft; //seconds until this simulation is no longer busy
	/**
	 * @param s the number of seconds required for one cycle of this simulation
	 * Precondition: This simulation is instantiated.
	 * Postcondition: This simulation has been initialized so that it takes s seconds to complete one cycle. 
	 */
	public Runway() {
		secondsForOnRunway = 0;
		RunTimeLeft = 0;
		
	}
	/**
	 * @param none
	 * @return true or false.
	 * Precondition:
	 * Postcondition: whether this simulation is currently busy or not is determined.
	 * 					boolean value true or false is returned.
	 */
	public boolean isBusy() {
		return (RunTimeLeft > 0);
	}
	/**
	 * @param none
	 * @return none
	 * Precondition:
	 * Postcondition: the remaining time is the current 
	 * 				  simulation cycle has been reduced by one second.
	 */
	public void reduceRemainingTime() {
		if(RunTimeLeft > 0)
			RunTimeLeft--;
	}
	/**
	 * @param
	 * @return
	 * Precondition: isBusy() is false.
	 * Postcondition: This simulation has started simulating one cycle. Therefore, isBusy() will return true
	 * 					until the required number of simulated seconds has passed.
	 * Throws: IllegalStateException, indicates that this simulation is busy
	 */
	public void makeRunwayBusy(int time) {
		
		if(RunTimeLeft > 0)
			throw new IllegalStateException("Runway is already busy.");
		secondsForOnRunway=time;
		RunTimeLeft = secondsForOnRunway;
	}
}
