package missile_wars.frontal.taches;

import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.fragments.FragmentCouleur;
import missile_wars.frontal.vues.VueParametres;
import missile_wars.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;

public class Initialisation {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Initialisation")

				.andContains(subTasks -> {

					// ajouter
					creerVueRacine(subTasks);
					creerVueParametres(subTasks);

					// ajouter
					installerVueRacine(subTasks);
					installerVueParametres(subTasks);

					afficherFenetre(subTasks);
				});
	}

	private static void afficherFenetre(FrontendTasks subTasks) {

		subTasks.task("afficherFenetre")

				.waitsFor(window())

				.thenExecutes(inputs -> {

					Window window = inputs.get(window());

					window.show();
				});
	}

	private static void creerVueRacine(FrontendTasks tasks) {

		tasks.task(create(VueRacine.class))

				.waitsFor(viewLoader(VueRacine.class))

				.thenExecutesAndReturnsValue(inputs -> {

					ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));

					VueRacine vueRacine = viewLoader.createView();

					return vueRacine;
				});
	}

	private static void installerVueRacine(FrontendTasks tasks) {

		tasks.task("installerVueRacine")

				.waitsFor(window())

				.waitsFor(created(VueRacine.class))

				.thenExecutes(inputs -> {

					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					Window window = inputs.get(window());

					window.installRootView(vueRacine);
				});
	}

	private static void creerVueParametres(FrontendTasks tasks) {

		tasks.task(create(VueParametres.class))
				.waitsFor(viewLoader(VueParametres.class))
				.waitsFor(viewLoader(FragmentCouleur.class))
				.thenExecutesAndReturnsValue(inputs -> {

					ViewLoader<VueParametres> viewLoader = inputs.get(viewLoader(VueParametres.class));
					ViewLoader<FragmentCouleur> viewLoaderCouleurs = inputs.get(viewLoader(FragmentCouleur.class));
					VueParametres VueParametres = viewLoader.createView();
					VueParametres.setViewLoaderCouleurs(viewLoaderCouleurs);
					return VueParametres;
				});
	}

	private static void installerVueParametres(FrontendTasks tasks) {

		tasks.task("installerVueParametres")
				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VueParametres.class))

				.thenExecutes(inputs -> {

					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					VueParametres VueParametres = inputs.get(created(VueParametres.class));

					vueRacine.afficherSousVue(VueParametres);

				});

	}
}
