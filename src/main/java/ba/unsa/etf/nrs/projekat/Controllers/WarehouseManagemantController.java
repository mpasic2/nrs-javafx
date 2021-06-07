package ba.unsa.etf.nrs.projekat.Controllers;

import ba.unsa.etf.nrs.projekat.Classes.Category;
import ba.unsa.etf.nrs.projekat.Classes.Product;
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
import javafx.scene.control.TextInputDialog;

public class WarehouseManagemantController implements Initializable {


    public ListView listProducts;
    public TextField fldQuantity;
    public TextField fldBarCode;
    public static ObservableList<Product> products = FXCollections.observableArrayList();
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

        deleteProduct(selectedProduct);
        listProducts.refresh();
    }

    private void deleteProductQuantity(int br){

        for(Product produkt : products){
            if(produkt.getBarCode().equals(selectedProduct.getBarCode())){
                if(produkt.getQuantity()>1 && br<produkt.getQuantity()) {
                    produkt.setQuantity(produkt.getQuantity() - br);
                }else deleteProduct(selectedProduct);
            }
        }

    }
    private void addProductQuantity(int br){

        for(Product produkt : products)
            if(produkt.getBarCode().equals(selectedProduct.getBarCode()))
                    produkt.setQuantity(produkt.getQuantity() + br);

    }

    private void deleteProduct(Product produkt){
        products.removeIf(produkt::equals);
    }
    public void napuni(){
        /*Category category = new Category(1,"categoriy");
        this.products.add(new Product("Jabuke",20,2,1,"0",category));
        this.products.add(new Product("Kruske",50,2,1,"0",category));
        this.products.add(new Product("Banane", 10,2,1,"0",category));
        this.products.add(new Product("Kasike",40,2,1,"0",category));
        this.products.add(new Product("Ubrusi",40,2,1,"0",category));
        this.products.add(new Product("Laptop",40,2,1,"0",category));
        this.products.add(new Product("Parfem",40,2,1,"0",category));
        this.products.add(new Product("Knjiga",40,2,1,"0",category));*/
        //selectedProduct.set(null);
    }

    public void addProduct(String a, int b){
       /*int temp=0;
        for(Product produkt : products){
            if(produkt.getSifra().equals(a)){
                produkt.setKolicina(produkt.getKolicina()+b);
                temp=1;
            }
        }
       if(temp!=1)
        products.add(new Product(a,b));*/
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

    public void btnChangeQ(ActionEvent actionEvent) {
        TextInputDialog txtInput = new TextInputDialog();
        txtInput.setHeaderText("Unesite kolicinu za koju zelite \nsmanjiti trenutnu kolicinu artikla! ");
        txtInput.showAndWait();


        String produkt = String.valueOf(listProducts.getSelectionModel().getSelectedItem());
        String kolicina = produkt.split(" ")[1];


        //kolicina proizvoda              unesena kolicina
        if(Integer.parseInt(kolicina) < Integer.parseInt(txtInput.getEditor().getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greska");
            alert.setHeaderText("Pogresni podaci");
            alert.setContentText("Nije moguce obrisati vecu kolicinu od trenutne kolicine proizvoda");
            alert.showAndWait();

        }

        else {

            deleteProductQuantity(Integer.parseInt(txtInput.getEditor().getText()));
            listProducts.refresh();
        }


    }

    public void btnAdd(ActionEvent actionEvent) {
        TextInputDialog txtInput = new TextInputDialog();
        txtInput.setHeaderText("Unesite kolicinu koju zelite dodati \nna kolicinu trenutnog artikla! ");
        txtInput.showAndWait();


        String produkt = String.valueOf(listProducts.getSelectionModel().getSelectedItem());
        String kolicina = produkt.split(" ")[1];

        addProductQuantity(Integer.parseInt(txtInput.getEditor().getText()));
        listProducts.refresh();



    }



}
