package at.sadra.apps.season4java;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class E27AndroidSplashScreen extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e27_android_splash_screen);

        logo = findViewById(R.id.logo);

        logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(E27AndroidSplashScreen.this,E27AndroidListView.class));
                finish();
            }
        },3000);
    }
}
