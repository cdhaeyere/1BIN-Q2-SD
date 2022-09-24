/**
 * @author Corentin D'haeyere
 */
public class Etudiant {

    private String nom;
    private String prenom;
    private char sexe; 			// 'M': masculin, 'F': feminin


    public Etudiant(String nom, String prenom, char sexe) {
        super();
        if(nom == null||prenom == null)
            throw new IllegalArgumentException("parametre null");
        if(sexe!='F'&&sexe!='M')
            throw new IllegalArgumentException("sexe invalide");
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
    }

    public Etudiant(String prenom, char sexe) {
        this("",prenom,sexe);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public char getSexe() {
        return sexe;
    }

    @Override
    public String toString() {
        return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe
                + "]";
    }

}
