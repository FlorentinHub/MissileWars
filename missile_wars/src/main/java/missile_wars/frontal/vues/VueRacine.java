package missile_wars.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.views.ViewFx;
import javafx.scene.layout.Pane;
import missile_wars.commun.modeles.Couleur;
import missile_wars.commun.modeles.ModeleParametres;

public class VueRacine extends ViewFx {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void afficherSousVue(ViewFx sousVue) {
		Pane racineSousVue = sousVue.rootNode();
		rootNode().getChildren().clear();
		rootNode().getChildren().add(racineSousVue);
	}

	public void afficher(ModeleParametres modele) {
		List<Couleur> lesCouleursPrincipales = modele.getLesCouleursPrincipales();
	}
}