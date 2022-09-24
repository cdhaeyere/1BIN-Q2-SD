/**
 * @author Corentin D'haeyere
 */
public class Bal2 {

    private NoeudEtudiant tete;
    private NoeudEtudiant derM;
    private NoeudEtudiant derF;

    /**
     * construit un bal avec aucun participant
     */
    public Bal2(){
        NoeudEtudiant newNode = new NoeudEtudiant();
        NoeudEtudiant newNode2 = new NoeudEtudiant();
        tete = newNode;
        derM = tete;
        derF = newNode2;
        derM.suivant = derF;
    }

    public String toString(){
        String aRenvoyer = "";
        NoeudEtudiant baladeur = tete;
        while(baladeur!=null){
            if(baladeur.etudiant!=null) {
                aRenvoyer += " " + baladeur.etudiant.getPrenom();
            }
            baladeur = baladeur.suivant;
        }
        return aRenvoyer;
    }

    /**
     * ajoute l etudiant dans la liste en tenant compte de l'ordre prevu
     * @param etudiant l etudiant a ajouter
     * @throws IllegalArgumentException si l etudiant est null
     */
    public void ajouterEtudiant(Etudiant etudiant){
        if(etudiant==null) {
            throw new IllegalArgumentException("etudiant null");
        }
        NoeudEtudiant newNode;
        if (etudiant.getSexe() == 'M') {
            newNode = new NoeudEtudiant(etudiant,derM.suivant);
            derM.suivant =newNode;
            derM = newNode;
        } else {
            newNode = new NoeudEtudiant(etudiant);
            derF.suivant = newNode;
            derF = derF.suivant;
        }
    }

    // classe interne
    private class NoeudEtudiant{

        private Etudiant etudiant;
        private NoeudEtudiant suivant;

        public NoeudEtudiant(){
            this.etudiant = null;
            this.suivant = null;
        }

        public NoeudEtudiant(Etudiant etudiant){
            this.etudiant = etudiant;
            this.suivant = null;
        }

        public NoeudEtudiant(Etudiant etudiant, NoeudEtudiant suivant){
            this.etudiant = etudiant;
            this.suivant = suivant;
        }

    }
}


