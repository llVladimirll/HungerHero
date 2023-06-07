package Aplikasi;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
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



public class loginPageController implements Initializable {

@FXML
private TextField tfEmail;

@FXML 
private PasswordField pfPassword;

@FXML
private void login(){
String Email = tfEmail.getText();
String Password = pfPassword.getText();

}

private boolean isValidLogin(String email, String password){
    try{
        File xmlFile = new File("Users.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbFactory.newDocumentBuilder();
        Document doc = db.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("user");
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                String storedEmail = element.getElementsByTagName("email").item(0).getTextContent();
                String storedPassword = element.getElementsByTagName("password").item(0).getTextContent();
                if(storedEmail.equals(email) && storedPassword.equals(password)){
                    return true;
                }
            }
        }
        
            }catch(Exception e){
                e.printStackTrace();
            }
            return false;
        }


    }


   

   

