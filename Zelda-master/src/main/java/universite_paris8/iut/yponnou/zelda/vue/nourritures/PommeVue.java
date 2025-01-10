package universite_paris8.iut.yponnou.zelda.vue.nourritures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.aliments.Pomme;

public class PommeVue extends NourritureVue {

    private final ImageView imageView;

    private static final Image pommeImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/aliments/apple.png");
    private static final Image pommeInventaire = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/aliments/pomme.png");

    public PommeVue(Pomme pomme, Pane pane) {
        super(pomme,pane);
        imageView = new ImageView(pommeImage);
    }

    @Override
    public void creerSprite(){
        imageView.setFitWidth(pommeImage.getWidth());
        imageView.setFitHeight(pommeImage.getHeight());
        imageView.setId(getObjet().getId());
        imageView.setX(getObjet().getPosition().getX());
        imageView.setY(getObjet().getPosition().getY());
        getPane().getChildren().add(imageView);
    }

    public void resizeImage(){
        if (imageView.getFitWidth() == pommeImage.getWidth() && imageView.getFitHeight() == pommeImage.getHeight()){
            imageView.setFitWidth(Constante.TAILLE50);
            imageView.setFitHeight(Constante.TAILLE50);
        }
//        else {
//            imageView.setFitWidth(pommeImage.getWidth());
//            imageView.setFitHeight(pommeImage.getHeight());
//        }
    }

}
