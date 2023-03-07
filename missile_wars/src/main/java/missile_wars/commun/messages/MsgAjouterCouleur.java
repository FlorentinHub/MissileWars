package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import missile_wars.commun.valeurs.Usager;

public class MsgAjouterCouleur extends MessageNtro {

    private Usager premierJoueur;

    public MsgAjouterCouleur() {
    }

    public Usager getPremierJoueur() {
        return premierJoueur;
    }

    public void setPremierJoueur(Usager premierJoueur) {
        this.premierJoueur = premierJoueur;
    }
}