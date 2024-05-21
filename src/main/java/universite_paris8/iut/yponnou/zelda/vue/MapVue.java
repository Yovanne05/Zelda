package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class MapVue extends Affichable {

    private Image floorImage;
    private Image murImage;

    private Image brickImage;
    private Image arbreImage;
    private List<Rectangle> obstaclesHitboxes;


    public MapVue(int[][] tab, TilePane tilePane) {
        super(tab, tilePane);
        floorImage = new Image("file:/home/etudiants/info/jmazur/IdeaProjects/Zelda/src/main/resources/universite_paris8/iut/yponnou/zelda/Images/grass.jpg");
        murImage = new Image("file:/home/etudiants/info/jmazur/IdeaProjects/Zelda/src/main/resources/universite_paris8/iut/yponnou/zelda/Images/mur.png");
        arbreImage = new Image("file:/home/etudiants/info/jmazur/IdeaProjects/Zelda/src/main/resources/universite_paris8/iut/yponnou/zelda/Images/arbre.png");
        brickImage = new Image("file:/home/etudiants/info/jmazur/IdeaProjects/Zelda/src/main/resources/universite_paris8/iut/yponnou/zelda/Images/brick.png");
        obstaclesHitboxes = new ArrayList<>();
    }

    public void creerSprite() {
        for (int y = 0; y < getTab().length; y++) {
            for (int x = 0; x < getTab()[y].length; x++) {
                ImageView imageView;
                if (getTab()[y][x] == 0) {
                    imageView = new ImageView(floorImage);
                } else if (getTab()[y][x] == 11) {
                    imageView = new ImageView(murImage);
                    Rectangle obstacle = new Rectangle(x * getTailleCaseX(), y * getTailleCaseY(), getTailleCaseX(), getTailleCaseY());
                    obstaclesHitboxes.add(obstacle);
                } else if (getTab()[y][x] == 12) {
                    imageView = new ImageView(arbreImage);
                    Rectangle obstacle = new Rectangle(x * getTailleCaseX(), y * getTailleCaseY(), getTailleCaseX(), getTailleCaseY());
                    obstaclesHitboxes.add(obstacle);
                } else if (getTab()[y][x] == 13) {
                    imageView = new ImageView(brickImage);
                    Rectangle obstacle = new Rectangle(x * getTailleCaseX(), y * getTailleCaseY(), getTailleCaseX(), getTailleCaseY());
                    obstaclesHitboxes.add(obstacle);
                } else {
                    continue; // Ignore other valuesz
                }

                imageView.setFitWidth(getTailleCaseX());
                imageView.setFitHeight(getTailleCaseY());
                imageView.setX(x * getTailleCaseX());
                imageView.setY(y * getTailleCaseY());
                getPane().getChildren().add(imageView);
            }
        }
    }

    public List<Rectangle> getObstacleHitboxes() {
        return obstaclesHitboxes;
    }
}
