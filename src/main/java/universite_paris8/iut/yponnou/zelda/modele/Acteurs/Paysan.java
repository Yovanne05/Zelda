package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.Constante;
import universite_paris8.iut.yponnou.zelda.modele.Environnement;

public class Paysan extends Acteur {
    public Paysan(double x, double y, Environnement environnement, int dx, int dy) {
        super("Paysan", x, y, 20, 0.03, environnement, dx, dy);
    }
    public void parler() {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initStyle(StageStyle.TRANSPARENT);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 20px;");

        Label label = new Label("Bonjour, je suis un paysan de ce village. J'ai appris que votre frère a été capturé et que la clé se trouverait peut-être dans un royaume." +
                "\n Le gardien qui garde votre frère s'appelle M. Homps il me semble. Il aurait cacher une clé dans l'une des maison.");
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
