/*
 * Author: Lindsay Zabler
 * Class: CSC 213/L
 * Purpose: Lab 4
 * This is a class that incorporates the File class, I/O Stream classes, and Buffered I/O Stream classes
 * for the purpose of reading bytes of a file and copying them into the desired file in the desired destination
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

