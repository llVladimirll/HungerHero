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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class homePageController implements Initializable{
    XYChart.Series data = new XYChart.Series<>();
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

    @FXML
    private BarChart bcFood;



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
        data.getData().add(new XYChart.Data("January", 1050));
        data.getData().add(new XYChart.Data("February", 1030));
        data.getData().add(new XYChart.Data("March", 900));
        data.getData().add(new XYChart.Data("April", 1075));
        data.getData().add(new XYChart.Data("May", 1500));
        data.getData().add(new XYChart.Data("June", 900));
        data.getData().add(new XYChart.Data("July", 1200));
        data.getData().add(new XYChart.Data("August", 1000));
        data.getData().add(new XYChart.Data("September", 1000));
        


        bcFood.getData().addAll(data);
        
    }
    
}
