package universite_paris8.iut.yponnou.zelda.vue.Pv;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;

public class BarreDeVieVue {

    private final Pane pane;
    private int nbPortionPleine;
    private final Ennemi e;

    private final Image barreVieVert1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-1.png");
    private final Image barreVieVert2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-2.png");
    private final Image barreVieVert3 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-3.png");
    private final Image barreVieVert4 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-4.png");
    private final Image barreVieVert5 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-5.png");
    private final Image barreVieVert6 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-6.png");
    private final Image barreVieVert7 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-7.png");
    private final Image barreVieVert8 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-8.png");
    private final Image barreVieVert9 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/BarreDeVie/BarreDeVie-9.png");

    public BarreDeVieVue(Ennemi ennemi, Pane pane) {
        this.pane = pane;
        e = ennemi;
        this.nbPortionPleine = 8;
        spritePv(nbPortionPleine);
    }

    public void spritePv(int nbPortionPleine) {
        this.nbPortionPleine=nbPortionPleine;
        ImageView image;

        // on vide la hbox pour refaire un affichage
        pane.getChildren().remove(pane.lookup('#'+e.getId()+"BarreVie"));
        // gestion de la santé
        if (this.nbPortionPleine > 7)
            image = new ImageView(barreVieVert1);
        else if (this.nbPortionPleine > 6)
            image = new ImageView(barreVieVert2);
        else if (this.nbPortionPleine > 5)
            image = new ImageView(barreVieVert3);
        else if (this.nbPortionPleine > 4)
            image = new ImageView(barreVieVert4);
        else if (this.nbPortionPleine > 3)
            image = new ImageView(barreVieVert5);
        else if (this.nbPortionPleine > 2)
            image = new ImageView(barreVieVert6);
        else if (this.nbPortionPleine > 1)
            image = new ImageView(barreVieVert7);
        else
            image = new ImageView(barreVieVert8);

        image.setId(e.getId()+"BarreVie");
        image.translateXProperty().bind(e.getPosition().xProperty());
        image.translateYProperty().bind(e.getPosition().yProperty().subtract(8));
        pane.getChildren().add(image);
    }
}
