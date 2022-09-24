
public class TestDocumentsLRU {
	
	public static void main(String[] args) {
		
		DocumentsLRU docs = new DocumentsLRU(5);
		
		System.out.println("Au depart :");
		System.out.println(docs);
		
		System.out.println("\nouvrir doc3");
		docs.ouvrirDocument("doc3");
		System.out.println(docs);
		
		System.out.println("\nouvrir doc4");
		docs.ouvrirDocument("doc4");
		System.out.println(docs);
		
		System.out.println("\nouvrir doc4");
		docs.ouvrirDocument("doc4");
		System.out.println(docs);
		
		System.out.println("\nouvrir doc5");
		docs.ouvrirDocument("doc5");
		System.out.println(docs);
		
		System.out.println("\nouvrir doc6");
		docs.ouvrirDocument("doc6");
		System.out.println(docs);
		
		System.out.println("\nouvrir doc3");
		docs.ouvrirDocument("doc3");
		System.out.println(docs);
		
		System.out.println("\nouvrir doc6");
		docs.ouvrirDocument("doc6");
		System.out.println(docs);
		
		System.out.println("\nouvrir doc7");
		docs.ouvrirDocument("doc7");
		System.out.println(docs);
		
		
		
	}
}
