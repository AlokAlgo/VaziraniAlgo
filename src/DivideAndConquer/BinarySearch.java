package DivideAndConquer;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] input = new int[100];
		for (int i = 0; i< 100 ; i++) {
			input[i] = 2 * i;
		}
		System.out.println(binarySearch(input, 49, 0, input.length -1));
		System.out.println(binarySearch(input, 50, 0, input.length -1));
	}
	/*
	 * @param input int[] a containing integers
	 * @param int no to be searched
	 * @param lo lower index
	 * @param hi higher index
	 * @return int which is the index of the no in int[], -1 if no not found
	 */
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
