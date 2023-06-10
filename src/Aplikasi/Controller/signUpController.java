package Aplikasi.Controller;

import Aplikasi.User;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

import java.io.File;
import java.io.IOException;

public class signUpController implements Initializable{

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPhoneNumber;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Button regButton;


    public void register(ActionEvent Event) throws IOException{
        String name = tfName.getText();
        String password = pfPassword.getText();
        String phoneNumber = tfPhoneNumber.getText();
        String email = tfEmail.getText();

        User user = new User(name, password, phoneNumber, email);

        storeUserInXML(user);


    }

    private void storeUserInXML(User user){
        try{
            File xmlFile = new File("/Aplikasi/Model/Users.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;

            if(xmlFile.exists()){
                doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();
            }
         else {
             doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("users");
                doc.appendChild(rootElement);
        }

        
        Element userElement = doc.createElement("user");

        
        Element usernameElement = doc.createElement("username");
        usernameElement.setTextContent(user.getEmail());
        userElement.appendChild(usernameElement);

       
        Element passwordElement = doc.createElement("password");
        passwordElement.setTextContent(user.getPassword());
        userElement.appendChild(passwordElement);

        
        doc.getDocumentElement().appendChild(userElement);

        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);

        System.out.println("User registered and stored in XML successfully.");
    }catch(Exception e){
        e.printStackTrace();
    }
    } 
    
        
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }


    
}
