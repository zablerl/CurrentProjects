/**
 * Author: Lindsay Zabler
 * Purpose: Helpful interface to be used by the Thread and ExecutorService
 * so that the both objects can compute the factors.
 */

import java.util.ArrayList;

public class RunnableExample implements Runnable
{
	private int num;
	
	public RunnableExample(int num)
	{
		this.num = num;
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		try
		{
			ArrayList<Integer> factors = new ArrayList<Integer>();
			for (int current = 1; current <= num; current++)
			{
				if ((num % current) == 0)
				{
					factors.add(current);
				}
			}
			
			for (int i = 0; i < factors.size(); i++)
			{
				System.out.print(factors.get(i) + ",");
				Thread.sleep(500);
			}
			System.out.println();
		}
		catch(Exception e)
		{
			
		}
		
			
		
	}
	
}