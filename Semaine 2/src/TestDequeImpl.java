import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * @author Corentin D'haeyere
 */
public class TestDequeImpl {
	private final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {	
		
		System.out.println("***************************************");
		System.out.println("Programme Test pour la classe DequeImpl");
		System.out.println("***************************************");
	
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode premier()");
			System.out.println("2 -> Tester la methode dernier()");
			System.out.println("3 -> Tester la methode ajouterEnPremier()");			
			System.out.println("4 -> Tester la methode ajouterEnDernier()'");
			System.out.println("5 -> Tester la methode supprimerPremier()");
			System.out.println("6 -> Tester la methode supprimerDernier()");
			System.out.println("7 -> Tester la methode iterator()");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			System.out.println();
			System.out.println();
			switch (choix) {
			case 1:
				testPremier();
				break;
			case 2:
				testDernier();
				break;
			case 3:				
				ajouterEnPremier();
				break;
			case 4:
				ajouterEnDernier();
				break;
			case 5:
				supprimerPremier();
				break;
			case 6:
				supprimerDernier();
				break;
			case 7:
				iterer();
				break;
			default:
				break;
			}

		} while (choix >= 1 && choix <= 7);
	}
	
	
	private static void iterer() {
		System.out.println("Tests methode iterator()");
		System.out.println();
		System.out.print("Test 1 : dequeVide :");
		DequeImpl<String> dequeVide = new DequeImpl<String>();
		Iterator<String> it = dequeVide.iterator();
		try{
			if(it.hasNext()){
				System.out.println(" KO, hasNext() doit renvoyer false");
				return;
			}
		
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception lors de l'appel de la methode hasNext()!: ");
			ex.printStackTrace();
			return;
		}
		try{
			it.next();
				System.out.println("KO, il fallait une NoSuchElementException lors d'1 next()");
				return;	
		}catch (NoSuchElementException ex){
			
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception lors de l'appel de la methode next() qui n'est pas une NoSuchElementException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 2 : deque a b c :");
		String[] tabc = {"a","b","c"};
		DequeImpl<String> dequeabc = new DequeImpl<String>(tabc);
		it = dequeabc.iterator();
		if(!it.hasNext()){
			System.out.println(" KO, le 1er appel de hasNext() doit renvoyer true");
			return;
		}
		try{
			String next = it.next();
			if(!next.equals("a")){
				System.out.println("le 1er next() a renvoye : "+ next);
				return;	
			}	
		}catch (NoSuchElementException ex){
			System.out.println("KO, il a eu une  NoSuchElementException lors du 1er next()");
			return;	
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception lors du 1er next ");
			ex.printStackTrace();
			return;
		}
		
		if(!it.hasNext()){
			System.out.println(" KO, le 2�me appel de hasNext() doit renvoyer true");
			return;
		}
		try{
			String next = it.next();
			if(!next.equals("b")){
				System.out.println("le 2eme next() a renvoye : "+ next);
				return;	
			}	
		}catch (NoSuchElementException ex){
			System.out.println("KO, il a eu une  NoSuchElementException lors du 2eme next()");
			return;	
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception lors du 2eme next ");
			ex.printStackTrace();
			return;
		}
		
		if(!it.hasNext()){
			System.out.println(" KO, le 3eme appel de hasNext() doit renvoyer true");
			return;
		}
		try{
			String next = it.next();
			if(!next.equals("c")){
				System.out.println("le 3eme next() a renvoye : "+ next);
				return;	
			}	
		}catch (NoSuchElementException ex){
			System.out.println("KO, il a eu une  NoSuchElementException lors du 3eme next()");
			return;	
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception lors du 3eme next ");
			ex.printStackTrace();
			return;
		}
		
		try{
			if(it.hasNext()){
				System.out.println(" KO, hasNext() doit renvoyer apres 3 next()");
				return;
			}
		
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception lors de l'appel de la methode hasNext() apres 3 next() ");
			ex.printStackTrace();
			return;
		}
		try{
			it.next();
				System.out.println("KO, il fallait une NoSuchElementException lors du 4eme next()");
				return;	
		}catch (NoSuchElementException ex){
			
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception lors du 4eme appel de la methode next() qui n'est pas une NoSuchElementException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.println("Tous les tests ont reussi!");	
		
	}


	private static void testPremier() {
		
		System.out.println("Tests methode premier()");
		System.out.println();
		System.out.print("Test 1 : dequeVide :");
		DequeImpl<String> dequeVide = new DequeImpl<String>();
		try{
			String s = dequeVide.premier();
			if(s!=null){
				System.out.println(" KO, il fallait renvoyer null");
				return;
			}

		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : deque a b c :");
		String[] tabc = {"a","b","c"};
		DequeImpl<String> dequeabc = new DequeImpl<String>(tabc);
		try{
			String s = dequeabc.premier();
			if(!s.equals("a")){
				System.out.println(" KO : premier renvoye : "+ s);
				return;
			}
			if(!dequeabc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste a change : "+ dequeabc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	
	}
	


	private static void testDernier() {
	
		System.out.println("Tests methode dernier()");
		System.out.println();
		System.out.print("Test 1 : dequeVide :");
		DequeImpl<String> dequeVide = new DequeImpl<String>();
		try{
			String s = dequeVide.dernier();
			if(s!=null){
				System.out.println(" KO, il fallait renvoyer null");
				return;
			}

		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : deque a b c :");
		String[] tabc = {"a","b","c"};
		DequeImpl<String> dequeabc = new DequeImpl<String>(tabc);
		try{
			String s = dequeabc.dernier();
			if(!s.equals("c")){
				System.out.println(" KO : premier renvoye : "+ s);
				return;
			}
			if(!dequeabc.toString().equals(" a b c")){
				System.out.println(" KO : contenu liste a change : "+ dequeabc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	
		
	}


	private static void ajouterEnPremier() {
		System.out.println("Tests methode ajouterEnPremier()");
		System.out.println();
		System.out.print("Test 1 : dequeVide :");
		DequeImpl<String> dequeVide = new DequeImpl<String>();
		try{
			dequeVide.ajouterEnPremier("x");
			if(dequeVide.taille()!=1){
				System.out.println(" KO : l'attribut taille vaut : "+ dequeVide.taille());
				return;
			}
			if(!dequeVide.toString().equals(" x")){
				System.out.println(" KO : votre liste contient : "+ dequeVide);
				return;
			}
		
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : deque a b c :");
		String[] tabc = {"a","b","c"};
		DequeImpl<String> dequeabc = new DequeImpl<String>(tabc);
		try{
			dequeabc.ajouterEnPremier("x");
			if(dequeabc.taille()!=4){
				System.out.println(" KO : l'attribut taille vaut : "+ dequeabc.taille());
				return;
			}
			if(!dequeabc.toString().equals(" x a b c")){
				System.out.println(" KO : votre liste contient : "+ dequeabc);
				return;
			}
		}
		catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 3 : agrandissement de table");
		String[] tcde = {"c","d","e"};
		DequeImpl<String> dequecde = new DequeImpl<String>(tcde);
		dequecde.ajouterEnPremier("b");
		dequecde.ajouterEnPremier("a");
		try{
			dequecde.ajouterEnPremier("x");
			
			if(!dequecde.toString().equals(" x a b c d e")){
				System.out.println(" KO : votre liste contient : "+ dequecde);
				System.out.println("Elle aurait du contenir x a b c d e!");
				return;
			}
		}
		catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	
		
		
	}


	private static void ajouterEnDernier() {

		System.out.println("Tests methode ajouterEnDernier()");
		System.out.println();
		System.out.print("Test 1 : dequeVide :");
		DequeImpl<String> dequeVide = new DequeImpl<String>();
		try{
			dequeVide.ajouterEnDernier("x");
			if(dequeVide.taille()!=1){
				System.out.println(" KO : l'attribut taille vaut : "+ dequeVide.taille());
				return;
			}
			if(!dequeVide.toString().equals(" x")){
				System.out.println(" KO : votre liste contient : "+ dequeVide);
				return;
			}

		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");


		System.out.print("Test 2 : deque a b c :");
		String[] tabc = {"a","b","c"};
		DequeImpl<String> dequeabc = new DequeImpl<String>(tabc);
		try{
			dequeabc.ajouterEnDernier("x");
			if(dequeabc.taille()!=4){
				System.out.println(" KO : l'attribut taille vaut : "+ dequeabc.taille());
				return;
			}
			if(!dequeabc.toString().equals(" a b c x")){
				System.out.println(" KO : votre liste contient : "+ dequeabc);
				return;
			}
		}
		catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		System.out.print("Test 3 : agrandissement de table");
		
		dequeabc = new DequeImpl<String>(tabc);
		dequeabc.ajouterEnDernier("d");
		dequeabc.ajouterEnDernier("e");
		try{
			dequeabc.ajouterEnDernier("x");
			
			if(!dequeabc.toString().equals(" a b c d e x")){
				System.out.println(" KO : votre liste contient : "+ dequeabc);
				System.out.println("Elle aurait du contenir a b c d e x!");
				return;
			}
		}
		catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
	
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	



	}


	private static void supprimerPremier() {
		System.out.println("Tests methode supprimerPremier()");
		System.out.println();
		System.out.print("Test 1 : dequeVide :");
		DequeImpl<String> dequeVide = new DequeImpl<String>();
		try{
			String s = dequeVide.supprimerPremier();
			if(s!=null){
				System.out.println(" KO, il fallait renvoyer null");
				return;
			}
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : deque a b c :");
		String[] tabc = {"a","b","c"};
		DequeImpl<String> dequeabc = new DequeImpl<String>(tabc);
		try{
			String s = dequeabc.supprimerPremier();
			if(!s.equals("a")){
				System.out.println(" KO : premier renvoye : "+ s);
				return;
			}
			if(dequeabc.taille()!=2){
				System.out.println(" KO : l'attribut taille vaut : "+ dequeabc.taille());
				return;
			}
			if(!dequeabc.toString().equals(" b c")){
				System.out.println(" KO : votre liste contient : "+ dequeabc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	
		
	}

	private static void supprimerDernier() {
		System.out.println("Tests methode supprimerDernier()");
		System.out.println();
		System.out.print("Test 1 : dequeVide :");
		DequeImpl<String> dequeVide = new DequeImpl<String>();
		try{
			String s = dequeVide.supprimerDernier();
			if(s!=null){
				System.out.println(" KO, il fallait renvoyer null");
				return;
			}	
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		
		
		System.out.print("Test 2 : deque a b c :");
		String[] tabc = {"a","b","c"};
		DequeImpl<String> dequeabc = new DequeImpl<String>(tabc);
		try{
			String s = dequeabc.supprimerDernier();
			if(!s.equals("c")){
				System.out.println(" KO : premier renvoye : "+ s);
				return;
			}
			if(dequeabc.taille()!=2){
				System.out.println(" KO : l'attribut taille vaut : "+ dequeabc.taille());
				return;
			}
			if(!dequeabc.toString().equals(" a b")){
				System.out.println(" KO : votre liste contient : "+ dequeabc);
				return;
			}
		}catch (Exception ex){
			System.out.println(" ko, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" ok");
		System.out.println("Tous les tests ont reussi!");	
		
	}
	
}
