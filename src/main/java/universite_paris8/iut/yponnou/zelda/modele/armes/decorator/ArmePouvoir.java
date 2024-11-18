package universite_paris8.iut.yponnou.zelda.modele.armes.decorator;

import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;

public abstract class ArmePouvoir extends Arme {

    /**
     * Classe abstraite représentant une arme avec un pouvoir spécial.
     * Elle sert de base pour les décorateurs d'armement qui ajoutent des bonus à une arme existante.
     */

    private final Arme arme;
    private final int degatsOrigine;

    public ArmePouvoir(Arme arme) {
        super(arme.getPosition().getX(), arme.getPosition().getY(), arme.getEnvironnement(), arme.getPtsDegats(), arme.getProprietaire(), arme.getPortee());
        this.arme = arme;
        this.degatsOrigine = arme.getPtsDegats();
    }

    public Arme getArme() {
        return arme;
    }

    protected void appliquerBonus(int bonus) {
       arme.setPtsDegats(degatsOrigine + bonus);
    }

    protected void reinitialiserDegats() {
        setPtsDegats(degatsOrigine);
    }

    public Arme getArmeSousJacent() {
        Arme armeActuelle = this;
        while (armeActuelle instanceof ArmePouvoir) {
            armeActuelle = ((ArmePouvoir) armeActuelle).getArme();
        }
        return armeActuelle;
    }
}
