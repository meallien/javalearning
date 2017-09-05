package javalearning.sumparallel;

import java.util.ArrayList;
import java.util.concurrent.*;

public class SumFutureTaskParallel extends SumParallel {	
	public SumFutureTaskParallel(int length)
	{
		super(length);
		tasks = new ArrayList<Future<Integer>>();
	}
	
	public int computeByParallel(int threadCount)
	{
		threadCount = splitElements(threadCount);
		if (threadCount <= 0)
			return 0;
		
		System.out.println("--Compute by future task parallelism");
		for (int i = 0; i < threadCount; i++)
		{
			Callable<Integer> subsum = new SumCallable(i, subElements[i]);
			FutureTask<Integer> task = new FutureTask<Integer>(subsum);
			tasks.add(task);
			Thread t = new Thread(task);
			t.start();
		}
		

		int sum = getResult2();
		return sum;
	}
	
	protected int getResult1()
	{
		int sum = 0;
		while (true)
		{
			try
			{
				for (Future<Integer> task : tasks)
				{
					if (task.isDone())
					{
						int subsum = task.get();
						sum += subsum;
						tasks.remove(task);
						//System.out.println("GetResult1 get subsum " + subsum);
						break;
					}
				}
			}
			catch (ExecutionException xe)
			{}
			catch (InterruptedException ie)
			{}
			
			if (tasks.isEmpty())
				break;
		}
		return sum;
	}
	
	protected int getResult2()
	{
		int sum = 0;
		while (true)
		{
			for (Future<Integer> task : tasks)
			{
				try
				{
					int subsum = task.get(10, TimeUnit.MICROSECONDS);
					sum += subsum;
					tasks.remove(task);
					break;
				}
				catch (TimeoutException e)
				{
					continue;
				}
				catch (ExecutionException xe)
				{}
				catch (InterruptedException ie)
				{}
			}
			
			if (tasks.isEmpty())
				break;
		}
		return sum;
	}
	
	protected ArrayList<Future<Integer>> tasks;
}


class SumCallable implements Callable<Integer>
{
	public SumCallable(int id, int[] values)
	{
		this.id = id;
		this.values = values;
	}
	
	
	public Integer call()
	{
		int sum = 0;
		//for (int i = 0; i < 20; i++)
		{
			for (int a : values)
				sum += a;			
		}
		
//		try
//		{
//			Thread.sleep((long)(100 * Math.random()));	
//		}
//		catch (InterruptedException e)
//		{}
		
//		System.out.println("Future Task " + id + " gets subsum: " + sum);
		return sum;
	}
	
	private int id;
	private int[] values;
}
