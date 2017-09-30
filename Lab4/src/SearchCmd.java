/*
 * Author: Lindsay Zabler
 * Class: CSC 213/L
 * Purpose: Lab 4
 * This is a class that incorporates the File class, the Reader class and the Buffered Reader class
 * for the purpose of reading a file through its text and seeing if the inputed term to search for
 * is located within the file. If term is found, execute() returns true, false otherwise
 */

import java.io.*;

public class SearchCmd
{
	private File inputFile;
	private String search;
	
	public SearchCmd(File in, String str1)
	{
		inputFile = in;
		search = str1;
	}
	
	public boolean validateInputFile()
	{
		if (inputFile.exists())
		{
			if (inputFile.isDirectory() == false)
			{
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean execute() throws IOException
	{
		FileReader readerF = new FileReader(inputFile);
		BufferedReader readerB = new BufferedReader(readerF);
		String line = null;
		
		try
		{
			while((line = readerB.readLine()) != null)
			{
				line = line.toLowerCase();
				if (line.contains(search))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
		}
		finally
		{
			if (readerB != null)
			{
				readerB.close();
			}
			
			if (readerF != null)
			{
				readerF.close();
			}
		}
		
		return false;
	}
}

