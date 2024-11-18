package universite_paris8.iut.yponnou.zelda.vue.pv;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Boss;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Ennemi;


public class BarreDeVieVue {

    private final Pane pane;
    private int nbPortionPleine;
    private final Ennemi e;

    private final Image barreVieVertGarde1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-1.png");
    private final Image barreVieVertGarde2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-2.png");
    private final Image barreVieVertGarde3 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-3.png");
    private final Image barreVieVertGarde4 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-4.png");
    private final Image barreVieVertGarde5 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-5.png");
    private final Image barreVieVertGarde6 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-6.png");
    private final Image barreVieVertGarde7 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-7.png");
    private final Image barreVieVertGarde8 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-8.png");

    private final Image barreVieVertNivSup1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvVert-1.png");
    private final Image barreVieVertNivSup2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvVert-2.png");
    private final Image barreVieVertNivSup3 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvVert-3.png");
    private final Image barreVieVertNivSup4 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvVert-4.png");
    private final Image barreVieVertNivSup5 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvVert-5.png");
    private final Image barreVieVertNivSup6 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvVert-6.png");
    private final Image barreVieVertNivSup7 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvVert-7.png");
    private final Image barreVieVertNivSup8 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvVert-8.png");

    private final Image barreVieJauneNivSup1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvJaune-1.png");
    private final Image barreVieJauneNivSup2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvJaune-2.png");
    private final Image barreVieJauneNivSup3 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvJaune-3.png");
    private final Image barreVieJauneNivSup4 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvJaune-4.png");
    private final Image barreVieJauneNivSup5 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvJaune-5.png");
    private final Image barreVieJauneNivSup6 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvJaune-6.png");
    private final Image barreVieJauneNivSup7 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvJaune-7.png");
    private final Image barreVieJauneNivSup8 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvJaune-8.png");

    private final Image barreVieRougeNivSup1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvRouge-1.png");
    private final Image barreVieRougeNivSup2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvRouge-2.png");
    private final Image barreVieRougeNivSup3 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvRouge-3.png");
    private final Image barreVieRougeNivSup4 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvRouge-4.png");
    private final Image barreVieRougeNivSup5 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvRouge-5.png");
    private final Image barreVieRougeNivSup6 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvRouge-6.png");
    private final Image barreVieRougeNivSup7 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvRouge-7.png");
    private final Image barreVieRougeNivSup8 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/bdvRouge-8.png");


    public BarreDeVieVue(Ennemi ennemi, Pane pane) {
        this.pane = pane;
        e = ennemi;
        if (e instanceof Garde)
            this.nbPortionPleine = 8;
        if (e instanceof Chevalier)
            this.nbPortionPleine = 16;
        if (e instanceof Boss)
            this.nbPortionPleine = 24;
        spritePv(nbPortionPleine);
    }

