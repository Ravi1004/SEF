package baseLineCalculator;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * <p> Title: CalculatorValue Class. </p>
 * 
 * <p> Description: An entity class component of a JavaFX demonstration application that represents
 * the calculator value and hides its implementation from the rest of the system, making it easier
 * for us to do experiments with alternate representations.</p>
 * 
 * <p> Copyright: Lynn Robert Carter © 2016 </p>
 * 
 * @author Lynn Robert Carter
 * @autor V.Ravi
 * 
 * @version 4.00	2019-12-03 Baseline JavaFX implementation of a 1 integer calculator 
 * 
 */
public class CalculatorValue {

	// These are the major values that define a calculator value
	double measuredValue;
	double errorTerm;
	int unitCode;
	String errorMessage;

	/*****
	 * These are the constructors for the class
	 * 
	 * This is the default constructor
	 */
	public CalculatorValue() {
		measuredValue = 0;
		errorTerm = 0;
		unitCode = 0;
		errorMessage = "";
	}

	/*****
	 * This constructor creates a calculator value based on a double integer
	 */
	public CalculatorValue(double v) {
		measuredValue = v;
		errorTerm = 0;
		unitCode = 0;
		errorMessage = "";
	}

	/*****
	 * This constructor creates a calculator value based on two long values and an int coded unit code
	 */
	public CalculatorValue(double v, double et, int uc) {
		measuredValue = v;
		errorTerm = et;
		unitCode = uc;
		errorMessage = "";
	}

	
	/*****
	 * This constructor creates a duplicate of an already existing calculator value
	 */
	public CalculatorValue(CalculatorValue v) {
		measuredValue = v.measuredValue;
		errorTerm = v.errorTerm;
		unitCode = v.unitCode;
		errorMessage = v.errorMessage;
	}

	/*****
	 * This constructor creates a calculator value from a string... Due to the nature
	 * of the input, there is a serious chance of errors, and so the routine returns
	 * the value with the error message value set to empty or the string of an error
	 * message.
	 */
	public CalculatorValue(String s) {
		measuredValue = 0;
		if (s.length() == 0) {									// If there is nothing there,
			errorMessage = "***Error*** Input is empty";		// signal an error	
			return;												// 
		} 
		// If the first character is a plus sign, ignore it.
		int start = 0;											// Start at character position zero
		boolean negative = false;								// Assume the value is not negative
		if (s.charAt(start) == '+')								// See if the first character is '+'
			 start++;											// If so, skip it and ignore it
		
		// If the first character is a minus sign, skip over it, but remember it
		else if (s.charAt(start) == '-'){						// See if the first character is '-'
			start++;											// if so, skip it
			negative = true;									// but do not ignore it
		}
		
		// See if the user-entered string can be converted into Long value
		Scanner tempScanner = new Scanner(s.substring(start));	// Create scanner for the digits
		if (!tempScanner.hasNextDouble()) {						// See if the next token is a valid
			errorMessage = "***Error*** Invalid value"; 		// Long integer value.  If not, 
			tempScanner.close();								// close the scanner and
			measuredValue = 0;									// return a zero value.
			return;												
		}
		
		// Convert the user-entered string to a double value and see if something else is following it
		measuredValue = tempScanner.nextDouble();				// Convert the value and check to see
		if (tempScanner.hasNext()) {							// that there is nothing else is 
			errorMessage = "***Error*** Excess data"; 			// following the value.  If so,
			tempScanner.close();								// close the scanner and
			measuredValue = 0;									// return a zero value.
			return;													
		}
		
		// Getting here means that the input is valid
		tempScanner.close();									// Close the scanner
		errorTerm = 0;											// Clear the error term
		unitCode = 0;											// clear the unit code
		errorMessage = "";										// Clear the error message
		if (negative)											// Return the proper value based
			measuredValue = -measuredValue;						// on the state of the flag that
	} 

