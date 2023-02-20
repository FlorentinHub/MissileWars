package pong.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.modeles.valeurs.RendezVous;
import pong.frontal.evenements.EvtAfficherPartie;

public class VueFileAttente extends ViewFx {
	public void afficher(ModeleFileAttente modele) {

		List<RendezVous> rendezVous = modele.getLesRendezVous();
	}
	@FXML
	private Label labelRendezVous;
	@FXML
	private Button boutonJoindrePartie;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("labelRendezVous", labelRendezVous);
		Ntro.assertNotNull("boutonJoindrePartie", boutonJoindrePartie);
		installerEvtAfficherPartie();
	}

	public void afficherRendezVousEnTexte(String message) {
		labelRendezVous.setText(message);
	}
	private void installerEvtAfficherPartie() {

		boutonJoindrePartie.setOnAction(evtFx -> {

			System.out.println("[VueFileAttente] clic:" + evtFx.getEventType());

		});
		EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);

		boutonJoindrePartie.setOnAction(evtFx -> {

			evtNtro.trigger();

		});
	}
}
