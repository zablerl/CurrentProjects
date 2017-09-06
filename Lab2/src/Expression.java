import java.util.Scanner;

public class Expression
{
	public static void main(String[] args)
	{
		String prompt = "Please enter a mathematical expression (q to exit): ";
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.print(prompt);
			String in = input.nextLine();
			
			// Removing whitespace:
			in = in.trim();
			
			// Comparing entire string
			if (in.equals("q"))  // or .equalsIgnoreCase()
			{
				System.out.println("You found the q");
				System.exit(0);  // Terminates program
			}
			
			// Get index of character
			int index = in.indexOf("+");
			
			
			System.out.println("Index of plus sign: " + index);
			String firstStr = in.substring(0, index);
			String secondStr = in.substring(index + 1);
			// Chop up a string
			if (index != -1)
			{
				
				System.out.println(firstStr);
				System.out.println(secondStr);
			}
			
			try
			{
				int first = Integer.parseInt(firstStr);
				int second = Integer.parseInt(secondStr);
				
				
				
				System.out.println("First int : " + first);
				System.out.println("Second int: " + second);
			}
			catch(Exception e)
			{
				System.out.println("Error occurred");
				continue;
			}
			
			System.out.println(in);
	
		}
	}
}