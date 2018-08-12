package at.sadra.apps.season4java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class E03AndroidUIControlsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e03_android_uicontrols);
        setTitle(getResources().getString(R.string.E03AndroidUIControlsActivity));

        Button myButton = ((Button) findViewById(R.id.button1));

        myButton.setText(R.string.newName);
        myButton.setTextColor(getResources().getColor(R.color.buttonColor));
    }


}
