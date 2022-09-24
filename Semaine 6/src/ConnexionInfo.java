/**
 * @author Corentin D'haeyere
 */
public class ConnexionInfo {
   
 	Ensemble<LoginInfo> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
 	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGININFO
 	
 	public ConnexionInfo(){
		ensembleDesConnectes = new EnsembleTableBooleens(139);
	}
 	
 	public	int nombreDeConnectes(){
		return ensembleDesConnectes.taille();
	}

 	// ajoute le loginInfo s'il n'est pas encore connecte
	public boolean connecter(LoginInfo loginInfo){
		if(estConnecte(loginInfo))return false;
		return ensembleDesConnectes.ajouter(loginInfo);
	}

	// retire le loginInfo s'il est connecte
	public boolean deconnecter(LoginInfo loginInfo){
		if(!estConnecte(loginInfo))return false;
		return ensembleDesConnectes.enlever(loginInfo);
	}

	public boolean estConnecte(LoginInfo loginInfo){
		return ensembleDesConnectes.contient(loginInfo);
	}
}