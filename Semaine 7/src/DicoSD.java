import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Corentin D'haeyere
 */

public class DicoSD {

	public HashMap<String, LinkedList<String>> mapSite;

	// Au depart le dico est vide
	public DicoSD() {
		mapSite = new HashMap<>();
	}

	/**
	 * ajout dans le dico une association sd-url si cette association n'est pas encore presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si cette association n'etait pas encore presente dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String url){
		if (!mapSite.containsKey(sd)) {
			LinkedList<String> listeLiens = new LinkedList<>() ;
			listeLiens.add(url);
			mapSite.put(sd, listeLiens);
			return true;
		} else {
			if (!mapSite.get(sd).contains(url)) {
				mapSite.get(sd).add(url);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * verifie si la structure de donnees se trouve dans le dico
	 * cette structure de donnees doit posseder au moins une url!
	 * @param sd la structure de données
	 * @return true si sd est present, false sinon
	 */
	public boolean contient(String sd){
		return mapSite.containsKey(sd) && !mapSite.get(sd).isEmpty();
	}
	
	
	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		if (mapSite.get(sd) == null) return ("[]");
		return ""+mapSite.get(sd);
	}
	
	/**
	 * supprime dans le dico l'association sd-url si celle-ci est presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si l'association etait presente dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String url){
		if (mapSite.containsKey(sd)) {
			if (mapSite.get(sd).contains(url)) {
				mapSite.get(sd).remove(url);
				return true;
			}
		}
		return false;
	}
		
}
