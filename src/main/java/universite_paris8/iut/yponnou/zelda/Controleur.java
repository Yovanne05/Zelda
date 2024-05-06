package universite_paris8.iut.yponnou.zelda;

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
        afficheMonde();
    }

    public void afficheMonde(){
        int[][] tab=monde.getTab();
        for(int i=0;i<tab.length;i++){
            for (int j=0;j<tab[i].length;j++){
                Rectangle rectangle = new Rectangle(50,50);
                rectangle.setX(i*50);
                rectangle.setY(j*50);
                if(tab[i][j]==1){
                    rectangle.setFill(Color.BLACK);
                }
                else{
                    rectangle.setFill(Color.RED);
                }
                pane.getChildren().add(rectangle);
            }
        }
    }

}
