import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArbreDEntiers implements Iterable<Integer>{
	protected NoeudEntier racine; 
	protected int taille;
	
	public ArbreDEntiers () {
		this.racine=null ;
		this.taille=0;
	}

	public ArbreDEntiers (int entier) {
		this.racine=new NoeudEntier(entier) ;
		this.taille=1;
	}
	
	public ArbreDEntiers (ArbreDEntiers gauche, int entier, ArbreDEntiers droit) {
		this.racine=new NoeudEntier(gauche.racine,entier,droit.racine) ;
		this.taille= 1 + gauche.taille + droit.taille;
	}

	public boolean estVide () {
		return  this.racine == null;
	}

	public int taille () {
		return taille;
	}

	public Iterator<Integer> preIterateur () {
		return new PreIterateur(this);
	}
	
	public Iterator<Integer> postIterateur () {
		return new PostIterateur(this);
	}

	// iterateur in ordre
	public Iterator<Integer> iterator () {
		return new InIterator(this);
	}
	
	public Iterator<Integer> iterateurParNiveau () {
		return new LevelIterator(this);
	}
	
	
	protected class NoeudEntier {
		protected int entier; 
		protected NoeudEntier gauche;
		protected NoeudEntier droit;

		private NoeudEntier (int entier) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
		}
		
		private NoeudEntier (NoeudEntier g,int entier,NoeudEntier d) {
			this.entier = entier;
			this.gauche = g;
			this.droit = d;
		}
	}
	
	private class PreIterateur implements Iterator<Integer> {
		
		private final ArrayDeque<Integer> fileDEntiers;
		
		public PreIterateur (ArbreDEntiers a) {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(a.racine);
		}
		
		private void remplirFile (NoeudEntier n) {
			if (n != null) {
				fileDEntiers.add(n.entier);
				remplirFile(n.gauche);
				remplirFile(n.droit);
			}
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
		}

		public Integer next () {
			if (hasNext()) {
				return fileDEntiers.removeFirst();
			} else throw new NoSuchElementException();
		}
	}

	private class PostIterateur implements Iterator<Integer> {

		private final ArrayDeque<Integer> fileDEntiers;

		public PostIterateur (ArbreDEntiers a) {
			fileDEntiers = new ArrayDeque<>(taille);
			remplirFile(a.racine);
		}

		private void remplirFile (NoeudEntier n) {
			if (n != null) {
				remplirFile(n.gauche);
				remplirFile(n.droit);
				fileDEntiers.add(n.entier);
			}
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
		}

		public Integer next () {
			if (hasNext()) {
				return fileDEntiers.removeFirst();
			} else throw new NoSuchElementException();
		}
	}

	private class InIterator implements Iterator<Integer> {

		private final ArrayDeque<Integer> fileDEntiers;

		public InIterator (ArbreDEntiers a) {
			fileDEntiers = new ArrayDeque<>(taille);
			remplirFile(a.racine);
		}

		private void remplirFile (NoeudEntier n) {
			if (n != null) {
				remplirFile(n.gauche);
				fileDEntiers.add(n.entier);
				remplirFile(n.droit);
			}
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
		}

		public Integer next () {
			if (hasNext()) {
				return fileDEntiers.removeFirst();
			} else throw new NoSuchElementException();
		}
	}

	private class LevelIterator implements Iterator<Integer> {

		private final ArrayDeque<NoeudEntier> fileDNoeuds;

		public LevelIterator (ArbreDEntiers a) {
			fileDNoeuds = new ArrayDeque<>();
			if (!a.estVide()) fileDNoeuds.add(a.racine);
		}

		public boolean hasNext () {
			return !fileDNoeuds.isEmpty();
		}

		public Integer next () {
			if (hasNext()) {
				NoeudEntier noeud = fileDNoeuds.removeFirst();
				if (noeud.gauche != null)
					fileDNoeuds.addLast(noeud.gauche);
				if (noeud.droit != null)
					fileDNoeuds.addLast(noeud.droit);
				return noeud.entier;
			} else throw new NoSuchElementException();
		}
	}
}
