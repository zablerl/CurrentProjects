import java.io.File;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		String prompt = "Please enter a command(copy|search|exit): ";
		
		Scanner input = new Scanner(System.in);
		Scanner fileInput = new Scanner(System.in);
		Scanner fileOutput = new Scanner(System.in);
		Scanner size = new Scanner(System.in);
		Scanner term = new Scanner(System.in);
		
		String in1 = "";
		String in2 = "";
		String in3 = "";
		
		CopyCmd copy = null;
		SearchCmd searchTerm = null;
		
		
		
		while(true)
		{
			System.out.println(prompt);
			System.out.print(">");
			String in = input.nextLine();
			
			in = in.trim();
	
			if (in.equals("copy"))
			{
				System.out.println("Please enter the path to the file to copy: ");
				System.out.print(">");
				in1 = fileInput.nextLine();
				if (in1.isEmpty() || in1 == null)
				{
					System.out.println("ERROR: the file name cannot be null or empty string");
					continue;
				}
				
				System.out.println("Please enter the destination path: ");
				System.out.print(">");
				in2 = fileOutput.nextLine();
				if (in2.isEmpty() || in2 == null)
				{
					System.out.println("ERROR: the file name cannot be null or empty string");
					continue;
						
				}
				System.out.println("Please enter the size of the read buffer: ");
				System.out.print(">");
				in3 = size.nextLine();
				
				try
				{
					File inputText = new File(in1);
					File outputText = new File(in2);
					
					int buffSize = Integer.parseInt(in3);
					if (buffSize <= 0 || buffSize > 1024)
					{
						System.out.println("ERROR: invalid read length: " + in3);
						continue;
					}
					
					copy = new CopyCmd(buffSize, inputText, outputText);
					
					if (copy.validateInputFile() && copy.validateOutputFile())
					{
						copy.execute();	
					}
					else
					{
						System.out.println("ERROR: input/output files do not exist: " + in1 + "/" + in2);
						continue;
					}
						
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
				
				
			}
			
			else if (in.equals("search"))
			{
				System.out.println("Please enter the path to the file to search: ");
				System.out.print(">");
				in1 = fileInput.nextLine();
				if (in1.isEmpty() || in1 == null)
				{
					System.out.println("ERROR: the file name cannot be null or empty string");
					continue;
				}
				
				System.out.println("Please enter the term to search for: ");
				System.out.print(">");
				String search = term.nextLine();
				
				try
				{
					File inputTxt = new File(in1);
					searchTerm = new SearchCmd(inputTxt, search);
					
					if (searchTerm.validateInputFile())
					{
						if (searchTerm.execute())
						{
							System.out.println("Term found!");
						}
						else
						{
							System.out.println("Term not found!");
						}
					}	
					else
					{
						System.out.println("ERROR: input file does not exist: " + in1);
						continue;
					}
					
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}	
				
				
			}
			
			else if (in.equals("exit"))
			{
				System.exit(0);
			}
			
			else
			{
				System.out.println("Command is invalid");
			}
		
		}
		
	}
}