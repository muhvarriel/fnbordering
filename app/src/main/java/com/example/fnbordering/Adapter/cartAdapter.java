package com.example.fnbordering.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Model.Cart;
import com.example.fnbordering.R;
import com.example.fnbordering.cart;
import com.example.fnbordering.food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.cartViewHolder> {

    Context context;
    ArrayList<Cart> listData;

    public cartAdapter(Context c, ArrayList<Cart> p) {
        context = c;
        listData = p;
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cartViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {
        holder.nameView.setText(listData.get(position).getProductName());
        holder.quantityView.setText("Quantity: " + listData.get(position).getQuantity());

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
