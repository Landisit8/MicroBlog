import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
/*
 * @author Federico Landini
 */
public class SocialNetwork implements ISocialNetwork{
	
	//variabili
	private Map<String,Set<String>> reteSociale; 	//network
	private List<Post> tuttiPost;					//lista
	
	//costruttore
	public SocialNetwork() {
		reteSociale = new HashMap<>();
		tuttiPost = new Vector<>();
	}
	
	//metodi
	public void loadList(Post p)
	{
		tuttiPost.add(p);
	}
	
	public List<Post> gettuttiPost() {
		return this.tuttiPost;
	}
	
	//1)
	public Map<String, Set<String>> guessFollowers(List<Post> ps)
	{
		if (gettuttiPost().size() == 0)
			return null;
		else
		{
			for (Post p : ps)
				if (p.getClass() == Follow.class)
				{
					Set<String> seguiti = new HashSet<>();
					Follow f = (Follow) p;
					reteSociale.putIfAbsent(f.getAuthorF(), seguiti);
					reteSociale.get(f.getAuthorF()).add(p.getAuthor());
				}
			return reteSociale;
		}
	}
		
	//2
	public List<String> influencers()
	{
		if (gettuttiPost().size() == 0)
			return null;
		else
		{
			Map<String,Integer> influencers = new HashMap<>();
			List<String> listOrder = new ArrayList<String>();
			Set<String> sizeSet = new HashSet<String>();
			String maxKey = new String();
		
			for (Post p : tuttiPost)
				if (p.getClass() == Follow.class)
				{
					Follow f = (Follow)p;
					influencers.putIfAbsent(f.getAuthor(), 0);
					influencers.put(f.getAuthor(),influencers.get(f.getAuthor())+1);
				}
				else
					influencers.putIfAbsent(p.getAuthor(), 0);	
		
			sizeSet = influencers.keySet();
			for (int i=0; i<sizeSet.size();i++)
			{
				int maxValue = 0;
				for (Map.Entry<String,Integer> entry : influencers.entrySet())	
					if (entry.getValue() >= maxValue)
					{
						maxValue = entry.getValue();
						maxKey = entry.getKey();
					}
				listOrder.add(maxKey);
				influencers.replace(maxKey, -1);
			}
			return listOrder;	
		}
	}
	
	//3
	public Set<String> getMentionedUsers()
	{
		if (gettuttiPost().size() == 0)
			return null;
		else
		{
			Set<String> menzionati = new HashSet<String>();
			String[] a;
			for (Post p : this.tuttiPost)
				if(p.getText().contains("@"))
				{
					a = p.getText().split(" ");
					for (String b : a)
						if(b.contains("@"))
							menzionati.add(b);
				}
			return menzionati;
		}
	}
	
	//4
	public Set<String> getMentionedUsers(List<Post> ps)
	{
		if (gettuttiPost().size() == 0)
			return null;
		else
		{
			Set<String> menzionati = new HashSet<String>();
			String[] a;
			for (Post p : ps)
				if(p.getText().contains("@"))
				{
					a = p.getText().split(" ");
					for (String b : a)
						if(b.contains("@"))
							menzionati.add(b);
				}
			return menzionati;
		}
	}
	
	//5
	public List<Post> writtenBy(String username)
	{
		if (gettuttiPost().size() == 0)
			return null;
		else
		{
			List<Post> thePost = new Vector<>();
			for (Post p : this.tuttiPost)
				if (p.getClass() != Follow.class)
					if (p.getAuthor().equals(username))
						thePost.add(p);
			return thePost;
		}
	}
	//6
	public List<Post> writtenBy(List<Post> ps, String username)
	{
		if (gettuttiPost().size() == 0)
			return null;
		else
		{
			List<Post> thePost = new Vector<>();
			for (Post p : ps)
				if (p.getClass() != Follow.class)
					if (p.getAuthor().equals(username))
						thePost.add(p);
			return thePost;	
		}
	}
	
	//7
	public List<Post> containing(List<String> words)
	{
		if (gettuttiPost().size() == 0)
			return null;
		else
		{
			List<Post> thePost = new Vector<>();
			for(String word: words)
				for(Post ps: this.tuttiPost)
            		if (ps.getClass() != Follow.class)
            			if(ps.getText().contains(word))
            				thePost.add(ps);
			return thePost;
		}
	}
}