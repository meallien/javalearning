package javalearning;

/* Give an array with length n, compute its longest sub array, with elements increasing
 * Might not continuous.
 * */

public class LongestIncreasingDiscreteSub {
	public static void main(String[] args)
	{
		LongestIncreasingDiscreteSub sub = new LongestIncreasingDiscreteSub();
		sub.compute1();
	}
	
	public LongestIncreasingDiscreteSub()
	{
		
	}
	
	public void compute1()
	{
		int length = data.length;
		int[] dp = new int[length];
		dp[0] = 1;
		
		for (int i = 1; i < length; i++)
		{
			System.out.println("");
			int maxLength = 0;
			for (int j = 0; j < i; j++)
			{
				if (dp[j] > maxLength && data[i] > data[j])
				{
					maxLength = dp[j];
					System.out.println("j = " + data[j] + " i = " + data[i] + " results max_length " + (maxLength+1));
				}
				
			}
			dp[i] = maxLength +1;
		}
		
		int max = 1;
		for (int i = 0; i < length; i++)
		{
			if (dp[i] > max)
			{
				max = dp[i];
				System.out.println("Find new max: max = " + max + " [ " + i + "]");
			}
		}
		System.out.println("Longest increasing sub array: length = " + max);
	}
	
	private int[] data = {20, 10, 50, 30, 60, 40, 80, 50, 60};
	//private int[] data = {20, 10, 50, 30, 60, 40, 80, 90, 70};
}
