package DivideAndConquer;

import java.util.Arrays;

public class RemoveDuplicates {
	public static void main(String[] args) {
		//create the input array
		int[] input = new int[100];
		for(int i = 0; i < 100; i++)
		{
			if(i % 2 == 0) {
				input[i] = 100 - i;
				continue;
			}
			input[i] = input[i - 1];
		}
		Arrays.sort(input);
		input = removeDuplicates(input);
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}
	
	private static int[] removeDuplicates(int[] sorted) {
		if (sorted.length == 1) {
			return sorted;
		}
		int lastVal = sorted[0];
		int processIndex = 1;
		int copyIndex = 1;
		// LoopInvariant: All the elements before the copyIndex are unique.
		// Terminates when processIndex > sorted.length
		while(processIndex < sorted.length) {
			if (sorted[processIndex] != lastVal) {
				lastVal = sorted[processIndex];
				if(processIndex > copyIndex) {
					sorted[copyIndex] = lastVal;
					copyIndex++;
				}
			}
			processIndex++;
		}
		return Arrays.copyOfRange(sorted, 0, copyIndex);		
	}
}