	public CalculatorValue(String sMV, String sEV) {
		measuredValue = 0;
			if (sMV.length() == 0) {									// If there is nothing there,
				errorMessage = "***Error*** Input is empty";			// signal an error	
				return;													// 
			} 
			// If the first character is a plus sign, ignore it.
			int start = 0;												// Start at character position zero
			boolean negative = false;									// Assume the value is not negative
			if (sMV.charAt(start) == '+')								// See if the first character is '+'
				 start++;												// If so, skip it and ignore it
			
			// If the first character is a minus sign, skip over it, but remember it
			else if (sMV.charAt(start) == '-'){							// See if the first character is '-'
				start++;												// if so, skip it
				negative = true;										// but do not ignore it
			}
			
			// See if the user-entered string can be converted into Double value
			Scanner tempScanner = new Scanner(sMV.substring(start));	// Create scanner for the digits
			if (!tempScanner.hasNextDouble()) {							// See if the next token is a valid
				errorMessage = "***Error*** Invalid value"; 			// Double value.  If not, 
				tempScanner.close();									// close the scanner and
				measuredValue = 0;										// return a zero value.
				return;												
			}
			
			// Convert the user-entered string to a double value and see if something else is following it
			measuredValue = tempScanner.nextDouble();					// Convert the value and check to see
			if (tempScanner.hasNext()) {								// that there is nothing else is 
				errorMessage = "***Error*** Excess data"; 				// following the value.  If so,
				tempScanner.close();									// close the scanner and
				measuredValue = 0;										// return a zero value.
				return;													
			}
			
			// Getting here means that the input is valid
			tempScanner.close();										// Close the scanner
			unitCode = 0;												// clear the unit code
			errorMessage = "";											// Clear the error message
			if (negative)												// Return the proper value based
				measuredValue = -measuredValue;	
			if (sMV.length() == 0) {									// If there is nothing there,
				errorMessage = "***Error*** Input is empty";			// signal an error													// 
			} 
//		-------------------------------------------------------------------------------------------------------------	
			// If the first character is a plus sign, ignore it.
			// Error Value Validation
			
			errorTerm = 0;
			start = 0;												// Start at character position zero
			negative = false;										// Assume the value is not negative
			if (sEV.length() == 0) {									// If there is nothing there,
				errorMessage = "Please Enter Error Term";			// signal an error	
				return;													// 
			} 

			if (sEV.charAt(start) == '+')							// See if the first character is '+'
				 start++;											// If so, skip it and ignore it
			
			// If the first character is a minus sign, skip over it, but remember it
			else if (sEV.charAt(start) == '-'){						// See if the first character is '-'
				start++;											// if so, skip it
				negative = true;									// but do not ignore it
			}
			
			// See if the user-entered string can be converted into Double value
			tempScanner = new Scanner(sEV.substring(start));		// Create scanner for the digits
			if (!tempScanner.hasNextDouble()) {						// See if the next token is a valid
				errorMessage = "***Error*** Invalid value"; 		// Double integer value.  If not, 
				tempScanner.close();								// close the scanner and
				errorTerm = 0;										// return a zero value.
				return;												
			}
			
			// Convert the user-entered string to a double value and see if something else is following it
			errorTerm = tempScanner.nextDouble();					// Convert the value and check to see
			if (tempScanner.hasNext()) {							// that there is nothing else is 
				errorMessage = "***Error*** Excess data"; 			// following the value.  If so,
				tempScanner.close();								// close the scanner and
				errorTerm = 0;										// return a zero value.
				return;													
			}
			
			// Getting here means that the input is valid
			tempScanner.close();									// Close the scanner
			unitCode = 0;											// clear the unit code
			errorMessage = "";										// Clear the error message
			if (negative)											// Return the proper value based
				errorTerm = - errorTerm;	
	}																// on the state of the flag that
	
	
	// Check whether the units are compatible or not and performs 
	//	conversion if both belongs to the same category
	
	public boolean isUnitsCompatible(CalculatorValue v) {	
				
		if((unitCode == v.unitCode) ) {
			return true;
		}

		if ((unitCode >= 1 && unitCode <= 2) && (v.unitCode >= 1 && v.unitCode <= 2)) {
			
			if (unitCode == 1) {
				v.meterToKilometer();
			} else {
				this.meterToKilometer();
			}
			
			return true;
		}
		
		if (unitCode >= 4 && unitCode <= 6 && v.unitCode >= 4 && v.unitCode <= 6) {
			
			if (unitCode == 4 && v.unitCode == 5) {
				v.minutesToHours();
			} else if (unitCode == 5 && v.unitCode == 4) {
				this.minutesToHours();
			} else if (unitCode == 4 && v.unitCode == 6) {
				v.secondsToHours();
			} else if (unitCode == 6 && v.unitCode == 4) {
				this.secondsToHours();
			} else if (unitCode == 5 && v.unitCode == 6) {
				v.secondsToMinutes();
			} else if (unitCode == 6 && v.unitCode == 5) {
				this.secondsToMinutes();
			}
			
			return true;
		}
		
		if (unitCode >= 7 && unitCode <= 8 && v.unitCode >= 7 && v.unitCode <= 8) {
			
			if(unitCode == 7) {
				v.mpsToKMPH();
			} else {
				this.mpsToKMPH();
			}
			
			return true;
		}
		
		if (unitCode >= 9 && unitCode <= 10 && v.unitCode >= 9 && v.unitCode <= 10) {
			
			if(unitCode == 9) {
				v.mps2ToKMPH2();
			} else {
				this.mps2ToKMPH2();
			}

			return true;
		}
		return false;
	}
	
