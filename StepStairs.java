package javalearning;

/* Step 1 or 2 stairs for one time, how many ways can we step to N stairs?
 * */

public class StepStairs {
	public static void main(String[] args)
	{
		StepStairs stepstairs = new StepStairs();
		stepstairs.compute1(1);
		stepstairs.compute1(2);
		stepstairs.compute1(3);
		stepstairs.compute1(4);
		stepstairs.compute1(10);
	}
	
	public StepStairs()
	{
		
	}
	
	public void compute1(int n)
	{
		if (n <= 1)
			return;
		
		int[] ways = new int[n+1];
		ways[0] = 0;
		ways[1] = 1;
		ways[2] = 2;
		
		for (int i = 3; i < n+1; i ++)
		{
			ways[i] = ways[i-1] + ways[i-2];
		}
		
		System.out.println("Step " + n + ": " + ways[n] + " ways.");
	}
}
