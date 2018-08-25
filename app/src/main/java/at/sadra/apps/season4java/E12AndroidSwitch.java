package at.sadra.apps.season4java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class E12AndroidSwitch extends AppCompatActivity implements View.OnClickListener{

    Switch onOff, nightMode, backgroundWorking;
    Button submit;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e12_android_switch);
        setTitle(getString(R.string.E12AndroidSwitch));
        init();
    }

    private void init() {
        onOff = findViewById(R.id.onOff);
        nightMode = findViewById(R.id.nightMode);
        backgroundWorking = findViewById(R.id.backgroundWorking);

        result = findViewById(R.id.result);

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        result.setText("");
        String newLine = getString(R.string.newLine);

        result.append(getString(R.string.onOff) + getString(R.string.spacer));
        if (onOff.isChecked()) {
            result.append(getString(R.string.isOn));
        }else {
            result.append(getString(R.string.isOff));
        }
        result.append(newLine);

        result.append(getString(R.string.textSwitchNight) + getString(R.string.spacer));
        if (nightMode.isChecked()) {
            result.append(getString(R.string.isOn));
        }else {
            result.append(getString(R.string.isOff));
        }
        result.append(newLine);

        result.append(getString(R.string.backgroundWorking) + getString(R.string.spacer));
        if (backgroundWorking.isChecked()) {
            result.append(getString(R.string.isOn));
        }else {
            result.append(getString(R.string.isOff));
        }
        result.append(newLine);

        result.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
    }
}
