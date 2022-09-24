/**
 * @author Corentin D'haeyere
 */
public class Connexion {
   
	Ensemble<Login> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGIN
	
	public Connexion(){
		ensembleDesConnectes = new EnsembleTableBooleens(256);
	}

	public int nombreDeConnectes(){
		return ensembleDesConnectes.taille();
	}
	
	// ajoute le login s'il n'est pas encore connecte
	public boolean connecter(Login login){
		if(ensembleDesConnectes.contient(login))return false;
		ensembleDesConnectes.ajouter(login);
		return true;
	}
	
	// retire le login s'il est connecte
	public boolean deconnecter(Login login){
		if(!ensembleDesConnectes.contient(login))return false;
		ensembleDesConnectes.enlever(login);
		return true;
	}

	public boolean estConnecte(Login login){
		return ensembleDesConnectes.contient(login);
	}
}

