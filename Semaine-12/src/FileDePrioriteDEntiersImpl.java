
public class FileDePrioriteDEntiersImpl implements FileDePrioriteDEntiers {
	
	private int [] arbre ; 
	private int taille; 	//taille logique 

	
	public FileDePrioriteDEntiersImpl(int capacite) {
		arbre = new int[capacite];
		taille=0;
	}
	
	
	public FileDePrioriteDEntiersImpl() {
		this(4);
	}

	@Override
	public int taille() {	
		return taille;
	}
	

	@Override
	public boolean estVide() {
		return taille==0;
	}

	
	private int indiceParent(int i) { 
		return ((i-1)/2); 
	} 
	
	
	private int indiceGauche(int i) { 
		return (2*i+1); 
	} 
	
	
	private int indiceDroit(int i) { 
		return (2*i + 2); 
	} 
	
	
	private void pushUp(int i){
		if (arbre[indiceParent(i)]<arbre[i]){
			int temp = arbre[i];
			arbre[i]=arbre[indiceParent(i)];
			arbre[indiceParent(i)]=temp;
			pushUp(indiceParent(i));
		}
	}

	@Override
	public void insere(int entier) {
		// agrandissement de la table si celle-ci est pleine
		if(arbre.length==taille){
			int[] arbreTemp = new int[arbre.length*2];
			for (int i = 0; i < arbre.length; i++) {
				arbreTemp[i]=arbre[i];
			}
			arbre = arbreTemp;
		}
		// on place l'entier en fin de table (taille logique)
		arbre[taille]=entier;
		// on reorganise l'arbre pour qu'il soit complet
		// appel de la methode recursive pushUp() a partir du nouvel entier insere
		pushUp(taille);
		// ne pas oublier d'augmenter la taille logique de la table
		taille++;

	}
	

	private void pushDown(int i){

		// feuille

		// une feuille n'a pas de fils, donc il n'y a pas de permutation a envisager
		// c'est termine : cas bete 1
		// l'arbre est complet, donc si pas de fils gauche, d'office il n'a pas de fils droit
		if(indiceGauche(i)>=taille)
			return;


		// noeud interne avec uniquement fils droit
		// l'arbre est complet, donc ce n'est pas possible


		// noeud interne avec uniquement fils gauche

		// Ce cas ne doit pas etre prevu si le pushDown est uniquement utilise par supprimeMax()
		// L'"ancien" fils droit est d'office <= que son parent
		/*
		if(indiceDroit(i)>=taille){
			if(arbre[i]>=arbre[indiceGauche(i)])
				return;
			int temp = arbre[i];
			arbre[i]=arbre[indiceGauche(i)];
			arbre[indiceGauche(i)]=temp;
			return;
		}
		*/


		// noeud interne avec 2 fils

		// Si le parent est plus grand que ses 2 fils, il n'y a pas de permutation a faire
		// L'arbre est complet
		// C'est termine : cas bete 2
		if(arbre[i]>=arbre[indiceGauche(i)]&&arbre[i]>=arbre[indiceDroit(i)])
			return;

		// Au moins un des 2 fils est plus grand
		// Pour que l'arbre soit complet, le plus grand doit devenir le parent
		// Il faut faire une permutation et un appel recursif
		// Recherche du fils le plus grand
		// Si c'est le gauche :
		if(arbre[indiceGauche(i)]>=arbre[indiceDroit(i)]){
			int temp = arbre[i];
			arbre[i]=arbre[indiceGauche(i)];
			arbre[indiceGauche(i)]=temp;
			pushDown(indiceGauche(i));
			return;
		}
		// Si c'est le droit :
		int temp = arbre[i];
		arbre[i]=arbre[indiceDroit(i)];
		arbre[indiceDroit(i)]=temp;
		pushDown(indiceDroit(i));
	}
	
	@Override
	public int supprimeMax(){
		if (estVide()) return -1;
		int max = arbre[0];
		arbre[0]=arbre[taille-1];
		taille--;
		pushDown(0);
		return max;
	}
	
	
	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS
	public String toString(){
		String aRenvoyer = "";
		for (int i = 0; i < taille; i++) {
			aRenvoyer+=" "+arbre[i];
		}
		return aRenvoyer;
	}

}
