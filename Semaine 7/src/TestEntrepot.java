/**
 * @author Corentin D'haeyere
 */
public class TestEntrepot {
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+" Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+" Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	
	public static void main(String [] args){
		
		Entrepot entrepot = new Entrepot(5);
		
		System.out.println("test1 : la societe 3 se voit attribuer le hangar numero 3");
		assertEquals("test 1 ko : mauvais numero", 3, entrepot.attribuerHangar(3, "soc3"));
		assertEquals("test 1 ko : pas les bons hangars", "[3]",entrepot.getSociete(3).lesHangars());
	
		System.out.println("test1 ok");
		System.out.println();
		
		System.out.println("test2 : la societe 5 se voit attribuer le hangar numero 0");
		assertEquals("test 2 ko : mauvais numero", 0, entrepot.attribuerHangar(5, "soc5"));
		assertEquals("test 2 ko : pas les bons hangars", "[0]",entrepot.getSociete(5).lesHangars());
		System.out.println("test2 ok");
		System.out.println();
		
		System.out.println("test3 : la societe 3 se voit attribuer le hangar numero 4");
		assertEquals("test 3 ko : mauvais numero", 4, entrepot.attribuerHangar(3, "soc3"));
		assertEquals("test 3 ko : pas les bons hangars", "[3, 4]",entrepot.getSociete(3).lesHangars());
		System.out.println("test3 ok");
		System.out.println();
		
		
		System.out.println("test4 : la societe 3 se voit attribuer le hangar numero 1");
		assertEquals("test 4 ko : mauvais numero", 1, entrepot.attribuerHangar(3, "soc3"));
		assertEquals("test 4 ko : pas les bons hangars", "[3, 4, 1]",entrepot.getSociete(3).lesHangars());
		System.out.println("test4 ok");
		System.out.println();
		
		System.out.println("test5 : la societe 5 se voit attribuer le hangar numero 2");
		assertEquals("test 5 ko : mauvais numero", 2, entrepot.attribuerHangar(5, "soc5"));
		assertEquals("test 5 ko : pas les bons hangars", "[0, 2]",entrepot.getSociete(5).lesHangars());
		System.out.println("test5 ok");
		System.out.println();
		
		System.out.println("test6 : il n'y a plus d'hangar de libre , la societe 3 ne recoit pas d'hangar");
		assertEquals("test 6 ko : mauvais numero", -1, entrepot.attribuerHangar(3, "soc3"));
		assertEquals("test 6 ko : pas les bons hangars", "[3, 4, 1]",entrepot.getSociete(3).lesHangars());
		System.out.println("test6 ok");
		System.out.println();
		
		System.out.println("test7 : il n'y a plus d'hangar de libre , la societe 99 ne recoit pas d'hangar");
		System.out.println("      : elle ne peut pas etre repertoriee parmi les societes presentes");
		assertEquals("test 7 ko : mauvais numero", -1, entrepot.attribuerHangar(99, "soc99"));
		assertEquals("test 7 ko : societe n'existe pas", null, entrepot.getSociete(99));
		System.out.println("test7 ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi!");
		
	}
}
