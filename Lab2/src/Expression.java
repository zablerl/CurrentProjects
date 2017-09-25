import java.util.Scanner;

public class Expression
{
	public static void main(String[] args)
	{
		String prompt = "Please enter a mathematical expression (q to exit): ";
		Scanner input = new Scanner(System.in);
		int index = 0;
		String sign = "";
		int result = 0;
		int num = 0;
		
		while(true)
		{
			System.out.print(prompt);
			String in = input.nextLine();
			
			// Removing whitespace:
			in = in.trim();
			
			// Comparing entire string
			if (in.equals("q"))  // or .equalsIgnoreCase()
			{
				System.out.println("Program will terminate now");
				System.exit(0);  // Terminates program
			}
		
			// Get index of character
			if (in.contains("+"))
			{
				index = in.indexOf("+");
				sign = "+";
			}
			else if (in.contains("-"))
			{
				index = in.indexOf("-");
				sign = "-";
			}
			else if (in.contains("*"))
			{
				index = in.indexOf("*");
				sign = "*";
			}
			else if (in.contains("/"))
			{
				index = in.indexOf("/");
				sign = "/";
			}
			else
			{
				System.out.println("ERROR: invalid or no operator specified - please try again");
				System.out.println("");
				continue;
			}
			
			//System.out.println("Index of sign: " + index);
			
			String firstStr = in.substring(0, index);
			String secondStr = in.substring(index + 1);
			// Chop up a string
			
			firstStr = firstStr.trim();
			secondStr = secondStr.trim();
			/*
			System.out.println(firstStr);
			System.out.println(secondStr);
			*/
			
			try
			{
				int first = Integer.parseInt(firstStr);
				int second = Integer.parseInt(secondStr);
				
				
				if (first < 0 || second < 0)
				{
					System.out.println("ERROR: negative numbers are not allowed");
					System.out.println("");
					continue;
				}
				/*
				System.out.println("First int : " + first);
				System.out.println("Second int: " + second);
				
				System.out.println("Sign: " + sign);
				*/
				
				
				if (sign.equals("+"))
					{
						result = first + second;	
					}
				else if (sign.equals("-"))
				{
					result = first - second;
				}
				else if (sign.equals("*"))
				{
					result = first * second;
				}
				else
				{
					try
					{
						result = first / second;
								
					}
					catch(Exception e)
					{
						System.out.println("ERROR: division by zero");
						System.out.println("");
						continue;
					}
				}
				
				
			}
			catch(Exception e)
			{
				System.out.println("ERROR: invalid number detected");
				System.out.println("");
				continue;
			}
			
			System.out.println("The result is: " + result);
			System.out.println("");
	
		}
	}
}