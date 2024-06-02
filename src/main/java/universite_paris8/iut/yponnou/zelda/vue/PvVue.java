package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class PvVue {

    private final Pane pane;

    public PvVue(Pane pane) {
        this.pane = pane;
    }

    public Pane getPane() {
        return pane;
    }

    public abstract void spritePv();
}
