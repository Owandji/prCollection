import java.util.HashSet;


public class HashSetMain {
	private static HashSet<Jour> hashSet;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Dans un Set, pas de doublons
		hashSet = new HashSet<Jour>();
		
		Boolean ajout;
		ajout = hashSet.add(Jour.LUNDI);	//ajout�
		System.out.println(ajout?"Ajout�":"Refus�");
		ajout = hashSet.add(Jour.MARDI);	//ajout�
		System.out.println(ajout?"Ajout�":"Refus�");
		ajout = hashSet.add(Jour.LUNDI);	//refus�
		System.out.println(ajout?"Ajout�":"Refus�");
		System.out.println(hashSet);
		
		// NULL est accept�
		ajout = hashSet.add(null);		//ajout�
		System.out.println(ajout?"Ajout�":"Refus�");
		System.out.println(hashSet);
		
		// Les �l�ments sont tri�s
		hashSet.add(Jour.JEUDI);
		System.out.println(hashSet);
		
		/*
		 * HashSet ne permet pas les doublons. 
		 * Il propose la m�thode add plut�t que la m�thode put. 
		 * Il propose la m�thode contains pour v�rifier la pr�sence d'un �l�ment dans la s�quence. 
		 * HashSet est utile pour maintenir une liste de valeurs uniques.
		 */

	}

	public enum Jour {
		LUNDI, MARDI, MERCREDI, JEUDI,
		VENDREDI, SAMEDI, DIMANCHE
	}
}
