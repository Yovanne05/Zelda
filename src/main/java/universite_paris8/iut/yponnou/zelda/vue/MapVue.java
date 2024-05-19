package universite_paris8.iut.yponnou.zelda.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class MapVue extends Affichable {

    private Image floorImage;
    private Image obstacleImage;
    private List<Rectangle> obstacleHitboxes;

    public MapVue(int[][] tab, TilePane tilePane) {
        super(tab, tilePane);
        floorImage = new Image("file:C:\\Users\\Mazur\\IdeaProjects\\Zelda\\src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\Images\\sol.jpg");
        obstacleImage = new Image("file:C:\\Users\\Mazur\\IdeaProjects\\Zelda\\src\\main\\resources\\universite_paris8\\iut\\yponnou\\zelda\\Images\\mur.png");
        obstacleHitboxes = new ArrayList<>();
    }

    public void creerSprite() {
        for (int y = 0; y < getTab().length; y++) {
            for (int x = 0; x < getTab()[y].length; x++) {
                ImageView imageView;
                if (getTab()[y][x] == 0) {
                    imageView = new ImageView(floorImage);
                } else if (getTab()[y][x] == 1) {
                    imageView = new ImageView(obstacleImage);
                    Rectangle obstacleHitbox = new Rectangle(x * getTailleCaseX(), y * getTailleCaseY(), getTailleCaseX(), getTailleCaseY());
                    obstacleHitboxes.add(obstacleHitbox);
                } else {
                    continue; // Ignore other values
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
        return obstacleHitboxes;
    }
}
