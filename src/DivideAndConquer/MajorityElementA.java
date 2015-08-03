package DivideAndConquer;
/*
 * VAzirani 2.23 a
 */

public class MajorityElementA {
	
	public static void main(String[] args) {
		// create the input with a majority element
		int[] input = new int[100];
		for (int i = 0; i < 100; i++) {
			if (i % 3 == 0) {
				input[i] = 3 * i;
			}
		}
		Result result = getMajorityElementIndex(input, 0, input.length - 1);
		System.out.println( result.isMajority);
		System.out.println( result.no);
		System.out.println( result.count);
		
	}
	static class Result {
		boolean isMajority;
		int no;
		int count;
		Result(boolean isMajority, int no, int count) {
			this.isMajority = isMajority;
			this.count = count;
			this.no = no;
		}
	}
	
	private static Result getMajorityElementIndex(int[] input, int lo, int hi) {
		
		if (lo == hi) {
			return new Result(true, input[lo], 1);
		}
		int mid = (lo + hi) / 2;
		Result left = getMajorityElementIndex(input, lo, mid);
		Result right = getMajorityElementIndex(input, mid + 1, hi);
		if (!left.isMajority && !right.isMajority) {
			return new Result(false, 0, 0);
		}
		
		if(left.isMajority) {
			if (right.isMajority && right.no == left.no) {
				return new Result(true, left.no, left.count + right.count);
			}
			int count = left.count + count(input, mid + 1, hi, left.no);
			if (count > (hi - lo + 1) / 2) {
				return new Result(true, left.no, count);
			}
			
		}
		if(right.isMajority) {
			if (left.isMajority && left.no == right.no) {
				return new Result(true, right.no, right.count + left.count);
			}
			int count = right.count + count(input, lo, mid, right.no);
			if (count > (hi - lo + 1) / 2) {
				return new Result(true, right.no, count);
			}
			
		}
		return new Result(false, 0, 0);
	}
	
	private static int count(int[] input, int lo, int hi, int no) {
		int count = 0;
		for(int i = lo; i <= hi; i++) {
			if(input[i] == no) {
				count++;
			}
		}
		return count;
	}

}
