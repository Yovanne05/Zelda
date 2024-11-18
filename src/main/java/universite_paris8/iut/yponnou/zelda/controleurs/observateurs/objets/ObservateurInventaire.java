package universite_paris8.iut.yponnou.zelda.controleurs.observateurs.objets;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

import universite_paris8.iut.yponnou.zelda.modele.aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.armes.decorator.ArmePouvoir;
import universite_paris8.iut.yponnou.zelda.modele.objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.armes.ArcVue;
import universite_paris8.iut.yponnou.zelda.vue.armes.EpeeVue;
import universite_paris8.iut.yponnou.zelda.vue.objets.ClefVue;
import universite_paris8.iut.yponnou.zelda.vue.nourritures.PommeVue;

public class ObservateurInventaire extends ObservateurObjets {

    public ObservateurInventaire(HBox hBox) {
        super(hBox);
    }

    @Override
    public void onChanged(Change<?extends Objet> change) {
        Node node;
        while (change.next()) {
            for (Objet ob : change.getAddedSubList()) {
                if (ob instanceof Clef) {
                    ClefVue clefVue = new ClefVue(ob, getPane());
                    clefVue.creerSprite();
                    clefVue.resizeImage();
                }
                else if (ob instanceof Pomme) {
                    PommeVue pommeVue = new PommeVue((Pomme) ob, getPane());
                    pommeVue.creerSprite();
                    pommeVue.resizeImage();
                } else if (ob instanceof Arme) {
                    Arme arme = (Arme) ob;
                    Arme armeSousJacent = (arme instanceof ArmePouvoir)
                            ? ((ArmePouvoir) arme).getArmeSousJacent()
                            : arme;

                    if (armeSousJacent instanceof ArcArme) {
                        ArcVue arcVue = new ArcVue(arme, getPane());
                        arcVue.creerSprite();
                        arcVue.resizeImage();
                    } else if (armeSousJacent instanceof Epee) {
                        EpeeVue epeeVue = new EpeeVue(arme, getPane());
                        epeeVue.creerSprite();
                        epeeVue.resizeImage();
                    }
                }
            }
            for (Objet ob : change.getRemoved()) {
                for (int i = 0; i < getPane().getChildren().size(); i++) {
                    if (getPane().getChildren().get(i).getId().equals(ob.getId())) {
                        node = getPane().getChildren().get(i);
                        getPane().getChildren().remove(node);
                    }
                }
            }
        }
    }
}
