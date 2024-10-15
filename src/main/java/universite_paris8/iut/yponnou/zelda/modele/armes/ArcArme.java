package universite_paris8.iut.yponnou.zelda.modele.armes;


import universite_paris8.iut.yponnou.zelda.modele.environnements.Environnement;

public class ArcArme extends ArmeDistance {


    public ArcArme(double posxi, double posyi, Projectile projectile, Environnement environnement) {
        super(posxi, posyi, projectile, environnement);
    }

    @Override
    public int utiliser() {
        Fleche f = (Fleche) this.getProjectile();
        this.getEnvironnement().ajouterActeur(f);
        f.utiliserFleche();
        return this.getProjectile().getPtsDegats();
    }

    public String nom(){
        return "Arc";
    }



}