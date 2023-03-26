package pong.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.frontal.evenements.EvtAfficherPartie;
import pong.maquettes.MaquetteUsagers;

public class VueFileAttente extends ViewFx {

	@FXML
	private Button boutonJoindrePartie;

	@FXML
	private Button boutonSInscrire;

	@FXML
	private Label labelRendezVous;

	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonOuvrirPartie", boutonJoindrePartie);
		Ntro.assertNotNull("boutonAjouterRendezVous", boutonSInscrire);
		Ntro.assertNotNull("labelRendezVous", labelRendezVous);

		installerEvtAfficherPartie();
		installerMsgAjouterRendezVous();
	}

	private void installerEvtAfficherPartie() {
		
		EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);

		boutonJoindrePartie.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
	}

	private void installerMsgAjouterRendezVous() {

		MsgAjouterRendezVous msgAjouterRendezVous = NtroApp.newMessage(MsgAjouterRendezVous.class);

		boutonSInscrire.setOnAction(evtFx -> {

			msgAjouterRendezVous.setPremierJoueur(MaquetteUsagers.usagerCourant());
			msgAjouterRendezVous.send();
			
			MaquetteUsagers.prochainUsager();
		});
	}

	public void afficherRendezVousEnTexte(String message) {
		labelRendezVous.setText(message);
	}

}
