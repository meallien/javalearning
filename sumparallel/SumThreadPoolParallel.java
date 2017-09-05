package javalearning.sumparallel;

import java.util.concurrent.*;

public class SumThreadPoolParallel extends SumFutureTaskParallel {
	public SumThreadPoolParallel(int length)
	{
		super(length);
	}
	
	public int ComputeByParallel(int threadCount)
	{
		threadCount = splitElements(threadCount);
		if (threadCount <= 0)
			return 0;
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		System.out.println("--Compute by future task parallelism");
		for (int i = 0; i < threadCount; i++)
		{
			Callable<Integer> subsum = new SumCallable(i, subElements[i]);
			Future<Integer> task = pool.submit(subsum);
			tasks.add(task);
		}

		int sum = getResult2();
		
		pool.shutdown();
		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("Largest pool size = " + largestPoolSize);
		
		return sum;
	}
}




