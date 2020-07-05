package baseLineCalculator;
import java.math.BigDecimal;

/**
 * This is a RoundOffMeasuredValue class which basically round of the measured value
 * 
 * @author Ravi VIswanadhula
 *
 */
public class RoundOffMeasuredValue {
	static StringBuffer result;
	public static String roundOffMV(double measuredValue, int sdPos, boolean isDouble) {
		System.out.println(measuredValue);
		BigDecimal bigDecimal = new BigDecimal(Double.toString(measuredValue));
		String num = bigDecimal.toPlainString();
		result = new StringBuffer();
		result.append(num);
		String s1 = result.substring(0);
		s1 = s1.indexOf(".") < 0 ? s1 : s1.replaceAll("0*$", "").replaceAll("\\.$", "");
		result = new StringBuffer(s1);
		if (isDouble) {
			int pos = result.lastIndexOf(".");
			System.out.println("Pos " + pos);
			if (pos >= 0) {
				for (int i = pos + 1; i < result.length(); i++) {
					if(i > sdPos + pos) 
						result.replace(i, i + 1, "0");
				}
				s1 = result.substring(0);
				s1 = s1.indexOf(".") < 0 ? s1 : s1.replaceAll("0*$", "").replaceAll("\\.$", "");
				result = new StringBuffer(s1);
				return result.substring(0);
			}
		}
		
		else if (s1.contains(".")){
			int pos = result.lastIndexOf(".");
			for (int i = 0; i < s1.length(); i++) {
				if (i >= pos - sdPos && result.charAt(i) != '.') 
					result.replace(i, i+1, "0"); 
			}
		}return result.substring(0);
	}
}
