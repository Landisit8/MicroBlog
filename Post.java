import java.util.Date;
import java.util.UUID;
/*
 * @author Federico Landini
 */
public class Post implements IPost{
	//Variabili
	private UUID id;
	private String author;
	private String text;
	private Date timestamp;

	//Costruttore
	public Post(String author, String text) throws Exceptions
	{
		this.author = controlloAuthor(author);
		this.text = controlloText(text);
		this.timestamp = new Date();
		//Genero un numero random
		this.id = UUID.randomUUID();
	}

	//metodi
	public String getAuthor() {
		return this.author;
	}
	
	public String getText() {
		return text;
	}	

	public UUID getId() {
		return this.id;
	}

	public Date getTimestamp() {
		
		return timestamp;
	}
	
	// @REQUIRES:	il testo inserito deve essere diverso da NULL e non deve superare i 140 caratteri   
	// @MODIFIES:	niente 
	// @THROWS:		se il testo e' NULL o supera i 140 caratteri, stampa il messaggio dedicato  
	//				e se viene lanciata l'eccezione non viene creato il post
	// @EFFECTS:	se non viene rispettata la requires viene lanciata una delle eccezioni 
	// @RETURN:		ritorno il testo se non vengono lanciate le eccezioni
	private String controlloText(String text) throws Exceptions 
	{
		if (text.length() == 0)
		{
			throw new Exceptions("Non hai inserito nessun testo!!");
		}
		else if (text.length() > 140)
			{
				throw new Exceptions("Hai inserito piu' di 140 caratteri!!");
			}
		return text; 
	}
	
	// @REQUIRES:	il nome dell'autore deve essere diverso da NULL 
	// @MODIFIES:	niente 
	// @THROWS:		se il nome dell'autore e' NULL e se viene lanciata l'eccezione non viene creato il post
	// @EFFECTS:	se non viene rispettata la requires viene lanciata l'eccezione
	// @RETURN:		ritorni il valore del nome dell'autore se non viene lanciata una eccezione
	private String controlloAuthor(String author) throws Exceptions
	{
		if (author.length() == 0)
		{
			throw new Exceptions("Non hai inserito nesun nome!!");
		}
		return author; 
	}
	
}