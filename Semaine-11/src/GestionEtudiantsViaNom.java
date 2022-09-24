import java.util.Comparator;
import java.util.TreeSet;

public class GestionEtudiantsViaNom {

    private static final MonScanner           scanner          = new MonScanner("InputA.txt");
    private static final ComparateurNom comparateur      = new ComparateurNom();
    private static final TreeSet<Etudiant>    ensembleStudents = new TreeSet<>(comparateur);

    public static void main(String[] args) {
        System.out.println("*********************");
        System.out.println("Gestion des etudiants");
        System.out.println("*********************");
        int choix = 0;
        do {
            System.out.println();
            System.out.println("1 -> ajouter un etudiant");
            System.out.println("2 -> afficher tous les etudiants");

            System.out.println();
            System.out.print("Entrez votre choix : ");

            choix = scanner.nextInt();
            switch (choix) {
                case 1 -> ajout();
                case 2 -> tous();
                default -> {
                }
            }
        } while (choix >= 1 && choix <= 2 );


    }

    private static void tous() {
        System.out.println();
        for (Etudiant etudiant : ensembleStudents) {
            System.out.println(etudiant.getNumeroMatricule()+ " " +etudiant.getNom() + " " +etudiant.getPrenom());
        }
        System.out.println();
    }

    private static void ajout() {
        System.out.println();
        System.out.print("Entrez le numero de matricule : ");
        int numero = scanner.nextInt();
        System.out.print("Entrez le nom : ");
        String nom = scanner.next();
        System.out.print("Entrez le prenom : ");
        String prenom = scanner.next();
        ensembleStudents.add(new Etudiant(numero,nom,prenom));
    }

    private static class ComparateurNom implements Comparator<Etudiant> {

        @Override
        public int compare(Etudiant etudiant1, Etudiant etudiant2) {
            if (etudiant1.getNom().compareTo(etudiant2.getNom()) == 0) {
                return etudiant1.getPrenom().compareTo(etudiant2.getPrenom());
            }
            return etudiant1.getNom().compareTo(etudiant2.getNom());
        }
    }
}
