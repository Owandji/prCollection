import java.util.Hashtable;

public class HashtableMain {
	private static Hashtable<String,Jour> hashtable;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO A completer...
		
		//Hashtable focntionne avec une paire clé-valeur
		//	Ne permet pas de valeur NULL (ni clé, ni valeur)
		//	Renvoie NullPointerException en cas d'ajout de la valeur NULL
		//	Est synchronisé donc un seul thread peut y accéder à la fois (coûteux).

	}

	public enum Jour {
		LUNDI, MARDI, MERCREDI, JEUDI,
		VENDREDI, SAMEDI, DIMANCHE
	}
}
