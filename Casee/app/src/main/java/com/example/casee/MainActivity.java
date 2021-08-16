package com.example.casee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewPager);
        recyclerView=findViewById(R.id.recyclerView);





        getNowPlaying();
        getUpComing();


    }

    public void getNowPlaying(){
        try {
            Call<MoviesResponse> call = RetrofitCall.RetrofitClientInstance.getInstance().getApi().getNowPlaying("7ab5d50261233f3efabb49372afd47ab");
            call.enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                    try {

                        if (response.code() == 200) {
                            MoviesResponse moviesResponse = response.body();
                            setViewPager(moviesResponse.getMovies());

                        }

                    } catch (Exception e) {

                    }
                }

                @Override
                public void onFailure(Call<MoviesResponse> call, Throwable t) {
                    Log.v("ghgjh", call.toString());
                }
            });
        } catch (Exception e) {
            Log.v("", e.getMessage());
        }

    }
    public void getUpComing(){ try {
        Call<MoviesResponse> call = RetrofitCall.RetrofitClientInstance.getInstance().getApi().getUpComing("7ab5d50261233f3efabb49372afd47ab");
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                try {

                    if (response.code() == 200) {
                        MoviesResponse moviesResponse = response.body();

                        setUpComing(moviesResponse.getMovies());

                    }

                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.v("ghgjh", call.toString());
            }
        });
    } catch (Exception e) {
        Log.v("", e.getMessage());
    }





    }
    public void setViewPager(List<Movies> nowPlayingList) {
        viewPagerAdapter= new ViewPagerAdapter(this,nowPlayingList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
    }

    public void setUpComing(List<Movies> upComing){
        recyclerViewAdapter=new RecyclerViewAdapter(this,upComing);
        recyclerView.setAdapter(recyclerViewAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);






    }


}