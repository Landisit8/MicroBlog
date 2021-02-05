import java.util.UUID;
/*
 * @author Federico Landini
 */
public class Follow extends Post implements IFollow{
	//variabili
	private String authorF;
	private UUID idF;
	
	//costruttore
	public Follow(String author, String text, String authorFo) throws Exceptions {
		super(author, text);
		this.authorF = controlloFollow(authorFo);
		this.idF = UUID.randomUUID();
	}
	
	//metodi
	public UUID getIdF() {
		return this.idF;
	}

	public String getAuthorF() {
		return this.authorF;
	}
	
	// @REQUIRES:	il nome dell'autore del follow deve essere diverso dal nome dell'autore 
	//				del post e deve essere diverso da NULL   
	// @MODIFIES:	niente 
	// @THROWS:		se il nome del creatore del follow e' uguale al nome del creatore 
	//				del post o il nome dell'autore follow e' uguale a NULL, stampa il messaggio dedicato  
	//				e se viene lanciata l'eccezione non viene creato il like
	// @EFFECTS:	se non viene rispettata la requires viene lanciata una delle eccezioni 
	// @RETURN:		ritorno il nome dell'autore del follow se non vengono lanciate le eccezioni
	private String controlloFollow(String authorF) throws Exceptions
	{
		if (getAuthor().equals(authorF))
		{
			throw new Exceptions("Non puoi seguire te stesso!");
		}
		else if (authorF.length() == 0)
			{
				throw new Exceptions("Non hai inserito nessun nome!");
			}
		return authorF;
	}
}