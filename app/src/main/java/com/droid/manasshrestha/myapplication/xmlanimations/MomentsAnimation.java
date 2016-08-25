package com.droid.manasshrestha.myapplication.xmlanimations;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.droid.manasshrestha.myapplication.GeneralUtils;
import com.droid.manasshrestha.myapplication.R;

public class MomentsAnimation extends AppCompatActivity {

    ImageView imageView;
    ImageView ivLogo;
    ImageView ivHousePhoto;
    ImageView ivMaleFigures;
    ImageView ivMountain;
    ImageView ivIceBerg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_moments_animation);
        imageView = (ImageView) findViewById(R.id.iv_balloons);
        ivLogo = (ImageView) findViewById(R.id.iv_logo);
        ivHousePhoto = (ImageView) findViewById(R.id.iv_house);
        ivMaleFigures = (ImageView) findViewById(R.id.iv_male_figures);
        ivIceBerg = (ImageView) findViewById(R.id.iv_ice_berg);
        ivMountain = (ImageView) findViewById(R.id.iv_mountain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startBalloonsAnimation();
            }
        }, 500);

    }

    private void startBalloonsAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(imageView.getY(), imageView.getY() - GeneralUtils.convertDpToPixel(50));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = ((Float) (valueAnimator.getAnimatedValue())).floatValue();
                imageView.setY(value);
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.start();

        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                //animation start
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startLogoAnimation();
                startPhotoAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private void startPhotoAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.1f, 1f);
        valueAnimator.setDuration(1000);
        ivHousePhoto.setVisibility(View.VISIBLE);
        ivMaleFigures.setVisibility(View.VISIBLE);
        ivIceBerg.setVisibility(View.VISIBLE);
        ivMountain.setVisibility(View.VISIBLE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = ((Float) (valueAnimator.getAnimatedValue())).floatValue();
                ivHousePhoto.setScaleY(value);
                ivHousePhoto.setScaleX(value);
                ivHousePhoto.setRotation(ivHousePhoto.getRotation() - 0.5f);

                ivMaleFigures.setScaleX(value);
                ivMaleFigures.setScaleY(value);
                ivMaleFigures.setRotation(ivMaleFigures.getRotation() + 0.5f);

                ivIceBerg.setScaleX(value);
                ivIceBerg.setScaleY(value);
                ivIceBerg.setRotation(ivIceBerg.getRotation() - 0.5f);

                ivMountain.setScaleX(value);
                ivMountain.setScaleY(value);
                ivMountain.setRotation(ivMountain.getRotation() + 0.5f);
            }
        });

        valueAnimator.start();

    }

    private void startLogoAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = ((Float) (valueAnimator.getAnimatedValue())).floatValue();
                ivLogo.setAlpha(value);
                ivLogo.setTranslationY(ivLogo.getTranslationY() - 4);
            }
        });
        valueAnimator.start();
    }

}
