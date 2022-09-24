public class Emplacement {

    private int      numero;
    private Exposant exposant;
    private char type;

    public Emplacement(int numero, Exposant exposant, char type) {
        this.numero = numero;
        this.exposant = null;
        this.type = type;
    }

    public int getNumero() {
        return numero;
    }

    public Exposant getExposant() {
        return exposant;
    }

    public char getType() {
        return type;
    }

    public void setExposant(Exposant exposant) {
        this.exposant = exposant;
    }

    @Override
    public String toString() {
        if (exposant == null) {
            return "Emplacement: " + numero + ", Type: " + type + ", Libre";
        }
        return "Emplacement: " + numero + ", Type: " + type + " Exposant: " + exposant.getNom();
    }
}
