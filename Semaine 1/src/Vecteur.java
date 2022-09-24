/**
 * @author Corentin D'haeyere
 */
public interface Vecteur<E> {
    /**
     * verifie si le vecteur est vide
     * @return true si le vecteur est vide, false sinon
     */
    boolean estVide();


    /**
     * renvoie la taille logique
     * @return le nombre d'elements contenu dans le vecteur
     */
    int taille();


    String toString();


    /**
     * renvoie l'element qui se trouve au rang passe en parametre
     * @param rang
     * @return un element
     * @throws VecteurOutException s'il n'y a pas d'element correspondant a ce rang
     */
    E element(int rang)throws VecteurOutException;


    /**
     * insere un element au rang passe en parametre
     * l'ordre des elements doit etre conserve --> decalages!!!
     * il ne peut y avoir des trous
     * @param rang
     * @param element l'element a inserer
     * @throws VecteurOutException si ce n'est pas possible de mettre un element a ce rang
     */
    void insere(int rang, E element)throws VecteurOutException;


    /**
     * ajoute l'element a la fin du vecteur
     * @param element
     */
    void ajoute(E element);


    /**
     * remplace un element par l'element passe en parametre
     * @param rang le rang de l'element a remplacer
     * @param element le nouvel element
     * @return l'element qui a ete remplace
     * @throws VecteurOutException s'il n'y a pas d'element correspondant a ce rang
     */
    E remplace(int rang, E element)throws VecteurOutException;


    /**
     * supprime l'element au rang passe en parametre
     * l'ordre des elements doit etre conserve --> decalages!!!
     * il ne peut y avoir des trous
     * @param rang
     * @return l'element qui a ete supprime
     * @throws VecteurOutException s'il n'y a pas d'element correspondant a ce rang
     */
    E supprime(int rang)throws VecteurOutException;

}
