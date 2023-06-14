package Aplikasi.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Aplikasi.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ProfileController implements Initializable{

    private User loggedinUser;

    @FXML
    Label lbName;

    public void setLoggedinUser(User user){ 
        lbName.setText(user.getName());
    }
    

        
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
