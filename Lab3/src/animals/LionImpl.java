package animals;

/**
 * Base class that inherits methods from both Animal and Lion interfaces that defines
 * what a lion is.
 * 
 * @author Lindsay Zabler
 * Lab: CSC 213
 */

public class LionImpl implements Lion
{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("I'm a lion and I eat meat");
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("I'm a lion and I sleep all day long");
		
	}

	@Override
	public void roar() {
		// TODO Auto-generated method stub
		System.out.println("I'm a lion and HEAR ME ROAR");
		
	}

	@Override
	public void beTheKing() {
		// TODO Auto-generated method stub
		System.out.println("I'm a lion and I'm the king of the jungle");
		
	}
	
}