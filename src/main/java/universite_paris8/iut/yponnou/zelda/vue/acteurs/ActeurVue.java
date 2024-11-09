package universite_paris8.iut.yponnou.zelda.vue.acteurs;

import javafx.scene.layout.Pane;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;

public abstract class ActeurVue {

    private final Pane pane;
    private final Acteur acteur;

    public ActeurVue(Acteur actVue, Pane pane) {
        this.pane = pane;
        this.acteur = actVue;
    }

    public Pane getPane() {
        return pane;
    }
    public Acteur getActeur() {
        return acteur;
    }

    public abstract void creerSprite();
    public abstract void upgradeSprite();
}