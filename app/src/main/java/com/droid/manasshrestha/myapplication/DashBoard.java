package com.droid.manasshrestha.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.droid.manasshrestha.myapplication.basicanimations.BasicAnimationActivity;
import com.droid.manasshrestha.myapplication.weatheranimations.WeatherAnimationsActivity;
import com.droid.manasshrestha.myapplication.xmlanimations.ButtonToDialogAnimationActivity;
import com.droid.manasshrestha.myapplication.xmlanimations.MomentsAnimation;

public class DashBoard extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    public void startSimpleAnimationsActivity(View view){
        startActivity(new Intent(this, BasicAnimationActivity.class));
    }

    public void startWeatherAnimationsActivity(View view){
        startActivity(new Intent(this, WeatherAnimationsActivity.class));
    }

    public void startButtonAnimationActivity(View view) {
        startActivity(new Intent(this, ButtonToDialogAnimationActivity.class));
    }

    public void startMomentsAnimations(View view) {
        startActivity(new Intent(this, MomentsAnimation.class));
    }
}
