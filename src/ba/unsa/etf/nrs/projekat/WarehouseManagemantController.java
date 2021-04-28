package ba.unsa.etf.nrs.projekat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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

public class WarehouseManagemantController implements Initializable {


    public ListView listProducts;
    public TextField fldQuantity;
    public TextField fldBarCode;
    public ObservableList<Product> products = FXCollections.observableArrayList();
    private Product selectedProduct ;

    public void btnAddProduct(ActionEvent actionEvent) {
        if(fldBarCode.getText()!="" && fldQuantity.getText()!=""){
            //products.add(new Product(fldBarCode.getText(),Integer.parseInt(fldQuantity.getText())));
            addProduct(fldBarCode.getText(),Integer.parseInt(fldQuantity.getText()));
        }
        listProducts.refresh();
        fldBarCode.setText("");
        fldQuantity.setText("");
    }

    public void btnRemove(ActionEvent actionEvent) {
        if(fldQuantity.getText()!="") {
            deleteProductQuantity(Integer.parseInt(fldQuantity.getText()));
        }else {
            deleteProduct(selectedProduct);
        }
        listProducts.refresh();
    }

    private void deleteProductQuantity(int br){

        for(Product produkt : products){
            if(produkt.getSifra().equals(selectedProduct.getSifra())){
                if(produkt.getKolicina()>1 && br<produkt.getKolicina()) {
                    produkt.setKolicina(produkt.getKolicina() - br);
                }else deleteProduct(selectedProduct);
            }
        }

    }

    private void deleteProduct(Product produkt){
        products.removeIf(produkt::equals);
    }
    public void napuni(){
        this.products.add(new Product("123",20));
        this.products.add(new Product("121",50));
        this.products.add(new Product("000", 10));
        this.products.add(new Product("555",40));
        //selectedProduct.set(null);
    }

    public void addProduct(String a, int b){
       int temp=0;
        for(Product produkt : products){
            if(produkt.getSifra().equals(a)){
                produkt.setKolicina(produkt.getKolicina()+b);
                temp=1;
            }
        }
       if(temp!=1)
        products.add(new Product(a,b));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        napuni();

        listProducts.setItems(products);

        listProducts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selectedProduct = (Product) newValue;
            }
        });
    }
}
