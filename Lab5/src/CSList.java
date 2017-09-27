import java.util.Comparator;

public class CSList<E> implements ICSList<E>
{
	private CSNode<E> head = new CSNode<E>();
	private CSNode<E> tail = new CSNode<E>();
	private CSNode<E> run = new CSNode<E>();
	
	
	
	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		int counter = 0;
		if (head.getNext() == null)
		{
			return 0;
		}
		run = head;
		while (run != null)
		{
			counter++;
			run = run.getNext();
		}
		return counter;
		
	}

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		if (head.getNext() == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E o) 
	{
		// TODO Auto-generated method stub
		if (head.getNext() == null)
		{
			return false;
		}
		head = run;
		while (run != null)
		{
			if (run.getObject() == o)
			{
				return true;
			}
			run = run.getNext();
		}
		return false;
	}
		

	@Override
	public boolean add(E e) 
	{
		// TODO Auto-generated method stub
		CSNode<E> newNode = new CSNode<E>();
		if (head.getNext() == null)
		{
			newNode = head.getNext();
			newNode.setPrev(head);
			newNode.setNext(null);
			newNode.setObject(e);
			tail = newNode;
		}
		
		CSNode<E> temp = new CSNode<E>();
		
			
		return false;
	}

	@Override
	public boolean remove(E o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sort(Comparator<E> comparator) {
		// TODO Auto-generated method stub
		
	}
	
}