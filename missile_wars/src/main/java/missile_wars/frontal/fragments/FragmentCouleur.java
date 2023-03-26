package missile_wars.frontal.fragments;

import java.awt.Button;
import java.awt.Label;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.evenements.EvtAfficherParametres;


public class FragmentCouleur extends ViewFragmentFx {

    @FXML
    private Button boutonMenu;

    @FXML
    private Label labelCouleurLabel;

    @Override
    public void initialiser() {

        Ntro.assertNotNull("boutonMenu", boutonMenu);
        Ntro.assertNotNull("labelCouleurLabel", labelCouleurLabel);

        installerEvtAfficherMenu();
    }

    private void installerEvtAfficherMenu() {

        EvtAfficherMenu evtNtro = NtroApp.newEvent(EvtAfficherMenu.class);

        boutonMenu.setOnAction(evtFx -> {

            evtNtro.trigger();
        });
    }

    public void afficherCouleur(String couleur) {
        labelCouleurLabel.setText(couleur);
    }
}