    public void spritePv(int nbPortionPleine) {
        this.nbPortionPleine=nbPortionPleine;
        ImageView image;

        // on vide la hbox pour refaire un affichage
        pane.getChildren().remove(pane.lookup('#'+e.getId()+"BarreVie"));
        // gestion de la santé

        if (e instanceof Garde) {
            if (this.nbPortionPleine > 7)
                image = new ImageView(barreVieVertGarde1);
            else if (this.nbPortionPleine > 6)
                image = new ImageView(barreVieVertGarde2);
            else if (this.nbPortionPleine > 5)
                image = new ImageView(barreVieVertGarde3);
            else if (this.nbPortionPleine > 4)
                image = new ImageView(barreVieVertGarde4);
            else if (this.nbPortionPleine > 3)
                image = new ImageView(barreVieVertGarde5);
            else if (this.nbPortionPleine > 2)
                image = new ImageView(barreVieVertGarde6);
            else if (this.nbPortionPleine > 1)
                image = new ImageView(barreVieVertGarde7);
            else
                image = new ImageView(barreVieVertGarde8);
        }
        else if (e instanceof Chevalier) {
            if (this.nbPortionPleine > 15)
                image = new ImageView(barreVieJauneNivSup1);
            else if (this.nbPortionPleine > 14)
                image = new ImageView(barreVieJauneNivSup2);
            else if (this.nbPortionPleine > 13)
                image = new ImageView(barreVieJauneNivSup3);
            else if (this.nbPortionPleine > 12)
                image = new ImageView(barreVieJauneNivSup4);
            else if (this.nbPortionPleine > 11)
                image = new ImageView(barreVieJauneNivSup5);
            else if (this.nbPortionPleine > 10)
                image = new ImageView(barreVieJauneNivSup6);
            else if (this.nbPortionPleine > 9)
                image = new ImageView(barreVieJauneNivSup7);
            else if (this.nbPortionPleine > 8)
                image = new ImageView(barreVieJauneNivSup8);
            else if (this.nbPortionPleine > 7)
                image = new ImageView(barreVieVertNivSup1);
            else if (this.nbPortionPleine > 6)
                image = new ImageView(barreVieVertNivSup2);
            else if (this.nbPortionPleine > 5)
                image = new ImageView(barreVieVertNivSup3);
            else if (this.nbPortionPleine > 4)
                image = new ImageView(barreVieVertNivSup4);
            else if (this.nbPortionPleine > 3)
                image = new ImageView(barreVieVertNivSup5);
            else if (this.nbPortionPleine > 2)
                image = new ImageView(barreVieVertNivSup6);
            else if (this.nbPortionPleine > 1)
                image = new ImageView(barreVieVertNivSup7);
            else
                image = new ImageView(barreVieVertNivSup8);
        }
        else {
            if (this.nbPortionPleine > 23)
                image = new ImageView(barreVieRougeNivSup1);
            else if (this.nbPortionPleine > 22)
                image = new ImageView(barreVieRougeNivSup2);
            else if (this.nbPortionPleine > 21)
                image = new ImageView(barreVieRougeNivSup3);
            else if (this.nbPortionPleine > 20)
                image = new ImageView(barreVieRougeNivSup4);
            else if (this.nbPortionPleine > 19)
                image = new ImageView(barreVieRougeNivSup5);
            else if (this.nbPortionPleine > 18)
                image = new ImageView(barreVieRougeNivSup6);
            else if (this.nbPortionPleine > 17)
                image = new ImageView(barreVieRougeNivSup7);
            else if (this.nbPortionPleine > 16)
                image = new ImageView(barreVieRougeNivSup8);
            else if (this.nbPortionPleine > 15)
                image = new ImageView(barreVieJauneNivSup1);
            else if (this.nbPortionPleine > 14)
                image = new ImageView(barreVieJauneNivSup2);
            else if (this.nbPortionPleine > 13)
                image = new ImageView(barreVieJauneNivSup3);
            else if (this.nbPortionPleine > 12)
                image = new ImageView(barreVieJauneNivSup4);
            else if (this.nbPortionPleine > 11)
                image = new ImageView(barreVieJauneNivSup5);
            else if (this.nbPortionPleine > 10)
                image = new ImageView(barreVieJauneNivSup6);
            else if (this.nbPortionPleine > 9)
                image = new ImageView(barreVieJauneNivSup7);
            else if (this.nbPortionPleine > 8)
                image = new ImageView(barreVieJauneNivSup8);
            else if (this.nbPortionPleine > 7)
                image = new ImageView(barreVieVertNivSup1);
            else if (this.nbPortionPleine > 6)
                image = new ImageView(barreVieVertNivSup2);
            else if (this.nbPortionPleine > 5)
                image = new ImageView(barreVieVertNivSup3);
            else if (this.nbPortionPleine > 4)
                image = new ImageView(barreVieVertNivSup4);
            else if (this.nbPortionPleine > 3)
                image = new ImageView(barreVieVertNivSup5);
            else if (this.nbPortionPleine > 2)
                image = new ImageView(barreVieVertNivSup6);
            else if (this.nbPortionPleine > 1)
                image = new ImageView(barreVieVertNivSup7);
            else
                image = new ImageView(barreVieVertNivSup8);
        }
        image.setId(e.getId()+"BarreVie");
        image.translateXProperty().bind(e.getPosition().xProperty());
        image.translateYProperty().bind(e.getPosition().yProperty().subtract(8));
        pane.getChildren().add(image);
    }
}
