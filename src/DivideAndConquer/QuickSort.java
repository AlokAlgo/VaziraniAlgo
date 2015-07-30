package DivideAndConquer;

public class QuickSort {
	
	public static void main(String[] args) {
	//create the input array
			int[] input = new int[100];
			for(int i = 0; i < 100; i++)
			{
				input[i] = 100 - i;
			}
			quickSort(input, 0, input.length - 1);
			for(int i = 0; i < 100; i++)
			{
				System.out.println(input[i]);
			}
			
	}
	static class PartitionObject {
		int partitionStartIndex;
		int partitionEndIndex;
			PartitionObject(int start, int end) {
				this.partitionStartIndex = start;
				this.partitionEndIndex = end;
			}
		
	}
	// Sorts the elements in place using a helper partitioning routine
	private static void quickSort(int[] input, int lo, int hi) {
		// if no or one element then just return
		if (lo >= hi) {
			return;
		}
		PartitionObject partObject = partition(input, lo, hi);
		// input[partObject.partitionStartIndex..partObject.partitionEndIndex] is sorted
		// so sort the left and right regions respectively, recusively.
		quickSort(input, lo, partObject.partitionStartIndex - 1);
		quickSort(input, partObject.partitionEndIndex + 1, hi);
	}
	/*
	 * @param input int[]
	 * @param lo lower end of input array to be processed
	 * @param hi higher end input array
	 * This method will process the subArray input[lo..hi].
	 * @return PartitionObject which has partitionStartIdex and partitionEndIndex such that
	 * input[lo..partpartitionStartIndex - 1] < input[partpartitionStartIndex - parttionEndIndex] 
	 * input[partionEndIndex + 1..hi] > input[partitionStartIndex..partitionEndIndex] = input[partitionStartIndex]
	 */
	private static PartitionObject partition(int[] input, int lo, int hi) {
		// handling base case when it is already partitioned
		if (lo == hi) {
			return new PartitionObject(lo, lo);
		}
		// input array will be paritioned in three groups
		// choose a random pivot
		double val = Math.random();
		int pivotIndex = (int) Math.ceil(lo + (hi - lo) * val);
		int pivotVal = input[pivotIndex];
		swap(input, pivotIndex, lo);
		
		int partStartIndex = lo;
		int partEndIndex = lo;
		int processIndex = lo + 1;
		
		// LoopInvariant: input array[lo..processIndex] has three partition
		// LeftPartition input[lo..partStartIndex-1] contains element lesser than pivotVal
		// MiddlePartition input[partStartIndex..partEndIndex] contains elements equal to pivotVal
		// RightPartition: input[partStartIndex..partEndIndex] contains elements greater than pivotVal
		// the condition is true in the begining as processIndex = 1 and partStartIndex = partEndIndex = lo and
		// input[lo] = pivotVal
		// terminates whhen processIndex > hi
		while (processIndex <= hi) {
			if (input[processIndex] ==  pivotVal) {
				input[processIndex] = input[partEndIndex + 1];
				input[partEndIndex + 1] =  pivotVal;
				partEndIndex++;
			} else if (input[processIndex] < input[partStartIndex]) {
				input[partStartIndex] = input[processIndex];
				input[processIndex] = input[partEndIndex + 1];
				input[partEndIndex + 1] = pivotVal;
				partStartIndex++;
				partEndIndex++;
			}
			processIndex++;
		}
		return new PartitionObject(partStartIndex, partEndIndex);
	}
	// swaps elements at position firstIndex and secndIndex in the input array
	private static void swap(int[] input, int firstIndex, int secondIndex) {
		int tmp = input[firstIndex];
		input[firstIndex] = input[secondIndex];
		input[secondIndex] = tmp;
	}
	

}
