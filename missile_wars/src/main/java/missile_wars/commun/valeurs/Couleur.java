package missile_wars.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;
import missile_wars.frontal.fragments.FragmentCouleur;

public class Couleur implements ModelValue {
	private int rouge;
	private int vert;
	private int bleu;

	public Couleur() {

	}

	public Couleur(int rouge, int vert, int bleu) {
		this.rouge = rouge;
		this.vert = vert;
		this.bleu = bleu;
	}

	public void setRGB(int rouge, int vert, int bleu) {
		setRouge(rouge);
		setVert(vert);
		setBleu(bleu);
	}

	public int getRouge() {
		return rouge;
	}

	public void setRouge(int rouge) {
		this.rouge = rouge;
	}

	public int getVert() {
		return vert;
	}

	public void setVert(int vert) {
		this.vert = vert;
	}

	public int getBleu() {
		return bleu;
	}

	public void setBleu(int bleu) {
		this.bleu = bleu;
	}

	public String toString() {
		String retour;
		retour = "rouge";
		return retour;
	}

	public FragmentCouleur creerFragment(ViewLoader<FragmentCouleur> ViewLoaderParametres) {

		return ViewLoaderParametres.createView();
	}
	public void afficherSur(FragmentCouleur fragmentCouleur) {
		fragmentCouleur.afficherCouleur(Couleur.get);
	}
}