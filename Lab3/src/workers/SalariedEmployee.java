package workers;

/**
 * Base class for an object that defines an hourly employee at a company.
 * 
 * @author Lindsay Zabler
 * Lab: CSC 213
 */

public class SalariedEmployee extends Employee
{

	double Payrate;
	
	protected SalariedEmployee(String name) {
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
		
		double ammount = Payrate / 26;
		
		return ammount;
	}

	@Override
	public boolean isHourly() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setPayRate(double rate)
	{
		Payrate = rate;
	}
	
}