import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMain {
	private static TreeSet<Jour> treeSet;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		treeSet = new TreeSet<Jour>();
		
		//Ajout dans une séquence triée (SortedSet)
		//		L'ordre est défini dans l'énumération
		treeSet.add(Jour.MERCREDI);
		treeSet.add(Jour.MARDI);
		treeSet.add(Jour.LUNDI);
		treeSet.add(Jour.JEUDI);
		treeSet.add(Jour.VENDREDI);
		treeSet.add(Jour.DIMANCHE);
		treeSet.add(Jour.SAMEDI);
		
		System.out.println(treeSet);
		
		System.out.println("[\t\t\t\t\t\t"+ Jour.MARDI +"\t\t\t\t\t\t]");
		System.out.println("[\t\t\t\t\t"+ Jour.LUNDI +"\t\t"+ Jour.JEUDI +"\t\t\t\t\t]");
		System.out.println("[\t\t\t\t\t\t"+ Jour.MERCREDI +"\t\t"+ Jour.SAMEDI +"\t\t\t]");
		System.out.println("[\t\t\t\t\t\t\t"+ Jour.VENDREDI +"\t\t"+ Jour.DIMANCHE +"\t]");

		System.out.println("Plafond LUNDI: "+ treeSet.ceiling(Jour.LUNDI));
		System.out.println("Plafond MARDI: "+ treeSet.ceiling(Jour.MARDI));
		System.out.println("Plafond MERCREDI: "+ treeSet.ceiling(Jour.MERCREDI));
		System.out.println("Plafond JEUDI: "+ treeSet.ceiling(Jour.JEUDI));
		System.out.println("Plafond VENDREDI: "+ treeSet.ceiling(Jour.VENDREDI));
		System.out.println("Plafond SAMEDI: "+ treeSet.ceiling(Jour.SAMEDI));
		System.out.println("Plafond DIMANCHE: "+ treeSet.ceiling(Jour.DIMANCHE));
		
		System.out.println("Plancher LUNDI: "+ treeSet.floor(Jour.LUNDI));
		System.out.println("Plancher MARDI: "+ treeSet.floor(Jour.MARDI));
		System.out.println("Plancher MERCREDI: "+ treeSet.floor(Jour.MERCREDI));
		System.out.println("Plancher JEUDI: "+ treeSet.floor(Jour.JEUDI));
		System.out.println("Plancher VENDREDI: "+ treeSet.floor(Jour.VENDREDI));
		System.out.println("Plancher SAMEDI: "+ treeSet.floor(Jour.SAMEDI));
		System.out.println("Plancher DIMANCHE: "+ treeSet.floor(Jour.DIMANCHE));

		System.out.println("Plus haut LUNDI: "+ treeSet.higher(Jour.LUNDI));
		System.out.println("Plus haut MARDI: "+ treeSet.higher(Jour.MARDI));
		System.out.println("Plus haut MERCREDI: "+ treeSet.higher(Jour.MERCREDI));
		System.out.println("Plus haut JEUDI: "+ treeSet.higher(Jour.JEUDI));
		System.out.println("Plus haut VENDREDI: "+ treeSet.higher(Jour.VENDREDI));
		System.out.println("Plus haut SAMEDI: "+ treeSet.higher(Jour.SAMEDI));
		System.out.println("Plus haut DIMANCHE: "+ treeSet.higher(Jour.DIMANCHE));
		
		System.out.println("Plus bas LUNDI: "+ treeSet.lower(Jour.LUNDI));
		System.out.println("Plus bas MARDI: "+ treeSet.lower(Jour.MARDI));
		System.out.println("Plus bas MERCREDI: "+ treeSet.lower(Jour.MERCREDI));
		System.out.println("Plus bas JEUDI: "+ treeSet.lower(Jour.JEUDI));
		System.out.println("Plus bas VENDREDI: "+ treeSet.lower(Jour.VENDREDI));
		System.out.println("Plus bas SAMEDI: "+ treeSet.lower(Jour.SAMEDI));
		System.out.println("Plus bas DIMANCHE: "+ treeSet.lower(Jour.DIMANCHE));

		//Connaître le premier ou le dernier
		System.out.println("Premier (plus bas): "+ treeSet.first());
		System.out.println("Dernier (plus haut): "+ treeSet.last());

		//Récupérer une vue sur les éléments strictement plus petits que l'élément donné
		SortedSet<Jour> vue = treeSet.headSet(Jour.JEUDI);	//Vue sur LUNDI, MARDI, MERCREDI
		System.out.println(vue);
		vue.remove(Jour.MERCREDI);		//Suppression dans la vue
		System.out.println(vue);
		System.out.println(treeSet);	//Impact dans le TreeSet
		treeSet.add(Jour.MERCREDI);
		
		//Récupérer une vue sur les éléments plus petits ou égaux à l'élément donné
		vue = treeSet.headSet(Jour.JEUDI, true);	//Y compris JEUDI
		System.out.println(vue);
		
		//Récupérer une vue sur les éléments plus grands ou égaux à l'élément donné
		vue = treeSet.tailSet(Jour.JEUDI);
		System.out.println(vue);
		
		//Récupérer une vue sur les éléments strictement plus grands à l'élément donné
		vue = treeSet.tailSet(Jour.JEUDI, false);	//JEUDI exclus
		System.out.println(vue);
		
		//Récupérer une vue sur tous les éléments entre un minimum inclus et un maximum exclus
		vue = treeSet.subSet(Jour.MARDI, Jour.VENDREDI);
		System.out.println(vue);
		
		//Récupérer une vue sur tous les éléments entre un minimum exclus et un maximum inclus
		vue = treeSet.subSet(Jour.MARDI, false, Jour.VENDREDI, true);
		System.out.println(vue);
		
		//Parcourir avec un itérateur descendant
		Iterator<Jour> it = treeSet.descendingIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//Récupérer un Set dont l'ordre des éléments est inversé
		//Parcourir ce Set avec un itérateur ascendant
		NavigableSet<Jour> reverseSet = treeSet.descendingSet();
		it = reverseSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
				
		//Implémenter un ordre de tri alphabétique
		TreeSet<Jour> treeSetAlphabet = new TreeSet<Jour>(new Comparator<Jour>() {
			@Override
			public int compare(Jour j1, Jour j2) {
				return j1.toString().compareTo(j2.toString());
			}			
		});
		
		treeSetAlphabet.addAll(treeSet);
		System.out.println("Ordre alphabétique: "+ treeSetAlphabet);

		//Récupérer une instance du comparateur
		Comparator<Jour> ordreAlpha = (Comparator<Jour>) treeSet.comparator();

		//Implémenter un ordre de tri personnalisé
		TreeSet<Jour> treeSetPerso = new TreeSet<Jour>(new Comparator<Jour>() {
			Jour[] tOrdrePerso = {Jour.JEUDI, Jour.MARDI, Jour.SAMEDI, Jour.LUNDI, 
					Jour.MERCREDI, Jour.DIMANCHE, Jour.VENDREDI};
			
			@Override
			public int compare(Jour j1, Jour j2) {
				return indexOf(j1,tOrdrePerso)-indexOf(j2,tOrdrePerso);
			}
			
			private int indexOf(Jour j, Jour[] tab) {
				int lg = tab.length;
				
				for(int i=0;i<lg;i++) {
					if(tab[i].equals(j)) return i; 
				}
				return -1;
			}
		});
		
		treeSetPerso.addAll(treeSet);
		System.out.println("Ordre personnalisé: "+ treeSetPerso);
		
	}

	public enum Jour {
		LUNDI, MARDI, MERCREDI, JEUDI,
		VENDREDI, SAMEDI, DIMANCHE
	}
}
