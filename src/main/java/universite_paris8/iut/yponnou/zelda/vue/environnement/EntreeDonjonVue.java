package universite_paris8.iut.yponnou.zelda.vue.environnement;

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

public class EntreeDonjonVue {

    public void entree(){
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
