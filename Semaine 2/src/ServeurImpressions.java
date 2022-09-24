/**
 * @author Corentin D'haeyere
 */
public class ServeurImpressions{

	private final FileAttenteImpressions[] table;

	/**
	 * construit une table avec 10 files FileAttenteImpressions
	 */
	public ServeurImpressions() {
		table = new FileAttenteImpressions[10];
		for (int i = 0; i < table.length; i++){
			table[i] = new FileAttenteImpressions();
		}
	}
	
	/**
	 * verifie si toutes les files sont vides
	 * @return true si toutes les files sont vides, false sinon
	 */
	public boolean estVide(){
		for (FileAttenteImpressions attenteImpressions : table) {
			if (!attenteImpressions.estVide()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ajoute la demande d impression en fin de la file de priorite correspondante
	 * @param demande la demande a ajouter
	 * @throws IllegalArgumentException si la demande est null
	 */
	public void ajouter(DemandeImpressionAvecPriorite demande){
		if (demande == null) throw new IllegalArgumentException();
		table[demande.getPriorite()].ajouter(demande);
	}
	
	/**
	 * retire l'impression en tete de file de priorite la plus haute qui est non vide
	 * @return l'impression qui a ete retiree
	 * @throws FileVideException si aucune demande d impression dans la file
	 */
	public DemandeImpressionAvecPriorite retirer() throws FileVideException{
		for (int i = 9;i >= 0;i--){
			if (!table[i].estVide()){
				return (DemandeImpressionAvecPriorite) table[i].retirer();
			}
		}
		throw new FileVideException();
	}
}


