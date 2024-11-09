package universite_paris8.iut.yponnou.zelda.modele.action;

import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;

public class AttaqueNormal implements Action{
    @Override
    public void executer(Hero hero) {
        hero.attaquer();
    }
}