/**
 * @author Corentin D'haeyere
 */
public class TestServeurImpressions {
	public static void main(String[] args) {
		ServeurImpressions file = new ServeurImpressions();
		DemandeImpressionAvecPriorite demande;
		
		System.out.println("Au depart la file est vide : "+ file.estVide());
				
		System.out.println("ajout dans une file vide des documents suivants (dans cet ordre!)");
		System.out.println("doc1 - 4");
		file.ajouter(new DemandeImpressionAvecPriorite("doc1",4));
		System.out.println("doc2 - 9");
		file.ajouter(new DemandeImpressionAvecPriorite("doc2",9));
		System.out.println("doc3 - 0");
		file.ajouter(new DemandeImpressionAvecPriorite("doc3",0));
		System.out.println("doc4 - 9");
		file.ajouter(new DemandeImpressionAvecPriorite("doc4",9));
		System.out.println("doc5 - 4");
		file.ajouter(new DemandeImpressionAvecPriorite("doc5",4));
		System.out.println("doc6 - 4");
		file.ajouter(new DemandeImpressionAvecPriorite("doc6",4));
		System.out.println("ils devraient etre imprimes dans cet ordre : doc2 doc4 doc1 doc5 doc6 doc3!");
		boolean ok = true;
		try{
			demande = file.retirer();
			if(!demande.getNomDocument().equals("doc2"))
				ok = false;
			System.out.println(demande);
			demande = file.retirer();
			if(!demande.getNomDocument().equals("doc4"))
				ok = false;
			System.out.println(demande);
			demande = file.retirer();
			if(!demande.getNomDocument().equals("doc1"))
				ok = false;
			System.out.println(demande);
			demande = file.retirer();
			if(!demande.getNomDocument().equals("doc5"))
				ok = false;
			System.out.println(demande);
			demande = file.retirer();
			if(!demande.getNomDocument().equals("doc6"))
				ok = false;
			System.out.println(demande);
			demande = file.retirer();
			if(!demande.getNomDocument().equals("doc3"))
				ok = false;
			System.out.println(demande);
			if(!ok)
				System.out.println("Attention, l'ordre n'est pas respecte!");
		}catch (FileVideException e){
			System.out.println("Attention FileVideException");
		}
		
	}	
}
