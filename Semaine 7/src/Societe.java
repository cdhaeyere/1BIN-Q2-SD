import java.util.LinkedList;

/**
 * @author Corentin D'haeyere
 */

public class Societe {

	private final int numeroSociete;
	private final String nom;
	private final LinkedList<Integer> lesHangars;
	
	/**
	 * construit une societe sans hangar
	 * @param numeroSociete son numero
	 * @param nom son nom
	 * @throws IllegalArgumentException si le numero de la societe est negatif ou nul 
	 *                                  si le nom est null ou ""
	 */
	public Societe(int numeroSociete, String nom) {
		if(numeroSociete<0)
			throw new IllegalArgumentException();
		if(nom == null || nom.equals(""))
			throw new IllegalArgumentException();
		this.numeroSociete = numeroSociete;
		this.nom = nom;
		lesHangars = new LinkedList<Integer>();
	}

	/**
	 * renvoie un String avec les hangars occupes par la societe 
	 * @return 
	 */
	public String lesHangars() {
		return lesHangars.toString();
		// A NE PAS MODIFIER --> VA SERVIR POUR LES TESTS
	}

	/**
	 * ajoute un hangar si celui-ci n'y est pas encore
	 * @param numeroHangar le numero du hangar ajoute
	 * @return si le hangar a pu être ajouté
	 */
	public boolean ajouterHangar(int numeroHangar){
		if (!lesHangars.contains(numeroHangar)) {
			lesHangars.add(numeroHangar);
			return true;
		}
		return false;
	}

	/**
	 * retire un hangar si celui-ci y est
	 * @param numeroHangar le numero du hangar
	 * @return si le hangar a pu être retiré
	 */
	public boolean retirerHangar(int numeroHangar) {
		if (lesHangars.contains(numeroHangar)) {
			lesHangars.remove(Integer.valueOf(numeroHangar));
			return true;
		}
		return false;
	}
	
	// A VOUS D'AJOUTEZ LES METHODES INDISPENSABLES pour l'application 
	public int getNumeroSociete() {
		return numeroSociete;
	}
	
	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Societe [numeroSociete=" + numeroSociete + ", nom=" + nom
				+ ", lesHangars=" + lesHangars + "]";
	}


	@Override
	public int hashCode() {
		return numeroSociete;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Societe other = (Societe) obj;
		if (numeroSociete != other.numeroSociete)
			return false;
		return true;
	}
}
