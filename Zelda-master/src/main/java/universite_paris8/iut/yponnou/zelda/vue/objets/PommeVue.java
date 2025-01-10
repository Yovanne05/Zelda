package universite_paris8.iut.yponnou.zelda.vue.objets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Pomme;

public class PommeVue extends NourritureVue {

    private final Pane pane;
    private final Pomme pomme;

    private static final Image pommeImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/aliments/apple.png");

    public PommeVue(Pomme pomme, Pane pane) {
        super(pomme,pane);
        this.pane = pane;
        this.pomme = pomme;
    }

    @Override
    public void creerSprite(){
        ImageView mainImage = new ImageView(pommeImage);
        mainImage.setFitWidth(pommeImage.getWidth());
        mainImage.setFitHeight(pommeImage.getHeight());
        mainImage.setId(pomme.getId());
        mainImage.setX(pomme.getPosition().getX());
        mainImage.setY(pomme.getPosition().getY());
        pane.getChildren().add(mainImage);
    }

}
