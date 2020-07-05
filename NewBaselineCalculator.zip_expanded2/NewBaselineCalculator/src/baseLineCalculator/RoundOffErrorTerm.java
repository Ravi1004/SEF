package baseLineCalculator;

/**
 * This class is RoundoffErrorTerm, which will be used to round of the error term 
 * 
 * @author Ravi VIswanadhula
 *
 */
public class RoundOffErrorTerm {
	
	private static double number;
	private static StringBuffer num;
	private static StringBuffer res;


	private static void a(double firstDigit) {
		res.append((int)firstDigit + 1);
		int pos = num.indexOf(".");		
		for(int i = 1; i < pos ; i++) {
			num.replace(i, i + 1, "0");
			res.append("0");
		}
		num.append(".");
		res.append(".");
		for (int i = pos + 1; i < num.length(); i++) {
			num.replace(i, i + 1, "0");
			res.append("0");
		}	
	}
	
	public static String roundOff(double ev) {		
		num = new StringBuffer();
		res = new StringBuffer();
		number = ev;
		if (number == 0) return "0";
		num.append(number);
		num = new StringBuffer(num.toString().toUpperCase());		
		char sign = ' ';
		if(num.charAt(0) == '+') {
			num.replace(0, 1, "");
			sign = '+';
		}
		if(num.charAt(0) == '-') {
			num.replace(0, 1, "");
			sign = '-';
		}
		String expTerm = "";
		if(num.lastIndexOf("E") != -1) {expTerm = num.substring(num.lastIndexOf("E"), num.length());}
		double firstDigit = Double.parseDouble(num.substring(0,1));
		if (firstDigit > 0) {a(firstDigit); return setResult(sign, expTerm);} else {b(); return setResult(sign, expTerm);}
	}
	
	private static void b() {
		int pos = num.lastIndexOf(".");
		for (int i = 0; i < pos; i++) {
			res.append('0');
		}
		res.append(".");
		int i;
		for (i = pos + 1; i < num.length(); i++) {
			if (num.charAt(i) != '0') 
				break;
			else 
				res.append("0");
				num.replace(i, i + 1, "0");
		}
		double digit = Double.parseDouble(num.substring(i,i+1));
		digit = digit + 1;
		if (digit >= 0 && digit <= 9) 
			res.append(digit);
		else {
			res.deleteCharAt(res.length());
			res.append(digit + 1);
		}
		res.deleteCharAt(res.length() - 1);
		res.deleteCharAt(res.length() - 1);
		for(int j = i + 1; j < num.length();j++) {
			res.append("0");
			num.replace(j, j + 1, "0");
		}
	}
	
	private static String setResult(char sign, String expTerm) {
		if(!expTerm.isEmpty()) {
			res = new StringBuffer(res.substring(0,1));
			String s = res.substring(0);
			s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
			res.append(expTerm);
			res.append("0");
			num.append(expTerm);
		}
		String s1 = num.substring(0, num.length()); 
		s1 = s1.indexOf(".") < 0 ? s1 : s1.replaceAll("0*$", "").replaceAll("\\.$", "");
		String s2 = res.substring(0,res.length() - 1); 
		s2 = s2.indexOf(".") < 0 ? s2 : s2.replaceAll("0*$", "").replaceAll("\\.$", "");
		double number1 = Double.parseDouble(s1);
		if (Math.abs(number) > number1) 
			return "" + sign + s2;
		else 
			return "" + sign + number1 + ""; 
	}
}
