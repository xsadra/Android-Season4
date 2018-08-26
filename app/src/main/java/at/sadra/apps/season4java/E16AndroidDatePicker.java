package at.sadra.apps.season4java;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.DatePicker;
import android.widget.TextView;

public class E16AndroidDatePicker extends AppCompatActivity {

    DatePicker datePicker;
    TextView selectDate;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e16_android_date_picker);
        setTitle(getString(R.string.E16AndroidDatePicker));
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void init() {
        datePicker = findViewById(R.id.datePicker);
        selectDate = findViewById(R.id.selectDate);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datePicker.getVisibility() == View.GONE) {
                    datePicker.setVisibility(View.VISIBLE);
                    datePicker.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left));
                }
            }
        });

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(final DatePicker datePicker, int i, int i1, int i2) {
                String year = ((Integer) i).toString();
                String month = ((Integer) i1).toString();
                String day = ((Integer) i2).toString();

                String dateSpacer = getString(R.string.dateSpacer);

                String date = day + dateSpacer + month + dateSpacer + year;

                selectDate.setText(date);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_out_right);
                datePicker.setAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        datePicker.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
}
