import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Chain implements Iterable<String>
{
	
	private LinkedList<String> linkedList;
	
	public Chain()
	{
		this.linkedList = new LinkedList<String>();
	}
	
	public Chain(List<String> list, String string)
	{
		this.linkedList = new LinkedList<String>(list);
		this.linkedList.addFirst(string);
	}
	
	public int length()
	{
		return this.linkedList.size();
	}


	@Override
	public Iterator<String> iterator()
	{
		return this.linkedList.descendingIterator();
	}

	public Chain addLast(String string)
	{
		return new Chain(this.linkedList,string);
	}

	public String getLast()
	{
		return this.linkedList.element();
	}

	public boolean contains(String string)
	{
		return this.linkedList.contains(string);
	}

	
	/**
	 * This method makes an array list from a chain
	 * 
	 * @return - is an arraylist of strings
	 */
	public ArrayList<String> getArrayList()
	{
		ArrayList<String> temp = new ArrayList<String>();
		Iterator<String> iterate = this.linkedList.iterator();
		
		while(iterate.hasNext())
		{
			temp.add(0,iterate.next());
		}
		return temp;
	}
	
	
}
