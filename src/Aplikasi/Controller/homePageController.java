package Aplikasi.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class homePageController implements Initializable{
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

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
    
}
