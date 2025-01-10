package universite_paris8.iut.yponnou.zelda.vue.armes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.objets.ObjetVue;

public class EpeeVue extends ObjetVue {

    private final ImageView imageView;

    private final Image sword32x32 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/armes/sword.png");

    public EpeeVue(Objet objet, Pane pane) {
        super(objet, pane);
        this.imageView = new ImageView(sword32x32);
    }

    @Override
    public void creerSprite(){
        imageView.setFitWidth(sword32x32.getWidth());
        imageView.setFitHeight(sword32x32.getHeight());
        imageView.setId(getObjet().getId());
        imageView.setX(getObjet().getPosition().getX());
        imageView.setY(getObjet().getPosition().getY());
        getPane().getChildren().add(imageView);
    }

    public void resizeImage(){
        imageView.setFitWidth(Constante.TAILLE50);
        imageView.setFitHeight(Constante.TAILLE50);
    }
}
