package DivideAndConquer;

public class BinaryMultiplication {
	public static void main(String[] args) {
		int first = 50;
		int second = 600;
		String firstString = Integer.toBinaryString(first);
		String secondString = Integer.toBinaryString(second);
		System.out.println(multiply(firstString, secondString));

	}

	private static int multiply(String first, String second) {
		// if the strings are not the same length make them same length 
		if ( first.length() != second.length()) {
			String pads = "";
			
			for (int i = 0; i < Math.abs(first.length() - second.length()); i++) {
				pads = pads + "0";
			}
			if (first.length() > second.length()) {
				second = pads + second ;
			} else {
				first = pads + first;
			}
		}
		
		int maxSize = Math.max(first.length(), second.length());
		if (maxSize == 1) {
			return getIntVal(first) * getIntVal(second);
		}
		
		int partitionLength = maxSize % 2 == 0 ? maxSize / 2 : maxSize / 2 + 1;
		String leftFirst = getLeftString(first, partitionLength);
		String rightFirst = getRightString(first, partitionLength);
		String rightSecond = getRightString(second, partitionLength);
		String leftSecond = getLeftString(second, partitionLength);
		
		int one = multiply(leftFirst, leftSecond);
		int two = multiply(rightFirst, rightSecond);
		int three = multiply(addBinary(leftFirst, rightFirst),
							addBinary(leftSecond, rightSecond)
							);

		return (int) (one * Math.pow(2, (maxSize - partitionLength) * 2) + (three - one - two) * Math.pow(2, maxSize - partitionLength) + two);

	}
	
	private static String getLeftString(String input, int partitionLength) {
		if (input.equals("")) {
			return "";
		}
		if ( partitionLength >= input.length() ) {
			return input;
		}
		return input.substring(0, partitionLength);
		
	}
	private static String getRightString(String input, int partitionLength) {
		if (input.equals("")) {
			return "";
		}
		if ( partitionLength >= input.length() ) {
			return "";
		}
		return input.substring(partitionLength, input.length());
		
	}
	
	private static String addBinary(String first, String second) {
		return Integer.toBinaryString(getIntVal(first) + getIntVal(second));
	}
	
	private static int getIntVal(String input) {
		return input.equals("") ? 0 : Integer.parseInt(input, 2);
	}
	
	

}
