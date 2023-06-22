package Aplikasi.Controller;

import Aplikasi.Donate;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DonateController implements Initializable {
    @FXML
    private Button btnDonate;

    @FXML
    private TextField tfFoodItem;

    @FXML
    private TextField tfDonateAmount;

    @FXML
    private Calendar calDonateDate;

    @FXML
    private TextField tfPickUp;



    @FXML
    public void donate(){
        String foodItem = tfFoodItem.getText();
        String donateAmount = tfDonateAmount.getText();
        int amount = Integer.parseInt(donateAmount);
        String pickUp = tfPickUp.getText();
        String donateDate = calDonateDate.getTime().toString();

        
        Donate donate = new Donate(foodItem, amount, donateDate, pickUp);


        storeDonateHistory(donate);
    }

    private void storeDonateHistory(Donate donate){
        try {
            File file = new File("src/Aplikasi/Model/DonateHistory.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;

            if(file.exists()){
                doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
            }
            else{
                doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("donateHistory");
                doc.appendChild(rootElement);
            }

            Element historyElement = doc.createElement("History");

            Element foodItemElement = doc.createElement("foodItem");
            foodItemElement.setTextContent(donate.getFoodItem());
            foodItemElement.appendChild(foodItemElement);

            Element donateAmountElement = doc.createElement("donateAmount");
            donateAmountElement.setTextContent(String.valueOf(donate.getAmount()));
            donateAmountElement.appendChild(donateAmountElement);

            Element donateDateElement = doc.createElement("donateDate");
            donateDateElement.setTextContent(donate.getDate());
            donateDateElement.appendChild(donateDateElement);

            Element pickUpElement = doc.createElement("location");
            pickUpElement.setTextContent(donate.getPickUpLocation());
            pickUpElement.appendChild(pickUpElement);

            doc.getDocumentElement().appendChild(historyElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(source, streamResult);
            
            System.out.print("Donate Added!!!");



            


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }
    
}
