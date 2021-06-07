package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Employee;
import ba.unsa.etf.nrs.projekat.Classes.User;
import ba.unsa.etf.nrs.projekat.Controllers.CashierController;
import ba.unsa.etf.nrs.projekat.PosDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

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

    public int checkLogin(String username, String password) throws IOException, ParseException {
        //metoda vraca -1 ako username ne postoji
        //metoda vraca 0 ako user postoji ali je sifra pogresna
        //metoda vraca 1 ako je user kasir
        //metoda vraca 2 ako je user menadzer
        //metoda vraca 3 ako je user skladistar
        int out = -1;

        //role 1 je kasir, role 2 je menadzer, role 3 je skladistar

        ObservableList<Employee> employees;
        employees= PosDAO.getInstance().dajZaposlene();

        ObservableList<User> users;
        users = PosDAO.getInstance().dajUsere();

        for(int i=0;i<employees.size();i++){
            for(int j=0;j<users.size();j++){
                if(employees.get(i).getUserId()==users.get(j).getId()){
                    //nasli smo usera za zaposelnog
                    if(users.get(j).getUsername().equals(username)){
                        if(users.get(j).getPassword().equals(password)){
                            if(employees.get(i).getRole()==1) out=1;
                            else if(employees.get(i).getRole()==2) out=2;
                            else out=3;

                        }


                    }

                }
            }
        }

    return out;

    }


    public void loginAdminAction(ActionEvent actionEvent) throws IOException, ParseException {
        int user = checkLogin(adminUsername.getText(), adminPassword.getText());

        if(user==2){
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

        else if(user==1){
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

        else if(user==3){
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
