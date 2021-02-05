import java.util.UUID;
/*
 * @author Federico Landini
 */
public interface IFollow {
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	niente
	// @RETURN:		ritorni il valore del ID univoco del follow
	public UUID getIdF();
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	niente
	// @RETURN:		ritorni il valore del nome dell'autore del like
	public String getAuthorF();
}
