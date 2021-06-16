package ba.unsa.etf.nrs.projekat;

import ba.unsa.etf.nrs.projekat.Classes.Bill;
import ba.unsa.etf.nrs.projekat.Classes.Employee;
import retrofit2.http.Field;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface API {


    @PUT("/UpdateEmployee/:id")
    @Headers("accept: application/json")
    void updateEmployee(Employee emp, int id);

    @POST("/AddBill")
    @Headers("accept: application/json")
    void addBill(Bill bill);

}
