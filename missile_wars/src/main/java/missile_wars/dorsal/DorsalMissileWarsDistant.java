package missile_wars.dorsal;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.backend.RemoteBackendNtro;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import missile_wars.commun.Declarations;

public class DorsalMissileWarsDistant extends RemoteBackendNtro {

	// public static void main(String[] args) {
	// 	NtroClientFx.launch(args);
	// }

	// @Override
	// public void registerBackend(BackendRegistrar registrar) {
	// 	//registrar.registerBackend(new DorsalMissileWars());
    //     registrar.registerBackend(new DorsalMissileWarsDistant());
	// }

	// @Override
	// public void registerFrontend(FrontendRegistrarFx registrar) {
	// 	registrar.registerFrontend(new FrontalMissileWars());
	// }

	// @Override
	// public void registerMessages(MessageRegistrar registrar) {
	// 	Declarations.declarerMessage(registrar);
	// }

	// @Override
	// public void registerModels(ModelRegistrar registrar) {
	// 	Declarations.declarerModels(registrar);
	// }
    @Override
    public void registerServer(ServerRegistrar registrar) {
        Declarations.declarerServeur(registrar);
    }
    
}