	// Check whether the units are compatible or not and performs 
	//	conversion if both belongs to the same category as well as different category

	public String isUnitsCompatibleForMpyDiv(CalculatorValue v) {
		
		String resUnit = "";
		
		if((unitCode == v.unitCode)) {
			return "same";
		}

		if ((unitCode >= 1 && unitCode <= 2) && (v.unitCode >= 1 && v.unitCode <= 2)) {
			if (unitCode == 1) {
				this.kilometersToMeters();
				return "1meters";
			} else {
				v.kilometersToMeters();
				return "2meters";
			}
		}
		
		if (unitCode >= 4 && unitCode <= 6 && v.unitCode >= 4 && v.unitCode <= 6) {
			if (unitCode == 4 && v.unitCode == 5) {
				this.hoursToMinutes();
				return "1minutes";
			} else if (unitCode == 5 && v.unitCode == 4) {
				v.hoursToMinutes();
				return "2minutes";
			} else if (unitCode == 4 && v.unitCode == 6) {
				this.hoursToSeconds();
				return "1seconds";
			} else if (unitCode == 6 && v.unitCode == 4) {
				v.hoursToSeconds();
				return "2seconds";
			} else if (unitCode == 5 && v.unitCode == 6) {
				this.minutesToSeconds();
				return "1seconds";
			} else if (unitCode == 6 && v.unitCode == 5) {
				v.minutesToSeconds();
				return "2seconds";
			}
		}
		
		if (unitCode >= 7 && unitCode <= 8 && v.unitCode >= 7 && v.unitCode <= 8) {
			if(unitCode == 7) {
				this.KMPHToMPS();
				return "1Meters / seconds";
			} else {
				v.KMPHToMPS();
				return "2Meters / seconds";
			}
		}
		
		if (unitCode >= 9 && unitCode <= 10 && v.unitCode >= 9 && v.unitCode <= 10) {
			if(unitCode == 9) {
				this.KMPH2TOMPS2();
				return "1Meters / second ^ 2";
			} else {
				v.KMPH2TOMPS2();
				return "2Meters / second ^ 2";
			}
		}
		
		if (unitCode == 1) {
			this.kilometersToMeters();
			resUnit = "01(meters),";
		} else if (unitCode == 4) {
			this.hoursToSeconds();
			resUnit = "01(seconds),";
		} else if (unitCode == 5) {
			this.minutesToSeconds();
			resUnit = "01(seconds),";
		} else if(unitCode == 7) {
			this.KMPHToMPS();
			resUnit = "01(Meters / seconds),";
		} else if(unitCode == 9) {
			this.KMPH2TOMPS2();
			resUnit = "01(Meters / second^2),";
		}
		
		if(v.unitCode == 1) {
			v.kilometersToMeters();
			resUnit += "02(meters)";
		} else if (v.unitCode == 4) {
			v.hoursToSeconds();
			resUnit += "02(seconds)";
		} else if (v.unitCode == 5) {
			v.minutesToSeconds();
			resUnit += "02(seconds)";
		} else if(v.unitCode == 7) {
			v.KMPHToMPS();
			resUnit += "02(Meters / seconds)";
		} else if(v.unitCode == 9) {
			v.KMPH2TOMPS2();
			resUnit += "02(Meters / second^2)";
		}
		return resUnit;
	}
	
	// The below methods helps us in conversion
	
