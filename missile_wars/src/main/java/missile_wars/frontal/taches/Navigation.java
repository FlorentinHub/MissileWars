package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.evenements.EvtAfficherParametres;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.vues.VueParametres;
import missile_wars.frontal.vues.VueMenu;
import missile_wars.frontal.vues.VueRacine;

public class Navigation {

	private static void creerVueMenu(FrontendTasks subTasks) {

	    subTasks.task(create(VueMenu.class))

	         .waitsFor(viewLoader(VueMenu.class))

	         .thenExecutesAndReturnsValue(inputs -> {

	             ViewLoader<VueMenu> viewLoader = inputs.get(viewLoader(VueMenu.class));

	             VueMenu vueMenu = viewLoader.createView();

	             return vueMenu;
	         });
	}
	public static void creerTaches(FrontendTasks tasks) {

	    tasks.taskGroup("Navigation")

	         .waitsFor("Initialisation")

	         .andContains(subTasks -> {

	        	 afficherVueParametres(subTasks);

	             creerVueMenu(subTasks);
	             afficherVueMenu(subTasks);

	         });
	}
	private static void afficherVueMenu(FrontendTasks subTasks) {

	    subTasks.task("afficherVueMenu")

	         .waitsFor(created(VueMenu.class))

	         .waitsFor(event(EvtAfficherMenu.class))

	         .thenExecutes(inputs -> {

	             VueRacine vueRacine = inputs.get(created(VueRacine.class));
	             VueMenu vueMenu = inputs.get(created(VueMenu.class));

	             vueRacine.afficherSousVue(vueMenu);
	         });
	}

	private static void afficherVueParametres(FrontendTasks subTasks) {

	    subTasks.task("afficherVueParametres")

	          .waitsFor(event(EvtAfficherParametres.class))

	          .thenExecutes(inputs -> {

	              VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
	              VueParametres VueParametres = inputs.get(created(VueParametres.class));

	              vueRacine.afficherSousVue(VueParametres);

	          });
	}
}
