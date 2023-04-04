package missile_wars.commun;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import missile_wars.commun.messages.MsgAjouterCouleur;
import missile_wars.commun.modeles.ModeleParametres;
import missile_wars.commun.valeurs.Couleur;

public class Declarations {
    public static void declarerMessage(MessageRegistrar registrar) {
        registrar.registerMessage(MsgAjouterCouleur.class);
    }
    public static void declarerModels(ModelRegistrar registrar) {
		registrar.registerModel(ModeleParametres.class);
		registrar.registerValue(Couleur.class);
	}
    public static void declarerServeur(ServerRegistrar registrar) {
        registrar.registerName("localhost");
        registrar.registerPort(8003);
    }
}