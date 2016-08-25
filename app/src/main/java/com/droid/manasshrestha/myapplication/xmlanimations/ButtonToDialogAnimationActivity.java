package com.droid.manasshrestha.myapplication.xmlanimations;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.droid.manasshrestha.myapplication.R;

/**
 * using value animator to animated a text field to a dialog view
 * Value animator iterates through the provided values
 */
public class ButtonToDialogAnimationActivity extends AppCompatActivity {

    private static final float ALPHA_DECREMENT = 0.04f;
    private static final float TRANSLATION_VALUE = 6;

    TextView textView;
    RelativeLayout relativeLayout;
    ValueAnimator valueAnimator;
    FrameLayout flParent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_animation);

        textView = (TextView) findViewById(R.id.tv_push_button);
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_container);
        flParent = (FrameLayout) findViewById(R.id.fl_parent);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                wr want the values to go from the with of the relative layout container to
                the width of the parent along with the margin the relative layout accounted for
                 */
                valueAnimator = ValueAnimator.ofFloat(relativeLayout.getWidth(), flParent.getWidth() - relativeLayout.getLeft() * 2);
                valueAnimator.setDuration(1000);

                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float value = ((Float) (valueAnimator.getAnimatedValue())).floatValue();

                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) value, relativeLayout.getHeight() + 10);
                        layoutParams.setMargins(relativeLayout.getLeft(), relativeLayout.getTop(), relativeLayout.getLeft(), relativeLayout.getTop());
                        relativeLayout.setLayoutParams(layoutParams);
                        textView.setAlpha(textView.getAlpha() - ALPHA_DECREMENT);

                        relativeLayout.setTranslationY(relativeLayout.getTranslationY() + TRANSLATION_VALUE);
                    }
                });

                valueAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        //animation start
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        startTextAnimation();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {
                        //animation cancel
                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {
                        //animation repeat
                    }
                });

                valueAnimator.start();
            }
        });


    }

    /**
     * animate alpha for text view
     */
    private void startTextAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(200);
        textView.setText("Lorem ipsum dolor sit amet, est eu simul ornatus, vix an delenit probatus. Eam legimus phaedrum eu. Nulla ceteros duo an, eam te illum scaevola tacimates, ius esse delectus sapientem ea.\n\nEa choro impedit splendide ius, pro saepe vocent consulatu ex, ex alii adversarium mei. Prima clita offendit et sit.");
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = ((Float) (valueAnimator.getAnimatedValue())).floatValue();
                textView.setAlpha(value);
            }
        });

        valueAnimator.start();
    }
}
