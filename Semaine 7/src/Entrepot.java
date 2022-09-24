import java.util.HashMap;

/**
 * @author Corentin D'haeyere
 */

public class Entrepot {

	private final Hangar[] tableHangars;
	private final HashMap<Integer, Societe> societeMap;

	private int nombreHangarsOccupes;

	/**
	 * construit un entrepot contenant nombreHangars
	 * @param nombreHangars le nombre d'hangars
	 * @throws IllegalArgumentException si le nombre d'hangars est negatif ou nul
	 */
	public Entrepot(int nombreHangars) {
		if (nombreHangars <= 0) throw new IllegalArgumentException();
		tableHangars = new Hangar[nombreHangars];
		societeMap = new HashMap<>();
		for (int i = 0 ; i< nombreHangars ; i++) {
			Hangar hangar = new Hangar(i);
			tableHangars[i] = hangar;
		}
	}
	
	/**
	 * attribue un hangar a la societe passee en parametre
	 * Si l'attribution a pu se faire : 
	 * la societe est enregistree comme presente (si pas encore presente)
	 * le hangar lui est ajoute
	 * @param numeroSociete le numero de la société
	 * @param nomSociete le nom de la société
	 * @return le numero du hangar attribue ou -1 s'il n'y en a plus de libre
	 */
	public int attribuerHangar(int numeroSociete, String nomSociete) {
		if (!checkHangarDispo()) return -1;
		Societe societeTemp = new Societe(numeroSociete, nomSociete);
		if (!societeMap.containsKey(numeroSociete))
			societeMap.put(numeroSociete, societeTemp);
		int numeroHangar = -1;
		if (numeroSociete >= tableHangars.length) numeroHangar = numeroSociete % tableHangars.length;
		else numeroHangar = numeroSociete;
		while (tableHangars[numeroHangar].getSociete() != null) {
			if (numeroHangar >= tableHangars.length - 1)
				numeroHangar = -1;
			numeroHangar++;
		}
		societeMap.get(numeroSociete).ajouterHangar(numeroHangar);
		tableHangars[numeroHangar].setSociete(societeTemp);
		nombreHangarsOccupes++;
		return numeroHangar;
	}

	public String listeHangars(int numeroSociete) {
		if (societeMap.get(numeroSociete) == null)
			return "La societe n'existe pas ! ";
		return societeMap.get(numeroSociete).lesHangars();
	}

	/**
	 * renvoie la societe dont le numero est passe en parametre
	 * @param numeroSociete le numero de la societe
	 * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
	 */
	public Societe getSociete(int numeroSociete){
		if (societeMap.containsKey(numeroSociete)) {
			return societeMap.get(numeroSociete);
		}
		return null;
	}

	public boolean checkHangarDispo() {
		for (int i = 0 ; i < tableHangars.length-1 ; i++) {
			if (tableHangars[i].getSociete() == null) return true;
		}
		return false;
	}

	public boolean liberer(int numeroHangar) {
		if (numeroHangar < 0 || numeroHangar > tableHangars.length) {
			System.out.println("numero de hangar incorrect");
			return false;
		}
		if (tableHangars[numeroHangar].getSociete() == null) return false;
		int numeroSociete = tableHangars[numeroHangar].getSociete().getNumeroSociete();
		societeMap.get(numeroSociete).retirerHangar(numeroHangar);
		tableHangars[numeroHangar].setSociete(null);
		return true;
	}
}
