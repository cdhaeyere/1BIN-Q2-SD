import java.util.Scanner;

/**
 * @author Corentin D'haeyere
 */

public class GestionnaireEntrepot {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] NOMS_METHODES = {"attribuer un hangar", "lister les hangars d'une société", "liberer un hangar", "ajouter un véhicule à une société", "vérifier la plaque d'immatriculation"};

    public static Entrepot entrepot = new Entrepot(5);
    public static Societe societe = new Societe(0, "Microsoft");

    public static void main(String[] args) {
        System.out.println("**************************************");
        System.out.println("Programme Gestionnaire d'Entrepot");
        System.out.println("**************************************");

        int choix = 0;
        boolean testOK;
        while (true) {
            for (int i = 0; i < NOMS_METHODES.length; i++) {
                System.out.println((i + 1) + " -> Tester la méthode '" + NOMS_METHODES[i] + "'");
            }
            choix = scanner.nextInt();
            switch (choix) {
                case 1 -> testOK = testAttribuer();
                case 2 -> testOK = testLister();
                case 3 -> testOK = testLiberer();
            }
        }
    }

    private static boolean testAttribuer() {
        if (!entrepot.checkHangarDispo()) System.out.println("Il n'y a plus de hangar libre");
        else {
            System.out.println("Il y a au moins 1 hangar de libre ! " );
            System.out.println("Entrez un numero de societe");
            int numero = scanner.nextInt();
            System.out.println("Entrez le nom de la societe");
            String nom = scanner.next();
            System.out.println("La societe numero "+numero+" s'est vue attribuer le hangar numero "+entrepot.attribuerHangar(numero, nom));
            System.out.println("Les hangars de la societe  " + nom +" : "+entrepot.listeHangars(numero));
        }
        return true;
    }

    private static boolean testLister() {
        System.out.println("Entrez un numero de societe");
        int numero = scanner.nextInt();
        System.out.println("Entrez le nom de la societe");
        String nom = scanner.next();
        System.out.println("Liste du/des hangar(s) : "+entrepot.listeHangars(numero));
        return true;
    }

    private static boolean testLiberer() {
        System.out.println("Entrez le numero du hangar a supprimer");
        int numHangar = scanner.nextInt();
        System.out.println("Hangar libéré ? : "+entrepot.liberer(numHangar));
        return true;
    }
}
