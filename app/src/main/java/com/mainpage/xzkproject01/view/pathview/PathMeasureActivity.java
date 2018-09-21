package com.mainpage.xzkproject01.view.pathview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.mainpage.xzkproject01.R;

public class PathMeasureActivity extends AppCompatActivity {

    private PathMeasureView pathMeasureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_measure);

        pathMeasureView = findViewById(R.id.path_measure_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ValueAnimator animator = ValueAnimator.ofInt(1, 7200);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                pathMeasureView.setProgress(animatedValue);
            }
        });
        animator.setDuration(40*1000);
        animator.start();
    }
}
