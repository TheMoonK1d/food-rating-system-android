package com.example.rate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rate.databinding.FragmentHomeBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;


public class HomeFragment<MainFragmentActivity> extends Fragment implements HomeFoodInterface {
    RecyclerView recyclerView;
    Context homeContext;
    ArrayList <FoodHomeModel> foodHomeModels = new ArrayList<>();
    int[] foodHomeImg = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
    };







    private void setUp(){
        String[] foodNames = getResources().getStringArray(R.array.lst_name);
        String[] foodRate = getResources().getStringArray(R.array.lst_rate);

        for (int i = 0; i< foodNames.length; i++){
            foodHomeModels.add(new FoodHomeModel(
                    foodNames[i],
                    foodRate[i],
                    foodHomeImg[i]
                    ));
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getActivity().setTitle("Home");
        recyclerView = view.findViewById(R.id.home_r_view);

        setUp();

        FoodHomeModelAdapter adapter = new FoodHomeModelAdapter(homeContext, foodHomeModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(homeContext, 2));



        //test

//        recyclerView = getActivity().findViewById(R.id.home_r_view);
//        setUp();
//
//        adapter = new FoodHomeModelAdapter(homeContext, foodHomeModels);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(homeContext));

return view;

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeContext = context;
    }

    @Override
    public void itemClicked(int position) {

    }
}