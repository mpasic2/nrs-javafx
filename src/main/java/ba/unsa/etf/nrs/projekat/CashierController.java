package ba.unsa.etf.nrs.projekat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class CashierController implements Initializable {
    public TextField fldBarCode;
    public TextField fldQuantity;
    public ListView listProducts;

    public ObservableList<Product> products = FXCollections.observableArrayList();
    private Product selectedProduct ;

    public void napuni(){
        this.products.add(new Product("123",20));
        this.products.add(new Product("121",50));
        this.products.add(new Product("000", 10));
        this.products.add(new Product("555",40));
        //selectedProduct.set(null);
    }



    public void btnAddProduct(ActionEvent actionEvent) {



        if(fldBarCode.getText()!="" && fldQuantity.getText()!=""){
            //products.add(new Product(fldBarCode.getText(),Integer.parseInt(fldQuantity.getText())));
            addProduct(fldBarCode.getText(),Integer.parseInt(fldQuantity.getText()));
        }
        listProducts.refresh();
    }

    public void addProduct(String a, int b){
        products.add(new Product(a,b));
    }

    public void btnRemove(ActionEvent actionEvent) {

        deleteProduct(selectedProduct);
        listProducts.refresh();
    }

    private void deleteProduct(Product produkt){
        products.removeIf(produkt::equals);
    }

    private Product getProduct(int br){
        return products.get(br - 1);
    }

    public void btnCheckout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Racun");
        alert.setHeaderText("Racun kreiran");
        alert.setContentText("Uspješno kreiran račun");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // napuni();

        listProducts.setItems(products);

        listProducts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selectedProduct = (Product) newValue;
            }
        });

    }
}
