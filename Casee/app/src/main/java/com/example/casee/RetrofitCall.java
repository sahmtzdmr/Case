package com.example.casee;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCall {
    public static class RetrofitClientInstance {
        private static Retrofit retrofit;
        private static RetrofitClientInstance instance;
        private static final String BASE_URL = "https://api.themoviedb.org/";

        private RetrofitClientInstance() {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        public static synchronized RetrofitClientInstance getInstance(){
            if (instance==null){
                instance=new RetrofitClientInstance();
            }
            return instance;
        }
        public RecyclerInterface getApi(){
            return retrofit.create(RecyclerInterface.class);
        }
    }


}
