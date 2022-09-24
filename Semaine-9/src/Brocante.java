import java.util.*;


public class Brocante {

	private int phase = 1;

	// suivez l'implementation imposee dans l'enonce
	private List<Emplacement> emplacements;
	private HashMap<String, Integer> mapRiverains;
	private HashMap<Character, ArrayDeque<Emplacement>> mapEmplacements;
	private HashMap<String, Exposant> mapExposants;

	private List<Character> types;

	public Brocante(char[] typesEmplacement, String[] tableRiverains){
		emplacements = new ArrayList<>();
		mapRiverains = new HashMap<>();
		mapExposants = new HashMap<>();
		mapEmplacements = new HashMap<>();
		types = new ArrayList<>();
		for (int i = 0; i < typesEmplacement.length; i++) {
			Character character = typesEmplacement[i];
			if (!types.contains(character)) {
				types.add(character);
			}
			emplacements.add(new Emplacement(i, null, character));
		}
		for (String riverain : tableRiverains) {
			mapRiverains.put(riverain, 0);
		}
	}

	public boolean reserver(Exposant exposant,int numeroEmplacement){
		if (phase != 1) throw new IllegalStateException();
		if (numeroEmplacement < 0 || numeroEmplacement >= emplacements.size()) throw new IllegalArgumentException();
		if (emplacements.get(numeroEmplacement).getExposant() != null) return false;
		String nomExposant = exposant.getNom();
		if (!mapRiverains.containsKey(nomExposant)) return false;
		if (!mapExposants.containsKey(exposant.getNom())) {
			mapExposants.put(exposant.getNom(), exposant);
		}
		if (mapRiverains.get(nomExposant) >= 3) return false;
		if (!exposant.addEmplacement(emplacements.get(numeroEmplacement))) {
			System.out.println("Impossible d'ajouter l'emplacement");
			return false;
		}
		emplacements.get(numeroEmplacement).setExposant(exposant);
		Integer nombreEmplacements = nombreEmplacementsRiverain(nomExposant);
		nombreEmplacements++;
		mapRiverains.put(exposant.getNom(), nombreEmplacements);
		return true;
	}

	/**
	 * a comme effet de passer de la phase 1 a la phase 2
	 * si deja en phase 2, rien ne doit etre fait
	 */
	public void changerPhase(){
		if (phase == 1) {
			phase = 2;
			for (Emplacement emplacement : emplacements) {
				mapEmplacements.put(emplacement.getType(), new ArrayDeque<>());
				if (emplacement.getExposant() == null) {
					mapEmplacements.get(emplacement.getType()).push(emplacement);
				}
			}
		}
	}

	/**
	 * attribue automatiquement un emmplacement libre au demandeur passe en parametre
	 * @param exposant le demandeur d'un emplacement
	 * @return le numero de l'emplacement attribue ou -1 si plus d'emplacement libre
	 * @throws IllegalStateException si on n'est pas en phase 2
	 */
	public int attribuerAutomatiquementEmplacement(char type, Exposant exposant){
		if (!checkType(type)) throw new IllegalArgumentException();
		if (phase != 2) throw new IllegalStateException();
		if (mapEmplacements.isEmpty()) return -1;
		if (!mapExposants.containsKey(exposant.getNom())) {
			mapExposants.put(exposant.getNom(), exposant);
		}
		int numEmplacement = mapEmplacements.get(type).remove().getNumero();
		Emplacement emplacement = emplacements.get(numEmplacement);
		if (!exposant.addEmplacement(emplacement)) {
			System.out.println("L'emplacement n'a pas pu être ajouté!");
			return -1;
		}
		emplacement.setExposant(exposant);
		return numEmplacement;
	}

	/**
	 * renvoie, sous forme d'une chaine de caracteres, tous les numeros des emplacements et leurs eventuels occupants
	 */
	public String toString(){
		// Va servir pour debugger
		String aRenvoyer = "";
		aRenvoyer = aRenvoyer + "\ntableEmplacements" + emplacements.toString();
		aRenvoyer = aRenvoyer + "\nmapRiverains" + mapRiverains.toString();
		aRenvoyer = aRenvoyer + "\nmapExposants" + mapExposants.toString();
		if (phase == 2) {
			aRenvoyer = aRenvoyer + "\npileEmplacementsLibres" + mapEmplacements.toString();
		}
		return aRenvoyer;
		// A modifier lorsque toute l'application sera au point!
	}

	public boolean estUnRiverain(String nom) {
		return mapRiverains.containsKey(nom);
	}

	public boolean emplacementLibre(char type) {
		if (!checkType(type)) throw new IllegalArgumentException();
		return !mapEmplacements.get(type).isEmpty();
	}

	public boolean estLibre(int numero) {
		return emplacements.get(numero).getExposant() == null;
	}

	public int nombreEmplacementsRiverain(String nom) {
		return mapRiverains.get(nom);
	}

	public Exposant getExposant(String nom) {
		return mapExposants.get(nom);
	}

	public Iterator<Exposant> tousLesExposants() {
		return mapExposants.values().iterator();
	}

	public boolean liberer(Exposant exposant, int numero) {
		Emplacement emplacement = emplacements.get(numero);
		if (exposant.hasEmplacement(emplacement)) {
			if (exposant.removeEmplacement(emplacement)) {
				emplacement.setExposant(null);
				if (phase == 2) {
					mapEmplacements.get(emplacement.getType()).push(emplacement);
				}
				if (phase == 1) {
					if (mapRiverains.containsKey(exposant.getNom())) {
						int nombreEmplacements = mapRiverains.get(exposant.getNom());
						nombreEmplacements--;
						mapRiverains.put(exposant.getNom(), nombreEmplacements);
					}
				}
				if (mapExposants.get(exposant.getNom()).nombreEmplacements() == 0) {
					mapExposants.remove(exposant.getNom());
				}
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean checkType(char type) {
		return types.contains(type);
	}

	public int getNombreEmplacements() {
		return emplacements.size();
	}

	public boolean ajouterEmplacement(Emplacement emplacement) {
		if (!checkType(emplacement.getType())) return false;
		if (emplacements.add(emplacement)) {
			return true;
		}
		if (phase == 2) {
			mapEmplacements.get(emplacement.getType()).push(emplacement);
			return true;
		}
		return false;
	}
}
