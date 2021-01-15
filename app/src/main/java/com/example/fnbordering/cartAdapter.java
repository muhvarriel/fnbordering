package com.example.fnbordering;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.fnbordering.Model.Food;
import com.example.fnbordering.Model.Order;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.cartViewHolder> {

    Context context;
    List<Order> listData = new ArrayList<>();

    public cartAdapter(List<Order> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cartViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {
        holder.nameView.setText(listData.get(position).getProductName());
        holder.quantityView.setText(listData.get(position).getQuantity());

        TextDrawable drawable = TextDrawable.builder()
                .buildRound(""+listData.get(position).getQuantity(), Color.RED);
        int price = (Integer.parseInt(listData.get(position).getPrice()))*(Integer.parseInt(listData.get(position).getQuantity()));
        holder.priceView.setText("IDR " + price);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class cartViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView, priceView, quantityView;

        public cartViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView)itemView.findViewById(R.id.txtName);
            priceView = (TextView)itemView.findViewById(R.id.txtPrice);
            quantityView = (TextView)itemView.findViewById(R.id.txtQuantity);
        }
    }
}
