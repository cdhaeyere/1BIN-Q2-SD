import java.util.Iterator;
import java.util.LinkedList;

public class Exposant {

    private String nom;
    private String email;
    private String telephone;

    private LinkedList<Emplacement> emplacements;

    public Exposant(String nom, String email, String telephone) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        emplacements = new LinkedList<Emplacement>();
    }

    public String getNom() {
        return nom;
    }

    public Iterator<Emplacement> getEmplacements() {
        return emplacements.iterator();
    }

    @Override
    public String toString() {
        return "Exposant{" + "nom=" + nom + ", email=" + email + ", telephone=" + telephone + ", emplacements=" + emplacements + '}';
    }

    public boolean addEmplacement(Emplacement emplacement) {
        return emplacements.add(emplacement);
    }

    public boolean removeEmplacement(Emplacement emplacement) {
        return emplacements.remove(emplacement);
    }

    public boolean hasEmplacement(Emplacement emplacement) {
        return emplacements.contains(emplacement);
    }

    public int nombreEmplacements() {
        return emplacements.size();
    }
}
