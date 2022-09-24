/**
 * @author Corentin D'haeyere
 */
public class VecteurDeCaracteresImpl implements VecteurDeCaracteres {
	
	private static final int CAPACITE_MIN = 4;		// taille physique de depart pour le constructeur sans parametre
	private char[] table;
	private int taille;

	/**
	 * construit un vecteur avec 0 caractere mais pouvant contenir jusqu'a CAPACITE_MIN caracteres
	 */
	public VecteurDeCaracteresImpl() {
		this.table=new char[CAPACITE_MIN];
		this.taille=0;
	}

	/**
	 * construit un vecteur avec 0 caractere mais pouvant contenir jusqu'a capacite caracteres
	 * @param capacite capacite de depart
	 * @throws IllegalArgumentException si la capacite de depart est negative ou nulle
	 */
	public VecteurDeCaracteresImpl(int capacite) {
		if(capacite<=0){
			throw new IllegalArgumentException("la capacite ne peut etre negative ou nulle");
		}
		this.table=new char[capacite];
		this.taille=0;
	}
	
	// A ne pas modifier!!! Va servir pour les tests
	/**
	 * constructeur par recopie
	 * @param capacite taille physique du vecteur
	 * @param tableARecopier table contenant les caracteres a recopier
	 * @throws IllegalArgumentException si la capacite de depart est negative ou nulle
	 *                               ou si la table a recopier est null 
	 *                               ou si taille physique < taille logique 
	 */
	public VecteurDeCaracteresImpl(int capacite,char[]tableARecopier){
		if(capacite<=0)
			throw new IllegalArgumentException("capacite negative ou nulle");
		if(tableARecopier==null)
			throw new IllegalArgumentException("table a recopier null");
		if(tableARecopier.length>capacite)
			throw new IllegalArgumentException("taille physique < taille logique");
		this.table=new char[capacite];
		this.taille=tableARecopier.length;
		for (int i = 0; i < tableARecopier.length; i++) {
			table[i]=tableARecopier[i];
		}
	}
	
	// A ne pas modifier!!! Va servir pour les tests
	public String toString(){
		String aRenvoyer="";
		if(taille>0){
			aRenvoyer+="'"+table[0]+"'";
			for (int i = 1; i < taille; i++) {
				aRenvoyer+=" "+"'"+ table[i]+"'";
			}
		}
		return aRenvoyer;
	}
	
	// taille logique de la table
	public int taille() {
		return taille;
	}
	
	
	public boolean estVide() {
		return (taille==0);
	}

	
	public char element(int rang) throws VecteurOutException {
		if (rang < 0 || rang >= taille) throw new VecteurOutException();
		return table[rang];
	} 
	
	public void insere(int rang, char caractere) throws VecteurOutException {
		if (rang < 0 || rang > taille()) throw new VecteurOutException();
		if (taille() == table.length) {
			char[] tTemp = new char[table.length*2];
			for (int i = 0; i < table.length; i++) {
				tTemp[i] = table[i];
			}
			table = tTemp;
		}
		for (int i = taille()-1; i >= rang; i--) {
			table[i+1] = table[i];
		}
		table[rang] = caractere;
		taille++;
	}	
	
	public void ajoute(char caractere) {
		insere(taille(), caractere);
	}

	public char remplace(int rang, char caractere)throws VecteurOutException {
		if (rang < 0 || rang >= taille) throw new VecteurOutException();
		char temp = table[rang];
		table[rang] = caractere;
		return temp;
	}

	public char supprime(int rang) throws VecteurOutException {
		if (rang < 0 || rang >= taille) throw new VecteurOutException();
		char temp = table[rang];
		for (int i = rang; i < taille()-1; i++) {
			table[i] = table[i+1];
		}
		taille--;
		return temp;
	}

}
