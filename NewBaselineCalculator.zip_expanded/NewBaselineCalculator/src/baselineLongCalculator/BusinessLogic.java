
package baselineLongCalculator;
/**
 * @author Ravi VIswanadhula
 * */
public class BusinessLogic {
	public CalculatorValue operand1;
	public CalculatorValue operand2;
	public CalculatorValue result;
	public boolean operandError = false;
	public boolean operand1Defined = false;
	public boolean operand2Defined = false;
	
//	public String addOperands(){
//		
//		result = new CalculatorValue(operand1);						// Establish the left operand
//		result.add(operand2);										// add the right operand to it
//		String theAnswer = result.toString();						// No possible errors, so get the 
//		return theAnswer;
//	}

	/**********
	 * This is the subtract routine
	 * 
	 */
	public String subOperands(){
		result = new CalculatorValue(operand1);						// Establish the left operand
		result.sub(operand2);										// add the right operand to it
		String theAnswer = result.toString();						// No possible errors, so get the 
		return theAnswer;									// required to do subtraction
	}

	/**********
	 * This is the multiply routine
	 * 
	 */
	public String mpyOperands(){
		result = new CalculatorValue(operand1);						// Establish the left operand
		result.mpy(operand2);										// add the right operand to it
		String theAnswer = result.toString();						// No possible errors, so get the 
		return theAnswer;									// required to do multiplication
	}

	/**********
	 * This is the divide routine.  If the divisor is zero, the divisor is declared to be invalid.
	 * 
	 */
	public String divOperands(){
		result = new CalculatorValue(operand1);						// Establish the left operand
		if(operand2.measuredValue == 0) {
			return "Error";
			
		}
		result.div(operand2);										// add the right operand to it
		String theAnswer = result.toString();						// No possible errors, so get the 
		return theAnswer;									// required to do division
	}

	public String addOperands() {
		// TODO Auto-generated method stub
		result = new CalculatorValue(operand1);						// Establish the left operand
		result.add(operand2);										// add the right operand to it
		String theAnswer = result.toString();						// No possible errors, so get the 
		return theAnswer;

	}
}
