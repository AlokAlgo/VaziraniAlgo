package DivideAndConquer;

import java.util.Arrays;

public class RecursiveMergeSort {
	
	public static void main(String[] args) {
		//create the input array
		int[] input = new int[100];
		for(int i = 0; i < 100; i++)
		{
			input[i] = 100 - i;
		}
		mergeSort(input);
		for(int i = 0; i < 100; i++)
		{
			System.out.println(input[i]);
		}
	}
	
	private static void mergeSort(int[] input) {
		recursiveMergeSort(input, 0, input.length - 1);
	}
	
	private static void recursiveMergeSort(int[] input, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		recursiveMergeSort(input, low, mid);
		recursiveMergeSort(input, mid + 1, high);
		int[] result = merge(input, low, mid, mid + 1, high);
		for ( int i = low; i <= high; i++) {
			input[i] = result[i - low];
		}
	}
	
	private static int[] merge(int[] input, int firstLow, int firstHigh, int secondLow, int secondHigh) {
		if ( firstLow > firstHigh) {
			return Arrays.copyOfRange(input, secondLow, secondHigh + 1);
		}
		if  (secondLow > secondHigh) {
			return Arrays.copyOfRange(input, firstLow, firstHigh + 1);
		}
		if (input[firstLow] <= input[secondLow]) {
			return join(input[firstLow], merge(input, firstLow + 1, firstHigh, secondLow, secondHigh));
		}
		return join(input[secondLow], merge(input, firstLow, firstHigh, secondLow + 1, secondHigh));
		
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
