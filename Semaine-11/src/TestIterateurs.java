import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class TestIterateurs {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("**************************************");
		System.out.println("Programme Test");
		System.out.println("**************************************");
		int choix = 0;
		do{
			System.out.println();
			System.out.println("1 -> Tester l'iterateur en pre-ordre");
			System.out.println("2 -> Tester l'iterateur en post-ordre");
			System.out.println("3 -> Tester l'iterateur en in-ordre");
			System.out.println("4 -> Tester l'iterateur par niveau");
			System.out.println();
			System.out.print("Entrez votre choix : ");

			choix = scanner.nextInt();
			switch (choix) {


			case 1:
				testIterateurPreOrdre();
				break;	
			case 2:
				testIterateurPostOrdre();
				break;	
			case 3:
				testIterateurInOrdre();
				break;	
			case 4:
				testIterateurParNiveau();
				break;	
			default:
				break;
			}
		} while ((choix > 0)&&(choix<5));
	}

	private static ArbreDEntiers arbre(){
		ArbreDEntiers g = new ArbreDEntiers(6);
		ArbreDEntiers d = new ArbreDEntiers();
		d =  new ArbreDEntiers(g,7,d);
		g = new ArbreDEntiers(3);
		ArbreDEntiers g1 = new ArbreDEntiers(g,5,d);
		g = new ArbreDEntiers(2);
		d = new ArbreDEntiers();
		d = new ArbreDEntiers(g,4,d);
		g = new ArbreDEntiers();
		d = new ArbreDEntiers(g,9,d);
		return  new ArbreDEntiers(g1, 8, d);
	}
	
	private static ArbreDEntiers arbreVide(){
		return new ArbreDEntiers();
	}
	

	public static void testIterateurPreOrdre(){
		
		ArbreDEntiers a = arbre();
		Iterator<Integer> it = a.preIterateur();
		if(it==null){
			System.out.println("Vous avez oublie d'ecrire la methode preIterateur()");
			System.exit(0);		
		}
		int[] solution = {8,5,3,7,6,9,4,2};
		boolean aReussi = true;
		int i = 0;
		while(it.hasNext()){
			int suivant = (Integer)it.next();
			if(suivant!=solution[i]) aReussi = false;
			i++;
			System.out.print(suivant + " ");
		}
		try{
			System.out.println(it.next());
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			aReussi = false;
		}catch (NoSuchElementException e){
			
		}catch (Exception e){
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			aReussi = false;
		}
		System.out.println();
		if(aReussi && i == 8){
			System.out.println("Le test a reussi!");
		}
		else {
			System.out.println("Attention, le test a echoue!");
		}
	}

	private static void testIterateurParNiveau() {
		ArbreDEntiers a = arbre();
		Iterator<Integer> it = a.iterateurParNiveau();
		if(it==null){
			System.out.println("Vous avez oublie d'ecrire la methode iterateurParNiveau()");
			System.exit(0);		
		}
		int[] solution = {8,5,9,3,7,4,6,2};
		boolean aReussi = true;
		int i = 0;
		while(it.hasNext()){
			int suivant = it.next();
			if(suivant!=solution[i]) aReussi = false;
			i++;
			System.out.print(suivant + " ");
		}
		System.out.println();
		try{
			System.out.println(it.next());
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			aReussi = false;
		}catch (NoSuchElementException ignored){
			
		}catch (Exception e){
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			aReussi = false;
		}

		if(aReussi && i == 8){
			System.out.println("Le test a reussi!");
		}
		else {
			System.out.println("Attention, le test a echoue!");
		}
	}

	private static void testIterateurInOrdre() {
		ArbreDEntiers a = arbre();
		Iterator<Integer> it = a.iterator();
		if(it==null){
			System.out.println("Vous avez oublie d'ecrire la methode iterator()");
			System.exit(0);		
		}
		int[] solution = {3,5,6,7,8,9,2,4};
		boolean aReussi = true;
		int i = 0;
		while(it.hasNext()){
			int suivant = (Integer)it.next();
			if(suivant!=solution[i]) aReussi = false;
			i++;
			System.out.print(suivant + " ");
		}
		System.out.println();
		try{
			System.out.println(it.next());
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			aReussi = false;
		}catch (NoSuchElementException ignored){
			
		}catch (Exception e){
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			aReussi = false;
		}

		if(aReussi && i == 8){
			System.out.println("Le test a reussi!");
		}
		else {
			System.out.println("Attention, le test a echoue!");
		}

	}

	private static void testIterateurPostOrdre() {
		ArbreDEntiers a = arbre();
		Iterator<Integer> it = a.postIterateur();
		if(it==null){
			System.out.println("Vous avez oublie d'ecrire la methode postIterateur()");
			System.exit(0);		
		}
		int[] solution = {3,6,7,5,2,4,9,8};
		boolean aReussi = true;
		int i = 0;
		while(it.hasNext()){
			int suivant = it.next();
			if(suivant!=solution[i]) aReussi = false;
			i++;
			System.out.print(suivant + " ");
		}
		System.out.println();
		try{
			System.out.println(it.next());
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			aReussi = false;
		}catch (NoSuchElementException ignored){
			
		}catch (Exception e){
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			aReussi = false;
		}

		if(aReussi && i == 8){
			System.out.println("Le test a reussi!");
		}
		else {
			System.out.println("Attention, le test a echoue!");
		}
	}

}
