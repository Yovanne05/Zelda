package universite_paris8.iut.yponnou.zelda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Lanceur extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(Objects.requireNonNull(getClass().getResource("/universite_paris8/iut/yponnou/zelda/Fonts/MedievalSharp/MedievalSharp-Regular.ttf")).toExternalForm(), 18);

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        StackPane root = (StackPane) scene.getRoot();
        root.requestFocus();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}