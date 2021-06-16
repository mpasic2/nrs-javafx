package ba.unsa.etf.nrs.projekat.Classes;

import com.google.gson.annotations.SerializedName;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class EmployeeSerial {
    @SerializedName("id")
    int id;

    @SerializedName("userId")
    int userId;

    @SerializedName("managerId")
    int managerId;

    @SerializedName("hireDate")
    LocalDate hireDate;

    @SerializedName("jobTitle")
    String jobTitle;

    @SerializedName("role")
    int role;
}
