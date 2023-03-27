package missile_wars.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import missile_wars.commun.monde2d.MondePong2d;

public class CanvasPartie extends ResizableWorld2dCanvasFx {
    
    @Override
    protected void initialize() {
        // ajouter
        setInitialWorldSize(MondePong2d.LARGEUR_MONDE, MondePong2d.HAUTEUR_MONDE);
    }
	public void displayFps(String imagesParSeconde) {
		drawOnCanvas(gc -> {
            gc.save();
            gc.setFill(Color.LIMEGREEN);
			gc.fillText(imagesParSeconde, 0, 12);
            gc.restore();
		});
	}

}