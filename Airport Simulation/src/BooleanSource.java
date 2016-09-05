//A BooleanSourc provides a random sequence of boolean values.
/**
 *  
 * @author Bekabil Tolassa
 *
 */
public class BooleanSource {
	private double probability; //The probability of query() returning true.
	/**
	 * @param p
	 * Precondition: This BooleanSource is instantiated. 0 <= p and p <= 1.
	 * Postcondition: This BooleanSource has been initialized so that p is the approximate probability of  
	 * 					returning true in any subsequent activation of of the query method. 
	 * Throws: IllegalArgumentException, indicates that p is outside of its legal range.
	 */
	public BooleanSource(double p) {
		if((p < 0) || (p > 1))
			throw new IllegalArgumentException("Illegal p: " + p);
		probability = p; 
	}
	/**
	 * @param none
	 * @return true or false
	 * Precondition: This Averager is initialized.
	 * Postcondition: random number is generated and computed against value of probability
	 * 					boolean value of true or false is returned.
	 */
	public boolean query() {
		return (Math.random() < probability);
	}
}
