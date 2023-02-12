import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class LinkedListMain {
	private static LinkedList<Jour> linkedList;
	private static ArrayDeque<Jour> arrayDeque;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		linkedList = new LinkedList<Jour>();
		//Ajouter à la fin (add = addLast)
		linkedList.add(Jour.JEUDI);
		linkedList.addLast(Jour.VENDREDI);
		linkedList.offer(Jour.SAMEDI);
		linkedList.offerLast(Jour.DIMANCHE);
		System.out.println(linkedList);
		
		//Ajouter au début
		linkedList.addFirst(Jour.MERCREDI);
		linkedList.offerFirst(Jour.MARDI);
		linkedList.push(Jour.LUNDI);
		System.out.println(linkedList);
				
		//Connaître le premier élément
		Jour first = linkedList.element();
		System.out.println(first);
		
		first = linkedList.getFirst();
		System.out.println(first);

		first = linkedList.peek();
		System.out.println(first);
		
		first = linkedList.peekFirst();
		System.out.println(first);
				
		//Connaître le dernier élément
		Jour last = linkedList.getLast();
		System.out.println(last);
		
		last = linkedList.peekLast();
		System.out.println(last);
		
		//Retirer le premier
		first = linkedList.pop();
		System.out.println(first);
		System.out.println(linkedList);
		
		first = linkedList.poll();
		System.out.println(first);
		System.out.println(linkedList);

		first = linkedList.pollFirst();
		System.out.println(first);
		System.out.println(linkedList);
		
		first = linkedList.remove();
		System.out.println(first);
		System.out.println(linkedList);

		first = linkedList.remove(0);
		System.out.println(first);
		System.out.println(linkedList);

		first = linkedList.removeFirst();
		System.out.println(first);
		System.out.println(linkedList);
		

			linkedList.clear();
			ajouterSemaine(linkedList);

		//Retirer le dernier
		last = linkedList.remove(linkedList.size()-1);
		System.out.println(last);
		System.out.println(linkedList);

		last = linkedList.pollLast();
		System.out.println(last);
		System.out.println(linkedList);

		//Retirer la première occurrence d'un élément précis
		Boolean retire = linkedList.remove(Jour.LUNDI);
		System.out.println(retire?"Retiré":"Non trouvé");
		System.out.println(linkedList);
		
		retire = linkedList.removeFirstOccurrence(Jour.LUNDI);
		System.out.println(retire?"Retiré":"Non trouvé");
		System.out.println(linkedList);
		
		//Retirer la première occurrence d'un élément précis
		retire = linkedList.removeLastOccurrence(Jour.LUNDI);
		System.out.println(retire?"Retiré":"Non trouvé");
		System.out.println(linkedList);
		
		
			linkedList.clear();
			ajouterSemaine(linkedList);

		//Parcourir avec un itérateur: du premier au dernier 
		Iterator<Jour> it = linkedList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

		//Parcourir avec un itérateur: du dernier au premier
		Iterator<Jour> dit = linkedList.descendingIterator();
		while(dit.hasNext()) {
			System.out.println(dit.next());
		}

		test();
	}
		
	public static void ajouterSemaine(Collection<Jour> c) {
		c.add(Jour.LUNDI);
		c.add(Jour.MARDI);
		c.add(Jour.MERCREDI);
		c.add(Jour.JEUDI);
		c.add(Jour.VENDREDI);
		c.add(Jour.SAMEDI);
		c.add(Jour.DIMANCHE);
	}
	
	public static void test() {
		//######## LinkedList vs AArrayDeque ###################
		final Queue<Jour> qLL = new LinkedList<Jour>(); 

		final Queue<Jour> qAD = new ArrayDeque<Jour>(); 

		int count = 1000000;
		
		System.out.println("Début du test"); 
		long start = System.nanoTime(); 
		for (int i = 0; i < count; i++) {
			qLL.offer(Jour.LUNDI); 
		} 
		for (int i = (count >> 1); i > 0; i--) { 
			qLL.peek(); 
			qLL.poll(); 
		} 
		long end = System.nanoTime(); 
		System.out.println("\tAvec LinkedList: " + (end - start) / 1000000 + "ms"); 

		System.gc(); 

		start = System.nanoTime(); 
		for (int i = 0; i < count; i++) { 
			qAD.offer(Jour.LUNDI); 
		} 
		for (int i = (count >> 1); i > 0; i--) { 
			qAD.peek(); 
			qAD.poll(); 
		} 
		end = System.nanoTime(); 
		System.out.println("\tAvec ArrayDeque: " + (end - start) / 1000000 + "ms"); 
		System.out.println("Fin du test");
		//Conclusion:
		//Utiliser ArrayDeque plutôt que LinkedList pour implémenter une Queue
	}
	
	public enum Jour {
		LUNDI, MARDI, MERCREDI, JEUDI,
		VENDREDI, SAMEDI, DIMANCHE
	}

}
