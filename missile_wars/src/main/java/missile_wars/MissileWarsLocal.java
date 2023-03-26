package missile_wars;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import missile_wars.commun.messages.MsgAjouterCouleur;
import missile_wars.commun.modeles.ModeleParametres;
import missile_wars.commun.valeurs.Couleur;
import missile_wars.dorsal.DorsalMissileWars;
import missile_wars.frontal.FrontalMissileWars;

public class MissileWarsLocal implements NtroClientFx {

	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		registrar.registerBackend(new DorsalMissileWars());
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		registrar.registerFrontend(new FrontalMissileWars());
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgAjouterCouleur.class);
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		registrar.registerModel(ModeleParametres.class);
		registrar.registerValue(Couleur.class);
	}

}