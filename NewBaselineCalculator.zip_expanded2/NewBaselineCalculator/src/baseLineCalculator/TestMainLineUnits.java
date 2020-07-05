package baseLineCalculator;

import java.util.Arrays;

/**
 * @author V.Ravi 
 *
 */
public class TestMainLineUnits {
	public static void main(String[] args) {

		BusinessLogic businessLogicObj = new BusinessLogic();
		businessLogicObj.setOperand1("1", "0");
		businessLogicObj.setOperand2("1000", "0");
		businessLogicObj.isUnitsCompatible("1", "2");
		System.out.println("Sum " + businessLogicObj.addOperands());
		businessLogicObj.setOperand1("4.258", "0");
		businessLogicObj.setOperand2("4.258", "0");
		String[] t1res = businessLogicObj.mpyOperands().split(":");
		businessLogicObj.setOperand1("9", "0");
		businessLogicObj.setOperand2(t1res[0], t1res[1]);
		String[] t2res = businessLogicObj.mpyOperands().split(":");
		businessLogicObj.setOperand1(t2res[0], t2res[1]);
		businessLogicObj.setOperand2("2.32712784452E11", "9E8");
		String[] t3res = businessLogicObj.divOperands().split(":");
		businessLogicObj.setOperand1("875451000", "3000");
		businessLogicObj.setOperand2("875415000", "3000");
		String[] t4res = businessLogicObj.mpyOperands().split(":");
		businessLogicObj.setOperand1(t3res[0], t3res[1]);
		String[] t5res = businessLogicObj.mpyOperands().split(":");
		businessLogicObj.setOperand1(t4res[0], t4res[1]);
		businessLogicObj.setOperand2(t5res[0], t5res[1]);
		String[] t6res = businessLogicObj.mpyOperands().split(":");
		businessLogicObj.setOperand1(t6res[0], t6res[1]);
		String[] t7res = businessLogicObj.sqrtOperands().split(":");
		System.out.println(Arrays.toString(t7res));
	}
}
