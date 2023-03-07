package pong.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.evenements.EvtAfficherFileAttente;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VueRacine;

public class Navigation {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Navigation")

				.waitsFor("Initialisation")

				.andContains(subTasks -> {
					afficherVueParametres(subTasks);
					creerVueMenu(subTasks);
					afficherVueMenu(subTasks);

				});
	}
	private static void creerVueMenu(FrontendTasks subTasks) {

	    subTasks.task(create(VueMenu.class))

	         .waitsFor(viewLoader(VueMenu.class))

	         .thenExecutesAndReturnsValue(inputs -> {

	             ViewLoader<VueMenu> viewLoader = inputs.get(viewLoader(VueMenu.class));

	             VueMenu vueMenu = viewLoader.createView();

	             return vueMenu;
	         });
	}

	private static void afficherVueMenu(FrontendTasks subTasks) {

	    subTasks.task("afficherVueMenu")

	         .waitsFor(created(VueMenu.class))

	         .waitsFor(event(EvtAfficherMenu.class))

	         .thenExecutes(inputs -> {

	             VueRacine vueRacine = inputs.get(created(VueRacine.class));
	             VueMenu vueMenu = inputs.get(created(VueMenu.class));

	             vueRacine.afficherSousVue(VueMenu);
	         });
	}

	private static void afficherVueParametres(FrontendTasks subTasks) {

	    subTasks.task("afficherVueParametres")

	          .waitsFor(event(EvtAfficherVueParametres.class))

	          .thenExecutes(inputs -> {

	              VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
	              VueParametres vueParametres = inputs.get(created(VueParametres.class));

	              vueRacine.afficherSousVue(VueParametres);

	          });
	}
}