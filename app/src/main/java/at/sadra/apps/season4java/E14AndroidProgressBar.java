package at.sadra.apps.season4java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class E14AndroidProgressBar extends AppCompatActivity implements View.OnClickListener {

    TextView circleProgressBarTitle, horizontalProgressBarTitle;
    ProgressBar circleProgressBar, horizontalProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e14_android_progress_bar);
        setTitle(getString(R.string.E14AndroidProgressBar));
        init();
    }

    private void init() {
        circleProgressBar = findViewById(R.id.circleProgressBar);

        circleProgressBarTitle = findViewById(R.id.circleProgressBarTitle);
        circleProgressBarTitle.setOnClickListener(this);

        horizontalProgressBar = findViewById(R.id.horizontalProgressBar);

        horizontalProgressBar.setMax(100);

        horizontalProgressBarTitle = findViewById(R.id.horizontalProgressBarTitle);
        horizontalProgressBarTitle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.circleProgressBarTitle:
                if (circleProgressBar.getVisibility() == View.GONE) {
                    circleProgressBar.setVisibility(View.VISIBLE);
                } else {
                    circleProgressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.horizontalProgressBarTitle:

                if (horizontalProgressBar.getProgress()>=99) {
                    horizontalProgressBar.setProgress(0);
                    progressBarTester();
                } else {
                    progressBarTester();
                }
                break;
        }
    }

    private void progressBarTester() {
        horizontalProgressBarTitle.setText(getString(R.string.horizontalProgressBarTitle) + " (" + horizontalProgressBar.getProgress() + "%)");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (horizontalProgressBar.getProgress()<100) {
                                horizontalProgressBar.setProgress(horizontalProgressBar.getProgress() + 1);
                                progressBarTester();
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
