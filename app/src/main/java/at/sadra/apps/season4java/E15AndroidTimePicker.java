package at.sadra.apps.season4java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.TimePicker;

import app.App;

public class E15AndroidTimePicker extends AppCompatActivity implements View.OnClickListener, TimePicker.OnTimeChangedListener {

    TextView timeText, confirmTimeText;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e15_android_time_picker);
        setTitle(getString(R.string.E15AndroidTimePicker));
        init();
    }

    private void init() {
        timeText = findViewById(R.id.timeText);
        timePicker = findViewById(R.id.timePicker);

        confirmTimeText = findViewById(R.id.confirmTimeText);

        timeText.setOnClickListener(this);
        timePicker.setOnTimeChangedListener(this);
        confirmTimeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        App.log("Out 0");
        if (view == timeText) {
            if (timePicker.getVisibility() == View.GONE) {
                Animation animation = AnimationUtils.loadAnimation(E15AndroidTimePicker.this, android.R.anim.slide_in_left);
                timePicker.setVisibility(View.VISIBLE);
                timePicker.setAnimation(animation);
            }
        } else if (view == confirmTimeText) {
            String time = timePicker.getCurrentHour() + getString(R.string.timeSpacer) + timePicker.getCurrentMinute();
            timeText.setText(time);
            Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
            timePicker.startAnimation(animation);
            confirmTimeText.startAnimation(animation);
            App.log("Out 1");
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    timePicker.setVisibility(View.GONE);
                    confirmTimeText.setVisibility(View.GONE);
                    App.log("Out 2");
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }

    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
        if (confirmTimeText.getVisibility() == View.GONE) {
            Animation animation = AnimationUtils.loadAnimation(E15AndroidTimePicker.this, android.R.anim.slide_in_left);
            confirmTimeText.setVisibility(View.VISIBLE);
            confirmTimeText.setAnimation(animation);
        }
        String time = timePicker.getCurrentHour() + getString(R.string.timeSpacer) + timePicker.getCurrentMinute();
        confirmTimeText.setText(getString(R.string.timeConfirm).replace("%s", time));
    }
}
