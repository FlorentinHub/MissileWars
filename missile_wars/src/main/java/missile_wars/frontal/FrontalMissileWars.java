package missile_wars.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.taches.Initialisation;
import missile_wars.frontal.vues.VueFileAttente;
import missile_wars.frontal.vues.VueRacine;

public class FrontalMissileWars implements FrontendFx {

	@Override
	public void createTasks(FrontendTasks tasks) {

		Initialisation.creerTaches(tasks);

	}

	@Override
	public void registerEvents(EventRegistrar registrar) {

	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueFileAttente.class, "/file_attente.xml");
		
		//registrar.registerStylesheet("/dev.css");
		registrar.registerStylesheet("/prod.css");
		
		registrar.registerDefaultResources("/chaines_fr.properties");

		registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
	}

	@Override
	public void execute() {

	}
}
