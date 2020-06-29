package com.example.travelagency.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.travelagency.R;
import com.example.travelagency.models.Offers;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.ViewHolder> {

    ArrayList<Offers> offers;
    Context context;

    public OffersAdapter(ArrayList<Offers> offers, Context context) {
        this.offers = offers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offers_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvOfferText.setText(offers.get(i).getOfferText());
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOfferText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOfferText = itemView.findViewById(R.id.tv_offer_text);
        }
    }
}
