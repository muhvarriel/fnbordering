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

import com.example.fnbordering.Model.Food;

import java.util.ArrayList;

public class foodAdapter extends RecyclerView.Adapter<foodAdapter.foodViewHolder> {

    Context context;
    ArrayList<Food> foodies;

    public foodAdapter(Context c, ArrayList<Food> p) {
        context = c;
        foodies = p;
    }

    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new foodViewHolder(LayoutInflater.from(context).inflate(R.layout.item_food,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull foodViewHolder holder, int position) {
        holder.nameView.setText(foodies.get(position).getName());
        holder.priceView.setText("IDR " + foodies.get(position).getPrice());
        holder.idView.setText(foodies.get(position).getId());
        holder.descView.setText(foodies.get(position).getDesc());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mFood = new Intent(context, food.class);
                mFood.putExtra(food.EXTRA_FOOD, foodies.get(position));
                context.startActivity(mFood);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodies.size();
    }

    class foodViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView, priceView, idView, descView;
        public LinearLayout button;

        public foodViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView)itemView.findViewById(R.id.txtFoodName);
            priceView = (TextView)itemView.findViewById(R.id.txtFoodPrice);
            idView = (TextView)itemView.findViewById(R.id.txtId);
            descView = (TextView)itemView.findViewById(R.id.txtDesc);
            button = (LinearLayout) itemView.findViewById(R.id.btnFood);
        }
    }
}
