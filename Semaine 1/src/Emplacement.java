/**
 * @author Corentin D'haeyere
 */
public class Emplacement {

    private int numero;
    private String oeuvre;

    public Emplacement(int numero, String oeuvre) {
        super();
        this.numero = numero;
        this.oeuvre = oeuvre;
    }

    public int getNumero() {
        return numero;
    }

    public String getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(String oeuvre) {
        this.oeuvre = oeuvre;
    }

    @Override
    public String toString() {
        return "Emplacement [numero=" + numero + ", oeuvre=" + oeuvre + "]";
    }
}
