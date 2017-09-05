package javalearning;

/* Give an array with length n, compute its max sub array sum
 * max{A[a] + ... + A[b]}, with 0 <= a <= b < n
 * */

public class MaxSubSum {
	public static void main(String[] args)
	{
		MaxSubSum subsum = new MaxSubSum();
		subsum.compute1();
	}
	
	public MaxSubSum()
	{
		
	}
	
	public void compute1()
	{
		int length = data.length;
		
		int currentSum = data[0];
		int header = 0;  // header pointer, record minimum
		int tail = 0;  // tail pointer, record maximum
		
		boolean recompute = true;  // start from index 0, means recompute
		for (int i = 0; i < length; i++)
		{
			if (recompute)
			{
				recompute = false;
				currentSum = data[i];
				header = i;
				tail = i;
				compareAndRecord(currentSum, header, tail);
				continue;
			}
			
			int sum = currentSum + data[i];
			if (sum < 0)
			{
				System.out.println("Recompute: sum = " + sum);
				recompute = true;
				// element i set 'recompute' flag, process the flag in element i+1
				continue;
			}
			
			tail = i;
			currentSum = sum;
			compareAndRecord(currentSum, header, tail);
		}

		// if the last element set 'recompute' flag, we also need to process it here 
		if (recompute)
		{
			recompute = false;
			currentSum = data[length-1];
			header = length-1;
			tail = length-1;
			compareAndRecord(currentSum, header, tail);
		}
		
		System.out.println("Final result:");
		printResult();
	}
	
	private void compareAndRecord(int sum, int header, int tail)
	{
		System.out.println("Compare: final_sum = " + final_sum + ", sum = " + sum);
		if (sum > final_sum)
		{
			final_sum = sum;
			final_header = header;
			final_tail = tail;
		}
		printResult();
	}
	private void printResult()
	{
		System.out.println("final_sum = " + final_sum + ", [" + final_header + ", " + final_tail + "]");
	}
	
	// private int[] data = {10, 2, -1, -15, 10, 30, -5, 100};
	private int[] data = {-5, -2, -3, -1};
	
	private int final_sum = data[0];
	private int final_header = 0;
	private int final_tail = 0;
}
