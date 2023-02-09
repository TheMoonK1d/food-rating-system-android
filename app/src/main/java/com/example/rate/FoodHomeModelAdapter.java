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

public class FoodHomeModelAdapter extends RecyclerView.Adapter<FoodHomeModelAdapter.MyViewHolder> {
    Context context;
    private final HomeFoodInterface homeFoodInterface;
    ArrayList<FoodHomeModel> foodHomeModels;

    public FoodHomeModelAdapter(Context context, ArrayList<FoodHomeModel> foodHomeModels, HomeFoodInterface homeFoodInterface){
        this.foodHomeModels = foodHomeModels;
        this.context = context;
        this.homeFoodInterface = homeFoodInterface;
    }
    @NonNull
    @Override
    public FoodHomeModelAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_view_item, parent, false);
        return new FoodHomeModelAdapter.MyViewHolder(view, homeFoodInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHomeModelAdapter.MyViewHolder holder, int position) {
        holder._foodName.setText(foodHomeModels.get(position).getName());
        holder._foodRate.setText(foodHomeModels.get(position).getRated());
        holder._foodImage.setImageResource(foodHomeModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return foodHomeModels.size();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView _foodImage;
        TextView _foodName, _foodRate;
        public MyViewHolder(@NonNull View itemView, HomeFoodInterface homeFoodInterface) {
            super(itemView);
            _foodImage = itemView.findViewById(R.id.foodimg);
            _foodName = itemView.findViewById(R.id.foodname);
            _foodRate = itemView.findViewById(R.id.foodrate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (homeFoodInterface != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            homeFoodInterface.itemClicked(position);
                        }
                    }
                }
            });
        }

    }
}
