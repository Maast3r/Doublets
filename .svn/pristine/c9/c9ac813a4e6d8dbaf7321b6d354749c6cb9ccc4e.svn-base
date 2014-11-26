import java.util.PriorityQueue;


public class PriorityQueueManager extends ChainManager
{
	private PriorityQueue<CompareIt> pq;
	private String end;

	/**
	 * creates a new PriorityQueueManager
	 * 
	 * @param end
	 */
	public PriorityQueueManager(String end)
	{
		this.pq = new PriorityQueue<CompareIt>();
		this.end = end;
	}

	@Override
	public void add(Chain chain)
	{
		this.pq.add(new CompareIt(chain));
		if(this.pq.size() > this.maxSize())
		{
			this.setMaxSize(this.pq.size());
		}
	}

	@Override
	public Chain next()
	{
		incrementNumNexts();
		
		if(this.pq.size() == 0)
		{
			return null;
		}
		return this.pq.remove().chain;
	}
	
	/**
	 * Counts the number of letters in the word that are different from the word we want
	 * 
	 * @param string
	 * @return - the number of different letters
	 */
	public int bestWordCalc (String string)
	{
		int count = 0;
		for(int i = 0; i < string.length(); i++)
		{
			if(string.charAt(i) != this.end.charAt(i))
			{
				count ++;
			}
		}
		return count;
	}
	
	/**
	 * This class compares strings in the chain to the end word and picks the best path
	 * 
	 * @author maas
	 *
	 */
	
	public class CompareIt implements Comparable<CompareIt>
	{
		private int chainInt;
		private Chain chain;
		
		/**
		 * constructs a new compareIt in the Priority queue
		 * @param chain
		 */
		public CompareIt(Chain chain)
		{
			this.chainInt = chain.length() + bestWordCalc(chain.getLast());
			this.chain = chain;
		}
		@Override
		public int compareTo(CompareIt compareIt)
		{
			return this.chainInt - compareIt.chainInt;
		}
		
	}

}
