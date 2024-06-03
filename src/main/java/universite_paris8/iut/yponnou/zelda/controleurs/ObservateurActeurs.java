package universite_paris8.iut.yponnou.zelda.controleurs;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObservateurActeurs extends Constante implements ListChangeListener<Acteur> {

    private Pane pane;

    private Image enemyImage;
    /////////////////////
    private Image playerup1;
    private Image playerup2;
    private Image playerright1;
    private Image playerright2;
    private Image playerleft1;
    private Image playerleft2;
    private Image playerdown1;
    private Image playerdown2;
    //////////////////////////
    public ObservateurActeurs(Pane pane) {
        this.pane = pane;
        enemyImage=new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/zombie.png");
        //player tout les angles
        playerup1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_up_1.gif");
        playerup2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_up_2.gif");
        playerright1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_right_1.gif");
        playerright2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_right_2.gif");
        playerleft1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_left_1.gif");
        playerleft2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_left_2.gif");
        playerdown1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_down_1.gif");
        playerdown2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_down_2.gif");


    }

    public void creerSprite(Acteur a) {
        ImageView imageView;
        if (a instanceof Hero) {
            imageView = new ImageView(playerdown1);
            System.out.println("zef");
        } else if (a instanceof Ennemi) {
            imageView = new ImageView(enemyImage);
            System.out.println("efzf");
        } else {
            throw new IllegalArgumentException("Acteur non supporté");
        }
        imageView.setFitWidth(TAILLECASEX);
        imageView.setFitHeight(TAILLECASEY);

        imageView.translateXProperty().bind(a.xProperty());
        imageView.translateYProperty().bind(a.yProperty());
        imageView.setId(a.getId());
        pane.getChildren().add(imageView);
    }

    public void upgradeSprite(Acteur a,boolean pas) {
        ImageView imageView;
        this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));
        if (a instanceof Hero) {
            imageView = new ImageView(getHeroImage(a.getDirection(),pas));
        } else if (a instanceof Ennemi) {
            imageView = new ImageView(getEnemyImage(a.getDirection()));
        } else {
            throw new IllegalArgumentException("Acteur non supporté");
        }
        imageView.setFitWidth(TAILLECASEX);
        imageView.setFitHeight(TAILLECASEY);

        imageView.translateXProperty().bind(a.xProperty());
        imageView.translateYProperty().bind(a.yProperty());
        imageView.setId(a.getId());
        pane.getChildren().add(imageView);
    }

    private Image getHeroImage(String direction,boolean pas) {
        switch (direction) {
            case "right":
                if(pas){
                    return playerright2;
                }
                return playerright1;
            case "left":
                if(pas){
                    return playerleft2;
                }
                return playerleft1;
            case "up":
                if(pas){
                    return playerup2;
                }
                return playerup1;
            default:
                if(pas){
                    return playerdown2;
                }
                return playerdown1;// Default image if direction is not set
        }
    }
    private Image getEnemyImage(String direction) {
        switch (direction) {
            case "right":
                return enemyImage;
            case "left":
                return enemyImage;
            case "down":
                return enemyImage;
            case "up":
                return enemyImage ;
            default:
                return enemyImage; // Default image if direction is not set
        }
    }

//    public void creerSprite(Acteur a) {
//        Rectangle r = new Rectangle(TAILLECASEX,TAILLECASEY);
//        if(a instanceof Hero){
//            r.setFill(Color.YELLOW);
//        }else if(a instanceof Ennemi){
//            r.setFill(Color.RED);
//        }
//        r.setId(a.getId());
//        r.translateXProperty().bind(a.xProperty());
//        r.translateYProperty().bind(a.yProperty());
//        pane.getChildren().add(r);
//    }


    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            for (Acteur a : change.getAddedSubList()) {
                creerSprite(a);
            }
            for (Acteur a : change.getRemoved()) {
                for (int i = 0; i < pane.getChildren().size(); i++) {
                    System.out.println(this.pane.lookup("#"+a.getId()));
                        this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));

                }
            }
        }
    }
}