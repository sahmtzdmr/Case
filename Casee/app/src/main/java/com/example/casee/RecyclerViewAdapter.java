package com.example.casee;

import android.content.Context;
import android.content.Intent;
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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.cardViewTutucu>{
    private Context context;

    private List<Movies> upComing=new ArrayList<>();
    public CardView cardView;



    public RecyclerViewAdapter(Context context, List<Movies> upComing) {
        this.context = context;
        this.upComing = upComing;

    }

    public class cardViewTutucu extends RecyclerView.ViewHolder{
        public  ImageView imageView;
        public TextView textView,textView2;


        public cardViewTutucu(View view){

            super(view);
            imageView=view.findViewById(R.id.imageSmilar);
            textView=view.findViewById(R.id.textView);
            textView2=view.findViewById(R.id.textView2);

        }


    }

    @NonNull
    @Override
    public cardViewTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_for_recyler,parent,false);

        return new cardViewTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewTutucu holder, int position) {
        Movies movies=upComing.get(position);

        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + movies.getPoster_path())
                .into(holder.imageView);
        holder.textView.setText(movies.getOriginal_title());
        holder.textView2.setText(movies.getOverview());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MovieDetail.class);
                intent.putExtra("id",movies.getId());
                intent.putExtra("image",movies.getPoster_path());
                intent.putExtra("overview",movies.getOverview());
                intent.putExtra("vote_average",movies.getVote_average());
                intent.putExtra("title",movies.getOriginal_title());




                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return upComing.size();
    }

}
