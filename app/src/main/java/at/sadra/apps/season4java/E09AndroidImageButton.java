package at.sadra.apps.season4java;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import app.App;

public class E09AndroidImageButton extends AppCompatActivity {


    ImageButton logOff;
    Boolean flag = false;

    Button cameraFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e09_android_image_button);
        setTitle(getString(R.string.E09AndroidImageButton));


        logOff = findViewById(R.id.imageButtonLogOff);

        logOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag) {
                    logOff.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                } else {
                    logOff.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }
                flag = !flag;
            }
        });

        cameraFlash = findViewById(R.id.buttonCamera);

        cameraFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.toast(getString(R.string.takePhoto));
            }
        });

    }
}
