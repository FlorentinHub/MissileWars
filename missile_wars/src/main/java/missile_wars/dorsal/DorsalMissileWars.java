package missile_wars.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.dorsal.taches.ModifierCouleur;

public class DorsalMissileWars extends LocalBackendNtro {

	    @Override
	    public void createTasks(BackendTasks tasks) {
	    	ModifierCouleur.creerTaches(tasks);

	    }

	@Override
	public void execute() {

	}
}