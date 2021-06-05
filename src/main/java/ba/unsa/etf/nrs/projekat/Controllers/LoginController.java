package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Controllers.CashierController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {
    public TextField adminUsername;
    public PasswordField adminPassword;


    String adminName = "admin";
    String adminPass = "admin";

    String cashierName = "kasir";
    String cashierPass = "kasir";

    String warehousemanName = "skladistar";
    String warehousemanPass = "skladistar";


    public void loginAdminAction(ActionEvent actionEvent) throws IOException {

        if((adminUsername.getText().equals(adminName) && adminPassword.getText().equals(adminPass))){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dobrodošli");
            alert.setHeaderText("Uspješno ste se registrovali");
            alert.setContentText("Uspješan login");
            alert.showAndWait();

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/managerPage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            primaryStage.show();
            Stage zatvori = (Stage) adminUsername.getScene().getWindow();
            zatvori.close();
        }

        else if(adminUsername.getText().equals(cashierName) && adminPassword.getText().equals(cashierPass)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dobrodošli");
            alert.setHeaderText("Uspješno ste se registrovali");
            alert.setContentText("Uspješan login");
            alert.showAndWait();


            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/newCashier.fxml"));
            CashierController ctrl = new CashierController();
            loader.setController(ctrl);
            Parent root = loader.load();
            primaryStage.setTitle("Kasir");
            primaryStage.setScene(new Scene(root, 850, 600));
            primaryStage.setResizable(false);
            primaryStage.show();
            Stage zatvori = (Stage) adminUsername.getScene().getWindow();
            zatvori.close();
        }

        else if((adminUsername.getText().equals(warehousemanName) && adminPassword.getText().equals(warehousemanPass))){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dobrodošli");
            alert.setHeaderText("Uspješno ste se registrovali");
            alert.setContentText("Uspješan login");
            alert.showAndWait();

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/warehousePage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            primaryStage.show();
            Stage zatvori = (Stage) adminUsername.getScene().getWindow();
            zatvori.close();
        }

        else{
            adminUsername.getStyleClass().remove("poljeIspravno");
            adminUsername.getStyleClass().add("poljeNijeIspravno");

            adminPassword.getStyleClass().remove("poljeIspravno");
            adminPassword.getStyleClass().add("poljeNijeIspravno");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Greška prilikom registracije");
            alert.setContentText("Neispravni podaci!");
            alert.showAndWait();
        }
    }





    public void aboutAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacije");

        alert.setResizable(true);

        alert.setHeaderText("POS KASA");
        alert.setContentText("Desktop aplikacija za POS kasu koja kao korisnike ima menadžere, kasire i skladištare. Cilj aplikacije je olakšati svakodnevni posao navedenim licima.");
        alert.showAndWait();
    }

    public void loginHelpAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacije");
        alert.setResizable(true);

        alert.setHeaderText("POS KASA");
        alert.setContentText("Da bi ste pristupili aplikaciji potrebno je da se prijavite sa vašim korisničkim podacima koje ste dobili od menadžera." +
                "Podatke upisujete u polja koja su vezana za vašu djelatnost");
        alert.showAndWait();
    }
}
