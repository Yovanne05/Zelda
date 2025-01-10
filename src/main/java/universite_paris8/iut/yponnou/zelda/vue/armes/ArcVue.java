package universite_paris8.iut.yponnou.zelda.vue.armes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.objets.ObjetVue;

public class ArcVue extends ObjetVue {

    private final ImageView imageView;

    private final Image arcImage32x32 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/arc-32x32.png");
    private final Image arcImage50x50 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/arc-50x50.png");

    public ArcVue(Objet objet, Pane pane) {
        super(objet, pane);
        this.imageView = new ImageView(arcImage32x32);
    }

    @Override
    public void creerSprite(){
        imageView.setFitWidth(arcImage32x32.getWidth());
        imageView.setFitHeight(arcImage32x32.getHeight());
        imageView.setId(getObjet().getId());
        imageView.setX(getObjet().getPosition().getX());
        imageView.setY(getObjet().getPosition().getY());
        getPane().getChildren().add(imageView);
    }

    public void resizeImage(){
        imageView.setImage(arcImage50x50);
        imageView.setFitWidth(arcImage50x50.getWidth());
        imageView.setFitHeight(arcImage50x50.getHeight());
    }
}
