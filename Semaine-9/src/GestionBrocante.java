import java.util.Iterator;

public class GestionBrocante {
	
	private static MonScanner scanner = new MonScanner("lancement.txt");
	private static Brocante brocante;

	public static void main(String[] args) {	
		
		System.out.println("**********************");
		System.out.println("gestion d'une brocante");
		System.out.println("**********************");
	    System.out.println();
		System.out.println("configuration de la brocante");
		System.out.println("----------------------------");
		System.out.print("Entrez le nombre d'emplacements : ");
		int nombreEmplacements = scanner.nextInt();
		scanner.nextLine();
		char[] tableEmplacements = new char[nombreEmplacements];
		for (int i = 1; i <= nombreEmplacements; i++) {
			System.out.print("Type de l'emplacement n°" + i + ": ");
			char type = scanner.next().charAt(0);
			scanner.nextLine();
			tableEmplacements[i-1] = type;
		}
		System.out.print("Entrez le nombre de riverains : ");
		int nombreRiverains = scanner.nextInt();
		scanner.nextLine();
		String[] tableRiverains = new String[nombreRiverains];
		for (int i = 0; i < tableRiverains.length; i++) {
			System.out.print("Entrez le nom du riverain "+ (i+1) + ": ");
			tableRiverains[i] = scanner.nextLine();
		}
		brocante = new Brocante(tableEmplacements, tableRiverains);
		System.out.println();
		
		
		System.out.println("Phase 1");
		System.out.println("-------");
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> reserver un emplacement");
			System.out.println("2 -> afficher la brocante");
			System.out.println("3 -> consuler un exposant via son nom");
			System.out.println("4 -> lister tous les exposants");
			System.out.println("5 -> liberer un emplacement");
			System.out.println("6 -> ajouter un emplacement");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
				case 1:
					reserverPhase1();
					break;
				case 2:
					afficherTout();
					break;
				case 3:
					consulterExposant();
					break;
				case 4:
					listerExposants();
					break;
				case 5:
					libererEmplacement();
					break;
				case 6:
					ajouterEmplacement();
					break;
			}

		} while (choix >= 1 && choix <= 6);
		
		brocante.changerPhase();
		System.out.println();
		System.out.println();
		
		System.out.println("Phase 2");
		System.out.println("-------");
		choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> reserver un emplacement");
			System.out.println("2 -> afficher la brocante");
			System.out.println("3 -> consuler un exposant via son nom");
			System.out.println("4 -> lister tous les exposants");
			System.out.println("5 -> liberer un emplacement");
			System.out.println("6 -> ajouter un emplacement");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
				case 1:
					reserverPhase2();
					break;
				case 2:
					afficherTout();
					break;
				case 3:
					consulterExposant();
					break;
				case 4:
					listerExposants();
					break;
				case 5:
					libererEmplacement();
					break;
				case 6:
					ajouterEmplacement();
					break;
			}

		} while (choix >= 1 && choix <= 6);
		
		System.out.println("Fin de la brocante!");
	}

	private static void reserverPhase1() {
		System.out.print("Entrez le nom du riverain : ");
		String nom = scanner.nextLine();
		if (!brocante.estUnRiverain(nom)) {
			System.out.println("Le nom renseigné n'est pas celui d'un riverain !");
			return;
		}
		System.out.print("Entrez le numero de l'emplacement : ");
		int numero = scanner.nextInt();
		scanner.nextLine();
		if (!brocante.estLibre(numero)) {
			System.out.println("L'emplacement n'est pas libre !");
			return;
		}
		Exposant exposant = brocante.getExposant(nom);
		if (exposant == null) {
			System.out.println("Entrez l'adresse email du riverain : ");
			String email = scanner.nextLine();
			System.out.println("Entrez le numero de telephone du riverain : ");
			String telephone = scanner.nextLine();
			exposant = new Exposant(nom, email, telephone);
		}
		if (brocante.reserver(exposant, numero)) {
			System.out.println("Reservation effectuee!");
		} else {
			System.out.println("Reservation impossible!");
		}
	}

	private static void reserverPhase2() {
		System.out.println("Entrez le type d'emplacement souhaité : ");
		char type = scanner.nextLine().charAt(0);
		try {
			if (!brocante.emplacementLibre(type)) {
				System.out.println("Il n'y a plus d'emplacement libre !");
				return;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Type d'emplacement invalide !");
			return;
		}
		System.out.println("Entrez le nom : ");
		String nom = scanner.nextLine();
		Exposant exposant = brocante.getExposant(nom);
		if (exposant == null) {
			System.out.println("Entrez l'adresse email : ");
			String email = scanner.nextLine();
			System.out.println("Entrez le numero de telephone : ");
			String telephone = scanner.nextLine();
			exposant = new Exposant(nom, email, telephone);
		}
		int emplacementReserve = brocante.attribuerAutomatiquementEmplacement(type, exposant);
		if (emplacementReserve != -1) {
			System.out.println("L'emplacement " + emplacementReserve + " a été réservé pour " + exposant.getNom() + " !");
		} else {
			System.out.println("La réservation automatique n'a pas pu aboutir !");
		}
	}

	private static void afficherTout() {
		System.out.println(brocante);		
	}

	private static void consulterExposant() {
		System.out.print("Entrez le nom de l'exposant : ");
		String nom = scanner.nextLine();
		Exposant exposant = brocante.getExposant(nom);
		if (exposant == null) {
			System.out.println("L'exposant n'existe pas !");
			return;
		}
		System.out.println(exposant);
	}

	private static void listerExposants() {
		System.out.println("Liste des exposants : ");
		if (!brocante.tousLesExposants().hasNext()) {
			System.out.println("Aucun exposant n'est inscrit !");
			return;
		}
		for (Iterator<Exposant> it = brocante.tousLesExposants(); it.hasNext(); ) {
			Exposant exposant = it.next();
			System.out.println(exposant);
		}
	}

	private static void libererEmplacement() {
		System.out.print("Entrez le nom de l'exposant : ");
		String nom = scanner.nextLine();
		Exposant exposant = brocante.getExposant(nom);
		if (exposant == null) {
			System.out.println("L'exposant n'existe pas !");
			return;
		}
		System.out.print("Entrez le numero de l'emplacement : ");
		int numero = scanner.nextInt();
		scanner.nextLine();
		if (brocante.estLibre(numero)) {
			System.out.println("L'emplacement est libre !");
			return;
		}
		if (brocante.liberer(exposant, numero)) {
			System.out.println("Emplacement libere !");
		} else {
			System.out.println("Emplacement non libere, ce n'est pas votre emplacement !");
		}
	}

	public static void ajouterEmplacement() {
		System.out.println("Entrez le type d'emplacement : ");
		char type = scanner.next().charAt(0);
		scanner.nextLine();
		Emplacement emplacement = new Emplacement(brocante.getNombreEmplacements(), null, type);
		if (brocante.ajouterEmplacement(emplacement)) {
			System.out.println("Emplacement ajoute !");
		} else {
			System.out.println("Emplacement non ajoute !");
		}
	}

}
