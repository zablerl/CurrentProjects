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
		if (inputFile.isDirectory())
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public boolean validateOutputFile()
	{
		if (outputFile.isDirectory())
		{
			return false;
		}
		else
		{
			return true;
		}
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
				int num;
				
				if (remains >= bufferSize)
				{
					bytesToBeWritten = new byte[bufferSize];
				}
				else
				{
					bytesToBeWritten = new byte[(int)remains];
				}
				
				num = bisIn.read(bytesToBeWritten);
				bosOut.write(bytesToBeWritten, 0, bytesToBeWritten.length);
				
				remains -= num;
			}
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

