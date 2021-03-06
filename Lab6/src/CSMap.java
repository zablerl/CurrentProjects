import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A class that implements the {@link ICSMap} interface.
 * 
 * @author <Lindsay>
 * Copyright (C) 2017 Canisius College of Buffalo
 */
public class CSMap<K, V> implements ICSMap<K, V>
{
    /** The maximum number of buckets allowed in the map. */
    private static final int MAX_BUCKETS = 10;
    
    /** The bucket list. */
    private List<List<CSEntry<K, V>>> buckets;
    
    /**
     * Creates a new instance of a {@link CSMap}.  Initializes the bucket list.
     */
    public CSMap()
    {
        buckets = new ArrayList<List<CSEntry<K, V>>>();
        
        for ( int i = 0; i < MAX_BUCKETS; i++ )
        {
            buckets.add( new ArrayList<CSEntry<K, V>>() );
        }
    }
    
    @Override
    public V get( K key )
    {
        // TODO: add implementation
    	int num = getBucket(key);
    	for (int i = 0; i < buckets.get(num).size(); i++)
    	{
    		if (buckets.get(num).get(i).getKey().equals(key))
    		{
    			return buckets.get(num).get(i).getValue();
    		}
    	}
        return null;
    }

    @Override
    public V put( K key, V value )
    {
        // TODO: add implementation
    	V temp = null;
    	int num = getBucket(key);
    	CSEntry<K, V> entry = new CSEntry<K, V>(key, value);
    	
    	for (int i = 0; i < buckets.get(num).size(); i++)
    	{
    		if (buckets.get(num).get(i).getKey().equals(key))
    		{
    			temp = buckets.get(num).get(i).getValue();
    			buckets.get(num).get(i).setValue(value);
    			return temp;
    		}
    	}
    	
    	buckets.get(num).add(entry);
    	return null;
    }

    @Override
    public List<K> getKeys()
    {
        // TODO: add implementation
    	LinkedList<K> keys = new LinkedList<K>();
    	
    	for (int i = 0; i < MAX_BUCKETS; i++)
    	{
    		for (int k = 0; k < buckets.get(i).size(); k++)
    		{
    			keys.add(buckets.get(i).get(k).getKey());
    		}
    	}
    	
    	return keys;
    }

    @Override
    public boolean containsKey( K key )
    {
        // TODO: add implementation
    	int num = getBucket(key);
    	for (int i = 0; i < buckets.get(num).size(); i++)
    	{
    		if (buckets.get(num).get(i).getKey().equals(key))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Calculates the bucket that is appropriate for the key.
     * 
     * @param key The key to calculate the bucket for
     * 
     * @return The bucket that is appropriate for the key.
     */
    public int getBucket( K key )
    {
        // XXX: DO NOT MODIFY
        return Math.abs( (key.hashCode() % 7) );
    }
}
