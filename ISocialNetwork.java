import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * @author Federico Landini
 */
public interface ISocialNetwork {
	
	// @REQUIRES:	true 
	// @MODIFIES:	modifico la lista dei post 
	// @THROWS:		niente
	// @EFFECTS:	carico la lista dei post
	// @RETURN:		niente
	public void loadList(Post p);
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	niente
	// @RETURN:		Lista di tutti i post
	public List<Post> gettuttiPost();
	
	// @REQUIRES:	true 
	// @MODIFIES:	modifica le proprieta' della map<string, set<string>>
	//				da notare che viene caricata in questo formato: <autore follow,autore post>
	// @THROWS:		niente
	// @EFFECTS:	aggiunge nella rete sociale le persone che hanno almeno 1 follow
	// @RETURN:		la map aggiornata
	public Map<String, Set<String>> guessFollowers(List<Post> ps);
	
	// @REQUIRES:	true 
	// @MODIFIES:	ordina in una lista 
	// @THROWS:		niente
	// @EFFECTS:	ordina in modo decrescente gli autori dei post che hanno piu' follower			
	// @RETURN:		Lista ordinata di autori
	public List<String> influencers();
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	ricerca in tutti i post gli utenti taggati(@Autore)
	// @RETURN:		i nomi delle persone che sono state taggate
	public Set<String> getMentionedUsers();
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	ricerca da una serie di post gli utenti taggati(@Autore)
	// @RETURN:		i nomi delle persone che sono state taggate
	public Set<String> getMentionedUsers(List<Post> ps);
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	l'utente inserisce il nome autore e si vedranno i suoi 
	//				post presenti in tutti il network 
	// @RETURN:		tutti i dati del post 
	public List<Post> writtenBy(String username);
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	l'utente inserisce il nome autore e si vedranno i suoi 
	//				post presenti da una lista di post 
	// @RETURN:		tutti i dati del post
	public List<Post> writtenBy(List<Post> ps, String username);
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	da una lista di parole (gia' precaricata) controllare 
	//				quali autori hanno nei loro testi le parole della lista 
	// @RETURN:		lista degli autori 
	public List<Post> containing(List<String> words);
}
