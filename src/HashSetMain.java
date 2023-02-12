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
		ajout = hashSet.add(Jour.LUNDI);	//ajouté
		System.out.println(ajout?"Ajouté":"Refusé");
		ajout = hashSet.add(Jour.MARDI);	//ajouté
		System.out.println(ajout?"Ajouté":"Refusé");
		ajout = hashSet.add(Jour.LUNDI);	//refusé
		System.out.println(ajout?"Ajouté":"Refusé");
		System.out.println(hashSet);
		
		// NULL est accepté
		ajout = hashSet.add(null);		//ajouté
		System.out.println(ajout?"Ajouté":"Refusé");
		System.out.println(hashSet);
		
		// Les éléments sont triés
		hashSet.add(Jour.JEUDI);
		System.out.println(hashSet);
		
		/*
		 * HashSet ne permet pas les doublons. 
		 * Il propose la méthode add plutôt que la méthode put. 
		 * Il propose la méthode contains pour vérifier la présence d'un élément dans la séquence. 
		 * HashSet est utile pour maintenir une liste de valeurs uniques.
		 */

	}

	public enum Jour {
		LUNDI, MARDI, MERCREDI, JEUDI,
		VENDREDI, SAMEDI, DIMANCHE
	}
}
