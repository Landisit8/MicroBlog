import java.util.List;
/*
 * @author Federico Landini
 */
public interface IReport {
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	niente
	// @RETURN:		ritorna la lista delle persone segnalate
	public List<String> Getsegnalati();
	
	// @REQUIRES:	ogni volta che viene creato un post, controllo se nel testo 
	//				non sono presenti delle parole "proibite"
	// @MODIFIES:	modifico la lista delle segnalazioni 
	// @THROWS:		niente
	// @EFFECTS:	se una parola nel testo del post appena creato e' presente una 
	//				parola negata, allora il nome dell'autore viene aggiunto in 
	//				una lista delle persone segnalate 
	// @RETURN:		niente
	public Void controllo(String text, String author);

}
