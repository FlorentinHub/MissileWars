package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import missile_wars.frontal.donnees.DonneesVuePartie;
import missile_wars.frontal.vues.VueMenu;

public class AfficherPartie {

    public static boolean partieEnCours = false;

    public static void creerTaches(FrontendTasks tasks) {

        creerDonneesVuePartie(tasks);

        // ajouter le groupe de tâches suivant
        tasks.taskGroup("AfficherPartie")

                .waitsFor(created(DonneesVuePartie.class))

                .andContains(subTasks -> {

                    prochaineImagePartie(subTasks);

                });

    }

    // ajouter la méthode
    private static void prochaineImagePartie(FrontendTasks subTasks) {

        subTasks.task("prochaineImagePartie")

                .waitsFor(clock().nextTick())
                .waitsFor(created(VueMenu.class))
                .thenExecutes(inputs -> {
                    Tick tick = inputs.get(clock().nextTick());
                    DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
                    VueMenu vueMenu = inputs.get(created(VueMenu.class));

                    if(partieEnCours){
                          // afficher le monde 2d
                    donneesVuePartie.reagirTempsQuiPasse(tick.elapsedTime());
                    donneesVuePartie.afficherSur(vueMenu);  
                    }

                
                });
    }

    private static void creerDonneesVuePartie(FrontendTasks tasks) {

        tasks.task(create(DonneesVuePartie.class))

                .waitsFor("Initialisation")

                .executesAndReturnsCreatedValue(inputs -> {

                    return new DonneesVuePartie();
                });
    }
}