package com.example.youthhub.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //private static final String BASE_URL = "http://app1.youthhub.nz/v1/";
   // private static final String BASE_URL = "http://api.youthhub.nz/v1/";
   // private static final String BASE_URL = "http://api55.youthhub.co.nz/v1/";
    private static final String BASE_URL = "http://api33.youthhub.co.nz/v1/";
    private static Retrofit retrofit = null;

    private static Retrofit getClient() {

        /*OkHttpClient.Builder httpClient = new OkHttpClient.Builder().connectTimeout(100, TimeUnit.SECONDS).readTimeout(100,TimeUnit.SECONDS);

        httpClient.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader("YH-API-KEY", "T7aaUFPKAE0WDIZY8Q5s4LIknv0lXazE5xFP2ipq").build();
            return chain.proceed(request);
        });*/

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        Gson userDeserializer = new GsonBuilder().setLenient().registerTypeAdapter(ResponseWrapper.class, new UserResponseDeserializer()).create();


        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    public static ApiInterface getApiInterface(){
        return ApiClient.getClient().create(ApiInterface.class);
    }

}