import java.util.Scanner;

public class GestionRallyeAutomobile {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String[] NOMS_METHODE = {"Afficher toute la course","Afficher le pilote en tête", "Enregistrer un dépassement", "Disqualifier un pilote", "Donner la position d'un pilote","Faire franchir la ligne d’arrivée au pilote de tête"};

    private static String[] pilotesCourse;
    private static RallyeAutomobile rallyeAutomobile;

    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println(" Programme de gestion d'un Rallye Automobile");
        System.out.println("*************************************************");
        System.out.println("Entrer le nombre de pilotes : ");
        int nombrePilotes = scanner.nextInt();
        if(nombrePilotes <= 1) {
            System.out.println("Il faut au moins deux pilotes pour commencer le rallye.");
            return;
        }
        pilotesCourse = new String[nombrePilotes];
        for (int i = 1 ; i <= nombrePilotes ; i++) {
            System.out.println("Entrez le nom du pilote numero " + i + " :");
            String nom = scanner.next();
            pilotesCourse[i-1] = nom;
        }
        rallyeAutomobile = new RallyeAutomobile(pilotesCourse);
        int choix = 0;
        while (true) {
            for (int i = 0; i < NOMS_METHODE.length; i++) {
                System.out.println((i + 1) + "   ==>   " + NOMS_METHODE[i] + " ? ");
            }
            System.out.println("");
            System.out.println("    Votre choix :");
            choix = scanner.nextInt();
            boolean testOK;
            switch (choix) {
                case 1 :
                    testOK = testAfficherCourse();
                    break;
                case 2 :
                    testOK = testPiloteDeTete();
                    break;
                case 3:
                    testOK = testEnregistrerDepassement();
                    break;
                case 4:
                    testOK = testDisqualifierPilote();
                    break;
                case 5:
                    testOK = testPositionPilote();
                    break;
                case 6:
                    testOK = testFaireFranchirLigneArrivee();
                    break;
                default:
                    return;
            }
        }
    }

    private static boolean testAfficherCourse() {
        System.out.println("  La liste des pilotes toujours en course : ");
        System.out.println("");
        rallyeAutomobile.afficherPilotesEnCourse();
        return true;
    }

    private static boolean testPiloteDeTete() {
        System.out.println("  Le pilote en première position est " + rallyeAutomobile.donnerPiloteEnTete());
        return true;
    }

    private static boolean testEnregistrerDepassement() {
        System.out.println("Entrez le nom du pilote qui dépasse : ");
        String nom = scanner.next();
        if (rallyeAutomobile.donnerPositionPilote(nom) == -1) {
            if (rallyeAutomobile.estDisqualifie(nom)) {
                System.out.println("Ce pilote ne peut être avancé car il est disqualifié");
                return false;
            }
            if (rallyeAutomobile.dejaFranchiLigneArrivee(nom)) {
                System.out.println("Ce pilote ne peut être avancé car il a déjà franchi la ligne d'arrivée.");
                return false;
            }
            System.out.println("Ce pilote ne peut être avancé car il ne fait pas partie des pilotes inscrits.");
            return true;
        }
        if (rallyeAutomobile.donnerPiloteEnTete().equals(nom)) {
            System.out.println("Ce pilote ne peut être avancé car il est en tête.");
            return true;
        }
        rallyeAutomobile.depasserPilote(nom);
        System.out.println("Ce pilote a été avancé");
        return true;
    }

    private static boolean testDisqualifierPilote() {
        System.out.println("Entrez le nom du pilote à disqualifier : ");
        String nom = scanner.next();
        if (rallyeAutomobile.estDisqualifie(nom)) {
            System.out.println("Ce pilote ne peut être disqualifié, car il l'est déjà.");
            return false;
        }
        if (rallyeAutomobile.donnerPositionPilote(nom) == -1) {
            System.out.println("Ce pilote n'est pas dans la course.");
            return false;
        }
        rallyeAutomobile.disqualifie(nom);
        System.out.println("Ce pilote a été disqualifié.");
        if (rallyeAutomobile.estTerminee()) {
            System.out.println(rallyeAutomobile.afficherResultat());
            System.exit(0);
        }
        return true;
    }

    private static boolean testPositionPilote() {
        System.out.println("Entrez le nom du pilote dont vous voulez connaitre la position : ");
        String nom = scanner.next();
        if (rallyeAutomobile.donnerPositionPilote(nom) == -1) {
            if (rallyeAutomobile.dejaFranchiLigneArrivee(nom)) {
                System.out.println("Ce pilote n'est plus en course car il a déjà franchi la ligne d'arrivée");
                return false;
            }
            System.out.println("Ce pilote n'existe pas.");
            return false;
        }
        System.out.println("Ce pilote se trouve en position " + rallyeAutomobile.donnerPositionPilote(nom));
        return true;
    }

    private static boolean testFaireFranchirLigneArrivee() {
        System.out.println(rallyeAutomobile.franchirLigneArrivee(rallyeAutomobile.donnerPiloteEnTete()) + " vient de franchir la ligne d'arrivée.");
        if (rallyeAutomobile.estTerminee()) {
            System.out.println(rallyeAutomobile.afficherResultat());
            System.exit(0);
        }
        return true;
    }
}
