package javalearning;

/* Give an array with length n, compute its max distance
 * max{A[b] - A[a]}, with 0 <= a <= b < n
 * */

public class MaxDistance {
	public static void main(String[] args)
	{
		MaxDistance distance = new MaxDistance();
		System.out.println(distance.compute1());
	}
	
	public MaxDistance()
	{
		
	}
	
	public int compute1()
	{
		int length = data.length;
		
		int max = 0;
		int a = 0;  // header pointer, record minimum
		int b = 0;  // tail pointer, record maximum
		for (int i = 0; i < length; i++)
		{
			b = i;
			int temp = data[b] - data[a];
			if (temp > max)
			{
				max = temp;
			}
			if (data[i] < data[a])
				a = i;
		}
		
		return max;
	}
	
	private int[] data = {22, 20, 10, 33, 5, 2, 28, 70};
}
