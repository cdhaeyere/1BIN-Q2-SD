/**
 * @author Corentin D'haeyere
 */
public class TestConnexionInfo{

	public static void main(String[] args) throws IllegalArgumentException{

		System.out.println("********************************************");
		System.out.println("Programme Test pour la classe ConnexionInfo");
		System.out.println("********************************************");
		ConnexionInfo c = new ConnexionInfo();
		System.out.println("Test 1 : connexion de info001");
		if(!c.connecter(new LoginInfo("info001"))){
			System.out.println("Echec test 1, votre classe annonce ne pas avoir connecte info001");
			return;
		}
		if(c.nombreDeConnectes()!=1){
			System.out.println("Echec test 1, apres connexion de info001, votre classe annonce : "+ c.nombreDeConnectes()+" logins connectes!");
			return;
		}

		System.out.println("Test 2 : verifie connexion de info001");
		if(!c.estConnecte(new LoginInfo("info001"))){
			System.out.println("Echec test 2, votre classe ne trouve pas de connexion pour info001");
			return;
		}

		System.out.println("Test 3 : connexion de info001");
		if(c.connecter(new LoginInfo("info001"))){
			System.out.println("Echec test 3, votre classe annonce avoir connecte info001 alors qu'il l'est deja");
			return;
		}	
		if(c.nombreDeConnectes()!=1){
			System.out.println("Echec test 3, apres connexion du m�me login, votre classe annonce : "+ c.nombreDeConnectes()+" logins connectes!");
			return;
		}

		System.out.println("Test 4 : connexion de info137");
		c.connecter(new LoginInfo("info137"));
		if(c.nombreDeConnectes()!=2){
			System.out.println("Echec test 4, apres connexion d'un deuxieme login, votre classe annonce : "+ c.nombreDeConnectes()+" logins connectes!");
			return;
		}
		System.out.println("Test 5 : verifie connexion de info137");
		if(!c.estConnecte(new LoginInfo("info137"))){
			System.out.println("Echec test 5, votre classe ne trouve pas de connexion pour info137");
			return;
		}
		System.out.println("Test 6 : deconnexion de info137");
		if(!c.deconnecter(new LoginInfo("info137"))){
			System.out.println("Echec test 6, votre methode annonce ne pas avoir pu deconnecter un login existant : ");;
			return;
		}
		if(c.nombreDeConnectes()!=1){
			System.out.println("Echec test 6, apres deconnexion d'un des deux logins, votre classe annonce : "+ c.nombreDeConnectes()+" logins connectes!");
			return;
		}
		System.out.println("Test 7 : verifie non connexion de info137");
		if(c.estConnecte(new LoginInfo("info137"))){
			System.out.println("Echec test 7, votre classe trouve une connexion pour info137");
			return;
		}
		System.out.println("Test 8 : deconnexion de info137");
		if(c.deconnecter(new LoginInfo("info137"))){
			System.out.println("Echec test 8, votre classe annonce deconnecter un login non connecte");
			return;
		}
		if(c.nombreDeConnectes()!=1){
			System.out.println("Echec test 8, apres deconnexion d'un login non connecte, votre classe annonce : "+ c.nombreDeConnectes()+" logins connectes! Ce nombre devrait �tre egal a 1!");
			return;
		}
		System.out.println("Test 9 : Connexion de tous les employes");
		c = new ConnexionInfo();
		for (int i = 1; i <=9; i++) {
			String login = "info00"+i;
			if(!c.connecter(new LoginInfo(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		for (int i = 10; i <= 99; i++) {
			String login = "info0"+i;
			if(!c.connecter(new LoginInfo(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		for (int i = 100; i <= 137; i++) {
			String login = "info"+i;
			if(!c.connecter(new LoginInfo(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		System.out.println("Test 10 : Connexion d un nouvel employe, il a recu le login info138");
		c = new ConnexionInfo();
		c.connecter(new LoginInfo("info138"));
		
		System.out.println("Test 11 : Connexion d un nouvel employe, il a recu le login info139");
		c = new ConnexionInfo();
		c.connecter(new LoginInfo("info139"));
		System.out.println("Bravo! Tous les tests proposes ont reussi!");

	}
}

	