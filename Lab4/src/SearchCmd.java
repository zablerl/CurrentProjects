import java.io.*;

public class SearchCmd
{
	private File inputFile;
	private String search;
	
	public SearchCmd(File in, String str1)
	{
		inputFile = in;
		search = str1
	}
	
	public boolean validateInputFile()
	{
		if (inputFile.isDirectory())
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public boolean execute() throws IOException
	{
		FileReader readerF = new FileReader(inputFile);
		BufferedReader readerB = new BufferedReader(readerF);
		
		try
		{
			String line;
			while (readerB.readLine() != null)
			{
				line = readerB.readLine();
				if (line.contains(search))
				{
					return true;
				}
			}
		}
		finally
		{
			if (readerB != null)
			{
				readerB.close();
			}
		}
		
		return false;
	}
}

