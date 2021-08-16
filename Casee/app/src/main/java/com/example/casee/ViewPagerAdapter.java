package com.example.casee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    private List<Movies> nowPlaying=new ArrayList<>();





    LayoutInflater layoutInflater;

    ImageView viewPagerImageView;

    public ViewPagerAdapter(Context context,List<Movies> nowPlaying) {

        this.context = context;
        this.nowPlaying= nowPlaying;


    }

    @Override
    public int getCount() {
        return nowPlaying.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.viewpagerimage, container, false);

        viewPagerImageView = view.findViewById(R.id.imageView);

        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + nowPlaying.get(position).getPoster_path())
                .into(viewPagerImageView);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
