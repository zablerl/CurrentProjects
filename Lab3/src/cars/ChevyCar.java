package cars;

/**
 * Base class that inherits methods from CoolCar class.
 * 
 * @author Lindsay Zabler
 * Lab: CSC 213
 */

public class ChevyCar extends CoolCar
{
  
    public ChevyCar()
    {
    }
    
    @Override
    public String getBrand()
    {
        return "Chevrolet";
    }
    
    @Override
    public String getModel()
    {
        return "Camaro";
    }
    
    @Override
    public int getModelYear()
    {
        return 1970;
    }
    
    @Override
    public int getMileage()
    {
        return 32768;
    }
    
    @Override
    public double getFuelLevel()
    {
        return 0.75;
    }
    
}
