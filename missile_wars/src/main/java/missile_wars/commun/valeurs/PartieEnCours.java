package missile_wars.commun.valeurs;

public class PartieEnCours extends RendezVous{

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

		private String idPartie;

	public PartieEnCours() {
		super();
	}
	    @Override
	    public String toString() {
	        return getPremierJoueur().getPrenom() + " Vs " + deuxiemeJoueur.getPrenom();
	    }

}
