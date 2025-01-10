package universite_paris8.iut.yponnou.zelda.vue.pv;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CoeursVue {

    private final Pane pane;
    private int nbCoeursPlein;
    private int pvCoeurEndommage;

    public static Image coeur1 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/Coeurs/Heart-1.png");
    public static Image coeur2 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/Coeurs/Heart-2.png");
    public static Image coeur3 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/Coeurs/Heart-3.png");
    public static Image coeur4 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/Coeurs/Heart-4.png");
    public static Image coeur5 = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/vie/Coeurs/Heart-5.png");

    public CoeursVue(Pane pane) {
        this.pane = pane;
        this.nbCoeursPlein = 5;
        this.pvCoeurEndommage = 0;
        spritePv(nbCoeursPlein, pvCoeurEndommage);
    }

    public void spritePv(int nbCoeursPlein, int pvCoeurEndommage) {
        this.nbCoeursPlein = nbCoeursPlein;
        this.pvCoeurEndommage = pvCoeurEndommage;
        ImageView image;
        int nbCoeursVides;

        // on vide la hbox pour refaire un affichage
        pane.getChildren().clear();
        // gestion du nombre de coeurs pleins à créer
        for (int i = 0; i < this.nbCoeursPlein; i++){
            image = new ImageView(coeur1);
            pane.getChildren().add(image);
        }
        // si la santé n'est pas complète
        if (this.nbCoeursPlein != 5){
            if (this.pvCoeurEndommage == 0)
                image = new ImageView(coeur5);
            else if (this.pvCoeurEndommage < 6.67) {
                image = new ImageView(coeur4);
            }
            else if(this.pvCoeurEndommage < 13.33) {
                image = new ImageView(coeur3);
            }
            else {
                image = new ImageView(coeur2);
            }
            pane.getChildren().add(image);
        }

        // GESTION DU NOMBRE DE COEURS VIDES A CREER
        // plus de coeurs
        if (this.nbCoeursPlein == 0)
            nbCoeursVides = 4;  // on a déja créer un coeur vide dans le condition d'avant, donc on en met 4 de plus pour en faire 5
        // santé est pleine
        else if (this.nbCoeursPlein == 5)
            nbCoeursVides = 0;
            // santé toujours endommagé
        else
            nbCoeursVides = 5 - this.nbCoeursPlein - 1;
        for (int i = 0; i < nbCoeursVides; i++){
            image = new ImageView(coeur5);
            pane.getChildren().add(image);
        }
    }
}
