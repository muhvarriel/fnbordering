package com.example.fnbordering.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fnbordering.Model.Shop;
import com.example.fnbordering.shop;
import com.example.fnbordering.R;

import java.util.ArrayList;

public class shopAdapter extends RecyclerView.Adapter<shopAdapter.shopViewHolder> {

    Context context;
    ArrayList<Shop> shopies;

    public shopAdapter(Context c, ArrayList<Shop> p) {
        context = c;
        shopies = p;
    }

    @NonNull
    @Override
    public shopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new shopViewHolder(LayoutInflater.from(context).inflate(R.layout.item_shop,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull shopViewHolder holder, int position) {
        holder.nameView.setText(shopies.get(position).getName());
        holder.locationView.setText(shopies.get(position).getLocation());
        holder.rangeView.setText("IDR " + shopies.get(position).getRange());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mShop = new Intent(context, shop.class);
                mShop.putExtra(shop.EXTRA_SHOP, shopies.get(position));
                context.startActivity(mShop);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopies.size();
    }

    class shopViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView, locationView, rangeView;
        public LinearLayout button;

        public shopViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView)itemView.findViewById(R.id.restaurant_name);
            locationView = (TextView)itemView.findViewById(R.id.restaurant_location);
            rangeView = (TextView)itemView.findViewById(R.id.restaurant_range);
            button = (LinearLayout) itemView.findViewById(R.id.btnShop);
        }
    }
}
