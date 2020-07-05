package baseLineCalculator;
/**
 * @author V.Ravi
 *
 */
public class BusinessLogic {
	private CalculatorValue operand1;
	private CalculatorValue operand2;
	private CalculatorValue result;
	private String operand1ErrorMessage;
	private String operand2ErrorMessage;
	private boolean operandError;
	private boolean operand1Defined;
	private boolean operand2Defined;

	public BusinessLogic() {
		super();
		this.operandError = false;
		this.operand1Defined = false;
		this.operand2Defined = false;
		
		this.operand1 = new CalculatorValue();
		this.operand2 = new CalculatorValue();
		this.result = new CalculatorValue();
		
	}
	/*******************************************************************************************************
	 * This portion of the class is the business logic that defines the computation that takes place when
	 *  the various calculator buttons (add, subtract, multiply, and divide) are pressed.
	 */


	/**.
	 * This is the subtract routine
	 * 
	 */
	public String subOperands(){
		setResult(new CalculatorValue(getOperand1()));						// Establish the left operand
		getResult().sub(getOperand2());										// add the right operand to it
		String theAnswer = getResult().toString();						// No possible errors, so get the 
		return theAnswer;								
	}
	/**.
	 * This is the add routine
	 * 
	 */
	public String addOperands(){
    	setResult(new CalculatorValue(getOperand1()));						// Establish the left operand
    	getResult().add(getOperand2());										// add the right operand to it
		String Res = getResult().toString();						// No possible errors, so get the 
		return Res;
	}

	/**.
	 * This is the divide routine.  If the divisor is zero, the divisor is declared to be invalid.
	 * 
	 */
	public String divOperands(){
		setResult(new CalculatorValue(getOperand1()));						// Establish the left operand
		if (getOperand2().measuredValue != 0) {
		getResult().div(getOperand2());										// add the right operand to it
		String theAnswer = getResult().toString();						// No possible errors, so get the 
		return theAnswer;
		} else {
			return "null";
			}
		}

	/**.
	 * This is the multiply routine.
	 * 
	 */
	public String mpyOperands(){
		setResult(new CalculatorValue(getOperand1()));						// Establish the left operand
		getResult().mpy(getOperand2());										// add the right operand to it
		String theAnswer = getResult().toString();						// No possible errors, so get the 
		return theAnswer;
	}

	/**.
	 * This is the Square root routine.
	 * 
	 */
	public String sqrtOperands(){
		if (getOperand1().measuredValue >= 0) {
		setResult(new CalculatorValue(getOperand1()));						// Establish the left operand
		getResult().sqrt();										// add the right operand to it
		String theAnswer = getResult().toString();						// No possible errors, so get the 
		return theAnswer;
	} else {
		return null;
		}
	}

	/**.
	 * This is the power routine.
	 * 
	 */
	public String powOperands(){
		setResult(new CalculatorValue(getOperand1()));						// Establish the left operand
		if (getOperand2().measuredValue == 0) {
			return "1";
		}
		getResult().pow(getOperand2());										// add the right operand to it
		String theAnswer = getResult().toString();						// No possible errors, so get the 
		return theAnswer;
	}
	
	/**.
	 * @param op1UnitCode unit code for operand1
	 * @param op2UnitCode unit code for operand2
	 * @return boolean value based on their category
	 */
	public boolean isUnitsCompatible(String op1UnitCode, String op2UnitCode) {
		operand1.unitCode = Integer.parseInt(op1UnitCode != null ? op1UnitCode : "0");
		operand2.unitCode = Integer.parseInt(op2UnitCode != null ? op1UnitCode : "0");
		return operand1.isUnitsCompatible(operand2);
	}
	
	/**.
	 * @param u1 operand1 unit code
	 * @param u2 operand2 unit code
	 * @return converted value
	 */
	public String isUNitsCompatibleForMPYDIV(int u1, int u2) {
		// TODO Auto-generated method stub
		operand1.unitCode = u1;
		operand2.unitCode = u2;
		return operand1.isUnitsCompatibleForMpyDiv(operand2);
	}

	/**.
	 * @return operand1
	 */
	public CalculatorValue getOperand1() {
		return operand1;
	}
	/**
	 * @param mv sets the measured value of operand 2
	 * @return boolean value based on operand2defined
	 */
	public boolean setOperand2(String mv, String ev) {
		this.operand2Defined = false;
		this.operand2 = new CalculatorValue(mv, ev);
		operand2ErrorMessage = operand2.getErrorMessage();
		if(operand2ErrorMessage.length() > 0) {
			return false;
		}
		this.operand2Defined = true;
		return true;
	}

	/**.
	 * @param mv sets the measured value of operand 1
	 * @return boolean value based on operand1defined
	 */
	public boolean setOperand1(String mv, String ev) {
		this.operand1Defined = false;
		this.operand1 = new CalculatorValue(mv, ev);
		operand1ErrorMessage = operand1.getErrorMessage();
		if(operand1ErrorMessage.length() > 0) {
			return false;
		}
		this.operand1Defined = true;
		return true;
	}
	/**
	 * @return operand1 error message
	 */
	public String getOperand2ErrorMessage() {
		return operand1ErrorMessage;
	}
	/**
	 * @return operand2 error message
	 */
	public String getOperand1ErrorMessage() {
		return operand2ErrorMessage;
	}
	/**
	 * @return operand 2
	 */
	public CalculatorValue getOperand2() {
		return operand2;
	}
    /**
     * @param operand2 sets operand 2
     */
	public void setOperand2(CalculatorValue operand2) {
		this.operand2 = operand2;
	}
    /**
     * @return result of operation
     */
	public CalculatorValue getResult() {
		return result;
	}

	/**
	 * @return boolean value based on the operand error
	 */
	public boolean isOperandError() {
		return operandError;
	}
	
	/**
	 * @param set the result
	 */
	public void setResult(CalculatorValue result) {
		this.result = result;
	}
	/**
	 * @return boolean value based on operand2 defined
	 */
	public boolean isOperand2Defined() {
		return operand2Defined;
	}
	/**
	 * @param operand2Defined sets the operand2defined
	 */
	public void setOperand2Defined(boolean operand2Defined) {
		this.operand2Defined = operand2Defined;
	}
	/**
	 * @return boolean value based on operand1defined
	 */
	public boolean isOperand1Defined() {
		return operand1Defined;
	}
	/**
	 * @param operand1Defined sets the operand1defined
	 */
	public void setOperand1Defined(boolean operand1Defined) {
		this.operand1Defined = operand1Defined;
	}
	
}
