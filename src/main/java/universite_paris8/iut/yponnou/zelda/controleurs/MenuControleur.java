package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import universite_paris8.iut.yponnou.zelda.Lanceur;

import java.io.IOException;

public class MenuControleur {

    @FXML
    public Button boutonLancer;

    @FXML
    private void lancementJeu() throws IOException {
        Stage oldStage, newStage;

        newStage = new Stage();
        oldStage = (Stage) boutonLancer.getScene().getWindow();
        oldStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("village.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        BorderPane root = (BorderPane) scene.getRoot();
        root.requestFocus();
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private void lancementHistoire() {
        // Code pour afficher l'histoire
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Histoire");
        alert.setHeaderText("L'histoire de La quête du Paysan");
        alert.setContentText("Voici l'histoire de notre vaillant paysan...");
        alert.showAndWait();
    }
}
