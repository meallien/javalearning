package javalearning.sumparallel;

public class Tester {
	public static void main(String[] args)
	{
		System.out.println("Hello World");
		long startTime = 0;
		long endTime = 0;
		int maxElement = 10003;
		int threadCount = 2000;

//		startTime = System.nanoTime();
//		SumParallel computer = new SumParallel(maxElement);
//		int sum = computer.computeSequential();
//		endTime = System.nanoTime();
//		System.out.println("Sequential sum = " + sum + ", cost time " + (endTime-startTime) + " ns.");

//		startTime = System.nanoTime();
//		SumParallel computer2 = new SumThreadParallel(maxElement);
//		int sum2 = computer2.computeByParallel(threadCount);
//		endTime = System.nanoTime();
//		System.out.println("Thread Parallel sum = " + sum2 + ", cost time " + (endTime-startTime) + " ns.");

//		startTime = System.nanoTime();
//		SumParallel computer3 = new SumFutureTaskParallel(maxElement);
//		int sum3 = computer3.computeByParallel(threadCount);
//		endTime = System.nanoTime();
//		System.out.println("Future Task Parallel sum = " + sum3 + ", cost time " + (endTime-startTime) + " ns.");

		startTime = System.nanoTime();
		SumParallel computer4 = new SumThreadPoolParallel(maxElement);
		int sum4 = computer4.computeByParallel(threadCount);
		endTime = System.nanoTime();
		System.out.println("Future Task Parallel sum = " + sum4 + ", cost time " + (endTime-startTime) + " ns.");
	}
}
