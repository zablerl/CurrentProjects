/**
 * Author: Lindsay Zabler
 * Class: CSC 213/L
 * Lab 7
 * Purpose: Compute the factors of the user-inputed integer using both 
 * a single Thread and an ExecutorService
 */

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		String prompt = "Please enter a non-negative, non-zero integer(q to exit): ";
		String prompt2 = "Please select an option for computation: ";
		
		Scanner input = new Scanner(System.in);
		
		ExecutorService execute = Executors.newSingleThreadExecutor();
		
		while (true)
		{
			System.out.print(prompt);
			String integer = input.nextLine();
			int num = 0;
			
			if (integer.equals("q"))
			{
				execute.shutdown();
				System.exit(0);
			}
			
			try
			{
				num = Integer.parseInt(integer);
				
				if (num > 0)
				{
					
					while(true)
					{
						System.out.println(prompt2);
						System.out.println("1. Stand-alone thread ");
						System.out.println("2. Executor service ");
						String request = input.nextLine();
						
						if (request.equals("1"))
						{
							Thread t = new Thread(new RunnableExample(num));
							t.setName("Stand-alone thread");
							System.out.println("The factors of " + integer + " are:");
							t.start();
							t.join();
							break;
						}
						else if (request.equals("2"))
						{
							Future<?> task = execute.submit(new RunnableExample(num));
							try
							{
								task.get();
								break;
							}
							catch(ExecutionException e)
							{
								
							}
							
						}
						else
						{
							System.out.println("ERROR - invalid selection: " + request);
							continue;
						}
					}
					
				}
				else
				{
					System.out.println("ERROR- invalid intger: " + integer);
					continue;
				}
			}
			catch(Exception e)
			{
				System.out.println("ERROR - invalid integer: " + integer);
			}
			
			
		}

	}
}