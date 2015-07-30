package DivideAndConquer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IterativeMergeSort {
	
	public static void main(String[] args) {
		//create the input array
		int[] input = new int[100];
		for(int i = 0; i < 100; i++)
		{
			input[i] = 100 - i;
		}
		mergeSort(input);
	}
	
	private static void mergeSort(int[] input) {
		iterativeMergeSort(input);
	}
	
	private static void iterativeMergeSort(int[] input) {
		 Queue<int[]> queue = new LinkedList<int[]>();
		// create one length arrays and put it in the Queue
		 for (int i = 0; i < input.length; i++) {
			 int[] arr = new int[1];
			 arr[0] = input[i];
			 queue.add(arr);
		 }
		 while (queue.size() > 1) {
			 queue.add(merge(queue.remove(), queue.remove()));
			 
		 }
		 int[] output = queue.remove();
			for(int i = 0; i < output.length; i++)
			{
				input[i] = output[i];
			}
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
