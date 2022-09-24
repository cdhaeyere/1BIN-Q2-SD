import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * Algorithme de tri : UnshuffleSort 

 * Cet algorithme de tri necessite l�utilisation d�une liste de deques.
 * Cet algorithme de tri comporte deux etapes. La premiere consiste a repartir 
 * les entiers a trier dans un nombre variable de deques. Lorsque tous
 * les entiers auront ete repartis, la deuxieme etape se chargera de remplir la
 * table a renvoyer.
 * 
 * Les 2 etapes sont basees sur le principe suivant : La liste des deques devra
 * toujours etre triee en utilisant le premier entier de chaque deque comme clef de tri.
 * Les deques aussi sont tries.
 * 
 * 
 */
public class UnshuffleSort {
	
	private LinkedList<ArrayDeque<Integer>>  listeDeDeques;

	public UnshuffleSort() {
		this.listeDeDeques = new LinkedList<ArrayDeque<Integer>>();
	}

	/**
	 * tri de la table d'entiers re�ue en parametre
	 * 
	 * @param tableATrier la table a trier
	 * @return table contenant les entiers tries
	 */
	public int[] trier(int[] tableATrier) {
		remplirDeques(tableATrier);
		return viderDeques(tableATrier.length);
	}

	/**
	 * 1ere etape du tri : repartition des entiers dans des deques
	 * @param tableATrier la table a trier
	 */
	private void remplirDeques(int[] tableATrier) {
		// Pour le debug:
		System.out.println("etape1");

		for (int entier : tableATrier) {
			placerEntier(entier);
		}

	}

	private void placerEntier(int entier) {
		for (ArrayDeque<Integer> deque : listeDeDeques) {
			if (deque.getFirst() >= entier) { // si le premier element de la pile est plusgrand ou = à l'entier
				deque.addFirst(entier); // on l'ajoute/push dans la pile
				System.out.println(listeDeDeques);
				return; // break car déjà ajouté / stop parcours de l'arraydeque
			}
		}
		ArrayDeque<Integer> repartitionDeque = new ArrayDeque<Integer>(); // else crée new arrayDeque vide
		repartitionDeque.addFirst(entier); // et on l'ajoute/push dans l'arraydeque
		listeDeDeques.add(repartitionDeque); // on ajoute le nouvel arraydeque dans la liste des deques
		// Pour le debug:
		System.out.println(listeDeDeques);
	}
	

	/**
	 * 2eme etape du tri : on vide les deques
	 * 
	 * @param taille nombre d'entiers de la table a trier
	 * @return table contenant les entiers tries
	 */
	private int[] viderDeques(int taille) {

		// Pour le debug:
		System.out.println("etape2");
		int[] aRenvoyer = new int[taille]; // créer tableau d'int
		int indice = 0;
		while (!listeDeDeques.isEmpty()) { // parcours toutes les arraydeques de la liste de deques
			deplacerPremierDeque();
			aRenvoyer[indice] = listeDeDeques.getFirst().removeFirst(); // mets chaque element de la liste de
			// l'arraydeque dans
			// le tableau aRenvoyer
			if (listeDeDeques.getFirst().isEmpty()) { // et si le premier arraydeque est vide
				listeDeDeques.removeFirst(); // on retire l'arraydeque de la liste
			}
			indice++; // augmente l'indice du tableau
			System.out.println(listeDeDeques);
		}
		return aRenvoyer;

		// pour plus de lisibilite cette methode pourrait appeler les methodes suivantes
	}
	
	private int supprimerPlusPetitEntier(){
		return 0;
	}
	
	private void reorganiserListe(){
		// Pour le debug:
		System.out.println(listeDeDeques);
		// la liste ne peut contenir des deques vides
		// la liste des deques doit toujours etre triee selon le premier de chaque deque
		// pour plus de lisibilite cette methode pourrait appeler la methode suivante :
		
	}

	private void deplacerPremierDeque() {

		ArrayDeque<Integer> premierDeque = listeDeDeques.getFirst();
		int compteur = 0;
		for (ArrayDeque<Integer> arrayDeque : listeDeDeques) {
			if (arrayDeque.getFirst() > premierDeque.getFirst()) {
				listeDeDeques.add(compteur, premierDeque);
				listeDeDeques.removeFirst();
				return;
			}
			compteur++;
		}
		if (listeDeDeques.size() != 1) {
			listeDeDeques.add(premierDeque);
			listeDeDeques.removeFirst();
		}
	}

}
