package com.example.rate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rate.databinding.ActivityEmailBinding;
import com.example.rate.databinding.ActivityLoginBinding;
import com.example.rate.databinding.ActivitySignupBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class EmailActivity extends AppCompatActivity {
    ActivityEmailBinding binding;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        constraintLayout = findViewById(R.id.email_layout);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bk)));
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setTitle("");

//        binding.emailNxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(EmailActivity.this, PasswordActivity.class);
//                startActivity(intent);
//            }
//        });
        binding.emailNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = String.valueOf(binding.email.getText());

                    // Get instance of Vibrator from current Context
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                    // Vibrate for 500 milliseconds --> 0.5 seconds
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                        // According to docs A VibrationEffect describes a haptic effect to be performed by a Vibrator

                        if(email.isEmpty())
                        {
                            v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                            //Toast.makeText(EmailActivity.this, "Enter Your email first", Toast.LENGTH_SHORT).show();

                            Snackbar.make(constraintLayout, "Enter Your Email 📩", Snackbar.LENGTH_SHORT).setBackgroundTint(getResources().getColor(R.color.dark)).setTextColor(getResources().getColor(R.color.white)).show();
                        }else if(Patterns.EMAIL_ADDRESS.matcher(binding.email.getText().toString()).matches() == false)
                        {

                            v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                            binding.email.setError("This does not seem right");
                            //Toast.makeText(PasswordActivity.this, "Enter a new password", Toast.LENGTH_SHORT).show();
                            Snackbar.make(constraintLayout, "Invalid email", Snackbar.LENGTH_SHORT).setBackgroundTint(getResources().getColor(R.color.dark)).setTextColor(getResources().getColor(R.color.white)).show();

                        }
                        else{
                            Intent intent = new Intent(EmailActivity.this , PasswordActivity.class);
                            startActivity(intent);
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
            binding.emailNxt.setEnabled(false);


        }
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}