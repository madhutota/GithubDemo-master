package app.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import app.adapter.CardAdapter;
import app.model.OTPModel;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.githubdemo.app.R;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {


    private CardAdapter mCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Set up Android CardView/RecycleView
         */
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCardAdapter = new CardAdapter();
        mRecyclerView.setAdapter(mCardAdapter);

        /**
         * START: button set up
         */
        Button bClear = (Button) findViewById(R.id.button_clear);
        Button bFetch = (Button) findViewById(R.id.button_fetch);
        bClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCardAdapter.clear();
            }
        });

        bFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  getListGETRequest();
                getListFlowersGETRequest();
                /*getListGETRequest();
                generateOTPPOSTRequest();*/

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void generateOTPPOSTRequest() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("http://lms.carbay.my")  //call your base url
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        Api api = restAdapter.create(Api.class);

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("parameter", "generateSmsCode");
        parameters.put("MobileNo", "60193186507");
        parameters.put("DeviceId", "bbdaf0b8ceaa4c4e");
        parameters.put("user", "@c@a@dekho");
        parameters.put("pass", "123@c@a@de^kho^");

        Call<OTPModel> otpModelCall = api.generateOTP(parameters);

        otpModelCall.enqueue(new Callback<OTPModel>() {
            @Override
            public void onResponse(Call<OTPModel> call, Response<OTPModel> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    Log.e("TAG", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<OTPModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void getListGETRequest() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("https://api.edmunds.com")  //call your base url
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        Api api = restAdapter.create(Api.class);

        /*Call<Makes> call = api.getData("used", "2014", "basic", "json", "wdd3m9g97bfc63c34mgnumaz");*/

                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("state", "used");
                parameters.put("year", "2014");
                parameters.put("view", "basic");
                parameters.put("fmt", "json");
                parameters.put("api_key", "wdd3m9g97bfc63c34mgnumaz");

                Call<Makes> call = api.getData(parameters);

                call.clone().enqueue(new Callback<Makes>() {
                    @Override
                    public void onResponse(Call<Makes> callRes, Response<Makes> response) {
                        if (response.code() == HttpURLConnection.HTTP_OK) {
                           Log.e("TAG",""+response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Makes> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
    private void getListFlowersGETRequest() {
        //https://pixabay.com/api/?key=8468917-ea3eb71e3e1376b18140e5983&q=yellow+flowers&image_type=photo
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("https://pixabay.com")  //call your base url
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        Api api = restAdapter.create(Api.class);

        /*Call<Makes> call = api.getData("used", "2014", "basic", "json", "wdd3m9g97bfc63c34mgnumaz");*/

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("key", "8468917-ea3eb71e3e1376b18140e5983");
        parameters.put("q", "yellow+flowers");
        parameters.put("image_type", "photo");

        Call<FlowersResponse> call = api.getFlowersData(parameters);

        call.clone().enqueue(new Callback<FlowersResponse>() {
            @Override
            public void onResponse(Call<FlowersResponse> callRes, Response<FlowersResponse> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    Log.e("TAG",""+response.body());
                }
            }

            @Override
            public void onFailure(Call<FlowersResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
