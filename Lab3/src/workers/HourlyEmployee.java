package workers;

/**
 * Base class for an object that defines an hourly employee at a company.
 * 
 * @author Lindsay Zabler
 * Lab: CSC 213
 */

public class HourlyEmployee extends Employee
{
	private double Payrate = 15.60;
	private double hoursWorked;

	protected HourlyEmployee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPayRate() {
		// TODO Auto-generated method stub
		return Payrate;
	}

	@Override
	public double getPaycheckAmount() {
		// TODO Auto-generated method stub
		double amount = Payrate * hoursWorked;
		
		return amount;
	}

	@Override
	public boolean isHourly() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public double getHoursWorked()
	{
		return hoursWorked;
	}
	
	public void setPayRate(double rate)
	{
		Payrate = rate;
	}
	
	public void setHoursWorked(int hours)
	{
		try
		{
			if (hours < 0) 
			{
				throw new Exception("ERROR: the number of hours worked cannot be less than 0");
			}
			else
			{
				hoursWorked = hours;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		
		
	}
	
}