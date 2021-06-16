package ba.unsa.etf.nrs.projekat;

import ba.unsa.etf.nrs.projekat.Classes.Employee;
import retrofit2.http.Field;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {


    /*@GET("/screenings/all")
    @Headers("accept: application/json")
    Call<GridData<FilteredScreeningsDTO>> getFilteredScreenings(@Header("Authorization") String token, @Query("startDate") String startDate, @Query("endDate") String endDate);*/



    @POST("/UpdateEmployee/:id")
    @Headers("accept: application/json")
    void updateEmployee(Employee emp, int id);

}
