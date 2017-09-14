package cars;

/**
 * Base class that inherits methods from CoolCar class.
 * 
 * @author Lindsay Zabler
 * Lab: CSC 213
 */

public class VolkswagenCar extends CoolCar
{
  
    public VolkswagenCar()
    {
    }
    
    @Override
    public String getBrand()
    {
        return "Volkswagen";
    }
    
    @Override
    public String getModel()
    {
        return "Beetle";
    }
    
    @Override
    public int getModelYear()
    {
        return 1974;
    }
    
    @Override
    public int getMileage()
    {
        return 115492;
    }
    
    @Override
    public double getFuelLevel()
    {
        return 0.25;
    }
    
    @Override
    public boolean hasProblems()
    {
        return true;
    }
    
}