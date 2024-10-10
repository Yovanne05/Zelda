package universite_paris8.iut.yponnou.zelda.controleurs.observateurs.objets;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

import universite_paris8.iut.yponnou.zelda.modele.aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.objets.Clef;
import universite_paris8.iut.yponnou.zelda.modele.objets.Objet;
import universite_paris8.iut.yponnou.zelda.vue.armes_vue.ArcVue;
import universite_paris8.iut.yponnou.zelda.vue.armes_vue.EpeeVue;
import universite_paris8.iut.yponnou.zelda.vue.objets_vue.ClefVue;
import universite_paris8.iut.yponnou.zelda.vue.nourritures_vue.PommeVue;

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
                }
                else if(ob instanceof ArcArme){
                    ArcVue arcVue = new ArcVue(ob, getPane());
                    arcVue.creerSprite();
                    arcVue.resizeImage();
                }
                else if (ob instanceof Epee) {
                    EpeeVue epeeVue = new EpeeVue(ob,getPane());
                    epeeVue.creerSprite();
                    epeeVue.resizeImage();
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
