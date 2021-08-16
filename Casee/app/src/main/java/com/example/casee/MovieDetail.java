package com.example.casee;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetail extends AppCompatActivity {
   SmilarRecyclerViewAdapter smilarRecyclerViewAdapter;
    RecyclerView recyclerView;
    Context context;

    ImageView imageDetail;
    TextView titleDetail,overviewDetail,rating;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutdetail);
        overviewDetail=findViewById(R.id.overviewDetail);
        imageDetail=findViewById(R.id.imageDetail);
        titleDetail=findViewById(R.id.titleDetail);
        rating=findViewById(R.id.rating);
        recyclerView=findViewById(R.id.recyclerViewSmilar);

        Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt("id",0);
        String image=bundle.getString("image","");
        Glide.with(this).load("https://image.tmdb.org/t/p/w500" + image)
                .into(imageDetail);

        getDetails(id);
        getSmilarMovie(id);








    }

    public void getDetails(int movieId){ try {
        Call<DetailsResponse> call = RetrofitCall.RetrofitClientInstance.getInstance().getApi().getMovieDetail(movieId,"7ab5d50261233f3efabb49372afd47ab");
        call.enqueue(new Callback<DetailsResponse>() {
            @Override
            public void onResponse(Call<DetailsResponse> call, Response<DetailsResponse> response) {
                try {

                    if (response.code() == 200) {
                        DetailsResponse detailsResponse = response.body();

                        titleDetail.setText(detailsResponse.getTitle());

                        rating.setText(""+detailsResponse.getVote_average());

                        overviewDetail.setText(detailsResponse.getOverview());


                    }

                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<DetailsResponse> call, Throwable t) {
                Log.v("ghgjh", call.toString());
            }
        });
    } catch (Exception e) {
        Log.v("", e.getMessage());
    }





    }
    public void getSmilarMovie(int  movieId)
    { try {
        Call<MoviesResponse> call = RetrofitCall.RetrofitClientInstance.getInstance().getApi().getSmilarMovie(movieId,"7ab5d50261233f3efabb49372afd47ab");
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                try {

                    if (response.code() == 200) {
                        MoviesResponse moviesResponse = response.body();

                        setSmilar(moviesResponse.getMovies());



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





    public void setSmilar(List<Movies> movies){
        smilarRecyclerViewAdapter=new SmilarRecyclerViewAdapter(this,movies);
        recyclerView.setAdapter(smilarRecyclerViewAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);






    }


}
