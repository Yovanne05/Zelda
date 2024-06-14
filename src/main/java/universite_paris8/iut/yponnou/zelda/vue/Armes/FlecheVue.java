package universite_paris8.iut.yponnou.zelda.vue.Armes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.ActeurVue;

public class FlecheVue extends ActeurVue {

    private final ImageView imageView;

    private final Image flecheGaucheImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/fleche-gauche.png");
    private final Image flecheDroiteImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/fleche-droite.png");
    private final Image flecheHautImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/fleche-haut.png");
    private final Image flecheBasImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/fleche-bas.png");


    public FlecheVue(Fleche f, Pane pane) {
        super(f,pane);
        if (f.getDx() == 1 && f.getDy() == 0)
            imageView = new ImageView(flecheDroiteImage);
        else if (f.getDx() == -1 && f.getDy() == 0)
            imageView = new ImageView(flecheGaucheImage);
        else if (f.getDx() == 0 && f.getDy() == -1)
            imageView = new ImageView(flecheHautImage);
        else
            imageView = new ImageView(flecheBasImage);
    }
    public void creerSprite(){
        imageView.setId(getActeur().getId());
        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        getPane().getChildren().add(imageView);
    }

    @Override
    public void upgradeSprite() {

    }
}