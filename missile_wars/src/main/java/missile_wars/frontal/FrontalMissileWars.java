package missile_wars.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.evenements.EvtAfficherParametres;
import missile_wars.frontal.donnees.DonneesVuePartie;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.taches.AfficherParametres;
import missile_wars.frontal.taches.AfficherPartie;
import missile_wars.frontal.taches.Initialisation;
import missile_wars.frontal.taches.Navigation;
import missile_wars.frontal.vues.VueParametres;
import missile_wars.frontal.vues.VueRacine;
import missile_wars.frontal.vues.VueMenu;
import missile_wars.frontal.fragments.FragmentCouleur;


public class FrontalMissileWars implements FrontendFx {

	@Override
	public void createTasks(FrontendTasks tasks) {
		Initialisation.creerTaches(tasks);
		AfficherParametres.creerTaches(tasks);
		Navigation.creerTaches(tasks);
		AfficherPartie.creerTaches(tasks);
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		registrar.registerEvent(EvtAfficherParametres.class);
		registrar.registerEvent(EvtAfficherMenu.class);
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueParametres.class, "/parametres.xml");

		// registrar.registerStylesheet("/dev.css");
		registrar.registerStylesheet("/prod.css");

		registrar.registerDefaultResources("/chaines_fr.properties");

		registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
		registrar.registerResources(NtroApp.locale("qc"), "/chaines_qc.properties");
		registrar.registerResources(NtroApp.locale("ch"), "/chaines_ch.properties");
		registrar.registerView(VueMenu.class, "/menu.xml");
		//Fragment Couleur:
		registrar.registerFragment(FragmentCouleur.class, "/fragments/couleur.xml");

		registrar.registerViewData(DonneesVuePartie.class);
	}

	@Override
	public void execute() {

	}
}
