package ba.unsa.etf.nrs.projekat;

import ba.unsa.etf.nrs.projekat.Classes.Bill;
import ba.unsa.etf.nrs.projekat.Classes.BillDTO;
import ba.unsa.etf.nrs.projekat.Classes.Employee;
import retrofit2.Call;
import retrofit2.http.*;

public interface API {

    @POST("/AddBill")
    @Headers("accept: application/json")
    Call<Boolean> addBill(@Body BillDTO bill);

}
