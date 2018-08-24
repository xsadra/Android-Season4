package at.sadra.apps.season4java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import app.App;

public class E11AndroidRadioButton extends AppCompatActivity implements View.OnClickListener{

    RadioGroup radioSex;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e11_android_radio_button);
        setTitle(getString(R.string.E11AndroidRadioButton));

        init();
    }

    private void init() {
        radioSex = findViewById(R.id.radioSex);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int sexCheckedRadioButtonId = radioSex.getCheckedRadioButtonId();

        switch (sexCheckedRadioButtonId){
            case R.id.male:
                App.toast(getString(R.string.sexMaleMessage));
                break;
            case R.id.female:
                App.toast(getString(R.string.sexFemaleMessage));

                break;
            case R.id.other:
                App.toast(getString(R.string.sexOtherMessage));

                break;
            default:
                App.toast(getString(R.string.sexNoChoseMessage));

        }
    }
}
