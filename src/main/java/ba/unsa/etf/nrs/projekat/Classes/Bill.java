package ba.unsa.etf.nrs.projekat.Classes;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Bill {

    SimpleIntegerProperty id;
    SimpleIntegerProperty orderId;
    SimpleDoubleProperty total;
    SimpleIntegerProperty fiscalNumber;


    public Bill() {
    }

    public Bill(int id, int orderId, double total, int fiscalNumber) {
        this.id = new SimpleIntegerProperty(id);
        this.orderId = new SimpleIntegerProperty(orderId);
        this.total = new SimpleDoubleProperty(total);
        this.fiscalNumber = new SimpleIntegerProperty(fiscalNumber);
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

    public int getOrderId() {
        return orderId.get();
    }

    public SimpleIntegerProperty orderIdProperty() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId.set(orderId);
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
    }

    public int getFiscalNumber() {
        return fiscalNumber.get();
    }

    public SimpleIntegerProperty fiscalNumberProperty() {
        return fiscalNumber;
    }

    public void setFiscalNumber(int fiscalNumber) {
        this.fiscalNumber.set(fiscalNumber);
    }

    @Override
    public String toString() {
        return "id=" + id.getValue() + ", total=" + total.getValue() + ", fiscalNumber=" + fiscalNumber.getValue();
    }

}
