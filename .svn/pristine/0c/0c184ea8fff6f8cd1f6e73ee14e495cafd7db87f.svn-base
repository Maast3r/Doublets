import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 * Contains the general algorithm to search for doublets.
 * 
 * @author <<Andrew Ma, Tyler Johnson, Madison Bruner>> Created Mar 18, 2011.
 */
public class Doublets
{
	private static boolean exit = false;
	
	private Links link;

	public Doublets(Links link)
	{
		this.link = link;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Doublets, a game of verbal torture.");
		Scanner reader = new Scanner(System.in);
		
		//creates the links from "english.cleaned.all.35.txt"
		Links dictionary = getDictionary();
		
		//creates a new doublets using the links
		Doublets doublets = new Doublets(dictionary);
		
		while (!exit)
		{
			System.out.println("Enter starting word: ");
			String start = reader.nextLine().trim().toLowerCase();
			if(!dictionary.getDictionaryList().contains(start))
			{
				//first word isn't in the text file, break
				System.out.println("That word is not in the dictionary.");
				System.out.println("Deuces ;)");
				break;
			}
			System.out.println("Enter ending word: ");
			String end = reader.nextLine().trim().toLowerCase();
			if(!dictionary.getDictionaryList().contains(end))
			{
				//second word isn't in the text file, break
				System.out.println("That word is not in the dictionary.");
				System.out.println("Deuces ;)");
				break;
			}
			
			if(start.length() != end.length())
			{
				//words are not equal length
				System.out.println("The start and end aren't equal length.");
				System.out.println("Deuces ;)");
				break;
			}
			
			System.out
					.println("Enter chain manager(s: stack, q: queue, p: priority queue, x: exit): ");
			String chainString = reader.nextLine();
			char chainLetter = chainString.charAt(0);
			
			ChainManager chainManager = new StackManager();
			if (chainLetter == 's')
			{
				// stack
				chainManager = new StackManager();
			}
			else if (chainLetter == 'q')
			{
				// queue
				chainManager = new QueueManager();
			}
			else if (chainLetter == 'p')
			{
				// priority queue
				chainManager = new PriorityQueueManager(end);
							}
			else if (chainLetter == 'x')
			{
				// exit program
				System.out.println("Deuces ;)");
				exit = true;
				break;
			}
			else if(chainString.length() > 1)
			{
				// throw exception, the two strings are not of equal length.
				System.out.println("That was not a valid choice.");
				System.out.println("Deuces ;)");
				break;
			}
			
			Chain chain = doublets.getChain(start, end, chainManager);
			if(chain != null)
			{
				ArrayList<String> list = chain.getArrayList();
				System.out.println("Chain: " + list);
				System.out.println("Length: " + chain.length());
				System.out.println("Candidates: " + chainManager.getNumberOfNexts());
				System.out.println("Max Size: " + chainManager.maxSize());
				System.out.println("");
			}
			else
			{
				//no chain between start and end
				System.out.println("No chain between these two words.");
				System.out.println("Deuces ;)");
				break;
			}
		}
		reader.close();
	}

	/**
	 * Gets the chain depending on if the user asked for stack, queue, or priority queue
	 * @param start word
	 * @param end word
	 * @param chainManager (that the user chooses)
	 * @return Chain
	 */
	public Chain getChain(String start, String end, ChainManager chainManager)
	{
		Chain newChain = new Chain();
		newChain = newChain.addLast(start);
		
		chainManager.add(newChain);
		
		while(newChain != null)
		{
			newChain = chainManager.next();
			
			if(newChain != null)
			{
				String temp = newChain.getLast();
				
				if(temp.equals(end))
				{
					//once you get to the end
					return newChain;
				}
				
				Set<String> set = this.link.getCandidates(temp);
				
				if(set == null)
				{
					//nothing in the set
					return null;
				}
				for(String s: set)
				{
					if(!newChain.contains(s))
					{
						//making sure there are no doubles
						chainManager.add(newChain.addLast(s));
					}
				}
			}
			else
			{
				return null;
			}		
		}
		return null;
	}
	
	public Set<String> getCandidates(String string)
	{
		return this.link.getCandidates(string);
	}
	public static Links getDictionary()
	{
		return new Links("english.cleaned.all.35.txt");
	}
}
