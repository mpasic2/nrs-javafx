package ba.unsa.etf.nrs.projekat;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    public TextField adminUsername;
    public PasswordField adminPassword;

    public TextField cashierUsername;
    public PasswordField cashierPassword;

    public TextField warehousemanUsername;
    public PasswordField warehousemanPassword;

    String adminName = "admin";
    String adminPass = "admin";

    String cashierName = "kasir";
    String cashierPass = "kasir";

    String warehousemanName = "skladistar";
    String warehousemanPass = "skladistar";


    public void loginAdminAction(ActionEvent actionEvent) {

        if(adminUsername.getText().equals(adminName) && adminPassword.getText().equals(adminPass)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dobrodošli");
            alert.setHeaderText("Uspješno ste se registrovali");
            alert.setContentText("Uspješan login");
            alert.showAndWait();
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

    public void loginCashierAction(ActionEvent actionEvent) {
        if(cashierUsername.getText().equals(cashierName) && cashierPassword.getText().equals(cashierPass)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dobrodošli");
            alert.setHeaderText("Uspješno ste se registrovali");
            alert.setContentText("Uspješan login");
            alert.showAndWait();
        }

        else{
            cashierUsername.getStyleClass().remove("poljeIspravno");
            cashierUsername.getStyleClass().add("poljeNijeIspravno");

            cashierPassword.getStyleClass().remove("poljeIspravno");
            cashierPassword.getStyleClass().add("poljeNijeIspravno");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Greška prilikom registracije");
            alert.setContentText("Neispravni podaci!");
            alert.showAndWait();
        }
    }

    public void loginWarehousemanAction(ActionEvent actionEvent) {
        if(warehousemanUsername.getText().equals(warehousemanName) && warehousemanPassword.getText().equals(warehousemanPass)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dobrodošli");
            alert.setHeaderText("Uspješno ste se registrovali");
            alert.setContentText("Uspješan login");
            alert.showAndWait();
        }

        else{
            warehousemanUsername.getStyleClass().remove("poljeIspravno");
            warehousemanUsername.getStyleClass().add("poljeNijeIspravno");

            warehousemanPassword.getStyleClass().remove("poljeIspravno");
            warehousemanPassword.getStyleClass().add("poljeNijeIspravno");

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
        alert.setHeaderText("POS KASA");
        alert.setContentText("Desktop aplikacija za administratore, kasire i skladištare");
        alert.showAndWait();
    }
}
