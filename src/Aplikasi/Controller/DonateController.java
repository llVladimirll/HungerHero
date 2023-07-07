package Aplikasi.Controller;

import Aplikasi.Model.Database;
import Aplikasi.Model.Donate;
import Aplikasi.Model.Donation;
import Aplikasi.Model.User;
import Aplikasi.Model.DonateItem;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DonateController implements Initializable {
    private User loggedinUser;
    @FXML
    private ChoiceBox cbPortion;
    @FXML
    private TableColumn<Donation, Integer> tAmount;

    @FXML
    private TableView<Donation> tableView;

    @FXML
    private TextField tfDonateAmount;

    @FXML
    private TextField FoodItem;

    @FXML
    private TableColumn<Donation, String> tFoodItem;

    private ObservableList<Donation> data;

    @FXML
    private Button btHome, btProfile, btHistory,profileButton;

    @FXML
    private Button btnDonate;

    @FXML
    private DatePicker calDonateDate;

    @FXML
    private TextField tfPickUp;

    @FXML
    public void donate() {
        String pickUp = tfPickUp.getText();
        LocalDate donateDate = calDonateDate.getValue();

        Donate donate = new Donate("", donateDate.toString(), 0, pickUp);

        storeDonateHistory(donate);

        // Clear the input fields
        FoodItem.clear();
        tfDonateAmount.clear();
        tfPickUp.clear();
        calDonateDate.setValue(LocalDate.now());
    }

    @FXML
private Button btExit;

// ...

@FXML
public void exitApplication() {
    System.exit(0);
}

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize table columns
        tFoodItem.setCellValueFactory(new PropertyValueFactory<>("foodItem"));
        tAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // Initialize data list
        data = FXCollections.observableArrayList();
        tableView.setItems(data);
        btExit.setOnAction(event -> exitApplication());
    }

    @FXML
    void actionDelete(ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableView.getItems().remove(selectedIndex);
        }
    }

    @FXML
    void actionAdd(ActionEvent event) {
        String foodItem = FoodItem.getText();
        String amount = tfDonateAmount.getText();
        int amount2 = Integer.parseInt(amount);

        if (!foodItem.isEmpty() && amount2 != 0) {
            Donation newDonation = new Donation(foodItem, amount2);
            data.add(newDonation);

            FoodItem.clear();
            tfDonateAmount.clear();
        }
    }

    private void storeDonateHistory(Donate donate) {
        try {
            File file = new File("src/Aplikasi/Model/DonateHistory.xml");
    
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;
    
            if (file.exists()) {
                doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
            } else {
                doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("donateHistory");
                doc.appendChild(rootElement);
            }
    
            Element historyElement = doc.createElement("History");
    
            Element donateDateElement = doc.createElement("donateDate");
            donateDateElement.setTextContent(donate.getDate());
            historyElement.appendChild(donateDateElement);
    
            Element pickUpElement = doc.createElement("location");
            pickUpElement.setTextContent(donate.getPickUp());
            historyElement.appendChild(pickUpElement);
    
            doc.getDocumentElement().appendChild(historyElement);
    
            // Add items from the table to XML
            if(!data.isEmpty()){
            for (Donation donation : data) {
                Element tableItemElement = doc.createElement("TableItem");
    
                Element tableFoodItemElement = doc.createElement("foodItem");
                tableFoodItemElement.setTextContent(tFoodItem.getCellData(donation));
                tableItemElement.appendChild(tableFoodItemElement);
    
                Element tableAmountElement = doc.createElement("amount");
                tableAmountElement.setTextContent(String.valueOf(tAmount.getCellData(donation)));
                tableItemElement.appendChild(tableAmountElement);
    
                historyElement.appendChild(tableItemElement);
            }
            }
            else{System.out.println("empty");}
    
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
    
    @FXML
    public void navigatetoprofileScreen(ActionEvent event) throws IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Aplikasi/View/profile.fxml"));
            Parent root = loader.load();
        
            ProfileControl profileController = loader.getController();
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

    @FXML
    public void goToHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Aplikasi/View/homePage.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) btHome.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void setLoggedInUser(User user) {
        this.loggedinUser = Database.getUserfromDatabase(user.getEmail());
    }

    @FXML
    public void navigateToProfileScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Aplikasi/View/profile.fxml"));
        Parent root = loader.load();

        ProfileControl profileController = loader.getController();
        if (loggedinUser != null) {
            String loggedInEmail = loggedinUser.getEmail();
            User user = Database.getUserfromDatabase(loggedinUser.getEmail());
            profileController.setLoggedinUser(user);
        }

        Stage stage = (Stage) btProfile.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToHistory() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Aplikasi/View/historyPage.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) btHistory.getScene().getWindow();
        stage.setScene(scene);
    }
}
