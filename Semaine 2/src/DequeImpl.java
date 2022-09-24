import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Corentin D'haeyere
 */

public class DequeImpl<E> implements Deque<E> {

	private Object[] table;
	private int indicePremier;
	private int indiceDernier;
	private int taille;
	private int numVersion = 0; // pour l'iterateur

	public DequeImpl() {
		table = new Object[5];
		indicePremier = 0;
		indiceDernier = 0;
		taille = 0;
	}

	// Va servir pour les tests
	// A ne pas modifier!!!
	public DequeImpl(Object[] tableARecopier) {
		if (tableARecopier == null)
			throw new IllegalArgumentException();
		table = new Object[tableARecopier.length + 4];
		for (int i = 0; i < tableARecopier.length; i++) {
			table[i + 2] = tableARecopier[i];
		}
		indicePremier = 2;
		indiceDernier = indicePremier + tableARecopier.length - 1;
		taille = tableARecopier.length;
	}

	// Va servir pour les tests
	// A ne pas modifier!!!
	public String toString() {
		String aRenvoyer = "";
		for (int i = indicePremier; i <= indiceDernier; i++) {
			aRenvoyer += " " + table[i];
		}
		return aRenvoyer;
	}

	@Override
	public boolean estVide() {
		return taille == 0;
	}

	@Override
	public int taille() {
		return taille;
	}

	private void agrandirTable() {
		Object[] temp = new Object[table.length * 2];
		int middle = (temp.length - taille) / 2;
		int compteur = taille;
		int i = indicePremier;
		while(compteur != 0) {
			temp[middle] = table[i];
			middle++;
			i++;
			compteur--;
		}
		indicePremier = (temp.length - taille) / 2;
		indiceDernier = indicePremier + taille - 1;
		table = temp;
	}

	@Override
	public void ajouterEnPremier(E element) {
		if (estVide()) {
			table[table.length / 2] = element;
			indicePremier = table.length / 2;
			indiceDernier = indicePremier;
			taille = 1;
			numVersion++;
		} else if (indicePremier == 0) {
			agrandirTable();
			indicePremier--;
			table[indicePremier] = element;
			taille++;
			numVersion++;
		} else {
			indicePremier--;
			table[indicePremier] = element;
			taille++;
			numVersion++;
		}
	}

	@Override
	public void ajouterEnDernier(E element) {
		if (estVide()) {
			table[table.length / 2] = element;
			indiceDernier = table.length / 2;
			indicePremier = indiceDernier;
			taille = 1;
			numVersion++;
		} else if (indiceDernier == table.length - 1) {
			agrandirTable();
			indiceDernier++;
			table[indiceDernier] = element;
			taille++;
			numVersion++;
		} else {
			indiceDernier++;
			table[indiceDernier] = element;
			taille++;
			numVersion++;
		}
	}

	@Override
	public E premier() {
		if (estVide())
			return null;
		return (E) table[indicePremier];

	}

	@Override
	public E dernier() {
		if (estVide())
			return null;
		return (E) table[indiceDernier];
	}

	@Override
	public E supprimerPremier() {
		E element = premier();
		table[indicePremier] = null;
		indicePremier++;
		numVersion++;
		taille--;
		return element;
	}

	@Override
	public E supprimerDernier() {
		E element = dernier();
		table[indiceDernier] = null;
		indiceDernier--;
		numVersion++;
		taille--;
		return element;
	}

	@Override
	public Iterator<E> iterator() {
		return new IterateurImpl<E>();
	}

	private class IterateurImpl<E> implements Iterator<E> {

		private int indiceCourant;
		private int version;

		private IterateurImpl() {
			indiceCourant = indicePremier;
			version = numVersion;
		}

		@Override
		public boolean hasNext() {
			return table[indiceCourant] != null;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			if (version != numVersion)
				throw new ConcurrentModificationException();
			indiceCourant = indiceCourant + 1;
			return (E) table[indiceCourant - 1];
		}

		@Override
		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}
