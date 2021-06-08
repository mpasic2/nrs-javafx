package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Product;
import ba.unsa.etf.nrs.projekat.PosDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ProductManagementController implements Initializable {

    public Button btnBackProduct;
    public ListView productList;
    public TextField productNameFld;
    public TextField quantityFld;
    public TextField priceFld;
    public TextField categoryFld;
    public TextField discountFld;
    public TextField barCodeFld;
    public TextField discDiscountFld;
    public TextField discCategoryFld;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ObservableList<Product> products = PosDAO.getInstance().getProducts();
            productList.setItems(products.sorted());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void backAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/managerPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        Stage zatvori = (Stage) btnBackProduct.getScene().getWindow();
        zatvori.close();
    }



    public void changeBtn(ActionEvent actionEvent) {
    }

    public void addBtn(ActionEvent actionEvent) {

    }

    public void removeDiscount(ActionEvent actionEvent) {
    }

    public void setDiscount(ActionEvent actionEvent) {
    }


}
