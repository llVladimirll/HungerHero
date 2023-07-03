package Aplikasi.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Aplikasi.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProfileControl implements Initializable{

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
    Label lbName;

    public void setLoggedinUser(User user){ 
        lbName.setText(user.getName());
    }
    

        
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
