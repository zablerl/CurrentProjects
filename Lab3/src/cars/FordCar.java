package cars;

/**
 * Base class that inherits methods from CoolCar class.
 * 
 * @author Lindsay Zabler
 * Lab: CSC 213
 */

public class FordCar extends CoolCar
{
  
    public FordCar()
    {
    }
    
    @Override
    public String getBrand()
    {
        return "Ford";
    }
    
    @Override
    public String getModel()
    {
        return "Mustang";
    }
    
    @Override
    public int getModelYear()
    {
        return 1968;
    }
    
    @Override
    public int getMileage()
    {
        return 72500;
    }
    
    @Override
    public double getFuelLevel()
    {
        return 0.5;
    }
    
}