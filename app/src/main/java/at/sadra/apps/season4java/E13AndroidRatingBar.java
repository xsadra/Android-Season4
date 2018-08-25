package at.sadra.apps.season4java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RatingBar;
import android.widget.TextView;

import app.App;

public class E13AndroidRatingBar extends AppCompatActivity {

    RatingBar ratingBar;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e13_android_rating_bar);
        setTitle(getString(R.string.E13AndroidRatingBar));
        init();
    }

    private void init() {

        ratingBar = findViewById(R.id.ratingBar);
        question = findViewById(R.id.question);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(final RatingBar ratingBar, float v, boolean b) {
                App.toast(getString(R.string.rateMessage).replace("%s", ((Float) v).toString()));

                Animation animation = AnimationUtils.loadAnimation(E13AndroidRatingBar.this, android.R.anim.slide_out_right);
                ratingBar.startAnimation(animation);
                question.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ratingBar.setVisibility(View.GONE);
                        question.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

    }
}
