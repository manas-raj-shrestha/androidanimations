package com.droid.manasshrestha.myapplication.weatheranimations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.droid.manasshrestha.myapplication.AnimationViewChangeListener;
import com.droid.manasshrestha.myapplication.AnimationsRvAdapter;
import com.droid.manasshrestha.myapplication.R;

public class WeatherAnimationsActivity extends AppCompatActivity implements AnimationViewChangeListener {

    RecyclerView recyclerView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_weathers);

        frameLayout = (FrameLayout) findViewById(R.id.fl_animated_views);
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
        String[] weatherAnimations = new String[]{"Sleet", "Sunny", "Cloudy", "Foggy", "Partly Cloudy", "Rainy", "Snow", "Wind"};
        recyclerView.setAdapter(new AnimationsRvAdapter(this, weatherAnimations));
    }

    @Override
    public void onAnimationChanged(int position) {
        View view = new SleetWeather(this);
        switch (position) {
            case 0:
                view = new SleetWeather(this);
                break;
            case 1:
                view = new ClearWeather(this);
                break;
            case 2:
                view = new CloudyWeather(this);
                break;
            case 3:
                view = new FogWeather(this);
                break;
            case 4:
                view = new PartlyCloudyWeather(this);
                break;
            case 5:
                view = new RainyWeather(this);
                break;
            case 6:
                view = new SnowWeather(this);
                break;
            case 7:
                view = new WindWeather(this);
                break;
        }

        view.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        frameLayout.removeAllViews();
        frameLayout.addView(view);
    }
}
