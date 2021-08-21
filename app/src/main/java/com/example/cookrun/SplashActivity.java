package com.example.cookrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    ImageView splashLogo;
    TextView splashName, splashRightsText;
    LottieAnimationView splashLottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();



        splashLogo = findViewById(R.id.cookRunSplashIconImage);
        splashName = findViewById(R.id.cookRunSplashName);
        splashLottie = findViewById(R.id.cookRunSplashLottie);
        splashRightsText = findViewById(R.id.cookRunSplashRightText);


        splashLogo.animate().translationY(3000).setDuration(800).setStartDelay(3000);
        splashName.animate().translationY(3000).setDuration(800).setStartDelay(3000);
        splashLottie.animate().translationY(3000).setDuration(800).setStartDelay(3000);
        splashRightsText.animate().alpha(0).setDuration(800).setStartDelay(3000);

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(4000);


                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);

                }
            }



        };
        thread.start();



    }
}