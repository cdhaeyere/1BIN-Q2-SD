import java.util.NoSuchElementException;

import java.util.ArrayList;

public class ListeRecCaracteres {

	private NoeudCaractere tete;
	// N'ajoutez pas d'autres attributs
	
	public ListeRecCaracteres() {
		this.tete=null;
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeRecCaracteres(char[] tableCaracteres) {
		if(tableCaracteres==null)
			throw new IllegalArgumentException();
		for (int i = tableCaracteres.length-1; i>=0; i--) {
			this.tete=new NoeudCaractere(tableCaracteres[i],tete);
		}	
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String toString(){
		String aRenvoyer = "";
		NoeudCaractere baladeur = tete;
		while(baladeur != null) {
			aRenvoyer += " " + baladeur.caractere;
			baladeur = baladeur.suivant;
		}
		return aRenvoyer;
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS !!!
	public void remplacerToutParX(){
		NoeudCaractere baladeur = tete;
		while(baladeur != null) {
			baladeur.caractere = 'x';
			baladeur = baladeur.suivant;
		}
	}
	
	/**
	 * verifie la presence du caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return true si le caractere est present dans la liste, false sinon
	 */
	public boolean contient(char caractereRecherche) {
		if (tete == null)
			return false;
		return contientBis(tete, caractereRecherche);
	}

	private boolean contientBis(NoeudCaractere baladeur, char caractere) {
		if (baladeur == null)
			return false;
		if (baladeur.caractere == caractere)
			return true;
		return contientBis(baladeur.suivant, caractere);
	}
	
	/**
	 * calcule le nombre de fois qu'apparait le caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return le nombre d'occurrences du caractere
	 */
	public int nombreOccurrences(char caractereRecherche) {
		int occurence = 0;
		if (tete == null)
			return 0;
		return nbrOccurences(tete, caractereRecherche, occurence);
	}

	private int nbrOccurences(NoeudCaractere baladeur, char caractere, int occurences) {
		if (baladeur != null) {
			if (baladeur.caractere == caractere)
				occurences++;
			return nbrOccurences(baladeur.suivant, caractere, occurences);
		}
		return occurences;
	}

	/**
	 * remplace la 1ere occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacer(char caractereARemplacer, char nouveauCaractere) {

		if (tete != null)
			remplacerBis(tete, caractereARemplacer, nouveauCaractere);
	}

	private void remplacerBis(NoeudCaractere baladeur, char ancientChar, char nouveauChar) {
		if (baladeur != null) {
			if (baladeur.caractere == ancientChar) {
				baladeur.caractere = nouveauChar;
				return;
			}
			remplacerBis(baladeur.suivant, ancientChar, nouveauChar);
		}
	}
	
	/**
	 * remplace toutes les occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacerTout(char caractereARemplacer, char nouveauCaractere) {

		if (tete != null)
			remplacerToutBis(tete, caractereARemplacer, nouveauCaractere);
	}

	private void remplacerToutBis(NoeudCaractere baladeur, char ancientChar, char nouveauChar) {
		if (baladeur != null) {
			if (baladeur.caractere == ancientChar)
				baladeur.caractere = nouveauChar;
			remplacerToutBis(baladeur.suivant, ancientChar, nouveauChar);
		}
	}

	/**
	 * recherche le plus grand caractere de la liste ('a'<'b'< ...)
	 * @return le plus grand caractere 
	 * @throws NoSuchElementException si la liste est vide
	 */
	public char max() throws NoSuchElementException {
		char caractPlusGrand = ' ';
		if (tete == null)
			throw new NoSuchElementException(" liste de char est vide...");
		return maxBis(tete, caractPlusGrand);
	}

	private char maxBis(NoeudCaractere baladeur, char caractereMax) {
		if (baladeur != null) {
			if (baladeur.caractere >= caractereMax)
				caractereMax = baladeur.caractere;
			return maxBis(baladeur.suivant, caractereMax);
		}
		return caractereMax;
	}

	/**
	 * cree une arrayList contenant les caracteres de la liste 
	 * L'ordre doit etre respecte (une liste est une structure lineaire)
	 * @return l'arrayList cree
	 */
	public ArrayList<Character> enArrayList() {
		ArrayList<Character> listeNoeudChar = new ArrayList<Character>();
		if (tete == null)
			return listeNoeudChar;
		arrayListBis(tete, listeNoeudChar);
		return listeNoeudChar;
	}

	private void arrayListBis(NoeudCaractere baladeur, ArrayList<Character> listeChar) {
		if (baladeur != null) {
			listeChar.add(baladeur.caractere);
			arrayListBis(baladeur.suivant, listeChar);
		}
	}

	/**
	 * verifie si les 2 listes contiennent les memes caracteres et ceci dans le meme ordre
	 * Une liste est une structure LINEAIRE!
	 * @param l la liste a comparer a la liste courante
	 * @return true si les 2 listes sont les memes, false sinon
	 */
	public boolean estEgalA(ListeRecCaracteres l) {
		return estEgalBis(tete, l.tete);
	}

	private boolean estEgalBis(NoeudCaractere baladeur, NoeudCaractere baladeurAutreListe) {
		if (baladeur == null && baladeurAutreListe == null)
			return true;
		if ((baladeur != null && baladeurAutreListe == null) || (baladeur == null && baladeurAutreListe != null))
			return false;
		if (baladeur.caractere != baladeurAutreListe.caractere)
			return false;
		return estEgalBis(baladeur.suivant, baladeurAutreListe.suivant);

	}

	/**
	 * supprime une fois le caractere passe en parametre
	 * si le caractere se trouve plusieurs fois, c est sa premiere occurrence qui sera supprimee
	 * @param caractereASupprimer
	 * @return true si le caractere etait bien present dans la liste, false sinon
	 */
	
	// VERSION 1
	
	public boolean supprimerPremiereOccurrence(char caractereASupprimer){
		if(!contient(caractereASupprimer))
			return false;
		tete = supprimerPremiereOccurrence(tete,caractereASupprimer);
		return true;		
	}
	
	private NoeudCaractere supprimerPremiereOccurrence(NoeudCaractere noeud, char caractereASupprimer) {
		if(noeud==null)
			return null;
		if(noeud.caractere==caractereASupprimer)
			return noeud.suivant;
		noeud.suivant=supprimerPremiereOccurrence(noeud.suivant, caractereASupprimer);
		return noeud;
	}
	
	// VERSION 2
	
//	public boolean supprimerPremiereOccurrence(char caractereASupprimer) {
//		if(tete == null)
//			return false;
//		if(tete.caractere==caractereASupprimer){
//			tete = tete.suivant;
//			return true;
//		}
//			
//		return this.supprimerPremiereOccurrence(tete, caractereASupprimer) ;
//	}
//	
//	private boolean supprimerPremiereOccurrence(NoeudCaractere noeud, char caractereASupprimer) {
//		if (noeud.suivant == null)
//			return false ;
//		if (noeud.suivant.caractere == caractereASupprimer) {
//			noeud.suivant = noeud.suivant.suivant ;
//			return true ;
//		}
//		return supprimerPremiereOccurrence(noeud.suivant, caractereASupprimer);
//	}
	
	
	

	/**
	 * cree une liste qui est une copie de la liste courante (meme ordre)
	 * @return une copie de la liste courante
	 */
	public ListeRecCaracteres clone(){
		
		return null;

		// TODO
		
		// DEFI!
		
		// La methode recursive renvoie un noeud!
		// Lisez attentivement la version 1 de la solution de supprimerPremiereOccurrence
		
	}

	
	/**
	 * supprime le caractere autant de fois qu'il est present dans la liste
	 * @param caractereASupprimer
	 * @return le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(char caractereASupprimer){
		
		return 0;
	
		// TODO
		
		// DEFI!
		
		// Lisez attentivement la version 1 ou la version 2 de la solution recursive de supprimerPremiereOccurrence
	}
	

	

	private class NoeudCaractere{
		private char caractere;
		private NoeudCaractere suivant;

		public NoeudCaractere(char caractere, NoeudCaractere suivant){
			this.caractere = caractere;
			this.suivant = suivant;
		}

	}
}
