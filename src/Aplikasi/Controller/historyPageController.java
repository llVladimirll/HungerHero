package Aplikasi.Controller;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.IOException;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import Aplikasi.Model.Database;
import Aplikasi.Model.MyData;
import Aplikasi.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class historyPageController implements Initializable {
    @FXML
    private TableView<MyData> table;

    @FXML
    private TableColumn<MyData, Double> amountColumn;

    @FXML
    private TableColumn<MyData, String> dateColumn;

    @FXML
    private TableColumn<MyData, String> itemColumn;

    @FXML
    private TableColumn<MyData, String> unitColumn;
    @FXML
    private Button profileButton, DonationButton, btExit,btHome;

    @FXML
    public void exitApplication() {
        System.exit(0);
    }
     @FXML
    public void goToHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Aplikasi/View/homePage.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) btHome.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void Donation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Aplikasi/View/donatePage.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) DonationButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void navigatetoprofileScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Aplikasi/View/profile.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) profileButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Load XML file
            File xmlFile = new File("src/Aplikasi/Model/DonateHistory.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Load items from the XML file
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("item");

            // Display data in the table
            ObservableList<MyData> data = FXCollections.observableArrayList();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Double amount = Double.parseDouble(element.getElementsByTagName("amount").item(0).getTextContent());
                    String date = element.getElementsByTagName("date").item(0).getTextContent();
                    String item = element.getElementsByTagName("item").item(0).getTextContent();
                    String unit = element.getElementsByTagName("unit").item(0).getTextContent();
                    data.add(new MyData(amount, date, item, unit));
                }
            }

            // Set up table columns and bind data to the table view
            amountColumn.setCellValueFactory(new PropertyValueFactory<MyData, Double>("amount"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<MyData, String>("date"));
            itemColumn.setCellValueFactory(new PropertyValueFactory<MyData, String>("item"));
            unitColumn.setCellValueFactory(new PropertyValueFactory<MyData, String>("unit"));
            table.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
