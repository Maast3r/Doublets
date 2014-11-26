import java.util.Stack;

public class StackManager extends ChainManager
{
	Stack<Chain> stack;
	
	public StackManager()
	{
		this.stack = new Stack<Chain>();
	}
	
	@Override
	public void add(Chain chain)
	{
		this.stack.push(chain);
		if(this.stack.size() > this.maxSize())
		{
			this.setMaxSize(this.stack.size());
		}
	}

	@Override
	public Chain next()
	{
		incrementNumNexts();
		
		if(this.stack.isEmpty())
		{
			return null;
		}
		return this.stack.pop();
	}
}
