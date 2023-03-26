package pong.commun.valeurs;

public class PartieEnCours extends RendezVous {
	
	private String idPartie;
	private Usager deuxiemeJoueur;

	public Usager getDeuxiemeJoueur() {
		return deuxiemeJoueur;
	}

	public void setDeuxiemeJoueur(Usager deuxiemeJoueur) {
		this.deuxiemeJoueur = deuxiemeJoueur;
	}

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	public PartieEnCours() {
		super();
	}

	public PartieEnCours(String idRendezVous, 
			             Usager premierJoueur,
			             Usager deuxiemeJoueur,
			             String idPartie) {

		super(idRendezVous, premierJoueur);

		setIdPartie(idPartie);
		setDeuxiemeJoueur(deuxiemeJoueur);
	}

	
	@Override
	public String toString() {
		return getPremierJoueur().getPrenom() + " Vs " + deuxiemeJoueur.getPrenom();
	}
}
