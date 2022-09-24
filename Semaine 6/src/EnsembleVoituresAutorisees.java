/**
 * @author Corentin D'haeyere
 */
public class EnsembleVoituresAutorisees{

	private EnsembleTableHashing ensemble;
	// Utilisez un objet de la classe EnsembleTableHashing
	private int tailleParking = 500;

	// construit un ensemble vide mais pouvant contenir jusqu'a 500 voitures
	public EnsembleVoituresAutorisees(){
		ensemble = new EnsembleTableHashing(tailleParking);
	}


	/**
	 * ajoute la voiture dans l ensemble des voitures autorisees
	 * @param voiture la voiture autorisee
	 * @return true si la voiture etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(Voiture voiture){
		if (voiture == null)
			return false;
		else return ensemble.ajouter(voiture);
	}

	/**
	 * retire la voiture de l ensemble des voitures autorisees
	 * @param voiture la voiture non autorisee
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(Voiture voiture){
		if (voiture == null)
			return false;
		else return ensemble.enlever(voiture);
	}

	
	/**
	 * verifie si la voiture est presente dans l ensemble des voitures autorisees
	 * @param voiture la voiture a verifier
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean voitureAutorisee(Voiture voiture){
		if (voiture == null)
			return false;
		else return ensemble.contient(voiture);
	}
}