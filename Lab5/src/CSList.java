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
		run = head.getNext();
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
		run = head.getNext();
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
		try
		{
			CSNode<E> newNode = new CSNode<E>();
			if (e == null)
			{
				throw new NullPointerException();
			}
			if (head.getNext() == null)
			{
				head.setNext(newNode);
				tail.setPrev(newNode);
				newNode.setObject(e);
				newNode.setNext(tail);
				newNode.setPrev(head);
				return true;
			}
			
			run = head.getNext();
			while (run != null)
			{
				if (run == tail.getPrev())
				{
					newNode.setObject(e);
					run.setNext(newNode);
					newNode.setPrev(run);
					newNode.setNext(tail);
					tail.setPrev(newNode);
						
					return true;
				}
				run = run.getNext();
			}
			
		}
		catch(Exception except)
		{
			System.out.println(except);
		}
		return false;
	}

	@Override
	public boolean remove(E o) 
	{
		// TODO Auto-generated method stub
		if (head.getNext().getObject() == o)
		{
			head = head.getNext();
			head.setPrev(null);
			head.setObject(null);
			return true;
		}
		
		if (tail.getPrev().getObject() == o)
		{
			tail = tail.getPrev();
			tail.setNext(null);
			tail.setObject(null);
			return true;
		}
		
		run = head.getNext();
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
		head.setNext(null);
		tail.setPrev(null);
		
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
				return head.getNext().getObject();
			}
			run = head.getNext();
			while (run != null)
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
				temp = head.getNext().getObject();
				head.getNext().setObject(element);
				return temp;
			}
			run = head.getNext();
			while (run != null)
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
			if (index == 0)
			{
				temp = head.getNext();
				temp.setNext(head.getNext().getNext());
				head = newNode;
				head.setPrev(null);
				head.setNext(temp);
				head.setObject(null);
				temp.setPrev(head);
				
			}
			run = head.getNext();
			while (run != null)
			{
				if (counter == index)
				{
					newNode.setPrev(run.getPrev());
					run.getPrev().setPrev(newNode);
					run.setPrev(newNode);
					newNode.setNext(run);
					newNode.setObject(element);
					
				}
				if (run.equals(tail.getPrev()))
				{
					temp = tail.getPrev();
					temp.setPrev(tail.getPrev().getPrev());
					tail = newNode;
					tail.setPrev(temp);
					tail.setNext(null);
					tail.setObject(null);
					temp.setNext(tail);
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
		try
		{
			int counter = 0;
			E temp = null;
			CSNode<E> temp1 = new CSNode<E>();
			if (index == 0)
			{
				temp = head.getNext().getObject();
				head = head.getNext();
				head.setPrev(null);
				head.setObject(null);
				return temp;
			}
			run = head.getNext();
			while (run != null)
			{
				if (counter == index)
				{
					temp = run.getObject();
					temp1.setPrev(run.getPrev());
					run = run.getNext();
					run.setPrev(temp1.getPrev());
					return temp;
				}
				if (run.equals(tail.getPrev()))
				{
					temp = tail.getPrev().getObject();
					tail = tail.getPrev();
					tail.setNext(null);
					tail.setObject(null);
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
	public int indexOf(E o) 
	{
		// TODO Auto-generated method stub
		int counter = 0;
		if (head.getNext().getObject() == o)
		{
			return 0;
		}
		run = head.getNext();
		while (run != null)
		{
			if (run.getObject() == o)
			{
				return counter;
			}
			if (tail.getPrev().getObject() == o)
			{
				return counter;
			}
			counter++;
			run = run.getNext();
		}
		return -1;
	}

	@Override
	public void sort(Comparator<E> comparator) 
	{
		// TODO Auto-generated method stub
		CSNode<E> newHead = new CSNode<E>();
		CSNode<E> newTail = new CSNode<E>();
		
		run = head.getNext();
		while (run != null)
		{
			
		}
		
	}
	
}