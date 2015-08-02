package DivideAndConquer;

public class KthLargestTwoSortedArrays {
	
	public static void main(String[] args) {
		int[] first = new int[100];
		int[] second = new int[50];
		for(int i = 0; i < first.length; i++) {
			first[i] = 2 * i + 1;
		}
		for(int i = 0; i < second.length; i++) {
			second[i] = 3 * i + 1;
		}
		try {
			System.out.println(KthLargest(first, second, 0, first.length - 1, 0, second.length - 1, 150));
		}
		catch (Exception e) {
			
			
		}
	}
	
	private static int KthLargest(int[] first, int[] second, int firstlo, 
			int firsthi, int secondlo, int secondhi, int k) throws Exception {
		if (k > (first.length + second.length) || k < 1) {
			throw new Exception("K is out of range");
		}
		if (firstlo >= firsthi && secondlo >= secondhi) {
			return second[secondlo];
		}
		if (firstlo >= firsthi) {
			return second[k - firstlo - 2];
		}
		if (secondlo >= secondhi) {
			return first[k - secondlo - 2];
		}
		
		
		int firstmid = (firstlo + firsthi) / 2;
		int secondmid = (secondlo + secondhi) / 2;
		
		if (first[firstmid] == second[secondmid] && k == ( firstmid + secondmid + 2)) {
			return first[firstmid];
		}
		
		if (first[firstmid] == second[secondmid] && k < ( firstmid + secondmid + 2)) {
			return KthLargest(first, second, firstlo, firstmid, secondlo, secondmid, k);
		}
		
		if (first[firstmid] == second[secondmid] && k > ( firstmid + secondmid + 2)) {
			return KthLargest(first, second, firstmid + 1, firsthi, secondmid + 1, secondhi, k);
		}
		
		if (k >= ( firstmid + secondmid + 2) ) {
			if (first[firstmid] < second[secondmid]) {
				return KthLargest(first, second, firstmid + 1, firsthi, secondlo, secondhi, k);
			}
			return KthLargest(first, second, firstlo, firsthi, secondmid + 1, secondhi, k);
		}
		
		
		if (first[firstmid] < second[secondmid]) {
			return KthLargest(first, second, firstlo, firsthi, secondlo, secondmid - 1, k);
		}
		return KthLargest(first, second, firstlo, firstmid - 1, secondlo, secondhi, k);
			
		}
		
		
	}
