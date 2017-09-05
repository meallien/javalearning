package javalearning;

/* GiveMoney
 * For N members in a competition, each of them has a score. One knows his neighbor's score if this score is less than himself.
 * Now give money to all members, at least 1 dollar each.
 * One member will be happy if his money is higher than his lower score neighbor.
 * Problem: How much will be given to all these members?
 * 
 * Case: 10 members with score: {20, 32, 12, 32, 45, 11, 21, 31, 41, 33}
 * */

public class GiveMoney {
	public static void main(String[] args)
	{
		GiveMoney money = new GiveMoney();
		int total = money.give();
		System.out.println("Total give: " + total);
	}
	
	public GiveMoney()
	{
		// scores = {20, 32, 12, 32, 45, 11, 21, 31, 41, 33};
		money = new int[scores.length];
		for (int i = 0; i < money.length; i++)
		{
			money[i] = 1;
		}
	}
	
	public int give()
	{
		while (checkMoney())
		{
			;
		}
		
		int sum = 0;
		for (int i = 0; i < money.length; i++)
		{
			sum += money[i];
		}
		return sum;
	}
	
	private boolean checkMoney()
	{
		boolean moneyChanged = false;
		for (int i = 0; i < scores.length; i++)
		{
			if (scoreHigherThanLeft(i))
			{
				if (money[i] <= getLeftMoney(i))
				{
					money[i]++;
					moneyChanged = true;
					//System.out.println("Add to " + i + " member with score " + scores[i] + " by left");
				}
			}
			
			if (scoreHigherThanRight(i))
			{
				if (money[i] <= getRightMoney(i))
				{
					money[i]++;
					moneyChanged = true;
					//System.out.println("Add to " + i + " member with score " + scores[i] + " by right");
				}
			}	
		}
//		for (int i = 0; i < scores.length; i++)
//		{
//			System.out.print(scores[i] + " ");	
//		}
//		System.out.println();
		for (int i = 0; i < money.length; i++)
		{
			System.out.print(money[i] + "  ");	
		}
		
		System.out.println();
		System.out.println();
		return moneyChanged;
	}
	
	private int getLeftMoney(int index)
	{
		if (index <= 0)
			return 0;
		if (index >= scores.length)
			return 0;
		return money[index-1];
	}
	
	private int getRightMoney(int index)
	{
		if (index < 0)
			return 0;
		if (index >= scores.length -1)
			return 0;
		return money[index+1];
	}
	
	private boolean scoreHigherThanLeft(int index)
	{
		return scores[index] > getLeftScore(index);
	}
	
	private int getLeftScore(int index)
	{
		if (index <= 0)
			return 0;
		if (index >= scores.length)
			return 0;
		return scores[index-1];
	}

	private boolean scoreHigherThanRight(int index)
	{
		return scores[index] > getRightScore(index);
	}
	
	private int getRightScore(int index)
	{
		if (index < 0)
			return 0;
		if (index >= scores.length -1)
			return 0;
		return scores[index+1];
	}
	
	private int[] scores = {20, 32, 12, 32, 45, 11, 21, 31, 41, 33};
	private int[] money;
}
