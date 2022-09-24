
public class SerieEtudiants {
	
	private int numeroSerie;
	private ListeSimple<String> listeEtudiants;
	
	/**
	 * construit une serie contenant 0 etudiant
	 * @param numero le numero de la serie
	 * @throws IllegalArgumentException si le numero < 1 
	 */
	public SerieEtudiants(int numero) {
		if (numero<1) throw new IllegalArgumentException();
		listeEtudiants = new ListeSimpleImpl<>();
		this.numeroSerie = numero;
	}

	/**
	 * renvoie le nombre d'etudiants dans la serie
	 * @return le nombre d'etudiants
	 */
	public int nombreEtudiants(){
		return listeEtudiants.taille();
	}
	
	/**
	 * renvoie le numero de la serie
	 * @return le numero de la serie
	 */
	public int getNumeroSerie(){
		return numeroSerie;
	}
	
	/**
	 * verifie la presence d'un etudiant dans la serie
	 * @param nom le nom de l'etudiant recherche
	 * @return true si l'etudiant est present, false sinon
	 * @throws IllegalArgumentException si le nom est null
	 */
	public boolean contientEtudiant(String nom){
		if (nom==null) throw new IllegalArgumentException();
		return listeEtudiants.contient(nom);
	}
	
	
	/**
	 * ajoute un etudiant 
	 * l'ordre des etudiants dans la serie n'a pas d'importance
	 * precondition : l'etudiant n'est present dans aucune des series
	 * ! Il ne faut pas verifier une precondition !
	 * @param nom le nom de l'etudiant a ajouter
	 * @throws IllegalArgumentException si le nom est null
	 */
	public void ajouterEtudiant(String nom){
		if (nom==null) throw new IllegalArgumentException();
		listeEtudiants.insererEnTete(nom);
	}

	
	/**
	 * supprime un etudiant s'il est present dans la serie.
	 * @param nom le nom de l'etudiant a supprimer
	 * @return true si l'etudiant etait dans la serie, false sinon
	 * @throws IllegalArgumentException si le nom est null
	 */
	public boolean supprimerEtudiant(String nom){
		return listeEtudiants.supprimer(nom);
	}

	public String toString(){
		return "Série n°"+numeroSerie+listeEtudiants.toString();
	}

}
