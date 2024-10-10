package universite_paris8.iut.yponnou.zelda.vue.armes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.armes.Fleche;
import universite_paris8.iut.yponnou.zelda.vue.son.Son;
import universite_paris8.iut.yponnou.zelda.vue.acteurs.ActeurVue;

public class FlecheVue extends ActeurVue {

    private final ImageView imageView;

    private final Son sonFleche = new Son("/universite_paris8/iut/yponnou/zelda/Sons/bruits/sonFleche.wav");


    private final Image flecheGaucheImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/fleche-gauche.png");
    private final Image flecheDroiteImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/fleche-droite.png");
    private final Image flecheHautImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/fleche-haut.png");
    private final Image flecheBasImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/fleche-bas.png");

    public FlecheVue(Fleche f, Pane pane) {
        super(f,pane);
        if (f.getDirection().getDx() == 1 && f.getDirection().getDy() == 0)
            imageView = new ImageView(flecheDroiteImage);
        else if (f.getDirection().getDx() == -1 && f.getDirection().getDy() == 0)
            imageView = new ImageView(flecheGaucheImage);
        else if (f.getDirection().getDx() == 0 && f.getDirection().getDy() == -1)
            imageView = new ImageView(flecheHautImage);
        else
            imageView = new ImageView(flecheBasImage);
    }
    public void creerSprite(){
        imageView.setId(getActeur().getId());
        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        jouerSon();
        getPane().getChildren().add(imageView);
    }

    public void jouerSon(){
        try {
            sonFleche.jouer(1,0);
        }catch (Exception e){
            System.out.println("Son incompatible");
        }
    }



    @Override
    public void upgradeSprite() {

    }
}