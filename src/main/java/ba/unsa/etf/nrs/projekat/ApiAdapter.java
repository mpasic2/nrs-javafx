package ba.unsa.etf.nrs.projekat;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {
    static API retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:1000/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(API.class);


    public static API getRetrofit(){
        return retrofit;
    }

}
