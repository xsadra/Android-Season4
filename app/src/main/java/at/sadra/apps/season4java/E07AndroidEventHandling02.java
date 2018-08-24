package at.sadra.apps.season4java;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import app.App;

public class E07AndroidEventHandling02 extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout parent;
    LinearLayout buttonsParent;
    Button startButton;
    Button toggleColorButton;
    Button finishButton;
    FloatingActionButton toggleVisibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e07_02_android_event_handling);
        setTitle(getString(R.string.E07AndroidEventHandling02));

        parent = findViewById(R.id.parent);
        buttonsParent = findViewById(R.id.buttonsParent);

        startButton = findViewById(R.id.startButton);
        toggleColorButton = findViewById(R.id.toggleColorButton);
        finishButton = findViewById(R.id.finishButton);

        toggleVisibility = (FloatingActionButton) findViewById(R.id.toggleVisibility);

//        startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                App.toast("Start Button!");
//                App.log("Start Button!");
//            }
//        });
//
//        finishButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                App.toast("Finish Button!");
//                App.log("Finish Button!");
//            }
//        });

        startButton.setOnClickListener(this);
        finishButton.setOnClickListener(this);
        toggleColorButton.setOnClickListener(this);
        toggleVisibility.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.startButton:
                App.toast("--First Button Clicked--");
                App.toast("Start new Activity!");
                startActivity(new Intent(E07AndroidEventHandling02.this, E06AndroidButtonActivity.class));
                break;
            case R.id.finishButton:
                App.toast("--Finish Button:D --");
                finish();
                break;
            case R.id.toggleColorButton:
                App.toast("--Toggle Color Button Clicked--");

                int color = getColor(parent);
                toggleColor(color, R.color.alphaColor, R.color.colorPrimary);

                break;
            case R.id.toggleVisibility:
                App.toast("--Toggle Visibility Button Clicked--");
                App.log("## Toggle Start");
                if (buttonsParent.getVisibility() == View.VISIBLE) {
//                    buttonsParent.setVisibility(View.GONE);
                    Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
                    buttonsParent.setAnimation(animation);
                    App.log("## Animation Set");

                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            App.log("## Animation Start");

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            buttonsParent.setVisibility(View.GONE);
                            App.log("## Animation Finish");

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });


                } else {
                    buttonsParent.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
                    buttonsParent.setAnimation(animation);
                }

//                buttonsParent.setVisibility((buttonsParent.getVisibility() == View.VISIBLE)?View.GONE:View.VISIBLE);

                break;
            default:
                App.toast("--No Button Clicked--");
        }

    }

    private void toggleColor(int BaseColor, int firstColor, int secondColor) {
        if (BaseColor == readColor(firstColor)) {
            setColor(parent, secondColor);
        } else {
            setColor(parent, firstColor);
        }
    }

    private int readColor(int color) {
        return getResources().getColor(color);
    }

    private int getColor(View item) {
        return ((ColorDrawable) item.getBackground()).getColor();
    }

    private void setColor(View parent, int color) {
        parent.setBackgroundColor(getResources().getColor(color));
    }
}
