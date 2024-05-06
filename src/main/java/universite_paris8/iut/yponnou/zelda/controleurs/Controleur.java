package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.village.Monde;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Monde monde;
    @FXML
    private Pane pane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monde =new Monde(30,30);
        monde.creationMap();
        monde.afficheMonde(pane);
    }

}
