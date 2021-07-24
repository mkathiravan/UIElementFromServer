package net.kathir.simpledemoproject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("android_assignment.json")
    Call<ResponseTypeModel> getInfo();
}
