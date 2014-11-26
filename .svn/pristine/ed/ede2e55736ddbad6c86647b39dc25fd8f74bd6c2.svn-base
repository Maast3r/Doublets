import java.util.LinkedList;
import java.util.Queue;


public class QueueManager extends ChainManager
{
	private Queue<Chain> queue;
	
	public QueueManager()
	{
		this.queue = new LinkedList<Chain>();
	}

	@Override
	public void add(Chain chain)
	{
		this.queue.add(chain);
		if(this.queue.size() > this.maxSize())
		{
			setMaxSize(this.queue.size());
		}
	}

	@Override
	public Chain next()
	{
		incrementNumNexts();
		
		if(this.queue.size() == 0)
		{
			return null;
		}
		return this.queue.remove();
	}

}
