
package universite_paris8.iut.yponnou.zelda.vue.acteurs;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Paysan;

public class PaysanVue extends ActeurVue{

    private final Image paysansImage = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/acteurs/paysans.gif");
    public PaysanVue(Acteur actVue, Pane pane) {
        super(actVue, pane);
    }

    private Image getPaysansImage(String direction) {
        return switch (direction) {
            case "right" -> paysansImage;
            case "left" -> paysansImage;
            case "up" -> paysansImage;
            default -> paysansImage;// Default image if direction is not set
        };
    }

    @Override
    public void creerSprite() {
        ImageView imageView;
        if (getActeur() instanceof Paysan)
            imageView = new ImageView(paysansImage);
        /*else if (acteur instanceof Npc) {
            imageView = new ImageView(NPC);
            System.out.println("efzf");
        }*/
        else
            throw new IllegalArgumentException("Acteur non supporté");

        imageView.setFitWidth(Constante.TAILLE50);
        imageView.setFitHeight(Constante.TAILLE50);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }

    @Override
    public void upgradeSprite() {
        ImageView imageView;

        getPane().getChildren().remove(getPane().lookup("#"+getActeur().getId()));

        if (getActeur() instanceof Hero)
            imageView = new ImageView(getPaysansImage(getActeur().getDirection().directionString()));
        else
            throw new IllegalArgumentException("Acteur non supporté");
//        return imageView;
        imageView.setFitWidth(Constante.TAILLE50);
        imageView.setFitHeight(Constante.TAILLE50);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }

    public void parler() {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initStyle(StageStyle.TRANSPARENT);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 20px;");

        Label label = new Label("Bonjour, je suis un paysan de ce village. J'ai appris que votre frère a été capturé et que la clé se trouverait peut-être dans un royaume." +
                "\n La personne qui garde votre frère s'appelle M. Homps il me semble. Il aurait caché une clé dans un labyrinthe.");
        label.setTextFill(Color.WHITE);
        label.setFont(new Font(20));
        label.setMaxWidth(400); // Ajustez la largeur maximale selon vos besoins
        label.setAlignment(Pos.CENTER);
        label.setWrapText(true); // Active le retour à la ligne automatique

        root.getChildren().add(label);

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        popupStage.setScene(scene);
        popupStage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(10));
        delay.setOnFinished(event -> popupStage.close());
        delay.play();
    }
}
