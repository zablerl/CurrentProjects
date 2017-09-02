import java.util.Scanner;

/**
 * Javadoc
 * @author zablerl
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		// Output to the console
		System.out.println("Hello World!");
		System.out.println("This is CSC213");
		
		// Getting input from user
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println("You typed: " + s);
		
		// Getting input from user forever
		while(true)
		{
			System.out.print(">");
			String s1 = input.nextLine();
			System.out.println("You type: " + s1);
		}
	}
}