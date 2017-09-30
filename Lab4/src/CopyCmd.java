/*
 * Author: Lindsay Zabler
 * Class: CSC 213/L
 * Purpose: Lab 4
 * This is a class that incorporates the File class, I/O Stream classes, and Buffered I/O Stream classes
 * for the purpose of reading bytes of a file and copying them into the desired file in the desired destination
 */

import java.io.*;

public class CopyCmd
{
	private int bufferSize;
	private File inputFile;
	private File outputFile;
	
	public CopyCmd(int read1, File in, File out)
	{
		bufferSize = read1;
		inputFile = in;
		outputFile = out; 
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
	
	public boolean validateOutputFile()
	{
		if (outputFile.isDirectory() == false)
			{
				return true;
			}
		return false;
	}
	public void execute() throws IOException
	{
		FileInputStream fisIn = new FileInputStream (inputFile);
		BufferedInputStream bisIn = new BufferedInputStream(fisIn);
		FileOutputStream fosOut = new FileOutputStream(outputFile);
		BufferedOutputStream bosOut = new BufferedOutputStream(fosOut);
		
		long size = inputFile.length();
		long numRead = 0;
		long remains = size;
		
		try
		{
			while (remains > 0)
			{
				byte[] bytesToBeWritten;
				
				
				if (remains >= bufferSize)
				{
					bytesToBeWritten = new byte[bufferSize];
				}
				else
				{
					bytesToBeWritten = new byte[(int)remains];
				}
				
				numRead = bisIn.read(bytesToBeWritten);
				bosOut.write(bytesToBeWritten, 0, bytesToBeWritten.length);
				
				remains -= numRead;
			}
			
			bosOut.flush();
		}
			finally
			{
				if (bisIn != null)
				{
					bisIn.close();
				}
				
				if (fisIn != null)
				{
					fisIn.close();
				}
				
				if (fosOut != null)
				{
					fosOut.close();
				}
				
				if (bosOut != null)
				{
					fosOut.close();
				}
			}
		}
		
	}

