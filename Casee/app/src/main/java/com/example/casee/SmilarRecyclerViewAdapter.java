package com.example.casee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class SmilarRecyclerViewAdapter extends RecyclerView.Adapter<SmilarRecyclerViewAdapter.cardViewEkle> {


    private Context context;
    private List<Movies> smilarMovies=new ArrayList<>();
    public CardView cardView;

    public SmilarRecyclerViewAdapter(Context context,List<Movies> movies){
        this.context=context;
        this.smilarMovies=movies;







    }


    public class cardViewEkle extends RecyclerView.ViewHolder{
        public ImageView imageSmilar;
        public TextView smilarTitle,smilarDate;





        public cardViewEkle(View view){

            super(view);
            imageSmilar=view.findViewById(R.id.imageSmilar);
            smilarTitle=view.findViewById(R.id.smilarTitle);
            smilarDate=view.findViewById(R.id.smilarDate);




        }


    }





    @NonNull
    @Override
    public cardViewEkle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardviewforsmilar,parent,false);


        return new cardViewEkle(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewEkle holder, int position) {
        Movies movies= smilarMovies.get(position);
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + movies.getPoster_path())
                .into(holder.imageSmilar);
        holder.smilarTitle.setText(movies.getOriginal_title());
        holder.smilarDate.setText(movies.getRelease_date());




    }


    @Override
    public int getItemCount() {
        return smilarMovies.size();
    }
}
