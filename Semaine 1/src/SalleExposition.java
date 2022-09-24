/**
 * @author Corentin D'haeyere
 */
public class SalleExposition {

	private Vecteur<Emplacement> emplacements;
	private Pile<Emplacement> emplacementsLiberes;
	
	/**
	 * construit une salle d'exposition vide (aucun emplacement)
	 */
	public SalleExposition(){
		emplacements = new VecteurImpl<Emplacement>();
		emplacementsLiberes = new PileImpl<Emplacement>();
	}
	
	/**
	 * renvoie le nombre d'emplacements 
	 * @return le nombre d'emplacements crees (libres ou occupes)
	 */
	public int nombreEmplacements(){
		return emplacements.taille();
	}

	/**
	 * renvoie le nombre d'oeuvres 
	 * @return le nombre d'oeuvres 
	 */
	public int nombreOeuvres(){
		return emplacements.taille() - emplacementsLiberes.taille();
	}

	/**
	 * ajoute une oeuvre dans la salle d'exposition
	 * (ajoute un emplacement si necessaire)
	 * precondition : l'oeuvre n'y est pas encore
	 * Votre methode ne doit pas faire cette verification!
	 * @param oeuvre l'oeuvre a ajouter
	 * @return le numero de l'oeuvre ajoutee
	 * @throws IllegalArgumentException si l'oeuvre est vide ou null
	 */
	public int ajouter(String oeuvre){
		if (oeuvre == null || oeuvre.equals("")) throw new IllegalArgumentException();
		if (emplacementsLiberes.estVide()) {
			emplacements.ajoute(new Emplacement(emplacements.taille(), oeuvre));
		}
		return emplacements.taille();
	}

	
	/**
	 * renvoie l'oeuvre correspondante au numero passe en parametre
	 * @param numeroOeuvre le numero de l'oeuvre recherchee
	 * @return l'oeuvre ou null si le numeroOeuvre ne correspond a aucune oeuvre actuellement exposee 
	 */
	public String consulter(int numeroOeuvre){
		if (numeroOeuvre < 0 || numeroOeuvre > nombreOeuvres()) return null;
		return emplacements.element(numeroOeuvre-1).getOeuvre();
	}


	/**
	 * supprime l'oeuvre correspondante au numero passe en parametre
	 * @param numeroOeuvre le numero de l'oeuvre a supprimer
	 * @return l'oeuvre supprimee ou null si le numeroOeuvre ne correspond a aucune oeuvre actuellement exposee 
	 */
	public String supprimer(int numeroOeuvre){
		if (numeroOeuvre < 0 || numeroOeuvre > nombreOeuvres()) return null;
		return emplacements.supprime(numeroOeuvre-1).getOeuvre();
	}
	
	/**
	 * renvoie un String avec les oeuvres existantes (pas les emplacements!)
	 * Les numeros et les oeuvres doivent apparaitre 
	 */
	public String donnerCatalogue(){
		return emplacements.toString();
	}
}
