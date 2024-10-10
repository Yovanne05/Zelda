package universite_paris8.iut.yponnou.zelda.modele.Environnements;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Map;


public class EntreeDonjon extends Environnement{
    public EntreeDonjon(Hero hero) {
        super(new Map(30, 30),hero);
        this.getMap().initialisationMapEntreeDonjon();
    }

    @Override
    public void creationEnvironnement() {
        getHero().changeEnvObjets(this);
        getHero().setEnvironnement(this);

        getHero().getDirection().setDx(0);
        getHero().getDirection().setDy(0);
        this.ajouterActeur(getHero());

    }
}
