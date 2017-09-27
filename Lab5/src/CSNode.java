public class CSNode<T>
{
	private CSNode<T> next;
	private CSNode<T> prev;
	private T      storedObj;
	
	public CSNode()
	{
		this.prev = null;
		this.next = null;
		this.storedObj = null;
	}
	
	public CSNode(CSNode<T> prev, CSNode<T> next, T storedObj)
	{
		this.prev = prev;
		this.next = next;
		this.storedObj = storedObj;
	}
	
	public CSNode<T> getNext()
	{
		return next;
	}
	
	public void setNext(CSNode<T> next)
	{
		this.next = next;
	}
	
	public CSNode<T> getPrev()
	{
		return prev;
	}
	
	public void setPrev(CSNode<T> prev)
	{
		this.prev = prev;
	}
	
	public T getObject()
	{
		return storedObj;
	}
	
	public void setObject(T obj)
	{
		this.storedObj = obj;
	}
}