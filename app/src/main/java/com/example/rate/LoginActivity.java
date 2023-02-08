package com.example.rate;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.rate.databinding.ActivityLoginBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    static String email;
    String password;
    boolean valid = false;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bk)));
        constraintLayout = findViewById(R.id.login_layout);
        intro();


        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = String.valueOf(binding.emailInput.getText());
                password = String.valueOf(binding.passwordInput.getText());
                Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if(binding.emailInput.equals("") && binding.passwordInput.equals(""))
                    {
                        vb.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        Snackbar.make(constraintLayout, "Enter your Email and Password", Snackbar.LENGTH_SHORT).setBackgroundTint(getResources().getColor(R.color.dark)).setTextColor(getResources().getColor(R.color.white)).show();

                    }else if(email.isEmpty())
                    {
                        vb.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        //Toast.makeText(PasswordActivity.this, "Enter a new password", Toast.LENGTH_SHORT).show();
                        Snackbar.make(constraintLayout, "Enter your email 📩", Snackbar.LENGTH_SHORT)
                                .setBackgroundTint(getResources()
                                        .getColor(R.color.dark))
                                .setTextColor(getResources()
                                        .getColor(R.color.white)).show();

                    }
                    else if(Patterns.EMAIL_ADDRESS.matcher(binding.emailInput.getText().toString()).matches() == false)
                    {

                        vb.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        binding.emailInput.setError("This does not seem right");
                        //Toast.makeText(PasswordActivity.this, "Enter a new password", Toast.LENGTH_SHORT).show();
                        Snackbar.make(constraintLayout, "Invalid email", Snackbar.LENGTH_SHORT).setBackgroundTint(getResources().getColor(R.color.dark)).setTextColor(getResources().getColor(R.color.white)).show();

                    }else if(password.isEmpty())
                    {
                        vb.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        //Toast.makeText(PasswordActivity.this, "Confirm your password", Toast.LENGTH_SHORT).show();
                        Snackbar.make(constraintLayout, "Enter your password", Snackbar.LENGTH_SHORT).setBackgroundTint(getResources().getColor(R.color.dark)).setTextColor(getResources().getColor(R.color.white)).show();
                    }else
                    {
                           Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                           startActivity(intent);
                           Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    vb.vibrate(500);
                }
            }
        });

        binding.signupTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignUp();
            }
        });
        binding.signupTxtBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignUp();
            }
        });
    }

    public void goToSignUp(){
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
    }
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Leaving?");
        alertDialogBuilder
                .setMessage("Do you really want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        finishAffinity();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void intro (){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.intro);
        binding.logo.startAnimation(animation);
        //binding.loginBtn.startAnimation(animation);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.intro_slow);
        binding.animation.startAnimation(animation2);
    }
    public static boolean isValidEmail() {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}