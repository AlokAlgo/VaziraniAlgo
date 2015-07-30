package DivideAndConquer;

public class SameNumberAsIndex {
	public static void main(String[] args) {
		int[] input = new int[100];
		for (int i = 0; i< 100 ; i++) {
			input[i] = 2 * i ;
		}
		System.out.println(binarySearchSameNoAsIndex(input, 0, input.length -1));
		System.out.println(binarySearchSameNoAsIndex(input, 0, input.length -1));
	}
	/*
	 * @param input int[] containing integers
	 * @param int no to be searched
	 * @param lo lower index
	 * @param hi higher index
	 * @return int index which is the index such that input[index] == index, -1 if no such occurence found
	 */
	private static int binarySearchSameNoAsIndex(int[] input, int low, int high) {
		if (low > high) {
			return -1;
		}
		if ( low == high) {
			return input[low] == low ? low : -1;
		}
		
		int mid = (low + high) / 2;
		if (mid == input[mid]) {
			return mid;
		} else if (mid < input[mid]) {
			return binarySearchSameNoAsIndex(input, mid + 1, high);
		}
		return binarySearchSameNoAsIndex(input,low, mid -1);		
	}

}
