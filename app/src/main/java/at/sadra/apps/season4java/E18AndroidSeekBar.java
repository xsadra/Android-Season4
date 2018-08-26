package at.sadra.apps.season4java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class E18AndroidSeekBar extends AppCompatActivity {

    TextView seekBarAgeText;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e18_android_seek_bar);
        setTitle(getString(R.string.E18AndroidSeekBar));
        init();
    }

    private void init() {
        seekBarAgeText=findViewById(R.id.seekBarAgeText);

        seekBar = findViewById(R.id.seekBarAge);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarAgeText.setText(getText(R.string.seekBarAgeText) + ((Integer) i).toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
