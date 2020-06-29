package com.example.travelagency.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.travelagency.R;
import com.example.travelagency.models.Trending;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder>{

    ArrayList<Trending> trending;
    Context context;

    public TrendingAdapter(ArrayList<Trending> Trending, Context context) {
        this.trending = Trending;
        this.context = context;
    }

    @NonNull
    @Override
    public TrendingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.trending_item, viewGroup, false);
        return new TrendingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdapter.ViewHolder viewHolder, int i) {
        String destinationName = trending.get(i).getDestinationName();
        int destinationImageId = trending.get(i).getDestinationImageId();
        Drawable destinationDrawable = ResourcesCompat.getDrawable(context.getResources(), destinationImageId, null);
        String price = String.valueOf(trending.get(i).getPrice());

        viewHolder.tvDestinationName.setText(destinationName);
        viewHolder.clTrending.setBackground(destinationDrawable);
        viewHolder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return trending.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDestinationName;
        ConstraintLayout clTrending;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDestinationName = itemView.findViewById(R.id.tv_destination_name);
            clTrending = itemView.findViewById(R.id.cl_trending);
            price = itemView.findViewById(R.id.tv_price);
        }
    }

}
