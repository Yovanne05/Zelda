
package universite_paris8.iut.yponnou.zelda.modele.Acteurs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import universite_paris8.iut.yponnou.zelda.modele.Environnements.Environnement;
import universite_paris8.iut.yponnou.zelda.modele.Armes.ArcArme;
import universite_paris8.iut.yponnou.zelda.modele.Armes.Epee;

public class Vendeur extends Acteur {

    public Vendeur(double x, double y, Environnement environnement, int dx, int dy) {
        super("Vendeur", x, y, 20, 0.03, environnement, dx, dy);
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

        Label contenue = new Label("Choisissez votre objet : ");
        contenue.setTextFill(Color.WHITE);

        vbox.getChildren().add(titre);
        vbox.getChildren().add(contenue);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        Button buttonArc = new Button("Arc");
        buttonArc.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-width: 2px;");
        buttonArc.setOnAction(e -> {
            hero.getInventaire().inventaireProperty().add(new ArcArme(this.getPosition().getX(), this.getPosition().getY(),null,this.getPosition().getEnv()));
            dialog.setResult(ButtonType.OK); //Pour fermer le pop up
            dialog.close();
        });

        Button buttonEpee = new Button("Épée");
        buttonEpee.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: #ffffff; -fx-border-width: 2px;");
        buttonEpee.setOnAction(e -> {
            hero.getInventaire().inventaireProperty().add(new Epee(this.getPosition().getX(),this.getPosition().getY(),this.getPosition().getEnv()));
            dialog.setResult(ButtonType.OK);
            dialog.close();
        });

        Button buttonAnnuler = new Button("Annuler");
        buttonAnnuler.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-width: 2px;");
        buttonAnnuler.setOnAction(e -> {
            dialog.setResult(ButtonType.CANCEL);
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
