/**
 * @author Corentin D'haeyere
 */
public class DemandeImpressionAvecPriorite extends DemandeImpression{
	
	private int priorite;   // Une demande de priorite 9 est plus prioritaire qu une demande de priorite 0. 

	public DemandeImpressionAvecPriorite(String cheminAcces, String nomDocument,
			String nomUtilisateur, int priorite) {
		super(cheminAcces,nomDocument,nomUtilisateur);
		if(priorite<0||priorite>9)throw new IllegalArgumentException();
		this.priorite = priorite;
	}
	
	public DemandeImpressionAvecPriorite(String nomDocument,int priorite) {
		this("",nomDocument,"",priorite);
	}

	public int getPriorite(){
		return priorite;
	}

	public void setPriorite(int priorite){
		if(priorite<0||priorite>9)throw new IllegalArgumentException();
		this.priorite = priorite;
	}	
	
	public String toString() {
		return super.toString()+" priorite : "+ priorite;
	}
}
