package com.example.casee;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RecyclerInterface {

    @GET("3/movie/now_playing")
    Call<MoviesResponse> getNowPlaying(@Query("api_key") String api_key);


    @GET("3/movie/upcoming")
    Call<MoviesResponse> getUpComing(@Query("api_key") String api_key);

    @GET("3/movie/{movie_id}")
    Call<DetailsResponse> getMovieDetail(@Path("movie_id") int movie_id,@Query("api_key") String api_key );

    @GET("3/movie/{movie_id}/similar")
    Call<MoviesResponse> getSmilarMovie(@Path("movie_id") int movie_id,@Query(("api_key")) String api_key);






    }




