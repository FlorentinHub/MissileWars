package pong.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pong.frontal.evenements.EvtAfficherFileAttente;

public class VuePartie extends ViewFx {

	@FXML
	private Button boutonQuitterPartie;

	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterPartie);
		installerEvtAfficherFileAttente();
	}

	private void installerEvtAfficherFileAttente() {

		boutonQuitterPartie.setOnAction(evtFx -> {

			System.out.println("[VuePartie] clic: " + evtFx.getEventType());

		});
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);

		boutonQuitterPartie.setOnAction(evtFx -> {

			evtNtro.trigger();
		});
	}
}
