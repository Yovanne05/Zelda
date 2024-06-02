package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.layout.Pane;

public class BarreDeVieVue extends PvVue{

    private final int nbPortionPleine;
    private final int pvPortionEndommage;

    public BarreDeVieVue(int nbPortionPleine, int pvPortionEndommage, Pane pane) {
        super(pane);
        this.nbPortionPleine = nbPortionPleine;
        this.pvPortionEndommage = pvPortionEndommage;
    }


    @Override
    public void spritePv() {

    }
}
