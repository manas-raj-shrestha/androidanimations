package com.droid.manasshrestha.myapplication.basicanimations;

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

public class BasicAnimationActivity extends AppCompatActivity implements AnimationViewChangeListener {

    RecyclerView recyclerView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.fl_animated_views);
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
        String[] weatherAnimations = new String[]{"Cloud Loading", "Path Animation", "No Connection"};
        recyclerView.setAdapter(new AnimationsRvAdapter(this, weatherAnimations));
    }

    @Override
    public void onAnimationChanged(int position) {
        View view = new LoadingView(this);
        switch (position) {
            case 0:
                view = new LoadingView(this);
                break;
            case 1:
                view = new NoPermissionView(this);
                break;
            case 2:
                view = new NoConnectionView(this);
                break;
        }

        view.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        frameLayout.removeAllViews();
        frameLayout.addView(view);
    }
}
