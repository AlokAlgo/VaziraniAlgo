package DivideAndConquer;

import java.util.Arrays;
/*
 * Vazirani problem 2.19 a.
 */
public class KwayMergeA {
	
	public static void main(String[] args) {
		int[][] input = new int[10][20];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				input[i][j] = (2 * j + 1) * i;
			}
		}
		int[] result = kWayMerge(input);
		for(int i = 0; i < result.length; i++)
		{
			System.out.println(result[i]);
		}
	}
	
	private static int[] kWayMerge(int[][] input) {
		int[] result = input[0];
		for (int i = 1; i < input.length; i++) {
			result = merge(result, input[i]);
		}
		return result;
	}
	
	private static int[] merge(int[] first, int[] second) {
		if ( first == null || first.length == 0) {
			return second;
		}
		if  (second == null || second.length == 0) {
			return first;
		}
		if (first[0] <= second[0]) {
			return join(first[0], merge(Arrays.copyOfRange(first, 1, first.length),second));
		}
		return join(second[0], merge(first, Arrays.copyOfRange(second, 1, second.length)));
	}

	private static int[] join(int val, int[] input) {
		int[] output = new int[input.length + 1];
		output[0] = val;
		for (int i = 0; i < input.length; i++) {
			output[i + 1] = input[i];
		}
		return output;
	}

}
