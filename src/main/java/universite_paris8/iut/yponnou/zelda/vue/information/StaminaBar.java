package universite_paris8.iut.yponnou.zelda.vue.information;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;

public class StaminaBar {
    private HBox container;
    private Rectangle bar;
    private Hero hero;

    public StaminaBar(Hero hero) {
        this.hero = hero;
        this.container = new HBox();

        // Définition du style du conteneur avec padding et autres propriétés CSS
        this.container.setStyle("-fx-padding: 10px; -fx-background-color: rgba(0, 0, 0, 0.5); -fx-border-radius: 5;");

        // Création de la barre de stamina avec couleur verte
        this.bar = new Rectangle(200, 20, Color.GREEN);

        // Définir la taille de la barre de stamina et ajouter une bordure
        this.bar.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        // Ajout de la barre de stamina au conteneur
        this.container.getChildren().add(this.bar);

        // Binding de la largeur de la barre à la stamina de l'héro
        this.bar.widthProperty().bind(hero.staminaProperty().multiply(2)); // 2 pour une échelle de 200px max

        // Définir la taille minimale du conteneur pour contrôler la position de la barre de stamina
        this.container.setMinSize(220, 40); // Taille minimale du conteneur

        // Déplacer le conteneur 50 pixels en dessous
        this.container.translateYProperty().set(50); // Décalage vertical de 50 pixels
    }

    // Getter pour obtenir le conteneur de la barre de stamina
    public HBox getContainer() {
        return container;
    }
}