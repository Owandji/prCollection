import java.util.*;


public class ArrayListMain {
	private static ArrayList<Jour> arrayList;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// L'interface List permet de regrouper une séquence de données
		arrayList = new ArrayList<Jour>();
		
		//Interrogation
		boolean vide = arrayList.isEmpty();
		System.out.println(vide ? "Vide.":"Pas vide.");
		
		//Ajout d'un élément en fin de séquence
		arrayList.add(Jour.LUNDI);
		arrayList.add(Jour.JEUDI);
		arrayList.add(Jour.VENDREDI);
		arrayList.add(Jour.VENDREDI);
		arrayList.add(Jour.JEUDI);
		System.out.println(arrayList);
		System.out.println(arrayList.isEmpty()?"Vide.":"Pas vide.");
		
		//Insertion d'un élément à une position donnée
		arrayList.add(1, Jour.MARDI);
		System.out.println(arrayList);
		
		//Suppression de la première occurrence d'un élément donné
		arrayList.remove(Jour.VENDREDI);
		System.out.println(arrayList);
		
		//Suppression d'un élément donné à une position donnée
		arrayList.remove(0);
		System.out.println(arrayList);
		
		//Accès direct par position
		Jour j = arrayList.get(2);
		System.out.println("En position 2, il y a "+ j +".");
		
		//Recherche de la position d'un élément donné
		int pos = arrayList.indexOf(Jour.JEUDI);
		System.out.println("Le premier "+ Jour.JEUDI +" est en "+ pos +".");
		
		pos = arrayList.lastIndexOf(Jour.JEUDI);
		System.out.println("Le dernier "+ Jour.JEUDI +" est en "+ pos +".");
		
		//Recherche de la présence d'un élément donnée
		boolean trouve = arrayList.contains(Jour.MARDI);
		System.out.println(trouve ? "Mardi est là.":"Mardi est absent!");
		trouve = arrayList.contains(Jour.DIMANCHE);
		System.out.println(trouve ? "Dimanche est là.":"Dimanche est absent!");
		
		//Remplacer un élément par un autre à une position donnée
		arrayList.set(2, Jour.MERCREDI);
		System.out.println(arrayList);
		
		//Compte des éléments dans la séquence
		int nbJours = arrayList.size();
		System.out.println("Taille: "+ nbJours);
		
		
		for(int k=0;k<1000;k++) arrayList.add(Jour.DIMANCHE);
		nbJours = arrayList.size();
		
		//Parcourir une séquence (boucle for): old school
		long debut = System.currentTimeMillis();
		for(int i=0;i<nbJours;i++) {
			System.out.print(arrayList.get(i));
		}
		long fin = System.currentTimeMillis();
		System.out.println("\nFor:\t"+ (fin-debut));
		
		
		//Parcourir une séquence (boucle foreach): un peu mieux
		debut = System.currentTimeMillis();
		for(Jour elem : arrayList) {
			System.out.print(elem);
		}
		fin = System.currentTimeMillis();
		System.out.println("\nForeach:\t"+ (fin-debut));
		
		
		//Parcourir une séquence (avec itérateur): bcp plus rapide!
		debut = System.currentTimeMillis();
		Iterator<Jour> it = arrayList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		fin = System.currentTimeMillis();
		System.out.println("\nIterator:\t"+ (fin-debut));
		
		//ALLER-RETOUR: Parcourir une séquence (boucle foreach)
		debut = System.currentTimeMillis();
		for(int i=0;i<nbJours;i++) {
			System.out.print(arrayList.get(i));
		}
		for(int i=nbJours-1;i>=0;i--) {
			System.out.print(arrayList.get(i));
		}
		fin = System.currentTimeMillis();
		System.out.println("\n[A-R] For:\t"+ (fin-debut));
		
		//ALLER-RETOUR: Parcourir une séquence (avec itérateur)
//		arrayList.remove(nbJours-1);
//		arrayList.add(Jour.JEUDI);
		debut = System.currentTimeMillis();
		ListIterator<Jour> lit = arrayList.listIterator();
		while(lit.hasNext()) {
			System.out.print(lit.next());
		}
		while(lit.hasPrevious()) {
			System.out.print(lit.previous());
		}
		fin = System.currentTimeMillis();
		System.out.println("\n[A-R] ListIterator:\t"+ (fin-debut));

		// Parcourir à partir d'une position spécifique
		ListIterator<Jour> lit2 = arrayList.listIterator(nbJours/2);	// à partir du milieu
		System.out.println("Prochain: "+ lit2.nextIndex() +" - "+ lit2.next());		// indice du prochain
		System.out.println("Précédent: "+ lit2.previousIndex() +" - "+ lit2.previous());	// indice du précédent

		
		System.out.println("###################################################");
		//Opérations d'ensemble ************************************************
		//Ajout d'une séquence entière à la fin d'une autre séquence
		ArrayList<Jour> jours = new ArrayList<Jour>();
		jours.add(Jour.DIMANCHE);
		jours.add(0,Jour.LUNDI);
		arrayList.addAll(jours);
		System.out.println(arrayList);
		
		//Ajout d'une séquence entière à une position donnée (facultative)
		arrayList.addAll(4, jours);
		System.out.println(arrayList);
		
		//Suppression de tous les éléments de la séquence
		jours.clear();
		System.out.println(jours);
		
		//Copie d'une séquence
		jours = (ArrayList<Jour>) arrayList.clone();
		System.out.println(jours);
		
		//Recherche globale de tous les éléments d'une séquence dans une autre
		boolean idem = arrayList.containsAll(jours);
		System.out.println(idem ? "Tout est là.":"Au moins un des éléments est absent!");
		jours.add(Jour.VENDREDI);
		idem = arrayList.containsAll(jours);
		System.out.println(idem ? "Tout est là.":"Au moins un des éléments est absent!");
		
		//Suppression de toutes les occurrences des éléments d'une séquence présents dans une autre
			jours.clear(); jours.add(Jour.DIMANCHE);jours.add(Jour.LUNDI);
		arrayList.removeAll(jours);	//Tous les LUNDI et DIMANCHE sont retirés 
		System.out.println(arrayList);
		
		//Suppression inversée: ceux qui ne correspondent pas sont supprimés
			arrayList.addAll(jours); //On ajoute DIMANCHE et LUNDI
			jours.clear(); jours.add(Jour.MARDI);jours.add(Jour.MERCREDI);jours.add(Jour.JEUDI);
		arrayList.retainAll(jours);	//On ne garde que les MARDI, MERCREDI et JEUDI
		
		//Obtenir une vue sur une sous-liste
		List<Jour> vue = arrayList.subList(1, 3);
		System.out.println(vue);
		
		vue.add(Jour.SAMEDI);		//L'ajout se fait à la fin de la vue mais modifie aussi la séquence
		System.out.println(arrayList);
		
		vue.clear();	//Suppression de tous les éléments de la sous-liste
		System.out.println(arrayList);

	}
	
	public enum Jour {
		LUNDI, MARDI, MERCREDI, JEUDI,
		VENDREDI, SAMEDI, DIMANCHE
	}

}
