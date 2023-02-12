import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapMain {
	private static HashMap<String,Jour> hashMap;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//HashMap fonctionne avec une paire clé-valeur
		//	Permet la valeur NULL pour la clé ou la valeur
		//	N'est pas synchronisé donc plus performant.

		hashMap = new HashMap<String,Jour>();
		
		//Ajouter des paires clés-valeurs
		hashMap.put("debSem", Jour.LUNDI);
		hashMap.put("finSem", Jour.DIMANCHE);
		hashMap.put("mitemps", Jour.MERCREDI);
		hashMap.put("tard", Jour.VENDREDI);
		hashMap.put("congé", Jour.DIMANCHE);
		hashMap.put(null,null);			//NULL est permis
		hashMap.put(null,Jour.LUNDI);	//Modifie la clé null
		hashMap.put("folies",null);		//Affecte une valeur null
		
		System.out.println(hashMap);	//Remarquez l'ordre d'affichage...
		
		//Modifier une valeur pour une clé existante
		hashMap.put("congé", Jour.SAMEDI);
		System.out.println(hashMap);
		
		//Recherche d'une clé
		Boolean trouve = hashMap.containsKey("mitemps");
		System.out.println(trouve?"Clé 'mitemps' trouvée.":"Pas de clé 'mitemps'!");
		System.out.println(hashMap.containsKey("nokey")?"Clé 'nokey' trouvée.":"Pas de clé 'nokey'!");
		
		//Recherche d'une valeur
		trouve = hashMap.containsValue(Jour.DIMANCHE);
		System.out.println(trouve?"'DIMANCHE' a été trouvé.":"Pas de 'DIMANCHE'!");
		System.out.println(hashMap.containsValue(Jour.SAMEDI)?"'SAMEDI' a été trouvé.":"Pas de 'SAMEDI'!");

		//Récupérer une valeur à partir de sa clé
		Jour lateShift = hashMap.get("tard");
		System.out.println("Il travaille tard le "+ lateShift +".");
		
		//Suppression d'une paire clé-valeur
		Jour deleted = hashMap.remove("congé");
		System.out.println("Le congé du "+ deleted +" a été supprimé.");
		System.out.println(hashMap);	//DIMANCHE n'y est plus.
		
		//Récupérer une vue sur toutes les valeurs
		Collection<Jour> vueValues = hashMap.values();
		System.out.println(vueValues);

		//Récupérer une vue sur toutes les clés
		Set<String> vueKeys = hashMap.keySet();
		System.out.println(vueKeys);
		
		//Récupérer une vue sur toutes les paires clé-valeur
		//	Remarquez la syntaxe Set<Entry<String,Jour>>
		//	Set<X> signifie un ensemble de X différents (pas de doublons)
		//	Entry<K,V> signifie une paire clé K et valeur V (Map.Entry est une interface)
		//	donc Set<Entry<String,Jour>> signifie un ensemble de paires clé-valeur différentes
		Set<Entry<String,Jour>> vueKeysValues = hashMap.entrySet();
		System.out.println(vueKeysValues);

		//Ajouter plusieurs paires clé-valeur à partir d'un autre HashMap
		HashMap<String,Jour> autreHM = new HashMap<String,Jour>();
		autreHM.put("spécial", Jour.JEUDI);
		autreHM.put("matin", Jour.MERCREDI);
		autreHM.put("après-midi", Jour.VENDREDI);
		hashMap.putAll(autreHM);
		System.out.println(hashMap);
		
		
		/* ********* NE LISEZ LA SUITE QUE SI VOUS AIMEZ LES COMPLICATIONS ***************** */
		/* Il est bien sûr possible de créer des structures complexes
		 * avec des valeurs de type Array (Example 1) ou ArrayList, LinkedList, HashSet,...
		 * voire même des clés complexes (Example 2)
		 */
		System.out.println("\nExample 1");
		HashMap<String,Jour[]> joursem = new HashMap<String, Jour[]>();
		
		Jour[] joursOuvrables = {Jour.LUNDI,Jour.MARDI,Jour.MERCREDI,Jour.JEUDI,Jour.VENDREDI};
		Jour[] joursWeekend = {Jour.SAMEDI,Jour.DIMANCHE};

		joursem.put("ouvrés", joursOuvrables);
		joursem.put("weekend", joursWeekend);
		System.out.println(joursem);

		System.out.println("\nExample 2");
		HashMap<ArrayList<Jour>,Integer[]> jourdates = new HashMap<ArrayList<Jour>,Integer[]>();
		
		ArrayList<Jour> janvierJours4x = new ArrayList<Jour>();	//Jours présents 4 fois en janvier
		janvierJours4x.add(Jour.VENDREDI);
		janvierJours4x.add(Jour.SAMEDI);
		janvierJours4x.add(Jour.DIMANCHE);
		janvierJours4x.add(Jour.LUNDI);
		ArrayList<Jour> janvierJours5x = new ArrayList<Jour>();	//Jours présents 5 fois en janvier
		janvierJours5x.add(Jour.MARDI);
		janvierJours5x.add(Jour.MERCREDI);
		janvierJours5x.add(Jour.JEUDI);
		
		Integer[] dates4x = {4,5,6,7};
		jourdates.put(janvierJours4x, dates4x);
		Integer[] dates5x = {1,2,3};
		jourdates.put(janvierJours5x, dates5x);
		System.out.println(jourdates);
}

	public enum Jour {
		LUNDI, MARDI, MERCREDI, JEUDI,
		VENDREDI, SAMEDI, DIMANCHE
	}
}
