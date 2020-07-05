package baseLineCalculator;

/**
 * Test cases for integer calculator 
 * 
 * @author Ravi V
 *
 */
public class TestCase {
	public static void main(String[] args) {
		int noPassed = 0;
		int noFailed = 0;

		// TestCase 1.
		CalculatorValue operand1 = new CalculatorValue("10");
		CalculatorValue operand2 = new CalculatorValue("5");
		CalculatorValue result = new CalculatorValue(operand1);
		result.add(operand2);
		result.sub(operand1);
		result.mpy(new CalculatorValue(5));
		result.div(operand1);
		if (result.measuredValue == 2) {
			++noPassed;
			System.out.println("Result:\t" + result.toString());
		} else {
			System.out.println("TestCase 1");
			System.out.println(result.toString());
			++noFailed;
		}

		// TestCase 2.
		operand1 = new CalculatorValue(1000);
		operand2 = new CalculatorValue("abcd");
		result = new CalculatorValue(operand1);
		result.sub(operand2);
		if (result.measuredValue == 1000 && "***Error*** Invalid value".equals(operand2.getErrorMessage())) {
			++noPassed;
			System.out.println("Result:\t" + result.toString());
		} else {
			System.out.println("TestCase 2");
			System.out.println("Result:\t" + result.toString());
			System.out.println("Error Message:\t" + operand2.errorMessage);
			++noFailed;
		}

		// TestCase 3.
		operand1 = new CalculatorValue("587");
		operand2 = new CalculatorValue("");
		result = new CalculatorValue(operand1);
		result.mpy(operand2);
		if (result.measuredValue == 0 && "***Error*** Input is empty".equals(operand2.errorMessage)) {
			++noPassed;
			System.out.println("Result:\t" + result.toString());
		} else {
			System.out.println("TestCase 3");
			System.out.println("Result:\t" + result.toString());
			System.out.println("Error Message:\t" + operand2.errorMessage);
			++noFailed;
		}

		// TestCase 4.
		operand1 = new CalculatorValue("121212 1");
		operand2 = new CalculatorValue(753951852);
		operand2.setValue(486527);
		result = new CalculatorValue();
		result.setValue(operand2);
		if (result.measuredValue == 486527 && "***Error*** Excess data".equals(operand1.errorMessage)) {
			++noPassed;
			System.out.println("Result:\t" + result.toString());
		} else {
			System.out.println("TestCase 4");
			System.out.println("Result:\t" + result.toString());
			System.out.println("Error Message:\t" + operand2.errorMessage);
			++noFailed;
		}

		// TestCase 5.
		operand1 = new CalculatorValue(258,3,1);
		operand2 = new CalculatorValue(851,3,1);
		result = new CalculatorValue();
		result.setValue(operand2);
		if (result.measuredValue == 851) {
			++noPassed;
			System.out.println("Result:\t" + result.toString());
		} else {
			System.out.println("TestCase 5");
			System.out.println("Result:\t" + result.toString());
			++noFailed;
		}

		if (noFailed == 0) System.out.println("All TestCases Passed");

	}
}
