/**
 * @author Corentin D'haeyere
 */
public class 	FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner
	

	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}
	

	public boolean estVide(){
		return taille == 0;
	}


	public int taille(){
		return taille;
	}

	public E premier()throws FileVideException{

		if (estVide()){throw new FileVideException();}
		return (E)table[indiceTete];

	}


	public E defile() throws FileVideException{

		if (estVide()){throw new FileVideException();}
		E temp = (E)table[indiceTete];
		table[indiceTete] = null;
		indiceTete++;
		if (indiceTete == table.length){
			indiceTete = 0;
		}
		taille--;
		return temp;
	}

	public void enfile(E element){
		if (taille == table.length){
			Object[] temp = new Object[table.length];
			for (int i = 0;i < table.length;i++){
				temp[i] = table[i];
			}
			table = new Object[table.length*2];
			for (int i = 0; i < temp.length;i++){
				table[i] = temp[indiceTete];
				indiceTete++;
				if (indiceTete == temp.length){
					indiceTete = 0;
				}
			}
			indiceTete = 0;
		}
		if (indiceTete + taille >= table.length){
			table[(indiceTete + taille) - table.length] = element;
		} else {
			table[indiceTete + taille] = element;
		}
		taille++;
	}
}
