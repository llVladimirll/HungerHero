package Aplikasi.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Aplikasi.Database;
import Aplikasi.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class homePageController implements Initializable{
    private User loggedinUser;

    @FXML
    private Button profileButton;

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



    public void setLoggedInUser(User user) {
        this.loggedinUser = Database.getUserfromDatabase(user.getEmail());
    }

    public void navigatetoprofileScreen(ActionEvent event) throws IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Aplikasi/View/profile.fxml"));
            Parent root = loader.load();
        
            ProfileController profileController = loader.getController();
            if (loggedinUser != null) {
                String loggedInEmail = loggedinUser.getEmail();
                User user = Database.getUserfromDatabase(loggedinUser.getEmail());
                profileController.setLoggedinUser(user);
            }
        
            Stage stage = (Stage) profileButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
    
}
