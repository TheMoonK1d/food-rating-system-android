package com.example.rate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiscoverFragment extends Fragment implements DiscoverFoodInterface {

    RecyclerView recyclerView;
    Context discoverContext;
    ArrayList<FoodHomeModel> foodHomeModels = new ArrayList<>();
    int[] foodHomeImg = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
    };

    private void setUpDiscover(){
        String[] foodNames = getResources().getStringArray(R.array.lst_name);
        String[] foodRate = getResources().getStringArray(R.array.lst_rate);
        String [] foodDes = getResources().getStringArray(R.array.lst_des);
        String [] foodRes = getResources().getStringArray(R.array.lst_des);
        for (int i = 0; i< foodRes.length; i++){
            foodHomeModels.add(new FoodHomeModel(
                    foodNames[i],
                    foodRate[i],
                    foodHomeImg[i],
                    foodRes[i],
                    foodDes[i]
            ));
        }
    }

    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Discover");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        recyclerView = view.findViewById(R.id.discover_r_item);
        setUpDiscover();
        FoodDiscoverModelAdapter adapter = new FoodDiscoverModelAdapter(discoverContext,foodHomeModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(discoverContext));
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        discoverContext = context;
    }


    @Override
    public void itemClickedDis(int position) {
//        Intent intent = new Intent(discoverContext, DetailActivity.class);
//
//        intent.putExtra("FoodName",foodHomeModels.get(position).getName());
//        intent.putExtra("FoodImage",foodHomeModels.get(position).getImage());
//        intent.putExtra("FoodRate",foodHomeModels.get(position).getRated());
//        intent.putExtra("FoodDes",foodHomeModels.get(position).getDes());
//        getActivity().startActivity(intent);
    }
}