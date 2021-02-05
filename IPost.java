import java.util.Date;
import java.util.UUID;
/*
 * @author Federico Landini
 */
public interface IPost {
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	niente
	// @RETURN:		ritorni il valore del nome dell'autore
	public String getAuthor();
	
	// @REQUIRES:	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	niente
	// @RETURN:  	ritorni il valore del testo dell'autore
	public String getText();

	// @REQUIRES: 	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	niente
	// @RETURN:  	ritorni il valore del ID univoco del post
	public UUID getId();
	
	// @REQUIRES: 	true 
	// @MODIFIES:	niente 
	// @THROWS:		niente
	// @EFFECTS:	niente
	// @RETURN:  	ritorni la data di quando viene creato il post
	public Date getTimestamp();
}
