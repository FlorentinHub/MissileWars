package missile_wars.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import missile_wars.commun.monde2d.MondePong2d;
import missile_wars.frontal.controles.CanvasPartie;
import missile_wars.frontal.evenements.EvtAfficherParametres;

public class VueMenu extends ViewFx {

	@FXML
	private Button boutonQuitterMenu;
	@FXML
	private CanvasPartie canvasPartie;

	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonQuitterMenu", boutonQuitterMenu);
		installerEvtAfficherParametres();
		Ntro.assertNotNull(canvasPartie);
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

	public void viderCanvas() {
		canvasPartie.clearCanvas();
	}

	public void afficherImagesParSeconde(String fps) {
		canvasPartie.displayFps(fps);
	}

	public void afficherPong2d(MondePong2d mondePong2d) {
		mondePong2d.drawOn(canvasPartie);
	}

}