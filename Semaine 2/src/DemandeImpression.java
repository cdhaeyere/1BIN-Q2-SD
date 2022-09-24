/**
 * @author Corentin D'haeyere
 */
public class DemandeImpression {

	private String nomDocument;
	private String cheminAcces;
	private String nomUtilisateur;

	public DemandeImpression(String cheminAcces, String nomDocument,
			String nomUtilisateur) {
		if(nomDocument==null || nomDocument.equals(""))throw new IllegalArgumentException();
		if(cheminAcces==null)throw new IllegalArgumentException();
		if(nomUtilisateur==null)throw new IllegalArgumentException();
		this.cheminAcces = cheminAcces;
		this.nomDocument = nomDocument;
		this.nomUtilisateur = nomUtilisateur;
	}
	
	public DemandeImpression(String nomDocument){
		this("", nomDocument, "");
	}

	public String toString() {
		String aRenvoyer = "nom du document : "+this.nomDocument;
		if(!this.cheminAcces.equals(""))
			aRenvoyer+= " chemin d'acces : "+ this.cheminAcces;
		if(!this.nomUtilisateur.equals(""))
			aRenvoyer+=" nom d'utilisateur : "+this.nomUtilisateur;
		return aRenvoyer;
	}
	
	public String getNomDocument() {
		return nomDocument;
	}

	public String getCheminAcces() {
		return cheminAcces;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomDocument == null) ? 0 : nomDocument.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemandeImpression other = (DemandeImpression) obj;
		if (nomDocument == null) {
			if (other.nomDocument != null)
				return false;
		} else if (!nomDocument.equals(other.nomDocument))
			return false;
		return true;
	}
	

}
