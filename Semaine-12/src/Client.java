public class Client {

    private String nom;
    private int priorite;

    public Client(String nom, int priorite) {
        this.nom = nom;
        this.priorite = priorite;
    }

    public String getNom() {
        return nom;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }
}
