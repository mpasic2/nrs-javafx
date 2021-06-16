package ba.unsa.etf.nrs.projekat.Classes;

import com.google.gson.annotations.SerializedName;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BillDTO {
    @SerializedName("id")
    int id;
    @SerializedName("orderId")
    int orderId;
    @SerializedName("total")
    double total;
    @SerializedName("fiscalNumber")
    int fiscalNumber;

    public BillDTO(int id, int orderId, double total, int fiscalNumber) {
        this.id = id;
        this.orderId = orderId;
        this.total = total;
        this.fiscalNumber = fiscalNumber;
    }
}
