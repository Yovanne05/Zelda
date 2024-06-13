package universite_paris8.iut.yponnou.zelda.modele;

import javafx.collections.ObservableList;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;


public class Village extends Environnement{
    private Hero hero;
    private Paysan paysan;
    private Vendeur vendeur;


    public Village() {
        super(new Map(30, 30));
        this.getMap().initialisationMapVillage();
    }

    public void creationVillage(){

        hero=new Hero(830,510,this,0,0,null);
        vendeur = new Vendeur(1400, 500, this, 0, 0);
        paysan = new Paysan(310,320,this,0,0);

        this.ajouterActeur(vendeur);
        this.ajouterActeur(paysan);
        this.ajouterActeur(hero);
    }
}
