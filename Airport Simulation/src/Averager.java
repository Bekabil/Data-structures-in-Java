//An Average computes an average of a sequence of numbers.
/**
 *  
 * @author Bekabil Tolassa
 *
 */
public class Averager {
	private int count; //how many numbers have been given to this average.
	private double sum; // Sum of all the numbers given to this averager.
	/**
	 * Precondition: This Averager is instantiated.
	 * Postcondition: This Averager has been initialized and is ready to accept a sequence of numbers.
	 */
	public Averager() {
		count = 0;
		sum = 0;
	}
	/**
	 * @param value
	 * @return none
	 * Precondition: howManyNumbers() < Integer.MAX_VALUE
	 * Postcondition: This Averager has accepted value as the next number in the sequence of numbers.
	 * Throws: IllegalStateException. Indicates tha howManyNumbers() is Integer.MAX_VALUE.
	 */
	public void addNumber(double value) {
		if(count == Integer.MAX_VALUE)
			throw new IllegalStateException("Too many numbers.");
		count++;
		sum += value;
	}
	/**
	 * @param none
	 * @return the average of all the numbers that have been given to this Averager.
	 * 			if howManyNumbers() is zero, this method returns Double.NaN (not a number).
	 * Precondition: 
	 * Postcondition: double value of average of numbers is returned. Or not a number value is returned.
	 */
	public double average() {
		if (count == 0){
			return Double.NaN;
		}
		else
		{
			return sum / count;
		}
	}
	/**
	 * @param none
	 * @return count
	 * Precondition: this Averager is initialized.
	 * Postcondition: the count of how many numbers have been given to this Averager.
	 */
	public int howManyNumbers() {
		return count;
	}
	
	
	
}
