// implementation du vecteur en utilisant un tableau de taille variable redimensionnable
/**
 * @author Corentin D'haeyere
 */
public class VecteurImpl<E> implements Vecteur<E> {

    private E[] table;
    private int taille;    //taille logique
    
    public VecteurImpl(int capacite) {
        if (capacite <= 0)
            throw new IllegalArgumentException("la taille physique ne peut etre negative ou nulle");

        this.table = (E[]) new Object[capacite];
        this.taille = 0;
    }

    public VecteurImpl() {
        this(16);
    }

    public boolean estVide() {
        return taille == 0;
    }

    // taille logique
    public int taille() {
        return taille;
    }

    public String toString() {
        String aRenvoyer = "";
        if (taille > 0) {
            aRenvoyer += table[0];
            for (int i = 1; i < taille; i++) {
                aRenvoyer += " " + table[i];
            }
        }
        return aRenvoyer;
    }


    public E element(int rang) throws VecteurOutException {
        if (rang < 0 || rang >= taille) throw new VecteurOutException("rang invalide");
        return table[rang];
    }


    private void agrandirTable() {
        E[] temp = (E[]) new Object[table.length * 2];
        for (int i = 0; i < taille; i++) {
            temp[i] = table[i];
        }
        table = temp;
    }

    public void insere(int rang, E element) throws VecteurOutException {
        if (rang < 0 || rang > taille) throw new VecteurOutException("rang invalide");
        if (taille == table.length) {
            agrandirTable();
        }
        for (int i = taille - 1; i >= rang; i--) {
            table[i + 1] = table[i];
        }
        taille++;
        table[rang] = element;
    }


    public void ajoute(E element) {
        insere(taille, element);
    }


    public E remplace(int rang, E element) throws VecteurOutException {
        if (rang < 0 || rang >= taille) throw new VecteurOutException("rang invalide");
        E oARenvoyer = table[rang];
        table[rang] = element;
        return oARenvoyer;
    }


    public E supprime(int rang) throws VecteurOutException {
        if (rang < 0 || rang >= taille) throw new VecteurOutException("rang invalide");
        E oARenvoyer = table[rang];
        for (int i = rang; i < taille - 1; i++) {
            table[i] = table[i + 1];
        }
        taille--;
        return oARenvoyer;
    }
}
