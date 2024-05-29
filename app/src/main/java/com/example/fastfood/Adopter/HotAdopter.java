package com.example.fastfood.Adopter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fastfood.Domain.FoodDomain;
import com.example.fastfood.R;
import com.example.fastfood.ShowDetailActivity;

import java.util.ArrayList;

public class HotAdopter extends RecyclerView.Adapter<HotAdopter.ViewHolder> {
    @NonNull
    ArrayList<FoodDomain> hotFood;

    public HotAdopter(@NonNull ArrayList<FoodDomain> hotFood) {
        this.hotFood = hotFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hot, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HotAdopter.ViewHolder holder, int position) {
        holder.title.setText(hotFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(hotFood.get(position).getFee()));



        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(hotFood.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", hotFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return hotFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, fee, addBtn;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            fee = itemView.findViewById(R.id.txt_fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
