package missile_wars.frontal.donnees;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.monde2d.MondePong2d;
import missile_wars.frontal.vues.VueMenu;

public class DonneesVuePartie implements ViewData {
    // ajouter
    private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;


    // ajouter
    private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
    private long imagesAfficheesDepuisDernierCalculFps = 0;
    
    private MondePong2d mondePong2d = new MondePong2d();
    private String fpsCourant = "0";

    public void afficherSur(VueMenu vueMenu) {
        calculerFpsSiNecessaire();

        vueMenu.viderCanvas();
        vueMenu.afficherImagesParSeconde("FPS " + fpsCourant);
        vueMenu.afficherPong2d(mondePong2d);
        // ajouter
        
        imagesAfficheesDepuisDernierCalculFps++;
    }

    public void reagirTempsQuiPasse(double elapsedTime) {
        mondePong2d.onTimePasses(elapsedTime);
    }
        private void calculerFpsSiNecessaire() {
            long horodatageMaintenant = Ntro.time().nowMilliseconds();
            long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;
    
            if(millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
                calculerFpsMaintenant(millisecondesEcoulees);
    
                imagesAfficheesDepuisDernierCalculFps = 0;
                horodatageDernierCalculFps = horodatageMaintenant;
            }
        }
    
        private void calculerFpsMaintenant(long millisecondesEcoulees) {
            double secondesEcoulees = millisecondesEcoulees / 1E3;
            double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
            fpsCourant = String.valueOf(Math.round(fps));
        }
}