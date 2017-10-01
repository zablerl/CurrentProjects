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
		while (run != tail.getNext())
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
			head.setNext(newNode);
			newNode.setPrev(head);
			newNode.setNext(null);
			newNode.setObject(e);
			tail = newNode;
			return true;
		}
		else if (head.getNext() != null)
		{
			run = head;
			while (run.getNext() != null)
			{
				run = run.getNext();
			}
			
			newNode = run.getNext();
			newNode.setPrev(run);
			newNode.setPrev(null);
			newNode.setObject(e);
			tail = newNode;
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean remove(E o) 
	{
		// TODO Auto-generated method stub
		if (head.getObject() == o)
		{
			head = head.getNext();
			head.setPrev(null);
			return true;
		}
		
		if (tail.getObject() == o)
		{
			tail = tail.getPrev();
			tail.setNext(null);
			return true;
		}
		
		run = head;
		CSNode<E> temp = new CSNode<E>();
		while (run != null)
		{
			if (run.getObject() == o)
			{
				temp = run.getNext();
				temp.setPrev(run.getPrev());
				run.getPrev().setNext(temp);
				run = null;
				return true;
			
			}
			run = run.getNext();
		}
		return false;
	}

	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		head = null;
		tail = null;
		
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		try
		{
			int counter = 0;
			if (index == 0)
			{
				return head.getObject();
			}
			run = head;
			while (run == tail.getNext())
			{
				if (counter == index)
				{
					return run.getObject();
				}
				counter++;
				run = run.getNext();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public E set(int index, E element) throws IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		try
		{
			int counter = 0;
			E temp = null;
			if (index == 0)
			{
				temp = head.getObject();
				head.setObject(element);
				return temp;
			}
			run = head;
			while (run == tail.getNext())
			{
				if (counter == index)
				{
					temp = run.getObject();
					run.setObject(element);
					return temp;
				}
				counter++;
				run = run.getNext();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}

	
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		try
		{
			int counter = 0;
			CSNode<E> temp = new CSNode<E>();
			CSNode<E> newNode = new CSNode<E>();
			newNode.setObject(element);
			if (index == 0)
			{
				temp = head;
				temp.setNext(head.getNext());
				temp.setPrev(head.getPrev());
				head = newNode;
				head.setPrev(null);
				head.setNext(temp);
				
			}
			run = head;
			while (run == tail.getNext())
			{
				if (counter == index)
				{
					newNode.setPrev(run.getPrev());
					run.getPrev().setPrev(newNode);
					run.setPrev(newNode);
					newNode.setNext(run);
					
				}
				counter++;
				run = run.getNext();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

	@Override
	public E remove(int index) throws IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E o) 
	{
		// TODO Auto-generated method stub
		int counter = 0;
		if (head.getObject() == o)
		{
			return 0;
		}
		run = head;
		while (run == tail.getNext())
		{
			if (run.getObject() == o)
			{
				return counter;
			}
			counter++;
			run = run.getNext();
		}
		return -1;
	}

	@Override
	public void sort(Comparator<E> comparator) {
		// TODO Auto-generated method stub
		
	}
	
}