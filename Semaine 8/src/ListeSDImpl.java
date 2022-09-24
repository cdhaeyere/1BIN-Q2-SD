import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeSDImpl<E> implements ListeSD<E>, Iterable<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();
		queue = new Noeud();
		tete.suivant = queue;
		queue.precedent = tete;
	}

	public int taille () {
		return mapElementNoeud.size();
	}

	public boolean estVide () {
		return mapElementNoeud.isEmpty();
	}

	public boolean contient (E element) {
		return mapElementNoeud.containsKey(element);
	}

	public E premier() {
		return tete.suivant.element;
	}

	public E dernier() {
		return queue.precedent.element;
	}

	public boolean insererEnTete (E element){
		if (mapElementNoeud.containsKey(element)) return false;

		Noeud nouveauNoeud = new Noeud(element);

		Noeud noeudAvant = tete;
		Noeud noeudApres = tete.suivant;

		nouveauNoeud.precedent = tete;
		nouveauNoeud.suivant = tete.suivant;
		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;

		mapElementNoeud.put(element, nouveauNoeud);
		return true;
	}

	public boolean insererEnQueue (E element) {
		if (mapElementNoeud.containsKey(element)) return false;

		Noeud nouveauNoeud = new Noeud(element);

		Noeud noeudAvant = queue.precedent;
		Noeud noeudApres = queue;

		nouveauNoeud.precedent = queue.precedent;
		nouveauNoeud.suivant = queue;
		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;

		mapElementNoeud.put(element, nouveauNoeud);
		return true;
	}

	public boolean insererApres (E elementAvant, E elementAInserer){
		if (mapElementNoeud.containsKey(elementAInserer)) return false;

		Noeud nouveauNoeud = new Noeud(elementAInserer);

		Noeud noeudAvant = mapElementNoeud.get(elementAvant);
		if(noeudAvant == null) return false;
		Noeud noeudApres = noeudAvant.suivant;

		nouveauNoeud.precedent=noeudAvant;
		nouveauNoeud.suivant=noeudApres;
		noeudAvant.suivant=nouveauNoeud;
		noeudApres.precedent=nouveauNoeud;

		mapElementNoeud.put(elementAInserer, nouveauNoeud);

		return true;
	}

	public boolean insererAvant (E elementApres, E elementAInserer) {
		if (mapElementNoeud.containsKey(elementAInserer)) return false;

		Noeud nouveauNoeud = new Noeud(elementAInserer);

		Noeud noeudApres = mapElementNoeud.get(elementApres);
		if (noeudApres==null) return false;
		Noeud noeudAvant = noeudApres.precedent;

		nouveauNoeud.precedent = noeudAvant;
		nouveauNoeud.suivant = noeudApres;
		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;

		mapElementNoeud.put(elementAInserer, nouveauNoeud);

		return true;
	}


	public boolean supprimer (E element) {
		Noeud noeud = mapElementNoeud.remove(element);
		if(noeud==null)
			return false;
		Noeud noeudAvant = noeud.precedent;
		Noeud noeudApres = noeud.suivant;

		noeudAvant.suivant= noeudApres;
		noeudApres.precedent= noeudAvant;

		mapElementNoeud.remove(element, noeud);
		return true;
	}

	public E donnerPrecedent (E element) {
		Noeud noeud = mapElementNoeud.get(element);
		if (noeud == null) return null;
		return noeud.precedent.element;
	}

	public E donnerSuivant (E element) {	
		Noeud noeud = mapElementNoeud.get(element);
		if (noeud == null) return null;
		return noeud.suivant.element;
	}
	
	
	public boolean permuter (E element1, E element2) {
		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
		// Il est donc inutile de revoir le chainage
		// N'oubliez pas de modifier les noeuds associes dans le map

		Noeud noeud1 = mapElementNoeud.get(element1);
		Noeud noeud2 = mapElementNoeud.get(element2);

		if (noeud1 == null || noeud2 == null) return false;

		noeud1.element = element2;
		noeud2.element = element1;

		mapElementNoeud.put(element1, noeud2);
		mapElementNoeud.put(element2, noeud1);

		return true;
	}

	public int donnerPosition(E element) {
		if (element == null ) throw new IllegalArgumentException();
		if (!mapElementNoeud.containsKey(element)) return -1;
		Noeud nouveauNoeud = tete.suivant;
		int index = 1;
		while (nouveauNoeud != null) {
			if ((nouveauNoeud.element).equals(element)) return index ;
			nouveauNoeud = nouveauNoeud.suivant;
			index++;

		}
		return -1;
	}

	public Iterator<E> iterator() {
		return new IterateurImpl<E>();
	}

	public String toString () {
		String aRenvoyer = "";
		int num = 1;
		Noeud baladeur = tete.suivant;
		while (baladeur != queue) {
			aRenvoyer += num + " - " + baladeur.element + "\n";
			baladeur = baladeur.suivant;
			num++;
		}
		return aRenvoyer;   
	}

	public String toStringAffichage() {
		StringBuilder sb = new StringBuilder();
		Noeud baladeur = tete.suivant;
		while (baladeur != queue) {
			sb.append(baladeur.element).append("	");
			baladeur = baladeur.suivant;
		}
		return sb.toString();
	}

	// pour les tests
	public ListeSDImpl(E[] tableACopier) {	
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		Noeud prec = tete;
		for (int i = 0; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapElementNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		prec.suivant = queue;
		queue.precedent = prec;	
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete.suivant;
			int cpt=0;
			while (baladeur != queue) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.suivant;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// pour les tests
	public String queueTete(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = queue.precedent;
			int cpt=0;
			while (baladeur != tete) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.precedent;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// Classe interne Noeud
	private class Noeud{
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud() {
			this(null, null, null);
		}

		private Noeud(E element) {
			this(null, element, null);
		}

		private Noeud(Noeud precedent, E element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
			this.precedent = precedent;
		}
	}

	

	// Classe interne IterateurImpl
	private class IterateurImpl<E> implements Iterator<E>{

		private Noeud noeudCourant;

		private IterateurImpl() {
			noeudCourant = tete.suivant;
		}

		public boolean hasNext() {
			return noeudCourant != queue;
		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E aRenvoyer = (E)noeudCourant.element;
			noeudCourant = noeudCourant.suivant;
			return aRenvoyer;
		}

		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}

}
