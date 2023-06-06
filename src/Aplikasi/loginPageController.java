package Aplikasi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.*;
import javafx.application.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class loginPageController implements Initializable {

    @FXML
    private VBox vbox1;
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    private int currentImageIndex = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView1 = new ImageView();
        imageView2 = new ImageView();

        imageView1.setImage(new Image(getClass().getResourceAsStream("login.jpg")));
        imageView2.setImage(new Image(getClass().getResourceAsStream("elaine-casap-qgHGDbbSNm8-unsplash.jpg")));
        vbox1.getChildren().addAll(imageView1, imageView2);

        // Start the slideshow
        startSlideshow();
    }

    public void startSlideshow() {
        Duration duration = Duration.seconds(3);

        // Create a Timeline for the slideshow animation
        Timeline timeline = new Timeline(
                new KeyFrame(duration, event -> showNextImage()));

        // Set the animation to repeat indefinitely
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Start the animation
        timeline.play();
    }

    private void showNextImage() {
        // Increment the current image index
        currentImageIndex++;

        // Determine the index of the next image to be displayed
        int nextImageIndex = currentImageIndex % 2;

        // Load the next image and update the appropriate ImageView
        if (nextImageIndex == 0) {
            imageView1.setImage(new Image(getClass().getResourceAsStream("image1.jpg")));
        } else {
            imageView2.setImage(new Image(getClass().getResourceAsStream("image2.jpg")));
        }
    }
}
