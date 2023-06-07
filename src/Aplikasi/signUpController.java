package Aplikasi;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

public class signUpController implements Initializable{

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPhoneNumber;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField pfPassword;



    public void register(){
        String name = tfName.getText();
        String password = pfPassword.getText();
        String phoneNumber = tfPhoneNumber.getText();
        String email = tfEmail.getText();

        User user = new User(name, password, phoneNumber, email);

        storeUserInXML(user);

    }

    private void storeUserInXML(User user){
        try{
            File xmlFile = new File("Users.xml");
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
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }


    
}
