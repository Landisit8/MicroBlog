import java.util.List;
import java.util.Vector;
/*
 * @author Federico Landini
 */
public class Report extends SocialNetwork implements IReport{
	
	//variabili
	private String[] paroleNegate;
	private List<String> segnalati;
	
	//costruttore
	public Report() {
		paroleNegate = new String[]{"Università", "Scusami", "cavolo"};
		segnalati = new Vector<>();
	}
	
	//metodi
	public List<String> Getsegnalati() {
		return this.segnalati;
	}
	
	public Void controllo(String text, String author)
	{
		String[]a = text.split(" ");
		
		for (String b : a)
			for(int i=0; i < paroleNegate.length; i++)
				if (b.equals(paroleNegate[i]))
				{
					System.err.println("Sei stato segnalato.");
					System.err.println("Hai inserito una parola proibita!!");
					segnalati.add(author);
				}
		return null;
	}
}
