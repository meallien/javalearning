package javalearning.sumparallel;

public class SumThreadParallel extends SumParallel {
	public SumThreadParallel(int length)
	{
		super(length);
	}
	
	public int computeByParallel(int threadCount)
	{
		threadCount = splitElements(threadCount);
		if (threadCount <= 0)
			return 0;
		
		System.out.println("--Compute by thread parallelism");
		for (int i = 0; i < threadCount; i++)
		{
			SumRunnable task = new SumRunnable(i, subElements[i], this);
			Thread t = new Thread(task);
			t.start();
		}
		
		while (true)
		{
			if (readyThreads == threadCount)
			{
				break;
			}
		}
		
		return this.sum;
	}
	public synchronized void onSubSum(int id, int sum)
	{		
		int temp = this.sum;
		//this.sum += sum;
		//System.out.println("[" + id + "]OnSubSum sum = " + sum);
		this.sum = temp + sum;
		readyThreads++;
	}
	
	private volatile int sum;
	private volatile int readyThreads;
}


class SumRunnable implements Runnable
{
	public SumRunnable(int id, int[] values, SumThreadParallel callback)
	{
		this.id = id;
		this.values = values;
		this.callback = callback;
	}
	
	
	public void run()
	{
		int sum = 0;

		//for (int i = 0; i < 20; i++)
		{
			for (int a : values)
				sum += a;			
		}
		
//		try
//		{
//			int delay = (int)(100 * Math.random());
//			//System.out.println("Sleep " + delay + " ms");
//			Thread.sleep(delay);	
//		}
//		catch (InterruptedException e)
//		{
//			//System.out.println("InterruptedException");
//		}
		
		callback.onSubSum(id, sum);
	}
	
	private int id;
	private int[] values;
	private SumThreadParallel callback;
}
