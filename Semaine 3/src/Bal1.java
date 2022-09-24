/**
 * @author Corentin D'haeyere
 */
public class Bal1 {

    private NoeudEtudiant tete;
    private NoeudEtudiant derM;
    private NoeudEtudiant derF;

    /**
     * construit un bal "vide", la liste des etudiants est vide
     */
    public Bal1(){
        tete = null;
        derM = null;
        derF = null;
    }

    public String toString(){
        String aRenvoyer = "";
        NoeudEtudiant baladeur = tete;
        while(baladeur!=null){
            aRenvoyer+=" "+baladeur.etudiant.getPrenom();
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
        if(etudiant==null)
            throw new IllegalArgumentException("etudiant null");
        NoeudEtudiant nouveauNoeud = new NoeudEtudiant(etudiant);
        switch (etudiant.getSexe()) {
            case 'M':
                if (tete == null) {
                    tete = nouveauNoeud;
                    derM = nouveauNoeud;
                    break;
                }
                if (tete.etudiant.getSexe() == 'M' && derM.suivant == null) {
                    derM.suivant = nouveauNoeud;
                    derM = nouveauNoeud;
                    break;
                }
                if (tete.etudiant.getSexe() == 'F') {
                    nouveauNoeud.suivant = tete;
                    tete = nouveauNoeud;
                    derM = nouveauNoeud;
                    break;
                }
                if (tete.etudiant.getSexe() == 'M' && derM.suivant.etudiant.getSexe() == 'F') {
                    nouveauNoeud.suivant = derM.suivant;
                    derM.suivant = nouveauNoeud;
                    derM = nouveauNoeud;
                    break;
                }
            case 'F':
                if (nouveauNoeud.etudiant.getSexe()=='F'){
                    if (tete==null){
                        tete = nouveauNoeud;
                        derF = nouveauNoeud;
                        break;
                    }
                    if (tete.etudiant.getSexe()=='M' && derF==null){
                        derM.suivant = nouveauNoeud;
                        derF = nouveauNoeud;
                        break;
                    }
                    derF.suivant = nouveauNoeud;
                    derF = nouveauNoeud;
                    break;
                }
            default:
                break;
        }
    }

    // classe interne
    private class NoeudEtudiant{

        private Etudiant etudiant;
        private NoeudEtudiant suivant;

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
