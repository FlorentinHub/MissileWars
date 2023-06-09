package pong.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import pong.commun.valeurs.RendezVous;
import pong.commun.valeurs.Usager;
import pong.frontal.vues.VueFileAttente;

public class ModeleFileAttente implements Model, WatchJson, WriteObjectGraph {

	private long prochainIdRendezVous = 1;

	private List<RendezVous> lesRendezVous = new ArrayList<>();

	public long getProchainIdRendezVous() {
		return prochainIdRendezVous;
	}

	public void setProchainIdRendezVous(long prochainIdRendezVous) {
		this.prochainIdRendezVous = prochainIdRendezVous;
	}

	public List<RendezVous> getLesRendezVous() {
		return lesRendezVous;
	}

	public void setLesRendezVous(List<RendezVous> lesRendezVous) {
		this.lesRendezVous = lesRendezVous;
	}

	public ModeleFileAttente() {

	}

	public String ajouterRendezVous(Usager premierJoueur) {
		String idRendezVous = genererIdRendezVous();
		RendezVous rendezVous = new RendezVous(idRendezVous, premierJoueur);

		lesRendezVous.add(rendezVous);
		
		return idRendezVous;
	}

	private String genererIdRendezVous() {
		String idRendezVous = String.valueOf(prochainIdRendezVous);
		prochainIdRendezVous++;

		return idRendezVous;
	}
	
	
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int numeroRendezVous = 1;
		
		for(RendezVous rendezVous : lesRendezVous) {

			builder.append(numeroRendezVous);
			builder.append(". ");
			builder.append(rendezVous.toString());
			builder.append("\n");

			numeroRendezVous++;
		}

		return builder.toString();
	}

	public void afficherSur(VueFileAttente vueFileAttente) {
		vueFileAttente.afficherRendezVousEnTexte(this.toString());
	}

}
