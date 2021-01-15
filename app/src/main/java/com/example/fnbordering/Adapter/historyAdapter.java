package com.example.fnbordering.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fnbordering.Model.History;
import com.example.fnbordering.R;

import java.util.ArrayList;
import java.util.List;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.historyViewHolder> {

    Context context;
    ArrayList<History> listData;

    public historyAdapter(Context c, ArrayList<History> p) {
        context = c;
        listData = p;
    }

    @NonNull
    @Override
    public historyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new historyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_history,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull historyViewHolder holder, int position) {
        holder.nameView.setText(listData.get(position).getProductName());
        holder.quantityView.setText("Quantity: " + listData.get(position).getQuantity());

        int price = (Integer.parseInt(listData.get(position).getPrice()))*(Integer.parseInt(listData.get(position).getQuantity()));
        holder.priceView.setText("IDR " + price);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class historyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView, priceView, quantityView;

        public historyViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView)itemView.findViewById(R.id.txtName);
            priceView = (TextView)itemView.findViewById(R.id.txtPrice);
            quantityView = (TextView)itemView.findViewById(R.id.txtQuantity);
        }
    }
}
