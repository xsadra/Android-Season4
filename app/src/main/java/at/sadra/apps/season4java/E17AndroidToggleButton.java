package at.sadra.apps.season4java;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import app.App;

public class E17AndroidToggleButton extends AppCompatActivity {

    ToggleButton toggleButton;
TextView textViewToggle;
    ScrollView mainScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e17_android_toggle_button);
        setTitle(getString(R.string.E17AndroidToggleButton));
        init();
    }

    private void init() {
        mainScrollView=findViewById(R.id.mainScroll);
        textViewToggle = findViewById(R.id.textViewToggle);
        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    mainScrollView.setBackgroundColor(getColor(R.color.darkBackground));
                    textViewToggle.setTextColor(getColor(R.color.white));
                    App.toast(getString(R.string.nightModeActive));
                }else{
                    mainScrollView.setBackgroundColor(getColor(R.color.white));
                    textViewToggle.setTextColor(getColor(R.color.darkBackground));
                    App.toast(getString(R.string.nightModeDeactivate));
                }
            }
        });
    }
}
