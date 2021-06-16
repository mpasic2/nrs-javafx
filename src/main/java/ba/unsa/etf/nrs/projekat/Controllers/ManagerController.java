package ba.unsa.etf.nrs.projekat.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ManagerController {


    public Button btnBackUser;
    public Button btnProducts;
    public Button btnPos;
    public Button btnUsers;
    public Button btnReport;



    public void posState(ActionEvent actionEvent) {
    }

    public void creteReport(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/generateRecord.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) btnPos.getScene().getWindow();
        zatvori.close();
    }


    public void productManagement(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/productManagement.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setTitle("Upravljanje proizvodima");
        primaryStage.show();
        Stage zatvori = (Stage) btnPos.getScene().getWindow();
        zatvori.close();
    }

    public void actionManagement(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/actionManagement.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) btnPos.getScene().getWindow();
        zatvori.close();
    }

    public void userManagement(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/userManagement.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setTitle("Upravljanje uposlenicima");
        primaryStage.show();
        Stage zatvori = (Stage) btnPos.getScene().getWindow();
        zatvori.close();
    }



    public void helpWindow(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacije");

        alert.setResizable(true);

        alert.setHeaderText("POS KASA");
        alert.setContentText("Desktop aplikacija za POS kasu koja kao korisnike ima menadžere, kasire i skladištare. Cilj aplikacije je olakšati svakodnevni posao navedenim licima.");
        alert.showAndWait();
    }

    public void backAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) btnPos.getScene().getWindow();
        zatvori.close();
    }

    public void deleteEmply(ActionEvent actionEvent) throws IOException {
        Stage noviProzor = new Stage();
        Parent roditelj = FXMLLoader.load(getClass().getResource("/fxml/deleteUsers.fxml"));
        noviProzor.setTitle("Brisanje uposlenika");
        Scene scene = new Scene(roditelj, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        noviProzor.setScene(scene);
        noviProzor.show();

        Stage zatvaranjePoruka = (Stage) btnPos.getScene().getWindow();
        zatvaranjePoruka.close();

    }
}
