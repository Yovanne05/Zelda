
package universite_paris8.iut.yponnou.zelda.modele.Environnements;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.yponnou.zelda.controleurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Garde;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Paysan;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.modele.Map;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Clef;
import universite_paris8.iut.yponnou.zelda.vue.Acteurs.HeroVue;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;
import universite_paris8.iut.yponnou.zelda.vue.Pv.BarreDeVieVue;
import universite_paris8.iut.yponnou.zelda.vue.Pv.CoeursVue;

public class Village extends Environnement {

    private TilePane tilePaneDecors;
    private Hero hero;
    private Garde garde;
    private Paysan paysans;
    private Pane paneObjets;
    private Pane paneMap;
    private Pane paneCoeurs;
    private HBox hboxInventaire;
    private HeroVue heroVue;

    public Village(Map map, TilePane tilePaneDecors, Pane paneObjets, Pane paneMap, Pane paneCoeurs, HBox hboxInventaire, HeroVue heroVue) {
        super(map);
        map.initialisationMap();
        this.tilePaneDecors=tilePaneDecors;
        this.paneObjets=paneObjets;
        this.paneMap=paneMap;
        this.paneCoeurs=paneCoeurs;
        this.hboxInventaire=hboxInventaire;
        this.heroVue=heroVue;
        this.creationVillage();
    }

    public void creationVillage(){
        MapVue tileMap = new MapVue(getMap().getTabNum(), tilePaneDecors);

        ArcArme a =new ArcArme(400, 400,null,this);
        Epee e= new Epee(400,500,this);
        Clef c = new Clef("Porte1",500,1000,this);

        hero=new Hero(400,400,this,0,0,a);
        garde=new Garde(400,500,0.03,this,0,1,e);
        paysans = new Paysan(800, 400, 120, this, 0, 1);



        Pomme objet1 = new Pomme(605, 500, this);
        Pomme objet2 = new Pomme(700, 500, this);
        Pomme objet3 = new Pomme(700, 400, this);
        Pomme objet4 = new Pomme(750, 400, this);
        Pomme objet5 = new Pomme(820, 400, this);
        Pomme objet6 = new Pomme(500, 400, this);

        this.objetsProperty().addListener(new ObservateurObjets(paneObjets));
        this.acteursProperty().addListener( new ObservateurActeurs(paneMap));
        this.getProjectiles().addListener(new ObservateurProjectiles(paneMap));

        hero.pvProperty().addListener(new ObservateurCoeurs(paneCoeurs,new CoeursVue(paneCoeurs)));
        hero.getInventaire().addListener(new ObservateurInventaire(hboxInventaire));

        heroVue = new HeroVue(hero,paneMap);

        garde.pvProperty().addListener(new ObservateurBarreDeVie(garde,paneMap, new BarreDeVieVue(garde,paneMap)));

        this.ajouterActeur(garde);
        this.ajouterObjet(objet1);
        this.ajouterObjet(objet2);
        this.ajouterObjet(objet3);
        this.ajouterObjet(objet4);
        this.ajouterObjet(objet5);
        this.ajouterObjet(objet6);
        this.ajouterObjet(c);
        this.ajouterActeur(hero);
        this.ajouterActeur(paysans);

        tileMap.creerSprite();
    }

    public Hero heroEnv(){
        return hero;
    }

    public HeroVue getHeroVue(){
        return heroVue;
    }

    @Override
    public void toutLeMondeBouge() {
        for (Acteur a : this.getActeurs()) {
            if (a instanceof Garde) {
                ((Garde) a).deplacementEnRonde();
            }
        }
        for (int i = 0; i < this.getProjectiles().size(); i++) {
            if (this.getProjectiles().get(i) instanceof Fleche) {
//                System.out.println("Fleche");
                ((Fleche) this.getProjectiles().get(i)).utiliserFleche();
            }
        }
    }
}
