package universite_paris8.iut.yponnou.zelda.vue.objets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;

public class ClefVue extends ObjetVue{

    private final ImageView imageView;

    private Image clefImage16x16 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/clefs/clef-16x16.gif");
    private Image clefImage50x50 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/clefs/clef-50x50.png");

    public ClefVue(Objet objet, Pane pane) {
        super(objet, pane);
        imageView = new ImageView(clefImage16x16);
    }

    @Override
    public void creerSprite(){
        imageView.setFitWidth(clefImage16x16.getWidth());
        imageView.setFitHeight(clefImage16x16.getHeight());
        imageView.setId(getObjet().getId());
        imageView.setX(getObjet().getPosition().getX());
        imageView.setY(getObjet().getPosition().getY());
        getPane().getChildren().add(imageView);
    }

    public void resizeImage(){
        imageView.setImage(clefImage50x50);
        imageView.setFitWidth(clefImage50x50.getWidth());
        imageView.setFitHeight(clefImage50x50.getHeight());
    }
}
