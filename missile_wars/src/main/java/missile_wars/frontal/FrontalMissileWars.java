package missile_wars.frontal;

import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.taches.Initialisation;

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

	}

	@Override
	public void execute() {

	}
}
