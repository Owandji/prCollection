import java.util.Hashtable;

public class HashtableMain {
	private static Hashtable<String,Jour> hashtable;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO A completer...
		
		//Hashtable focntionne avec une paire cl�-valeur
		//	Ne permet pas de valeur NULL (ni cl�, ni valeur)
		//	Renvoie NullPointerException en cas d'ajout de la valeur NULL
		//	Est synchronis� donc un seul thread peut y acc�der � la fois (co�teux).

	}

	public enum Jour {
		LUNDI, MARDI, MERCREDI, JEUDI,
		VENDREDI, SAMEDI, DIMANCHE
	}
}
