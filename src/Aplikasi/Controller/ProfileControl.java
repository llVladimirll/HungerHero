package Aplikasi.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Aplikasi.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProfileControl implements Initializable {

    private User loggedinUser;

    Image homeImage = new Image("/Aplikasi/image/home-3.png");
    ImageView imageView1 = new ImageView(homeImage);
    Image profileImage = new Image("/Aplikasi/image/profile.png");
    ImageView imageView2 = new ImageView(profileImage);
    Image historyImage = new Image("/Aplikasi/image/history.png");
    ImageView imageView3 = new ImageView(historyImage);
    Image logoutImage = new Image("/Aplikasi/image/logout.png");
    ImageView imageView4 = new ImageView(logoutImage);
    Image donateImage = new Image("/Aplikasi/image/donate.png");
    ImageView imageView5 = new ImageView(donateImage);

    @FXML
    Label lbName, lbEmail, lbPhoneNumber, lbAdress;

    @FXML
    private Button btHome, btDonate, btHistory, btExit;

    @FXML
    public void exitApplication() {
        System.exit(0);
    }

    public void setLoggedinUser(User user) {
        lbName.setText(user.getName());
        lbEmail.setText(user.getEmail());
        lbPhoneNumber.setText(user.getPhoneNumber());
        lbAdress.setText(user.getAddress());

    }

    @FXML
    public void goToHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Aplikasi/View/homePage.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) btHome.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void gotoDonate() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Aplikasi/View/donatePage.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) btDonate.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void goToHistory() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Aplikasi/View/historyPage.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) btHistory.getScene().getWindow();
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
