package universite_paris8.iut.yponnou.zelda.modele;

import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.yponnou.zelda.Position;
import universite_paris8.iut.yponnou.zelda.controleurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.*;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArmeMelee;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Aliments.Pomme;
import universite_paris8.iut.yponnou.zelda.vue.MapVue;
import universite_paris8.iut.yponnou.zelda.vue.Pv.BarreDeVieVue;
import universite_paris8.iut.yponnou.zelda.vue.Pv.CoeursVue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Village extends Environnement{
    private static int cpt=0;
    private Hero hero;
    private Paysan paysan;
    private Vendeur vendeur;
    private ArrayList<Garde> gardes;

    private long dernierTempsGeneration; // Variable pour suivre le dernier temps de génération de garde
    private final long intervalleGeneration = 10 * 1000; // Intervalle de génération en millisecondes

    public Village() {
        super(new Map(30, 30));
        gardes=new ArrayList<>();
        this.dernierTempsGeneration = System.currentTimeMillis();
    }

    public void creationVillage(){

        hero=new Hero(830,510,this,0,0,null);
        vendeur = new Vendeur(1400, 500, this, 0, 0);
        paysan = new Paysan(310,320,this,0,0);

        this.ajouterActeur(vendeur);
        this.ajouterActeur(paysan);
        this.ajouterActeur(hero);
    }

    // Méthode pour vérifier si le temps écoulé dépasse l'intervalle de génération
    private boolean tempsPourGenerer() {
        long tempsActuel = System.currentTimeMillis();
        return tempsActuel - this.dernierTempsGeneration >= intervalleGeneration;
    }

    public void generationGarde(){
        Garde g;
        Epee e=new Epee(1400,50,this);
        Epee e2=new Epee(300,780,this);
        //x=1400 y=50
        //x=300 et y=780
        if(cpt%2==0){
            g=new Garde(1400,50,this,1,0,e);
        }else {
            g=new Garde(300,780,this,0,1,e2);
        }
        this.ajouterActeur(g);
        gardes.add(g);
        cpt++;
        this.dernierTempsGeneration = System.currentTimeMillis();

    }


    @Override
    public void toutLeMondeBouge() {
        ObservableList<Acteur> lsta= this.getActeurs();
        for (int i=0;i<lsta.size();i++) {
            if (lsta.get(i) instanceof Ennemi) {
                ((Ennemi) lsta.get(i)).deplacementEnnemi();
            }
        }
        for (int i = 0; i < this.getProjectiles().size(); i++) {
            if (this.getProjectiles().get(i) instanceof Fleche) {
                System.out.println("Fleche");
                ((Fleche) this.getProjectiles().get(i)).utiliserFleche();
            }
        }
//        if (tempsPourGenerer()) {
//            generationGarde(); // Générer un garde
//        }
    }
}
