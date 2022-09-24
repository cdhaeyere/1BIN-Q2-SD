
public class Commande {
	
	private Client client;
	private int nombreCasiersDemandes;

	/**
	 * 
	 * @param client
	 * @param nombreCasiersDemandes
	 */
	public Commande(Client client, int nombreCasiersDemandes) {
		super();
		this.client = client;
		setNombreCasiersDemandes(nombreCasiersDemandes);
	}

	public Client getClient() {
		return client;
	}

	public int getNombreCasiersDemandes() {
		return nombreCasiersDemandes;
	}

	public void setNombreCasiersDemandes(int nombreCasiersDemandes) {
		if(nombreCasiersDemandes<0)
			throw new IllegalArgumentException();
		this.nombreCasiersDemandes = nombreCasiersDemandes;
	}

	@Override
	public String toString() {
		return "Commande [client=" + client.getNom() + ", nombreCasiersDemandes="
				+ nombreCasiersDemandes + "]";
	}
	
	

	
	
	
}
