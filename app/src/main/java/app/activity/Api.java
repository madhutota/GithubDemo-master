package app.activity;


import java.util.Map;

import app.model.OTPModel;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Shankar on 5/13/2016.
 */
public interface Api {

    /*@GET("/api/vehicle/v2/makes")
    Call<Makes> getData(@Query("state") String state, @Query("year") String year, @Query("view") String view,
                 @Query("fmt") String fmt,@Query("api_key") String api_key);*/



    @GET("/api/vehicle/v2/makes")
    Call<Makes> getData(@QueryMap Map<String, String> parameterMap);

    @FormUrlEncoded
    @POST("/getAndroidAppFeeds.do")
    Call<OTPModel> generateOTP(@FieldMap Map<String, String> parameterMap);

    @GET("/api/")
    Call<FlowersResponse> getFlowersData(@QueryMap Map<String, String> parameterMap);
}