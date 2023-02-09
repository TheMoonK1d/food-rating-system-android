package com.example.rate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rate.databinding.ActivityDetailBinding;
import com.example.rate.databinding.ActivityLoginBinding;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    int _rateVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bk)));
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        Dialog dialog = new Dialog(DetailActivity.this);
        String name = getIntent().getStringExtra("FoodName");
        int img = getIntent().getIntExtra("FoodImage", 0);
        String rate = getIntent().getStringExtra("FoodRate");
        String des = getIntent().getStringExtra("FoodDes");
        binding.foodName.setText(name);
        binding.foodRate.setText(rate);
        binding.foodImg.setImageResource(img);
        binding.bluredImg.setImageResource(img);
        binding.foodDes.setText(des);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.bluredImg.setRenderEffect(RenderEffect.createBlurEffect(300,300, Shader.TileMode.MIRROR));
        }

        binding.rateBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                _rateVal = (int) rating;
                //Toast.makeText(DetailActivity.this, "Rating value :  " + Integer.valueOf((int) rating), Toast.LENGTH_LONG).show();
            }
        });

        binding.rateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.setContentView(R.layout.rate_dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(true);

                //dialog.getWindow().getAttributes().windowAnimations = R.style.animation;


                //TextView cancel_text = dialog.findViewById(R.id.cancel_text);
                ImageView closeIcn = dialog.findViewById(R.id.closeIcn);
                Button btn = dialog.findViewById(R.id.rate_btn_fin);


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DetailActivity.this, "Connection error...!", Toast.LENGTH_SHORT).show();
                    }
                });

                closeIcn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}