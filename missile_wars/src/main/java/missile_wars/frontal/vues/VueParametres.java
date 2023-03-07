package missile_wars.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import missile_wars.commun.maquettes.MaquetteUsagers;
import missile_wars.commun.messages.MsgAjouterCouleur;
import missile_wars.frontal.evenements.EvtAfficherMenu;

public class VueParametres extends ViewFx {

	@FXML
	private Label labelParametres;
	@FXML
	private Button boutonJoindreMenu;
	@FXML
	private Button boutonAddColor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("labelParametres", labelParametres);
		Ntro.assertNotNull("boutonJoindreMenu", boutonJoindreMenu);
		installerEvtAfficherParametres();
		Ntro.assertNotNull("boutonSInscrire", boutonAddColor);

	}

	public void afficherParametresEnTexte(String message) {
		labelParametres.setText(message);
	}

	private void installerEvtAfficherParametres() {
		boutonJoindreMenu.setOnAction(evtFx -> {
			System.out.println("[VueParametres] clic:" + evtFx.getEventType());
		});
		EvtAfficherMenu evtNtro = NtroApp.newEvent(EvtAfficherMenu.class);
		boutonJoindreMenu.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
	}
    private void installerMsgAjouterCouleurs() {
    	MsgAjouterCouleur msgAjouterCouleur = NtroApp.newMessage(MsgAjouterCouleur.class);
    	boutonAddColor.setOnAction(evtFx -> {
            // On a un clic
        	// l'usager courant s'inscrit
        	msgAjouterCouleur.setPremierJoueur(MaquetteUsagers.usagerCourant());
        	msgAjouterCouleur.send();
            // à chaque clic, on passe à un nouvel usager
            MaquetteUsagers.prochainUsager();
        });
    }
}


