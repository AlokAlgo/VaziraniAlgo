package DivideAndConquer;
/* 2.16. You are given an innite array A[] in which the rst n cells contain integers in sorted order and
the rest of the cells are lled with1. You are not given the value of n. Describe an algorithm that
takes an integer x as input and nds a position in the array containing x, if such a position exists,
in O(log n) time. (If you are disturbed by the fact that the array A has innite length, assume
instead that it is of length n, but that you don't know this length, and that the implementation
of the array data type in your programming language returns the error message 1 whenever
elements A[i] with i > n are accessed.) */

public class InfiniteArray {
	public static void main(String[] args){
		int[] input = new int[1000];
		for(int i = 0; i < 100; i++)
		{
			input[i] = i;
		}
		for(int i = 100; i < 1000; i++)
		{
			input[i] = Integer.MAX_VALUE;
		}
		System.out.println(search(input, 99, 0, 0));
		
	}
	// this method can't use the length of array to use binary search
	// so every time it doubles the search range to search until it exhausts
	// all he numbers < Infinity.
	private static int search(int[] input, int searchVal, int lo, int hi) {
		// search range is exhausted so return -1
		if(input[lo] == Integer.MAX_VALUE) {
			return -1;
		}
		// now the range contains some infinities
		if (input[hi] == Integer.MAX_VALUE ) {
			// get the highest index which is a real no
			hi = getLastNumberIndex(input, lo, hi);
			return binarySearch(input, searchVal, lo, hi);
		}
		int retVal = binarySearch(input, searchVal, lo, hi);
		hi = hi + 1;
		return retVal == -1 ? search(input, searchVal, hi, 2 * hi) : retVal;
	}
	// returns the greatest index <= hi such that input[greatestIndex] < Infinity
	// and all the indices lesser than the greatest index are also less than infinity.
	private static int getLastNumberIndex(int[] input, int lo, int hi) {
		if (lo == hi) {
			return lo;
		}
		int mid = (lo + hi) / 2;
		// if all the numbers are real then return hi
		if (input[hi] < Integer.MAX_VALUE && input[lo] < Integer.MAX_VALUE) {
			return hi;
		}
		// find the last real no in left part
		int lastIndex = getLastNumberIndex(input, lo, mid);
		// if all no in left are real then get from the right part
		return lastIndex == mid
					? getLastNumberIndex(input, mid + 1, hi) : lastIndex;
	}
	
	private static int binarySearch(int[] input, int no, int low, int high) {
		if (low > high) {
			return -1;
		}
		if ( low == high) {
			return no == input[low] ? low : -1;
		}
		
		int mid = (low + high) / 2;
		if (input[mid] == no) {
			return mid;
		} else if (input[mid] < no) {
			return binarySearch(input, no, mid + 1, high);
		}
		return binarySearch(input, no, low, mid -1);		
	}

}
