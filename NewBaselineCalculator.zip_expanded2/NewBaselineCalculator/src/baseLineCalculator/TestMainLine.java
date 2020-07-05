/**
 * @author V.Ravi
 */
package baseLineCalculator;

public class TestMainLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0; 
		String[] wrongAnswers = new String[20];
		CalculatorValue op1 = new CalculatorValue("100");
		CalculatorValue op2 = new CalculatorValue("15");
		CalculatorValue res = new CalculatorValue(op1);
		res.add(op2);
		if (res.toString().equals("115.0")) {
			count++;
		} else {
			wrongAnswers[0] = "Test case 1 : Expected Output = 26 , Your Output =" + res.toString();
		}  
		CalculatorValue op21 = new CalculatorValue();
		CalculatorValue op22 = new CalculatorValue();
		CalculatorValue res2 = new CalculatorValue(op21); 
		res2.sub(op22);
		if (res2.toString().equals("0.0")) {
			count++;
		} else {
			wrongAnswers[1] = "Test case 2 : Expected Output = 0 , Your Output =" + res2.toString();
		}
		long l = 2L;
		CalculatorValue op31 = new CalculatorValue(l);
		CalculatorValue op32 = new CalculatorValue("-14");
		CalculatorValue res3 = new CalculatorValue(op31);
		res3.mpy(op32);
		if (res3.toString().equals("-28.0")) {
			count++;
		} else {
			wrongAnswers[2] = "Test case 3 : Expected Output : 28 , Your Output :" + res3.toString();
		}
		CalculatorValue op41 = new CalculatorValue();
		CalculatorValue op42 = new CalculatorValue("+14");
		op41.setValue(14);
		CalculatorValue res4 = new CalculatorValue(op41);
		res4.div(op42);

		if (res4.toString().equals("1.0")) {
			count++;
		} else {
			wrongAnswers[3] = "Test case 4 : Expected Output : 1 , Your Output :" + res4.toString();
		}
		CalculatorValue op51 = new CalculatorValue();
		CalculatorValue op52 = new CalculatorValue("+14");
		op41.setValue(14);
		CalculatorValue res5 = new CalculatorValue(op41);
		res5.div(op52);
		if (op51.errorMessage.equals("")) {
			count++;
		} else {
			wrongAnswers[4] = "Test case 5 : Expected Output : ' ' , Your Output :" + op51.getErrorMessage();
		}
		CalculatorValue op61 = new CalculatorValue("14");
		CalculatorValue op62 = new CalculatorValue(" ");
		op62.setValue(new CalculatorValue(14));
		CalculatorValue res6 = new CalculatorValue(op41);
		res6.div(op61);
		if (op61.errorMessage.equals("")) {
			count++; 
		} else {
			wrongAnswers[5] = "Test case 6 : Expected Output : 1 , Your Output :" + res6.toString();
		}
		CalculatorValue op71 = new CalculatorValue("++14d");
		op62.setValue(new CalculatorValue(14));
		CalculatorValue res7 = new CalculatorValue(op41);
		res7.div(op2);
		if (op71.errorMessage.equals("Invalid value")) {
			count++; 
		} else {
			wrongAnswers[6] = "Test case 7 : Expected Output : Invalid value , Your Output :" + op71.getErrorMessage();
		} 
		CalculatorValue op81 = new CalculatorValue("123 455");
		CalculatorValue op82 = new CalculatorValue(" ");
		op82.setValue(new CalculatorValue(14));
		CalculatorValue res8= new CalculatorValue(op41);
		res8.div(op82);
		if (op81.errorMessage.equals("Excess data")) {
			count++; 
		} else {
			wrongAnswers[7] = "Test case 8 : Expected Output : Excess data , Your Output :" + op81.getErrorMessage();
		}
		CalculatorValue op91 = new CalculatorValue(1,2,3);
		CalculatorValue op92 = new CalculatorValue("");
		op92.setValue(new CalculatorValue(14));
		CalculatorValue res9= new CalculatorValue(op41);
		res9.div(op82);
		if (op91.errorMessage.equals("Excess data")) {
			count++; 
		} else {
			wrongAnswers[8] = "Test case 9 : Expected Output : Excess data , Your Output :" + op81.getErrorMessage();
		}

		CalculatorValue op110 = new CalculatorValue(1,2,3);
		op92.setValue(new CalculatorValue(14));
		CalculatorValue res10= new CalculatorValue(op41);
		res10.sqrt();
		if (op110.errorMessage.equals("Excess data")) 
			count++; 
		else 
			wrongAnswers[9] = "Test case 10 : Expected Output : Excess data , Your Output :" + op110.getErrorMessage();
		
		CalculatorValue op211 = new CalculatorValue(""); 
		op211.setValue(new CalculatorValue("3"));
		CalculatorValue res11= new CalculatorValue(op41);
		res11.pow(op211);
		if (res11.measuredValue == 8.0) {
			count++; 
		} else {
			wrongAnswers[10] = "Test case 11 : Expected Output : 8.0 , Your Output :" + res11.measuredValue;
		}
		
		op211.setValue(new CalculatorValue("3"));
		CalculatorValue res12= new CalculatorValue(op41);
		res12.sqrt();
		if (res12.measuredValue == -2.0) {
			count++; 
		} else {
			wrongAnswers[11] = "Test case 12 : Expected Output : -2.0 , Your Output :" + res12.measuredValue;
		}

		for (String answer : wrongAnswers) {
			if (answer != null)
				System.out.println(answer);
		}
		System.out.println("Total Test Cases Passed :" + count);
	}
}






