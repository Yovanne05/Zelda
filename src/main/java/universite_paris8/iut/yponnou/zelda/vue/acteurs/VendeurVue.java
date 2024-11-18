package universite_paris8.iut.yponnou.zelda.vue.acteurs;

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
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Acteur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Hero;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.Vendeur;
import universite_paris8.iut.yponnou.zelda.modele.acteurs.informaion.Direction;
import universite_paris8.iut.yponnou.zelda.modele.armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.armes.Arme;
import universite_paris8.iut.yponnou.zelda.modele.armes.Epee;
import universite_paris8.iut.yponnou.zelda.modele.armes.Fleche;
import universite_paris8.iut.yponnou.zelda.modele.armes.decorator.ArmeDistanceFeu;
import universite_paris8.iut.yponnou.zelda.modele.armes.decorator.ArmeMeleeFeu;

import static universite_paris8.iut.yponnou.zelda.modele.utilitaire.Constante.TAILLE50;

public class VendeurVue extends ActeurVue {

    private final Image vendeurVue = new Image("file:src/main/resources/universite_paris8/iut/yponnou/zelda/Images/acteurs/vendeur.png");

    public VendeurVue(Acteur actVue, Pane pane) {
        super(actVue, pane);
    }

    private Image getVendeurVue(String direction) {
        return switch (direction) {
            case "right", "left", "down", "up" -> vendeurVue;
            default -> vendeurVue;
        };
    }

    @Override
    public void creerSprite() {
        ImageView imageView;

        if (getActeur() instanceof Vendeur)
            imageView = new ImageView(vendeurVue);
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

        getPane().getChildren().remove(getPane().lookup("#" + getActeur().getId()));

        if (getActeur() instanceof Vendeur)
            imageView = new ImageView(getVendeurVue(getActeur().getDirection().directionString()));
        else
            throw new IllegalArgumentException("Acteur non supporté");

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

        vbox.getChildren().addAll(titre, contenu);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);



        Button buttonArc = new Button("Arc");
        buttonArc.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-width: 2px;");
        buttonArc.setOnAction(e -> {
            Direction d = new Direction(this.getActeur().getDirection().getDx(), this.getActeur().getDirection().getDy());
            Fleche fleche = new Fleche(this.getActeur().getPosition().getX(), this.getActeur().getPosition().getY(), this.getActeur().getEnvironnement(), d);
            hero.getInventaire().ajouterObjet(new ArcArme(this.getActeur().getPosition().getX(), this.getActeur().getPosition().getY(), fleche, this.getActeur().getEnvironnement(),this.getActeur().getEnvironnement().getHero()));
            dialog.setResult(ButtonType.OK);
            dialog.close();
        });

        Button buttonEpee = new Button("Épée");
        buttonEpee.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-width: 2px;");
        buttonEpee.setOnAction(e -> {
            hero.getInventaire().ajouterObjet(new Epee(this.getActeur().getPosition().getX(), this.getActeur().getPosition().getY(), this.getActeur().getEnvironnement(),this.getActeur().getEnvironnement().getHero(), 80));
            dialog.setResult(ButtonType.OK);
            dialog.close();
        });

        Button buttonEpeeFeu = new Button("Épée en Feu");
        buttonEpeeFeu.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-width: 2px;");
        buttonEpeeFeu.setOnAction(e -> {
            Arme epee = new Epee(this.getActeur().getPosition().getX(), this.getActeur().getPosition().getY(), this.getActeur().getEnvironnement(),this.getActeur().getEnvironnement().getHero(), 80);
            epee = new ArmeMeleeFeu((Epee)epee);
            hero.getInventaire().ajouterObjet(epee);
            dialog.setResult(ButtonType.OK);
            dialog.close();
        });

        Button buttonArcFeu = new Button("Arc en Feu");
        buttonArcFeu.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-width: 2px;");
        buttonArcFeu.setOnAction(e -> {
            Direction d = new Direction(this.getActeur().getDirection().getDx(), this.getActeur().getDirection().getDy());
            Fleche fleche = new Fleche(this.getActeur().getPosition().getX(), this.getActeur().getPosition().getY(), this.getActeur().getEnvironnement(), d);
            Arme arc = new ArcArme(this.getActeur().getPosition().getX(), this.getActeur().getPosition().getY(), fleche, this.getActeur().getEnvironnement(),this.getActeur().getEnvironnement().getHero());
            arc = new ArmeDistanceFeu((ArcArme) arc);
            hero.getInventaire().ajouterObjet(arc);
            dialog.setResult(ButtonType.OK);
            dialog.close();
        });

        Button buttonAnnuler = new Button("Annuler");
        buttonAnnuler.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-width: 2px;");
        buttonAnnuler.setOnAction(e -> {
            dialog.setResult(ButtonType.CANCEL);
            dialog.close();
        });

        buttonBox.getChildren().addAll(buttonArc, buttonEpee, buttonEpeeFeu, buttonArcFeu, buttonAnnuler);
        vbox.getChildren().add(buttonBox);

        dialog.getDialogPane().setContent(vbox);

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        dialog.showAndWait();
    }
}
