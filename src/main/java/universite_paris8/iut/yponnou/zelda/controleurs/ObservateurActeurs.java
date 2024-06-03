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
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Npc;

public class ObservateurActeurs extends Constante implements ListChangeListener<Acteur> {

    private Pane pane;
    private Image NPC;

    private Image enemyImage;
    /////////////////////
    private Image playerup;
    private Image playerright;
    private Image playerleft;
    private Image playerdown;

    //////////////////////////
    public ObservateurActeurs(Pane pane) {
        this.pane = pane;
        NPC=new Image(("file:/home/etudiants/info/jmazur/IdeaProjects/Zelda/src/main/resources/universite_paris8/iut/yponnou/zelda/player/NPC.gif"));
        enemyImage=new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/zombie.png");
        //player tout les angles
        playerup = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_up.gif");
        playerright = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_right.gif");
        playerleft = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_left.gif");
        playerdown = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/player/player_down.gif");


    }

    public void creerSprite(Acteur a) {
        ImageView imageView;
        if (a instanceof Hero) {
            imageView = new ImageView(playerdown);
            System.out.println("zef");
        } else if (a instanceof Ennemi) {
            imageView = new ImageView(enemyImage);
            System.out.println("efzf");
        } else if (a instanceof Npc) {
            imageView = new ImageView(NPC);
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

    public void upgradeSprite(Acteur a ) {
        ImageView imageView;
        this.pane.getChildren().remove(this.pane.lookup("#"+a.getId()));
        if (a instanceof Hero) {
            imageView = new ImageView(getHeroImage(a.getDirection()));
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

    private Image getHeroImage(String direction) {
        switch (direction) {
            case "right":
                return playerright;
            case "left":
                return playerleft;
            case "up":
                return playerup;
            default:
                return playerdown;// Default image if direction is not set
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