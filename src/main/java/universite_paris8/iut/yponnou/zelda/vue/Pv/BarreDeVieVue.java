package universite_paris8.iut.yponnou.zelda.vue.Pv;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Ennemi;

public class BarreDeVieVue extends PvVue {

    private final int nbPortionPleine;
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

    public BarreDeVieVue(Ennemi ennemi, int nbPortionPleine, Pane pane) {
        super(pane);
        this.nbPortionPleine = nbPortionPleine;
        e = ennemi;
    }


    @Override
    public void spritePv() {
        ImageView image;

        // on vide la hbox pour refaire un affichage
        getPane().getChildren().remove(getPane().lookup('#'+e.getId()+"BarreVie"));
        // gestion de la santé
        if (nbPortionPleine > 7)
            image = new ImageView(barreVieVert1);
        else if (nbPortionPleine > 6)
            image = new ImageView(barreVieVert2);
        else if (nbPortionPleine > 5)
            image = new ImageView(barreVieVert3);
        else if (nbPortionPleine > 4)
            image = new ImageView(barreVieVert4);
        else if (nbPortionPleine > 3)
            image = new ImageView(barreVieVert5);
        else if (nbPortionPleine > 2)
            image = new ImageView(barreVieVert6);
        else if (nbPortionPleine > 1)
            image = new ImageView(barreVieVert7);
        else
            image = new ImageView(barreVieVert8);

        image.setX(0);
        image.setY(e.getPosition().getY()-8);
        image.setId(e.getId()+"BarreVie");
        image.translateXProperty().bind(e.getPosition().xProperty());
        image.translateYProperty().addListener((observable, oldValue, newValue) -> image.setY(e.getPosition().getY()-8));
        getPane().getChildren().add(image);
    }
}
