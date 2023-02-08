package com.example.rate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.transition.FragmentTransitionSupport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rate.databinding.ActivitySignupBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Objects.requireNonNull(getSupportActionBar())
                .setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.bk)));
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setTitle("");
        constraintLayout = findViewById(R.id.signup_layout);
        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = String.valueOf(binding.firstnameInput.getText());
                String lName = String.valueOf(binding.lastnameInput.getText());

                Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    // According to docs A VibrationEffect describes a haptic effect to be performed by a Vibrator

                    if(fName.isEmpty() && lName.isEmpty())
                    {
                        vb.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        Snackbar.make(constraintLayout, "Enter your full name 📥", Snackbar.LENGTH_SHORT)
                                .setBackgroundTint(getResources()
                                        .getColor(R.color.dark))
                                .setTextColor(getResources()
                                        .getColor(R.color.white)).show();
                        //Toast.makeText(SignupActivity.this, "We need your name", Toast.LENGTH_SHORT).show();
                    }else
                    if(fName.isEmpty())
                    {
                        vb.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        Snackbar.make(constraintLayout, "Enter your fist name 📥", Snackbar.LENGTH_SHORT)
                                .setBackgroundTint(getResources()
                                        .getColor(R.color.dark))
                                .setTextColor(getResources()
                                        .getColor(R.color.white)).show();
                        //Toast.makeText(SignupActivity.this, "Enter your fist name", Toast.LENGTH_SHORT).show();
                    }else if(lName.isEmpty())
                    {
                        vb.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        Snackbar.make(constraintLayout, "Enter your last name 📥", Snackbar.LENGTH_SHORT)
                                .setBackgroundTint(getResources()
                                        .getColor(R.color.dark))
                                .setTextColor(getResources()
                                        .getColor(R.color.white)).show();
                        //Toast.makeText(SignupActivity.this, "Enter your last name", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent intent = new Intent(SignupActivity.this , EmailActivity.class);
                        startActivity(intent);
                    }
                } else {
                    vb.vibrate(500);

                }
            }


        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}