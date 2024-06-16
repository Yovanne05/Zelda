package universite_paris8.iut.yponnou.zelda.modele.Environnements;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Map;

public class EntreeDonjon extends Environnement{
    public EntreeDonjon(Hero hero) {
        super(new Map(30, 30),hero);
        this.getMap().initialisationMapEntreeDonjon();
    }

    @Override
    public void creationEnvironnement() {
        getHero().changeEnvArc(this);
        getHero().getPosition().setEnv(this);

        getHero().setDx(0);
        getHero().setDy(0);
        this.ajouterActeur(getHero());

    }
@Override
    public void entree() {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initStyle(StageStyle.TRANSPARENT);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 20px;");

        Label label = new Label("Vous n'avez pas la clé pour rentrer dans le Donjon de Mr.Homps .");
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

        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(event -> popupStage.close());
        delay.play();
    }
}
