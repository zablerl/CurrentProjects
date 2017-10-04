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
		while (run != tail)
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
		CSNode<E> newNode = new CSNode<E>();
		newNode.setObject(e);
		
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
		while (run != tail)
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
			
	
		return false;
	}

	@Override
	public boolean remove(E o) 
	{
		// TODO Auto-generated method stub
		
		CSNode<E> newNode = new CSNode<E>();
			
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
		while (run != tail)
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
	public E get(int index) 
	{
		// TODO Auto-generated method stub
		
		int counter = 0;
		
		if (index > size() || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0)
		{
			return head.getNext().getObject();
		}
		run = head.getNext();
		while (run != tail)
		{
			if (counter == index)
			{
				return run.getObject();
			}
			counter++;
			run = run.getNext();
		}
		
		return null;
	}

	@Override
	public E set(int index, E element) 
	{
		// TODO Auto-generated method stub
		
		int counter = 0;
		E temp = null;
		
		if (index > size() || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0)
		{
			temp = head.getNext().getObject();
			head.getNext().setObject(element);
			return temp;
		}
		run = head.getNext();
		while (run != tail)
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
		
		return null;
	}

	
	@Override
	public void add(int index, E element)
	{
		// TODO Auto-generated method stub
		
		int counter = 0;
		CSNode<E> temp = new CSNode<E>();
		CSNode<E> newNode = new CSNode<E>();
		newNode.setObject(element);
		
		if (index > size() || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0)
		{
			temp = head.getNext();
			head.setNext(newNode);
			newNode.setPrev(head);
			newNode.setNext(temp);
				
		}
		run = head.getNext();
		while (run != tail)
		{
			if (counter == index)
			{
				temp = run.getPrev();
				run.getPrev().setNext(newNode);
				newNode.setPrev(temp);
				newNode.setNext(run);
				run.setPrev(newNode);
					
			}
			counter++;
			run = run.getNext();
		}
	}
	

	@Override
	public E remove(int index)
	{
		// TODO Auto-generated method stub
		
		int counter = 0;
		E temp = null;
		CSNode<E> temp1 = new CSNode<E>();
		
		if (index > size() || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0)
		{
			temp = head.getNext().getObject();
			head = head.getNext();
			head.setPrev(null);
			head.setObject(null);
			return temp;
		}
		run = head.getNext();
		while (run != tail)
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

		while (run != tail)
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
		CSNode<E> temp = new CSNode<E>();
		E val1 = null;
		E val2 = null;
		
		for (int i = 1; i < size(); i++)
		{
			for (int j = i; j > 0; j--)
			{
				val1 = get(j);
				val2 = get(j-1);
				if (comparator.compare(val1, val2) == -1)
				{
					temp.setObject(val1);
					set(j, val2);
					set(j-1, temp.getObject());
				}
			}
		}
		
	
		
		
		
	}
	
}