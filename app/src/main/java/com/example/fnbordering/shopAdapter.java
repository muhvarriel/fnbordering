package com.example.fnbordering;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fnbordering.Model.Category;

import java.util.ArrayList;

public class shopAdapter extends RecyclerView.Adapter<shopAdapter.shopViewHolder> {

    Context context;
    ArrayList<Category> categories;

    public shopAdapter(Context c, ArrayList<Category> p) {
        context = c;
        categories = p;
    }

    @NonNull
    @Override
    public shopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new shopViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull shopViewHolder holder, int position) {
        holder.nameView.setText(categories.get(position).getName());
        holder.locationView.setText(categories.get(position).getLocation());
        holder.rangeView.setText("IDR " + categories.get(position).getRange());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mShop = new Intent(context, shop.class);
                mShop.putExtra(shop.EXTRA_SHOP, categories.get(position));
                context.startActivity(mShop);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
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
