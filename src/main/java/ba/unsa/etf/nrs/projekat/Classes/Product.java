package ba.unsa.etf.nrs.projekat.Classes;

import ba.unsa.etf.nrs.projekat.Classes.Category;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty quantity;
    private SimpleIntegerProperty price;
    private SimpleDoubleProperty discount;
    private SimpleStringProperty barCode;
    private Category category;

    public Product() {
    }
    public Product(String name, int quantity, int price, double discount, String barCode, Category category) {
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.price = new SimpleIntegerProperty(price);
        this.discount = new SimpleDoubleProperty(discount);
        this.barCode = new SimpleStringProperty(barCode);
        this.category = category;
    }
    public Product(int id, String name, int quantity, int price, double discount, String barCode, Category category) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.price = new SimpleIntegerProperty(price);
        this.discount = new SimpleDoubleProperty(discount);
        this.barCode = new SimpleStringProperty(barCode);
        this.category = category;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getPrice() {
        return price.get();
    }

    public SimpleIntegerProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public double getDiscount() {
        return discount.get();
    }

    public SimpleDoubleProperty discountProperty() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount.set(discount);
    }

    public String getBarCode() {
        return barCode.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public SimpleStringProperty barCodeProperty() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode.set(barCode);
    }


    @Override
    public String toString() {
        return name.get() +"  "+ barCode.get()+"  "+ quantity.get();
    }
}
