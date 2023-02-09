package com.example.rate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodDiscoverModelAdapter extends RecyclerView.Adapter<FoodDiscoverModelAdapter.DiscoverViewHolder> {
    Context context;
    private final DiscoverFoodInterface discoverFoodInterface;
    ArrayList<FoodHomeModel> foodHomeModels;

    public FoodDiscoverModelAdapter(Context context, ArrayList<FoodHomeModel> foodHomeModels, DiscoverFoodInterface discoverFoodInterface){
        this.foodHomeModels = foodHomeModels;
        this.context = context;
        this.discoverFoodInterface = discoverFoodInterface;
    }

    @NonNull
    @Override
    public DiscoverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.discover_view_item, parent, false);
        //return new DiscoverFragment().DiscoverViewHolder(view, discoverFoodInterface);
        return new FoodDiscoverModelAdapter.DiscoverViewHolder(view, discoverFoodInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull FoodDiscoverModelAdapter.DiscoverViewHolder holder, int position) {
        holder._foodName.setText(foodHomeModels.get(position).getName());
        holder._foodRate.setText(foodHomeModels.get(position).getRated());
        holder._foodImage.setImageResource(foodHomeModels.get(position).getImage());
    }



    @Override
    public int getItemCount() {
        return foodHomeModels.size();
    }


    public static class DiscoverViewHolder extends RecyclerView.ViewHolder{
        ImageView _foodImage;
        TextView _foodName, _foodRate;
        public DiscoverViewHolder(@NonNull View itemView, DiscoverFoodInterface discoverFoodInterface) {
            super(itemView);
            _foodImage = itemView.findViewById(R.id.foodimg);
            _foodName = itemView.findViewById(R.id.foodname);
            _foodRate = itemView.findViewById(R.id.foodrate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (discoverFoodInterface != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            discoverFoodInterface.itemClickedDis(position);
                        }
                    }
                }
            });
        }


    }
}