	private void hoursToMinutes() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * 60;
		errorTerm = errorTerm * 60;
	}

	private void kilometersToMeters() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * 1000;
		errorTerm = errorTerm * 1000;
	}

	private void meterToKilometer() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * Math.pow(10, -3);
		errorTerm = errorTerm * Math.pow(10, -3);
	}
	
	private void minutesToHours() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * Math.pow(60, -1);
		errorTerm = errorTerm * Math.pow(60, -1);
	}
	
	private void secondsToHours() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * Math.pow(3600, -1);
		errorTerm = errorTerm * Math.pow(3600, -1);		
	}

	private void secondsToMinutes() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * Math.pow(60, -1);
		errorTerm = errorTerm * Math.pow(60, -1);		
	}

	private void minutesToSeconds() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * 60;
		errorTerm = errorTerm * 60;
	}

	private void hoursToSeconds() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * 3600;
		errorTerm = errorTerm * 3600;
	}

	private void KMPHToMPS() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * (5 / 18.0);
		errorTerm = errorTerm * (5 / 18.0);
	}

	
	private void mpsToKMPH() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * (18 / 5.0);
		errorTerm = errorTerm * (18 / 5.0);
	}

	private void KMPH2TOMPS2() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue / 12960.0;
		errorTerm = errorTerm / 12960.0;
	}

	private void mps2ToKMPH2() {
		// TODO Auto-generated method stub
		measuredValue = measuredValue * (1 / 12960.0);
		errorTerm = errorTerm * (1 / 12960.0);
	}

	/*****
	 * This is the default toString method
	 * 
	 * When more complex calculator values are creating this routine will need to be updated
	 */
	public String toString() {
		String strEV = RoundOffErrorTerm.roundOff(errorTerm);
		BigDecimal bigDecimal = new BigDecimal(Double.toString(Double.parseDouble(strEV)));
		String num = bigDecimal.toPlainString();
		num = num.indexOf(".") < 0 ? num : num.replaceAll("0*$", "").replaceAll("\\.$", "");
		int sdPos;
		if (num.contains(".")) {
			sdPos = num.length() - 2;
		} else {
			System.out.println("B");
			sdPos = num.length() - 1;
		}
		String strMV = RoundOffMeasuredValue.roundOffMV(measuredValue, sdPos, num.contains("."));
		strMV = strMV.indexOf(".") < 0 ? strMV : strMV.replaceAll("0*$", "").replaceAll("\\.$", "");
		return strMV + ":" + strEV;
	}
	
	/*****
	 * This is the start of the getters and setters
	 * 
	 * Get the error message
	 */
	public String getErrorMessage(){
		return errorMessage;
	}
	
	/*****
	 * Set the current value of a calculator value to a specific long integer
	 */
	public void setValue(double v){
		measuredValue = v;
		errorMessage = "";
	}
	
	/*****
	 * Set the current value of a calculator value to a specific long integer
	 */
	public void setValue(CalculatorValue v){
		measuredValue = v.measuredValue;
		errorMessage = v.errorMessage;
	}
	

	/*******************************************************************************************************
	 * The following methods implement computation on the calculator values.  These routines assume that the
	 * caller has verified that things are okay for the operation to take place.
	 * 
	 * Since this is addition, we don't recognize any errors.
	 */
	public void add(CalculatorValue v) {
		measuredValue += v.measuredValue;
		errorTerm += v.errorTerm;
		errorMessage = "";
	}

	/*****
	 * The following methods have not been implemented.  The code here is just a stub to allow the code to
	 * properly compile and run.
	 * 
	 * @param v
	 */
	public void sub(CalculatorValue v) {
		measuredValue -= v.measuredValue;
		errorTerm += v.errorTerm;
		errorMessage = "";
	}

	public void mpy(CalculatorValue v) {
		double mul = measuredValue * v.measuredValue;
//		double Value1errorfraction = errorTerm / measuredValue;
//		double Value2errorfraction = v.errorTerm / v.measuredValue;
//		errorTerm = (Value1errorfraction + Value2errorfraction) * mul;
		errorTerm = measuredValue * v.errorTerm + v.measuredValue * errorTerm;
		measuredValue = mul;
		errorMessage = "";
	}

	public void div(CalculatorValue v) {
		double quo = measuredValue / v.measuredValue;
//		double Value1errorfraction = errorTerm / measuredValue;
//		double Value2errorfraction = v.errorTerm / v.measuredValue;
//		errorTerm = (Value1errorfraction + Value2errorfraction) * quo;
		errorTerm = ((measuredValue * v.errorTerm) + (v.measuredValue * errorTerm)) / (Math.pow(v.measuredValue, 2));
		measuredValue = quo;
		errorMessage = "";
		}
	
	public void sqrt() {
		if(measuredValue < 0) {errorMessage = "Square root cannot be performed for negative numbers";return;}
		double power = Math.pow(measuredValue, 0.5);
		double powerErrorTerm = (0.5 * Math.pow(measuredValue, 0.5 - 1)) * errorTerm;
		measuredValue = power;
		errorTerm = powerErrorTerm;
		errorMessage = "";
	}

	public void pow(CalculatorValue v) {
//		measuredValue = Math.pow(measuredValue, v.measuredValue);
		double power = Math.pow(measuredValue, v.measuredValue);
		double powerErrorTerm = (v.measuredValue * Math.pow(measuredValue, v.measuredValue - 1)) * errorTerm;
		measuredValue = power;
		errorTerm = powerErrorTerm;
		errorMessage = "";
	}
}
