/**
 * @author Corentin D'haeyere
 */
public class TestFileAttenteImpressions {
	
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a re�u en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" re�u="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" re�u="+recu);
			System.exit(0);			
		}
	}
	
	public static void main(String[] args) {
		FileAttenteImpressions file = new FileAttenteImpressions();
		System.out.println("***************************************************");
		System.out.println("Programme Test pour la classe FileAttenteImpression");
		System.out.println("***************************************************");
		System.out.println();
	
		// Test 1 : file vide
		assertEquals("Test1 ko : au depart la file est vide : ", true,file.estVide() );
		try {
			file.retirer();
			System.out.println("Test1 ko : retrait dans une file vide, il fallait lancer une FileVideException");
			return;
		} catch (FileVideException e) {		
		}
		// Test 2 : ajout d'1 document et ensuite retrait
		file.ajouter(new DemandeImpression("doc1"));	
		assertEquals("Test2 ko : apres ajout de doc1, la file n'est plus vide",false,file.estVide() );
		try{
			assertEquals("Test2 ko : le document retire n est pas celui qui a ete ajoute ", true, (new DemandeImpression("doc1")).equals(file.retirer()));
		}catch (FileVideException e) {	
			System.out.println("Test2 ko : retrait dans une file non vide, il ne fallait pas lancer une FileVideException");
			return;
		}
		assertEquals("Test2 ko : ajout puis retrait dans une file au depart vide, la file est a nouveau vide", true,file.estVide() );
		// Test 3 : ajout de 3 documents dans une file vide puis retrait de ces 3 documents
		file = new FileAttenteImpressions();
		file.ajouter(new DemandeImpression("doc1"));
		file.ajouter(new DemandeImpression("doc2"));
		file.ajouter(new DemandeImpression("doc3"));
		assertEquals("Test3 ko, apres 3 ajouts, la file n'est plus vide : file.estVide() : ",false,file.estVide() );
		assertEquals("Test3 ko, retrait du 1er document",true, (new DemandeImpression("doc1")).equals(file.retirer()));
		assertEquals("Test3 ko, retrait du 2eme document",true, (new DemandeImpression("doc2")).equals(file.retirer()));
		assertEquals("Test3 ko, retrait du 3eme document",true, (new DemandeImpression("doc3")).equals(file.retirer()));
		assertEquals("Test3 ko : 3 ajouts puis 3 retraits dans une file au depart vide, la file est a nouveau vide", true,file.estVide() );
		
		System.out.println("Tous les tests ont reussi!");
	}
}
