package javalearning.sumparallel;

public class SumParallel {
	public SumParallel(int length)
	{
		elements = new int[length];
		for (int i = 0; i < elements.length; i++)
		{
			elements[i] = i;
		}
	}
	
	public int computeSequential()
	{
		System.out.println("--Compute Sequential");
		int sum = 0;
		//for (int i = 0; i < 20; i++)
		{
			for (int value : elements)
			{
				sum += value;
			}
		}
		return sum;
	}
	
	protected int splitElements(int threadCount)
	{		
		if (threadCount <= 1 || elements.length <= 1)
			return -1;
		if (threadCount > elements.length)
			threadCount = elements.length;
		
		// split elements : get tail index
		int[] indexTails = new int[threadCount];
		for (int i = 0; i < threadCount; i++)
		{
			indexTails[i] = elements.length/threadCount * (i+1);
			//System.out.println("indexTails[" + i + "] = " + indexTails[i]);
		}
		// Note: last element is put into last subElement
		indexTails[threadCount-1] = elements.length;
		//System.out.println("indexTails[" + (threadCount-1) + "] = " + indexTails[threadCount-1]);
		
		// re-construct sub elements
		subElements = new int[threadCount][];
		// sub element 0
		subElements[0] = new int[indexTails[0]];
		for (int i = 0; i < indexTails[0]; i++)
		{
			subElements[0][i] = elements[i];
		}
		//System.out.println("length 0 = " + subElements[0].length);
		
		// following sub elements
		for (int i = 1; i < threadCount; i++)
		{
			int length = indexTails[i] - indexTails[i-1];
			subElements[i] = new int[length];
			for (int j = 0; j < length; j++)
			{
				subElements[i][j] = elements[indexTails[i-1] + j];
			}
			//System.out.println("length " + i + " = " + length);
		}
		
		// print debug
//		{
//			int totalLength = 0;
//			for (int i = 0; i < threadCount; i++)
//			{
//				int length = subElements[i].length;
//				totalLength += length;
//				for (int j = 0; j < length; j++)
//					System.out.print(subElements[i][j] + " ");
//				System.out.println();
//			}
//			System.out.println("Total length = " + totalLength);
//		}
		
		return threadCount;
	}
	
	public int computeByParallel(int threadCount)
	{
		return computeSequential();
	}

	protected int[] elements;
	protected int[][] subElements;
}
