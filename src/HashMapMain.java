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
		//HashMap fonctionne avec une paire cl�-valeur
		//	Permet la valeur NULL pour la cl� ou la valeur
		//	N'est pas synchronis� donc plus performant.

		hashMap = new HashMap<String,Jour>();
		
		//Ajouter des paires cl�s-valeurs
		hashMap.put("debSem", Jour.LUNDI);
		hashMap.put("finSem", Jour.DIMANCHE);
		hashMap.put("mitemps", Jour.MERCREDI);
		hashMap.put("tard", Jour.VENDREDI);
		hashMap.put("cong�", Jour.DIMANCHE);
		hashMap.put(null,null);			//NULL est permis
		hashMap.put(null,Jour.LUNDI);	//Modifie la cl� null
		hashMap.put("folies",null);		//Affecte une valeur null
		
		System.out.println(hashMap);	//Remarquez l'ordre d'affichage...
		
		//Modifier une valeur pour une cl� existante
		hashMap.put("cong�", Jour.SAMEDI);
		System.out.println(hashMap);
		
		//Recherche d'une cl�
		Boolean trouve = hashMap.containsKey("mitemps");
		System.out.println(trouve?"Cl� 'mitemps' trouv�e.":"Pas de cl� 'mitemps'!");
		System.out.println(hashMap.containsKey("nokey")?"Cl� 'nokey' trouv�e.":"Pas de cl� 'nokey'!");
		
		//Recherche d'une valeur
		trouve = hashMap.containsValue(Jour.DIMANCHE);
		System.out.println(trouve?"'DIMANCHE' a �t� trouv�.":"Pas de 'DIMANCHE'!");
		System.out.println(hashMap.containsValue(Jour.SAMEDI)?"'SAMEDI' a �t� trouv�.":"Pas de 'SAMEDI'!");

		//R�cup�rer une valeur � partir de sa cl�
		Jour lateShift = hashMap.get("tard");
		System.out.println("Il travaille tard le "+ lateShift +".");
		
		//Suppression d'une paire cl�-valeur
		Jour deleted = hashMap.remove("cong�");
		System.out.println("Le cong� du "+ deleted +" a �t� supprim�.");
		System.out.println(hashMap);	//DIMANCHE n'y est plus.
		
		//R�cup�rer une vue sur toutes les valeurs
		Collection<Jour> vueValues = hashMap.values();
		System.out.println(vueValues);

		//R�cup�rer une vue sur toutes les cl�s
		Set<String> vueKeys = hashMap.keySet();
		System.out.println(vueKeys);
		
		//R�cup�rer une vue sur toutes les paires cl�-valeur
		//	Remarquez la syntaxe Set<Entry<String,Jour>>
		//	Set<X> signifie un ensemble de X diff�rents (pas de doublons)
		//	Entry<K,V> signifie une paire cl� K et valeur V (Map.Entry est une interface)
		//	donc Set<Entry<String,Jour>> signifie un ensemble de paires cl�-valeur diff�rentes
		Set<Entry<String,Jour>> vueKeysValues = hashMap.entrySet();
		System.out.println(vueKeysValues);

		//Ajouter plusieurs paires cl�-valeur � partir d'un autre HashMap
		HashMap<String,Jour> autreHM = new HashMap<String,Jour>();
		autreHM.put("sp�cial", Jour.JEUDI);
		autreHM.put("matin", Jour.MERCREDI);
		autreHM.put("apr�s-midi", Jour.VENDREDI);
		hashMap.putAll(autreHM);
		System.out.println(hashMap);
		
		
		/* ********* NE LISEZ LA SUITE QUE SI VOUS AIMEZ LES COMPLICATIONS ***************** */
		/* Il est bien s�r possible de cr�er des structures complexes
		 * avec des valeurs de type Array (Example 1) ou ArrayList, LinkedList, HashSet,...
		 * voire m�me des cl�s complexes (Example 2)
		 */
		System.out.println("\nExample 1");
		HashMap<String,Jour[]> joursem = new HashMap<String, Jour[]>();
		
		Jour[] joursOuvrables = {Jour.LUNDI,Jour.MARDI,Jour.MERCREDI,Jour.JEUDI,Jour.VENDREDI};
		Jour[] joursWeekend = {Jour.SAMEDI,Jour.DIMANCHE};

		joursem.put("ouvr�s", joursOuvrables);
		joursem.put("weekend", joursWeekend);
		System.out.println(joursem);

		System.out.println("\nExample 2");
		HashMap<ArrayList<Jour>,Integer[]> jourdates = new HashMap<ArrayList<Jour>,Integer[]>();
		
		ArrayList<Jour> janvierJours4x = new ArrayList<Jour>();	//Jours pr�sents 4 fois en janvier
		janvierJours4x.add(Jour.VENDREDI);
		janvierJours4x.add(Jour.SAMEDI);
		janvierJours4x.add(Jour.DIMANCHE);
		janvierJours4x.add(Jour.LUNDI);
		ArrayList<Jour> janvierJours5x = new ArrayList<Jour>();	//Jours pr�sents 5 fois en janvier
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
