package universite_paris8.iut.yponnou.zelda.vue.Nourritures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Aliments.Pomme;

public class PommeVue extends NourritureVue {

    private final Pane pane;
    private final Pomme pomme;
    private final ImageView imageView;

    private static final Image pommeImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/aliments/apple.png");
    private static final Image pommeInventaire = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/aliments/pomme.png");

    public PommeVue(Pomme pomme, Pane pane) {
        super(pomme,pane);
        this.pane = pane;
        this.pomme = pomme;
        imageView = new ImageView(pommeImage);
    }

    @Override
    public void creerSprite(){
        imageView.setFitWidth(pommeImage.getWidth());
        imageView.setFitHeight(pommeImage.getHeight());
        imageView.setId(pomme.getId());
        imageView.setX(pomme.getPosition().getX());
        imageView.setY(pomme.getPosition().getY());
        pane.getChildren().add(imageView);
    }

    public void resizeImage(){
        if (imageView.getFitWidth() == pommeImage.getWidth() && imageView.getFitHeight() == pommeImage.getHeight()){
            imageView.setFitWidth(Constante.TAILLE50);
            imageView.setFitHeight(Constante.TAILLE50);
        }
        else {
            imageView.setFitWidth(pommeImage.getWidth());
            imageView.setFitHeight(pommeImage.getHeight());
        }
    }

}
