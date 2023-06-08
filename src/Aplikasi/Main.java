package Aplikasi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    
        FXMLLoader loader = new FXMLLoader((getClass().getResource("loginPage.fxml")));
        Parent root = loader.load();

        String css = this.getClass().getResource("Design.css").toExternalForm();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("hungerhero");
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }
}