package com.example.rate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
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

import com.example.rate.databinding.ActivityPasswordBinding;
import com.google.android.material.snackbar.Snackbar;

import java.security.spec.PSSParameterSpec;
import java.util.Objects;

public class PasswordActivity extends AppCompatActivity {

    ActivityPasswordBinding binding;
    String password, c_password;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasswordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        constraintLayout = findViewById(R.id.password_layout);
//        String pass_f = String.valueOf(binding.conPassword.getText());
//        String pass_l = String.valueOf(binding.passwordInput.getText());



        Objects.requireNonNull(getSupportActionBar())
                .setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.bk)));
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setTitle("");
        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(PasswordActivity.this, pass_f+" "+pass_l, Toast.LENGTH_SHORT).show();
                password = String.valueOf(binding.conPassword.getText());
                c_password = String.valueOf(binding.passwordInput.getText());
                //Toast.makeText(PasswordActivity.this, password+" "+c_password, Toast.LENGTH_SHORT).show();

                // Get instance of Vibrator from current Context
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                // Vibrate for 500 milliseconds --> 0.5 seconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    // According to docs A VibrationEffect describes a haptic effect to be performed by a Vibrator

                    if(password.isEmpty())
                    {
                        v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        //Toast.makeText(PasswordActivity.this, "Enter a new password", Toast.LENGTH_SHORT).show();
                        Snackbar.make(constraintLayout, "Enter a new password", Snackbar.LENGTH_SHORT)
                                .setBackgroundTint(getResources()
                                        .getColor(R.color.dark))
                                .setTextColor(getResources()
                                        .getColor(R.color.white)).show();

                        binding.icn.setText("\uD83D\uDE4A");
                    }else
                    if(c_password.isEmpty())
                    {
                        v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        //Toast.makeText(PasswordActivity.this, "Confirm your password", Toast.LENGTH_SHORT).show();
                        Snackbar.make(constraintLayout, "Confirm your password", Snackbar.LENGTH_SHORT)
                                .setBackgroundTint(getResources()
                                        .getColor(R.color.dark))
                                .setTextColor(getResources()
                                        .getColor(R.color.white)).show();

                        binding.icn.setText("\uD83D\uDC35");

                    }else
                    if(password.isEmpty() || c_password.isEmpty())
                    {
                        v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        //Toast.makeText(PasswordActivity.this, "Enter Your password first", Toast.LENGTH_SHORT).show();
                        Snackbar.make(constraintLayout, "Enter Your Password", Snackbar.LENGTH_SHORT)
                                .setBackgroundTint(getResources()
                                        .getColor(R.color.dark))
                                .setTextColor(getResources()
                                        .getColor(R.color.white)).show();

                    }else if(password.equals(c_password))
                    {
                        Toast.makeText(PasswordActivity.this, "Welcome to Rate", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PasswordActivity.this , HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        //Toast.makeText(PasswordActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                        Snackbar.make(constraintLayout, "Password does not match", Snackbar.LENGTH_SHORT)
                                .setBackgroundTint(getResources()
                                        .getColor(R.color.dark))
                                .setTextColor(getResources()
                                        .getColor(R.color.white)).show();

                        binding.icn.setText("\uD83D\uDE49");
                    }
                } else {
                    v.vibrate(500);

                }
            }



        });

        // Get instance of Vibrator from current Context
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (vibrator.hasVibrator()) {

            // Your device has Vibrator , Then You can Vibrate

        } else {
            // Your device hasn't Vibrator
            Toast.makeText(this, "Some thing seems Wrong \uD83D\uDE15", Toast.LENGTH_SHORT).show();
            binding.register.setEnabled(false);


        }

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}