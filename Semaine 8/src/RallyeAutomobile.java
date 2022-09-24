import java.util.ArrayList;
import java.util.List;

public class RallyeAutomobile {

    private ListeSDImpl<String> pilotesCourse;
    private ListeSDImpl<String> pilotesArrives;
    private ListeSDImpl<String> pilotesDisqualifies;

    public RallyeAutomobile(String[] lesPilotes) {
        pilotesCourse = new ListeSDImpl<>();
        pilotesArrives = new ListeSDImpl<>();
        pilotesDisqualifies = new ListeSDImpl<>();
        for(int i = 0 ; i < lesPilotes.length; i++) {
            pilotesCourse.insererEnQueue(lesPilotes[i]);
        }
    }

    public String donnerPiloteEnTete() {
        return pilotesCourse.premier();
    }

    public boolean supprimer(String pilote) {
        if (pilote == null) throw new IllegalArgumentException("Merci de renseigner un nom de pilote valide !");
        if (!pilotesCourse.contient(pilote)) return false;

        pilotesCourse.supprimer(pilote);
        return true;
    }

    public void afficherPilotesEnCourse() {
        System.out.println(pilotesCourse.toStringAffichage());
    }

    public int donnerPositionPilote(String pilote) {
        if (pilote == null) throw new IllegalArgumentException("pilote est un string vide ! ");
        return pilotesCourse.donnerPosition(pilote);
    }

    public boolean depasserPilote(String pilote) {
        if (pilote == null) throw new IllegalArgumentException("pilote est un string vide ! ");
        pilotesCourse.permuter(pilotesCourse.donnerPrecedent(pilote), pilote);
        return true;
    }

    public boolean dejaFranchiLigneArrivee(String pilote) {
        if (pilote == null) throw new IllegalArgumentException("pilote est un string vide !");
        return pilotesArrives.contient(pilote);
    }

    public boolean estDisqualifie(String pilote) {
        if (pilote == null) throw new IllegalArgumentException("pilote est un string vide !");
        return pilotesDisqualifies.contient(pilote);
    }

    public void disqualifie(String pilote) {
        if (pilote == null) throw new IllegalArgumentException("pilote est un string vide !");
        if (!pilotesCourse.contient(pilote)) return;
        pilotesDisqualifies.insererEnQueue(pilote);
        pilotesCourse.supprimer(pilote);
    }

    public String franchirLigneArrivee(String pilote) {
        if (!dejaFranchiLigneArrivee(pilote)) {
            pilotesArrives.insererEnQueue(pilote);
            pilotesCourse.supprimer(pilote);
        }
        return pilote;
    }

    public boolean estTerminee() {
        return pilotesCourse.estVide();
    }

    public String afficherResultat() {
        StringBuilder sb = new StringBuilder();
        sb.append("La course est terminée !\n");
        sb.append("Voici le classement final :\n");
        int numero = 1;
        for (String pilote : pilotesArrives) {
            sb.append(numero).append(" : ").append(pilote).append("\n");
        }
        return sb.toString();
    }
}
