package animals;

/**
 * Base class that inherits methods from both Animal and Penguin interfaces to define
 * what a penguin is.
 * 
 * @author Lindsay Zabler
 * Lab: CSC 213
 */

public class PenguinImpl implements Penguin, Animal
{
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("I'm a penguin and I eat fish");
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("I'm a penguin and I sleep in the cold");
		
	}

	@Override
	public void waddle() {
		// TODO Auto-generated method stub
		System.out.println("I'm a penguin and I waddle around in the cold");
		
	}
}