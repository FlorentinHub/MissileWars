package missile_wars.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import missile_wars.frontal.evenements.EvtAfficherParametres;

public class VueMenu extends ViewFx {

	@FXML
	private Button boutonQuitterMenu;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("boutonQuitterMenu", boutonQuitterMenu);
		installerEvtAfficherParametres();
	}

	private void installerEvtAfficherParametres() {
		boutonQuitterMenu.setOnAction(evtFx -> {
			System.out.println("[VueMenu] clic: " + evtFx.getEventType());
		});
		EvtAfficherParametres evtNtro = NtroApp.newEvent(EvtAfficherParametres.class);
		boutonQuitterMenu.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
	}
}