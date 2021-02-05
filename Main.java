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
public class Main {
	public static void main(String[] args) throws Exceptions  {
		//variabili 
		SocialNetwork social = new SocialNetwork();
		Report controllare = new Report();
		//variabili per i metodi
		Map<String,Set<String>> rete = new HashMap<String,Set<String>>();
		List<String> words = new Vector<String>();
		List<Post> persone = new Vector<Post>();
		List<String> personeVip = new Vector<String>();
		Set<String> menzionare = new HashSet<String>();
		ArrayList<Post> utenti = new ArrayList<Post>();
		
		//caricamento dei post e like
	
		try {
		Post federico = new Post("federico","mr robot e' la mia serie tv preferita");
		controllare.controllo("mr robot e' la mia serie tv preferita", "federico");
		social.loadList(federico);
		Follow like = new Follow("federico","mr robot e' la mia serie tv preferita","giuseppe");
		social.loadList(like);
		Follow like1 = new Follow("federico","mr robot e' la mia serie tv preferita","camilla");
		social.loadList(like1);
		Follow like2 = new Follow("federico","mr robot e' la mia serie tv preferita","emanuele");
		social.loadList(like2);
		Follow like3 = new Follow("federico","mr robot e' la mia serie tv preferita","gianfranco");
		social.loadList(like3);
		Follow like4 = new Follow("federico","mr robot e' la mia serie tv preferita","gennaro");
		social.loadList(like4);
		
		Post giuseppe = new Post("giuseppe","@camilla e' una brava persona, cavolo");
		controllare.controllo("@camilla e' una brava persona, cavolo", "giuseppe");
		social.loadList(giuseppe);
		utenti.add(giuseppe);
		Follow like5 = new Follow("giuseppe","@camilla e' una brava persona, cavolo","federico");
		social.loadList(like5);
		Follow like6 = new Follow("giuseppe","@camilla e' una brava persona, cavolo","camilla");
		social.loadList(like6);
		Follow like7 = new Follow("giuseppe","@camilla e' una brava persona, cavolo","emanuele");
		social.loadList(like7);
		
		Post camilla = new Post("camilla","ieri ho visto il film di checco zalone");
		controllare.controllo("ieri ho visto il film di checco zalone", "camilla");
		social.loadList(camilla);
		utenti.add(camilla);
		Follow like8 = new Follow("camilla","ieri ho visto il film di checco zalone","federico");
		social.loadList(like8);
		Follow like9 = new Follow("camilla","ieri ho visto il film di checco zalone","giuseppe");
		social.loadList(like9);
		Follow like10 = new Follow("camilla","ieri ho visto il film di checco zalone","emanuele");
		social.loadList(like10);
		Post camilla1 = new Post("camilla","Ho sonno, ieri e' stato il mio compleanno");
		social.loadList(camilla1);
		utenti.add(camilla1);
		controllare.controllo("Ho sonno, ieri e' stato il mio compleanno", "camilla");
		Follow like11 = new Follow("camilla","Ho sonno, ieri e' stato il mio compleanno","emanuele");
		social.loadList(like11);
		
		Post emanuele = new Post("emanuele","Scusami ma non ho capito l'ultimo film di Tarantino");
		controllare.controllo("Scusami ma non ho capito l'ultimo film di Tarantino", "emanuele");
		social.loadList(emanuele);
		
		Post gennaro = new Post("gennaro","io e @giuseppe oggi abbiamo fatto una passeggiata nel bosco");
		controllare.controllo("io e @giuseppe oggi abbiamo fatto una passeggiata nel bosco","gennaro");
		social.loadList(gennaro);
		Follow like12 = new Follow("gennaro","io e @giuseppe oggi abbiamo fatto una passeggiata nel bosco","emanuele");
		social.loadList(like12);
		Follow like13 = new Follow("gennaro","io e @giuseppe oggi abbiamo fatto una passeggiata nel bosco","gianfranco");
		social.loadList(like13);
		} catch (Exceptions errore) {
			System.err.println(errore);
		}
		
		//controllo autoLike
		try {
			Post gianfranco = new Post("gianfranco","l'Università di bob si chiama La vita");
			controllare.controllo("Università di bob si chiama La vita", "gianfranco");
			social.loadList(gianfranco);
			Follow like14 = new Follow("gianfranco","bob","gianfranco");
			social.loadList(like14);
			} catch (Exceptions mandarino) {
				System.err.println(mandarino);
			}
		
		//controllo nessun testo inserito
		try {
			@SuppressWarnings("unused")
			Post luigi = new Post("luigi","");
		} catch (Exceptions mandarino) {
			System.err.println(mandarino);
		}
		
		//controllo nessun nome inserito
		try {
			@SuppressWarnings("unused")
			Post marco = new Post("","la vita secondo jim");
		} catch (Exceptions mandarino) {
			System.err.println(mandarino);
		}
		
		//controllo testo con piu' di 140 caratteri
		try {
			@SuppressWarnings("unused")
			Post filippo = new Post("filippo","Il patron della Virtus Bologna, Massimo Zanetti, "
					+ "ha detto che Marco Stefano Belinelli è l'italiano più forte di sempre. "
					+ "Noi non riusciamo a esprimerci perché ci sono stati tantissimi campioni "
					+ "nella storia del nostro basket però vi riproponiamo una giornata storica "
					+ "per il nostro basket, probabilmente la migliore degli ultimi 15 anni: "
					+ "la gara contro la Spagna a EuroBasket del 2015."
					+ "Ufficiale: Marco Belinelli torna in Italia e abbraccia la casa della "
					+ "società che lo lanciò a 16 anni. Beli alla Virtus Bologna."
					+ "Quale impatto sul campionato, quale impatto sulla squadra, "
					+ "assieme agli arrivi degli ultimi due anni in particolare, il"
					+ "livello e il rendere appetibile il nostro sport aumenta?\r\n"
					+ "Un'idea che mi passa, senza avere la sfera di cristallo, sono curioso "
					+ "di vedere l'impatto in uno spogliatoio di serie A, molto diverso "
					+ "rispetto a quello che è uno di Nba, il nome pesa così e forse "
					+ "più di quello di Teodosic.");
		} catch (Exceptions mandarino) {
			System.err.println(mandarino);
		}
		
			// 1 metodo:
			// restituisce la rete sociale derivata dalla lista di post
			System.out.println("(1)");
			rete = social.guessFollowers(social.gettuttiPost());
			if (rete == null)
				System.err.println("Non esiste ancora nessun post!!");
			else
				for (Map.Entry<String,Set<String>> entry : rete.entrySet())
					System.out.println(entry.getKey() + ":" + entry.getValue());
			
		
			System.out.println("------");
		
			// 2 metodo:
			// restituisce gli utenti più influenti delle rete sociale 
			// (parametro del metodo), ovvero quelli che 
			// hanno un numero maggiore di “follower”;
			/* lista degli influencers:
			 * federico:	5 followers
			 * camilla:		4 followers
			 * giuseppe:	3 followers
			 * gennaro: 	2 followers
			 * gianfranco:	0 followers
			 * emanuele:	0 followers 
			 */
			System.out.println("(2)");
			personeVip = social.influencers();
			if (personeVip == null)
				System.err.println("Non esiste ancora nessun post!!");
			else
				for (String c1 : personeVip)
					System.out.println(c1);
		
			System.out.println("------");
		
			// 3 metodo:
			// restituisce l’insieme degli utenti menzionati 
			// (inclusi) nei post presenti nella rete sociale
			System.out.println("(3)");
			menzionare = social.getMentionedUsers();
			if (menzionare == null)
				System.err.println("Non esiste ancora nessun post!!");
			else
				for (String c1 : menzionare)
					System.out.println(c1);
				
		
			System.out.println("------");
		
			// 4 metodo:
			// restituisce l’insieme degli utenti
			// menzionati (inclusi) nella lista di post
			System.out.println("(4)");
			menzionare = social.getMentionedUsers(utenti);
			if (menzionare == null)
				System.err.println("Non esiste ancora nessun post!!");
			else
				for (String c1 : menzionare)
					System.out.println(c1);
			

			System.out.println("------");
		
			// 5 metodo:
			// restituisce la lista dei post effettuati
			// dall’utente nella rete sociale il cui nome 
			// è dato dal parametro username
			System.out.println("(5)");
			persone = social.writtenBy("federico");
			if (persone == null)
				System.err.println("Non esiste ancora nessun post!!");
			else if (persone.size() == 0)
					System.err.println("non hai inserito nessun nome");
			else
			{
				for (Post p1 : persone)
				{
					System.out.println("Autore: " + p1.getAuthor());
					System.out.println("Testo: " + p1.getText());
					System.out.println("Data: " + p1.getTimestamp());
				}	
			}
		
			System.out.println("------");
			
			// 6 metodo:
			// restituisce la lista dei post
			// effettuati dall’utente il cui nome è dato dal 
			// parametro username presenti nella lista ps.
			System.out.println("(6)");
			persone = social.writtenBy(utenti, "camilla");
			if (persone == null)
				System.err.println("Non esiste ancora nessun post!!");
			else if (persone.size() == 0)
					System.err.println("non hai inserito nessun nome");
			else
			{
				for (Post p1 : persone)
				{
					System.out.println("Autore: " + p1.getAuthor());
					System.out.println("Testo: " + p1.getText());
					System.out.println("Data: " + p1.getTimestamp());
				}	
			}

			System.out.println("------");
		
			// 7 metodo:
			// restituisce la lista dei post presenti
			// nella rete sociale che includono almeno una 
			// delle parole presenti nella lista delle parole
			// argomento del metodo.
			//carico le words 
			System.out.println("(7)");
			words.add("serie tv");
			words.add("film");
			words.add("bosco");
			//inizio metodo:
			persone = social.containing(words);
			if (persone == null)
				System.err.println("Non esiste ancora nessun post!!");
			else
				for (Post p1 : persone)
					System.out.println(p1.getAuthor());
				
			System.out.println("------");
		
			// lista delle persone segnalate:
			System.out.println("Lista persone segnalate:");
			for (String c1 : controllare.Getsegnalati())
			{
				System.out.println(c1);
			}
		}
	}