package Aplikasi.Model;

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
    
        FXMLLoader loader = new FXMLLoader((getClass().getResource("/Aplikasi/View/signUp.fxml")));
        Parent root = loader.load();
        


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HungerHero");
        primaryStage.show();
    }
}