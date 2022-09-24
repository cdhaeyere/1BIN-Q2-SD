import java.util.LinkedList;

public class DocumentsLRU {

	private LinkedList<String> listeLRU;
	
	
	/**
	 * construit une liste de nombreDocuments documents : doc1 doc2 ...
	 * @param nombreDocuments
	 * @throws IllegalArgumentException il faut au moins 1 document
	 */
	public DocumentsLRU(int nombreDocuments){
		if (nombreDocuments < 1) throw new IllegalArgumentException();
		listeLRU = new LinkedList<>();
		for (int i = 0; i < nombreDocuments; i++) {
			listeLRU.add("doc"+(i+1));
		}
	}
	

	/**
	 * place le document passe en parametre dans la liste selon le mecanisme LRU
	 * @param document qui est ouvert
	 * @throws IllegalArgumentException si le document est null ou ""
	 */
	public void ouvrirDocument(String document){
		if (document==null || document.equals("")) throw new IllegalArgumentException();
		if (listeLRU.contains(document)) {
			listeLRU.remove(document);
			listeLRU.addFirst(document);
		} else {
			listeLRU.removeLast();
			listeLRU.addFirst(document);
		}
	}
	
	
	public String toString(){
		return listeLRU.toString();
	}
	
}
