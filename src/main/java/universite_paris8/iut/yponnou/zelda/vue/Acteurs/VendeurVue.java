
package universite_paris8.iut.yponnou.zelda.vue.Acteurs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.Acteurs.Vendeur;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.Objets.Objet;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

public class VendeurVue extends ActeurVue {

    private final Image vendeurVue = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/acteurs/vendeur.png");

    public VendeurVue(Acteur actVue, Pane pane) {
        super(actVue, pane);
    }

    private Image getVendeurVue(String direction) {
        return switch (direction) {
            case "right" -> vendeurVue;
            case "left" -> vendeurVue;
            case "down" -> vendeurVue;
            case "up" -> vendeurVue;
            default -> vendeurVue; // Default image if direction is not set
        };
    }

    @Override
    public void creerSprite() {
        ImageView imageView /* = upgradeSprite(acteur)*/;

        if (getActeur() instanceof Vendeur)
            imageView = new ImageView(vendeurVue);
        /*else if (acteur instanceof Npc) {
            imageView = new ImageView(NPC);
            System.out.println("efzf");
        }*/
        else
            throw new IllegalArgumentException("Acteur non supporté");

        imageView.setFitWidth(70);
        imageView.setFitHeight(70);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }

    @Override
    public void upgradeSprite() {
        ImageView imageView;

        getPane().getChildren().remove(getPane().lookup("#"+getActeur().getId()));

        if (getActeur() instanceof Vendeur)
            imageView = new ImageView(getVendeurVue(getActeur().getDirection().directionString()));
        else
            throw new IllegalArgumentException("Acteur non supporté");
//        return imageView;
        imageView.setFitWidth(TAILLE50);
        imageView.setFitHeight(TAILLE50);

        imageView.translateXProperty().bind(getActeur().getPosition().xProperty());
        imageView.translateYProperty().bind(getActeur().getPosition().yProperty());
        imageView.setId(getActeur().getId());
        getPane().getChildren().add(imageView);
    }

    public void proposerObjet(Hero hero) {
        Dialog<ButtonType> dialog = new Dialog<>();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));

        BackgroundFill backgroundFill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        vbox.setBackground(new Background(backgroundFill));

        Label titre = new Label("Le vendeur vous propose un objet gratuitement");
        titre.setTextFill(Color.WHITE);

        Label contenu = new Label("Choisissez votre objet : ");
        contenu.setTextFill(Color.WHITE);

        vbox.getChildren().add(titre);
        vbox.getChildren().add(contenu);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        Button buttonArc = new Button("Arc");
        buttonArc.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-width: 2px;");
        buttonArc.setOnAction(e -> {
            hero.ajouterObjet(new ArcArme(this.getActeur().getPosition().getX(), this.getActeur().getPosition().getY(),null,this.getActeur().getPosition().getEnv()));
            dialog.setResult(ButtonType.OK); // Fermer la fenêtre de dialogue
            dialog.close();
        });

        Button buttonEpee = new Button("Épée");
        buttonEpee.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: #ffffff; -fx-border-width: 2px;");
        buttonEpee.setOnAction(e -> {
            hero.ajouterObjet(new Epee(this.getActeur().getPosition().getX(), this.getActeur().getPosition().getY(),this.getActeur().getPosition().getEnv()));
            dialog.setResult(ButtonType.OK); // Fermer la fenêtre de dialogue
            dialog.close();
        });

        Button buttonAnnuler = new Button("Annuler");
        buttonAnnuler.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-width: 2px;");
        buttonAnnuler.setOnAction(e -> {
            dialog.setResult(ButtonType.CANCEL); // Annuler l'action
            dialog.close();
        });

        buttonBox.getChildren().addAll(buttonArc, buttonEpee, buttonAnnuler);

        vbox.getChildren().add(buttonBox);

        dialog.getDialogPane().setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        dialog.getDialogPane().setContent(vbox);

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        dialog.showAndWait();
    }
}
